const uneDobraRetorna = (numerosArray, ...restNumeros) => {
  const resultArray = [...numerosArray]

  restNumeros.forEach(num => resultArray.push(num * 2))

  return resultArray
}

const r1 = uneDobraRetorna([1, 2, 3], 4, 4)
console.log(r1) // [1, 2, 3, 8, 8]

const r2 = uneDobraRetorna([2], 10, 4, 8)
console.log(r2) // [2, 20, 8, 16]

const r3 = uneDobraRetorna([6, 8])
console.log(r3) // [6, 8]