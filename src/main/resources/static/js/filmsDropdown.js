const apiURL = "https://ghibliapi.herokuapp.com/films"

function populateDropdown(films){
    for(obj of films){
        let option = document.createElement('option');
        option.setAttribute("value", obj.title);
        console.log(option);
        option.innerHTML = `${obj.title}`;
        document.getElementById("selectFilm").append(option);
    }
}

(()=>{
    fetch(apiURL)
        .then((res) => res.json())
        .then((films) => populateDropdown(films));
})();