# entrata

Project Overview:

This project is a TestNG-based test automation framework for testing web applications. 
It includes sample test cases to demonstrate the testing of a web application.

Test Execution
1. Clone the project repository in your preferred Java IDE.
2. Run the testNG.xml file
3. If Face any issue update the mvn project and again execute the same file.


#In this project i have used following concept
Handle WebElement, Used collection, Windows/tab handling, Different types of wait, javascriptexecuter, Assertions to verify, encapsulation, abstratcion,
inheritance, methodOverriding, Scrolling on webpage, Cookies.

Method decription:
setUp() , tearDown(): setup and closing the browser
stratApplication() : fetch URL and verify.
formInteraction(): fill details of form and without submitting navigate back to main URL and verify.
windowsInteraction(): Inetratcion btween tab/window verify.
readPropertyFile(): read propety from configpropertyRepo.

Test Scenarios:
Scenario 1: Setup browser
Test Case:
1. Launch Chrome browser throught WebDriverManager.
2. Maximize the browser.

Scenario 2: Verify launch the URL on Browser
Test Case:
1. Setup browser
2. go to the given URL
3. Accept the cookies
4. Verify the cuurent URL and expected URL

Scenario 3: verify navigate back functionality from the form
Test Case:
1. URL open
2.  Navigate to Form
3.  Fill the details of form but do not sumbit it
4. Navigate Back to previous page
5. Verify expected and actul behaviour

Scenario 4: verify navigate back functionality from the form
Test Case:
1. URL open
2.  click on link which open in New tab/window
3. Go to the newly open window
4. Verify the expected and actual behavior
5. Go back the parent window
6. Verify the expected and actual behavior

Scenario 5: Browser Close
Test Case
1. close the open browser.



