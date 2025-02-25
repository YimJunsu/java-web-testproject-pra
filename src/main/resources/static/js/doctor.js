const viewall = () =>{
    fetch("/doctor/viewall" , {method : 'GET'})
        .then(r => r.json())
        .then(d=>{
            console.log(d);
                const tbody = document.querySelector('.tbody');
                let html = '';
                let list = d;
                list.forEach(obj=>{
                    html += `<tr>
                    <td>${obj.doctorid}</td>
                    <td><a href="javascript:void(0)" onclick="showOffCanvas('${obj.doctorid}')">${obj.name}</a></td>
                    <td>${obj.specialty}</td>
                    <td>${obj.phone}</td>
                    <td>${obj.createdat}</td>
                    </tr>`
                })
                tbody.innerHTML = html;
        })
        .catch(e=>{console.log(e)})
}
viewall();

const showOffCanvas = (doctorid) => {
    // 상세 정보를 오프캔버스에 표시하는 로직
    fetch(`/doctor/view?doctorid=${doctorid}`, { method: 'GET' })
        .then(response => response.json())
        .then(data => {
            const offcanvasBody = document.getElementById('offcanvas-body');
            offcanvasBody.innerHTML = `
                <p><strong>의사 코드:</strong> ${data.doctorid}</p>
                <p><strong>이름:</strong> ${data.name}</p>
                <p><strong>종목:</strong> ${data.specialty}</p>
                <p><strong>전화번호:</strong> ${data.phone}</p>
                <p><strong>가입날짜:</strong> ${data.createdat}</p>

                <button onclick="remove(${data.doctorid})" type="button">의사 삭제</button> 
                <a href="/changeda.html?doctorid=${data.doctorid}" class="btn btn-primary">의사 정보 수정</a>
                `;
            var myOffcanvas = new bootstrap.Offcanvas(document.getElementById('offcanvasScrolling'));
                    myOffcanvas.show();
        })
        .catch(error => console.error('Error fetching patient details:', error));
}

function remove(doctorid) {
    fetch(`/doctor/remove?doctorid=${doctorid}`, {method: 'DELETE',})
    .then(r => r.json())
    .then(d => {
        console.log(d);
        if (d === true) {
            alert("삭제완료");
            location.href = "/doctor.html";
        } else {
            alert("삭제 실패");
        }
    })
    .catch(e => {
        console.log('오류 발생:', e);
    });
}