var allUsers = [
            {
                userID:1,
                username:"Alice",
                password:"12345",
                firstName:"Alice",
                lastName:"Bob",
                role:"STUDENT"
            },
            {
                userID:2,
                username:"JI",
                password:"12345",
                firstName:"JI",
                lastName:"GO",
                role:"STUDENT"
            },
            {
                userID:3,
                username:"Bye",
                password:"12345",
                firstName:"Bye",
                lastName:"Cook",
                role:"STUDENT"
            },
            {
                userID:4,
                username:"Cook",
                password:"12345",
                firstName:"Tim",
                lastName:"Ushe",
                role:"FACULTY"
            },
            {
                userID:5,
                username:"Jane",
                password:"12345",
                firstName:"Jane",
                lastName:"Oh",
                role:"STUDENT"
            }
        ];

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
            return element.userID == userId;
        })
    }
    function updateUser(userId, user, callback) {
        for (var i=0; i<allUsers.length; i++) {
            if (allUsers[i].userID == userId) {
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
            return user.userID != userId;
        });
    }
}
