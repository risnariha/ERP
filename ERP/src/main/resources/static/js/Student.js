// Assumes REST endpoints /api/students (GET, POST, DELETE)
function fetchStudents() {
    fetch('/api/students')
        .then(res => res.json())
        .then(students => {
            const tbody = document.querySelector("#studentsTable tbody");
            tbody.innerHTML = '';
            students.forEach(s => {
                const tr = document.createElement('tr');
                tr.innerHTML =
                    `<td>${s.id}</td>
                     <td>${s.name}</td>
                     <td>${s.email}</td>
                     <td>${s.department}</td>
                     <td>${s.year}</td>
                     <td>
                        <button onclick="deleteStudent(${s.id})">Delete</button>
                     </td>`;
                tbody.appendChild(tr);
            });
        });
}

function deleteStudent(id) {
    fetch(`/api/students/${id}`, { method: 'DELETE' })
        .then(() => fetchStudents());
}

document.getElementById('addStudentForm').onsubmit = function(e) {
    e.preventDefault();
    const student = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        department: document.getElementById('department').value,
        year: document.getElementById('year').value
    };
    fetch('/api/students', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(student)
    }).then(res => {
        if (res.ok) {
            fetchStudents();
            document.getElementById('studentError').innerText = '';
        } else {
            document.getElementById('studentError').innerText = 'Error adding student.';
        }
    });
};

fetchStudents();
