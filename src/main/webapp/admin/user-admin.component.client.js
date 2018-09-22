
(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn, $searchBtn;
    var $firstNameFld, $lastNameFld;
    var $userRowTemplate, $tbody;
    var $userRole;
    var userTemplate;
    var userService = new AdminUserServiceClient();
    $(main);


    function main() {
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $userRole = $("#roleFld");
        $createBtn = $("#createBtn");
        $updateBtn = $("#updateBtn");
        $searchBtn = $("#searchBtn");

        userTemplate = $(".wbdv-template.wbdv-hidden").clone();
        $createBtn.click(createUser);
        $searchBtn.click(searchUser);
        renderUsers(findAllUsers());
        

    }
    function createUser() {
        var timestamp = (new Date()).getTime();
        var newUser = {
            id:timestamp,
            username:$usernameFld.val(),
            password:$passwordFld.val(),
            firstName:$firstNameFld.val(),
            lastName:$lastNameFld.val(),
            role:$userRole.val(),
        };
        clearForm()

        userService.createUser(newUser);
        renderUsers(findAllUsers());
    }

    function findAllUsers() {
        return userService.findAllUsers();
    }

    function findUserById(userId) {
        return userService.findUserById(userId);
    }

    function deleteUser(event) {
        var deletButton = $(event.currentTarget);
        var usrRow = deletButton.parents(".wbdv-template");
        var userId = usrRow.attr("id");
        userService.deleteUser(userId);
        usrRow.remove();
        
    }

    function selectUser(event) {
        var editButton = $(event.currentTarget);
        var usrRow = editButton.parents(".wbdv-template");
        var userId = usrRow.attr("id");
        var user = findUserById(userId);
        renderUser(user);
    }

    function updateUser(userID) {
        var updateUser = {
            username:$usernameFld.val(),
            password:$passwordFld.val(),
            firstName:$firstNameFld.val(),
            lastName:$lastNameFld.val(),
            role:$userRole.val()
        }
        userService.updateUser(userID, updateUser);
        clearForm();
        renderUsers(findAllUsers());
    }

    function renderUser(user) {
        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $userRole.val(user.role)
        $updateBtn.unbind('click');
        $updateBtn.click(function(){
            updateUser(user.id);
        });
    }

    function renderUsers(users) {
        $(".wbdv-tbody").empty();
        for (var i = 0; i < users.length; i++) {
            var template = userTemplate.clone()
            var user = users[i];
            template.attr("id",user.id);
            template.removeClass("wbdv-hidden");
            template.find(".wbdv-username").html(user.username);
            template.find(".wbdv-first-name").html(user.firstName);
            template.find(".wbdv-last-name").html(user.lastName);
            template.find(".wbdv-role").html(user.role);
            template.find(".wbdv-remove").click(deleteUser);
            template.find(".wbdv-edit").click(selectUser);
            $('.wbdv-tbody').append(template);
        }
    }

    function clearForm() {
        $usernameFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $passwordFld.val("");
    }

    function searchUser() {
        var allUsers = findAllUsers();
        username = $usernameFld.val();
        firstName = $firstNameFld.val();
        lastName = $lastNameFld.val();
        role = $userRole.val();
        var searchResult = [];

        if (username == "" && firstName == "" && lastName == "" && role == "") {
            renderUsers(searchResult);
            return;
        }

        for (var i = 0; i < allUsers.length; i++) {
            if ((username == '' || username == allUsers[i].username) &&
                (firstName == ''|| firstName == allUsers[i].firstName) &&
                (lastName == '' || lastName == allUsers[i].lastName) &&
                (role == '' || role == allUsers[i].role)) {
                searchResult.push(allUsers[i]);
            }
        }
        renderUsers(searchResult);
    }

})();
