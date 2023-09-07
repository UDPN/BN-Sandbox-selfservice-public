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


**Step 2: Create DID document/private key for this BN**

```
cd BN-Sandbox-selfservice-public/docker-compose

cat udpn-did-sdk-1.0.0.jar.part{0..4} > udpn-did-sdk-1.0.0.jar && shasum -c udpn-did-sdk-1.0.0.jar.shasum && rm udpn-did-sdk-1.0.0.jar.part*

java -jar udpn-did-sdk-1.0.0.jar signature

# Get the authKeyInfo-privateKey from the did_private_keys.txt file
authKey=$(grep "authKeyInfo-privateKey:" did_private_keys.txt | awk '{print $2}')

# Append the authKey to the DID_PRIVATE_KEY line in the .env file
sed "s/DID_PRIVATE_KEY=.*/DID_PRIVATE_KEY=$authKey/" .env > .env.tmp && mv .env.tmp .env
```

<br/>

**Step 3:start service**
```
# You can modify the data storage directory yourself .env BN_DATA_VOLUMES
docker-compose up -d
```


<br/>

**Step 4:stop service**
```
docker-compose down
```
<br/>

**Step 5:update service**
```
1、backup your did private key 
2、stop your bn service
3、git clone new tag
4、start your service
Support: 1.2.2.2.1 Upgrading to 1.3.3.0.0,1.4.4.0.0
Support: 1.3.3.0.0 Upgrading to 1.4.4.0.0
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

-   Eureka [<span
    class="underline">http://localhost:8761/</span>](http://localhost:8761/)

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

<br>

**Upgrade (optional)**

1.  Update the latest repo by run "git pull" in BN-Sandbox-selfservice-public/docker-compose

2.  Upgrade all the images by run "bash upgrade-to-latest.sh" in BN-Sandbox-selfservice-public/docker-compose

3.  Start BN again

<br/>

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
