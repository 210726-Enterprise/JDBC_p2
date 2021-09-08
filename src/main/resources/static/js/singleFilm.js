const infoURL = `${window.location.href.substr(0, window.location.href.indexOf('?'))}/detail`;
const reviewsURL = `${window.location.href.substr(0, window.location.href.indexOf('?'))}/reviews`;

function populateFilm(film){
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
//    document.getElementById("filmReviews").innerHTML = `<div>
//                                                            <button>User Reviews</button>
//                                                        </div>`
}
function populateReviews(reviews) {
    for(review of reviews) {
        let post = document.createElement("div")
        post.className = "reviewContent";
        post.innerHTML = `<h4>by: ${review.user.username} &emsp; rating: ${review.rating}</h4>
                            <hr>
                          <p>${review.content}</p>`;
        document.getElementById("filmReviews").append(post);
    }
}
(()=>{
    fetch(infoURL)
        .then((res) => res.json())
        .then((film) => {
            console.log(film);
            populateFilm(film)
            fetch(reviewsURL)
                .then((res) => res.json())
                .then((reviews) => populateReviews(reviews));
        })
})();