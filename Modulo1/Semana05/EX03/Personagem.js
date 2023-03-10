class Personagem {
  percentualVida = 100

  constructor(nome) {
    this.nome = nome
  }

  sofreuDano(percentualDano) {
    const calculo = this.percentualVida - percentualDano

    this.percentualVida = calculo < 0 ? 0 : calculo
  }

  usouKitMedico() {
    const calculo = this.percentualVida + 10

    this.percentualVida = calculo > 100 ? 100 : calculo
  }
}

export default Personagem
