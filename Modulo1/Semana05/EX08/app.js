import { Usuario } from './Usuario.js'

const usuario = new Usuario('usuario', 'a@a.com', '123')

const button = document.querySelector('#button')

button.addEventListener('click', () => {
  const email = document.querySelector('#email').value
  const password = document.querySelector('#password').value

  if (usuario.autenticar(email, password)) {
    alert('Autenticação feita com sucesso!')
  } else {
    alert('Credenciais inválidas!')
  }
})
