
// debereis utilizar esta variable para generar el código aleatoriamente
const hex = "0123456789ABCDEF";

const objectColor = {
    color: '#f1f5f8',
    generarColorAleatorio: () => {
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += hex[Math.floor(Math.random() * 16)];
        }
        objectColor.color = color;
        return color;
    }
};

// inicializa la app al color por defecto
cambiarHTML(objectColor.color);

function cambiarColor() {
    // genera color hexa aleatorio
    const nuevoColor = objectColor.generarColorAleatorio();
    // hace los cambios en el html
    cambiarHTML(nuevoColor);
}

// funcion que recibe color por parámetro y lo aplica al documento
function cambiarHTML(color) {
    // selecciona elemento del dom
    const codigoColor = document.querySelector('.color');
    // cambia el string del elemento
    codigoColor.innerHTML = color;
    // cambia el color de letra del elemento
    codigoColor.style.color = color;

    // selecciona el elemento main del DOM
    const main = document.querySelector('main');
    // cambia su color de fondo por el color random
    main.style.background = color;
}



