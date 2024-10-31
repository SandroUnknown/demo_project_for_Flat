# Проект по автоматизации тестирования для компании [«ФЛАТ»](https://flat-soft.ru/)
</br>
  
>_**<p align="justify">[ООО «ФЛАТ»](https://flat-soft.ru/)** — российский разработчик линейки программных продуктов для организации современных корпоративных коммуникаций и оперативного взаимодействия на территориально-распределенных объектах.</p>_
> 
>_<p align="justify">Программное обеспечение ФЛАТ решает задачи по организации коммуникаций, приведения разрозненной инфраструктуры к единому централизованному стандарту, предоставляет сервисы оперативного и функционального контроля, учета и управления коммуникационными ресурсами, предлагая на российском рынке решения по записи переговоров, тарификации вызовов, централизованного управления парком телефонных аппаратов, а также продукты для развертывания современного контактного центра.</p>_
> 
>_<p align="justify">Программные решения компании включены в Реестр российских программ для электронных вычислительных машин и баз данных Минкомсвязи РФ.</p>_

</br>
</br>
</br>



<a name="table-of-contents"></a>
## Содержание:
* [О проекте](#about)
* [Технологии и инструменты](#tools)
* [Что делают тесты?](#tests)
* [Сборка в Jenkins](#jenkins)
* [Запуск из терминала](#console)
* [Allure-отчет](#allure)
* [Интеграция с Allure TestOps](#allure-testops)
* [Интеграция с Jira](#jira)
* [Уведомление в Telegram при помощи бота](#telegram)
* [Примеры видео выполнения тестов на Selenoid](#video)
</br>
</br>


  
<a name="about"></a>
## О проекте  
>_<p align="justify">Основная цель проекта — отработка навыков автоматизации тестирования, улучшение понимания процесса разработки тестов и повышение эффективности обеспечения качества программного обеспечения.</p>_
>
>_<p align="justify">Тестирование проводилось исключительно на уровне пользовательского интерфейса (UI), что позволяет сосредоточиться на взаимодействии пользователей с сайтом.</p>_
>
>_<p align="justify">Проект является демонстрационным и включает в себя ряд тестов, охватывающих различные аспекты функциональности, обеспечивая надежность и стабильность работы веб-приложения.</p>_
</br>
</br>



<a name="tools"></a>
## Технологии и инструменты
<p align="left">  
<a href="https://www.jetbrains.com/idea"><img src="media/icons/Intelij_IDEA.svg" width="64" height="64"   alt="Intellij IDEA"/></a>  
<a href="https://www.java.com"><img src="media/icons/Java.svg" width="64" height="64"                     alt="Java"/></a>  
<a href="https://junit.org/junit5"><img src="media/icons/JUnit5.svg" width="64" height="64"               alt="JUnit 5"/></a>  
<a href="https://gradle.org"><img src="media/icons/Gradle.svg" width="64" height="64"                     alt="Gradle"/></a>  
<a href="https://selenide.org"><img src="media/icons/Selenide.svg" width="64" height="64"                 alt="Selenide"/></a>
<a href="https://github.com"><img src="media/icons/Github.svg" width="64" height="64"                     alt="Github"/></a>   
<a href="https://www.jenkins.io"><img src="media/icons/Jenkins.svg" width="64" height="64"                alt="Jenkins"/></a>  
<a href="https://allurereport.org"><img src="media/icons/Allure.svg" width="64" height="64"               alt="Allure"/></a>  
<a href="https://qameta.io"><img src="media/icons/AllureTestOps.svg" width="64" height="64"               alt="Allure TestOps"/></a>
<a href="https://www.atlassian.com/software/jira"><img src="media/icons/Jira.svg" width="64" height="64"  alt="Jira"/></a>
<a href="https://telegram.org/"><img src="media/icons/Telegram.svg" width="64" height="64"                alt="Telegram"/></a>
<a href="https://aerokube.com/selenoid"><img src="media/icons/Selenoid.svg" width="64" height="64"        alt="Selenoid"/></a>  
</p>
</br>
</br>




<a name="tests"></a>
## Что делают тесты?
Тесты проверяют разные страницы сайта на работоспособность и корректность данных.</br>

<details>
<summary>Общие тесты для всех страниц</summary></br>
   
  - [x] Проверка наличия и корректности `телефона` и `email` в верхней части страницы;
  - [x] Проверка наличия и корректности `контактных данных` в нижней части страницы;
  - [x] Проверка всех пунктов (и подпунктов) главного `меню` на предмет корректности ссылок и наименований;
  </br>      
</details>
   
<details>
<summary>Тесты для главной страницы</summary></br>
  
  - [x] Проверка содержимого страницы:
    - [x] Проверка `слогана` компании;
    - [x] Проверка `предоставляемых услуг`;
  </br>
</details> 

<details>
<summary>Тесты для страницы "партнеры"</summary></br>
  
  - [x] Проверка всех `партнеров` (по городам) на корректность данных `[параметризированный тест]`;
  - [x] Проверка работы `поиска` партнера по имени `[параметризированный тест]`;
</details>

  

</br>
</br>




## Что делают тесты?
Тесты проверяют разные страницы сайта на работоспособность и корректность данных.</br>

* Общие тесты для всех страниц:
  - [x] Проверка наличия и корректности `телефона` и `email` в верхней части страницы;
  - [x] Проверка наличия и корректности `контактных данных` в нижней части страницы;
  - [x] Проверка всех пунктов (и подпунктов) главного `меню` на предмет корректности ссылок и наименований;

* Тесты для главной страницы:
  - [x] Проверка содержимого страницы:
    - [x] Проверка `слогана` компании;
    - [x] Проверка `предоставляемых услуг`;

* Тесты для страницы "партнеры":
  - [x] Проверка всех `партнеров` (по городам) на корректность данных `[параметризированный тест]`;
  - [x] Проверка работы `поиска` партнера по имени `[параметризированный тест]`;
        


</br>
</br>


## Что делают тесты?
>Тесты проверяют разные страницы сайта на работоспособность и корректность данных.</br>
>
> * Общие тесты для всех страниц:
>  - [x] Проверка наличия и корректности `телефона` и `email` в верхней части страницы;
>  - [x] Проверка наличия и корректности `контактных данных` в нижней части страницы;
>  - [x] Проверка всех пунктов (и подпунктов) главного `меню` на предмет корректности ссылок и наименований;
>
> * Тесты для главной страницы:
>  - [x] Проверка содержимого страницы:
>    - [x] Проверка `слогана` компании;
>    - [x] Проверка `предоставляемых услуг`;
>
> * Тесты для страницы "партнеры":
>  - [x] Проверка всех `партнеров` (по городам) на корректность данных `[параметризированный тест]`;
>  - [x] Проверка работы `поиска` партнера по имени `[параметризированный тест]`;
        


</br>
</br>



<a name="jenkins"></a>
## Сборка в Jenkins
Тесты запускаются только через [Jenkins](https://jenkins.autotests.cloud/job/qa_homework_14_jenkins_crowdtesting_project/)  
<img src="images/Jenkins.png" width="900">
В качестве параметров можно выбрать:  
- Браузер
- Разрешение экрана
- Версию браузера
</br>
</br>


<a name="console"></a>
## Запуск из терминала
Просто текст:  
- Текст 1
- Текст 2
- Текст 3
</br>
</br>


<a name="allure"></a>
## Allure-отчет
После выполнения тестов можно посмотреть отчет в [Allure](https://jenkins.autotests.cloud/job/qa_homework_14_jenkins_crowdtesting_project/allure/)
### На скриншоте один из результатов выполнения тестов:
<img src="images/AllureReport.png" width="900">
</br>
</br>


<a name="llure-testops"></a>
## Allure TestOps
Просто текст:  
- Текст 1
- Текст 2
- Текст 3
</br>
</br>


<a name="jira"></a>
## Интеграция с Jira
Просто текст:  
- Текст 1
- Текст 2
- Текст 3
</br>
</br>


<a name="telegram"></a>
## Уведомление в Telegram при помощи бота
После выполнения отчета результат так же предоставит бот в Telegram:
<p align="center">
    <img src="images/TelegramBot.png">
</p>
</br>
</br>


<a name="video"></a>
## Примеры видео выполнения тестов на Selenoid
Просто текст:  
- Текст 1
- Текст 2
- Текст 3
</br>
</br>




---
---
---



The background color is `#ffffff` for light mode and `#000000` for dark mode.

1. First list item
   - First nested list item
     - Second nested list item


- [x] #739
- [ ] https://github.com/octo-org/octo-repo/issues/740
- [ ] Add delight to the experience when all tasks are complete :tada:
- [ ] \(Optional) Open a followup issue


> [!NOTE]
> Useful information that users should know, even when skimming content.

> [!TIP]
> Helpful advice for doing things better or more easily.

> [!IMPORTANT]
> Key information users need to know to achieve their goal.

> [!WARNING]
> Urgent info that needs immediate user attention to avoid problems.

> [!CAUTION]
> Advises about risks or negative outcomes of certain actions.



| Left-aligned | Center-aligned | Right-aligned |
| :---         |     :---:      |          ---: |
| git status   | git status     | git status    |
| git diff     | git diff       | git diff      |





