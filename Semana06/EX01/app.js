function sleep(valor) {
  return new Promise((res, rej) => {
    setTimeout(() => res(valor), 3000)
  })
}

sleep('Ok!').then(result => {
  console.log(result)
})
