# О проекте
Рест сервис, выполняющий CRUD операции над таблицей `product(id int, name varchar, amount int)` и один метод(`name`), который возвращает сумму полей `amount` по полю `name`.

#Для запуска:
- На машине, с установленным Docker, в командной строке с `Bash`: `docker-compose up`. Это запустит два сервиса: `postgres` и `rest-service`.
- В сервисе http запросов например `Postman` или через командную строку с помощью утилиты `curl` по адресу http://localhost:8080/product запросов доступны команды:
    - GET: 
      - `""`; все доступные продукты
      - `"/{id}"`; найти по `id`
      - `"/sumAmountByName/{name}"`; посчитать сумму значений поля `amount` для всех продуктов имени `name`
    - POST:
      - `""`; добавить продукт
    - PUT: 
      - `"/{id}"`; обновить по `id` 
    - DELETE: 
      - `"/{id}"`; удалить по `id`
    
#Технологии
Spring boot, Spring data JDBC, Gradle, Docker, Docker-compose, Postgres, Liquibase
