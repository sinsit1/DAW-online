const API_BASE_URL = 'https://pokeapi.co/api/v2/pokemon/';
const MIN = 1; //id min de la API
const MAX = 1025; // OJO! en la api los id correlativos llegan hasta el 1025, luego empiezan a numerarse desde del 10001. Aunque el count que da la BD da 1302.
const pokemons = [null, null, null]; // array donde almacenamos los 3 pokemons.
const intervals = Array(3); // donde guardo los ids de los intervalos para poder hacerles un clear

// helper, saca ints random entre un min y max, incluidos.
function randomIntFromInterval(min, max) { // min and max included 
    return Math.floor(Math.random() * (max - min + 1) + min)
}

function initPokedex(){
    pokemons.forEach((pokemon, i) =>{
        // recoge el pokemon del local, si no hay devuelve un undefined. Lo guarda en su posicion correspondiente del array base de pokemons
        pokemons[i]= JSON.parse(localStorage.getItem(i)); // recoge del localstorage, que se guarda en string, lo parse a JSON.
        // si hay pokemon en esa posicion, lo pinta en el DOM, y añade estilos de capturado.
        if(pokemons[i]) {
            setPokemon(i, pokemons[i]);
            setCatchStyles(i); 
        // sino genera el intervalo para que vaya cambiando
        } else{
            createInterval(i, randomIntFromInterval(2000, 5000)); 
        }
    });
}

document.addEventListener('DOMContentLoaded', function () {
    initPokedex();

    // recoge los personajes y les añade un ID con la posicion, y el evento de capturas pokemon.
    const elements = document.getElementsByClassName('personaje');
    for (var i = 0; i < elements.length; i++) {
        elements[i].setAttribute('id', i);
        elements[i].children[4].children[0].addEventListener('click', (i, a)=>catchPokemon(i));
    }
}, false);

// recibe posicion, y añade estilos de capturado
function setCatchStyles(position) {
    const elements = document.getElementsByClassName('personaje');
    elements[position].children[0].children[0].className="capturado";
    elements[position].children[4].children[0].className="capturado-btn";
    elements[position].children[4].children[0].className="capturado-btn";
    elements[position].children[4].children[0].innerHTML = "Capturado";
}

// pide a la API el personaje. pide un id random entre MIN y MAX y, lo guarda en el array de pokemons y lo pinta en el DOM Hace un catch del error si lo hubiese y saca por la consola
const getPokemon = async (position) => {
    try {
        const response = await axios.get(`${API_BASE_URL}${randomIntFromInterval(MIN, MAX)}`);
        pokemons[position] = {
            name: response.data.name,
            image: response.data.sprites.front_shiny,
            types: response.data.types.map(el => el.type).map(e => e.name),
            moves: response.data.moves.map(el => el.move).map(e => e.name),
        }
        setPokemon(position, pokemons[position]);
    } catch (error) {
        console.error(error);
    }
};

// funcion que recibe posicion y tiempo para crear un intervalo.
function createInterval(position, ms) {
    // guardo el id del intervalo para poder hacerle un clear al capturar el pokemon
    intervals[position] = setInterval(async () => {
        await getPokemon(position);
    }, ms);
}

// con la posicion, y la info, lo pinta en el DOM.
function setPokemon(position, infoPokemon) {
    const elements = document.getElementsByClassName('personaje');
    elements[position].children[0].children[0].setAttribute('src', infoPokemon.image)
    elements[position].children[1].innerHTML = infoPokemon.name;
    elements[position].children[2].innerHTML = infoPokemon.types.toString();
    elements[position].children[3].innerHTML = `Este pokemon dispone de <b>${infoPokemon.moves.length}</b> movimientos entre los que destacan <b>${infoPokemon.moves[0]}</b> y <b>${infoPokemon.moves[1]}</b>`
}

// recoge posicion del padre, añade estilos de capturado, y guarda el pokemon en el localstorage, 
// con la posicion como id para facilitar la recogida posterior
function catchPokemon(event) {
    const position = event.target.parentElement.parentElement.id;
    setCatchStyles(position);
    clearInterval(intervals[position]);
    localStorage.setItem(position, JSON.stringify(pokemons[position]));
}
