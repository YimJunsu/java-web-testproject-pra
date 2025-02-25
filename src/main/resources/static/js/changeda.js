// changepa.html에서 patientid 읽기
const urlParams = new URLSearchParams(window.location.search);
const doctorid = urlParams.get('doctorid');
console.log(doctorid); 


const getMyInfo =()=>{
    fetch(`/doctor/view?doctorid=${doctorid}`,{method : 'GET'})
        .then(r=>r.json())
        .then( data => {
            if( data != ''){
                document.querySelector('.phone').value = data.phone;
                document.querySelector('.name').value = data.name;
                document.querySelector('.specialty').value = data.specialty;
                
            }
        }).catch( e => { console.log(e) })
}           
getMyInfo();

const onUpdate = () => {
    let name = document.querySelector('.name').value;
    let specialty = document.querySelector('.specialty').value;

    const urlParams = new URLSearchParams(window.location.search);
    const doctorid = urlParams.get('doctorid');

    if (!doctorid) {
        alert('의사 ID가 없습니다.');
        return;
    }

    let dataObj = { doctorid: doctorid, name: name, specialty: specialty}

    const option = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dataObj)
    }

    fetch('/doctor/change', option)
        .then(response => response.json())
        .then(data => {
            if (data) {
                alert('수정 성공');
                location.href = "/doctor.html";
            } else {
                alert('수정 실패');
            }
        }).catch(e => {
            console.log(e);
        })
}