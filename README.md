# Tournament table service for matches

Этот проект позволяет создавать матчи, команды.
В сервисереализованы такие методы как:
getStandings - получает турнирную таблицу исходя из матчей за определённую дату.
createMatch - создаёт матч исходя из переданных параметров.

## Содержание

- [Технологии] Java 21, Spring Boot, Lombok, MapStruct, Spring Data JPA, Flyway, PostgreSQL, JUnit
- [Запуск] запустить проект можно с помощью команды ./gradlew bootRun
- [Авторы] Nikita Shvetsov

## Технологии

- Язык программирования: Java 21 
- Сборщик проекта: Gradle
- База данных: PostgreSQL
- Тестирование: JUnit, Mockito
- Маппинг данных: MapStruct
- Взаимодействие с бд: Spring Data JPA
- Миграция: Flyway

## Установка и настройка

### Предварительные требования

- Java 21
- PostgreSQL
- Gradle

### Установка зависимостей

1. Клонируйте репозиторий:
   ```sh
   [git clone https://github.com/your-username/your-project.git](https://github.com/PlayerOfName/quetion_two.git)
   ```

2. Установите Gradle (если еще не установлен):
   - [Инструкции по установке Gradle](https://gradle.org/install/)

3. Инициализируйте проект:
   ```sh
   ./gradlew build
   ```

### Настройка базы данных

1. Установите и запустите PostgreSQL.
2. Создайте базу данных:
   ```sql
   CREATE DATABASE your_database_name;
   ```

3. Настройте параметры подключения в `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=none
   ```

## Тестирование

Запустите тесты:
```sh
./gradlew test
```
