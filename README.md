# Authable
Authable is an enterprise ready to deploy Backend API product (Microservice / VM) for authentication / authorization ecosystem.

## Motivation
Coming across Time based OTP algorithm, made me realize a technology (having several benefits) not being actively implemented by many of the small and medium enterprises. Specially who are constantly looking for newer mechanism of securing their applications. However, the goal is that it can be deployed on a regular VM or as microservices with minor tweaks.

## Repo Overview
| Project |  Status  |   Summary |
| ------ | ------ | ------ |
| authable-core-api | Under Development | The heart and mind of all features |
| authable-core-admin | Not Started | Administration panel for admin users to view logs and events of onboarded users |
| authable-web | Not Started | An internet facing web connector for QR-Scan based on SSE.  |
| authable-docs | Not Started | Documentation on "How to Get Started" |
| authable-mobile-flutter | Not Started | A sample implementation of QR and TOTP on mobile app using flutter framework |
| example-consumer-app | Not Started | A sample application demostrating how to consume core api and a simple web example of usecases |

## Features envisaged
| Feature |  Status  |   Summary |
| ------ | ------ | ------ |
| Time Based OTP | Under Development | A Time based OTP module |
| QR Auth | Not Started | A Password less login using QR |
| Regular OTP | Not Started | Why Should your OTPs be in your core system |
| In App OTP | Not Started | Move away from SMS OTPs |


## Architecture
1. The core middleware is based on Hexagonal architecture including a multi-maven project. Thus, avoid the conflict of not seggregating boundaries when building new features.
2. core middleware is never exposed to internet directly
3. The core middleware aggresively used Reactive Spring + Java 17 at its core, benefiting to extract more juice from your hosted machine
4. The maven modules have be designed in a way that you can easily break individual modules and write little code to convert them to microservices, if your usecase demands
5. The core is designed to handle integration with your multiple frontfacing applications. Thereby every application can have its own authentication / authorization hand picked.
6. Using Spring data, you can easily choose from various databases (SQL / NoSQL) to store (currently MySQL) your data.


## Security
1. System to System passwords use SHA512.
2. TOTP Secrets are ecnrypted using AES256. And the keys are stored in a encoded file on app server (Optionally you can use AWS CMK for storing the master key)
3. Secrets are encypted at REST and in Transit between caller and authable core (configuration).


## Usecases
1. Use the TOTP(Time based OTP) module as a 2FA for login in your existing applications(No cost).
2. Protect certain critical pages in your application with an additional auth factor.
3. Protect users from MITM, Keystroke, Phishing attack by implementation of TOTP
