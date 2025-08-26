# 🏦 JavaCore Project – Bank transfers

## 📌 Description

#### The project implements a simple system for processing bank transfers without a database, only on Java Core.

## Main features:

* ###### Storing accounts and their balances in a text file (accounts.txt);
* ###### Reading translations from input files (input/*.txt);
* ###### Making transfers between accounts;
* ###### Recording the result in a report (report.txt);
* ###### Archiving processed files into the archive folder.

## 📂 Project structure

#### JavaCore_Project/
##### ├── accounts.txt           # File with accounts (number;balance)
##### ├── input/                 # Input files with operations
##### ├── archive/               # Processed files are moved here
##### ├── report.txt             # Report on all operations
##### ├── src/JavaCore_Project/
##### │   ├── Main.java          # Entry point
##### │   ├── Model/             # Models (Account, Transfer)
##### │   ├── Service/           # Services(ParserService, TransferService, ReportService)
##### │   └── Exceptions/        # Custom exceptions

## 📑 File Format

### accounts.txt

##### The file stores a list of accounts:
###### 1001;5000
###### 1002;3000
###### 1003;7000

##### Where:
###### 1001 – account number
###### 5000 – balance

### Input files in the input folder
##### Each line is a translation:
###### 1001;1002;1000
###### 1003;1002;500
###### 1002;1001;200

##### Where:
###### 1001 – sender's account
###### 1002 – recipient's account
###### 1000 – transfer amount

##### `Exception lines (incorrect format, negative amount, non-existent account) will be included in report.txt with the Exception mark.`

### report.txt

##### After execution, the program writes a log:

###### date&time | input1.txt | from:1001 | to:1002 | amount:1000 | Successfully.
###### date&time | input1.txt | from:1003 | to:1002 | amount:9000 | Exception:Insufficient funds.

## 🚀 Project launch

##### Make sure you have Java 17+ installed
###### java -version

##### Compile the project:
###### javac -d out src/JavaCore_Project/**/*.java

##### Run:
###### java -cp out JavaCore_Project.Main

## ▶️ Usage

### After launching the program will ask:

#### Enter the operation number to perform:
##### 1 - process files from input
##### 2 - show report

###### 1 → performs all translations from input, generates a report and transfers processed files to archive.

###### 2 → displays a hint where to look for report.txt

## ⚠️ Exception Handling

#### Invalid account → report entry: Exception: Invalid account number
#### Insufficient funds → entry: Exception: Insufficient funds
#### Invalid line format in input file → entry: Exception: Invalid line
#### The program does not terminate on errors - all operations are recorded in report.txt

## 🛠️ Technologies

#### Java Core

#### Working with files (java.io, java.nio.file)

#### Exceptions (IOException, NumberFormatException (кастомные TransferException, InvalidAmountException))

#### Collections (HashMap, List)

### 📌 This project demonstrates the basics of working with files, collections, exceptions, and the structure of Java applications without using a database.