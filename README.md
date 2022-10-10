# docker-compose


## Integrated environment

| Configuration item | Description version number |
| ------------------------- | ------------------------------------- |
| docker | v18.02.0+ |
| docker-compose | v2.2.2+ |

### Recommended minimum hardware configuration

cpu : 4core
mem : 8G
disk: 40G

### install docker
```
sudo curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
```

### install docker-compose
```
sudo curl -L "https://get.daocloud.io/docker/compose/releases/download/1.27.3/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && sudo chmod +x /usr/local/bin/docker-compose
```

## command

- repo download and clone
```
git clone https://github.com/UDPN/BN-Sandbox-selfservice-public
```
- Enter the BN docker-compose directory
  
  `cd BN-Sandbox-selfservice-public/docker-compose`
- start BN
  
  `sudo docker-compose up -d`  
- stop BN
  
  `sudo docker-compose down`  

### upgrade iterative

The directory where the JAR file is located docker-compoes/bnserver. 
After you stop BN docker-compose, replace the source file with the new version of JAR, and then run BN docker-compose again.
You can download the latest JAR from https://github.com/UDPN/BN-Sandbox-selfservice-public/docker-compose/bnserver/*.jar.

### after deployment web address
Note: The system needs to use port 80,8080-8085,8761,3306,6379. If there is any conflict, please modify the .env file.

- EUREKA
    http://localhost:8761/
- Sandbox-web
    http://localhost/
- bn-web
    http://localhost:8080/

## .env configure

| BN-server item | Description |
| ------------------------- | ------------------------------------- |
| LOG_SAVE_DIR | Log directory storage address |
| VN_INIT_FILE | vninit.yml directory storage address |
| DID_PROXY_PROP_FILE | did_proxy.properties directory storage address |
| BN_DATA_VOLUMES | BN-server jar package directory storage address |
| EUREKA_CONTAINER_NAME | EUREKA name |
| EUREKA_PORT | EUREKA accessible port |
| EUREKA_USER | EUREKA user |
| EUREKA_PWD | EUREKA password |
| BN_INIT_CONTAINER_NAME | BN Init name |
| BN_INIT_PORT | BN Init accessible port |
| BN_EVENT_CONTAINER_NAME | BN Event name |
| BN_EVENT_PORT | BN Event accessible port |
| BN_GATEWAY_CONTAINER_NAME | BN Gateway name |
| BN_GATEWAY_PORT | BN Gateway accessible port |
| BN_PROCESS_CONTAINER_NAME | BN Process name |
| BN_PROCESS_PORT | BN Process accessible port |
| BN_PERMISSION_CONTAINER_NAME | BN Permission name |
| BN_PERMISSION_PORT | BN Permission accessible port |

vninit.yml and did_proxy.properties, The file is the configuration file for connecting to the VN. 
To change the VN environment, you need to replace the corresponding configuration file.

### mysql

```
        - mysql.master.url=jdbc:mysql://${MYSQL_MASTER_HOST}:${MYSQL_MASTER_PORT}/${MYSQL_DATABASE}?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai
        - mysql.master.username=${MYSQL_USER}
        - mysql.master.password=${MYSQL_PWD}
        - mysql.slave.url=jdbc:mysql://${MYSQL_SLAVE_HOST}:${MYSQL_SLAVE_PORT}/${MYSQL_DATABASE}?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai
        - mysql.slave.username=${MYSQL_USER}
        - mysql.slave.password=${MYSQL_PWD}
```

| Configuration item | Description |
| ------------------------- | ------------------------------------- |
| MYSQL_MASTER_HOST | Your primary MYSQL accessible IP |
| MYSQL_SLAVE_HOST | Your IP slave from MYSQL |
| MYSQL_DATABASE | your MYSQL database name |
| MYSQL_USER | your MYSQL user |
| MYSQL_PWD |  The corresponding password of your MYSQL user |

If you do not have master-slave MYSQL, you can configure the content from the master to the master.

### redis

```
        - spring.redis.host=${REDIS_HOST}
        - spring.redis.port=${REDIS_PORT}
        - spring.redis.password=${REDIS_PASSWORD}
        - spring.redis.database=${REDIS_DATABASE}
```

| Configuration item | Description |
| ------------------------- | ------------------------------------- |
| REDIS_HOST | Your REDIS accessible IP |
| REDIS_PORT | Your REDIS accessible port |
| REDIS_DATABASE | REDIS databases number |
| REDIS_PASSWORD |  The corresponding password of your MYSQL user |

## Access the network independently

After the BN deployment is completed, please connect to the network independently. 
The help manual for network access is as follows:

http://xxxx

## contact us
Email: xxxx@xxxx.com
