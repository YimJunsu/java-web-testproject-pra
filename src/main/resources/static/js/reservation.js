document.addEventListener('DOMContentLoaded', function() {
    // 의사 목록과 환자 목록을 서버에서 받아오기
    fetchDoctors();
    fetchPatients();
});

// 의사 목록을 받아와서 select 요소에 추가
function fetchDoctors() {
    fetch("/doctor/viewall")  // 의사 목록을 서버에서 받아옴
        .then(response => response.json())  // JSON 형식으로 파싱
        .then(data => {
            const doctorSelect = document.getElementById("doctorId");
            data.forEach(doctor => {
                const option = document.createElement("option");
                option.value = doctor.doctorid;  // 의사의 ID를 value로 사용
                option.textContent = doctor.name + " 선생님";  // 의사 이름을 텍스트로 표시
                doctorSelect.appendChild(option);  // <select> 요소에 option 추가
            });
        })
        .catch(error => console.error('Error fetching doctors:', error));
}

// 환자 목록을 받아와서 select 요소에 추가
function fetchPatients() {
    fetch("/patient/viewall")  // 환자 목록을 서버에서 받아옴
        .then(response => response.json())  // JSON 형식으로 파싱
        .then(data => {
            const patientSelect = document.getElementById("patientId");
            data.forEach(patient => {
                const option = document.createElement("option");
                option.value = patient.patientid;  // 환자의 ID를 value로 사용
                option.textContent = patient.name + "님";  // 환자 이름을 텍스트로 표시
                patientSelect.appendChild(option);  // <select> 요소에 option 추가
            });
        })
        .catch(error => console.error('Error fetching patients:', error));
}

function reservation(event) {
    event.preventDefault();

    // 선택된 환자ID, 의사ID를 문자열로 받아온 후 int로 변환
    const patientid = parseInt(document.querySelector('.patientid').value);
    const doctorid = parseInt(document.querySelector('.doctorid').value);
    const reservationdate = document.querySelector('.reservationdate').value;
    const reservationtime = document.querySelector('.reservationtime').value;

    // 만약 ID가 없는 경우 처리
    if (isNaN(patientid) || isNaN(doctorid)) {
        alert("환자와 의사를 선택해주세요.");
        return;
    }

    console.log(patientid);  // patientid 값 출력
    console.log(doctorid);   // doctorid 값 출력
    console.log(reservationdate);  // 예약 날짜 출력
    console.log(reservationtime);  // 예약 시간 출력

    const obj = {
        patientid: patientid,
        doctorid: doctorid,
        reservationdate: reservationdate,
        reservationtime: reservationtime
    };

    const option = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(obj)
    };

    fetch("/reservation/upload", option)
        .then(r => r.json())
        .then(d => {
            console.log(d);  // 서버에서 반환된 데이터 출력
            if (d === true) {
                alert("예약 성공");
                location.href = "/dPdir.html";
            } else {
                alert("예약 실패");
            }
        })
        .catch(e => {
            console.log(e);
        });
}
