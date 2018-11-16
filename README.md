# EmployeeSearch
Dockerized application for Employee Search

### Steps to Run the application :
1) Clone the repo
2) Build using the following command : gradlew build 
3) Start the application using following command :docker compose up.
4)Alternatively, you can start the application in standalone mode using "java -jar build/libs/esearch-0.0.1-SNAPSHOT.jar"

### Sample Employee Tree Structure 
          1
         / \
        2   3
       / \
      4   5
      
REST calls Supported :

Fetch user details :
GET : http://localhost:8080/5

Update Parent details for a node :
POST : http://localhost:8080/5?newParent=1

### output formats 
GET : http://localhost:8080/4
{"data":"4",
"height":2,
"parent":{"data":"2","height":1,"parent":{"data":"1","height":0,"parent":null,"rootNode":null},
"rootNode":{"data":"1","height":0,"parent":null,"rootNode":null}},"rootNode":{"data":"1","height":0,"parent":null,"rootNode":null}}
