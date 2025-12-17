// const eventSource = new EventSource("/placar-backend/api/realtime");

// eventSource.addEventListener("placar", function (event) {
//     const data = JSON.parse(event.data);

//     atualizarTodos(".placarA", data.placarA);
//     atualizarTodos(".placarB", data.placarB);
// });

// eventSource.onerror = () => {
//     const status = document.getElementById("status-conexao");
//     status.innerText = " Desconectado";
//     status.classList.remove("online");
//     status.classList.add("offline");
// };

// function atualizarTodos(selector, valor) {
//     document.querySelectorAll(selector).forEach(el => {
//         el.innerText = valor;
//         el.classList.add("atualizado");

//         setTimeout(() => {
//             el.classList.remove("atualizado");
//         }, 300);
//     });
// }
