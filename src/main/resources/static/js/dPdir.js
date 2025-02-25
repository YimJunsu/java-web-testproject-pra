const viewall = () => {
    fetch("/reservation/viewall", { method: 'GET' })
        .then(r => r.json())
        .then(d => {
            const tbody = document.querySelector('.tbody');
            let html = '';
            let list = d;
            list.forEach(obj => {
                html += `<tr>
                    <td>${obj.reservationid}</td>
                    <td>${obj.reservationdate}</td>
                    <td>${obj.reservationtime}</td>
                    <td>${obj.doctorName}선생님</td>
                    <td>${obj.patientName}님</td>
                    <td>${obj.status}</td>
                    <td><button onclick="changeStatus(${obj.reservationid}, ${obj.status})">상태 변경</button></td>
                    <th><button onclick="remove(${obj.reservationid})">삭제</button></td>
                </tr>`;
            });
            tbody.innerHTML = html;
        })
        .catch(e => { console.log(e) });
}

const changeStatus = (reservationId, currentStatus) => {
    const newStatus = !currentStatus; 
    const reservationDto = {reservationid: reservationId,status: newStatus};

    fetch("/reservation/change", 
        { method: 'PUT',headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(reservationDto)
    })
    .then(response => response.json())
    .then(data => {
        alert("변경완료")
        viewall();
    })
    .catch(error => {
        alert('상태 변경에 실패했습니다.');
    });
}
viewall(); // 페이지 로드 시 예약 목록 가져오기

function remove(reservationid){
    fetch(`/reservation/remove?reservationid=${reservationid}`, { method: "DELETE" })
        .then(r => r.json())
        .then(d => {
            console.log(d);
            if (d === true) {
                alert("삭제완료");
                location.href = "/dPdir.html";
            } else {
                alert("삭제 실패");
            }
        })
        .catch(e => { console.log(e) });
}

