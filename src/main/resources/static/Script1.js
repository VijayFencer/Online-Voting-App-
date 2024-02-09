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