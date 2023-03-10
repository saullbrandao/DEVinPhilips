function isPrimo(numero) {
  if (numero === 0 || numero === 1) {
    return false
  }

  for (let i = 2; i < numero; i++) {
    if (numero % i === 0) {
      return false
    }
  }

  return true
}

function numerosPrimos() {
  let totalPrimos = 0

  for (let i = 0; i <= 1000; i++) {
    if (isPrimo(i)) {
      console.log(i)
      totalPrimos++
    }
  }

  console.log(`Total de números primos até 1000: ${totalPrimos}`)
}

numerosPrimos()