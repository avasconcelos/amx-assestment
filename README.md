# REST API AMX-Assignment

The assessment consists of an API to be used for opening a new “current account” of
already existing customers.
Requirements

• The API will expose an endpoint which accepts the user information (customerID,
initialCredit).

• Once the endpoint is called, a new account will be opened connected to the user
whose ID is customerID.

• Also, if initialCredit is not 0, a transaction will be sent to the new account.

• Another Endpoint will output the user information showing Name, Surname,
balance, and transactions of the accounts

## Build

    gradle clean build

## Docker build

    docker build -t amx-assestment .

## Docker run

    docker run -p 8080:8080 amx-assestment

# REST API

The REST API to the assestment app is described below.

## Create User

### Request

`POST /api/users`

    curl --request POST --url http://localhost:8080/api/users --header 'Content-Type: application/json' --data '{ "name": "Alfafa", "surname": "Vasconcelos" }'

### Response

    HTTP/1.1 201 Created
    {
        "id": 1,
        "name": "Alfafa",
        "surname": "Vasconcelos"
    }

## Open Account

### Request

`POST /api/accounts/open`

    curl --request POST --url http://localhost:8080/api/accounts/open --header 'Content-Type: application/json' --data '{ "customerId": 1, "initialCredit": 10.0 }'

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36

    {"id":1,"name":"Foo","status":"new"}

## Get user accounts info

### Request

`GET /api/users/{id}/info`

    curl --request GET --url http://localhost:8080/api/accounts/users/1/info'

### Response

    HTTP/1.1 200 OK

    {
        "name": "Alfafa",
        "surname": "Vasconcelos",
        "accounts": [
            {
                "accountId": 1,
                "balance": 1021.0,
                "transactions": [
                    {
                        "transactionId": 1,
                        "amount": 1021.0
                    }
                ]
            }
        ]
    }
    
