# 🚀 Exercise 1 – Design Patterns in Java

Welcome to my **Java Design Patterns Showcase**!  
This project is built as part of my learning journey 👨‍💻 and demonstrates how common design patterns can be applied in a simple, human‑understandable way.

---

## 🧩 Patterns Covered

- 🎭 **Behavioral**
  - Strategy
  - Observer
- 🏗️ **Creational**
  - Builder
  - Factory
- 🏛️ **Structural**
  - Adapter
  - Facade

Each pattern is implemented with a **satellite theme 🛰️** so the examples feel connected and easy to follow.

---

## 📂 Project Structure

src/ ├── app/ │ └── Main.java ├── behavioral/ │ ├── StrategyDemo.java │ └── ObserverDemo.java ├── creational/ │ ├── BuilderDemo.java │ └── FactoryDemo.java └── structural/ ├── AdapterDemo.java └── FacadeDemo.java

Code

---

## ▶️ How to Run

From the project root:


javac -d out src/app/*.java src/behavioral/*.java src/creational/*.java src/structural/*.java
java -cp out app.Main
✅ Requires Java 17+ ✅ No external libraries — just pure Java

✨ Sample Output
Code
=== Behavioral Patterns ===
Direct rotation
Fuel saving rotation
Console: Satellite rotated

=== Creational Patterns ===
Built satellite facing South, panels=true, data=42
Factory: Created Satellite Mk I

=== Structural Patterns ===
Legacy system started
Adapter: Satellite rotated
Facade: Panels activated and data collected
💡 Why this project?
👀 Readable — each pattern is short and focused

🧑‍🤝‍🧑 Human‑themed — satellites, panels, and data instead of abstract “Foo” and “Bar”

🎯 Practical — one command to build and run

🌱 Learning‑oriented — designed to help me (and others) understand patterns quickly

---
---




Exercise 2

# 🛰️ Satellite Command System

---

## 🌟 Why This Project Exists
Instead of just being another coding exercise, this project is a mini‑simulation of real aerospace challenges.  
It shows how I think about state management, dependencies, and system design — skills that matter in any engineering role.

---

## 🚀 What It Can Do
- Rotate the satellite (North, South, East, West)  
- Switch solar panels on/off  
- Collect data (only when panels are active)  
- Maintain and update state across commands  

---

## 🧩 What Makes My Approach Different
- **Design Thinking:** I treated the satellite like a real system with dependencies (panels must be active before data collection).  
- **SOLID Principles:** Code is modular and extendable — adding new commands is simple.  
- **Error Handling:** Built‑in checks prevent invalid operations.  
- **Logging:** Every command leaves a trace, just like in mission control.  

---

## 📊 Example Mission Log

> rotate("South")
> activatePanels()
> collectData()

---

## 📊 Final State
- **Orientation:** South  
- **Solar Panels:** Active  
- **Data Collected:** 10  

---

## 🛠️ Tech & Tools
- **Language:** Java (object‑oriented design)
- **Patterns:** Command Pattern + State Management  
- **Extras:** Logging, exception handling  

---

## 💡 What I Learned
- How to design systems that mirror real‑world constraints  
- The importance of clean abstractions for long‑term maintainability  
- Thinking like an engineer, not just a coder  

---
