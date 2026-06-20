//Funcionalidad del menu hamburguesa
const boton = document.querySelector(".menu-hamburguesa");
const nav = document.querySelector("header nav");

boton.addEventListener("click", () => {
    nav.classList.toggle("activo")
})


//Funcionalidad del formulario de contacto.HTML
const formulario = document.getElementById("formulario-contacto");

if (formulario) {
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
    });

    const nombreElement = document.getElementById("nombre");
    const emailElement = document.getElementById("email");
    const telefonoElement = document.getElementById("telefono");
    const asuntoElement = document.getElementById("asunto");
    const mensajeElement = document.getElementById("mensaje");

    nombreElement.addEventListener("input", () =>{
        nombreElement.style.backgroundColor = "";
    });

    emailElement.addEventListener("input", () =>{
        emailElement.style.backgroundColor = "";
    });

    telefonoElement.addEventListener("input", () =>{
        telefonoElement.style.backgroundColor = "";
    });

    asuntoElement.addEventListener("input", () =>{
        asuntoElement.style.backgroundColor = "";
    });

    mensajeElement.addEventListener("input", () =>{
        mensajeElement.style.backgroundColor = "";
    });
}


//Funcionalidad formulario de blog.HTML
const formularioBlog = document.getElementById("formulario-suscripcion");

if (formularioBlog) {
    formularioBlog.addEventListener("submit", (event) =>{
    event.preventDefault();

    const nombreInput = document.getElementById("nombre-suscripcion").value;
    const correoInput = document.getElementById("email-suscripcion").value;

    if (nombreInput.trim().length < 3 || !/^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$/.test(nombreInput)) {
        alert("Por favor, ingresa un nombre válido (mínimo 3 caracteres y solo letras).");

        const inputError = document.getElementById("nombre-suscripcion");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";

        return false; // Detiene la ejecución si el nombre está mal
    }

    if (correoInput.trim().length === 0 || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(correoInput)) {
        alert("Por favor, ingresa un correo electrónico válido.");
        
        const inputError = document.getElementById("email-suscripcion");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";

        return false;
    }

    alert("Datos enviados correctamente");
    formularioBlog.reset();
    })

    
    const nombreElemento = document.getElementById("nombre-suscripcion");
    const correoElemento = document.getElementById("email-suscripcion");

    nombreElemento.addEventListener("input", () =>{
        nombreElemento.style.backgroundColor = "";
    });

    correoElemento.addEventListener("input", () =>{
        correoElemento.style.backgroundColor = "";
    });
}

function validarCampos(nombre, email, telefono, asunto, mensaje){
    if (nombre.trim().length < 3 || !/^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$/.test(nombre)) {
        alert("Por favor, ingresa un nombre válido (mínimo 3 caracteres, solo letras).");
        
        const inputError = document.getElementById("nombre");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        
        return false; // Detiene la función y avisa que hay un error
    }
    
    if (email.trim().length === 0 || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        alert("Por favor, ingresa un córreo electrónico válido");
        const inputError = document.getElementById("email");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }    

    if (telefono.trim().length === 0 || !/^\+?[0-9 ]{9,15}$/.test(telefono)) {
        alert("Por favor, ingrese un número de teléfono válido");
        const inputError = document.getElementById("telefono");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }

    if (asunto.trim().length < 5) {
        alert("Por favor, el asunto debe tener una longitud mínima de 5 caracteres");
        const inputError = document.getElementById("asunto");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }

    if (mensaje.trim().length < 10) {
        alert("Por favor, el mensaje debe tener una longitud mínima de 10 caracteres");
        const inputError = document.getElementById("mensaje");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }

    return true;
}