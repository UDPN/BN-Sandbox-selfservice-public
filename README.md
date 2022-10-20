# Setup Business Node(BN) with docker-compose


## System prerequisites

### Minimum hardware spec

cpu : 4core
mem : 8G
disk: 40G

### OS and tools

| Tools | version number(tested) |
| ------------------------- | ------------------------------------- |
| Ubuntu | v20.04.04 |
| docker | v20.10.18 |
| docker-compose | v1.27.3 |


### tips to install docker 
```
sudo curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
```

### tips to install docker-compose
```
sudo curl -L "https://get.daocloud.io/docker/compose/releases/download/1.27.3/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && sudo chmod +x /usr/local/bin/docker-compose
```

## Steps to install BN instance

- repo download and clone
```
git lfs clone git@github.com:UDPN/BN-Sandbox-selfservice-public.git
```
- Enter the BN docker-compose directory
  
  `cd BN-Sandbox-selfservice-public/docker-compose`
- start BN
  
  `sudo docker-compose up -d`  
- stop BN
  
  `sudo docker-compose down`  
- Register to Validator Node

  By now, your BN instance has been started successfully.  Now, you need to follow the user guide and start to register to VN via url-to-manual

### Web addresses used in BN service

Note: The system needs to use port 80,8080-8085,8761,3306,6379. If there is any conflict, please modify the .env file.

- EUREKA
    http://localhost:8761/
- Sandbox-web
    http://localhost/
- bn-web
    http://localhost:8080/

### upgrade (optional)

1. Stop BN docker-compose
2. Fetch the latest jar file by "cd BN-Sandbox-selfservice-public; git fetch"
3. Start BN again

## .env configure (advanced)

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

### mysql (advanced)

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

### redis (advanced)

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

## contact us
Email: xxxx@xxxx.com
