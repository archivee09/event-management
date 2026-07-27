# Event Management REST API

A REST API built with Spring Boot and MySQL to manage events 
and attendee registrations with capacity control.

## Tech Stack
- Java 17
- Spring Boot 4.0.7
- Spring Data JPA + Hibernate
- MySQL
- Maven
- Tested with Postman

## Features
- Create and manage events with capacity limits
- Register attendees for events
- Prevents overbooking — returns error when event is full
- Cancel registrations
- View all attendees per event

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/events | Get all events |
| POST | /api/events | Create an event |
| GET | /api/events/{id} | Get event by ID |
| POST | /api/events/{id}/register | Register attendee |
| GET | /api/events/{id}/attendees | Get all attendees |
| DELETE | /api/attendees/{id} | Cancel registration |

## How to Run
1. Clone the repo
2. Create a MySQL database called `eventdb`
3. Update `application.properties` with your MySQL password
4. Run `mvn spring-boot:run`
5. API runs on http://localhost:8080

## Sample Request
POST /api/events
```json
{
    "name": "Tech Meetup",
    "date": "2026-08-01",
    "location": "Bengaluru",
    "maxCapacity": 50
}
```
