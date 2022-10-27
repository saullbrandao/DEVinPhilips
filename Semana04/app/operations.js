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
  const value = formData.get('value')
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

})


function withdraw({ account, value }) {
  console.log(account, value)
}

function deposit({ account, value }) {
  console.log(account, value)
}

function getBalance(account) {
  const client = clients.find(client => client.account === account)
  alert(`Saldo: ${client.balance}`)
}