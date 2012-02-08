### The first part of this python module implements the interface : UsersManager
### and provides services for the users

def connect(pseudo, password):
    "service that lets a user connect"
    global users
    if users.has_key(pseudo):
        if users[pseudo] == password:
            if (pseudo in connectedUsers) == False:
                connectedUsers.append(pseudo)
                return 1
            else:
                return 0
        else:
            return 0
    else:
        return 0

def disconnect(pseudo):
    "Service that lets a user disconnect"
    global connectedUsers
    connectedUsers.remove(pseudo)

### The second part of this python module implements the interface : AdminServer
### and provides services for the administrator

def connectAdmin(pseudo, password):
    "Service that makes the connection for the administrator"
    global adminConnected
    if adminConnected == False and adminPseudo == pseudo and adminPassword == password:
        adminConnected = True
        return 1
    else:
        return 0

def disconnectAdmin(pseudo):
    "Service that allows the administrator to disconnect"
    global adminConnected
    adminConnected = False



def addUser(pseudo, password):
    "Service that allows the administrator to add a user"
    global users
    if users.has_key(pseudo):
        return 0
    else:
        users[pseudo] = password
        f = open('resources/users.txt', 'a')
        fileUser = "%s:%s\n" %(pseudo,password)
        f.write(fileUser)
        f.close()
        return 1

def deleteUser(pseudo):
    "Service that allows the administrator to delete a user"
    global users, userList
    if users.has_key(pseudo) == False:
        return 0
    else:
        del users[pseudo]
        fileContent = ""
        for username in users.keys():
            fileContent = "%s%s:%s\n" % (fileContent,username,users[username])
        f = open('resources/users.txt', 'w')
        f.write(fileContent)
        f.close()
        return 1

def getUsers():
    "Service that returns the list of users to the administrator"
    global users
    return listToString(users.keys())
    
### The last part of this module is for useful functions
    
def listToString(l):
    "Function that transforms a list in a string containing the list items"
    if len(l)==0:
        return ""
    stri =""
    for i in range (len(l)):
        stri = "%s%s%s" %(stri, str(l[i]), "\n")
    return stri

### Main script

#this dictionary contains the users : the keys are the usernames and the values are the passwords
users = {}

#the list of the connected users
connectedUsers = []

#status of administrator
adminConnected = False

#pick the administrator pseudo and password
f = open('resources/admin.txt', 'r')
adminStr = f.readline()
adminPair = adminStr.split(":")
adminPseudo = adminPair[0]
adminPassword = adminPair[1]

#read the list of users from the file "users.txt" which syntax is username1:password1\nusername2:password2 ...
f = open('resources/users.txt', 'r')
userList = f.readlines()
for user in userList:
    pair = user.split(":")
    username = pair[0]
    if pair[1][len(pair[1])-1] == '\n':
        password = pair[1][:len(pair[1])-1]
    else:
        password = pair[1]
    users[username]=password    
f.close()



