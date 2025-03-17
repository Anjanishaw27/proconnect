function toggleAnswer(element) {
    let answer = element.querySelector("p");
    answer.style.display = answer.style.display === 'none' ? 'block' : 'none';
}

// Optional: Smooth hover effect for better UX
document.querySelectorAll('.card').forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.classList.add('hovered');
    });
    card.addEventListener('mouseleave', () => {
        card.classList.remove('hovered');
    });
});