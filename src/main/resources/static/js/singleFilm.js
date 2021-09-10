const actionURL = `${window.location.href.substr(0, window.location.href.indexOf('?'))}`;
const infoURL = "http://" + window.location.hostname + ":" + window.location.port + window.location.pathname + "/detail";
const reviewsURL = "http://" + window.location.hostname + ":" + window.location.port + window.location.pathname + "/reviews";

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
                                 &#8226; Movie Length: <strong>${film.running_time} minutes</strong>
                             </p>
                         </section>
                     </div>`;
    document.getElementById("filmName").innerHTML = `${film.title}`;
}

function populateReviews(reviews) {
    for(review of reviews) {
        let post = document.createElement("div")
        post.className = "reviewContent";
        post.innerHTML = `<div class="innerReviewContent">
                          <h4>by: ${review.user.username} &emsp; rating: ${review.rating}</h4>
                            <hr>
                          <p>${review.content}</p>
                          </div>
                          <form action="/Ghiblihub/films/title/${review.film.title}/${review.reviewId}" method="GET">
                              <input type="submit" value="Comments"/>
                          </form>`;
        document.getElementById("filmReviews").append(post);
    }
}
function reload() { window.location.reload() };
(()=>{
    console.log(window.location.href + "/detail");
    console.log(window.location.href + "/reviews");
    fetch(infoURL)
        .then((res) => res.json())
        .then((film) => {
            console.log(film);
            populateFilm(film)
            fetch(reviewsURL)
                .then((res) => res.json())
                .then((reviews) => populateReviews(reviews));
        })
    document.getElementById("reviewForm").action = actionURL;
})();