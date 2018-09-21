var allUsers = [
            {
                userID:1,
                username:"Alice",
                password:"12345",
                firstName:"Alice",
                lastName:"Bob",
                role:"Student"
            },
            {
                userID:2,
                username:"JI",
                password:"12345",
                firstName:"JI",
                lastName:"GO",
                role:"Student"
            },
            {
                userID:3,
                username:"Bye",
                password:"12345",
                firstName:"Bye",
                lastName:"Cook",
                role:"Student"
            },
            {
                userID:4,
                username:"Cook",
                password:"12345",
                firstName:"Tim",
                lastName:"Ushe",
                role:"Faculty"
            },
            {
                userID:5,
                username:"Jane",
                password:"12345",
                firstName:"Jane",
                lastName:"Oh",
                role:"Student"
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
    function findUserById(userId, callback) {}
    function updateUser(userId, user, callback) {}
    function deleteUser(userId, callback) {
        allUsers = $.grep(allUsers, function(user){
            return user.userID != userId;
        });
    }
}
