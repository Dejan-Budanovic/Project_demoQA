```markdown
# Project_demoQA

**Junior-level QA Automation practice project** for **DemoQA – Elements section**  
[https://demoqa.com/](https://demoqa.com/)

This project contains **automated UI tests** created as part of learning and practicing **QA automation fundamentals**. The tests validate the behavior of selected **Elements** on the DemoQA website and demonstrate basic automation skills using Java and Selenium.

---

## 📌 Project Scope

Automation testing is implemented for the following **Elements** on DemoQA:

- **Text Box**
- **Check Box**
- **Radio Button**
- **Web Tables**
- **Buttons**
- **Links**

❗ The following sections were **not included** in this project:

- Broken Links & Images  
- Upload and Download  
- Dynamic Properties  

---

## 🤖 Automation Testing Overview

This project focuses on:

- Writing beginner-friendly automated UI tests  
- Locating web elements using common Selenium strategies  
- Validating UI behavior and basic user interactions  
- Running tests using Maven  

Test data for Web Tables is externalized using Excel (`webtablesdata.xlsx`) to practice **data-driven testing basics**.

---

## 🧰 Tech Stack

- **Java** – programming language  
- **Selenium WebDriver** – UI automation  
- **Maven** – build and dependency management  
- **TestNG / JUnit** – test execution framework  
- **Apache POI** – reading test data from Excel  

---

## 📁 Project Structure

```text
Project_demoQA
├── src/                     # Automation test classes
├── target/                  # Build output
├── pom.xml                  # Maven configuration
├── webtablesdata.xlsx       # Test data for automation
```

---

## ⚙️ Setup & Installation

### Prerequisites

- Java JDK installed  
- Maven installed  
- IDE (IntelliJ IDEA or Eclipse)  
- Supported browser (e.g., Chrome)  

### Clone the Repository

```bash
git clone https://github.com/Dejan-Budanovic/Project_demoQA.git
cd Project_demoQA
```

### Install Dependencies

```bash
mvn clean install
```

---

## ▶️ Running the Tests

Run all automated tests using Maven:

```bash
mvn test
```

Tests can also be executed directly from your IDE.

---

## 🎯 Learning Goals

This project was created to practice and demonstrate:

- Basic **QA automation concepts**  
- Writing and organizing automated test cases  
- Working with **Selenium WebDriver**  
- Using **Maven** in a test automation project  
- Simple **data-driven testing** techniques  

---

## 👤 Author

**Dejan Budanovic**  
Junior QA Software Tester

---

## 📝 License

This project is provided for **learning and demonstration purposes**.  
No license is currently applied.    
```
