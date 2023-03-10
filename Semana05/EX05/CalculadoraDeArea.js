export class CalculadoraDeArea {
  constructor(tipo, base, altura) {
    this.tipo = tipo
    this.base = base
    this.altura = altura
  }

  calcular() {
    switch (this.tipo) {
      case 'triangulo':
        return (this.base * this.altura) / 2
      case 'quadrado':
      case 'retangulo':
        return this.base * this.altura
      default:
        return 'Tipo inválido'
    }
  }
}
