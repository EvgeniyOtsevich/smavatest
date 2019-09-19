# Smava Test UI Automation

#### Requirement:
- Java 8
- Maven 3.6.0

#### Library uses:
    - Junit5
    - Hamcrest
    - Allure2
    - Javafaker
    - Webdrivermanager

### Setup (for Linux)
1. Install maven (if not installed previusly)
```
  > sudo apt-get install maven
```
2. Install Google Chrome (if not installed previusly) 
```
  > sudo apt-get install google-chrome-stable
```
3. Clone reposetory
```
  > git clone https://github.com/EvgeniyOtsevich/smavatest.git
```
4. Navigate to `smavatest` folder
```
  > cd smavatest
```

### Execute
For executing tests run
```
  > mvn clean test
``` 
For generating allure report run
```
  > mvn io.qameta.allure:allure-maven:serve
``` 
