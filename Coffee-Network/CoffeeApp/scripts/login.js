

document.addEventListener('DOMContentLoaded', function(){

    const SIGNUP_API = 'http://localhost:8080/signup';
    const $signUpForm = document.getElementById('signup');

    const LOGIN_API = 'http://localhost:8080/login';
    const $logInForm = document.getElementById('login');

    $signUpForm.addEventListener('submit', function(event){
        event.preventDefault(); //Cancelamos el refresh de la pagina (Condicion de carrera)
        
        const formData = new FormData($signUpForm); //Object which accepts a form object
        const jsonData = Object.fromEntries(formData.entries());

        /*for (let entry of data.entries()){ //Prints entries inside data form
            console.log(entry);
        }*/
        fetch(SIGNUP_API,
            {method: 'POST', 
            body: JSON.stringify(jsonData),
            headers: {"Content-Type": "application/json"}
        }).then(function(response){
            console.log("Account created succesfully")
            login(jsonData);
        }).catch(function(){
            console.error("Attempt failed")
        });

    });

    function login(credentials){
        fetch(LOGIN_API,
            {method: 'POST', 
            body: JSON.stringify(credentials),
            headers: {"Content-Type": "application/json"}
        }).then(function(response){
            return response.json();
        }).then(function(auth){
            sessionStorage.setItem("token", auth.token)
            location.replace("./index.html");
        }).catch(function(){
            console.error("LogIn Denied")
        });
    }

    $logInForm.addEventListener('submit', function(event){
        event.preventDefault(); //Cancelamos el refresh de la pagina (Condicion de carrera)
        
        const formData = new FormData($logInForm); //Object which accepts a form object
        const jsonData = Object.fromEntries(formData.entries());

        login(jsonData);

    });

});