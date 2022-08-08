let btn = document.getElementById("btn");
btn.onclick = function (){
    let handanflag = 0;
//type
    let type1 = document.getElementById("type1").checked
    let type2 = document.getElementById("type2").checked
    let typeError = document.getElementById("type-error")

    if (!type1 && !type2){
        handanflag = 1;
        typeError.innerHTML = "個人または企業を選択してください。"
    }
    let username = document.getElementById("username")
    let usernameError = document.getElementById("username-error")

//username
    function validateUsername(username){
        const regex = /^[a-zA-Z\d_-]{4,20}$/
        return regex.test(username.value);
    }
    if (username.value === ""){
        usernameError.innerHTML = "ユーザー名を入力して下さい"
        usernameError.style.display = "inline"
        handanflag = 1;
    }else if (!validateUsername(username)){
        usernameError.innerHTML = "ユーザーの格式は不正です。"
        usernameError.style.display = "inline"
        handanflag = 1;
    }else {
        usernameError.style.display = "none"
    }
//usermail
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
    } else {
        usermailError.style.display = "none"
    }
//userpassword
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
        passwordError.innerHTML = "passwordの格式は不正です。"
        passwordError.style.display = "inline"
        handanflag = 1;
    }else {
        passwordError.style.display = "none"
    }
//kakunin
    let kakunin = document.getElementById("kakunin");
    let kakuninError = document.getElementById("kakunin-error")
    if(kakunin.value === ""){
        kakuninError.innerHTML = "確認パスワードを入力して下さい"
        kakuninError.style.display = "inline"
        handanflag = 1;
    }else if (kakunin.value !== userpassword.value){
        kakuninError.innerHTML = "確認パスワードとパスワードは不一致です。"
        kakuninError.style.display = "inline"
        handanflag = 1;
    }else {
        kakuninError.style.display = "none"
    }
    if (handanflag === 0){
        var formElement = document.forms[0];
    }
    formElement.submit();
}


