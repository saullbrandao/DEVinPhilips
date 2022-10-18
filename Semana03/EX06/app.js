const verificaPalindromo = (str) => {
  if (typeof str !== 'string' || str.length === 0) return false

  const strReversa = str.split('')
    .reverse()
    .join('')

  return str === strReversa
}

console.log(verificaPalindromo("ana")); // true

console.log(verificaPalindromo("julia")); // false

console.log(verificaPalindromo(null)); // false
console.log(verificaPalindromo('')); // false
console.log(verificaPalindromo(undefined)); // false