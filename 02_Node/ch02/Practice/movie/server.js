const key = 'a5463b23503122d280758867620e42f8';

async function view() {
  event.preventDefault();
  let date = document.getElementById('date').value;
  let datas = await fetchMovies(date);

  let resDiv = document.getElementById('result');
  if (resDiv.innerHTML != '') {
    resDiv.innerHTML = '';
  }
  if (datas) {
    datas.forEach((movie) => {
      const h1 = document.createElement('h1');
      h1.textContent = `${movie.rank} : ${movie.movieNm}`;
      resDiv.appendChild(h1);
    });
  }
}

async function fetchMovies(date) {
  let url = `http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=${key}&targetDt=${date}`;

  let movies = await fetch(url);
  let data = await movies.json();

  return data.boxOfficeResult.dailyBoxOfficeList;
}

document.addEventListener('DOMContentLoaded', () => {
  let submit = document.getElementById('submit');

  submit.addEventListener('click', view);
});
