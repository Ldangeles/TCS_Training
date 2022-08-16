window.addEventListener('DOMContentLoaded', function(){

    const mainElement = document.getElementById("main");
    const prevButton = this.document.getElementById("prev")
    const nextButton = this.document.getElementById("next")
    const pageCounter = this.document.getElementById("page")

    let pageNumber = 1;
    
    function loadCharacter(url){
        fetch(url)
            .then(function (response) {
                return response.json();
            })
            .then(function(resultsPage) {
                const html = resultsPage.results.
                    map(function(result){
                        return `
                        <article>
                            <h2 id="name">${result.name.toLowerCase()}</h2>
                            <table> <!-- Tabla -->
                                <tr>
                                    <td><strong>Height:</strong></td>
                                    <td>${result.height/100}m</td>
                                </tr>
                                <tr>
                                    <td><strong>Weight:</strong></td>
                                    <td>${result.mass}kg</td>
                                </tr>
                                <tr>
                                    <td><strong>Gender:</strong></td>
                                    <td>${result.gender}</td>
                                </tr>
                                <tr>
                                    <td><strong>Year of Birth:</strong></td>
                                    <td>${result.birth_year}</td>
                                </tr>
                                <tr>
                                    <td><strong>Hair Color:</strong></td>
                                    <td>${result.hair_color}</td>
                                </tr>
                                <tr>
                                    <td><strong>Eye Color:</strong></td>
                                    <td>${result.eye_color}</td>
                                </tr>
                            </table>
                        </article>`;
                    });
                
                mainElement.innerHTML = html.join("");

                pageCounter.innerHTML = pageNumber;

                if(resultsPage.previous == null){
                    prevButton.disabled = true;
                    prevButton.onclick = null;
                } else {
                    prevButton.disabled = false;
                    prevButton.onclick = function(){
                        pageNumber--;
                        loadCharacter(resultsPage.previous)
                    };
                }

                if(resultsPage.next == null){
                    nextButton.disabled = true;
                    nextButton.onclick = null;
                } else {
                    nextButton.disabled = false;
                    nextButton.onclick = function(){
                        pageNumber++;
                        loadCharacter(resultsPage.next)
                    };
                }


            });
    }

    loadCharacter("https://swapi.dev/api/people")
});