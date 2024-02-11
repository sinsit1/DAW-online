const navButtons = [
  {id: 'todo', desc: 'Todas las categorias'},
  {id: 'desayuno', desc: 'Desayunos'},
  {id: 'comida', desc: 'Comidas'},
  {id: 'cena', desc: 'Cenas'},
  {id: 'batidos', desc: 'Batidos'},
];

const menu = [
  {
    id: 1,
    title: "buttermilk pancakes",
    category: "desayuno",
    price: 15.99,
    img: "./images/item-1.jpeg",
    desc: `Gofres de mantequilla con salsa de sirope de arce y frutas`,
  },
  {
    id: 2,
    title: "diner double",
    category: "comida",
    price: 13.99,
    img: "./images/item-2.jpeg",
    desc: `Hamburguesa doble de ternera, sin nada que envidiar a McDonals!`,
  },
  {
    id: 3,
    title: "godzilla milkshake",
    category: "batidos",
    price: 6.99,
    img: "./images/item-3.jpeg",
    desc: `Batido tan grande como el monstruo japones, al que te costara derrotar`,
  },
  {
    id: 4,
    title: "country delight",
    category: "desayuno",
    price: 20.99,
    img: "./images/item-4.jpeg",
    desc: `Comida tipica inglesa  para despertate como si fueras la reina de inglaterra.`,
  },
  {
    id: 5,
    title: "egg attack",
    category: "comida",
    price: 22.99,
    img: "./images/item-5.jpeg",
    desc: `Hamburguesa de cerdo, y huevo frito que no te comeras sin ensuciarte, para chuparse los dedos.`,
  },
  {
    id: 6,
    title: "oreo dream",
    category: "batidos",
    price: 18.99,
    img: "./images/item-6.jpeg",
    desc: `Si eres fan de las galletas oreo, este es un batido que no te puedes perder!`,
  },
  {
    id: 7,
    title: "bacon overflow",
    category: "desayuno",
    price: 8.99,
    img: "./images/item-7.jpeg",
    desc: `Para los carnivoros de verdad, con bacon crujiente y pollo a la plancha.`,
  },
  {
    id: 8,
    title: "american classic",
    category: "comida",
    price: 12.99,
    img: "./images/item-8.jpeg",
    desc: `Sientete un verdadero americano, como si estubieras en cualquier esquina de NY.`,
  },
  {
    id: 9,
    title: "quarantine buddy",
    category: "batidos",
    price: 16.99,
    img: "./images/item-9.jpeg",
    desc: `El clasico entre los clasicos, que nunca pasa de moda y que hasta podras compartir con tu amigo de cuarentena.`,
  },
  {
    id: 10,
    title: "bison steak",
    category: "cena",
    price: 22.99,
    img: "./images/item-10.jpeg",
    desc: `Verdadera carne ahumada de bisonte, para la gente que no se llena con nada y le gusta el verdadero sabor a bisonte!`,
  },
];

// crea el nav iterando los botones necesarios definidos arriba
function createNav(){
  return `<div class="title">
  <h2>menu restaurante DWEC03</h2>
  <div class="underline"></div>
  </div>
  <div class="btn-container">
      ${navButtons.map(el => `<button type="button" class="filter-btn" id="${el.id}" data-id="${el.id}">
      ${el.desc}
    </button>`).join('')}
`;
}

// Recibe un array de elementos y actualiza la lista del dom. 
function updateMenuItems(menu){
  sectionCenter.innerHTML='';
  for (let index = 0; index < menu.length; index++) {
    const item = createMenuItem(menu[index]);
    sectionCenter.appendChild(item)
  }
}

// crea cada item de la lista y lo devuelve
function createMenuItem(item){
  const menuItem = document.createElement('article');
  menuItem.classList.add("menu-item");
  const image = document.createElement('img');
  image.classList.add("photo");
  image.addEventListener('mouseover', ()=>{image.classList.add('encima')});
  image.addEventListener('mouseout', ()=>{image.classList.remove('encima')});


  image.setAttribute('alt', 'menu-item');
  image.src = item.img;

  const itemInfo = document.createElement('div');
  itemInfo.classList.add("item-info");
  const itemInfoHtml = `<header>
    <h4>${item.title}</h4>
    <h4 class="price">${item.price}€</h4>
    </header><p class="item-text">${item.desc}</p>`;

  itemInfo.innerHTML = itemInfoHtml;

  menuItem.appendChild(image);
  menuItem.appendChild(itemInfo);

  return menuItem;
}
// recibe el evento que procede de los botones del nav y hace un filtro sobre los elementos
function filterProducts(e){
  menuFiltered = menu.filter(el => el.category === e.target.id);
  updateMenuItems(e.target.id === 'todo' ? menu : menuFiltered);
}

// hago una copia del menu para podre mutarla
let menuFiltered = [...menu];

const body = document.getElementsByTagName('body')[0];
const sectionMenu = document.createElement('section');
const sectionCenter = document.createElement('section');

sectionMenu.classList.add('menu');
sectionCenter.classList.add('section-center');
// crea nav de la pagina
sectionMenu.innerHTML = createNav();
// añade el nav al body
body.appendChild(sectionMenu);
// añade lista de items del menu al body
body.appendChild(sectionCenter);

const menuButtonsItems = document.getElementsByClassName('filter-btn');
// añade evento a los botones para poder hacer filtros en la lista
for (let button of menuButtonsItems) {
  button.addEventListener('click', filterProducts)
}

//inicializa el menu
updateMenuItems(menu);