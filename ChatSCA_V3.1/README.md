Demonstrator of composition of heterogeneous services with SCA: Chat SCA
========================================================================


##Description

Chat SCA application is our main heterogeneity demonstrator. It’s an application that allows members to connect to a single chat room to discuss with a minimum of editorial rigor otherwise an automatic moderator will censor bad words or SMS/Geek words. 

##Architecture

The architecture of the application is described as below:

* **Chat server composite**: includes 3 components
    *  *Messages Manager*: implemented in Java, provides messages management services that are exposed over Java RMI to the client
    *  *Users Manager*: implemented in python, provides users management services that are exposed under JSON-RPC to the administration component   and a connection/disconnection service to the client under SOA protocol.
    *  *Administration component*: written in JavaScript. It’s a web based application that adds, removes members to/from the chat room.
*  **Moderation Unit**: includes 2 EJB components that are deployed in their EJB Container (Apache OpenEJB)
    *  *ModerationStarImplRemote*: a component that removes bad words and substitute them by stars (*)
    *  *ModerationSubsImplRemote*: a component that substitutes the SMS/Geek words by conventional words. 
*  **Client**: A client written in Java that uses 4 references of services: messages manager, users’ manager, and the 2 components of the moderation unit.
 

##run

###Important remarks

First of all, assure that you have installed properly Tuscany and 
that you have positioned properly the variable of environment 
TUSCANY_HOME, otherwise , Ant will declare a "fail".

It is imperative that you respect the order which follows:
    1. ChatServer
    2. ModerationUnit
    3. SCAClient


###Installation
1. Bien positionner la variable d'environnement TUSCANY_HOME
2. `cd $YOUR_WORKSPACE/ChatSCA_V3.1/ChatServer`
3. `ant`
4. (new terminal)
`cd $YOUR_WORKSPACE/ChatSCA_V3.1/ModerationUnit`
5. `ant compile run`
6. (new terminal)
    `cd $VOTRE_WORKSPACE/ChatSCA_V2.2.1/SCAClient`
7. `ant`
8. Copy the following link to your browser:
    `localhost:8080/webadmin/`
9. Connect as administrator through this web panel:
    Username: admin
    password: admin
    (customizable in file *admin.txt* )
10. Add users as required.

11. Connect in the Client application with the user name and password you added 
    or already exist.

12. Test your application and especially the moderation unit through SMS/bad words
    (ie: "hello leet wtf owned") ! **Sorry !**

###clean

You have just to write `ant clean` at the level of each of these directories: ChatServer, ModerationUnit and SCAClient.


