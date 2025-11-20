function fetchUsers() {
    fetch('/api/users')
        .then(res => res.json())
        .then(users => {
            const tbody = document.querySelector("#usersTable tbody");
            tbody.innerHTML = '';
            users.forEach(u => {
                const tr = document.createElement('tr');
                tr.innerHTML =
                    `<td>${u.id}</td>
                     <td>${u.username}</td>
                     <td>${u.email}</td>
                     <td>${u.roles ? u.roles.join(",") : ""}</td>
                     <td>
                        <!-- Add edit/delete as needed -->
                     </td>`;
                tbody.appendChild(tr);
            });
        });
}
fetchUsers();
