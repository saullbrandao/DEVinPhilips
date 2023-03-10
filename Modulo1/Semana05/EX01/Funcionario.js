class Funcionario {
  constructor(cpf, nomeCompleto, salario) {
    this.cpf = cpf
    this.nomeCompleto = nomeCompleto
    this.salario = salario
  }

  promover(percentual) {
    this.salario += (this.salario * percentual) / 100
  }

  // https://gist.github.com/joaohcrangel/8bd48bcc40b9db63bef7201143303937?permalink_comment_id=4006668#gistcomment-4006668
  validarCPF() {
    let cpf = this.cpf

    // Valida se é string
    if (typeof cpf !== 'string') return false

    // Separa apenas os numeros
    cpf = cpf.replace(/[^\d]+/g, '')

    // Retorna falso se tiver tamanho diferente de 11 ou sequência de digitos repetidos
    if (cpf.length !== 11 || !!cpf.match(/(\d)\1{10}/)) return false

    // Converte para um array de numeros
    cpf = cpf.split('').map(el => +el)

    const rest = count =>
      // Calcular Soma dos digitos e multiplicar por 10
      ((cpf
        .slice(0, count - 12)
        .reduce((soma, el, index) => soma + el * (count - index), 0) *
        10) % //Pegar o resto por 11
        11) % // Transformar de 10 para 0
      10

    return rest(10) === cpf[9] && rest(11) === cpf[10]
  }
}

export default Funcionario
