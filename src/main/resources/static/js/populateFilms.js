console.log(window.location.origin);
const apiURL = "https://ghibliapi.herokuapp.com/films"
console.log(apiURL);

function populatePage(films){
    for(obj of films){
        let film = document.createElement('div');
        film.innerHTML = `<div class="card">
                              <center>
                              <a href="filmDetail">
                                  <img src="images/${obj.title}.jpg" style="
                                            height: 360px;
                                            width: relative;">
                              </a>
                              </center>
                          </div>`;

        document.getElementById("films-container").append(film);
    }
}
(()=>{
    fetch(apiURL)
        .then((res) => res.json())
        .then((films) => populatePage(films));
})();