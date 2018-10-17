## Project Details
* A sample spring boot JPA project to demonstrate different annotations of JPA.
* One GET REST method exposed to return a list of notifications from in-memory H2 DB.
* Project is enabled with AWS code pipeline CI/CD capability.
* Once a commit is pushed to this repo the following happens automatically:
  * AWS code pipeline will download the source code from github.
  * AWS Code build will do a maven buid to generate the jar file.
  * AWS Code build will build a docker image with the generated jar file.
  * The docker image is then pushed to AWS ECR.
  * AWS code deploy will deploy the latest docker image to an ECS service.

## Additional Links
* https://docs.aws.amazon.com/AmazonECS/latest/developerguide/ecs-cd-pipeline.html
* https://stackoverflow.com/questions/52663698/aws-fargate-deploy-invalid-action-configuration-the-aws-ecs-container-do

## Code Pipeline
<img width="895" alt="screen shot 2018-10-12 at 9 46 06 pm" src="https://user-images.githubusercontent.com/6800366/46865608-dbd72c80-ce69-11e8-8a29-bb79e1fd2773.png">


| Annotation    | Meaning                                             |
| ------------- |:---------------------------------------------------:|
| @Component    | generic stereotype for any Spring-managed component |
| @Repository   | stereotype for persistence layer                    |
| @Service      | stereotype for service layer                        |
| @Controller   | stereotype for presentation layer (spring-mvc)      |


## Accessing H2 Console

http://localhost:8080/h2-console/
