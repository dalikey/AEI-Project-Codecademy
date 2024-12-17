# AEI Project

This repository contains the **AEI Project**, a Java application developed as part of a Codecademy initiative. The project demonstrates core concepts of object-oriented programming, database interaction, and user input validation.

## Features

- **Database Integration:** CRUD operations on a database for managing `Cursist` (students).
- **Input Validation:** Includes utilities to validate user input such as email, date, gender, and postal code.
- **User Interface:** A basic JavaFX GUI for interacting with the application.
- **JUnit Testing:** Test cases for input validation methods.

## Project Structure

```
programma/
├── DB/               # Database connection and repositories
├── domain/           # Domain models (e.g., Cursist)
├── JunitTests/       # Unit tests for validation logic
├── logic/            # Input validation and business logic
└── ui/               # User interface controllers (JavaFX)
```

## Getting Started

### Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher.
- **JavaFX SDK:** For running the GUI components.
- **Database:** A running SQL database with a `Cursist` table.

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/dalikey/AEI-Project-Codecademy.git
   cd AEI-Project-Codecademy
   ```

2. Configure the database connection in `DatabaseConnection` class:
   ```java
   // Example configuration
   DatabaseConnection.connect("jdbc:mysql://localhost:3306/your_database", "username", "password");
   ```

3. Build and run the project using your preferred IDE (e.g., IntelliJ IDEA, Eclipse) or command-line tools.

4. Launch the application:
   ```bash
   java -jar AEI-Project.jar
   ```

### Database Schema

Ensure your database has the following table:

```sql
CREATE TABLE Cursist (
    CursistID INT AUTO_INCREMENT PRIMARY KEY,
    CursistEmail VARCHAR(255) NOT NULL,
    Naam VARCHAR(255) NOT NULL,
    Geboortedatum DATE NOT NULL,
    Geslacht VARCHAR(10) NOT NULL,
    Adres VARCHAR(255),
    Stad VARCHAR(100),
    Land VARCHAR(100),
    Postcode VARCHAR(10)
);
```

## Key Classes and Functionalities

### `CursistRepo`
Handles CRUD operations for the `Cursist` entity:
- `create(Cursist)`
- `get()`
- `getCursist(int id)`
- `update(int id, Cursist)`
- `delete(int id)`

### `Validatie`
Provides static methods for input validation:
- `validatieEmail(String Email)`
- `validatieDatum(Date datum)`
- `validatieGeslacht(String gender)`
- `validatiePostcode(String postcode)`

### JUnit Tests
Located in `programma.JunitTests.MailToolsTest`, these tests ensure the robustness of validation logic.

### JavaFX UI
Interactive GUI for adding and managing `Cursist` entries, implemented in `AddCursistenController`.

## Running Tests

JUnit tests can be executed from your IDE or via the command line:

```bash
mvn test
```

## Contributing

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes and open a pull request.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for more details.

## Contact

For questions or feedback, please contact the repository owner through GitHub.
