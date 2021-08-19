docker build -f Dockerfile-mysql -t my-mysql-img .
docker build -f Dockerfile -t my-app-backend-img .

docker container run --name my-mysql-con -d -p 3306:3306 my-mysql-img
docker container run --name my-app-backend-con -d --link my-mysql-con my-app-backend-img 
