import { Partida } from './Partida.js'
import { Time } from './Time.js'

const timeA = new Time('A', 'AFC')
const timeB = new Time('B', 'BFC')

const partida1 = new Partida('AFC', 3, 'BFC', 2)
const partida2 = new Partida('AFC', 1, 'BFC', 1)
const partida3 = new Partida('AFC', 0, 'BFC', 3)

timeA.computarPartida(partida1)
timeA.computarPartida(partida2)
timeA.computarPartida(partida3)
timeB.computarPartida(partida1)
timeB.computarPartida(partida2)
timeB.computarPartida(partida3)

timeA.exibirSituacao()
console.log('')
timeB.exibirSituacao()
