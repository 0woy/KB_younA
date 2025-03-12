//Promise
/**
let pizza = new Promise((resolve, reject) => {
  resolve('피자를 주문했슴다.');
  reject('피자를 주문 안 했음');
});

// pizza.then((result) => console.log(result)).catch((err) => console.log(err));


let init = new Promise((resolve, reject) => {
  let users = fetch('https://jsonplaceholder.typicode.com/posts?_limit=10');
  resolve(users);
  reject('사용자 못 불러왔슈');
});

function toJson(users) {
  let json = new Promise((resolve, reject) => {
    resolve(users.json());
    reject('json으로 못 바깟어요');
  });
  return json;
}

init
  .then((users) => {
    return toJson(users);
  })
  .then((jsonData) => {
    console.log(jsonData);
  })
  .catch((err) => console.log(err));
 */

document.addEventListener('DOMContentLoaded', () => {
  let btn = document.getElementById('start');
  let resDiv = document.getElementById('result');

  async function fetchPosts() {
    let post = await fetch(
      'https://jsonplaceholder.typicode.com/posts?_limit=10'
    );
    let res = await post.json();
    return res;
  }

  async function displayPosts() {
    resDiv.innerHTML = '<p> 게시글을 불러오는 중 . . . </p>';
    const posts = await fetchPosts();
    resDiv.innerHTML = '';

    if (posts) {
      posts.forEach((post) => {
        const div = document.createElement('div');
        const title = document.createElement('h2');
        const description = document.createElement('p');

        title.textContent = `[${post.title}]`;
        description.textContent = `${post.body}`;

        div.appendChild(title);
        div.appendChild(description);
        div.appendChild(document.createElement('hr'));

        resDiv.appendChild(div);
      });
    }
  }
  btn.addEventListener('click', displayPosts);
});
