# Commons

Commons is a package that contains shared constants, objects and classes among the microservices. The reason of the usage of this dependency package is to avaoid code duplication and improve code reusabilty.

## Annotations
- ```@NotNull``` is used to mark a field as mandatory.
- This annotation is used in [MandatoryFieldValidator.java](https://github.com/orkungdk/commons/blob/master/src/main/java/tr/com/ogedik/commons/validator/MandatoryFieldValidator.java)
_____
## Constants
- This package contains shared constant variables by microservices. For instance, service and header names.
____
## Entity
- This package contains two different entity class. The reason of this package is to provide a common entity structure in the project. For instance, mete data usage.
  - [AbstractEntity.java](https://github.com/orkungdk/commons/blob/master/src/main/java/tr/com/ogedik/commons/entity/AbstractEntity.java): Abstraction of an entity class. Contains meta informations. (createdAt, createdBy, uodatedAt, updatedBy)
  - [ResourceEntity.java](https://github.com/orkungdk/commons/blob/master/src/main/java/tr/com/ogedik/commons/entity/ResourceEntity.java): Extends ```AbstractEntity.java``` and inherits resourceId field to the classes who extends this class.
____
## Exception
- This package contains a customized RunTimeException. Multiple ErrorMessages can be added to throw multiple errors at the same time.
- In the constants package, an enumurated needs to be defined that contains title and error code. So that error body can be initialized easily.
____
## Helper
- TokenHelper.java
     - Generated JWT Tokens and checks whether a token is expired or not.
____
## Mapper
- Abstraction of mappers. This class needs to be extended by all of the mappers so that, thanks to Mapstruct, creating a java class will be enought to generate mapper implementations.
____
## Rest
- Model
    - Request models that are consumed by controllers.
- Rest
    - This package contains a http request client to be able to send rest request easily. It is used to send a REST request from a microservice to the another microservice.
____
## Response
  - ## [CommonResponse.java](https://github.com/orkungdk/commons/blob/master/src/main/java/tr/com/ogedik/commons/response/CommonResponse.java)
    - This is a common return type of all methods in the constructors. Thanks to **Builder Pattern** an instance of this object can be generated.
  - ## [RestResponse.java](https://github.com/orkungdk/commons/blob/master/src/main/java/tr/com/ogedik/commons/response/RestResponse.java)
    - This response object is for the responses that are parsed by HttpRestClient. On the other word, this response object uses for the internal request results.
____
## Util
  - Contains utility classes for complex type Java objects.
____ 
## Validator
  - This package contains abstraction of a validator and the validation facade. ```Facade Pattern```is being used for validations.
  - MandatoryCheckValidator is a common validation class. This is a **singleton** classs. Instead of most of the validators in Scrumier, it is not a spring bean.
  
  
  ___
  
  # Contribution
  - ### Git flow
    - In order to be able to contribute this package, you need to fork this repository and clone it into your local.
    - Create a feature branch from master.
    - Push your changes to your feature branch on your fork.
    - Create a pull request from the feature branch on your fork to the master branch on this repository
  - ### Building Artifact
    - Add your authentication information to ~/.m2/settings.xml so that the github site-maven-plugin can push to GitHub
    ```xml
    <settings>
      <servers>
        <server>
          <id>github</id>
          <username>YOUR-USERNAME</username>
          <password>YOUR-PASSWORD</password>
       </server>
      </servers>
    </settings>
    ```
    - Run the following command and then you suppose to be able to see the new artifact in https://github.com/orkungdk/commons/tree/maven-repo
    ```bash
    mvn clean deploy
    
