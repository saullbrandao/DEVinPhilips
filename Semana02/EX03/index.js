function tabuada() {
    let numero = Number(prompt("Digite um número"))
    if (isNaN(numero)) {
        alert("Número inválido. Tente novamente.")
        tabuada()
        return
    }

    let resultadoTabuada = '';

    for (let i = 0; i <= 10; i++) {
        resultadoTabuada += `${numero} x ${i} = ${numero * i}\n`
    }

    alert(resultadoTabuada)
}

tabuada()