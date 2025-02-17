document.addEventListener("DOMContentLoaded", function () {
    const paymentMethod = document.getElementById("payment-method");
    const cardDetails = document.getElementById("card-details");
    const cardNumberDisplay = document.querySelector(".card-number-display");
    const cardNameDisplay = document.querySelector(".card-name-display");
    
    paymentMethod.addEventListener("change", function () {
        if (paymentMethod.value === "credit-card") {
            cardDetails.classList.remove("hidden");
        } else {
            cardDetails.classList.add("hidden");
        }
    });

    document.getElementById("card-number").addEventListener("input", function () {
        cardNumberDisplay.textContent = this.value || "**** **** **** ****";
    });

    document.getElementById("card-name").addEventListener("input", function () {
        cardNameDisplay.textContent = this.value || "Cardholder Name";
    });

    document.getElementById("payment-form").addEventListener("submit", function (event) {
        event.preventDefault();
        alert("✅ Payment successfully processed!");
    });
});

    
