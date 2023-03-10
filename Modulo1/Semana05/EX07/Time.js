export class Time {
  vitorias = 0
  empates = 0
  derrotas = 0
  golsMarcados = 0
  golsSofridos = 0

  constructor(nome, sigla) {
    this.nome = nome
    this.sigla = sigla
  }

  get numeroDeJogos() {
    return this.vitorias + this.empates + this.derrotas
  }

  get numeroDePontos() {
    return 3 * this.vitorias + this.empates
  }

  computarPartida(partida) {
    if (partida.siglaTimeA === this.sigla) {
      this.golsMarcados += partida.golsTimeA
      this.golsSofridos += partida.golsTimeB

      if (partida.golsTimeA > partida.golsTimeB) {
        this.vitorias++
      } else if (partida.golsTimeA < partida.golsTimeB) {
        this.derrotas++
      } else {
        this.empates++
      }
    }

    if (partida.siglaTimeB === this.sigla) {
      this.golsMarcados += partida.golsTimeB
      this.golsSofridos += partida.golsTimeA

      if (partida.golsTimeA > partida.golsTimeB) {
        this.derrotas++
      } else if (partida.golsTimeA < partida.golsTimeB) {
        this.vitorias++
      } else {
        this.empates++
      }
    }
  }

  exibirSituacao() {
    console.log(`Nome: ${this.nome}`)
    console.log(`Sigla: ${this.sigla}`)
    console.log(`Vitórias: ${this.vitorias}`)
    console.log(`Empates: ${this.empates}`)
    console.log(`Derrotas: ${this.derrotas}`)
    console.log(`Gols Marcados: ${this.golsMarcados}`)
    console.log(`Gols Sofridos: ${this.golsSofridos}`)
  }
}
