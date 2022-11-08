const users = []

async function getUsers() {
  const response = await fetch('https://randomuser.me/api/?results=4')
  const result = await response.json()

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

await getUsers()

displayUsers(users)
