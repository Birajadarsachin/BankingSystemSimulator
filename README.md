**Banking System Simulator (Core Java & OOPs)**

A modular Java console application that simulates real-world banking operations — including account creation, deposits, withdrawals, fund transfers, and balance inquiries.
Built using Core Java, OOP principles, collections, multithreading, and custom exception handling.

**🚀 Features**

👤 Account Creation: Auto-generates unique account numbers.

💰 Deposit & Withdraw: Validates all transactions and handles exceptions.

🔁 Fund Transfer: Safe transfer between accounts.

📊 Balance Inquiry: Displays account details neatly.

🧵 Multithreading: Simulates concurrent deposits/withdrawals with synchronization.

🧱 Robust Exception Handling: Manages invalid inputs and runtime issues gracefully.

**⚙️ Tech Stack**

Language: Java

IDE: IntelliJ IDEA

Concepts Used: OOP (Encapsulation, Inheritance, Polymorphism), Collections, Generics, Streams, Multithreading, Exception Handling

**🧩 How to Run**

1. Clone the repository

    a. git clone https://github.com/Birajadarsachin/BankingSystemSimulator

   b. cd BankingSystemSimulator


3. Open in IntelliJ IDEA or any IDE

4. Run Main.java (in the app package)

5. Follow the console menu instructions

---

### **Thread Safety Verification**

To ensure the system is **thread-safe**, a test class `TransactionSimulator.java` was used to simulate **concurrent deposits and withdrawals** on the same account using multiple threads.

**What We Did:**
- Two threads (`t1` and `t2`) performed deposits and withdrawals simultaneously.  
- The `Account` class methods (`deposit` and `withdraw`) were marked as `synchronized`.

** Outcome:**
- The final balance remained consistent (`2500.0`), proving there were **no race conditions**.  
- This verified that our synchronization logic works correctly under multithreaded access.



