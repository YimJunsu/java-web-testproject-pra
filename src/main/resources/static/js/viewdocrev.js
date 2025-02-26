const urlParams = new URLSearchParams(window.location.search);
const doctorid = urlParams.get('doctorid');
console.log(doctorid);

const viewall = () =>{
    fetch(`/reservation/viewalldoctor?doctorid=${doctorid}` , {method : 'GET'})
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