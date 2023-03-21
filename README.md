# springboot-testing

Junit jupiter 5.9.2

### Note
- We can config runtime db (mysql) and testing db (h2) seperate in a project <br>
- Can prepare data for test by initial data (create default file data.sql which spring boot auto handle) or use @sql file on every declare method test
- Use @mockbean instead of @mock. And dont need @InjectMock, can use @autowrite instead of
- Can use @TestPropertySource("/application-test.properties") to specific properties for a test class


# JPA-Hibernate
- If use H2 embedded db to test. Access http://localhost:8080/h2-console for db management UI
- IF create 2 data.sql file in src/main/resources and src/test/resource, when run unit test, it will run both  sql in those file. So be careful with this note
- Using bellow setting to avoid the above:
> spring.sql.init.schema-locations=classpath:schema-dev.sql
> spring.sql.init.data-locations=classpath:data-dev.sql

