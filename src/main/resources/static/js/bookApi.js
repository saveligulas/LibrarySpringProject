const jwtCookie = document.cookie
  .split('; ')
  .find(row => row.startsWith('Authorization='));

const jwtToken = jwtCookie ? jwtCookie.split('=')[1] : null;