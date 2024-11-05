<a name="start"></a>
# <p align="center">Демонстрационный проект по автоматизации</br>тестирования для компании [«ФЛАТ»](https://flat-soft.ru/)</p>
<a href="https://flat-soft.ru/"><img src="media/icons/face.png" width="100%" alt="FLAT-SOFT"/></a>  

> _<p align="justify"><sub><a href="https://flat-soft.ru/"><img src="media/icons/logo.png" width="128" alt="FLAT-SOFT"/></a></sub></p>_
> _<p align="justify"> &emsp;&emsp;&emsp;&emsp; — **российский разработчик** линейки программных продуктов для организации современных корпоративных коммуникаций и оперативного взаимодействия на территориально-распределенных объектах.</p>_
> 
> _<p align="justify">Программное обеспечение ФЛАТ решает задачи по организации коммуникаций, приведения разрозненной инфраструктуры к единому централизованному стандарту, предоставляет сервисы оперативного и функционального контроля, учета и управления коммуникационными ресурсами, предлагая на российском рынке решения по записи переговоров, тарификации вызовов, централизованного управления парком телефонных аппаратов, а также продукты для развертывания современного контактного центра.</p>_
> 
> _<p align="justify">Программные решения компании включены в Реестр российских программ для электронных вычислительных машин и баз данных Минкомсвязи РФ.</p>_

</br>
</br>
</br>




<a name="table-of-contents"></a>
# Содержание

</br>


* [**О проекте**](#about)
  * [Для чего был создан проект](#for-what)
  * [Технологии и инструменты](#tools)
  * [Что делают тесты?](#tests)
* [**Запуск тестов из терминала**](#console)
  * [Параметры запуска](#console_params)
  * [Список возможных задач (TASK)](#console_tasks)
  * [Примеры запуска тестов](#console_example)
* [**Интеграции и примеры**](#integrations)
  * [Сборка в Jenkins](#jenkins)
  * [Интеграция с Allure Report](#allure-report)
  * [Интеграция с Allure TestOps](#allure-testops)
  * [Интеграция с Jira](#jira)
  * [Уведомление в Telegram при помощи бота](#telegram)
  * [Примеры видео выполнения тестов на Selenoid](#video)

</br>
</br>
</br>




<a name="about"></a>
# О проекте

_<p align="right">[<sub>Перейти к содержанию</sub>](#table-of-contents)</p>_

_<p align="right">[`Перейти к содержанию`](#table-of-contents)</p>_



<a name="for-what"></a>
### Для чего был создан проект

> _<p align="justify">Основная цель проекта — отработка навыков автоматизации тестирования, улучшение понимания процесса разработки тестов и повышение эффективности обеспечения качества программного обеспечения.</p>_
>
> _<p align="justify">Тестирование проводилось исключительно на уровне пользовательского интерфейса (UI), что позволило сосредоточиться на взаимодействии пользователя с сайтом.</p>_
>
> _<p align="justify">Проект является демонстрационным и включает в себя ряд тестов, охватывающих различные аспекты функциональности, обеспечивая надежность и стабильность работы веб-приложения.</p>_
 
</br>
</br>


<a name="tools"></a>
### Технологии и инструменты

> <p align="left">  
> <a href="https://www.jetbrains.com/idea"><img src="media/icons/Intelij_IDEA.svg" width="60" height="60"   alt="Intellij IDEA"/></a>  
> <a href="https://www.java.com"><img src="media/icons/Java.svg" width="60" height="60"                     alt="Java"/></a>  
> <a href="https://junit.org/junit5"><img src="media/icons/JUnit5.svg" width="60" height="60"               alt="JUnit 5"/></a>  
> <a href="https://gradle.org"><img src="media/icons/Gradle.svg" width="60" height="60"                     alt="Gradle"/></a>  
> <a href="https://selenide.org"><img src="media/icons/Selenide.svg" width="60" height="60"                 alt="Selenide"/></a>
> <a href="https://github.com"><img src="media/icons/Github.svg" width="60" height="60"                     alt="Github"/></a>   
> <a href="https://www.jenkins.io"><img src="media/icons/Jenkins.svg" width="60" height="60"                alt="Jenkins"/></a>  
> <a href="https://allurereport.org"><img src="media/icons/Allure.svg" width="60" height="60"               alt="Allure Report"/></a>  
> <a href="https://qameta.io"><img src="media/icons/AllureTestOps.svg" width="60" height="60"               alt="Allure TestOps"/></a>
> <a href="https://www.atlassian.com/software/jira"><img src="media/icons/Jira.svg" width="60" height="60"  alt="Jira"/></a>
> <a href="https://telegram.org/"><img src="media/icons/Telegram.svg" width="60" height="60"                alt="Telegram"/></a>
> <a href="https://aerokube.com/selenoid"><img src="media/icons/Selenoid.svg" width="60" height="60"        alt="Selenoid"/></a>  
> </p>

</br>
</br>


<a name="tests"></a>
### Что делают тесты?

> Тесты проверяют разные страницы сайта на работоспособность и корректность данных.</br></br>
>
> **Общие тесты для всех страниц:**
>  - [x] Проверка наличия и корректности `телефона` и `email` в верхней части страницы `(header)`;
>  - [x] Проверка наличия и корректности `контактных данных` в нижней части страницы `(footer)`;
>  - [x] Проверка всех пунктов (и подпунктов) главного `меню` на предмет корректности ссылок и наименований;</br></br>
>  
> **Тесты для главной страницы:**
>  - [x] Проверка содержимого страницы:
>    - [x] Проверка `слогана` компании;
>    - [x] Проверка `предоставляемых услуг`;</br></br>
>    
> **Тесты для страницы "партнеры":**
>  - [x] Проверка всех `партнеров` (по городам) на корректность данных `[параметризированный тест]`;
>  - [x] Проверка работы `поиска` партнера по имени `[параметризированный тест]`;
 
</br>
</br>
</br>




<a name="console"></a>
# Запуск тестов из терминала

</br>


<a name="console_params"></a>
### Параметры запуска

> Тесты можно запускать как с передачей параметров, так и без них (в этом случае тесты будут запущены с параметрами по умолчанию).
>
> | Параметр          | Описание                                                | Значение по умолчанию                |
> | :---              | :---                                                    | :---                                 |
> | `TASK`            | Имя задачи в Gradle (указывает какие тесты выполнить)   | test                                 |
> | `REMOTE_URL`      | Адрес удалённого сервера, где будут запускаться тесты   | (пустое значение ~ локальный запуск) |
> | `BASE_URL`        | Адрес сайта, где будут запускаться тесты                | https://flat-soft.ru                 |
> | `BROWSER`         | Браузер, в котором будут выполняться тесты              | chrome                               |
> | `BROWSER_VERSION` | Версия браузера, в которой будут выполняться тесты      | 125.0                                |
> | `BROWSER_SIZE`    | Размер окна браузера, в котором будут выполняться тесты | 1920x1080                            |

</br>


<a name="console_tasks"></a>
### Список возможных задач (`TASK`)

> [!CAUTION]
> | Задача                      | Описание                                                                                                                                            |
> | :---                        | :---                                                                                                                                                |
> | `test`                      | Запускает `все` тесты</br> _(является значением по умолчанию)_                                                                                      |
> | `main_page`                 | Запускает тесты, `полностью` проверяющие только `главную страницу`                                                                                  |
> | `main_page_content_only`    | Запускает тесты, проверяющие `только контент` `главной страницы`</br> _(без проверки общих для сайта элементов, таких как меню, footer и topbar)_   |
> | `partner_page`              | Запускает тесты, `полностью` проверяющие только `страницу партнеров`                                                                                |
> | `partner_page_content_only` | Запускает тесты, проверяющие `только контент` `страницы партнеров`</br> _(без проверки общих для сайта элементов, таких как меню, footer и topbar)_ |
> | `smoke`                     | Запускает тесты, проверяющие `topbar и footer` `на всех страницах`                                                                                  |
> | `top_bar`                   | Запускает тесты, проверяющие `только topbar` `на всех страницах`                                                                                    |
> | `footer`                    | Запускает тесты, проверяющие `только footer` `на всех страницах`                                                                                    |
> | `top_menu`                  | Запускает тесты, проверяющие `только menu` `на всех страницах`                                                                                      |

</br>


<a name="console_example"></a>
### Примеры запуска тестов

> **Локальный запуск** (без параметров)
> ```
> gradle clean test
> ```
>
> </br>
>
> **Удаленный запуск** (с параметрами)
> ```
> clean
> -Dtask="${TASK}"
> -DremoteUrl="${REMOTE_URL}"
> -DbaseUrl="${BASE_URL}"
> -Dbrowser="${BROWSER}"
> -DbrowserVersion="${BROWSER_VERSION}"
> -DbrowserSize="${BROWSER_SIZE}"
> ```

</br>
</br>
</br>




<a name="integrations"></a>
# Интеграции и примеры

</br>


<a name="jenkins"></a>
### Сборка в Jenkins

> Реализован запуск тестов с помощью [`Jenkins`](https://jenkins.autotests.cloud/job/!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!/) (требуется авторизация).</br>
> </br>
> Для запуска сборки необходимо: 
> 1. Перейти в раздел `▷ Build with Parameters`
> 2. Выбрать необходимые [параметры](#console_params)
> 3. Нажать кнопку `▷ Build`
>
> <p>  
> <img src="media/screenshots/Jenkins_1.png" width="49%">
> <img src="media/screenshots/Jenkins_2.png" width="49%">
> </p>
>
> После выполнения сборки в разделе `🔆 Build History` можно будет детально изучить прошедние тесты:
> * Посмотреть лог
> * Посмотреть &nbsp; [<img src="media/icons/Allure.svg" width="16" height="16" alt="Allure Report"/>   Allure Report](#allure-report)
> * Посмотреть &nbsp; [<img src="media/icons/AllureTestOps.svg" width="16" height="16" alt="Allure TestOps"/>   Allure TestOps](#allure-testops)

</br>


<a name="allure-report"></a>
### Allure Report

> После выполнения тестов формируется [`Allure Report`](https://jenkins.autotests.cloud/job/!!!!!!!!!!!!!!!!!!!!!!!!!!!!) (требуется авторизация).</br>
> <details> 
> <summary>Примеры (скриншоты).</summary>
> </br></br>
>
> **Основная страница отчёта** `(Overview)`
>
> <img src="media/screenshots/Jenkins_1.png" width="100%" height="800">
> </br></br></br>
> 
> **Тест-кейсы** `(Suites)`</br>
> _с шагами и вложениями_
> 
> <img src="media/screenshots/Jenkins_1.png" width="100%" height="800">
> </br></br></br>
>
> **Графики** `(Graphs)`
>
> <img src="media/screenshots/Jenkins_1.png" width="100%" height="800">
> </details>

</br>


<a name="allure-testops"></a>
### Allure TestOps

> Выполнена интеграция сборки `Jenkins` с [`Allure TestOps`](https://jenkins.autotests.cloud/job/!!!!!!!!!!!!!!!!!!!!!!!!!!!!) (требуется авторизация).
> <details> 
> <summary>Примеры (скриншоты).</summary>
> </br></br>
>
> **Основная страница отчёта** `Dashboard`</br>
> _со статистикой пройденных тестов_
> 
> <img src="media/screenshots/scr3.png" width="100%" height="800">
> </br></br></br>
>
> **Ручные тесты !!!**
> 
> <img src="media/screenshots/scr3.png" width="100%" height="800">
> </br></br></br>
>
> **Авто тесты !!!**
> 
> <img src="media/screenshots/scr3.png" width="100%" height="800">
> </details>

</br>


<a name="allure-testops"></a>
### Allure TestOps

> Выполнена интеграция сборки `Jenkins` с [`Allure TestOps`](https://jenkins.autotests.cloud/job/!!!!!!!!!!!!!!!!!!!!!!!!!!!!) (требуется авторизация).
> </br>
>
> <details> 
> <summary>Примеры (скриншоты).</summary>
> </br></br>
>
> **Основная страница отчёта** `Dashboard`</br>
> _со статистикой пройденных тестов_
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
>
> </br>
>
> **Ручные тесты !!!**
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
>
> </br>
>
> **Авто тесты !!!**
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
> </details>

</br>


<a name="jira"></a>
### Интеграция с Jira

> Выполнена интеграция `Allure TestOps` с [`Jira`](https://JIRA/!!!!!!!!!!!!!!!!!!!!!!!!!!!!) (требуется авторизация).
> </br>
>
> <details> 
> <summary>Примеры (скриншоты).</summary>
> </br></br>
>
> **Основная страница отчёта** `Dashboard`</br>
> _со статистикой пройденных тестов_
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
>
> </br>
>
> **Авто тесты !!!**
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
> </details>

</br>


<a name="telegram"></a>
### Уведомление в Telegram при помощи бота

> Выполнена интеграция сборки `Jenkins` с `Telegram`.
> </br>
>
> <details> 
> <summary>Примеры (скриншоты).</summary>
> </br></br>
>
> **После выполнения теста (при запуске на Jenkins) `Telegram-бот` пришлет оповещение в специально-созданный Telegram-канал**</br>
> _со краткой статистикой пройденных тестов_
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
> </details>

</br>


<a name="video"></a>
### Примеры видео выполнения тестов на Selenoid

> <details> 
> <summary>Несколько примеров выполнения тестов.</summary>
> </br></br>
>
> **После выполнения теста (при запуске на Jenkins) `Telegram-бот` пришлет оповещение в специально-созданный Telegram-канал**</br>
> _со краткой статистикой пройденных тестов_
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
> </details>

</br>


---
---
</br>



> [!NOTE]
> <details> 
> <summary>Несколько примеров выполнения тестов.</summary>
> </br></br>
>
> **После выполнения теста (при запуске на Jenkins) `Telegram-бот` пришлет оповещение в специально-созданный Telegram-канал**</br>
> _со краткой статистикой пройденных тестов_
> 
> | ![Alt name of image](/media/screenshots/scr3.png) |
> |-|
</details>




</br>
</br>
---
---


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



<details>
<summary>Tips for collapsed sections</summary>
  бла
  бла 
  бла
</details>



