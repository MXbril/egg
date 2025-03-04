//alert("Hola este es mi Javascript");
//let nombre = "Maximo";

//console.log(nombre)
let contenidoTitulo = "Acerca de mi";

let titulo = document.querySelector(".seccion-1 .cambio");
titulo.innerHTML = contenidoTitulo;

let textoTitulo = titulo.innerText;
console.log(textoTitulo);

if (textoTitulo == "Acerca de mi") {
    titulo.innerHTML = "Otro";
} else {
    console.log("no se cumple");
}

//FUNCIONES

//let nombre = "Junior";
//let gente = "todos";
//let gusto = "musica";

//let parrafo = document.querySelector(".parrafo2");


//function cambiarTexto(nombre, gente, gusto) {
//    let contenido = `¡Hola a todos! Soy ${nombre}, y estoy encantado de tener la oportunidad de presentarme ante ${gente} hoy.
//    Disfruto dedicar mi tiempo libre a los deportes y ${gusto}.
//    Mis objetivos a futuro son trabajar de programador web y formar mi propia empresa.`;

//    return contenido;
//}

//parrafo.innerText = cambiarTexto(nombre, gente, gusto);

//FUNCIONES

let modificar = "este titulo estara modificado";

function modificarTexto(modificar) {
    let contenedor = `${modificar}`;

    return contenedor;
}

titulo.innerText = modificarTexto(modificar);

let menu_responsive = document.querySelector(".checkbtn");

menu_responsive.onclick = function () {
  navBar = document.querySelector(".navbar");
  navBar.classList.toggle("active");
};





