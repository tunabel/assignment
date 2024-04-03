1. Try to explain what Singleton pattern is and write a sample code. 

Answer: 
- The Singleton pattern is a design pattern that ensures a class has only one instance and provides 
a global point of access to that instance. It is useful when you want to restrict the instantiation 
of a class to only one object
    Follow `org.example.assignment.config.Logger`
- Read more [here](./src/main/java/org/example/assignment/config/Logger.java)
2. Try to explain the difference between public, private, protected and package.

Answer:

- public: Members marked as public are accessible from any other class. This means they can be 
accessed from within the same package or from outside the package. For example, a public method in
a class can be called from any other class.
- private: Members marked as private are accessible only within the same class. They cannot be 
accessed from outside the class, not even from subclasses. This ensures encapsulation and hides
the implementation details of a class. For example, private fields can only be accessed and 
modified by methods within the same class.
- protected: Members marked as protected are accessible within the same package and by subclasses, 
even if they are in different packages. This allows subclasses to access and modify these members 
but restricts access from classes outside the package that are not subclasses. It's a way to provide
encapsulation while still allowing subclasses to access certain members.
- package (default): Members without any access modifier (package-private) are accessible only 
within the same package. They cannot be accessed from outside the package, not even from subclasses 
in other packages. This provides a level of encapsulation within the package, restricting access to
only classes within the same package.

3. Try to explain the difference between ArrayList and LinkedList and what scenario will be suitable for each.

Answer: 

ArrayList:

+ Underlying data structure: Dynamic array.
+ Elements are stored in a contiguous memory block.
+ Access time: O(1) for random access (by index).
+ Insertion/deletion time: O(n) for inserting or deleting elements in the middle of the list (since elements may need to be shifted).
+ Iterating through elements: Generally faster compared to LinkedList due to better cache locality.
+ Suitable for scenarios where random access or search by index is frequent, but insertion and deletion operations are less frequent or primarily performed at the end of the list.
+ Memory overhead: ArrayList requires less memory overhead per element than LinkedList since it does not need to store references to next/previous elements.
- LinkedList:

+ Underlying data structure: Doubly linked list.
+ Elements are stored as nodes, where each node holds a reference to the next and previous nodes.
+ Access time: O(n) for random access since elements need to be traversed sequentially from the beginning or end of the list.
+ Insertion/deletion time: O(1) for inserting or deleting elements at the beginning or end of the list. O(n) for inserting or deleting elements in the middle (although faster than ArrayList due to less shifting).
+ Suitable for scenarios where frequent insertion or deletion operations are required, especially in the middle of the list, and random access/search by index is less frequent or not required.
+ Memory overhead: LinkedList requires more memory overhead per element compared to ArrayList since it needs to store references to next and previous elements.

Choosing between ArrayList and LinkedList:

Use ArrayList when:

+ Random access by index is frequent.
+ Elements are primarily added or removed at the end of the list.
+ Memory overhead needs to be minimized. 

Use LinkedList when:

+ Frequent insertion or deletion operations are required, especially in the middle of the list.
+ Random access by index is not frequent or not required.
+ Memory overhead is not a concern, and flexibility in adding/removing elements is more important.

4. Try to write the code will lead to deadlock.

Following: `org.example.assignment.service.StudentService` 

Read more [here](./src/main/java/org/example/assignment/service/impl/StudentServiceImpl.java)
` doSomethingDeadlock()`

5. What is the purpose of thread pool	

- A thread pool is a collection of pre-initialized threads that are available for performing tasks, allowing for better resource management and improved performance in multithreaded applications. The primary purpose of a thread pool is to manage the creation, lifecycle, and execution of threads, thereby avoiding the overhead of creating a new thread for each task.

6. Try to write a function with recursion to implement the highest common factor calculation.

   public static int calculatehighestCommonFactor(int a, int b) {
        if (b == 0) {
          return a;
        } 
        return calculatehighestCommonFactor(b, a % b);
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 60;
        System.out.println("highestCommonFactor of " + num1 + " and " + num2 + " is: " + calculatehighestCommonFactor(num1, num2));
    }
7. Java8 provides the stream feature, try to use it to sum 1 to 10 without for loop.

Following: `org.example.assignment.service.StudentService`

Read more [here](./src/main/java/org/example/assignment/service/impl/StudentServiceImpl.java)`setScore()`

8. Please design a database schema to store students, classes and score.

   Following: `/src/main/resources/db/changelog/15280020240402_create_table.xml`

   Read more [here](./src/main/resources/db/changelog/15280020240402_create_table.xml)

9. Try to explain database normalization and denormalization.

Database Normalization:

- Normalization is the process of organizing data in a database efficiently. It involves breaking down a database into smaller, more manageable tables and defining relationships between them. The goal of normalization is to eliminate redundant data and ensure that each piece of information is stored in only one place.
- There are several normal forms (1NF, 2NF, 3NF, BCNF, etc.), each representing a higher level of normalization. The most commonly used are:
- First Normal Form (1NF): Ensures that each column contains atomic values, meaning there are no repeating groups or arrays within a column.
- Second Normal Form (2NF): Ensures that all non-key attributes are fully functional dependent on the primary key. It eliminates partial dependencies.
- Third Normal Form (3NF): Ensures that all non-key attributes are non-transitively dependent on the primary key. It eliminates transitive dependencies.

Database Denormalization:

- Denormalization is the process of deliberately adding redundancy to a database in order to improve performance. While normalization aims to reduce redundancy, denormalization aims to increase it strategically to optimize certain types of queries.
- Denormalization is often used in read-heavy applications or in situations where performance is critical and data integrity can be maintained through careful planning and maintenance. Some common denormalization techniques include:
- Adding Redundant Columns: Introducing additional columns in a table to store precomputed or derived values that would otherwise require complex joins or calculations.
- Flattening Hierarchies: Instead of storing hierarchical data in multiple related tables, denormalization involves combining the related data into a single table, which simplifies queries but may introduce redundancy.
- Duplication of Data: Duplicating data across tables to eliminate the need for joins, thus reducing query complexity and improving performance

10. Try to explain the RESTful API and design an API with RESTful format.

- A RESTful API (Representational State Transfer) is an architectural style for designing networked applications. It is based on a set of principles that define how web standards such as HTTP and URIs (Uniform Resource Identifiers) are used to create, read, update, and delete resources. RESTful APIs are designed to be scalable, flexible, and easy to understand.


Following: `org.example.assignment.controller.StudentController`
Read more [here](./src/main/java/org/example/assignment/controller/StudentController.java)
)


Endpoints:


GET /students: Retrieve a list of all students.

GET /students/{id}: Retrieve details of a specific student.

POST /students: Create a new student.

PUT /students/{id}: Update details of a specific student.

DELETE /students/{id}: Delete a specific student.

Request and Response Examples:

- GET /students

Response:

`[
{
"id": 1,
"name": "F. Scott Fitzgerald"
},
{
"id": 2,
"name": "Harper Lee"
}
]`

- GET /students/1

Response:

`{
"id": 1,
"name": "F. Scott Fitzgerald"
}`

- POST /students

Request:

`{
"name": "George Orwell"
}`

Response:

`{
"id": 3,
"name": "George Orwell"
}`
- PUT /students/3

Request:

`{
"id": 1,
"name": "George Orwell"
}`

Response:

`{
"id": 1,
"name": "George Orwell"
}`

- DELETE /students/3

Response: 204 No Content