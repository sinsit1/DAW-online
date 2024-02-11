"use strict";

const MIN = 0;
const MAX = 100;

// inicializo los intentos a 0
let attemps = 0;
// variable donde guardo lo introducido por el usuario
let userNum;


// checkea si un tipo string contiene un numero con una expresion regular
function checkIfStringIsNumber(string) {
    return /^[0-9]*$/.test(string);
}

function checkUserNumber(userNumber) {
    // este bloque comprueba como de lejos está el numero introducido del numero a adivinar y saca su mensaje correspondiente por consola
    let subtraction = MAGIC_NUMBER - userNumber;

    if(subtraction === 0){
        console.log(`Felicidades! Has adivinado el número! Y sólo has necesitado ${attemps} intentos!`)
    } else if (subtraction <= 5 && subtraction >= -5) {
        console.log('¡Por qué poco!')
    } else if (subtraction <= 15 && subtraction >= -15) {
        console.log('Estas cerca de adivinar el número')
    } else if (subtraction <= 30 && subtraction >= -30) {
        console.log('Uffff…. no estas nada cerca de ganar.')
    } else {
        console.log('Mejor dedicate a otra cosa')
    }
}

function checkNumberValidity(userNumber) {
    // EN ESTE PRIMER BLOQUE RECOGEMOS NUMERO Y CHECKEAMOS QUE SEA UN NUMERO, Y QUE ESTÉ DENTRO DEL RANGO DADO

    //Compruebo si el string añadido por el usuario es un numero a través de una regex, si es número, lo paso a tipo number. Sino castedNumer queda a null
    let castedNumber = checkIfStringIsNumber(userNum) ? parseInt(userNum) : null;

    if (!castedNumber) { // si no hay casted number, significa que lo introducido NO era un numero y muestro su mensaje
        console.error('El valor introducido no es un numero');
    } else if (castedNumber < MIN || castedNumber > MAX) { // compruebo que esté dentro del rango definido
        console.error(`El número introducido no está entre el ${MIN} y el ${MAX}`);
    }

    return castedNumber;
}

do {
    // recojo lo introducido por el usuario
    userNum = prompt(`Ingrese un número (llevas ${attemps} intentos):`);
    // si el usuario introduce salir acaba el juego
    if(userNum === 'SALIR' || userNum === 'salir') {
        console.log('Qué pena que te vayas ya. Vuelve pronto!')
        break;
    }

    // checkea si es un numero valido. Si lo es, lo retorna con tipo number, sino devuelve un null
    let validatedNumber = checkNumberValidity(userNum);

    // si era un numero correcto, entonces suma 1 a los intentos, y saca por pantalla el texto segun lo lejos que está de adivinarlo
    if (validatedNumber && validatedNumber >= MIN && validatedNumber <= MAX) {
        ++attemps;
        checkUserNumber(validatedNumber)
    }

    // Solo salimos del bucle si acertamos el numero
} while (MAGIC_NUMBER !== parseInt(userNum));


