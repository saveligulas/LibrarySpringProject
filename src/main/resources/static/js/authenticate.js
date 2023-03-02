const emailHolder = document.querySelector('#email');
const passwordHolder = document.querySelector('#password');

const submitButton = document.querySelector('#cta');

const prepareParams = params => ({
    email: params.email,
    password: params.password
});

const onSubmit = () => {
    const email = emailHolder.value;
    const password = passwordHolder.value;

    const data = prepareParams({email, password});
    const options = {
        method: 'POST',
        body: JSON.stringify(data),
        Headers: {
            'Content-type': 'application/json'
        }
    };
    
    fetch('http://localhost:8080/auth/post/authenticate', options)
    .then(response => response.json)
    .then(console.log(response));

    console.log(options);
};

const addSubmitEventListener = () => {
    submitButton.addEventListener('click', onSubmit);
};

addSubmitEventListener();