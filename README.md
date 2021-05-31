# О проекте
Рест сервис, выполняющий CRUD операции над таблицей `product(id int, name varchar, amount int)` и один метод(`name`), который возвращает сумму полей `amount` по полю `name`.


# Для запуска 
### (из папки проекта в командной строке с установленным и запущенным *Docker*):
- `./gradlew build` для `*nix` // `gradlew build` для `Windows` (собрать программу `rest-service`)
- `docker-compose up` (запустить два сервиса: `postgres` и `rest-service`)
- через `Postman` или `curl` по адресу `http://localhost:8080/product`:
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
    

# Технологии
Spring boot, Spring data JDBC, Spring MVC, Gradle, Docker, Docker-compose, Postgres, Liquibase
