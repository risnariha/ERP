document.getElementById('loginForm').onsubmit = async function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const resp = await fetch('/api/auth/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password})
    });
    if (resp.ok) {
        // You might want to store JWT here or redirect
        window.location.href = "/";
    } else {
        document.getElementById('loginError').innerText = "Login failed. Please check your credentials.";
    }
};
