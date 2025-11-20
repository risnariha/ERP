function fetchCourses() {
    fetch('/api/courses')
        .then(res => res.json())
        .then(courses => {
            const tbody = document.querySelector("#coursesTable tbody");
            tbody.innerHTML = '';
            courses.forEach(c => {
                const tr = document.createElement('tr');
                tr.innerHTML =
                    `<td>${c.id}</td>
                     <td>${c.name}</td>
                     <td>${c.description}</td>
                     <td>${c.faculty}</td>
                     <td>
                        <button onclick="deleteCourse(${c.id})">Delete</button>
                     </td>`;
                tbody.appendChild(tr);
            });
        });
}

function deleteCourse(id) {
    fetch(`/api/courses/${id}`, { method: 'DELETE' })
        .then(() => fetchCourses());
}

document.getElementById('addCourseForm').onsubmit = function(e) {
    e.preventDefault();
    const course = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
        faculty: document.getElementById('faculty').value
    };
    fetch('/api/courses', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(course)
    }).then(res => {
        if (res.ok) {
            fetchCourses();
            document.getElementById('courseError').innerText = '';
        } else {
            document.getElementById('courseError').innerText = 'Error adding course.';
        }
    });
};

fetchCourses();
