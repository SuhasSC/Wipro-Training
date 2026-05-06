const API_URL = "https://jsonplaceholder.typicode.com/users";

// this function runs when page loads
// it fetches all employees and displays them
async function loadEmployees() {
  try {
    const response = await fetch(API_URL);

    // convert response into json
    const data = await response.json();

    // render data in table
    displayEmployees(data);

  } catch (error) {
    console.error("error fetching employees:", error);
  }
}


// this function takes employee data and shows it in table
function displayEmployees(employees) {

  const table = document.getElementById("employeeTable");

  // clear old data before inserting new
  table.innerHTML = "";

  // loop over each employee
  employees.map(emp => {

    // create row dynamically
    const row = `
      <tr>
        <td>${emp.name}</td>
        <td>${emp.email}</td>
        <td>${emp.company?.name || "N/A"}</td>

        <td>
          <!-- edit button will prefill form -->
          <button class="btn btn-warning btn-sm" onclick="editEmployee(${emp.id}, '${emp.name}', '${emp.email}')">
            edit
          </button>

          <!-- delete button -->
          <button class="btn btn-danger btn-sm" onclick="deleteEmployee(${emp.id})">
            delete
          </button>
        </td>
      </tr>
    `;

    // append row to table
    table.innerHTML += row;
  });
}


// this function handles add + update both
async function saveEmployee() {

  const id = document.getElementById("empId").value;
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;

  // basic validation
  if (!name || !email) {
    alert("please fill all fields");
    return;
  }

  try {
    // if id exists → update
    if (id) {

      await fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ name, email })
      });

      alert("employee updated");

    } else {

      // otherwise create new employee
      await fetch(API_URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ name, email })
      });

      alert("employee added");
    }

    // reset form after operation
    document.getElementById("empId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";

    document.getElementById("formTitle").innerText = "add employee";

    // reload table
    loadEmployees();

  } catch (error) {
    console.error("error saving employee:", error);
  }
}


// this function fills form with existing data for editing
function editEmployee(id, name, email) {

  document.getElementById("empId").value = id;
  document.getElementById("name").value = name;
  document.getElementById("email").value = email;

  // change title to show update mode
  document.getElementById("formTitle").innerText = "update employee";
}


// this function deletes employee
async function deleteEmployee(id) {

  const confirmDelete = confirm("are you sure you want to delete?");

  if (!confirmDelete) return;

  try {
    await fetch(`${API_URL}/${id}`, {
      method: "DELETE"
    });

    alert("employee deleted");

    // refresh data
    loadEmployees();

  } catch (error) {
    console.error("error deleting employee:", error);
  }
}


// initial load
loadEmployees();