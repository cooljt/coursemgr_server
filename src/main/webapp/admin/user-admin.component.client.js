
(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn;
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

        userTemplate = $(".wbdv-template.wbdv-hidden").clone();
        $createBtn.click(createUser);
        $updateBtn.click(updateUser);
        renderUsers(userService.findAllUsers());
        

    }
    function createUser() {
        var timestamp = (new Date()).getTime();
        var newUser = {
            userID:timestamp,
            username:$usernameFld.val(),
            password:$passwordFld.val(),
            firstName:$firstNameFld.val(),
            lastName:$lastNameFld.val(),
            role:$userRole.val(),
        };
        $usernameFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $passwordFld.val("");

        userService.createUser(newUser);
//        console.log(newUser)
        renderUsers(userService.findAllUsers());
    }

    function editUser(event) {

    }

    function findAllUsers() {}
    function findUserById() {}
    function deleteUser(event) {
        var button = $(event.currentTarget);
        var tr = button.parents(".wbdv-template");
        var userId = tr.attr("id");
        userService.deleteUser(userId);
        tr.remove();
        
    }

    function selectUser() {}
    function updateUser() {}

    function renderUser(user) {
        var newUser = $(".wbdv-template.wbdv-hidden").clone();
        var timestamp = (new Date()).getTime();
        newUser.removeClass("wbdv-hidden");
        newUser.find(".wbdv-username").html(user.username);
        newUser.find(".wbdv-first-name").html(user.firstName);
        newUser.find(".wbdv-last-name").html(user.lastName);
        newUser.find(".wbdv-role").html(user.role);
        newUser.find(".wbdv-remove").attr("id", timestamp).click(deleteUser);
        var timestamp2 = (new Date()).getTime();
        newUser.find(".wbdv-edit").attr("id", timestamp2).click(editUser);
        $('.wbdv-tbody').append(newUser);
    }

    function renderUsers(users) {
        $(".wbdv-tbody").empty();
        for (var i = 0; i < users.length; i++) {
            var template = userTemplate.clone()
            var user = users[i];
            template.attr("id",user.userID);
            template.removeClass("wbdv-hidden");
            template.find(".wbdv-username").html(user.username);
            template.find(".wbdv-first-name").html(user.firstName);
            template.find(".wbdv-last-name").html(user.lastName);
            template.find(".wbdv-role").html(user.role);
            template.find(".wbdv-remove").click(deleteUser);
            template.find(".wbdv-edit").click(editUser);
            $('.wbdv-tbody').append(template);
        }
        
    }
})();
