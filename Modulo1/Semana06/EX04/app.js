const retornoEmpresa1 = new Promise((resolve, reject) =>
  setTimeout(resolve, 5000, 'Empresa 1')
)
const retornoEmpresa2 = new Promise((resolve, reject) =>
  setTimeout(resolve, 3000, 'Empresa 2')
)

Promise.race([retornoEmpresa1, retornoEmpresa2]).then(result => {
  console.log(result)
})
