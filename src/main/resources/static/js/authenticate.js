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

    const loginData = prepareParams({email, password});
    
    fetch('https://example.com/login', {
    method: 'POST',
    body: JSON.stringify(loginData),
    headers: { 'Content-Type': 'application/json' },
    })
    .then(response => response.json())
    .then(data => {
    
        const token = data.token;
        console.log(token);

        document.cookie = `token=${token}; path=/;`;
    })
    .catch(error => console.error(error));
    };

const addSubmitEventListener = () => {
    submitButton.addEventListener('click', onSubmit);
};

addSubmitEventListener();