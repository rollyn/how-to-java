 function sendDelete(event) {
    event.preventDefault();
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", event.target.href);
    xhr.send();
    location.href = '/';
}


function clickBtn() {
    alert("HELLO");
}