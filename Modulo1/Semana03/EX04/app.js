const mesclaObjetos = (obj1, obj2) => ({ ...obj1, ...obj2 })

const objUm = { a: 1, b: 2 };
const objDois = { c: 3, d: 4 };
const novoObjeto = mesclaObjetos(objUm, objDois);
console.log(novoObjeto);