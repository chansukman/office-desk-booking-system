function readCookie(value){
    let name = value + "=";
    let cookieArray = document.cookie.split(';');
    for(let i = 0; i < cookieArray.length; i++){
        let cookie = cookieArray[i];
        while(cookie.charAt(0) == ' ') cookie = cookie.substring(1, cookie.length);
        if(cookie.indexOf(name) == 0){
            return cookie.substring(name.length);
        }
    }
    return null;
}

function printCookie(value){
    console.log(readCookie(value))
}

function addUserNameToHeader(){
    let userName = readCookie("userName");
    document.getElementById("user-name").innerText = userName;
}