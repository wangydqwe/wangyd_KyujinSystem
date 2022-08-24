function changeActionToRegister(){
    let s=document.getElementById("login-form")
    s.setAttribute("action", "register.jsp");
}

let btn = document.getElementById("btn");
btn.onclick = function (){
    let handanflag = 0;
    let error = document.getElementById("error");

//mail
    let usermail = document.getElementById("usermail");
    let usermailError = document.getElementById("mail-error")
    function validateEmail(usermail){
        const regex = /^[a-zA-Z\d_-]+@[a-zA-Z\d_-]+(\.[a-zA-Z\d_-]+)+$/
        return regex.test(usermail.value);
    }
    if(usermail.value === ""){
        usermailError.innerHTML = "mailを入力して下さい"
        usermailError.style.display = "inline"
        handanflag = 1;
    }else if (!validateEmail(usermail)){
        usermailError.innerHTML = "mailの格式は不正です。"
        usermailError.style.display = "inline"
        handanflag = 1;
    }  else {
        usermailError.style.display = "none"
    }
//password
    let userpassword = document.getElementById("userpassword")
    let passwordError = document.getElementById("password-error")
    function validatePass(userpassword){
        const regex =  /^(?!\d+$)(?![a-zA-Z]+$)[\dA-Za-z\\W]{6,18}$/
        return regex.test(userpassword.value);
    }
    if(userpassword.value === ""){
        passwordError.innerHTML = "パスワードを入力して下さい"
        passwordError.style.display = "inline"
        handanflag = 1;
    }else if (!validatePass(userpassword)){
        passwordError.innerHTML = "パスワードの格式は不正です。"
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