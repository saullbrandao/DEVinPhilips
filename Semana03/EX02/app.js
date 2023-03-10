const mensagemOla = (event) => {
  const inputElement = document.querySelector('input')
  const pElement = document.querySelector('p')

  pElement.textContent = `Olá, ${inputElement.value}!`
  inputElement.value = ''
}
