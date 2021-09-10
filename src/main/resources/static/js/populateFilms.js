const apiURL = "https://ghibliapi.herokuapp.com/films"
function populatePage(films){
    for(obj of films){
        let film = document.createElement('div');
        film.innerHTML = `<div class="card">
                              <center>
                              <form action="/Ghiblihub/films/title/${obj.title}" method="GET">
                                  <img src="images/${obj.title}.jpg" style="
                                            height: 360px;
                                            width: relative;">
                                  <br>
                                  <input type="submit" value="More"/>
                              </form>
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