document.addEventListener("DOMContentLoaded", function () {
    var navLinks = document.querySelectorAll('.nav-item');
    navLinks.forEach(function (link) {
        link.addEventListener('click', function () {
            navLinks.forEach(function (link) {
                link.classList.remove('active');
            });
            link.classList.add('active');
        });
    });
});

$(document).ready(function(){
    $("#register").click(function(){
        $("#register-form").fadeIn("fast");
    });
});

$(document).ready(function(){
    $("#login").click(function(){
        $("#Login-form").fadeIn("fast");
    });
});


function setHome(){
    document.getElementById('register-form').style.display = 'none';
    document.getElementById('Login-form').style.display = 'none';
}

function setLogin(){
    document.getElementById('register-form').style.display = 'none';
    sessionStorage.setItem('login', 'true');
    sessionStorage.removeItem('register');
}
 function setRegis(){
    document.getElementById('Login-form').style.display = 'none';
    sessionStorage.setItem('register', 'true');
     sessionStorage.removeItem('login');
 }
function closenav() {
    document.getElementById('navbar-btn').click();
}

document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', () => closenav());
  });
document.getElementById('home').addEventListener('click', () => setHome());
document.getElementById('login').addEventListener('click',()=>setLogin());
document.getElementById('register').addEventListener('click',()=>setRegis());

function  checklog(){
    var storedValue =  sessionStorage.getItem('login') === 'true'
    if(storedValue===true)
    {
        document.getElementById('login').click();
        document.getElementById('Login-form').style.display='flex';
        setLogin();
        closenav();
    }
    var storedValu=sessionStorage.getItem('register')==='true';
    if(storedValu===true)
    {
        document.getElementById('register').click();
        document.getElementById('register-form').style.display='flex';
        setRegis();
        closenav();
    }
}
window.onload=checklog;

