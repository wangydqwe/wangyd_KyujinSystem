window.onload = function() {

    let rtype = '${rtype}';

    let a1 = document.getElementById("a1")
    let a2 = document.getElementById("a2")
    let a3 = document.getElementById("a3")
    let a4 = document.getElementById("a4")
    let a5 = document.getElementById("a5")

    if (rtype === '1'){
        a1.style.display = "inline"
        a2.style.display = "inline"
        a5.style.display = "inline"
    }else if (rtype === '2'){
        a1.style.display = "inline"
        a3.style.display = "inline"
        a4.style.display = "inline"
    }else {
        a1.style.display = "inline"
        a2.style.display = "inline"
        a3.style.display = "inline"
        a4.style.display = "inline"
        a5.style.display = "inline"
    }
}