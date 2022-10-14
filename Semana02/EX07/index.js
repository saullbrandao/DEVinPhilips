function estacaoAno() {
    const dataHoje = new Date()
    const outonoInicio = new Date(`${dataHoje.getFullYear()}/03/22`)
    const outonoFim = new Date(`${dataHoje.getFullYear()}/06/21`)
    const invernoInicio = new Date(`${dataHoje.getFullYear()}/06/22`)
    const invernoFim = new Date(`${dataHoje.getFullYear()}/09/21`)
    const primaveraInicio = new Date(`${dataHoje.getFullYear()}/09/22`)
    const primaveraFim = new Date(`${dataHoje.getFullYear()}/12/21`)
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