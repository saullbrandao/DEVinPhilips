import { CalculadoraDeArea } from './CalculadoraDeArea.js'

const quadA = new CalculadoraDeArea('quadrado', 6, 6)
const areaQA = quadA.calcular()
console.log(areaQA) // 36

const triangB = new CalculadoraDeArea('triangulo', 8, 7)
const areaTB = triangB.calcular()
console.log(areaTB) // 28

const retA = new CalculadoraDeArea('retangulo', 4, 6)
const areaRA = retA.calcular()
console.log(areaRA) // 24
