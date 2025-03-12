// Call Back
const order = (coffee, callback) => {
  console.log(`${coffee} 주문 접수`);
  setTimeout(() => {
    callback(coffee);
  }, 3000);
};

const display = (result) => console.log(`${result} Complete!`);

// order('Americano', display);

//callback hell
function displayLetter() {
  console.log('A');
  setTimeout(() => {
    console.log('A');
    setTimeout(() => {
      console.log('B');
    }, 1000);
    setTimeout(() => {
      console.log('C');
    }, 1000);
    setTimeout(() => {
      console.log('D');
    }, 1000);
    setTimeout(() => {
      console.log('stop');
    }, 1000);
  }, 1000);
}
displayLetter();

// Promise
let likePizza = false;
const pizza = new Promise((resolve, reject) => {
  if (likePizza) {
    resolve('order pizza');
  } else {
    reject('fuck you pizza');
  }
});

pizza.then((result) => console.log(result)).catch((err) => console.log(err));

// async/await
async function init() {
  const response = await fetch('https://jsonplaceholder.typicode.com/users');
  const users = await response.json();
  console.log(users);
}
init();
