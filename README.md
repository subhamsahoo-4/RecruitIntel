# RecruitIntel

RecruitIntel is a Spring Boot + Selenium based LinkedIn candidate discovery system that automates the process of finding 2024/2025 graduate profiles and exporting candidate information.

## Features

* LinkedIn authenticated session handling
* Automated LinkedIn profile discovery
* Filters 2024 and 2025 graduate candidates
* Extracts candidate names and LinkedIn profile URLs
* REST API support
* CSV export support
* H2 Database integration
* Spring Data JPA persistence

---

## Tech Stack

* Java 17
* Spring Boot
* Selenium WebDriver
* Spring Security
* OAuth2
* H2 Database
* Maven

---

## APIs

### Start Scraping

```http
GET /scrape
```

Starts LinkedIn profile scraping.

---

### Get Students

```http
GET /students
```

Returns scraped candidate data in JSON format.

---

### Export CSV

```http
GET /export-csv
```

Exports candidate data into CSV format.

---

## JSON Response Example

```json
[
  {
    "name": "Abhijeet Gupta",
    "profileUrl": "https://www.linkedin.com/in/abhijeet-gupta-740aba259/"
  }
]
```

---

## Database

H2 database console:

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:file:./data/recruitintel
```

---

## How To Run

### Clone Repository

```bash
git clone <repo-url>
```

### Run Application

```bash
mvn spring-boot:run
```

### Open APIs

```text
http://localhost:8080/scrape
http://localhost:8080/students
```

---

## Project Structure

```text
controller/
service/
repository/
entity/
dto/
config/
```

---

## Author

Subham Sahoo
