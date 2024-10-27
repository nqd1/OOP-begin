```mermaid
classDiagram
    BankSystem <|-- BankAccount
    BankSystem <|-- Transaction

    class BankSystem{
        +messagePane(String, String)
        +main(String[])
    }

    class Transaction{
        -LocalDateTime dateTime
        -String type
        -double amount
        -double balanceAfter
        +Transaction(type, amount, balanceAfter)
        +toString()
    }

    class BankAccount{
        -String accountHolder
        -double balance
        -double monthlyInterestRate
        -int withdrawalInThisMonth
        -List~Transaction~ transactionHistory
        +BankAccount(accountHolder, initialBalance)
        -addTransaction(type, amount)
        +menu()
        -deposit()
        -withdraw()
        -checkBalance()
        -calculateMonthlyInterest()
        -showTransactionLog()
    }