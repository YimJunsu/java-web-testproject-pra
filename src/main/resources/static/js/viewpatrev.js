// changepa.html에서 patientid 읽기
const urlParams = new URLSearchParams(window.location.search);
const patientid = urlParams.get('patientid');
console.log(patientid); // URL에서 가져온 patientid

const viewall = () =>{
    fetch(`/reservation/viewallpatient?patientid=${patientid}` , {method : 'GET'})
        .then(r => r.json())
        .then(d=>{
            console.log(d);
                const tbody = document.querySelector('.tbody');
                let html = '';
                let list = d;
                list.forEach(obj=>{
                    html += `<tr>
                    <td>${obj.reservationid}</td>
                    <td>${obj.reservationdate}</td>
                    <td>${obj.reservationtime}</td>
                    <td>${obj.status}</td>
                    <td>${obj.doctorName}</td>
                    <td>${obj.patientName}</td>
                    </tr>`
                })
                tbody.innerHTML = html;
        })
        .catch(e=>{console.log(e)})
}
viewall();