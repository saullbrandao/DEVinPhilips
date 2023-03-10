import Personagem from './Personagem.js'

const alyx = new Personagem('Alyx')

console.log(alyx.percentualVida) // 100

alyx.sofreuDano(50)

console.log(alyx.percentualVida) // 50

alyx.usouKitMedico()

console.log(alyx.percentualVida) // 60

const test = new Personagem('Test')

console.log(test.percentualVida) // 100

test.sofreuDano(5)

console.log(test.percentualVida) // 95

test.usouKitMedico()

console.log(test.percentualVida) // 100

test.sofreuDano(105)

console.log(test.percentualVida) // 0
