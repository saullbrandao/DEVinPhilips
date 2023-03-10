function calculadoraPA(numero) {
  let valorInicial = Number(prompt("Digite o valor inicial"))
  const raiz = Number(prompt("Digite o valor da raiz"))
  let progressaoAritmetica = ''

  if (isNaN(valorInicial) || isNaN(raiz)) {
    alert("Valor inválido. Tente novamente")
    return calculadoraPA()
  }

  for (let i = 1; i <= 10; i++) {
    progressaoAritmetica += valorInicial
    progressaoAritmetica += i !== 10 ? ', ' : '.'

    valorInicial += raiz
  }

  alert(progressaoAritmetica)
}

calculadoraPA()