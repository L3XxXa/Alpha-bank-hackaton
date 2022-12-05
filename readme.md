## Документация backend-части приложения «Alfa Wallet»

### [Cntroller](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/Controller)

Отвечает за взаимодействие серверной части приложения и клиента. Существует 2 вида контроллеров: **CardController** и **UserController**:

#### UserController:

1) register — отвечает за регистрацию пользователя в системе. Принимает email и пароль пользователя. Проверяет, что email не зарегистрирован в системе. Если email повторяется, выбрасывается созданный Exception — *AlreadyUserExit*. Если email не повторяется, обращается к UserRepositoriy, после этого преобразует DTO в Entity.

2) login — принимает DTO, ищет пользователя в UserRepositoriy по email, берет модель из базы данных и сравнивает пароли. Если пользователя с запрашиваемым email не существует, то бросает *InvalidData*, который говорит что почта была неверна. Если пароли совпадают, то клиенту возвращается *true* и сообщение «Login successfully added».

3) getUsers — GET-запрос, обращается к **UserService** и выдает всех пользователей из базы данных.

4) getMappig (по пользователю) — принимает id, обращается к сервису и вызывает функцию getUserById, если найден, то преобразует Entity в DTO, иначе бросает Exception NotFound.

5) Delete User — Delete-запрос. Если пользователь найден, то он удаляется из БД, в противном случае бросает NotFoundException.

6) Update User — принимает DTO, находит пользователя в базе данных, изменяет текущую DTO-модель пользователя на переданную модель и сохраняет в базе данных, если не найдено, то бросает NotFoundException. 

7) refreshCards — принимает id, ищет пользователя с данным id в БД, после чего берет список карт и последние координаты, обращается к API 2GIS и последовательно передает запрос на поиск места выпуска каждой карты, далее находит ближайшие координаты данной точки, считает расстояние от пользователя до каждой из точек, далее сортирует по возрастанию расстояния. Обращается к БД карточек — каждой карточке приоритет от 0 до n (где n количество карточек у пользователя). Далее карточки сортируются по возрастанию приоритета. Карта с наименьшем приоритетом будет у пользователя первой.

#### CardController

1) addCard — добавляет карточку в БД, привязывает к пользователю. 
2) getCards — ищет данного пользователя в БД. Если пользователь не найден, то бросается NotFoundException, если пользователь найден, то выдает список карточек, которые привязаны к пользователю в порядке возрастания приоритета.
3) deleteCard — удаляет карту у пользователя. Если карточки нет, то бросается NotFoundException.

#### ArticleController

Служит для того, чтобы вылавливать ошибки и упаковывать их в BaseResponse.

### [Entity](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/Entity)

Модели для взаимодействия с БД:

#### User:

- id
- email
- пароль
- последняя координата по широте
- последняя координата по долготе

#### Card:

- id
- название карточки
- qr
- номер карточки
- приоритет

### [DTO](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/DTO)

Представление Entity в бизнес-логике backend-части приложения.

### [Exception](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/Exception)

Существует 3 вида ошибок, которые наследуются от Runtime Exception:

- **Invaild data** — Появляется, когда пользователь ввел неверные данные для логгирования в системе.
- **Not Found Exception** — Появляется, когда передан запрос на взаимодействие с несуществующими данными.
- **User Already Exists** — Появляется, когда нарушается состояние unique в таблице юзеров и клиент пытается зарегистрировать пользователя, который уже есть в базе данных.

### [Mapper](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/Mapper)

**CardMapper** и **UserMapper** — Преобразование Entity в DTO и обратно.

### [Repository](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/Repository)

Взаимодействие с базой данных. С помощью него выполняются основные запросы: Find, Save, Delete, Update и т.д.

### [Service](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/Service)

Этап взаимодействия, на котором соединяется репозиторий и передача запросов клиенту: слой, на котором происходит преобразование модели БД в модель бизнес-логики и выбрасываются соответствующие исключения при возникновении ошибки.

### [Utils](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/java/newthread/server/backend/Utils)

Различные вспомогательные классы, такие как:

#### BaseResponse 

Общение с клиентом. Унифицированнный ответ, в нем хранится Generic-результат и строковое описание ответа. В случае ошибки в строковое описание ответа входит название ошибки, в случае успеха описывается процесс, который был запрошен клиентом, и то, как он был выполнен.

#### ApiConnector

Служит для создания соединения с API 2GIS и осуществление рассчетов, связаных с вычислением расстояния между точками на карте и пользователем.

#### SpringFoxCofig

Автоматическая генерация спецификаций API на основе Swagger.

### [Migrations](https://github.com/L3XxXa/Alpha-bank-hackaton/tree/newThread_mvp/server/backend/src/main/resources/db/migration)

Существует 4 версии миграции:

1) Создание таблицы пользователей
2) Частичное заполнение таблицы пользователей
3) Создание таблицы с картами
4) Частичное заполнение таблицы с картами

---

#### Команда «new Thread()»: 
- Малов Алексей
- Медведев Вальдемар
- Вебер Олег
- Третьяков Артём
