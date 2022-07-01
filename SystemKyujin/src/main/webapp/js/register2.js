let submit = document.getElementById("register-form");
let username = document.getElementById("username");
let usermail = document.getElementById("usermail");
let userpassword = document.getElementById("userpassword");
let kakunin = document.getElementById("kakunin");


let btn = document.getElementById("btn");
btn.onclick = function (){

    //username
    if (username.value !== ""){
        return true;
    }else {
        username.nextElementSibling.innerHTML = "ユーザー名を入力して下さい";
    }

    return false;
}