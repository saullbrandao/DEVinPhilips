function calcularParesImpares() {
    const numeroDigitado = Number(prompt("Digite um número."))

    if (isNaN(numeroDigitado)) {
        alert("Número inválido. Tente novamente")
        return calcularParesImpares()
    }

    // Permite calcular com números negativos
    const numeroAbsoluto = Math.abs(numeroDigitado)
    let qtdPares = 0
    let qtdImpares = 0

    if (numeroDigitado % 2 === 0) {
        qtdImpares = numeroAbsoluto / 2
        qtdPares = qtdImpares + 1
    } else {
        qtdImpares = (numeroAbsoluto + 1) / 2
        qtdPares = qtdImpares
    }


    alert(`Quantidade de pares entre 0 e ${numeroDigitado}: ${qtdPares}
Quantidade de ímpares entre 0 e ${numeroDigitado}: ${qtdImpares}
`)
}

calcularParesImpares()