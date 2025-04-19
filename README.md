# ms-pdv-bms-restaurant

// PARA CRIAR UMA INSTANCIA DE MYSQL EM UM CONTAINER DOCKER

MYSQL INSTANCE ->>>>>>>>>>>
$docker run --name docker-mysql -p 3306:3306 -p 33060:33060 -e MYSQL_ROOT_HOST='%' -e MYSQL_ROOT_PASSWORD='root' -d mysql/mysql-server:latest

// STARTAR ou PARA a instancia MYSQL
$docker start docker-mysql
$docker stop docker-mysql

// CASO QUEIRA ACESSAR O MYSQL PELO PROMPT DE COMANDO
$sudo docker exec -it docker-mysql mysql -uroot -proot

create database restaurant_dev;
create database restaurant_local;
create database restaurant_prod;
create database restaurant_qa;

create user 'admin_dev'@'%' identified by 'admin_dev';
grant all on restaurant_dev.* to 'admin_dev'@'%';

create user 'admin_local'@'%' identified by 'admin_local';
grant all on restaurant_local.* to 'admin_local'@'%';

create user 'admin_prod'@'%' identified by 'admin_prod';
grant all on restaurant_prod.* to 'admin_prod'@'%';

create user 'admin_qa'@'%' identified by 'admin_qa';
grant all on restaurant_qa.* to 'admin_qa'@'%';

