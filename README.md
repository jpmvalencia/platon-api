# PlatonAPI

PlatonAPI is an API designed to manage student enrollments in subjects across various careers. The variant used for this API is **Variante B**.

## Base URL

The base URL for all requests is:

`base_url=http://localhost:8080/platon_api_war_exploded`

## Endpoints

### 1. Get all enrollments (GET)

**Endpoint:**

`GET {{base_url}}/inscriptions`

**Response:**

```json
{
    "message": "inscriptions retrieved successfully",
    "statusCode": 200,
    "data": [
        {
            "id": 1,
            "student": "John Doe",
            "document": 98765432,
            "career": "Computer Science",
            "subject": "Advanced Programming",
            "semester": "2023-2",
            "enrollmentDate": "2023-06-01",
            "status": "Active"
        },
        {
            "id": 2,
            "student": "Jane Smith",
            "document": 54321987,
            "career": "Business Administration",
            "subject": "Marketing Strategies",
            "semester": "2022-3",
            "enrollmentDate": "2022-09-15",
            "status": "Cancelled"
        }
    ]
}
```

### 2. Create a new enrollment (POST)

**Endpoint:**

`POST {{base_url}}/inscriptions`

**Request Body:**

```json
{
    "student": "John Doe",
    "document": 98765432,
    "career": "Computer Science",
    "subject": "Advanced Programming",
    "semester": "2023-2",
    "enrollmentDate": "2023-06-01",
    "status": "Active"
}
```

**Response:**

```json
{
    "message": "inscription created successfully",
    "statusCode": 201,
    "data": [
        {
            "id": 1,
            "student": "John Doe",
            "document": 98765432,
            "career": "Computer Science",
            "subject": "Advanced Programming",
            "semester": "2023-2",
            "enrollmentDate": "2023-06-01",
            "status": "Active"
        }
    ]
}
```

**Error Responses:**

1. If the enrollment status is not **Active** or **Cancelled**:

```json
{
    "message": "inscription status is not Active or Cancelled",
    "statusCode": 500
}
```

2. If the student is already enrolled in the subject:

```json
{
    "message": "student already in subject",
    "statusCode": 500
}
```

3. If the student is already enrolled in 7 subjects:

```json
{
    "message": "student is already in 7 subjects",
    "statusCode": 500
}
```

### 3. Get enrollments by career (GET)

**Endpoint:**

`GET {{base_url}}/inscriptions/career?name=Computer Science`

**Response:**

```json
{
    "message": "inscriptions retrieved successfully",
    "statusCode": 200,
    "data": [
        {
            "id": 1,
            "student": "John Doe",
            "document": 98765432,
            "career": "Computer Science",
            "subject": "Advanced Programming",
            "semester": "2023-2",
            "enrollmentDate": "2023-06-01",
            "status": "Active"
        }
    ]
}
```

**Endpoint:**

`GET {{base_url}}/inscriptions/career?name=Business Administration`

**Response:**

```json
{
    "message": "inscriptions retrieved successfully",
    "statusCode": 200,
    "data": [
        {
            "id": 2,
            "student": "Jane Smith",
            "document": 54321987,
            "career": "Business Administration",
            "subject": "Marketing Strategies",
            "semester": "2022-3",
            "enrollmentDate": "2022-09-15",
            "status": "Cancelled"
        }
    ]
}
```
