function fetchFaculty() {
    fetch('/api/faculty')
        .then(res => res.json())
        .then(facultyList => {
            const tbody = document.querySelector("#facultyTable tbody");
            tbody.innerHTML = '';
            facultyList.forEach(f => {
                const tr = document.createElement('tr');
                tr.innerHTML =
                    `<td>${f.id}</td>
                     <td>${f.name}</td>
                     <td>${f.email}</td>
                     <td>${f.department}</td>
                     <td>
                        <button onclick="deleteFaculty(${f.id})">Delete</button>
                     </td>`;
                tbody.appendChild(tr);
            });
        });
}

function deleteFaculty(id) {
    fetch(`/api/faculty/${id}`, { method: 'DELETE' })
        .then(() => fetchFaculty());
}

document.getElementById('addFacultyForm').onsubmit = function(e) {
    e.preventDefault();
    const faculty = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        department: document.getElementById('department').value
    };
    fetch('/api/faculty', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(faculty)
    }).then(res => {
        if (res.ok) {
            fetchFaculty();
            document.getElementById('facultyError').innerText = '';
        } else {
            document.getElementById('facultyError').innerText = 'Error adding faculty.';
        }
    });
};

fetchFaculty();
