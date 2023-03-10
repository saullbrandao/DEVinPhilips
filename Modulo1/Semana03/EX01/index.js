const entradas = [
  [56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47],
  [],
  'tg4gh0',
  ['vfvdf', 5, 45],
  [1],
  [1, -1],
  null,
  [-2, -2, -2, -2],
  [20, 10, 30]
]

const procuraMinMax = (numeros) => {
  // Checa se a entrada é uma Array
  if (Array.isArray(numeros)) {
    let max = -Infinity
    let min = Infinity

    numeros.forEach(elemento => {
      // Só faz a comparação se o elemento for um number(evita que o javascript faça coerção de tipo) 
      if (typeof elemento === 'number') {
        max = elemento > max ? elemento : max
        min = elemento < min ? elemento : min
      }
    })

    // imprime a resposta e retorna a função se o elemento for um number
    if (min !== Infinity && max !== -Infinity) {
      console.log(`Max: ${max} e Min: ${min}`)
      return
    }

  }

  console.log('Não é possível encontrar')
}

entradas.forEach(entrada => procuraMinMax(entrada)) 