
(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn;
    var $firstNameFld, $lastNameFld;
    var $userRowTemplate, $tbody;
    var $userRole;
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

        $createBtn.click(createUser);
        

    }
    function createUser() {
        
        var newUser = $(".wbdv-template.wbdv-hidden").clone();
        newUser.removeClass("wbdv-hidden");
        newUser.find(".wbdv-username")
               .html($usernameFld.val());
        newUser.find(".wbdv-first-name")
               .html($firstNameFld.val());
        newUser.find(".wbdv-last-name")
               .html($lastNameFld.val());
        newUser.find(".wbdv-role")
               .html($userRole.val());    
        $usernameFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $userRole.val("");
        $('.wbdv-tbody').append(newUser);
    }
    function findAllUsers() {}
    function findUserById() {}
    function deleteUser() {}
    function selectUser() {}
    function updateUser() {}
    function renderUser(user) {}
    function renderUsers(users) {}
})();
