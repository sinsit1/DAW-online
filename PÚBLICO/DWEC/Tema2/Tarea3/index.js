const videoclub = {
    numeroPeliculas: 0,
    peliculas: [],
    agregarPelicula: (pelicula)=>videoclub.peliculas.push(pelicula),
    borrarPelicula: ()=> borrarPelicula(), 
};

function esNumerico(value) {
    return /^-?\d+$/.test(value);
}

function agregarPelicula(){
    const selectorDirector = document.querySelector("#director").value;
    const director = selectorDirector.includes(',') ? selectorDirector.split(',') : selectorDirector;
    const selectorCasting = document.querySelector("#casting").value;
    const casting = selectorCasting.includes(',') ? selectorCasting.split(',') : selectorCasting;
    const pelicula = {
        titulo: document.querySelector("#titulo").value,
        año: esNumerico(document.querySelector("#año").value) ? parseInt(document.querySelector("#año").value) : document.querySelector("#año").value,
        director: director,
        casting: casting,
    };

    if(!comprobarSiExiste(pelicula)){
        console.log('Pelicula: ', pelicula);
        videoclub.agregarPelicula(pelicula);
        videoclub.numeroPeliculas = videoclub.peliculas.length;
    } else {
        alert(`La película ${pelicula.titulo} ya existe en el videoclub`);
    }

    console.log('Videoclub: ', videoclub);
}

function borrarPelicula(){
    const tituloPelicula = window.prompt('Introduce el título a borrar: ');
    const indiceABorrar = videoclub.peliculas.findIndex(el => el.titulo === tituloPelicula);
    if(indiceABorrar === -1) return alert('La pelicula que quieres borrar no existe en el videoclub');
    console.log(videoclub.peliculas[indiceABorrar]);
    videoclub.peliculas.splice(indiceABorrar, 1);
    videoclub.numeroPeliculas = videoclub.peliculas.length,
    alert(`La película ${tituloPelicula} se ha borrado del videoclub`);
    console.log('Videoclub: ', videoclub);
}

function contarPeliculas(){
    alert(`En el videoclub hay ${videoclub.numeroPeliculas} ${videoclub.numeroPeliculas === 1 ? 'película' :'películas'}`);
}

function comprobarSiExiste(pelicula){
    return videoclub.peliculas.some(el => el.titulo === pelicula.titulo);
}

function mostrarPeliculas(){
    if(videoclub.peliculas.length === 0) return alert('No hay películas en el videoclub');
    document.getElementById('datos').innerHTML = '';
    crearTablaPeliculas(videoclub.peliculas);
}

function crearTablaPeliculas(objectArray) {
    let body = document.getElementById('datos');
    body.style.paddingTop = '30px';
    let tbl = document.createElement('table');
    tbl.style.width = '80%';
    tbl.style.margin = '0 auto';
    let thead = document.createElement('thead');
    let thr = document.createElement('tr');
    
    for (p in objectArray[0]){
      let th = document.createElement('th');
      th.appendChild(document.createTextNode(p.toUpperCase()));
      thr.appendChild(th);
      th.setAttribute("style","border: 2px solid black");
    }
   
    thead.appendChild(thr);
    tbl.appendChild(thead);

    let tbdy = document.createElement('tbody');
    let tr = document.createElement('tr');
    objectArray.forEach((object) => {
      let n = 0;
      let tr = document.createElement('tr');
      for (p in objectArray[0]){
        var td = document.createElement('td');
        td.style.padding = '0 10px';
        td.style.border = '1px solid black';
        td.appendChild(document.createTextNode(object[p]));
        tr.appendChild(td);
        n++;
      };
      tbdy.appendChild(tr);    
    });
    tbl.appendChild(tbdy);
    body.appendChild(tbl)
    return tbl;
};