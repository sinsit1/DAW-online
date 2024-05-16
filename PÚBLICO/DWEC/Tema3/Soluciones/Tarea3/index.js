function playSound(e) {
    //si llega por teclado, llega keycode, sino por click
    let code = e.keyCode ? e.keyCode : this.dataset.key;

    const audio = document.querySelector(`audio[data-key="${code}"]`);
    const key = document.querySelector(`div[data-key="${code}"]`);
    setScreen(key.lastElementChild.textContent);
    if (!audio) return;

    key.classList.add('playing'); 

    audio.currentTime = 0;
    audio.play();
    
    // controla el audio, y cuando este termina, quita la clase de playing
    audio.onended = ()=> {
        key.classList.remove('playing'); 
        document.getElementById('text').remove()
    }
}

function setScreen(text){
    const screen = document.getElementsByClassName('screen')[0];
    const p = document.createElement('p');
    p.id='text';
    p.textContent=text;
    screen.appendChild(p);
}

const keys = document.querySelectorAll('.key');
for (let i=0, key; key = keys[i]; i++) {
    // evento para que funcione con click
    key.addEventListener('click', playSound);
}

// evento para que funcione con teclado
window.addEventListener('keydown', playSound);

window.addEventListener('keyup', ()=> document.getElementById('text').remove());




