# Power-Track || Java Embedded
* A Hardware is designed to measure the power usage of individual appliances in real time and push the data to SQL DB.
* Power Track is a Java-based console application designed to help users monitor and manage the power consumption of their household or office appliances.
* The system allows users to register appliances, track real-time energy usage, set monthly power budgets, and receive alerts when consumption exceeds the defined limit.
* It also provides helpful suggestions to reduce power usage, promoting energy efficiency and cost savings.
* User can control the appliance(on/off) through telegram bot.


# Tech stack
Frontend (Console Interface)
* Java – Console-based user interaction and application logic

Backend
* PHP – API scripts for handling HTTP requests from IoT and interacting with the database
* Apache – Web server to host PHP scripts

Database
* MySQL – Stores users, appliances, power usage logs, alerts

Networking & Protocols
* HTTP/HTTPS – Communication between IoT, server, and Telegram
* TCP/IP – Base protocol for network communication
* JDBC (TCP Port 3306) – Java to MySQL connection

Notification System
* Telegram Bot API – Sends alerts to users via Telegram


# ER Diagram:
![image](https://github.com/user-attachments/assets/928c4b33-df9a-4a61-aeb7-e61b77b7b19a)


# Components:
* ESP32 
* Current sensor  
* Voltage sensor 
* 5v Relay
* SMPS 230v AC - 5v DC 
* OLED Display
