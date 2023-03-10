import Juros from './Juros.js'

const aplicacaoA = new Juros(10000, 0.07, 24)
console.log(`Juros simples: R$${aplicacaoA.calcularJurosSimples().toFixed(2)}`)
console.log(
  `Juros compostos: R$${aplicacaoA.calcularJurosCompostos().toFixed(2)}`
)

const aplicacaoB = new Juros(10000, 0.15, 10)
console.log(`Juros simples: R$${aplicacaoB.calcularJurosSimples().toFixed(2)}`)
console.log(
  `Juros compostos: R$${aplicacaoB.calcularJurosCompostos().toFixed(2)}`
)
