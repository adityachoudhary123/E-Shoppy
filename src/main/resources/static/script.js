function register()
{
    var id = document.getElementById('register-user-id-input').value;
    var name = document.getElementById('register-user-name-input').value;
    var password = document.getElementById('register-user-password-input').value;
    var confirmPassword = document.getElementById('register-user-confirm-password-input').value;
    if(password == confirmPassword)
    {
        var request = new XMLHttpRequest();
         request.open('POST','//localhost:8080/user',true);
         request.setRequestHeader("Content-Type", "application/json");
         var obj = {
                     "user_ID":id,
                     "name":name,
                     "password":password
         };
         var data = JSON.stringify(obj);
         request.send(data);
         request.onreadystatechange = function() {
             if (this.readyState == 4 && this.status == 200) {
              document.getElementById("show-message").innerHTML = this.responseText;
             }
         };
    }
    else
    {
        document.getElementById("show-message").innerHTML = '*password not matches with confirm password';
    }
}

function searchProduct()
{
    var input = document.getElementById('search-input').value;
    var url = "/search?inp="+input;
    window.location = url;

}

function search()
{
    var url = window.location.href;
    var param = url.split("=");
    document.getElementById('product-display-table').innerHTML = "";
        var request = new XMLHttpRequest();
        request.open('POST','//localhost:8080/search',true);
        request.setRequestHeader("Content-Type", "text/plain");
        request.send(param[1]);
        request.onreadystatechange = function() {
             if (this.readyState == 4 && this.status == 200) {
                 var searchResult = JSON.parse(this.responseText);
                 var table = document.getElementById('product-display-table');
                 var row = table.insertRow(0);
                 row.style.backgroundColor = "lightgrey";
                 var cell1 = row.insertCell(0);
                 var cell2 = row.insertCell(1);
                 var cell3 = row.insertCell(2);
                 var cell4 = row.insertCell(3);
                 var cell5 = row.insertCell(4);
                 cell1.innerHTML = "<h4> Image</h4>";
                 cell2.innerHTML = "<h4> Name</h4>";
                 cell3.innerHTML = "<h4> Brand</h4>";
                 cell4.innerHTML = "<h4> Price</h4>";
                 cell5.innerHTML = "<h4> Wanna Buy</h4>"
                 for(var i = 0; i < searchResult.length; i++)
                 {
                     var obj = searchResult[i];
                     var row = table.insertRow(1);
                     var cell1 = row.insertCell(0);
                     var cell2 = row.insertCell(1);
                     var cell3 = row.insertCell(2);
                     var cell4 = row.insertCell(3);
                     var cell5 = row.insertCell(4);

                     cell1.innerHTML="<img src='/images/products/"+ obj.image_SOURCE+"' height = '150' width = '100'/>";
                     cell2.innerHTML = obj.product_NAME;
                     cell3.innerHTML = obj.brand;
                     cell4.innerHTML = obj.price;
                     cell5.innerHTML = "<div>"+
                    "<button id = 'counter-minus-"+i+"'type = 'button' onclick = 'deleteItem(this.id)'> - </button>"+
                    " &nbsp;&nbsp; <label id= 'count-display-"+i+"'>  0  </label>"+
                    " &nbsp;&nbsp; <button id = 'counter-plus-"+i+"'type = 'button' onclick = 'addItem(this.id)' > + </button>"+
                    "</div>"+
                    "<div>"+
                    "<button id = '" +obj.product_ID +"-" +i+"' type = 'button' onclick = 'addToCart(this.id)'> Add to Cart</button>"+
                    "</div>";

                 }

             }
        };
}
function addItem(id)
{
    var str = id.substring(13);
    str = "count-display-"+str;
    var number = document.getElementById(str).textContent;
    number = parseInt(number)+1;
    document.getElementById(str).innerHTML = number;
}
function deleteItem(id)
{
    var str = id.substring(14);
    str = "count-display-"+str;
        var number = document.getElementById(str).textContent;
        number = parseInt(number)-1;
    if(number >= 0)
        document.getElementById(str).innerHTML = number;
}


function addToCart(id)
{
    var value = id.split("-");
    var prod_Id = value[0];
    var username = sessionStorage.getItem('username');
    str = "count-display-"+value[1];
    var quantityVal = document.getElementById(str).textContent;
    quantityVal = parseInt(quantityVal);
    if(quantityVal <= 0)
    {
        alert("No Item Selected");
    }
    else
    {
        $.ajax({
              url: "//localhost:8080/cart",
              type: "POST",
              data: {
                product_Id: prod_Id,
                username: username,
                quantity: quantityVal,
              },
              success: function(response) {
                alert('product added in the cart!')
              },
              error: function(xhr) {
                alert('Something went wrong.. Please try again!')
              }
        });
    }

}

function displayCart()
{
    var username = sessionStorage.getItem('username');
    var url = "//localhost:8080/cart?username="+username;
    $.ajax({
           url: url,
           type: "GET",
           success: function(response) {
                 var searchResult = response;
                 var table = document.getElementById('cart-display-table');
                 var row = table.insertRow(0);
                 row.style.backgroundColor = "lightgrey";
                 var cell1 = row.insertCell(0);
                 var cell2 = row.insertCell(1);
                 var cell3 = row.insertCell(2);
                 var cell4 = row.insertCell(3);
                 cell1.innerHTML = "<h4> Image</h4>";
                 cell2.innerHTML = "<h4> Name</h4>";
                 cell3.innerHTML = "<h4> Brand</h4>";
                 cell4.innerHTML = "<h4> Price</h4>";
                 for(var i = 0; i < searchResult.length; i++)
                 {
                     var obj = searchResult[i];
                     var row = table.insertRow(1);
                     var cell1 = row.insertCell(0);
                     var cell2 = row.insertCell(1);
                     var cell3 = row.insertCell(2);
                     var cell4 = row.insertCell(3);

                     cell1.innerHTML="<img src='/images/products/"+ obj.image_SOURCE+"' height = '150' width = '100'/>";
                     cell2.innerHTML = obj.product_NAME;
                     cell3.innerHTML = obj.brand;
                     cell4.innerHTML = obj.price;


                 }
                     var button = document.createElement('button');
                     button.innerHTML = "checkout";
                     document.getElementById('check-out-div').appendChild(button);
           },
           error: function(xhr) {
               alert('Something went wrong.. Please try again!')
           }
    });


}
