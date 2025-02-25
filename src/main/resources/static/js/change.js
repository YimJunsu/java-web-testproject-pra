// changepa.html에서 patientid 읽기
const urlParams = new URLSearchParams(window.location.search);
const patientid = urlParams.get('patientid');
console.log(patientid); // URL에서 가져온 patientid


const getMyInfo =()=>{
    fetch(`/patient/view?patientid=${patientid}`,{method : 'GET'})
        .then(r=>r.json())
        .then( data => {
            if( data != ''){
                document.querySelector('.nameInput').value = data.name;
                document.querySelector('.birthdateInput').value = data.birthdate;
                document.querySelector('.phoneInput').value = data.phone;
                document.querySelector('.addressInput').value = data.address;
            }
        }).catch( e => { console.log(e) })
}           
getMyInfo();

const onUpdate = () => {
    let phone = document.querySelector('.phoneInput').value;
    let address = document.querySelector('.addressInput').value;

    const urlParams = new URLSearchParams(window.location.search);
    const patientid = urlParams.get('patientid');

    if (!patientid) {
        alert('환자 ID가 없습니다.');
        return;
    }

    let dataObj = { patientid: patientid, phone: phone, address: address }

    const option = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dataObj)
    }

    fetch('/patient/change', option)
        .then(response => response.json())
        .then(data => {
            if (data) {
                alert('수정 성공');
                location.href = "/wjqtn.html";
            } else {
                alert('수정 실패');
            }
        }).catch(e => {
            console.log(e);
        })
}

