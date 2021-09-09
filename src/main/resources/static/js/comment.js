const actionURL = `${window.location.href.substr(0, window.location.href.indexOf('?'))}`;
const reviewURL = "http://" + window.location.hostname + ":" + window.location.port + window.location.pathname + "/review";
const commentURL = "http://" + window.location.hostname + ":" + window.location.port + window.location.pathname + "/comments";


function populateReview(review){
    document.getElementById("currentReview").innerHTML =
    `<h4>by: ${review.user.username} &emsp; rating: ${review.rating}</h4>
        <hr>
    <p>${review.content}</p>`;
}
function populateComments(comments) {
    for(comment of comments) {
        let post = document.createElement('div');
        post.className = "commentContent";
        post.innerHTML = `<h4>${comment.user.username}</h4>
                            <p>${comment.content}</p>`

        document.getElementById("allComments").append(post);
    }
}

window.onload = () => {
console.log(window.location.href + "/review");
    fetch(reviewURL)
        .then((res) => res.json())
        .then((review) => {
            populateReview(review)
            fetch(commentURL)
                .then((res) => res.json())
                .then((comments) => populateComments(comments));
        })
    document.getElementById("commentForm").action = actionURL;
};