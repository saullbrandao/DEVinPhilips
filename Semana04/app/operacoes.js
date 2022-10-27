const operationSelect = document.querySelector('#operation')
const valueInput = document.querySelector('#value')

operationSelect.addEventListener('change', (event) => {
  if (event.target.value === 'balance') {
    valueInput.value = ''
    valueInput.disabled = true
  } else {
    valueInput.disabled = false
  }
})
