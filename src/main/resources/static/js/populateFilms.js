const apiURL = "https://ghibliapi.herokuapp.com/films"
function populatePage(films){
    localStorage["films"] = JSON.stringify(films);
    for(obj of films){
        let film = document.createElement('div');
        film.innerHTML = `<div class="card">
                              <center>
                                  <img src="images/${obj.title}.jpg" style="
                                            height: 360px;
                                            width: relative;">
                              <button id="${obj.title}" value="${obj.title}">${obj.title}</button>
                              </center>
                          </div>`;
        document.getElementById("films-container").append(film);
        let button = document.getElementById(obj.title);
        button.addEventListener("click", getDetail.bind(null, event, obj.title));
    }
}
function getDetail(e, title) {
    console.log(title);
    const buttons = document.getElementsByTagName("button");

    document.getElementById("films-container").innerHTML = `<h1> ${title} </h1>
                                                            <button id="backButton">All films</button>`;
    let backButton = document.getElementById("backButton");
    backButton.addEventListener("click", function() { window.location.reload() })
}

(()=>{
    fetch(apiURL)
        .then((res) => res.json())
        .then((films) => populatePage(films));
})();