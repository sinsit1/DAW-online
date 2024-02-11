let usuario = {};
let errores = [];
let arrayNumerosRandom = [];

function esNumerico(value) {
    return /^-?\d+$/.test(value);
}

function saludar() {
    alert(`Hola ${usuario.nombre} ${usuario.apellido} \n Edad: ${usuario.edad}, \n Altura: ${usuario.altura}, \n Peso: ${usuario.peso}, \n Url: ${usuario.url}, \n Aficiones: ${usuario.aficiones.toString()}`)
}

function abrirUrl() {
    const confirm = window.confirm("¿Quieres abrir la url personal?");
    if(confirm) window.open(usuario.url);
}

function crearUsuario(){
    //no borrar esta línea, hace que aparezcan los botones necesarios para el ejercicio
    let botonesUsuario = document.getElementById("botonesUs1,59uario")
    botonesUsuario.classList.remove("oculto")

    // cojo la fecha del input
    const fecha = document.querySelector("[name='fecha']").value;
    // separo la fecha por /, me genera un array, y cojo solo el año para poder calcular la edad.
    const anno = fecha.split('/')[2];
    if(anno) {
        usuario.edad = new Date().getFullYear() - parseInt(anno);
    }

    // recojo altura del input, si no la hay, genero error.
    const altura = document.querySelector("[name='altura']").value;
    if(!altura) {
        errores.push('altura');
    } else {
        // si se introduce correctamente eliminar el error de array de errores
        usuario.altura = parseFloat(altura);
        const index = errores.findIndex(el=> el === 'altura');
        if(index !== -1) errores.splice(index, 1);
    }

    // recojo peso del input, si no la hay, genero error.
    const peso = document.querySelector("[name='peso']").value;
    if(!peso) {
        errores.push('peso');
    } else if(esNumerico(peso)) {
        // si se introduce correctamente eliminar el error de array de errores
        usuario.peso = parseFloat(peso);
        const index = errores.findIndex(el=> el === 'peso');
        if(index !== -1) errores.splice(index, 1);
    }
    
    usuario.nombre = document.querySelector("[name='nombre']").value;
    usuario.apellido = document.querySelector("[name='apellido']").value;
    usuario.edad = new Date().getFullYear() - parseInt(anno);
    usuario.aficiones = document.querySelector("[name='aficiones']").value.split(',');
    usuario.url = document.querySelector("[name='url']").value;

    console.log('Usuario: ',usuario)
}

function mostrarEstadisticas () {
    // calculo IMC
    const IMC = usuario.peso/(usuario.altura*usuario.altura);
    const cadena = usuario.nombre + usuario.apellido;
    const numeroVocales = cadena.match(/[aáeéiíoóuú]/gi).length;
    const numeroConsonantes = cadena.match(/[b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,v,w,x,y,z]/gi).length;

    document.getElementById("form1").innerHTML = `IMC: ${!!IMC ? IMC : 'Error en los datos introducidos'}, Vocales: ${numeroVocales} , Consonantes: ${numeroConsonantes}`;
}

function numerosAleatoriosEnRango(min, max){
    return Math.abs(Math.floor(Math.random() * (max - min + 1) + min));
}

function generarArray(){
    //no borrar esta línea, hace que aparezcan los botones necesarios para el ejercicio
    let botonesArray = document.getElementById("botonesArray");
    botonesArray.classList.remove("oculto");

    arrayNumerosRandom = [];

    const longitud = document.querySelector("[name='dia']").value;
    const desde = document.querySelector("[name='mes']").value;
    const hasta = document.querySelector("[name='año']").value;

    // genero array de numeros aleatorios dentro del rango dado
    for (let index = 0; index < longitud; index++) {
       arrayNumerosRandom.push(numerosAleatoriosEnRango(desde, hasta));
    }
    document.getElementById("form2").innerHTML = `[ ${arrayNumerosRandom} ]`;
}   

function separarParesImpares() {
    const pares = [];
    const impares = [];

    // separo pares e impares
    for (let index = 0; index < arrayNumerosRandom.length; index++) {
        const element = arrayNumerosRandom[index];
        if(element%2==0) {
            pares.push(element);
        } else {
            impares.push(element);
        }
    }
    document.getElementById("form2").innerHTML = `Original: [ ${arrayNumerosRandom} ], Pares: [ ${pares.toString()}], Impares: [${impares.toString()}]`;
}


function quitarDuplicados() {
    const dataArr = new Set(arrayNumerosRandom);
    // elimino duplicados
    let arrayConUnicos = [...dataArr];
    document.getElementById("form2").innerHTML = `Original: [ ${arrayNumerosRandom} ], Sin duplicados: [ ${arrayConUnicos.toString()} ]`;
}
