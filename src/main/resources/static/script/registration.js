document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    let experience = document.getElementById('experience').value;
    let errorMessage = document.getElementById('errorMessage');
    
    if (password.length < 6) {
        errorMessage.textContent = "Password must be at least 6 characters long.";
        return;
    }
    
    alert("Registration successful! Welcome, " + name + "!");
    document.getElementById('registrationForm').reset();
});