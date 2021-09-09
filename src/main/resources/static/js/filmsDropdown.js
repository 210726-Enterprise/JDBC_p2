const apiURL = "https://ghibliapi.herokuapp.com/films"

function populateDropdown(films){
    document.getElementById("selectFilm").addEventListener('change', (event) => {console.log(event.target.value)})
    for(obj of films){
        let option = document.createElement('option');
        option.setAttribute("value", obj.title);
        console.log(option);
        option.innerHTML = `${obj.title}`;
        document.getElementById("selectFilm").append(option);
    }
    console.log(document.getElementById("selectFilm").value);
}

(()=>{
    fetch(apiURL)
        .then((res) => res.json())
        .then((films) => populateDropdown(films));
})();