
# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

#### My tech stack
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/git-logo.svg" alt="git">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/gradle-logo.svg" alt="gradle">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/java-logo.svg" alt="java">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/junit5-logo.svg" alt="junit5">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/3294e25e72c2949bd7027cd3d297b619dae42719/svg/selenide-logo.svg" alt="selenide">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/jenkins-logo.svg" alt="jenkins">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/88f137e2bed8e2b9aa3048dd41d68c6adb4a0522/svg/selenoid-logo.svg" alt="selenoid">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/54b7b71e5ab15cea6bc453babf179c93c8b136b2/svg/allure-Report-logo.svg" alt="allure">
<img height="30" width="30" src="https://raw.githubusercontent.com/r2ff/r2ff/b40f0e55529c51f4234b8c12c6b769ae6d4b9f9c/svg/allure-ee-logo.svg" alt="allure-testops">



* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```


For further development there are some example tests in src/test/java/cloud.autotests/tests/demowebshop
* remove @Disabled("...") annotation to run tests
```bash
gradle clean demowebshop
```

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>


