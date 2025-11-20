function fetchAttendance() {
    fetch('/api/attendance')
        .then(res => res.json())
        .then(records => {
            const tbody = document.querySelector("#attendanceTable tbody");
            tbody.innerHTML = '';
            records.forEach(a => {
                const tr = document.createElement('tr');
                tr.innerHTML =
                    `<td>${a.id}</td>
                     <td>${a.studentId}</td>
                     <td>${a.date}</td>
                     <td>${a.status}</td>
                     <td>
                        <button onclick="deleteAttendance(${a.id})">Delete</button>
                     </td>`;
                tbody.appendChild(tr);
            });
        });
}

function deleteAttendance(id) {
    fetch(`/api/attendance/${id}`, { method: 'DELETE' })
        .then(() => fetchAttendance());
}

document.getElementById('addAttendanceForm').onsubmit = function(e) {
    e.preventDefault();
    const record = {
        studentId: document.getElementById('studentId').value,
        date: document.getElementById('date').value,
        status: document.getElementById('status').value
    };
    fetch('/api/attendance', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(record)
    }).then(res => {
        if (res.ok) {
            fetchAttendance();
            document.getElementById('attendanceError').innerText = '';
        } else {
            document.getElementById('attendanceError').innerText = 'Error adding attendance.';
        }
    });
};

fetchAttendance();
