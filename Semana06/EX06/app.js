async function getAverageAge(name) {
  const response = await fetch(
    `https://api.agify.io/?country_id=BR&name=${name}`
  )

  const result = await response.json()

  console.log(`Nome: ${name}, Idade média: ${result.age}`)
}

getAverageAge('saull')
