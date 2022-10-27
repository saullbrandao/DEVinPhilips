import { clients } from "./app.js"
import { CPF_REGEX, PHONE_REGEX } from "./constants.js"

const form = document.querySelector('#signup-form')

form.addEventListener('submit', (event) => {
  event.preventDefault()

  const formData = new FormData(form)

  const name = formData.get('name')
  const cpf = formData.get('cpf')
  const phone = formData.get('phone')
  const password = formData.get('password')
  const passwordConfirm = formData.get('password-confirm')

  const formElements = {
    name,
    cpf,
    phone,
    password,
    passwordConfirm
  }

  if (!isFormValid(formElements)) {
    // TODO: display better error message
    return alert('Formulário inválido.')
  }

  const account = Math.floor(1000 + Math.random() * 90000)
  const balance = 0


  const newClient = {
    name, cpf, phone, password, account, balance
  }

  clients.push(newClient)

  alert(`Conta criada com sucesso: ${newClient.account}`)

  form.reset()
})


function isFormValid({ name, cpf, phone, password, passwordConfirm }) {
  return isNameValid(name) && isCPFValid(cpf) && isPhoneValid(phone) && isPasswordValid(password, passwordConfirm)
}

const isNameValid = name => (
  typeof name === 'string'
  && name.length >= 3
)

const isCPFValid = cpf => (
  typeof cpf === 'string'
  && CPF_REGEX.test(cpf)
  && !clients.some(client => client.cpf === cpf)
)

const isPhoneValid = phone => (
  typeof phone === 'string'
  && PHONE_REGEX.test(phone)
)

const isPasswordValid = (password, confirmPassword) => (
  typeof password === 'string'
  && password.length >= 3
  && password === confirmPassword
)
