const users = []

async function getUsers(quantity = 4) {
  if (quantity > 10) {
    quantity = 10
  }

  const response = await fetch(`https://randomuser.me/api/?results=${quantity}`)
  const result = await response.json()

  users.length = 0

  result.results.forEach(user => {
    const newUser = {
      name: `${user.name.title} ${user.name.first} ${user.name.last}`,
      img: user.picture.large,
      email: user.email,
      address: `${user.location.street.name} - ${user.location.street.number} ${user.location.city} - ${user.location.state} - ${user.location.country}`,
    }

    users.push(newUser)
  })
}

function displayUsers(users) {
  const ul = document.getElementById('userList')

  ul.replaceChildren()

  users.forEach(user => {
    const li = document.createElement('li')
    li.innerHTML = `
    <img src="${user.img}" alt="${user.name}'s picture" />
    <div class="user-info" >
    <p>${user.name}</p>
    <p>${user.email}</p>
    <p>${user.address}</p>
    </div>
    `

    li.classList.add('list-item')

    ul.appendChild(li)
  })
}

const searchButton = document.getElementById('searchButton')

searchButton.addEventListener('click', async () => {
  const quantity = Number(document.getElementById('quantity').value)

  await getUsers(quantity)
  displayUsers(users)
})
