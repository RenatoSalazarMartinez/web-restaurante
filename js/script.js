//Funcionalidad del menu hamburguesa
const boton = document.querySelector(".menu-hamburguesa");
const nav = document.querySelector("header nav");

boton.addEventListener("click", () => {
    nav.classList.toggle("activo")
})