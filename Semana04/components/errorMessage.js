export const createErrorMessage = (message, parentElement) => {
  const errorMessage = document.createElement('p')
  errorMessage.innerText = message
  errorMessage.classList.add('error')

  parentElement.appendChild(errorMessage)
}

export const removeErrorMessage = (parentElement) => {
  const errorMessage = document.querySelector(`#${parentElement?.id} .error`)

  if (errorMessage) errorMessage.remove()
}