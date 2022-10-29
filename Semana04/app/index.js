import './signup.js'
import './operations.js'

export const clients = []

if (localStorage.getItem('clients')) {
  const localStorageClients = JSON.parse(localStorage.getItem('clients'))
  clients.push(...localStorageClients)
}