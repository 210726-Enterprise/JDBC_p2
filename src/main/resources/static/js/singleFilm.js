const apiURL = `${window.location.href.substr(0, window.location.href.indexOf('?'))}/detail`;
console.log(apiURL);
function populatePage(film){
    console.log(film.title);
    document.getElementById("singleFilm").innerHTML = `<div class="innerWrapper">
                         <div class="image">
                             <img src="../../images/${film.title}.jpg" style="
                                             height: 360px;
                                             width: relative;">
                         </div>
                         <section class="detailInfo">
                             <h4 style="font-size: 24px;">
                                 Directed by: ${film.director}
                             </h4>
                             <hr>
                             <p style="font-size: 24px;">${film.description}</p>
                             <p style="font-size: 24px;">
                                 Year of Publication: <strong>${film.release_date}</strong>
                                 &#8226; Movie Length: <strong>${film.run_time}</strong>
                             </p>
                         </section>
                     </div>`;
    document.getElementById("filmName").innerHTML = `${film.title}`;
}
(()=>{
    fetch(apiURL)
        .then((res) => res.json())
        .then((films) => populatePage(films));
})();