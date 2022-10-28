import { clients } from './app.js'

const operationSelect = document.querySelector('#operation')
const valueInput = document.querySelector('#value')
const form = document.querySelector('#operations-form')

operationSelect.addEventListener('change', (event) => {
  if (event.target.value === 'balance') {
    valueInput.value = ''
    valueInput.disabled = true
  } else {
    valueInput.disabled = false
  }
})

form.addEventListener('submit', (event) => {
  event.preventDefault()
  const formData = new FormData(form)

  const operation = formData.get('operation')
  const value = Number(formData.get('value'))
  const account = Number(formData.get('account'))
  const password = formData.get('password')

  if (!clients.some(client => client.account === account && client.password === password)) {
    alert('Conta ou senha inválida')
    return
  }

  switch (operation) {
    case 'withdraw':
      withdraw({ account, value })
      break
    case 'deposit':
      deposit({ account, value })
      break
    case 'balance':
      getBalance(account)
      break
  }

  valueInput.disabled = false
  form.reset()
})


function withdraw({ account, value }) {
  if (value <= 0) {
    alert('Valor inválido')
    return
  }

  const client = clients.find(client => client.account === account)

  if (client.balance < value) {
    alert('Saldo insuficiente para essa operação.')
    return
  }

  client.balance -= value
  alert(`Saque efetuado com sucesso. Novo saldo: ${client.balance}`)
}

function deposit({ account, value }) {
  if (value <= 0) {
    alert('Valor inválido')
    return
  }

  const client = clients.find(client => client.account === account)
  client.balance += value

  alert(`Depósito efetuado com sucesso. Novo saldo: ${client.balance}`)
}

function getBalance(account) {
  const client = clients.find(client => client.account === account)
  alert(`Saldo: ${client.balance}`)
}