
# Codexist Case Study

This application is created for codexist for the case study purpose.

## Deployment

The project is on deployed and running on Google Cloud.

For be: https://codexist-be-by66nzg4wa-ew.a.run.app/ \
For fe: https://codexist-fe-by66nzg4wa-ew.a.run.app/

The steps for creating deployable image for backend application stated below;
```bash
docker build -t codexist-be . # creates a docker image for the application.
docker tag codexist-be gcr.io/{project-tag}/codexist-be:tag # create tag for the docker image
docker push gcr.io/{project-tag}/codexist-be:tag # push docker image to cloud
```

The steps for creating deployable image for frontend application stated below;
```bash
docker build -t codexist-fe . # creates a docker image for the application.
docker tag codexist-fe gcr.io/{project-tag}/codexist-fe:tag # create tag for the docker image
docker push gcr.io/{project-tag}/codexist-fe:tag # push docker image to cloud
```

After creating and pushing images for both the fe and be, we continue to Google Cloud run and create new service. When the new service created, we run a container.


## Tech Stack

FE:
- Vue.js

BE:
- Spring Boot
- Spring Data
- Jedis
- OpenFeign

For Deployment:
- Google Cloud Run
- Upstash (Redis)

## Running Tests

To run tests, run the following command

```bash
  mvn clean test
```


## Demo

You can see the demo by going to; https://codexist-fe-by66nzg4wa-ew.a.run.app/

## Note

The application is now running on 9090 port. Just by changing port in application.yml files and exposed port in Dockerfile (for BE) you can run in 8070 or another port as you wanted. When you changed the port, the deployment needs to be done again.