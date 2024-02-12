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


function setUpdate(){
    document.getElementById('updatepage').style.display="flex";
    document.getElementById('homepage').style.display="none";
    document.getElementById('votepage').style.display="none";
}

function setHome(){
    document.getElementById('homepage').style.display="flex";
    document.getElementById('updatepage').style.display="none";
    document.getElementById('votepage').style.display="none";
}

function setVote(){
    document.getElementById('votepage').style.display='flex';
    document.getElementById('updatepage').style.display="none";
    document.getElementById('homepage').style.display="none";

}

document.getElementById('update').addEventListener('click', () => setUpdate());
document.getElementById('home').addEventListener('click', () => setHome());
document.getElementById('vote').addEventListener('click',()=> setVote());