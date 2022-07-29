function changeActionToRegister(){
    let s=document.getElementById("login-form")
    s.setAttribute("action", "register.jsp");
}

let btn = document.getElementById("btn");
btn.onclick = function (){
    let handanflag = 0;
//mail
    let usermail = document.getElementById("usermail");
    let usermailError = document.getElementById("mail-error")
    if(usermail.value === ""){
        usermailError.innerHTML = "mailを入力して下さい"
        usermailError.style.display = "inline"
        handanflag = 1;
    } else {
        usermailError.style.display = "none"
    }
//password
    let userpassword = document.getElementById("userpassword")
    let passwordError = document.getElementById("password-error")

    if(userpassword.value === ""){
        passwordError.innerHTML = "パスワードを入力して下さい"
        passwordError.style.display = "inline"
        handanflag = 1;
    }else {
        passwordError.style.display = "none"
    }
    if (handanflag === 0){
        var formElement = document.forms[0];
    }
    formElement.submit();
}