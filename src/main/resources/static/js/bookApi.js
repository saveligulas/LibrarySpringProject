const jwtCookie = document.cookie
  .split('; ')
  .find(row => row.startsWith('Authorization='));

const jwtToken = jwtCookie ? jwtCookie.split('=')[1] : null;

console.log(jwtToken);

fetch('http://localhost:8080/api/book', {
    method: 'GET',
    headers: {
        'Authorization': `${jwtToken}`
    }
  })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));