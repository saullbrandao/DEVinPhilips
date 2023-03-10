function classificarIdade() {
    let idade = Number(prompt("Digite a sua idade"))

    if (idade >= 65) {
        alert("Idoso")
    } else if (idade >= 16) {
        alert("Adulto")
    } else if (idade >= 0) {
        alert("Jovem")
    } else {
        alert("Idade inválida. Digite novamente.")
        classificarIdade()
    }
}

classificarIdade()