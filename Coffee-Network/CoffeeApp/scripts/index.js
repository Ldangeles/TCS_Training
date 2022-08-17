document.addEventListener('DOMContentLoaded', function() {

    const COFFEE_API = 'http://localhost:8080/posts';
    const token = sessionStorage.getItem("token");

    if(token==null){
      location.replace("./login.html")
      return;
    }
  
    const $logout = document.getElementById("logout");
    const $main = document.getElementById('main');
  
    fetch(COFFEE_API, 
      {headers: {
        "Authorization": token
      }}).then(function(response) {
        return response.json();
      }).then(function(posts) {
        const postsHtml = posts.map(function (post) {
          return `
            <article class="card">
              <p>${post.user.username}</p>
              <p>${post.content}</p>
            </article>
          `;
        });
        $main.innerHTML = postsHtml.join('');
      })

    $logout.addEventListener('click', function(){
        sessionStorage.removeItem("token");
        location.reload();
    });
  
  });