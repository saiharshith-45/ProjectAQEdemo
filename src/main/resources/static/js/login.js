/**
 * 
 */
function validateLogin(event) {
    event.preventDefault();
    
    const employees = {
        "206333": { name: "Harshith Sai", password: "206333" },
        "206334": { name: "Sandeep", password: "206334" },
        "206335": { name: "Arjun", password: "206335" },
        "206337": { name: "Hemanjali", password: "206337" },
        "206344": { name: "Sreya", password: "206344" }
    };
    
    const employeeId = document.querySelector('input[name="employeeId"]').value;
    const password = document.querySelector('input[name="password"]').value;

    if (employees[employeeId] && employees[employeeId].password === password) {
        const employeeName = employees[employeeId].name;
        window.location.href = `/welcome?employeeName=${employeeName}`;
    } else {
        alert("Invalid login credentials");
    }
}
