class Fatura {
  constructor(id, descricao, quantia, preco = 0) {
    this.id = id
    this.descricao = descricao
    this.quantia = quantia > 0 ? quantia : 0
    this.preco = preco > 0 ? preco : 0
  }

  get obterValorTotal() {
    return this.quantia * this.preco
  }
}

export default Fatura
