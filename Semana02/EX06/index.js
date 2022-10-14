function calculadora() {
    const operacao = prompt("Digite a operação que deseja fazer('+', '-', '*' ou '/')")
    const primeiroNumero = Number(prompt("Digite o primeiro número"))
    const segundoNumero = Number(prompt("Digite o segundo número"))
    let resultado = 0

    if (isNaN(primeiroNumero) || isNaN(segundoNumero)) {
        alert("Número inválido. Tente novamente")
        return calculadora()
    }

    switch (operacao) {
        case "+":
            resultado = primeiroNumero + segundoNumero
            break
        case "-":
            resultado = primeiroNumero - segundoNumero
            break
        case "*":
            resultado = primeiroNumero * segundoNumero
            break
        case "/":
            resultado = primeiroNumero / segundoNumero
            break
        default:
            alert("Operação inválida. Tente novamente")
            return calculadora()
    }

    alert(`O resultado do seu cálculo é: ${resultado}`)
}

calculadora()