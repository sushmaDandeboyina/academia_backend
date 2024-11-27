## Student Fee Payment System
### Description

The Student Fee Payment System is a Spring Boot application that allows students to manage and pay their fee bills. Students can log in to the portal, view their pending bills, and make payments in multiple installments. The system tracks all payments and provides details of transaction history for each bill.

### Features

    * Student account registration and login with JWT authentication.
    * Display all pending bills for a logged-in student.
    * Payment of bills in multiple installments.
    * View transaction history for each bill.
    * Secure backend API using JWT for authorization.

### Technologies Used

    * Spring Boot: Application framework.
    * Hibernate/JPA: For database operations.
    * React: Frontend integration (if applicable).
    * JWT (JSON Web Token): For secure user authentication and verification.
    * MySQL/PostgreSQL: Database for storing user, bill, and transaction information.

### Prerequisites

#### To run this project, you need:

    * Java 17 (or compatible version)
    * Maven 3.6+ or Gradle
    * A database (e.g., MySQL)
    * (Optional) Node.js and npm (if using React for the frontend)
    * A REST client like Postman for testing the APIs.

### API Endpoints
#### HTTP Method	     Endpoint	                                                  Description
     POST      	/academia/v1/student/login	                         Log in a student using JWT authentication
     POST	      /academia/v1/student/create_account	                 Register a new student account
     GET	      /academia/v1/student/bills	                         Retrieve all bills of the logged-in student
     POST	      /academia/v1/student/bills/pay	                     Pay a bill (partial or full)
     GET	      /academia/v1/student/bills/payments	                 Retrieve payment transactions for a specific student and bill


### Installation and Setup
#### Backend (Spring Boot)

##### Clone the repository:

  git clone https://github.com/your-username/student-fee-payment.git
  cd student-fee-payment

##### Configure the application properties: Update src/main/resources/application.properties or application.yml with database and JWT secret details:

spring.datasource.url=jdbc:mysql://localhost:3306/student_fee_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
jwt.secret=your_jwt_secret
server.port=8080

##### Build and run the backend:

mvn clean install
mvn spring-boot:run



