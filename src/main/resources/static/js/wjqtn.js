const viewall = () =>{
    fetch("/patient/viewall" , {method : 'GET'})
        .then(r => r.json())
        .then(d=>{
            console.log(d);
                const tbody = document.querySelector('.tbody');
                let html = '';
                let list = d;
                list.forEach(obj=>{
                    html += `<tr>
                    <td>${obj.patientid}</td>
                    <td><a href="javascript:void(0)" onclick="showOffCanvas('${obj.patientid}')">${obj.name}</a></td>
                    <td>${obj.birthdate}</td>
                    <td>${obj.phone}</td>
                    <td>${obj.address}</td>
                    <td>${obj.createdat}</td>
                    </tr>`
                })
                tbody.innerHTML = html;
        })
        .catch(e=>{console.log(e)})
}
viewall();

const showOffCanvas = (patientid) => {
    // 상세 정보를 오프캔버스에 표시하는 로직
    fetch(`/patient/view?patientid=${patientid}`, { method: 'GET' })
        .then(response => response.json())
        .then(data => {
            const offcanvasBody = document.getElementById('offcanvas-body');
            offcanvasBody.innerHTML = `
                <p><strong>환자 코드:</strong> ${data.patientid}</p>
                <p><strong>이름:</strong> ${data.name}</p>
                <p><strong>생년월일:</strong> ${data.birthdate}</p>
                <p><strong>전화번호:</strong> ${data.phone}</p>
                <p><strong>주소:</strong> ${data.address}</p>
                <p><strong>가입날짜:</strong> ${data.createdat}</p>

                <button onclick="remove(${data.patientid})" type="button">환자 삭제</button> <!-- patientid 전달 -->
            `;
            var myOffcanvas = new bootstrap.Offcanvas(document.getElementById('offcanvasScrolling'));
                    myOffcanvas.show();
        })
        .catch(error => console.error('Error fetching patient details:', error));
}

function remove(patientid) {
    fetch(`/patient/remove?patientid=${patientid}`, {
        method: 'DELETE',
    })
    .then(r => r.json())
    .then(d => {
        console.log(d);
        if (d === true) {
            alert("삭제완료");
            location.href = "/wjqtn.html";
        } else {
            alert("삭제 실패");
        }
    })
    .catch(e => {
        console.log('오류 발생:', e);
    });
}
