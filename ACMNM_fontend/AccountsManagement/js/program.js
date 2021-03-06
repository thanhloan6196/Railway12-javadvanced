$(function () {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");

    var userInfo = JSON.parse(localStorage.getItem('userInfo'));

    var sPath = window.location.pathname;
    var sPage = sPath.substring(sPath.lastIndexOf('/') + 1);
    if (sPage == "login.html") {

    } else {
        if (userInfo === "undefined" || userInfo === null) {
            window.location.replace("http://127.0.0.1:5500/html/login.html");
            return;
        }
    }
    
    getListAccounts(0, 'id');
    getListDepartment();
    getListPosition();
    fillDataToSelection();
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListAccounts() {
    $(".main").load("viewlistaccounts.html");
    buildTable();
}

var accounts = [];
var departments = [];
var positions = [];
var pageNumber = 0;
var totalPage = 0;
var sortCollum = "id";
var userInfo = {};


function Account(id, email, userName, fullName, createDate) {
    this.id = id;
    this.email = email;
    this.userName = userName;
    this.fullName = fullName;
    this.createDate = createDate;
}

function getListAccounts(page, collum) {
    var userInfo = JSON.parse(localStorage.getItem('userInfo'));

    $.ajax({
        url: "http://localhost:8080/account/account-list?page=" + page + "&collum=" + collum,
        type: 'GET',
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        },
        data: {},
        success: function (data, status) {
            totalPage = data.totalPages;
            pageNumber = data.number;
            parseData(data.content);
            fillAccountsToTable();
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
    accounts = data;

}

function fillPageable() {
    $('.pagination').empty();
    if(totalPage < 2) return;
    $('.pagination').append(
        '<li class="page-item"><a class="page-link" onclick="goPrePage()" tabindex="-1">Previous</a></li>'
    );
    for (let index = 0; index < totalPage; index++) {
        if(index === pageNumber){
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
function goToPage(index){
    getListAccounts(index, sortCollum);
}
function goToNextPage(){
    if((pageNumber+1)===totalPage) return;
    getListAccounts(++pageNumber, sortCollum);
}
function goPrePage(){
    if((pageNumber)===0) return;
    getListAccounts((--pageNumber, sortCollum));
}




function fillAccountsToTable() {
    $('tbody').empty();
    accounts.forEach(function (item) {        
        $('tbody').append(
            '<tr>' +

            '<td>' + item.email + '</td>' +
            '<td>' + item.userName + '</td>' +
            '<td>' + item.fullName + '</td>' +
            '<td>' + item.department.departmentName + '</td>' +
            '<td>' + item.position.positionName + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    getListAccounts(0, 'id');
    getListDepartment();
    getListPosition();
}

function openAddModal() {
    fillDateToSelectOption();
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("email").value = "";
    document.getElementById("username").value = "";
    document.getElementById("fullname").value = "";
    document.getElementById("position").value = "1";
    document.getElementById("department").value = "1";
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

function addAccount() {

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

    if(email === ""){
        $('#email-err').append(
            "Email kh??ng ???????c tr???ng, h??y nh???p Email"
        )
        return;
    } else {
        $('#email-err').empty();
    }

    if(!validateEmail(email)){
        $('#email-err').append(
            "Email kh??ng ????ng ?????nh d???ng. H??y nh???p l???i email")
            return;
    }

    if(userName === ""){
        $('#username-err').append(
            "UserName kh??ng ???????c tr???ng, h??y nh???p UserName"
        )
        return;
    } else {
        $('#username-err').empty();
    }

    if(fullName === ""){
        $('#fullname-err').append(
            "Full Name kh??ng ???????c tr???ng, h??y nh???p Full Name"
        )
        return;
    } else {
        $('#fullname-err').empty();
    }

    var account = {
        email: email,
        userName: userName,
        fullName: fullName,
        department: department,
        position: position
    };

    var userInfo = JSON.parse(localStorage.getItem('userInfo'));
    $.ajax({
        url: 'http://localhost:8080/account/create',
        type: 'POST',

        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        },


        data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            if(data === "EMAIL"){
                $('#email-err').append(
                    "Email ???? t???n t???i, h??y nh???p email kh??c!"
                )
                return;
            }
            if(data === "USERNAME"){
                $('#username-err').append(
                    "Username ???? t???n t???i, h??y nh???p Username kh??c!"
                )
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
        addAccount();
    } else {
        updateAccount();
    }
}

function updateAccount() {
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

    if(email === ""){
        $('#email-err').append(
            "Email kh??ng ???????c tr???ng, h??y nh???p Email"
        )
        return;
    } else {
        $('#email-err').empty();
    }

    if(!validateEmail(email)){
        $('#email-err').append(
            "Email kh??ng ????ng ?????nh d???ng. H??y nh???p l???i email")
            return;
    }

    if(userName === ""){
        $('#username-err').append(
            "UserName kh??ng ???????c tr???ng, h??y nh???p UserName"
        )
        return;
    } else {
        $('#username-err').empty();
    }

    if(fullName === ""){
        $('#fullname-err').append(
            "Full Name kh??ng ???????c tr???ng, h??y nh???p Full Name"
        )
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
        url: 'http://localhost:8080/account/update',
        type: 'POST',

        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        },


        data: JSON.stringify(account),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {

            if(data === "EMAIL"){
                $('#email-err').append(
                    "Email ???? t???n t???i, h??y nh???p email kh??c!"
                )
                return;
            }
            if(data === "USERNAME"){
                $('#username-err').append(
                    "Username ???? t???n t???i, h??y nh???p Username kh??c!"
                )
                return;
            }


            // success
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
    var index = accounts.findIndex(x => x.id == id);
    var fullName = accounts[index].fullName;

    var result = confirm("B???n c?? ch???c ch???n mu???n x??a " + fullName + " kh??ng?");
    if (result) {
        deleteAccount(id);
    }
}

function deleteAccount(id) {
    // TODO validate
    var account = {
        id: id
    };

    var userInfo = JSON.parse(localStorage.getItem('userInfo'));
    $.ajax({
        url: 'http://localhost:8080/account/delete',
        type: 'POST',

        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        },


        data: JSON.stringify(account),
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


function getListDepartment() {
    var userInfo = JSON.parse(localStorage.getItem('userInfo'));
    $.ajax({
    url: "http://localhost:8080/department/department-list",
        type: 'GET',
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        },
        data: {},
        success: function (data, status) {
            departments = data;
        },
        error: function () {
            alert("Error when loading data");
            return;
        },
    });
}


function getListPosition() {
    var userInfo = JSON.parse(localStorage.getItem('userInfo'));
    $.ajax({
        url: "http://localhost:8080/position/position-list",
            type: 'GET',
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
            },
            data: {},
            success: function (data, status) {
                positions = data;
            },
            error: function () {
                alert("Error when loading data");
                return;
            },
        });
}

function fillDateToSelectOption() {
    $('#department').empty();
    $('#position').empty();
    departments.forEach(function (item) {
        $('#department').append(
            "<option value=" + item.id + ">" + item.departmentName + "</option>")
    });
    positions.forEach(function (item) {
        $('#position').append(
            "<option value=" + item.id + ">" + item.positionName + "</option>")
    });
}


function fillDataToSelection() {
    $('#search-department').empty();
    $('#search-position').empty();

    $('#search-department').append(
        "<option value=''>" + "Ch???n ph??ng ban" + "</option>");
    $('#search-position').append(
        "<option value=''>" + "Ch???n v??? tr??" + "</option>");

    departments.forEach(function (item) {
        $('#search-department').append(
            "<option value=" + item.id + ">" + item.departmentName + "</option>")
    });
    positions.forEach(function (item) {
        $('#search-position').append(
            "<option value=" + item.id + ">" + item.positionName + "</option>")
    });
}

function search(page) {
    var email = document.getElementById("search-email").value;
    var userName = document.getElementById("search-username").value;
    var fullName = document.getElementById("search-fullname").value;
    var departmentID = document.getElementById("search-department").value;
    var positionID = document.getElementById("search-position").value;

    var account = {
        page: page,
        email: email,
        userName: userName,
        fullName: fullName,
        departmentID: departmentID,
        positionID: positionID
    };


    var userInfo = JSON.parse(localStorage.getItem('userInfo'));
    $.ajax({
        url: 'http://localhost:8080/account/search',
        type: 'POST',

        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + userInfo.accessToken);
        },


        data: JSON.stringify(account),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            // success
            // reset list account
            accounts = [];

            // success
            // parseData(data);
            // fillAccountsToTable();

            totalPage = data.totalPages;
            pageNumber = data.number;
            parseData(data.content);
            fillAccountsToTable();
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

function sort(collum){
    sortCollum = collum;
    getListAccounts(pageNumber, collum);
}


function login() {
    var loginUserName = document.getElementById("login-username").value;
    var loginPassword = document.getElementById("login-password").value;

    var loginRequest = {
        username: loginUserName,
        password: loginPassword
    };

    $.ajax({
        url: 'http://localhost:8080/api/auth/signin',
        type: 'POST',
        data: JSON.stringify(loginRequest),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            localStorage.setItem('userInfo', JSON.stringify(data));
           // userInfo = JSON.parse(localStorage.getItem('userInfo'));
            window.location.replace("http://127.0.0.1:5500/html/program.html");
            getListAccounts(0, 'id');
            getListDepartment();
            getListPosition();
            fillDataToSelection();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}


function logOut(){
    localStorage.removeItem('userInfo');
    window.location.replace("http://127.0.0.1:5500/html/login.html");
}