# 🏦 Java CLI Banking App

A simple Java-based command-line banking application with two user roles: **Admin** and **User**, each with their own functionalities.

## 📥 Installation & Setup

### 1️⃣ Prerequisites  
Ensure you have the following installed:
- **Java (JDK 17 or later)** → [Download Here](https://www.oracle.com/java/technologies/javase-downloads.html)  
- **Git** (optional, for cloning the repository)

### 2️⃣ Clone the Repository  
Run the following command:
```sh
git clone https://github.com/AlaSww/Banking-System.git
cd your-repo-name
```
Or download the ZIP file and extract it manually.

### 3️⃣ Compile the Java Files  
Execute:
```sh
javac -d out src/*.java
```
This compiles the source code and stores the class files in the `out` directory.

### 4️⃣ Run the Application  
Start the banking app by running:
```sh
java -cp out BankingSystem
```

### 5️⃣ (Optional) Create an Executable JAR  
To generate a JAR file:
```sh
jar cfe banking-app.jar Main -C out .
```
Then run it using:
```sh
java -jar banking-app.jar
```

## 🚀 Features
- **Admin Role:** Manage user accounts, view transactions, etc.
- **User Role:** Check balance, deposit, withdraw, etc.

## 🛠️ Technologies Used
- **Java (CLI)**
- **OOP Principles**

## 📜 License
This project is open-source. Feel free to contribute!
