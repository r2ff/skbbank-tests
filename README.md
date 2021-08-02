
# Автотесты <a target="_blank" href="https:skbbank.ru">skbbank.ru</a>

### Для написания автотестов использовались технологии и инструменты
<p align="left">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/git-logo.svg" alt="git">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/gradle-logo.svg" alt="gradle">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/java-logo.svg" alt="java">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/junit5-logo.svg" alt="junit5">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/3294e25e72c2949bd7027cd3d297b619dae42719/svg/selenide-logo.svg" alt="selenide">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/jenkins-logo.svg" alt="jenkins">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/88f137e2bed8e2b9aa3048dd41d68c6adb4a0522/svg/selenoid-logo.svg" alt="selenoid">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/54b7b71e5ab15cea6bc453babf179c93c8b136b2/svg/allure-Report-logo.svg" alt="allure">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/b40f0e55529c51f4234b8c12c6b769ae6d4b9f9c/svg/allure-ee-logo.svg" alt="allure-testops">
</p>

### Реализованы следующие проверки:
- [X] - Проверка заголовка страницы
- [X] - Проверка перехода страницу на "Вклады" с главной страницы
- [X] - Открыть страницу вклада "Обыкновенное чудо"
- [X] - Проверка консоль браузера на наличие ошибок
- [X] - Проверка периода вклада
- [X] - Проверить информацию о разделе "Благотворительность"
- [X] - Проверка чекбокса при открытии вклада "Обыкновенное чудо" в офисе
- [X] - Проверка чекбокса при открытии вклада "Обыкновенное чудо" онлайн
- [X] - Проверка ввода суммы с помощью слайдера
- [X] - Проверка ввода суммы с клавиатуры

### Для запуска необходимо заполнить remote.properties или передать значения:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)

### Пример запуска теста
</br>
![test-example2](https://user-images.githubusercontent.com/84721020/127873408-ff2af3d7-9117-457c-8592-a80001b60fe1.gif)



Запуск тестов с remote.properties:
```bash
gradle clean test
```

Запуск тестов без remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Сформировать allure отчет:
```bash
allure serve build/allure-results
```



