# Product REST API

This is a simple project built with Spring Boot that allows you to manage products list.  



##  Functionality

It has basic CRUD operations:

- create a product
- get all products
- get a product by id
- update a product by id
- delete a product by id
  
 ## We can test it useing Postman
 1. We created product 'A' useing POST

 <img width="820" height="350" alt="image" src="https://github.com/user-attachments/assets/1280e818-e3c7-48a3-ab91-f6c0b3f8d400" />

 2. Useing GET we can see all our products, or search for some we need by adding it id

<img width="820" height="400" alt="image" src="https://github.com/user-attachments/assets/99de29c2-06b5-4604-a225-2dba21fff2a4" />
<img width="820" height="350" alt="image" src="https://github.com/user-attachments/assets/4c5f3b2e-45d1-44a7-a035-d1e4af0dc553" />

3. Also we can update some product useing PUT and it id
<img width="820" height="350" alt="image" src="https://github.com/user-attachments/assets/23a6d964-121a-4866-9d77-91a94b9dac0d" />

4. DELETE allows us to remove some product useing it id
<img width="820" height="325" alt="image" src="https://github.com/user-attachments/assets/a90d31c6-bab4-4bed-9be8-e9b56ec9088e" />

## Database

The project uses **H2 in-memory database**.

- Data is stored only while the application is running
- Tables are created automatically by Hibernate
- No external database installation is required

To open it you should:
1. Run your project;
2. Type http://localhost:8080/console in browser


  As you can see, all our changes in our database now
<img width="820" height="400" alt="image" src="https://github.com/user-attachments/assets/ad8e6862-4650-429e-83ec-aff3e64ee60c" />




  
