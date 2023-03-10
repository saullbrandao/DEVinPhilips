class Juros {
  constructor(capitalInicial, taxaAplicada, tempo) {
    this.capitalInicial = capitalInicial
    this.taxaAplicada = taxaAplicada
    this.tempo = tempo
  }

  calcularJurosSimples() {
    return this.capitalInicial * this.taxaAplicada * this.tempo
  }

  calcularJurosCompostos() {
    return this.capitalInicial * (1 + this.taxaAplicada) ** this.tempo
  }
}

export default Juros
