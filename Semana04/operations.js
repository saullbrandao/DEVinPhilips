import { clients } from './index.js'
import { createErrorMessage, removeErrorMessage } from './components/errorMessage.js'
import { createModal } from './components/modal.js'
import { saveToLocalStorage } from './utils/utils.js'

const operationSelect = document.querySelector('#operation')
const valueInput = document.querySelector('#value')
const operationsForm = document.querySelector('#operations-form')

operationSelect.addEventListener('change', (event) => {
  if (event.target.value === 'BALANCE') {
    valueInput.value = ''
    valueInput.disabled = true
  } else {
    valueInput.disabled = false
  }
})

operationsForm.addEventListener('submit', (event) => {
  event.preventDefault()
  removeErrorMessage(operationsForm)

  const formData = new FormData(operationsForm)


  const operation = formData.get('operation')
  const value = Number(formData.get('value'))
  const account = Number(formData.get('account'))
  const password = formData.get('password')

  if (!verifyAccountAndPassword(account, password)) {
    return createErrorMessage('Conta ou senha inválida.', operationsForm)
  }

  switch (operation) {
    case 'WITHDRAW':
      withdraw({ account, value })
      break
    case 'DEPOSIT':
      deposit({ account, value })
      break
    case 'BALANCE':
      getBalance(account)
      break
    default:
      createErrorMessage('Escolha uma operação válida', operationsForm)
      return
  }
})


const withdraw = ({ account, value }) => {
  if (!isValueValid(value)) {
    return createErrorMessage('Valor inválido', operationsForm)
  }

  const client = clients.find(client => client.account === account)

  if (client.balance < value) {
    return createErrorMessage('Saldo insuficiente para essa operação.', operationsForm)
  }

  client.balance -= value
  saveToLocalStorage(clients)

  const withdrawMessage = [`Saque efetuado com sucesso.`, `Novo saldo: R$${client.balance.toFixed(2)}`]
  createModal(withdrawMessage)
}

const deposit = ({ account, value }) => {
  if (!isValueValid(value)) {
    return createErrorMessage('Valor inválido', operationsForm)
  }

  const client = clients.find(client => client.account === account)
  client.balance += value
  saveToLocalStorage(clients)

  const depositMessage = [`Depósito efetuado com sucesso.`, `Novo saldo: R$${client.balance.toFixed(2)}`]
  createModal(depositMessage)
}

const getBalance = (account) => {
  const { balance } = clients.find(client => client.account === account)

  const balanceMessage = [`Conta: ${account}`, `Saldo: R$${balance.toFixed(2)}`]
  createModal(balanceMessage)
}

const isValueValid = (value) => value > 0

const verifyAccountAndPassword = (account, password) => clients.some(client => (
  client.account === account
  && client.password === password
)
)