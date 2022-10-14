function somarNumeros() {
    let resultado = 0

    while (true) {
        const numeroDigitado = Number(prompt("Digite um número."))

        if (numeroDigitado === -1) {
            break
        }

        if (isNaN(numeroDigitado)) {
            alert("Número inválido. Tente novamente")
            continue
        }

        resultado += numeroDigitado
    }

    alert(`Resultado da soma = ${resultado}`)
}

somarNumeros()