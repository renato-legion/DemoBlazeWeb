## BAUFEST-AUTOMATION-EJEMPLO

### Archetype
````text 
baufest.automation/
├── src/
├── main/
│   ├── java/
│   ├── baufest.automation.ejemplo/
│   └── exceptions
│   └── interactions
│   └── models
│   └── questions
│   └── runners
│   └── stepsdefinitions
│   └── tasks
│   └── userinterface
│   └── utils
├── test/
├─ resources
│   ├── features
│   └── webdriver
├── serenity.conf
├── pom.xml
├── README.md
└── serenity.properties
````

### Compile code Maven
1st:
````
mvn clean
````
2nd:
````
Go to runner and enter @tag and run, remember enter a
new <ramdom USER> in Tramites.feature:
````
3rd:
````
mvn serenity:aggregate
````
4th:
````
click on url to see the report
````
###Author: Renato Francisco Paco Huerta 
###Linkedin: https://www.linkedin.com/in/renatopaco98/

