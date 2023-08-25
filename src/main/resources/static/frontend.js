const form = document.getElementById('registrationForm');

form.addEventListener('submit', async (event) => {

event.preventDefault();
    const formData = new FormData(form);

    // Convert FormData object to a plain object
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    // Make an HTTP POST request to the server
    try {
    console.log("Calling backend")
        const response = await fetch('/api/users/form-data', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (response.ok) {
            console.log('Data sent successfully');
        } else {
            console.error('Failed to send data');
        }
    } catch (error) {
        console.error('Error:', error);
    }
});