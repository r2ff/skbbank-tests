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

### Реализованы следующие проверки
#### UI тесты:
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

#### API тесты:
- [X] - Проверка расчета калькулятора при максимальной сумме
- [X] - Проверка расчета калькулятора при минимальной сумме
- [X] - Проверка расчета калькулятора при минимальной сумме, при открытии вклада в офисе
- [X] - Проверка расчета калькулятора при сумме больше максимальной
- [X] - Проверка расчета калькулятора при сумме меньше минимальной
- [X] - Проверка расчета калькулятора с пустыми данными


### Для запуска необходимо заполнить remote.properties или передать значения:

* browser (default chrome)
* browserVersion (default 91.0)
* browserSize (default 1920x1080)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)

### В качестве CI/CD используется Jenkins </br>
![jenkins-build](https://user-images.githubusercontent.com/84721020/127875803-7a40bc61-4e25-48be-80e8-4151b674e553.JPG)

### Пример запуска теста на Selenoid </br>

![test-example3](https://user-images.githubusercontent.com/84721020/127874294-f583531d-dca5-42b7-82eb-267e9172b489.gif)

### Allure отчет </br>
#### Общая информация
![allure-test](https://user-images.githubusercontent.com/84721020/131735078-56f5eba7-4ede-486e-93e3-09f90696689b.png)
#### Список тестов
![allure-test2](https://user-images.githubusercontent.com/84721020/131735404-2f494efe-4afe-411f-964f-b2416c450e8f.png)

### Интеграция с Allure TestOps и Jira </br>
![launches](https://user-images.githubusercontent.com/84721020/131736707-5e22978d-1fa0-4cdc-b554-d56a07fa192e.png)
![testcases](https://user-images.githubusercontent.com/84721020/131736737-8326c3b2-7d35-4541-8720-6eb30951e32e.png)
![jira](https://user-images.githubusercontent.com/84721020/131736756-a3a26034-2b1e-4a04-97b0-510f73b7169d.png)

### Уведомления в telegram о результатах теста </br>
![telegram-bot](https://user-images.githubusercontent.com/84721020/131736399-7b44b1b2-25f7-45a9-b09d-14f610da0d78.png)

### Уведомления в slack о результатах теста </br>
![slack](https://user-images.githubusercontent.com/84721020/131736478-a948c517-8dc1-42c1-a46d-0fb6c3005de7.png)



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



