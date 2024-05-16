
const API_BASE_URL = 'https://rickandmortyapi.com/api/character';
const MIN_NUM = 1;
const MAX_NUM = 20;
const COOKIE_DURATION = 5; // en min.
let randomCharacter = null;

// diccionario de colores para el estado
const statusColors = {
    unknown: 'orangepoint',
    Dead: 'redpoint',
    Alive: 'greenpoint',
}

// recoje el contenido de la cookie
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

// recupera la cookie, y si la hay pinta el personaje
document.addEventListener('DOMContentLoaded', function () {
    const cookie = getCookie('character');
    if (cookie) setCharacter(JSON.parse(cookie));
}, false);

document.getElementsByClassName('random-btn')[0].addEventListener('click', getCharacter);

// helper, saca ints random entre un min y max, incluidos
function randomIntFromInterval(min, max) { // min and max included 
    return Math.floor(Math.random() * (max - min + 1) + min)
}

// pide a la API el personaje. Si le pasas ID, pide ese, sino pide un id random entre MIN y MAX. Hace un catch del error si lo hubiese y saca por la consola
async function getCharacter(characterId) {
    try {
        const response = await axios.get(`${API_BASE_URL}/${!!parseInt(characterId) ? characterId : randomIntFromInterval(MIN_NUM, MAX_NUM)}`);
        setCharacter(response.data);
    } catch (error) {
        console.error(error);
    }
}

// recibe un personaje, genera el html, y lo inserta en el DOM.
function setCharacter(character) {
    randomCharacter = character;
    const article = `
        <article class="personaje">
        <div class="img-container">
        <img src="${character.image}" id="person-img" alt="${character.name}" />
        </div>
        <h4 id="nombre">${character.name}</h4>
        <p id="raza">${character.species}</p>
        <span class="${statusColors[character.status]}"></span>
        <p id="info">
        Este personaje ha aparecido en <b>${character.episode.length}</b> capitulo${character.episode.length > 1 ? 's' : ''} de la serie.<br>
        La última vez fue visto en <b>${character.location.name}</b>
        </p>
        <div class="button-container">
        <button class="prev-btn" onClick=previousCharacter()>
            <i class="fas fa-chevron-left"></i>
        </button>
        <button class="next-btn" onClick=nextCharacter()>
            <i class="fas fa-chevron-right"></i>
        </button>
        </div>
        <div>
        <button class="random-btn" onClick=getCharacter()>personaje aleatorio</button>
        </div>
        <div>
        <button id="fav" class="random-btn" onClick=saveCharacter()>guardar favorito</button>
        </div>
        </article>
        `;
    const element = document.getElementsByClassName("personaje");
    element[0].remove();
    const container = document.getElementsByClassName("container");
    container[0].insertAdjacentHTML('beforeend', article);
}

// calcula cual es el ID del siguiente personaje y lo pide a la API. Si es mayor de 20, pide el primero
function nextCharacter() {
    const nextCharacterId = randomCharacter.id === 20 ? 1 : randomCharacter.id + 1;
    getCharacter(nextCharacterId);
}

// calcula cual es el ID del siguiente anterior y lo pide a la API. Si es menor de 1, pide el ultimo.
function previousCharacter() {
    const nextCharacterId = randomCharacter.id === 1 ? 20 : randomCharacter.id - 1;
    getCharacter(nextCharacterId);
}

// guarda el personaje en una cookie con 5 minutos de duración. Y saca un alert de confirmacion.
function saveCharacter() {
    const date = new Date();
    date.setTime(date.getTime() + (COOKIE_DURATION * 60 * 1000));
    const expires = "; expires=" + date.toGMTString();
    document.cookie = "character=" + JSON.stringify(randomCharacter) + expires + "; path=/";
    alert(`Personaje ${randomCharacter.name} guardado`);
}