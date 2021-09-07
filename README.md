## Info & Instructions

In this **README.md** you will find all the necessary info about this framework like:
- What is the main programming language used?
- Which frameworks are used?
- What test design pattern is followed?
- Which plugins & extensions are used and how they are used?
- How to run the tests and what should you expect at the end of  test execution?

### Code & Frameworks

- Language used: Java
- Test Library: Rest Assured
- Test Framework: TestNG
- Request/Response model: Project Lombok
- Assertion Framework: Hamcrest Assertions

### Plugins

- **Log**, powerful logger from project Lombok
- **allure-reporter**, an HTML report for JUnit tests

### How to run the tests:

1. Right-click on the **testng.xml** and run the file.(it will run the tests and create allure-results folder in /target which includes the test results in a JSO format
2. Open Terminal, navigate to the root project and enter: **allure serve target/allure-results** (this will convert the .json into an .html format and will automatically open the report in a browser)
