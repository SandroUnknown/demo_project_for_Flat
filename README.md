# Проект по автоматизации тестирования для компании [ФЛАТ](https://flat-soft.ru/)
> ФЛАТ – российский разработчик программных решений в области телекоммуникаций и ИТ

The background color is `#ffffff` for light mode and `#000000` for dark mode.



---

## Содержание

* <a href="#tests">Что делают тесты?</a>
* <a href="#tools">Технологии</a>
* <a href="#jenkins">Jenkins</a>
* <a href="#allure">Отчет в Allure</a>
* <a href="#telegramBot">Бот в Telegram</a>

---
<a id="tests"></a>
## <a name="Что делают тесты?">**Что делают тесты?**</a>

Шесть тестов, тестирующие разные страницы данного сайта.

---
<a id="tools"></a>
## <a name="Технологии:">**Технологии:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea"><img src="img/icons/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com"><img src="img/icons/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com"><img src="img/icons/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5"><img src="img/icons/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org"><img src="img/icons/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org"><img src="img/icons/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://allurereport.org"><img src="img/icons/Allure.svg" width="50" height="50"  alt="Allure"/></a>  
<a href="https://www.jenkins.io"><img src="img/icons/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://aerokube.com/selenoid"><img src="img/icons/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
</p>

---
<a id="jenkins"></a>
## <a name="Jenkins">**Jenkins**</a>

Тесты запускаются только через [Jenkins](https://jenkins.autotests.cloud/job/qa_homework_14_jenkins_crowdtesting_project/)  

<img src="images/Jenkins.png" width="900">

В качестве параметров можно выбрать:  
- Браузер
- Разрешение экрана
- Версию браузера

---

<a id="allure"></a>
## <a name="Отчет в Allure">**Отчет в Allure**</a>

После выполнения тестов можно посмотреть отчет в [Allure](https://jenkins.autotests.cloud/job/qa_homework_14_jenkins_crowdtesting_project/allure/)
### На скриншоте один из результатов выполнения тестов:

<img src="images/AllureReport.png" width="900">

---

<a id="telegramBot"></a>
## <a name="Бот в Telegram">**Бот в Telegram**</a>

После выполнения отчета результат так же предоставит бот в Telegram:
<p align="center">
    <img src="images/TelegramBot.png">
</p>
