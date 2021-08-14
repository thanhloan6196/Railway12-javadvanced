$(function () {
    $(".header").load("header.html");
    $(".main").load("home.html");
    //$(".main").load("login.html");
    $(".footer").load("footer.html");

    getListStudents(0, 'id');
     getListClass();
    // getListPosition();
     fillDataToSelection();

});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListStudents() {
    $(".main").load("viewliststudents.html");
    buildTable();
}

var students = [];
var classes = [];
var pageNumber = 0;
var totalPage = 0;
var sortCollum = "id";
//var userInfo = {};
//const userInfo = {};


function getListStudents(page, collum) {
    $.ajax({
        url: "http://localhost:8080/student/student-list?page=" + page + "&collum=" + collum,
        type: 'GET',
        data: {},
        success: function (data, status) {
            totalPage = data.totalPages;
            pageNumber = data.number;
            parseData(data.content);
            fillStudentsToTable();
            fillDataToSelection();
            fillPageable();
        },
        error: function () {
            alert("Error when loading data");
            return;
        },
    });
}

function parseData(data) {
    students = data;
}
function fillPageable() {
    $('.pagination').empty();
    if (totalPage < 2) return;
    $('.pagination').append(
        '<li class="page-item"><a class="page-link" onclick="goPrePage()" tabindex="-1">Previous</a></li>'
    );
    for (let index = 0; index < totalPage; index++) {
        if (index === pageNumber) {
            $('.pagination').append(
                '<li class="page-item active"><a class="page-link" onclick="goToPage(' + index + ')">' + index + '</a></li>'
            );
        } else {
            $('.pagination').append(
                '<li class="page-item"><a class="page-link" onclick="goToPage(' + index + ')">' + index + '</a></li>'
            );
        }
    }
    $('.pagination').append(
        '<li class="page-item"> <a class="page-link" onclick="goToNextPage()">Next</a></li>'
    );
}
function goToPage(index) {
    // console.log(index)
    getListStudents(index, sortCollum);
}
function goToNextPage() {
    if ((pageNumber + 1) === totalPage) return;
    getListStudents(++pageNumber, sortCollum);
}
function goPrePage() {
    if ((pageNumber) === 0) return;
    getListStudents(--pageNumber, sortCollum);
}
function fillStudentsToTable() {
    $('tbody').empty();
    students.forEach(function (item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.firstName + '</td>' +
            '<td>' + item.lastName + '</td>' +
            '<td>' + item.email + '</td>' +
            '<td>' + item.gender + '</td>' +
            '<td>' + item.address + '</td>' +
            '<td>' + item.clazz.className   + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    getListStudents(0, 'id');
     getListClass();
    // getListPosition();

}



function openAddModal() {
    fillDateToSelectOption();
    resetForm();
    openModal();
}
function fillDataToSelection() {
    $('#search-class').empty();

    $('#search-class').append(
        "<option value=''>" + "Chọn lớp" + "</option>");

    classes.forEach(function (item) {
        $('#search-class').append(
            "<option value=" + item.id + ">" + item.className + "</option>")
    });
}
function fillDateToSelectOption() {
    $('#class').empty();
    classes.forEach(function (item) {
        $('#class').append(
            "<option value=" + item.id + ">" + item.className + "</option>")
    });
}
function getListClass() {
    $.ajax({
        url: "http://localhost:8080/class/class-list",
        type: 'GET',
        data: {},
        success: function (data, status) {
            classes = data;
        },
        error: function () {
            alert("Error when loading data");
            return;
        },
    });
}
function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("email").value = "";
    document.getElementById("firstname").value = "";
    document.getElementById("lastname").value = "";
    document.getElementById("address").value = "";
    document.getElementById("gender").value = "MALE";
    document.getElementById("class").value = "1";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}
function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
function addStudent() {

    // get data
    var email = document.getElementById("email").value;
    var firstName = document.getElementById("firstname").value;
    var lastName = document.getElementById("lastname").value;
    var address = document.getElementById("address").value;
    var gender = document.getElementById("gender").value;
    var classID = document.getElementById("class").value;
    // TODO validate
    // then fail validate ==> return;

    if (email === "") {
        $('#email-err').append(
            "Email không được trống. Hãy nhập email")
        return;
    } else {
        $('#email-err').empty();
    }
    if (!validateEmail(email)) {
        $('#email-err').append(
            "Email không đúng định dạng. Hãy nhập lại email")
        return;
    }
    if (firstName === "") {
        $('#firstName-err').append(
            "firstName không được trống. Hãy nhập firstName")
        return;
    } else {
        $('#firstName-err').empty();
    }
    if (lastName === "") {
        $('#lastName-err').append(
            "lastName không được trống. Hãy nhập lastName")
        return;
    } else {
        $('#lastName-err').empty();
    }
    var classs =  {
        id: classID
    }
    var student = {
        email: email,
        firstName: firstName,
        lastName: lastName,
        gender: gender,
        address: address,
        classID: classs
    };
    $.ajax({
        url: 'http://localhost:8080/student/create',
        type: 'POST',
        data: JSON.stringify(student), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            if (data === "EMAIL") {
                $('#email-err').append(
                    "Email đã tồn tại. Hãy nhập email khác")
                return;
            }
            
            hideModal();
            showSuccessAlert(data);
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openUpdateModal(id) {
    fillDateToSelectOption();
    // get index from account's id
    var index = accounts.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = accounts[index].id;
    document.getElementById("email").value = accounts[index].email;
    document.getElementById("username").value = accounts[index].userName;
    document.getElementById("fullname").value = accounts[index].fullName;
    document.getElementById("department").value = accounts[index].department.id;
    document.getElementById("position").value = accounts[index].position.id;

    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addStudent();
    } else {
        updateStudent();
    }
}

function updateStudent() {
    var id = document.getElementById("id").value;
    // get data
    // get data
    var email = document.getElementById("email").value;
    var userName = document.getElementById("username").value;
    var fullName = document.getElementById("fullname").value;
    var departmentID = document.getElementById("department").value;
    var positionID = document.getElementById("position").value;
    // TODO validate
    // then fail validate ==> return;
    var department = {
        id: departmentID
    }
    var position = {
        id: positionID
    }
    if (email === "") {
        $('#email-err').append(
            "Email không được trống. Hãy nhập email")
        return;
    } else {
        $('#email-err').empty();
    }
    if (!validateEmail(email)) {
        $('#email-err').append(
            "Email không đúng định dạng. Hãy nhập lại email")
        return;
    }
    if (userName === "") {
        $('#username-err').append(
            "userName không được trống. Hãy nhập userName")
        return;
    } else {
        $('#username-err').empty();
    }
    if (fullName === "") {
        $('#fullname-err').append(
            "fullname không được trống. Hãy nhập fullName")
        return;
    } else {
        $('#fullname-err').empty();
    }
    var account = {
        id: id,
        email: email,
        userName: userName,
        fullName: fullName,
        department: department,
        position: position
    };
    var userInfo = JSON.parse(localStorage.getItem('userInfo'));
    $.ajax({
        url: 'http://localhost:8081/account/update',
        type: 'POST',
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        },
        data: JSON.stringify(account),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            // success
            if (data === "EMAIL") {
                $('#email-err').append(
                    "Email đã tồn tại. Hãy nhập email khác")
                return;
            }
            if (data === "USERNAME") {
                $('#username-err').append(
                    "username đã tồn tại. Hãy nhập username khác")
                return;
            }
            hideModal();
            showSuccessAlert(data);
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openConfirmDelete(id) {
    // get index from account's id
    var index = students.findIndex(x => x.id == id);
    var lastName = students[index].lastName;

    var result = confirm("Bạn có chắc chắn muốn xóa " + lastName + " không ?");
    if (result) {
        deleteStudent(id);
    }
}

function deleteStudent(id) {
    // TODO validate
    var student = {
        id: id
    };
    $.ajax({
        url: 'http://localhost:8080/student/delete',
        type: 'POST',
        data: JSON.stringify(student),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            // success
            showSuccessAlert(data);
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function showSuccessAlert(msg) {
    $(".response-alert").empty();
    $(".response-alert").append(msg);
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}

function search(page) {
    var email = document.getElementById("search-email").value;
    var firstName = document.getElementById("search-firstname").value;
    var lastName = document.getElementById("search-lastname").value;
    var address = document.getElementById("search-address").value;
    var gender = document.getElementById("search-gender").value;
    var classId = document.getElementById("search-class").value;

    if(gender === ""){
        var account = {
            page: page,
            email: email,
            firstName: firstName,
            lastName: lastName,
            address: address,
            classId: classId
        };
    } else{
        var account = {
            page: page,
            email: email,
            firstName: firstName,
            lastName: lastName,
            address: address,
            gender: gender,
            classId: classId
        };
    }

    
    $.ajax({
        url: 'http://localhost:8080/student/search',
        type: 'POST',
        data: JSON.stringify(account),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            // success
            // reset list account
            students = [];

            // success
            // parseData(data);
            // fillAccountsToTable();

            totalPage = data.totalPages;
            pageNumber = data.number;
            parseData(data.content);
            fillStudentsToTable();
            fillPageableSearch();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}
function fillPageableSearch() {
    $('.pagination').empty();
    if (totalPage < 2) return;
    $('.pagination').append(
        '<li class="page-item"><a class="page-link" onclick="goPrePageSearch()" tabindex="-1">Previous</a></li>'
    );
    for (let index = 0; index < totalPage; index++) {
        if (index === pageNumber) {
            $('.pagination').append(
                '<li class="page-item active"><a class="page-link" onclick="goToPageSearch(' + index + ')">' + index + '</a></li>'
            );
        } else {
            $('.pagination').append(
                '<li class="page-item"><a class="page-link" onclick="goToPageSearch(' + index + ')">' + index + '</a></li>'
            );
        }
    }
    $('.pagination').append(
        '<li class="page-item"> <a class="page-link" onclick="goToNextPageSearch()">Next</a></li>'
    );
}
function goToPageSearch(index) {
    // console.log(index)
    search(index);
}
function goToNextPageSearch() {
    if ((pageNumber + 1) === totalPage) return;
    search(++pageNumber);
}
function goPrePageSearch() {
    if ((pageNumber) === 0) return;
    search((--pageNumber));
}
function sort(collum) {
    // console.log("name", collum);
    sortCollum = collum;
    getListAccounts(pageNumber, collum);
}

