import { clients } from "./app.js"
import { CPF_REGEX, PHONE_REGEX } from "./constants.js"

const form = document.querySelector('#signup-form')

form.addEventListener('submit', (event) => {
  event.preventDefault()

  const formData = new FormData(form)

  const nome = formData.get('name')
  const cpf = formData.get('cpf')
  const celular = formData.get('phone')
  const senha = formData.get('password')
  const confirmarSenha = formData.get('password-confirm')

  const formElements = {
    nome,
    cpf,
    celular,
    senha,
    confirmarSenha
  }

  if (!isFormValid(formElements)) {
    // TODO: display better error message
    return alert('Formulário inválido.')
  }

  const conta = Math.floor(1000 + Math.random() * 90000)
  const saldo = 0


  const newClient = {
    nome, cpf, celular, senha, conta, saldo
  }

  clients.push(newClient)

  alert(`Conta criada com sucesso: ${newClient.conta}`)

  form.reset()
})


function isFormValid({ nome, cpf, celular, senha, confirmarSenha }) {
  return isNameValid(nome) && isCPFValid(cpf) && isPhoneValid(celular) && isPasswordValid(senha, confirmarSenha)
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
