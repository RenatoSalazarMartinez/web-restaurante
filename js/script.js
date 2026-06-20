//Funcionalidad del menu hamburguesa
const boton = document.querySelector(".menu-hamburguesa");
const nav = document.querySelector("header nav");

boton.addEventListener("click", () => {
    nav.classList.toggle("activo")
})


//Funcionalidad del formulario de contacto.HTML
const formulario = document.getElementById("formulario-contacto");


formulario.addEventListener("submit", (event) =>{
    event.preventDefault();

    //extraemos los valores de los inputs
    const nombreInput = document.getElementById("nombre").value;
    const emailInput = document.getElementById("email").value;
    const telefonoInput = document.getElementById("telefono").value;
    const asuntoInput = document.getElementById("asunto").value;
    const mensajeInput = document.getElementById("mensaje").value;

    const verificacion = validarCampos(nombreInput, emailInput, telefonoInput, asuntoInput, mensajeInput);

    if (verificacion) {
        alert("Envío satisfactorio")
        formulario.reset();
    }   
})


function validarCampos(nombre, email, telefono, asunto, mensaje){
    if (nombre.trim().length < 3 || !/^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$/.test(nombre)) {
        alert("Por favor, ingresa un nombre válido (mínimo 3 caracteres, solo letras).");
        return false; // Detiene la función y avisa que hay un error
    }
    
    if (email.trim().length === 0 || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        alert("Por favor, ingresa un córreo electrónico válido");
        return false;
    }    

    if (telefono.trim().length === 0 || !/^\+?[0-9 ]{9,15}$/.test(telefono)) {
        alert("Por favor, ingrese un número de teléfono válido");
        return false;
    }

    if (asunto.trim().length < 5) {
        alert("Por favor, el asunto debe tener una longitud mínima de 5 caracteres");
        return false;
    }

    if (mensaje.trim().length < 10) {
        alert("Por favor, el mensaje debe tener una longitud mínima de 10 caracteres");
        return false;
    }

    return true;
}