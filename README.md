# Shopping Cart System
## Architecture
I divided the proyect in 3 principal microservices:
### 1. **Order Service**
It manages the creation, reading, and updates of the orders.
### 2. **Product Service**
It works as a proxy to the external API FakeStoreAPI.
### 3. **Payment Service**
It simulates the payment process of an order.

##Tecnical Decisions
I decided to not implement authentication and authorization because in the requirements it's specified that Customers only need an entity and DTO without any endpoints to login or register. I believe the system is functional without needing JWT or OAuth.
