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
        mostrarToast('exito', '¡Envío satisfactorio!')
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
        mostrarToast("error", "Por favor, ingresa un nombre válido (mínimo 3 caracteres y solo letras).");

        const inputError = document.getElementById("nombre-suscripcion");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";

        return false; // Detiene la ejecución si el nombre está mal
    }

    if (correoInput.trim().length === 0 || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(correoInput)) {
        mostrarToast("error","Por favor, ingresa un correo electrónico válido.");
        
        const inputError = document.getElementById("email-suscripcion");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";

        return false;
    }

    mostrarToast("exito", "Datos enviados correctamente");
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

//Funcionalidad del modal del INDEX.HTML
document.addEventListener("DOMContentLoaded", () => {  // Esperamos a que el HTML de la página esté listo
    inicializarModal();


    // Funcionalidad para verificar los campos dentro del modal del formulario de reservas rápidas
    const formularioModal = document.getElementById("modal-formulario-reserva");
    if (formularioModal) {
        formularioModal.addEventListener("submit", (event) =>{
            event.preventDefault();

            const fechaHoy = new Date().toISOString().split('T')[0];
            const campoFecha = document.getElementById("fecha-reserva").value;
            const campoNumPersonas = Number(document.getElementById("personas-reserva").value);
            const campoTelefono = document.getElementById("telefono-reserva").value;

            if (campoFecha < fechaHoy) {
                mostrarToast("error","La fecha de la reserva no puede ser anterior al día de hoy.");
                const inputError = document.getElementById("fecha-reserva");
                inputError.focus();
                inputError.style.backgroundColor = "#ffdddd";
                return;
            }

            if (campoNumPersonas < 1 || campoNumPersonas > 10) {
                mostrarToast("error", "Por favor, selecciona entre 1 y 10 comensales para tu mesa.");
                const inputError = document.getElementById("personas-reserva");
                inputError.focus();
                inputError.style.backgroundColor = "#ffdddd";
                return;
            }

            if (campoTelefono.trim().length !== 9) {
                mostrarToast("error", "Por favor, ingrese un número de teléfono válido");
                const inputError = document.getElementById("telefono-reserva");
                inputError.focus();
                inputError.style.backgroundColor = "#ffdddd";
                return;
            }

            mostrarToast("exito", "¡Reserva lista! Te esperamos en Fuego & Brasa. 🔥🥩")
            formularioModal.reset();
        });


    const fechaElement = document.getElementById("fecha-reserva");
    const personasElement = document.getElementById("personas-reserva");
    const telElement = document.getElementById("telefono-reserva");

    fechaElement.addEventListener("input", () =>{
        fechaElement.style.backgroundColor = "";
    });
    personasElement.addEventListener("input", () =>{
        personasElement.style.backgroundColor = "";
    });
    telElement.addEventListener("input", () =>{
        telElement.style.backgroundColor = "";
    });
    }


    const botonReserva = document.querySelector(".btn-reservar");
    const capaOscura = document.querySelector(".modal-oscuro");
    const botonCerrarModal = document.getElementById("btn-cerrar-modal-reserva");

    if (botonReserva) {
        botonReserva.addEventListener("click", () =>{
            capaOscura.style.display = "flex";
        });
        botonCerrarModal.addEventListener("click", () => {
            capaOscura.style.display = "none";
        });
        capaOscura.addEventListener("click", (event) => {
            if (event.target === capaOscura) {
                capaOscura.style.display = "none";
            }
        });
    }
});




//FUNCIONES
function validarCampos(nombre, email, telefono, asunto, mensaje){
    if (nombre.trim().length < 3 || !/^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$/.test(nombre)) {
        mostrarToast("error", "Por favor, ingresa un nombre válido (mínimo 3 caracteres, solo letras).");
        
        const inputError = document.getElementById("nombre");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        
        return false; // Detiene la función y avisa que hay un error
    }
    
    if (email.trim().length === 0 || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        mostrarToast("error", "Por favor, ingresa un córreo electrónico válido");
        const inputError = document.getElementById("email");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }    

    if (telefono.trim().length === 0 || !/^\+?[0-9 ]{9,15}$/.test(telefono)) {
        mostrarToast("error", "Por favor, ingrese un número de teléfono válido");
        const inputError = document.getElementById("telefono");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }

    if (asunto.trim().length < 5) {
        mostrarToast("error", "Por favor, el asunto debe tener una longitud mínima de 5 caracteres");
        const inputError = document.getElementById("asunto");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }

    if (mensaje.trim().length < 10) {
        mostrarToast("error", "Por favor, el mensaje debe tener una longitud mínima de 10 caracteres");
        const inputError = document.getElementById("mensaje");
        inputError.focus();
        inputError.style.backgroundColor = "#ffdddd";
        return false;
    }

    return true;
}

//Funcion para inicializar el modal para realizar reservas rapidas
function inicializarModal(){
    document.body.insertAdjacentHTML('beforeend', `
        <div id="contenedor-toast">
            
        </div>
        
        <div class="modal-oscuro">
        <div class="modal">
            <form action="" id="modal-formulario-reserva">
                <span id="btn-cerrar-modal-reserva" class="btn-cerrar">&times;</span>
                <h2>Reserva ahora</h2>
                <div class="campo">
                    <label for="nombre-reserva"><i class="fas fa-user"></i> Nombre:</label>
                    <input type="text" name="nombre" id="nombre-reserva" required>
                </div>

                <div class="campo">
                    <label for="fecha-reserva"><i class="fas fa-calendar-alt"></i> Fecha:</label>
                    <input type="date" name="fecha" id="fecha-reserva" required>
                </div>

                <div class="campo">
                    <label for="hora-reserva"><i class="fas fa-clock"></i> Hora:</label>
                    <input type="time" name="hora" id="hora-reserva" required>
                </div>

                <div class="campo">
                    <label for="personas-reserva"><i class="fas fa-users"></i> Número de personas:</label>
                    <input type="number" name="personas" id="personas-reserva" required>
                </div>

                <div class="campo">
                    <label for="telefono-reserva"><i class="fas fa-phone"></i> Teléfono:</label>
                    <input type="tel" name="telefono" id="telefono-reserva" required>
                </div>
                
                <div class="campo-botones">
                    <button type="submit">Enviar mensaje</button>
                </div>     
            </form>
        </div>
    </div>    
    `);
}

function mostrarToast(tipo,mensaje){
    const nuevoToast = document.createElement('div');
    nuevoToast.classList.add('toast');
    nuevoToast.classList.add(`toast-${tipo}`);

    nuevoToast.textContent = mensaje;

    const contenedorToast = document.getElementById("contenedor-toast");

    contenedorToast.appendChild(nuevoToast);

    //funcion para que el toast desaparezca en un determinado tiempo
    setTimeout(() => {
        nuevoToast.remove();
    }, 4000);
}