const API_URL = "https://jsonplaceholder.typicode.com/users";

// load employees when page opens
async function loadEmployees() {
try {
const res = await fetch(API_URL);

if (!res.ok) {
  throw new Error("API error");
}

const employees = await res.json();
console.log("DATA:", employees);

showEmployees(employees);

} catch (err) {
console.error("Error fetching data:", err);
alert("Failed to load employees");
}
}

// display employees in table
function showEmployees(list) {
const table = document.getElementById("employeeTable");
table.innerHTML = "";

list.forEach(emp => {
const row = `
  <tr>
    <td>${emp.name}</td>
    <td>${emp.email}</td>
    <td>${emp.company?.name || "N/A"}</td>
    <td>
      <button class="btn btn-warning btn-sm"
        onclick="editEmployee(${emp.id}, '${emp.name}', '${emp.email}')">
        Edit
      </button>

      <button class="btn btn-danger btn-sm"
        onclick="deleteEmployee(${emp.id})">
        Delete
      </button>
    </td>
  </tr>
`;

table.innerHTML += row;

});
}

// add or update employee
async function saveEmployee() {
const id = document.getElementById("empId").value;
const name = document.getElementById("name").value;
const email = document.getElementById("email").value;

if (!name || !email) {
alert("Please fill all fields");
return;
}

const data = { name, email };

try {
if (id) {
await fetch(`${API_URL}/${id}`, {
method: "PUT",
headers: { "Content-Type": "application/json" },
body: JSON.stringify(data)
});
alert("Updated successfully");
} else {
  await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data)
  });
  alert("Added successfully");
}

// reset form
document.getElementById("empId").value = "";
document.getElementById("name").value = "";
document.getElementById("email").value = "";
document.getElementById("formTitle").innerText = "Add Employee";

loadEmployees();

} catch (err) {
console.error("Error saving:", err);
}
}

// edit employee
function editEmployee(id, name, email) {
document.getElementById("empId").value = id;
document.getElementById("name").value = name;
document.getElementById("email").value = email;

document.getElementById("formTitle").innerText = "Update Employee";
}

// delete employee
async function deleteEmployee(id) {
if (!confirm("Are you sure?")) return;

try {
await fetch(`${API_URL}/${id}`, { method: "DELETE" });
alert("Deleted successfully");

loadEmployees();

} catch (err) {
console.error("Error deleting:", err);
}
}

// initial load
loadEmployees();
