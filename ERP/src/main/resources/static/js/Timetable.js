function fetchTimetable() {
    fetch('/api/timetable')
        .then(res => res.json())
        .then(entries => {
            const tbody = document.querySelector("#timetableTable tbody");
            tbody.innerHTML = '';
            entries.forEach(tt => {
                const tr = document.createElement('tr');
                tr.innerHTML =
                    `<td>${tt.id}</td>
                     <td>${tt.course}</td>
                     <td>${tt.faculty}</td>
                     <td>${tt.time}</td>`;
                tbody.appendChild(tr);
            });
        });
}
fetchTimetable();
