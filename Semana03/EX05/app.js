const somaTudo = (...numeros) => {
  // só soma se o valor for um number
  return numeros.reduce((prev, curr) => typeof curr === 'number' && !isNaN(curr)
    ? prev + curr
    : prev
  )
}

const resultado = somaTudo(1, 2, 3, 4);
console.log(resultado);