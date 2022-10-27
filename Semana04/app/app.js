import './signup.js'
import './operations.js'

export const clients = []

if (localStorage.getItem('clients')) {
  const localStorageClient = JSON.parse(localStorage.getItem('clients'))
  clients.push(...localStorageClient)
}