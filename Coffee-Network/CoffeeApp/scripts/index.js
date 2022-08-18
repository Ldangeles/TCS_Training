document.addEventListener('DOMContentLoaded', function() {

    const COFFEE_API = 'http://localhost:8080/posts';
    const token = sessionStorage.getItem("token");

    if(token==null){
      location.replace("./login.html")
      return;
    }
  
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

    const $logout = document.getElementById("logout");
    $logout.addEventListener('click', function(){
        sessionStorage.removeItem("token");
        location.reload();
    });


    const $addPost = document.getElementById('addPost');
    $addPost.addEventListener('submit', function(event){
      event.preventDefault(); //Cancelamos el refresh de la pagina (Condicion de carrera)
      
      const formData = new FormData($addPost); //Object which accepts a form object
      const jsonData = Object.fromEntries(formData.entries());

      console.log(JSON.stringify(jsonData));

      fetch(COFFEE_API,{
        method: 'POST', 
        body: JSON.stringify(jsonData),
        headers: {
          "Authorization": token,
          "Content-Type": "application/json"}
      }).then(function(){
        location.reload();
      }).catch(function(){
        console.error("Post failed to create")
      });

  });


  
  });