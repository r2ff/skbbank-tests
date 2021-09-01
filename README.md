

# Автотесты <a target="_blank" href="https:skbbank.ru">skbbank.ru</a>

### Для написания автотестов использовались технологии и инструменты:
<p align="left">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/git-logo.svg" alt="git">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/gradle-logo.svg" alt="gradle">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/java-logo.svg" alt="java">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/1cd5ac320c63eada404ddab3cfe71b4fbb5e73b0/svg/junit5-logo.svg" alt="junit5">
<img height="40" width="40" src="https://raw.githubusercontent.com/r2ff/r2ff/3294e25e72c2949bd7027cd3d297b619dae42719/svg/selenide-logo.svg" alt="selenide">
<img height="40" width="40" src="https://user-images.githubusercontent.com/84721020/131733118-67426995-f58b-4f2d-89ce-ab59f0c4a9bc.png" alt="rest-assured">
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

### В качестве CI/CD используется Jenkins </br>
![jenkins-build](https://user-images.githubusercontent.com/84721020/127875803-7a40bc61-4e25-48be-80e8-4151b674e553.JPG)

### Пример запуска теста на Selenoid </br>

![test-example3](https://user-images.githubusercontent.com/84721020/127874294-f583531d-dca5-42b7-82eb-267e9172b489.gif)

### Allure отчет </br>
#### Общая информация
![allure-test](https://user-images.githubusercontent.com/84721020/127874570-340eb1d7-5348-4c0b-a2fc-941ad98df22e.JPG)
#### Список тестов
![allure-test2](https://user-images.githubusercontent.com/84721020/127875182-c950377a-412b-43d1-b69e-e226e8e4d8da.JPG)

### Уведомления в telegram о результатах теста
![telegram-bot](https://user-images.githubusercontent.com/84721020/127876037-e8a40367-cfd1-454b-b756-8e4b1bae047a.JPG)

### Уведомления в slack о результатах теста
![slack-bot](https://user-images.githubusercontent.com/84721020/128090650-4712592d-ffc6-4da9-8348-264c8a16d6fc.JPG)



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



