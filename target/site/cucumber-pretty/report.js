$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cnw_omc_place_order.feature");
formatter.feature({
  "line": 2,
  "name": "Placing an Order from OMC using CNW Customer",
  "description": "",
  "id": "placing-an-order-from-omc-using-cnw-customer",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CNWOrderCreation"
    }
  ]
});
formatter.scenarioOutline({
  "line": 12,
  "name": "Should be able to place Order with Hold for Call PRT",
  "description": "",
  "id": "placing-an-order-from-omc-using-cnw-customer;should-be-able-to-place-order-with-hold-for-call-prt",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 13,
  "name": "Navigate to Send a Release page",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User uploads primary content document",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User clicks on Distribution Tab",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User selects Category",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User selects News Line",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "User selects Public Release Time as \u003cPRT\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User selects on Save and Continue Button",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User selects Terms and Condition Check Box",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "User clicks on Submit Button",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "User fetch the Order No",
  "keyword": "And "
});
formatter.examples({
  "line": 24,
  "name": "",
  "description": "",
  "id": "placing-an-order-from-omc-using-cnw-customer;should-be-able-to-place-order-with-hold-for-call-prt;",
  "rows": [
    {
      "cells": [
        "PRT"
      ],
      "line": 25,
      "id": "placing-an-order-from-omc-using-cnw-customer;should-be-able-to-place-order-with-hold-for-call-prt;;1"
    },
    {
      "cells": [
        "Hold for Call"
      ],
      "line": 26,
      "id": "placing-an-order-from-omc-using-cnw-customer;should-be-able-to-place-order-with-hold-for-call-prt;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6164346251,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "These are the background steps to place an order from OMC-CNW website",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Navigate to OMC CNW Website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User is on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters UserName and Password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 8
    },
    {
      "cells": [
        "cnwtestuser2@cts.com",
        "password-1"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User should be Logged In Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_Test_Steps.navigate_to_OMC_CNW_Website()"
});
formatter.result({
  "duration": 29358666704,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_is_on_Login_Page()"
});
formatter.result({
  "duration": 1846193411,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_enters_UserName_and_Password(DataTable)"
});
formatter.result({
  "duration": 288179813,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_should_be_Logged_In_Successfully()"
});
formatter.result({
  "duration": 17062396376,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Should be able to place Order with Hold for Call PRT",
  "description": "",
  "id": "placing-an-order-from-omc-using-cnw-customer;should-be-able-to-place-order-with-hold-for-call-prt;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@CNWOrderCreation"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Navigate to Send a Release page",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User uploads primary content document",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User clicks on Distribution Tab",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User selects Category",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User selects News Line",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "User selects Public Release Time as Hold for Call",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User selects on Save and Continue Button",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User selects Terms and Condition Check Box",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "User clicks on Submit Button",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "User fetch the Order No",
  "keyword": "And "
});
formatter.match({
  "location": "Login_Test_Steps.navigate_to_Send_a_Release_page()"
});
formatter.result({
  "duration": 168725804,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_uploads_primary_content_document()"
});
formatter.result({
  "duration": 60804452921,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_clicks_on_Distribution_Tab()"
});
formatter.result({
  "duration": 157561831,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_selects_Category()"
});
formatter.result({
  "duration": 21034044677,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_selects_News_Line()"
});
formatter.result({
  "duration": 80175078281,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hold for Call",
      "offset": 36
    }
  ],
  "location": "Login_Test_Steps.user_selects_Public_Release_Time_as(String)"
});
formatter.result({
  "duration": 232316843,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_selects_on_Save_and_Continue_Button()"
});
formatter.result({
  "duration": 339626282,
  "status": "passed"
});
formatter.match({
  "location": "Login_Test_Steps.user_selects_Terms_and_Condition_Check_Box()"
});
formatter.result({
  "duration": 101922898,
  "error_message": "org.openqa.selenium.UnhandledAlertException: Unexpected modal dialog (text: Please select a distribution for your release.): Please select a distribution for your release.\nBuild info: version: \u00272.52.0\u0027, revision: \u00274c2593c\u0027, time: \u00272016-02-11 19:03:33\u0027\nSystem info: host: \u0027PC322043\u0027, ip: \u002710.102.167.165\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_121\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d43.0.1, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 49b9f7e2-5bb6-459c-9445-0ec5efcee82a\n*** Element info: {Using\u003dxpath, value\u003d//*[@id\u003d\u0027ctl00_cphPage_chkTermsAndConditions\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createUnhandledAlertException(ErrorHandler.java:187)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:154)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:302)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$1(ExpectedConditions.java:301)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:288)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:1)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:696)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:1)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat pages.OrderSubmitPageObjects.selectTermsAndConditionCheckBox(OrderSubmitPageObjects.java:38)\r\n\tat stepDefinitions.Login_Test_Steps.user_selects_Terms_and_Condition_Check_Box(Login_Test_Steps.java:211)\r\n\tat ✽.And User selects Terms and Condition Check Box(cnw_omc_place_order.feature:20)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Login_Test_Steps.user_clicks_on_Submit_Button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Login_Test_Steps.user_fetch_the_Order_No()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("Scenario: Method Should be able to place Order with Hold for Call PRTis failed");
formatter.after({
  "duration": 6668004,
  "status": "passed"
});
});