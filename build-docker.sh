docker build -f Dockerfile-mysql -t my-mysql-img .
docker build -f Dockerfile -t my-app-backend-img .

docker container run --name my-mysql-con my-mysql-img
docker container run --name my-app-backend-con my-app-backend-img