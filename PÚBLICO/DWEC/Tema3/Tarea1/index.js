const regexOnlyLetters = /^[a-zA-Z]+$/;
const date_regex = /^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2}$/;
const email_regex = /[A-Za-z0-9_.-]*@+(educacion.navarra|navarra)\.+(com|es)$/;
const mobile_regex = /^((6))[0-9]{8}$/; //regex movil que empieza por 6, 9 numeros
const tfn_regex = /^((948|848))[0-9]{6}$/; //regex fijo foral
const currentYear = new Date().getFullYear();
const inputs = ['nombre', 'apellido', 'fecha', 'email', 'edad', 'telefono', 'asunto', 'mensaje'];
const mandatoryFields = ['nombre', 'apellido', 'fecha', 'email', 'asunto', 'mensaje'];
const sendButton = document.getElementById('enviar');
let form = document.getElementsByTagName("form")[0];

const errors = {};
// añado evento focus y blur a todos los inputs
for (let index = 0; index < inputs.length; index++) {
    const input = document.getElementById(inputs[index]);
    input.addEventListener("focus", () => addClass(input));
    input.addEventListener("blur", () => removeClass(input));
    // genero un objeto con clave nombre de campo, y valor booleano, para saber si tiene error o no
    errors[inputs[index]] = null;
}

function capitalizeFirstLetterOfEveryWord(string) {
    return string.replace(/\b\w/g, (c) => c.toUpperCase());
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function addClass(input) {
    input.classList.add("enfocado");
}

function removeClass(input) {
    input.classList.remove("enfocado");
}

function addValidationClasses(input, isValid) {
    !isValid
        ? input.classList.add("incorrecto")
        : input.classList.remove("incorrecto");
}

function validateName(event, input) {
    const isValid = regexOnlyLetters.test(event.target.value);
    addValidationClasses(input, isValid);
    nameInput.value = capitalizeFirstLetter(event.target.value);
    errors.nombre = !isValid;
    updateErrors(errors);
}

function validateLastname(event, input) {
    const isValid = regexOnlyLetters.test(event.target.value);
    addValidationClasses(input, isValid);
    lastnameInput.value = event.target.value.replace(/\b\w/g, (c) => c.toUpperCase());
    errors.apellido = !isValid;
    updateErrors(errors);
}

function validateDate(event, input) {
    const isValid = date_regex.test(dateInput.value);
    const ageInput = document.getElementById('edad');
    addValidationClasses(input, isValid);
    if (isValid) {
        ageYear = input.value.split('/')[2];
        ageInput.value = currentYear - parseInt(ageYear);
    } else {
        ageInput.value = 'El campo no se ha podido calcular'
    }
    errors.fecha = !isValid;
    errors.edad = !isValid;
    updateErrors(errors);
}

function validateEmail(event, input) {
    const isValid = email_regex.test(input.value);
    addValidationClasses(input, isValid);
    errors.email = !isValid;
    updateErrors(errors);
}

function validatePhone(event, input) {
    const isValid = mobile_regex.test(input.value) || tfn_regex.test(input.value);
    addValidationClasses(input, isValid);
    errors.telefono = !isValid;
    updateErrors(errors);
}

function validateSubject(event, input) {
    const isValid = regexOnlyLetters.test(input.value);
    addValidationClasses(input, isValid);
    errors.asunto = !isValid;
    updateErrors(errors);
}

function validateMessage(event, input) {
    const maxLength = 200;
    const isValid = messageInput.value.length <= maxLength;
    if (!isValid) {
        messageInput.value = messageInput.value.slice(0, maxLength);
    }
    addValidationClasses(input, isValid);
    errors.mensaje = !isValid;
    updateErrors(errors);
}

// valida si el formulario esta correctamentre rellenado para habilitar el boton de enviar
function checkFormValidity() {
    let formHasErrors = !Object.values(errors).some(el => el === true) && !Object.values(errors).some(el => el === null)
    sendButton.disabled = !formHasErrors;
}

function updateErrors() {
    checkFormValidity();

    const errorsContainer = document.getElementById('errores');
    errorsContainer.innerHTML = ''; // resetea el div del DOM
    const text = document.createElement('span');
    const text2 = document.createElement('span');
    const jump = document.createElement('br');

    const fieldsWithErrors = [];

    for (let index = 0; index < inputs.length; index++) {
        if (errors[inputs[index]]) {
            fieldsWithErrors.push(inputs[index])
        }
    }

    text.textContent = `Total errores: ${fieldsWithErrors.length}`;
    text2.textContent = `Hay errores en los campos: ${fieldsWithErrors.toString()}`;

    if (fieldsWithErrors.length) {
        errorsContainer.appendChild(text);
        errorsContainer.appendChild(jump);
        errorsContainer.appendChild(text2);
    }
}

function reset() {
    for (let index = 0; index < inputs.length; index++) {
        const input = document.getElementById(inputs[index]);
        input.value = '';
        errors[inputs[index]] = null;
        addValidationClasses(input, true);
    }
}

const resetButton = document.getElementById('limpiar');
resetButton.addEventListener("click", () => reset());

// Añado los eventos de sus validadores personalizados
const nameInput = document.getElementById('nombre');
nameInput.addEventListener("keyup", (e) => validateName(e, nameInput));

const lastnameInput = document.getElementById('apellido');
lastnameInput.addEventListener("keyup", (e) => validateLastname(e, lastnameInput));

const dateInput = document.getElementById('fecha');
dateInput.addEventListener("keyup", (e) => validateDate(e, dateInput));
dateInput.placeholder = "DD/MM/YYYY";

const emailInput = document.getElementById('email');
emailInput.addEventListener("keyup", (e) => validateEmail(e, emailInput));

const tfnInput = document.getElementById('telefono');
tfnInput.addEventListener("keyup", (e) => validatePhone(e, tfnInput));

const subjectInput = document.getElementById('asunto');
subjectInput.addEventListener("keyup", (e) => validateSubject(e, subjectInput));
subjectInput.setAttribute('maxLength', 50);

const messageInput = document.getElementById('mensaje');
messageInput.addEventListener("keyup", (e) => validateMessage(e, messageInput));

form.addEventListener("submit", (e) => {
    e.preventDefault();

    const data = {};

    for (let index = 0; index < inputs.length; index++) {
        const input = document.getElementById(inputs[index]);
        data[inputs[index]] = input.value
    }

    console.log('Datos de usuario', data);
    alert(JSON.stringify(data));
});