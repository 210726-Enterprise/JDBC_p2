console.log(window.location.origin);
const apiURL = "https://ghibliapi.herokuapp.com/films"
console.log(apiURL);

function populatePage(films){
    for(obj of films){
        let film = document.createElement('div');
        film.innerHTML = `<h2>${obj.title}</h2>`;

        document.getElementById("films-container").append(film);
    }
}
(()=>{
    fetch(apiURL)
        .then((res) => res.json())
        .then((films) => populatePage(films));
})();