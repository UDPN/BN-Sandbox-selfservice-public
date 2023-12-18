Setup a Business Node(BN) with docker-compose
==========================

<br/>
<br/>


System prerequisites
==========================

***Minimum hardware spec***

CPU/Mem/Disk : 4core/8G/40G

<br/>

***OS and tools***

<table>
<tbody>
<tr class="odd">
<td><strong>Tools</strong></td>
<td><strong>Version Number (tested)</strong></td>
</tr>
<tr class="even">
<td>Ubuntu</td>
<td>v20.04LTS</td>
</tr>
<tr class="odd">
<td>docker</td>
<td>v20.10.18+</td>
</tr>
<tr class="even">
<td>docker-compose</td>
<td>v1.27.3+</td>
</tr>
</tbody>
</table>


<br/><br/><br/>

***Please note that all below commands are for Bash, please change accordingly if you use other shell, e.g. Zsh/ksh .etc***

<br/>

***Tips to Install docker***


```
sudo curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
```

<br/>

***Tips to Install docker-compose***

```
#!/bin/bash

sudo curl -L
"https://get.daocloud.io/docker/compose/releases/download/1.27.3/docker-compose-$(uname
-s)-$(uname -m)" -o /usr/local/bin/docker-compose && sudo chmod +x
/usr/local/bin/docker-compose
```

<br/>

Steps to install a Business Node instance
==========================

**Step 1: clone**

```
git clone https://github.com/UDPN/BN-Sandbox-selfservice-public.git
cd BN-Sandbox-selfservice-public
git checkout "NEW-TAG"
```

<br/>

**Step 2:start the base service**

```
# You can modify the data storage directory yourself .env BN_DATA_VOLUMES
docker-compose -f docker-compose-base.yaml up -d 

```

**Step 3: Load nacos config file**

```
# please check nacos status , you can open IP:8848/nacos default user nacos passwd nacos

# get token

curl -X POST '127.0.0.1:8848/nacos/v1/auth/login' -d 'username=nacos&password=nacos'

{"accessToken":"eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuYWNvcyIsImV4cCI6MTY5NzU1MjE2OX0.ODl0HnAuStEdALf1Tu5_kFcQ6S3PhKVb1p8xQMb3qOE8kGh47zY9rk1Yh744H1PZ","tokenTtl":18000,"globalAdmin":true,"username":"nacos"}

# create nacos namespace bn

curl -X POST 'http://127.0.0.1:8848/nacos/v1/console/namespaces?accessToken=eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJuYWNvcyIsImV4cCI6MTY5NzU1MjE2OX0.ODl0HnAuStEdALf1Tu5_kFcQ6S3PhKVb1p8xQMb3qOE8kGh47zY9rk1Yh744H1PZ&' -d "customNamespaceId=bn&namespaceName=bn&'namespaceDesc=bn"
```

**Step 4: Load config for bn namespace**

```
# Open the nacos administration page(http://127.0.0.1:8848/nacos) and import the files under nacos/config/xx.zip into the bn namespace
 
Configurations-->import-->Same preparation(Overwrite)-->Upload File-->choice x.zip

```

**Step 5: Create DID document/private key for this BN**  

```
cd BN-Sandbox-selfservice-public/docker-compose

cat udpn-did-sdk-1.0.0.jar.part{0..4} > udpn-did-sdk-1.0.0.jar && shasum -c udpn-did-sdk-1.0.0.jar.shasum && rm udpn-did-sdk-1.0.0.jar.part*

java -jar udpn-did-sdk-1.0.0.jar signature

# Get the authKeyInfo-privateKey from the did_private_keys.txt file
# get did_private_keys shell
grep "authKeyInfo-privateKey:" did_private_keys.txt | awk '{print $2}'

# change bn-common.yaml in nacos ,replace x with didprivatekey
did:
  private:
    key: xxxxxxxxxxxxxxxxxxxx

```

**Step 6:start the bn service**

```
wait 5 minutes
docker-compose -f docker-compose-bn.yaml up -d 

```

**notice**

```
# check nacos  ServiceManagemen--->Sever list, if it is before the network operation ,the server list not register 4 services, you need to restart service; If it is after the network operation , server list not register 6 services.
docker restart bnprocess bnpermission bninit bngateway
after the restart, wait 5 minutes and observe again
bnevent and vngateway can only be registered with nacos after they have completed the on-network operation
```

<br/>

**Step 7:stop service**

```
docker-compose down
```

<br/>

**Step 8:update service**

```
1、backup your did-private-key (Tags before 1.4.4.0.0 are in .env)
2、stop your bn service
3、git clone new tag
4、start your base service
setp2
5、load nacos-mysql.sql 
docker exec -it mysql /bin/bash -c "mysql -u root -p123456  < /docker-entrypoint-initdb.d/nacos-mysql.sql"
6、load nacos config file
setp3 and setp4
7、start your bn service
8、edit bn-common.yaml in nacos whit did-private-key
Support: 1.2.2.2.1 Upgrading to 1.3.3.0.0,1.4.4.0.0,1.6.6.0.0
Support: 1.3.3.0.0 Upgrading to 1.4.4.0.0,1.6.6.0.0
Support: 1.4.4.0.0 Upgrading to 1.6.6.0.0
Support: 1.6.6.0.0 Upgrading to 1.7.7.0.0, need to import the nacos config file again

```

**Support Needed**

If you have any problems installing BN, please check the following:

1. **System prerequisites**: Make sure your system meets the requirements listed at the beginning of the README.

2. **Memory**: Close any other programs that are running to free up memory for the BN containers.

3. **Commands**: Make sure you have run all of the commands above and that they were all successful.

4. **Repository**: Make sure you have the latest version of the repository. If you don't, please try to reinstall BN by:

5. Closing any running containers with "docker-compose down" or "sudo docker-compose down".

6. Cloning the repository again and following the commands above one by one.

If you are still having problems, please collect diagnostic information as below and send it to the UDPN support team.

Info to be collected: (system info including OS info, mem, disk usage; git logs of current repo; docker/docker-compose versions; docker container logs), please double check before send it out.

**How to register your business node with a Validator Node?**

After your Business Node instance has been launched successfully, you should refer to the user guide to complete the registration process with a Validator Node through BN [<span
class="underline">Enterprise version</span>](https://github.com/UDPN/BN-Sandbox-selfservice-public/blob/main/document/BN%20Back-end%20Management%20System%20Operation%20Manual%20-%20Enterprise.pdf) Manual or a [<span
class="underline">Standard version</span>](https://github.com/UDPN/BN-Sandbox-selfservice-public/blob/main/document/BN%20Back-end%20Management%20System%20Operation%20Manual%20-%20Standard.pdf) Manual.

<br/>

**Web addresses used in BN service**

Note: The system needs to use port 80,8080-8085,8761,3306,6379. If there
is any conflict, please modify the .env file.

-   Nacos [<span
    class="underline">http://localhost:8761/</span>](http://localhost:8848/nacos)

-   Sandbox-web [<span
    class="underline">http://localhost/</span>](http://localhost/)

-   Bn-web [<span
    class="underline">http://localhost:8080/</span>](http://localhost:8080/)

<br/>

**BN API tutorial**

If you are going to develop your UDPN core transfer/swap application and call BN transfer/swap API endpoint, please follow this [BN_API_User_Tutorial](BN_API_User_Tutorial.md)
If you are going to develop your UDPN application with Smart Contract Deployment/call .etc, please follow this [document/BN API User Guide.pdf](document/BN%20API%20User%20Guide.pdf) and here is an sample test java file for your reference [document/BNEntWeb3jTest.java](document/BNEntWeb3jTest.java)

**BN TestCoin manual**

Using the Ethereum testnet as a reference, in usual situations, it usually requires approximately 5-10 minutes to complete a transfer transaction due to the operational procedures of public blockchains. Nevertheless, on the Besu chain, employing smart contracts for executing a transfer transaction can be done in just a few seconds. To showcase the rapidity of transactions on the Besu chain, we present TestCoin from PoC#3 as an example for executing a transfer transaction. The diagram below illustrates the exact process of executing this transaction. The manul for this is at [document/TestCoin_Operation_Manual.pdf](document/TestCoin_Operation_Manual.pdf).



Advanced Configuration
============================

**env Advanced Configuration**

<table>
<tbody>
<tr class="odd">
<td><strong>BN-server item</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr class="even">
<td>LOG_SAVE_DIR</td>
<td>Log directory storage address</td>
</tr>
<tr class="odd">
<td>VN_INIT_FILE</td>
<td>vninit.yml directory storage address</td>
</tr>
<tr class="even">
<td>DID_PROXY_PROP_FILE</td>
<td>did_proxy.properties directory storage address</td>
</tr>
<tr class="odd">
<td>BN_DATA_VOLUMES</td>
<td>BN-server jar package directory storage address</td>
</tr>
<tr class="even">
<td>EUREKA_CONTAINER_NAME</td>
<td>EUREKA name</td>
</tr>
<tr class="odd">
<td>EUREKA_PORT</td>
<td>EUREKA accessible port</td>
</tr>
<tr class="even">
<td>EUREKA_USER</td>
<td>EUREKA user</td>
</tr>
<tr class="odd">
<td>EUREKA_PWD</td>
<td>EUREKA password</td>
</tr>
<tr class="even">
<td>BN_INIT_CONTAINER_NAME</td>
<td>BN Init name</td>
</tr>
<tr class="odd">
<td>BN_INIT_PORT</td>
<td>BN Init accessible port</td>
</tr>
<tr class="even">
<td>BN_EVENT_CONTAINER_NAME</td>
<td>BN Event name</td>
</tr>
<tr class="odd">
<td>BN_EVENT_PORT</td>
<td>BN Event accessible port</td>
</tr>
<tr class="even">
<td>BN_GATEWAY_CONTAINER_NAME</td>
<td>BN Gateway name</td>
</tr>
<tr class="odd">
<td>BN_GATEWAY_PORT</td>
<td>BN Gateway accessible port</td>
</tr>
<tr class="even">
<td>BN_PROCESS_CONTAINER_NAME</td>
<td>BN Process name</td>
</tr>
<tr class="odd">
<td>BN_PROCESS_PORT</td>
<td>BN Process accessible port</td>
</tr>
<tr class="even">
<td>BN_PERMISSION_CONTAINER_NAME</td>
<td>BN Permission name</td>
</tr>
<tr class="odd">
<td>BN_PERMISSION_PORT</td>
<td>BN Permission accessible port</td>
</tr>
</tbody>
</table>


vninit.yml and did\_proxy.properties: These files are the configuration
files to connect to the VN. You need to replace the configuration file
to change the VN environment.

<br/>

**MySQL Advanced Setup**

\-
mysql.master.url=jdbc:mysql://${MYSQL\_MASTER\_HOST}:${MYSQL\_MASTER\_PORT}/${MYSQL\_DATABASE}?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai

\- mysql.master.username=${MYSQL\_USER}

\- mysql.master.password=${MYSQL\_PWD}

\-
mysql.slave.url=jdbc:mysql://${MYSQL\_SLAVE\_HOST}:${MYSQL\_SLAVE\_PORT}/${MYSQL\_DATABASE}?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai

\- mysql.slave.username=${MYSQL\_USER}

\- mysql.slave.password=${MYSQL\_PWD}

<table>
<tbody>
<tr class="odd">
<td><strong>Configuration item</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr class="even">
<td>MYSQL_MASTER_HOST</td>
<td>Your primary MYSQL accessible IP</td>
</tr>
<tr class="odd">
<td>MYSQL_SLAVE_HOST</td>
<td>Your IP slave from MYSQL</td>
</tr>
<tr class="even">
<td>MYSQL_DATABASE</td>
<td>your MYSQL database name</td>
</tr>
<tr class="odd">
<td>MYSQL_USER</td>
<td>your MYSQL user</td>
</tr>
<tr class="even">
<td>MYSQL_PWD</td>
<td>The corresponding password of your MYSQL user</td>
</tr>
</tbody>
</table>


If you do not have master-slave MYSQL, you can use the same content
from mysql.master.* to the mysql.slave.*.

<br/>

**redis (advanced)**

\- spring.redis.host=${REDIS\_HOST}

\- spring.redis.port=${REDIS\_PORT}

\- spring.redis.password=${REDIS\_PASSWORD}

\- spring.redis.database=${REDIS\_DATABASE}

<table>
<tbody>
<tr class="odd">
<td><strong>Configuration item</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr class="even">
<td>REDIS_HOST</td>
<td>Your REDIS accessible IP</td>
</tr>
<tr class="odd">
<td>REDIS_PORT</td>
<td>Your REDIS accessible port</td>
</tr>
<tr class="even">
<td>REDIS_DATABASE</td>
<td>REDIS databases number</td>
</tr>
<tr class="odd">
<td>REDIS_PASSWORD</td>
<td>The corresponding password of your MYSQL user</td>
</tr>
</tbody>
</table>


<br/>

**contact us**