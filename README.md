# Spring GraphQL Practice:

## GraphQL:
- GraphQl is a query language to retrieve exactly the data requested by the client.
- It is an alternative to REST, SOAP or gRPC.

### Example Query:
```graphql
type Query{
    getAllStudents: [Student]    
}

type Student{
    id: ID!
    name: String!
    course: String!
    roll: Int!
}
```

## Spring Setup for GraphQL
- Use the `spring-boot-starter-graphql` dependency.
- Create a schema at `/resources/graphql`.

## Schemas
- GraphQL Server exposes a schema describing the API.
- The Schema consists of type definitions.
- Each type has one or more fields, each taking 0 or more arguments and returning a specific type.

### Schema Example:
```graphql
type Student{
    id: ID!
    name: String!
    course: String!
    roll: Int!
}
```

## Query
- A Query is a read operation used to request specific data from the server.
- It allows clients to specify exactly what data they need.

### Query Example
```graphql
type Query{
    getAllStudents: [Student]    
}

type Student{
    id: ID!
    name: String!
    course: String!
    roll: Int!
}
```

- This query can be used in our controller using `@QueryMApping` resolver methods.

```java
@Controller
public class StudentController{
    @QueryMapping
    public List<Student> getAllStudents(){
        // logic to fetch the all student
    }
}
```

## Mutation
- It is an operation used to modify data on the server.
- Create, Update or delete data on the server.

### Mutation Example
```graphql
type Mutation{
    addStudent(id: ID!, name: String!, course: String!, roll: Int!) : Student!
}
```
- In Spring Boot, use `@MutationMapping` annotation or resolver method.

```java
@Controller
public class StudentController{
    @MutationMapping
    public Student addStudent(@Argument Long id, @Argument String name, @Argument String course, @Argument int roll) {
        // logic to create student
    }
}
```