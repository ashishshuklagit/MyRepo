## Reward Points Calculator AP ##
# Overview #
This Spring Boot application provides a RESTful API to calculate reward points for customers based on their transaction amounts over a three-month period.

## How it Works
For every dollar spent over $100 in each transaction, the customer receives 2 points.

For every dollar spent between $50 and $100, the customer receives 1 point.

Transactions below $50 do not earn any points.

## Technologies Used #
Spring Boot,

Spring Tool Suite,

Maven,

Java,

H2.

## API Endpoints #
'POST /addData' - To save the data in DB for three month's trsnsaction by customer.

__sample data__
<img width="472" alt="image" src="https://github.com/user-attachments/assets/825b9653-93e3-43fc-a574-a8d9f64117a7">

    
'GET /getMonthaly/{customerId}' To fetch the monthaly transaction for each customer.

__sample request__
http://localhost:8080/getMonthaly/cust1?startDate=2024-05-01&endDate=2024-08-31.

response-

<img width="446" alt="image" src="https://github.com/user-attachments/assets/b7bfae21-ee5f-44b8-b68c-3b233863c7dd">

'GET /getTotal/{customerId}' For fetching the sum of points earned during three months by perticular customer.

# sample request
http://localhost:8080/getTotal/cust1?startDate=2024-05-01&endDate=2024-08-31.

response-

<img width="140" alt="image" src="https://github.com/user-attachments/assets/8f3e9316-00ff-4834-9f2c-ac503e5646c8">


# Data Model
## CustomerTransaction #
'id': Integer,

'customerId': String,

'date': LocalDate,

'amount': Long
