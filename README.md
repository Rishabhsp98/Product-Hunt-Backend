1. Majority of the APIs used in this project are exposed from JPA entity as it provides all types of customization.
2. Only GET Method have been allowed on the DB level APIs from JPA entity to ensure secured DB.
3. Only those Entity which are having annotation @RepositoryRestResource are exposing there Select queries , and it is ensured by spring.data.rest.detection-strategy = ANNOTATED.
4. This app only accepts HTTPS request only via server.ssl.enabled=true
5. A self-signed certificate has been generated - https://stackoverflow.com/questions/10175812/how-to-generate-a-self-signed-ssl-certificate-using-openssl
6. CORS mapping have been added for any request for port 4200 via https (local angular) using allowed.origins = https://localhost:4200
7. Project uses the buit in support for pagination from pageable response parameter for majority for REST APIs for products and cateories.
