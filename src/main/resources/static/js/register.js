const firstNameHolder = document.querySelector('#firstName');
const lastNameHolder = document.querySelector('#lastName');
const emailHolder = document.querySelector('#email');
const passwordHolder = document.querySelector('#password');

const submitButton = document.querySelector('#cta');

const messageField = document.getElementById('messageLabel');
const emailField = document.getElementById('email');

const prepareParams = params => ({
    firstName: params.firstName,
    lastName: params.lastName,
    email: params.email,
    password: params.password
});

const onSubmit = () => {
    const firstName = firstNameHolder.value;
    const lastName = lastNameHolder.value;
    const email = emailHolder.value;
    const password = passwordHolder.value;

    if(lastName.length<1 || firstName.length<1){
        messageField.textContent = "Your name cant be empty.";
    }
    if(password.length<8 || !/\d/.test(password) || !/[A-Z]/.test(password)) {
        messageField.textContent = "Your password must be atleast 8 characters long, contain atleast 1 digit and 1 capitalized letter.";
    }

    fetch('http://localhost:8080/validator/email', {
        
    })

    const data = prepareParams({firstName, lastName, email, password});

    fetch('http://localhost:8080/auth/post/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if(!response.ok) {
            return response.json().then(data => {
                throw new Error(`API error: ${data.message}`);
            });
        } else {
        console.log(response);
        messageField.textContent = response.message;
        }
        
    })
    .catch(error => {
        console.error(error);
        messageField.textContent = "Email is already taken!";
        emailField.value = '';
    });
};

const addSubmitEventListener = () => {
    submitButton.addEventListener('click', onSubmit);
};

addSubmitEventListener();