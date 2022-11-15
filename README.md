**Setup a Business Node(BN) with docker-compose**

**System prerequisites**

**Minimum hardware spec**

CPU/Mem/Disk : 4-core/8G/40G

**OS and tools**

<table>
<tbody>
<tr class="odd">
<td><strong>Tools</strong></td>
<td><strong>Version Number (tested)</strong></td>
</tr>
<tr class="even">
<td>Ubuntu</td>
<td>v20.04.04</td>
</tr>
<tr class="odd">
<td>docker</td>
<td>v20.10.18</td>
</tr>
<tr class="even">
<td>docker-compose</td>
<td>v1.27.3</td>
</tr>
</tbody>
</table>

**Install docker**

sudo curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun

**Install docker-compose**

sudo curl -L
"https://get.daocloud.io/docker/compose/releases/download/1.27.3/docker-compose-$(uname
-s)-$(uname -m)" -o /usr/local/bin/docker-compose && sudo chmod +x
/usr/local/bin/docker-compose

**Steps to install a Business Node instance**

*Step 1: Download and clone the repo*

sudo apt-get install git-lfs

git lfs clone [<span
class="underline">https://github.com/UDPN/BN-Sandbox-selfservice-public.git</span>](https://github.com/UDPN/BN-Sandbox-selfservice-public.git)

*Step 2: cd into the Business Node docker-compose directory*

cd BN-Sandbox-selfservice-public/docker-compose

*Step 3: Start the Business Node*

sudo docker-compose up -d

**How to stop the Business Node?**

sudo docker-compose down

**How to register your business node with a Validator Node?**

Now that your Business Node instance has started successfully, please
follow the user guide to register with a Validator Node via [Business Node Self-Onboarding Manual for the UDPN Sandbox](sandbox.manual.md)

**Web addresses used in BN service**

Note: The system needs to use port 80,8080-8085,8761,3306,6379. If there
is any conflict, please modify the .env file.

-   EUREKA [<span
    class="underline">http://localhost:8761/</span>](http://localhost:8761/)

-   Sandbox-web [<span
    class="underline">http://localhost/</span>](http://localhost/)

-   bn-web [<span
    class="underline">http://localhost:8080/</span>](http://localhost:8080/)

**Upgrade (optional)**

1.  Stop the BN with docker-compose

2.  Fetch the latest jar file using the following command "cd
    BN-Sandbox-selfservice-public; git fetch"

3.  Start BN again

**.env Advanced Configuration**

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

**contact us**
