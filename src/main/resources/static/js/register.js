const firstNameHolder = document.querySelector('#firstName');
const lastNameHolder = document.querySelector('#lastName');
const emailHolder = document.querySelector('#email');
const passwordHolder = document.querySelector('#password');

const submitButton = document.querySelector('#cta');

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

    const data = prepareParams({firstName, lastName, email, password});
    const options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-type': 'application/json'
        }
    };

    fetch('http://localhost:8080/auth/post/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(function(response) {
        // Handle success response
    })
    .catch(function(error) {
        // Handle error response
    });
    
    //fetch('http://localhost:8080/auth/post/register', options);

    console.log(options);
};

const addSubmitEventListener = () => {
    submitButton.addEventListener('click', onSubmit);
};

addSubmitEventListener();