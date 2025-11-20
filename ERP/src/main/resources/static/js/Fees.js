function fetchFees() {
    fetch('/api/fees')
        .then(res => res.json())
        .then(feesList => {
            const tbody = document.querySelector("#feesTable tbody");
            tbody.innerHTML = '';
            feesList.forEach(fee => {
                const tr = document.createElement('tr');
                tr.innerHTML =
                    `<td>${fee.id}</td>
                     <td>${fee.studentId}</td>
                     <td>${fee.amount}</td>
                     <td>${fee.status}</td>
                     <td>
                        <button onclick="deleteFee(${fee.id})">Delete</button>
                     </td>`;
                tbody.appendChild(tr);
            });
        });
}

function deleteFee(id) {
    fetch(`/api/fees/${id}`, { method: 'DELETE' })
        .then(() => fetchFees());
}

document.getElementById('addFeeForm').onsubmit = function(e) {
    e.preventDefault();
    const fee = {
        studentId: document.getElementById('studentId').value,
        amount: document.getElementById('amount').value,
        status: document.getElementById('status').value
    };
    fetch('/api/fees', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(fee)
    }).then(res => {
        if (res.ok) {
            fetchFees();
            document.getElementById('feeError').innerText = '';
        } else {
            document.getElementById('feeError').innerText = 'Error adding fee.';
        }
    });
};

fetchFees();
