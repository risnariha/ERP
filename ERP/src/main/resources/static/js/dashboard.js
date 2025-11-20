window.onload = function() {
    // You may fetch user info with JWT here
    document.getElementById('welcome').textContent = "Welcome to the ERP Dashboard!";
};

function logout() {
    // Implement your JWT/session clearing logic here (e.g., localStorage.clear())
    window.location.href = "login.html";
}
