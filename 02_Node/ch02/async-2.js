// Call Back
const order = (coffee, callback) => {
  console.log(`${coffee} 주문 접수`);
  setTimeout(() => {
    callback(coffee);
  }, 3000);
};

const display = (result) => console.log(`${result} Complete!`);

// order('Americano', display);

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
