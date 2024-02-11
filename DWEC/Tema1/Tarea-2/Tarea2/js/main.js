"use strict";

const MIN = 1;
const MAX = 50;

// checkea si un tipo string contiene un numero
function checkIfStringIsNumber(string) {
    return /^[0-9]*$/.test(string);
}

// EN ESTE PRIMER BLOQUE RECOGEMOS NUMERO Y CHECKEAMOS QUE SEA UN NUMERO, Y QUE ESTÉ DENTRO DEL RANGO DADO

// recoge numero del usuario, pero recoge un string
let addedNumber = prompt('Introduce un número: ', []);

//Compruebo si el string añadido por el usuario es un numero a través de una regex, si es número, lo paso a tipo number. Sino castedNumer queda a null
let castedNumber = checkIfStringIsNumber(addedNumber) ? parseInt(addedNumber) : null;

if (!castedNumber) { // si no hay casted number, significa que lo introducido NO era un numero y muestro su mensaje
    console.error('El valor introducido no es un numero');
} else if (castedNumber < MIN || castedNumber > MAX) { // compruebo que esté dentro dle rango definido
    console.error('El número introducido no está entre el 1 y el 50');
}



// EN ESTE SEGUNDO BLOQUE SACAMOS POR CONSOLA LA PRIMERA TABLA Y PREGUNTAMOS SI QUIERE VER LAS SIGUIENTE. APARTE SE COMPRUEBA QUE EL RESULTADO SEA VÁLIDO


// si hay un numero válido ( ya tipo number) y no es null, empiezo con las tablas
if (castedNumber) {

    let notAValidResult= 'Resultado no válido';
    //empiezo con la tabla de sumar
    console.log(`Tabla de sumar del ${castedNumber}`);
    for (let index = 0; index < 10; index++) {
        let result = castedNumber + index;
        console.log(`${castedNumber} + ${index} = ${(typeof result === 'number') ? result : notAValidResult}`);
    }
    // pregunto si quiere continuar con el resto de tablas
    let wantContinue = confirm('Quieres seguir con las tablas? La siguiente es la de restar');

    // si el usuario acepta (true), continuo con la siguiente tabla y vuelvo a preguntar
    if (wantContinue) {
        console.log(`Tabla de restar del ${castedNumber}`);
        for (let index = 0; index < 10; index++) {
            let result = castedNumber - index;
            console.log(`${castedNumber} - ${index} = ${(typeof result === 'number') ? result : notAValidResult}`);
        }
        wantContinue = confirm('Quieres seguir con las tablas? La siguiente es la de multiplicar');
    }

    // si el usuario acepta (true), continuo con la siguiente tabla y vuelvo a preguntar
    if (wantContinue) {
        console.log(`Tabla de multiplicar del ${castedNumber}`);
        for (let index = 0; index < 10; index++) {
            let result = castedNumber * index;
            console.log(`${castedNumber} * ${index} =  ${(typeof result === 'number') ? result : notAValidResult}`);
        }
        wantContinue = confirm('Quieres seguir con las tablas? La siguiente es la de dividir');
    }

    // si el usuario acepta (true), continuo con la ultima tabla
    if (wantContinue) {
        console.log(`Tabla de dividir del ${castedNumber}`);
        for (let index = 0; index < 10; index++) {
            let result = castedNumber / index;
            // cualquier numero dividido por 0 da infinito. En JS el tipo Infinity es type number, asi que necesitamos otra comprobación más
            console.log(`${castedNumber} / ${index} =  ${(typeof result === 'number') && isFinite(result) ? result : notAValidResult}`);
        }
    }
}

