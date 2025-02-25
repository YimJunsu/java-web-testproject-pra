const uploadpi = () => {
    const name = document.querySelector('.name').value;
    const birthdate = document.querySelector('.birthdate').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;

    const obj = { name: name, birthdate: birthdate, phone: phone, address: address };
    
    console.log('Request Payload:', JSON.stringify(obj)); 
    const option = {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(obj)
    };

    fetch("/patient/upload", option)
        .then(r => r.json())
        .then(d => {
            console.log(d);
            if (d === true) {
                alert("등록 성공 입니다.");
                location.href = "/wjqtn.html";
            } else {
                alert("실패 했습니다.");
            }
        })
        .catch(e => {
            console.log(e);
        });
};

const doctorupload = () => {
    const name = document.querySelector('.name').value;
    const specialty = document.querySelector('.specialty').value;
    const phone = document.querySelector('.phone').value;

    const obj = { name: name, specialty: specialty, phone: phone};
    console.log('Request Payload:', JSON.stringify(obj)); 
    const option = {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(obj)
    };

    fetch("/doctor/upload", option)
        .then(r => r.json())
        .then(d => {
            console.log(d);
            if (d === true) {
                alert("등록 성공 입니다.");
                location.href = "/doctor.html";
            } else {
                alert("실패 했습니다.");
            }
        })
        .catch(e => {
            console.log(e);
        });
};
