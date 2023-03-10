function displayTime() {
  const date = new Date()
  const hours = date.getHours()
  const minutes = date.getMinutes()
  const seconds = date.getSeconds()

  console.log(`${hours}:${minutes}:${seconds}`)
}

const interval = setInterval(displayTime, 2000)

setTimeout(() => clearInterval(interval), 20000)
