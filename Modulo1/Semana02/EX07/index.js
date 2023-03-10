function estacaoAno() {
  const dataHoje = new Date()
  const anoAtual = dataHoje.getFullYear()

  const outonoInicio = new Date(`${anoAtual}/03/22`)
  const outonoFim = new Date(`${anoAtual}/06/21`)

  const invernoInicio = new Date(`${anoAtual}/06/22`)
  const invernoFim = new Date(`${anoAtual}/09/21`)

  const primaveraInicio = new Date(`${anoAtual}/09/22`)
  const primaveraFim = new Date(`${anoAtual}/12/21`)

  let estação

  if (dataHoje >= outonoInicio && dataHoje <= outonoFim) {
    estação = 'Outono'
  } else if (dataHoje >= invernoInicio && dataHoje <= invernoFim) {
    estação = 'Inverno'
  } else if (dataHoje >= primaveraInicio && dataHoje <= primaveraFim) {
    estação = 'Primavera'
  } else {
    estação = 'Verão'
  }

  alert(`Estação atual no hesmifério sul: ${estação}`)
}

estacaoAno()