async function showBitcoinPrice() {
  const response = await fetch('https://api.coincap.io/v2/assets/bitcoin')

  const result = await response.json()
  const { symbol, priceUsd } = result.data

  console.log(`O preço do Bitcoin - ${symbol} em dólares hoje é $${priceUsd}`)
}

showBitcoinPrice()
