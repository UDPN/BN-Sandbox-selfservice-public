Setup a Business Node(BN) with docker-compose
==========================
<br/>
<br/>


System prerequisites
==========================

***Minimum hardware spec***

CPU/Mem/Disk : 4-core/8G/40G

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

<br/>

***Tips to Install docker***

sudo curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun

<br/>

***Tips to Install docker-compose***

sudo curl -L
"https://get.daocloud.io/docker/compose/releases/download/1.27.3/docker-compose-$(uname
-s)-$(uname -m)" -o /usr/local/bin/docker-compose && sudo chmod +x
/usr/local/bin/docker-compose

<br/>
<br/>

Steps to install a Business Node instance
==========================

*Step 1: Download and clone the repo*

```
#use https as below or use git@github.com:UDPN/BN-Sandbox-selfservice-public.git as alternative.
git clone https://github.com/UDPN/BN-Sandbox-selfservice-public.git
or
git clone git@github.com:UDPN/BN-Sandbox-selfservice-public.git
```

<br/>

*Step 2: Production and quasi production configuration

```
The default is sandbox production configuration
#################################
#------sandbox config 
#********************************
VN_GATEWAY=https://vngateway.sandbox.udpn.io:443
VN_CODE=VN0000001
# Please modify the following contents
DID_PROXY_MODE=1
DID_PROXY_URL=https://{ip}:{port}/v1/udpn/did/manage
BESU_NODE_URL=https://vngateway.sandbox.udpn.io:443/besu
BESU_NODE_PRIVATEKEY=81558146110441236696062019193516569978983436992581571730538671876174331431837
BESU_DID_CONTADDRESS=0x33c8d39fabb6b303337243c1486ba808582466b3
BESU_CPT_CONTADDRESS=0xfebf6499629be81cc6474a5ef7215a3d0231023c
BESU_AUTHISSUERADDRESS=0xdaba54526a67822da25f905acd3e51ddf968808d

If you need to connect to our quasi production environment, please use the following configuration
# #################################
# #------staging config
# #********************************
# VN_GATEWAY=http://16.163.247.242:30081
# VN_CODE=UDPN000111
# # Please modify the following contents
# DID_PROXY_MODE=1
# DID_PROXY_URL=http://{ip}:{port}/v1/udpn/did/manage
# BESU_NODE_URL=http://16.163.247.242:30081/besu
# BESU_NODE_PRIVATEKEY=43058870442585489105924017812119093828143936320321072321140103784621064736581
# BESU_DID_CONTADDRESS=0x1401f49199a4104d426a212b7d912c6b7635b0c6
# BESU_CPT_CONTADDRESS=0x2996130df7e249c843c944737f5ceacad646975e
# BESU_AUTHISSUERADDRESS=0xcbf2967e676cfc44ef7b1476f2040a93d5c16dbb

Note: The original data needs to be cleared when switching environments
rm -rf mysql/data/*
rm -rf redis/data/*

```

<br/>

*Step 3: Start the Business Node*

sudo docker-compose up -d

<br/>

**How to stop the Business Node?**

sudo docker-compose down

<br/>

**How to register your business node with a Validator Node?**

Now that your Business Node instance has started successfully, please
follow the user guide to register with a Validator Node via [Business Node Self-Onboarding Manual for the UDPN Sandbox](sandbox.manual.md) - Please note that the current configuration is using UDPN Sandbox Production (not staging)

<br/>

**Web addresses used in BN service**

Note: The system needs to use port 80,8080-8085,8761,3306,6379. If there
is any conflict, please modify the .env file.

-   EUREKA [<span
    class="underline">http://localhost:8761/</span>](http://localhost:8761/)

-   Sandbox-web [<span
    class="underline">http://localhost/</span>](http://localhost/)

-   bn-web [<span
    class="underline">http://localhost:8080/</span>](http://localhost:8080/)

<br/>

**BN API tutorial**

If you are going to develop your application and call BN API endpoint, please follow this [BN_API_User_Tutorial](BN_API_User_Tutorial.md)

<br>
**Upgrade (optional)**

1.  Stop the BN with docker-compose

2.  Fetch the latest jar file using the following command "cd
    BN-Sandbox-selfservice-public; git fetch"

3.  Start BN again

<br/>

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
