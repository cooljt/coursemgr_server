var allUsers = [];

$.getJSON("../users.json", function(data){
    for (var i = 0; i < data.length; i++) {
        allUsers.push(data[i]);
    }
});




function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    /*this.url = 'http://localhost:8080/api/user';*/
    var self = this;

    function createUser(user, callback) {
        allUsers.push(user);
    }

    function findAllUsers() {
       return allUsers;      
    }

    function findUserById(userId, callback) {
       return allUsers.find(function(element){
            return element.id == userId;
        })
    }
    function updateUser(userId, user, callback) {
        for (var i=0; i<allUsers.length; i++) {
            if (allUsers[i].id == userId) {
                allUsers[i].username = user.username;
                allUsers[i].password = user.password;
                allUsers[i].firstName = user.firstName;
                allUsers[i].lastName = user.lastName;
                allUsers[i].role = user.role;
                return;
            }
        }
    }
    function deleteUser(userId, callback) {
        allUsers = $.grep(allUsers, function(user){
            return user.id != userId;
        });
    }
}
