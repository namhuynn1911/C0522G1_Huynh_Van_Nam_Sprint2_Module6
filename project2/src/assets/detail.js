window.onload = function detail (){

//   // Quantity selector

  let minusButton = document.getElementById('minus');
  let plusButton = document.getElementById('plus');
  let inputField = document.getElementById('quantity');
  let priceUnit = document.getElementById('price-unit');
  let priceTotal = document.getElementById('price-total');
  let total = inputField.value * priceUnit.innerText;
  priceTotal.innerHTML = total;

  minusButton.addEventListener('click', event => {
    event.preventDefault();
    let currentValue = Number(inputField.value) || 0;
    currentValue != 0 ? inputField.value = currentValue - 1 : inputField.value = 0;
    priceTotal.innerHTML = (currentValue-1) * priceUnit.innerText;
  });

  plusButton.addEventListener('click', event => {
    event.preventDefault();
    let currentValue = Number(inputField.value) || 0;
    inputField.value = currentValue + 1;
    priceTotal.innerHTML = (currentValue+1) * priceUnit.innerText;
  });

// Color selector

  function productSelector() {
    let opt1 = document.getElementById('option1');
    let opt2 = document.getElementById('option2');
    let image1 = document.getElementById('image1');
    let image2 = document.getElementById('image2');

    if (opt1.checked) {
      image2.classList.add('hidden');
      image1.classList.remove('hidden');
    } else if (opt2.checked) {
      image1.classList.add('hidden');
      image2.classList.remove('hidden');
    }
  }

  document.addEventListener('input', function() {
    console.log('teste')
    productSelector();
  })
}
