import { clients } from "./index.js"
import { CPF_REGEX, PHONE_REGEX } from "./utils/constants.js"
import { createErrorMessage, removeErrorMessage } from "./components/errorMessage.js"
import { createModal } from "./components/modal.js"
import { cpfMask, phoneMask, saveToLocalStorage } from "./utils/utils.js"

const signupForm = document.querySelector('#signup-form')

signupForm.addEventListener('submit', (event) => {
  event.preventDefault()
  removeErrorMessage(signupForm)

  const formData = new FormData(signupForm)
  const formProps = Object.fromEntries(formData)

  const formValidation = isFormValid(formProps)
  if (formValidation !== true) {
    return createErrorMessage(formValidation, signupForm)
  }

  const newClient = {
    name: formProps.name,
    cpf: formProps.cpf,
    phone: formProps.phone,
    password: formProps.password,
    account: Math.floor(1000 + Math.random() * 90000),
    balance: 0
  }

  clients.push(newClient)

  saveToLocalStorage(clients)

  createModal(`Conta criada com sucesso: ${newClient.account}`)

  signupForm.reset()
})


const isFormValid = ({ name, cpf, phone, password, passwordConfirmation }) => {
  if (!isNameValid(name)) return 'Nome inválido'
  if (!isCPFValid(cpf)) return 'CPF inválido'
  if (!isPhoneValid(phone)) return 'Celular inválido'
  if (!isPasswordValid(password, passwordConfirmation)) return 'Senha inválida'
  return true
}

const isNameValid = name => (
  typeof name === 'string'
  && name.length >= 3
)

const isCPFValid = cpf => (
  typeof cpf === 'string'
  && CPF_REGEX.test(cpf)
  && !clients.some(client => client?.cpf === cpf)
)

const isPhoneValid = phone => (
  typeof phone === 'string'
  && PHONE_REGEX.test(phone)
)

const isPasswordValid = (password, passwordConfirmation) => (
  typeof password === 'string'
  && password.length >= 3
  && password === passwordConfirmation
)


const cpfInput = document.querySelector('#cpf')
cpfInput.addEventListener('input', () => cpfMask(cpfInput))

const phoneInput = document.querySelector('#phone')
phoneInput.addEventListener('input', () => phoneMask(phoneInput))