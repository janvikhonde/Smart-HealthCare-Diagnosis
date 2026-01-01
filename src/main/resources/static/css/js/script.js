// =======================
// Smart Healthcare - Main Script
// =======================

// ---------- Utility Functions ----------
function showLoading(elementId) {
    const element = document.getElementById(elementId);
    if (element) element.innerHTML = '<div class="loading-spinner"></div>';
}

function hideLoading(elementId) {
    const element = document.getElementById(elementId);
    if (element) element.innerHTML = '';
}

function validateEmail(email) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

function validatePhone(phone) {
    return /^[+]?[\d\s-()]+$/.test(phone) && phone.replace(/\D/g, '').length >= 10;
}

function scrollToElement(elementId) {
    const element = document.getElementById(elementId);
    if (element) element.scrollIntoView({ behavior: 'smooth', block: 'start' });
}

function formatDate(dateString) {
    const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
    return new Date(dateString).toLocaleDateString('en-US', options);
}

// ---------- Notification System ----------
function showNotification(message, type = 'info') {
    const notification = document.createElement('div');
    notification.className = `notification notification-${type}`;
    notification.textContent = message;

    Object.assign(notification.style, {
        position: 'fixed',
        top: '20px',
        right: '20px',
        padding: '1rem 1.5rem',
        borderRadius: '10px',
        fontSize: '15px',
        fontWeight: '500',
        boxShadow: '0 5px 20px rgba(0,0,0,0.15)',
        zIndex: '9999',
        animation: 'slideIn 0.3s ease-out',
        background:
            type === 'success' ? '#d1fae5' :
            type === 'error' ? '#fee2e2' : '#e0f2fe',
        color:
            type === 'success' ? '#065f46' :
            type === 'error' ? '#991b1b' : '#1e3a8a'
    });

    document.body.appendChild(notification);

    setTimeout(() => {
        notification.style.animation = 'slideOut 0.3s ease-out';
        setTimeout(() => notification.remove(), 300);
    }, 3000);
}

// ---------- Animations ----------
const style = document.createElement('style');
style.textContent = `
    .loading-spinner {
        border: 4px solid #f3f3f3;
        border-top: 4px solid #00bcd4;
        border-radius: 50%;
        width: 30px;
        height: 30px;
        animation: spin 1s linear infinite;
        margin: 20px auto;
    }

    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }

    @keyframes slideIn {
        from { transform: translateX(100%); opacity: 0; }
        to { transform: translateX(0); opacity: 1; }
    }

    @keyframes slideOut {
        from { transform: translateX(0); opacity: 1; }
        to { transform: translateX(100%); opacity: 0; }
    }
`;
document.head.appendChild(style);

// ---------- 🌍 Live Location & Hospital Fetch ----------
function getNearbyHospitals() {
    if (!navigator.geolocation) {
        showNotification("Geolocation not supported by your browser.", "error");
        return;
    }

    showNotification("Fetching your location...", "info");

    navigator.geolocation.getCurrentPosition(
        position => {
            const lat = position.coords.latitude;
            const lon = position.coords.longitude;

            showNotification("Location detected! Searching nearby hospitals...", "success");

            fetch(`/nearby-hospitals?lat=${lat}&lon=${lon}&radius=10`)
                .then(response => response.json())
                .then(data => {
                    if (data.length > 0) {
                        showNotification(`${data.length} hospitals found near you.`, "success");
                        displayHospitals(data);
                    } else {
                        showNotification("No hospitals found nearby.", "info");
                    }
                })
                .catch(() => showNotification("Error fetching hospital data.", "error"));
        },
        error => {
            console.error(error);
            showNotification("Please allow location permission to find hospitals.", "error");
        }
    );
}

// ---------- 🎙️ Voice Recognition (AI Input) ----------
let recognition;
function initVoiceInput(targetInputId) {
    if (!('webkitSpeechRecognition' in window)) {
        showNotification("Voice input not supported in this browser.", "error");
        return;
    }

    recognition = new webkitSpeechRecognition();
    recognition.continuous = false;
    recognition.interimResults = false;
    recognition.lang = 'en-US';

    recognition.onstart = () => showNotification("🎤 Listening... Speak now", "info");

    recognition.onresult = (event) => {
        const transcript = event.results[0][0].transcript;
        const input = document.getElementById(targetInputId);
        if (input) input.value = transcript;
        showNotification("✅ Voice input captured successfully.", "success");
    };

    recognition.onerror = () => showNotification("Voice recognition error. Try again.", "error");
    recognition.onend = () => showNotification("🎧 Voice input ended.", "info");

    recognition.start();
}

// ---------- Initialization ----------
document.addEventListener('DOMContentLoaded', () => {
    console.log('✅ Smart Healthcare Platform Ready');

    // Highlight active nav link
    const currentPath = window.location.pathname;
    document.querySelectorAll('.nav-links a').forEach(link => {
        if (link.getAttribute('href') === currentPath) {
            link.classList.add('active-link');
        }
    });
});

// ---------- Exports ----------
window.showNotification = showNotification;
window.scrollToElement = scrollToElement;
window.formatDate = formatDate;
window.getNearbyHospitals = getNearbyHospitals;
window.initVoiceInput = initVoiceInput;
