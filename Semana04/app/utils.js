export const cpfMask = (input) => {
  let { value } = input

  // impede entrar outro caractere que não seja número
  if (isNaN(value[value.length - 1])) {
    input.value = value.substring(0, value.length - 1)
    return
  }

  // adiciona os pontos do cpf
  if (value.length === 3 || value.length === 7) input.value += "."

  // adiciona o hífen
  if (value.length === 11) input.value += "-"
}

export const phoneMask = (input) => {
  let { value } = input

  // impede entrar outro caractere que não seja número
  if (isNaN(value[value.length - 1])) {
    input.value = value.substring(0, value.length - 1)
    return
  }

  // adiciona os parenteses do DDD
  if (value.length === 1) input.value = `(${value}`
  if (value.length === 3) input.value += ") "

  // adiciona o hífen
  if (value.length === 10) input.value += "-"
}