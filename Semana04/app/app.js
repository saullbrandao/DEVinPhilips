const CPF_REGEX = /^\d{3}\.\d{3}\.\d{3}\-\d{2}$/
const PHONE_REGEX = /(^[0-9]{2})?(\s|-)?(9?[0-9]{4})-?([0-9]{4}$)/

const clients = []

const form = document.querySelector('#form-cadastro')

form.addEventListener('submit', (event) => {
  event.preventDefault()

  const formData = new FormData(form)

  const nome = formData.get('nome')
  const cpf = formData.get('cpf')
  const celular = formData.get('celular')
  const senha = formData.get('senha')
  const confirmarSenha = formData.get('confirmar-senha')

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


