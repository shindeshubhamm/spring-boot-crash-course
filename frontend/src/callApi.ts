export function callApi() {
  fetch("http://localhost:8080/api/content")
    .then((response) => {
      const resJson = JSON.stringify(response);
      return resJson;
    })
    .catch(console.log);
}
