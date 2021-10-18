console.log("News Website");

//API KEY 
// f145e93f9c9042c3be0eebf0abc7746a

let source = "ary-news";
let apiKey = "f145e93f9c9042c3be0eebf0abc7746a";
// Grab the news container
let newsAccordion = document.getElementById("newsAccordion");

//initialize xhr object
let xhr = new XMLHttpRequest();

// Create an ajax GET request
xhr.open("GET","newsAPI.json", true);

// When response is ready 
xhr.onload = function(){
    if(this.status === 200){
        let html = "";
        let json = JSON.parse(this.responseText);
        let jsonArticles = json.articles;
        console.log(jsonArticles);
        jsonArticles.forEach(function(element, index) {
            html += `
<div class="accordion-item">
  <h2 class="accordion-header" id="heading${index}">
    <button class=" btn btn-link" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${index}"
      aria-expanded="true" aria-controls="collapse${index}">
      <b>breaking news ${index + 1}: </b> 
      ${element["title"]}
    </button>
  </h2>
  <div id="collapse${index}" class="accordion-collapse collapse" aria-labelledby="heading${index}"
    data-bs-parent="#newsAccordion">
    <div class="accordion-body">
    ${element["content"]}. <a href = "${element["url"]}" target = "_blank">Read more here</a> 
    </div>
  </div>
</div>
</div>`;
        });
        newsAccordion.innerHTML = html;
    }
    else{
        console.warn("Some error occured");
    }
}

// Send the request
xhr.send();
