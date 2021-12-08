
const openModal = () => document.getElementById('modal')
    .classList.add('active')

const closeModal = () => {
    clearFields()
    document.getElementById('modal').classList.remove('active')
    enableButtons()
    enableFields()
}



//Interação com layout
const isValidFields = () => {
    return document.getElementById('form').reportValidity()
}

const clearFields = () => {
    const fields = document.querySelectorAll('.modal-field')
    fields.forEach(field => field.value = "")
}


const disableButtons = () => {
    const saveButton = document.getElementById("salvar")
    const cancelButton = document.getElementById("cancelar")
    const adicionarContatoButton = document.getElementById("adicionarContato")
    saveButton.hidden = true;
    cancelButton.hidden = true;
    adicionarContatoButton.hidden = true;
}

const enableButtons = () => {
    const saveButton = document.getElementById("salvar")
    const cancelButton = document.getElementById("cancelar")
    const adicionarContatoButton = document.getElementById("adicionarContato")
    saveButton.hidden = false;
    cancelButton.hidden = false;
    adicionarContatoButton.hidden = false;
}


//Eventos
document.getElementById('cadastrarFornecedor')
    .addEventListener('click', openModal)

document.getElementById('modalClose')
    .addEventListener('click', closeModal)

document.getElementById('salvar')
    .addEventListener('click', saveFornecedor)

document.getElementById('cancelar')
    .addEventListener('click', closeModal)

document.querySelector('#tableFornecedor>tbody')
    .addEventListener('click', editConsultDelete)


