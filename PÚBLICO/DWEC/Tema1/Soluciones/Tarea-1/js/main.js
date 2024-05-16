 
"use strict";

// recoge nombre, apellidos y edad
let username = prompt('Introduce tu nombre: ', []);
let userLastname = prompt(`Perfecto, ${username}, ahora introduce tus apellidos`, []);
let userAge = prompt('Vale, solo falta la edad', []);
// defino los años que tengo que sumar a la edad, este dato es constante

const YEARS_TO_ADD = 5;


console.debug('Nombre: ', username);
console.debug('Apellidos: ', userLastname);
console.debug('Edad falsa: ', userAge);