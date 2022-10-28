import { clients } from "./app.js"
import { CPF_REGEX, PHONE_REGEX } from "./constants.js"

const form = document.querySelector('#signup-form')

form.addEventListener('submit', (event) => {
  event.preventDefault()

  const formData = new FormData(form)
  const formProps = Object.fromEntries(formData);

  console.log(formProps.phone)
  if (!isFormValid(formProps)) {
    // TODO: display better error message
    return alert('Formulário inválido.')
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

  localStorage.setItem('clients', JSON.stringify(clients))
  alert(`Conta criada com sucesso: ${newClient.account}`)

  form.reset()
})


function isFormValid({ name, cpf, phone, password, passwordConfirmation }) {
  return isNameValid(name) && isCPFValid(cpf) && isPhoneValid(phone) && isPasswordValid(password, passwordConfirmation)
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

const isPasswordValid = (password, confirmPassword) => (
  typeof password === 'string'
  && password.length >= 3
  && password === confirmPassword
)


const cpfInput = document.querySelector('#cpf')

cpfInput.addEventListener('input', cpfMask)

function cpfMask() {
  let { value } = cpfInput;

  // impede entrar outro caractere que não seja número
  if (isNaN(value[value.length - 1])) {
    cpfInput.value = value.substring(0, value.length - 1);
    return;
  }

  // adiciona os pontos do cpf
  if (value.length === 3 || value.length === 7) cpfInput.value += ".";

  // adiciona o hífen
  if (value.length === 11) cpfInput.value += "-";
}

const phoneInput = document.querySelector('#phone')

phoneInput.addEventListener('input', phoneMask)

function phoneMask() {
  let { value } = phoneInput;

  // impede entrar outro caractere que não seja número
  if (isNaN(value[value.length - 1])) {
    phoneInput.value = value.substring(0, value.length - 1);
    return;
  }

  // adiciona os parenteses do DDD
  if (value.length === 1) phoneInput.value = `(${value}`;
  if (value.length === 3) phoneInput.value += ") ";

  // adiciona o hífen
  if (value.length === 10) phoneInput.value += "-";
}