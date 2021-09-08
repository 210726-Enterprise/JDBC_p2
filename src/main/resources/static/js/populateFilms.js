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
//function getDetail(e, title) {
//    console.log(title);
//    const buttons = document.getElementsByTagName("button");
//
//    document.getElementById("films-container").innerHTML = `<h1> ${title} </h1>
//                                                            <button id="backButton">All films</button>`;
//    let backButton = document.getElementById("backButton");
//    backButton.addEventListener("click", function() { window.location.reload() })
//}

(()=>{
    fetch(apiURL)
        .then((res) => res.json())
        .then((films) => populatePage(films));
})();