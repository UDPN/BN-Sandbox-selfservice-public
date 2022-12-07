API User Tutorial for Business Node
===================================

Before using this manual, you need access to one existing Business Node
(BN), or you have set up your local BN via [<span
class="underline">Setup a Business Node(BN) with
docker-compose</span>](https://github.com/UDPN/BN-Sandbox-selfservice-public)
(Please ensure to complete the onboarding process).

Please read UDPN white paper first to understand the high-level
architecture of the UDPN better. The latest version of the UDPN white
paper can be downloaded:

1.  From UDPN official site soon (http://udpn.io)

2.  Shared by your dedicated UDPN contact person.

3.  Or from your sandbox instance if you have one: [<span
    class="underline">https://\*.sandbox.udpn.io</span>](https://*.sandbox.udpn.io)
    -&gt; Home -&gt; “Download Whitepaper”

Please note that the details regarding the API parameters can be found
via Swagger API:

1.  From your local BN:

[<span
class="underline">http://localhost:8082/swg/swagger-ui/index.html?urls.primaryName=bnprocesscore</span>](http://localhost:8082/swg/swagger-ui/index.html?urls.primaryName=bnprocesscore)

2.  From your UDPN sandbox, if you have access to one. Confirm with your
    dedicated UDPN contact:

[<span
class="underline">https://bngateway-yourDomainURL/swg/swagger-ui/index.html</span>](https://your-public-sandbox-URL/swg/swagger-ui/index.html)

3.  From a UDPN public BN instance (read-only, cannot trigger API call)

[<span
class="underline">https://bngateway-rd.sandbox.udpn.io/swg/swagger-ui/index.html</span>](https://bngateway-rd.sandbox.udpn.io/swg/swagger-ui/index.html)

Summary of API use for sending transfer or SWAP transactions on behalf
of your end user:

<img src="./media/api_image1.png" alt="BN API flow.drawio(1)" style="width:5.44931in;height:9.69097in" />

Please find below the core APIs used by the IT system operators to
connect to business nodes. Additional details on the API can be found in
the Swagger description provided above. All URLs come from setting up
the BN locally via [<span class="underline">Setup a Business Node(BN)
with
docker-compose</span>](https://github.com/UDPN/BN-Sandbox-selfservice-public).

In addition to this tutorial, we will provide a PostMan project
demonstrating how to use the API calls introduced below to complete a
SWAP transaction.

Note: Again, All URLs in following chapters come from setting up the BN
locally via [<span class="underline">Setup a Business Node(BN) with
docker-compose</span>](https://github.com/UDPN/BN-Sandbox-selfservice-public).

Login
-----

The IT system uses this API to log in to their business node. The
default username/password could be found at [<span
class="underline">this
page</span>](https://github.com/UDPN/BN-Sandbox-selfservice-public/blob/main/sandbox.manual.md)
if you are using <span class="underline">[Setup a Business Node(BN) with
docker-compose](https://github.com/UDPN/BN-Sandbox-selfservice-public).</span>
More APIs could be found via swagger.

[<span
class="underline">http://localhost/v1/udpn/processing/login/manage/login</span>](http://localhost/v1/udpn/processing/login/manage/login)

DID Document Uploading
----------------------

A DID is a unique identifier used to represent all UDPN users. You may
generate DID document with below ways:

1.  From your sandbox instance if you have one: [<span
    class="underline">https://\*.sandbox.udpn.io</span>](https://*.sandbox.udpn.io)
    -&gt; “Account Management” -&gt; “DID generation”

2.  If you are using <span class="underline">[Setup a Business Node(BN)
    with
    docker-compose](https://github.com/UDPN/BN-Sandbox-selfservice-public),</span>
    you need to navigate to the root directory
    “BN-Sandbox-selfservice-public” and generate an offline DID document
    on behalf of the end-user using the following command

“java -jar
docker-compose/nginx/dist/web/assets/did/udpn-did-sdk-1.0.0.jar”.

After the DID document is generated, you must use the command below to
upload it to a validator node via your business node.

[<span
class="underline">http://localhost/vn/v1/udpn/did/manage/didContract/storeDidDocumentOnChain</span>](http://localhost/vn/v1/udpn/did/manage/didContract/storeDidDocumentOnChain)

Link DID to Account
-------------------

The DID needs to be linked to a digital currency account before we can
transfer/swap funds from that account on the UDPN.

[<span
class="underline">http://localhost/v1/udpn/processing/account/bind/manage/save</span>](http://localhost/v1/udpn/processing/account/bind/manage/save)

1) Query all currencies and platforms currently supported on the UDPN.

[<span
class="underline">http://localhost/v1/udpn/processing/common/manage/active/currency/platform/select</span>](http://localhost/v1/udpn/processing/common/manage/active/currency/platform/select)

2) Query account list with accountBindingId .etc fields linked to
    specific DID

[<span
class="underline">http://localhost/v1​/udpn​/processing​/account​/bind​/manage​/searchs</span>](http://localhost/v1​/udpn​/processing​/account​/bind​/manage​/searchs)

3) More details on the APIs can be found in swagger

Transfer
--------

“Transfer” means moving funds between two accounts in the same digital
currency system.

##### Pre-processing

For a given transfer, query all possible TNs which could process the
transfer.

[<span
class="underline">http://localhost/v1/udpn/processing/transfer/manage/searchs</span>](http://localhost/v1/udpn/processing/transfer/manage/searchs)

Related query: query all platforms and currencies currently supported on
the UDPN.

[<span
class="underline">http://localhost/v1/udpn/processing/common/manage/active/currency/platform/select</span>](http://localhost/v1/udpn/processing/common/manage/active/currency/platform/select)

##### Permit

Once a transaction node is chosen to process the transfer, use this API
to collect the relevalt public chain package details.

As a temporary fix, we pass the end-user private key to the transaction
node so that it signs the transaction on behalf of the end user.

We will provide an SDK or manual in production so the IT system can sign
the transaction locally. For obvious security reasons, the private key
cannot be shared and must be safeguarded locally.

[<span
class="underline">http://localhost/v1/udpn/processing/digital/currency/swap/manage/permit/select</span>](http://localhost/v1/udpn/processing/digital/currency/swap/manage/permit/select)

##### Send a Transfer transaction request

Send a transfer transaction request

More information on how to query the transfer status is provided in the
subsequent sections (Sections 6/7).

[<span
class="underline">http://localhost/v1/udpn/processing/transfer/manage/save</span>](http://localhost/v1/udpn/processing/transfer/manage/save)

SWAP
-----

“SWAP” means moving funds between two accounts in two distinct currency
systems.

##### Pre-processing

For a given SWAP, query all possible TNs which could process the swap.

[<span
class="underline">http://localhost/v1/udpn/processing/digital/currency/swap/manage/searchs</span>](http://localhost/v1/udpn/processing/transfer/manage/searchs)

1) Related query: query all platforms and currencies currently supported on
the UDPN.

[<span
class="underline">http://localhost/v1/udpn/processing/common/manage/active/currency/platform/select</span>](http://localhost/v1/udpn/processing/common/manage/active/currency/platform/select)

##### Permit

Once a transaction node is chosen to process the SWAP, use this API to
collect the relevant public chain package details.

As a temporary fix, we pass the end-user private key to the transaction
node so that it signs the transaction on behalf of the end user.

We will provide an SDK or manual in production so the IT system can sign
the transaction locally. For obvious security reasons, the private key
cannot be shared and must be safeguarded locally.

[<span
class="underline">http://localhost/v1/udpn/processing/digital/currency/swap/manage/permit/select</span>](http://localhost/v1/udpn/processing/digital/currency/swap/manage/permit/select)

##### Send Swap transaction

Send SWAP transaction.

More information on how to query the swap status is provided in the
subsequent sections .

[<span
class="underline">http://localhost/v1/udpn/processing/digital/currency/swap/manage/save</span>](http://localhost/v1/udpn/processing/transfer/manage/save)

Retrieve the Transfer/SWAP list
-------------------------------

##### Query transaction list

Used to query all the transactions initiated by the business node

[<span
class="underline">http://localhost/v1/udpn/processing/digital/currency/swap/manage/swap/transfer/select</span>](http://localhost/v1/udpn/processing/digital/currency/swap/manage/swap/transfer/select)

##### Query transaction detail by transaction ID：

[<span
class="underline">http://localhost/v1/udpn/processing/digital/currency/swap/manage/swap/transfer/detail/select</span>](http://localhost/v1/udpn/processing/digital/currency/swap/manage/swap/transfer/detail/select)

Query transaction detail by transaction Key.
-------------------------------------------

[<span
class="underline">http://localhost/v1/udpn/processing/digital/currency/swap/manage/transaction/by/key/select</span>](http://localhost/v1/udpn/processing/digital/currency/swap/manage/transaction/by/key/select)

### Error Code
```
  (50000, "Encountered internal error, please contact administrator with message code:"),
  (20000, "The verification code has not expired"),
  (20001, "The verification code has timed out"),
  (20002, "The verification code is incorrect"),
  (20003, "Transaction cannot be select"),
  (20004, "Amount need to greater than 0"),
  (20005, "SourceCurrencyType and TargetCurrencyType cannot be the same currency"),
  (20006, "Transfer cannot be select"),
  (20007, "Please bind the VN first"),
  (20008, "No MQ connection information is available"),
  (20009, "Check whether the Event starts normally"),
  (20010, "No mail templates are available"),
  (20011, "Did not exist"),
  (20012, "PlatformType not null"),
  (20013, "The platformType value is incorrect"),
  (20014, "The currencyType value is incorrect"),
  (20015, "Duplicate information"),
  (20016, "CurrencyAccount is incorrect"),
  (20017, "The isDefault value is incorrect"),
  (20018, "This information is already set to default"),
  (20019, "CurrencyType ${currencyType} save failed"),
  (20020, "Account and did binding success"),
  (20021, "Account and did binding error"),
  (20022, "Account and did unbind success"),
  (20023, "Account and did unbind error"),
  (20024, "Set as default binding account success"),
  (20025, "Set as default binding account error"),
  (20026, "Swap submit success"),
  (20027, "Swap submit error"),
  (20028, "Transfer submit success"),
  (20029, "Transfer submit error"),
  (20030, "Vote success"),
  (20031, "Vote error"),
  (20032, "Bind vn success"),
  (20033, "Switch vn success"),
  (20034, "Sway key already exist"),
  (20035, "Transfer key already exist"),
  (20036, "Failed to submit node information"),
  (20037, "Reapply node info error"),
  (20038, "Node info already exist"),
  (20039, "Account binding data does not exist"),
  (20040, "SourceAccountAddress and TargetAccountAddress not the same"),
  (20041, "Bind vn error"),
  (20042, "Switch vn error"),
  (20043, "Did document not exist"),
  (20044, "UdpnPeerName verification fails"),
  (20045, "The format of serviceFee is incorrect"),
  (20046, "The format of fxRate is incorrect"),
  (20047, "The format of swapAmount is incorrect"),
  (20048, "The format of transferAmount is incorrect"),
  (20049, "This data does not exist"),
  (20050, "Incorrect \"transType\" values"),
  (20051, "UdpnDidDocument cannot be empty"),
  (20052, "UdpnPeerName cannot be empty"),
  (20053, "UdpnPeerTitle cannot be empty"),
  (20054, "UdpnPeerTitle length is 0-500"),
  (20055, "UdpnPeerDesc cannot be empty"),
  (20056, "UdpnPeerDesc length is 0-500"),
  (20057, "BnEmailCode cannot be empty"),
  (20058, "UdpnPeerType cannot be empty"),
  (20059, "NodeCreateType cannot be empty"),
  (20060, "NodeId cannot be empty"),
  (20061, "UdpnPeerName length is 2-50"),
  (20062, "Email cannot be empty"),
  (20063, "VnId cannot be empty"),
  (20064, "InPage cannot be empty"),
  (20065, "Did not null"),
  (20066, "PlatformType not null"),
  (20067, "CurrencyType not null"),
  (20068, "CurrencyAccount not null"),
  (20069, "Incorrect isDefault values"),
  (20070, "AccountBindingId not null"),
  (20071, "SwapAmount not null"),
  (20072, "SourceAccountAddress not null"),
  (20073, "TargetAccountAddress not null"),
  (20074, "FormPlatformType not null"),
  (20075, "ToPlatformType not null"),
  (20076, "FromCurrencyType not null"),
  (20077, "ToCurrencyType not null"),
  (20078, "Key not null"),
  (20079, "ServiceFee not null"),
  (20080, "FxRate not null"),
  (20081, "TnSecurityMsg not null"),
  (20082, "OriginalTnCode not null"),
  (20083, "TransId cannot be empty"),
  (20084, "TransType cannot be empty"),
  (20085, "TransferAmount not null"),
  (20086, "BnCode not null"),
  (20087, "Access to this interface is not allowed"),
  (20088, "DidSignatureValue not null"),
  (20089, "Signature verification failed"),
  (20090, "privateKey not null"),
  (20091, "The entered did is incorrect"),
  (21001, "The registerCpt method of sdk return null"),
  (21002, "The registerCpt method of sdk return null"),
  (21003, "The createDid method of sdk  return null"),
  (21004, "The getDocument method of sdk  return null"),
  (21005, "The storeDidDocumentOnChain method of sdk  return fail"),
  (21006, "The registerAuthIssuer method of sdk  return  null"),
  (21007, "The queryAuthIssuerList method of sdk  return  null"),
  (21008, "The updateCpt method of sdk  return  null"),
  (21009, "The queryCptById method of sdk  return  null"),
  (21010, "The verifyDidDocument method of sdk  return  null"),
  (21011, "The resetDidAuth method of sdk  return  null"),
  (21012, "The isPermission method of sdk  return  null"),
  (21013, "The deleteResource method of sdk  return  null"),
  (21014, "The getResource method of sdk  return  null"),
  (21015, "The saveResource method of sdk  return  null"),
  (21016, "The deletePermission method of sdk  return  null"),
  (21017, "The queryPermission method of sdk  return  null"),
  (21018, "The createPermission method of sdk  return  null"),
  (21019, "Did already exist"),
  (21020, "Did sdk throw exception"),
  (20587, "Did is invalid"),
  (20545, "Save node info error"),
  (20504, "The approved node corresponding to the private key was not found. Please try again later or contact the VN administrator"),
  (20506, "Failed to submit node information"),
  (20662, "The current vn has been withdrawn from the network, please switch to another vn"),
  (20682, "The vn service fee cannot be empty!"),
  (20683, "The original tn service fee cannot be empty!"),
  (20684, "The target tn service fee cannot be empty!"),
  (20092, "The node does not support submission"),
  (20093, "The node does not exist"),
  (20094, "VN connection failed, please select another VN"),
  (20095, "VN information does not exist"),
  (20099, "TargetTnCode not null"),
  (20112, "Currency precision is empty"),
  (20113, "Tn node does not exist"),
  (20114, "Tn url is empty"),
  (20605, "NodeCode cannot be empty"),
  (20118, "serviceFee not null"),
  (20119, "originalTnCode not null"),
  (20121, "StartDate cannot be empty"),
  (20122, "EndDate cannot be empty"),
  (20123, "Contact Name can not be empty"),
  (20124, "Contact Name can only contain numbers or letters, up to 50 characters"),
  (20125, "Contact Phone can only contain numbers, up to 20 characters"),
  (20126, "Address can only contain numbers or letters, up to 200 characters"),
  (20127, "Address can not be empty"),
  (20128, "Gateway url can not be empty"),
  (20129, "Country id can not be empty"),
  (20130, "Country information does not exist"),
  (20131, "Business license does not exist"),
  (20132, "Gateway url format error"),
  (20133, "Email format error"),
  (20134, "toAmount not null"),
  (20135, "totalAmount not null"),
  (20136, "The precision of toAmount is 32 digits before the decimal point and 18 digits after the decimal point"),
  (20137, "The precision of totalAmount is 32 digits before the decimal point and 18 digits after the decimal point"),
  (20105, "Platform and currency information does not exist"),
  (20106, "Swap amount precision is incorrect,The supported precision is: ${}"),
  (20107, "Service fee precision is incorrect,The supported precision is: ${}"),
  (20108, "Transfer amount precision is incorrect,The supported precision is: ${}"),
  (20138, "businessAccount not null"),
  (20139, "bindingId not null"),
  (20140, "businessAccount can be up to 50 characters"),
  (20141, "transDateType not null"),
  (20142, "Incorrect transDateType values"),
  (20143, "Incorrect transType values"),
  (20144, "Please enter the login account correctly"),
  (20145, "Your password do not match"),
  (20146, "Account is locked and cannot be used"),
  (20147, "The account you entered is invalid"),
  (20148, "Account already exists"),
  (20149, "Please log in first"),
  (20150, "Login failed"),
  (20151, "clientName not null"),
  (20152, "password not null"),
  (20153, "beneficiaryType not null"),
  (20154, "toBankAccount not null"),
  (20155, "Your passwords do not match"),
  (20156, "Incorrect beneficiaryType values"),
  (20189, "swap cannot be null"),
  (20180, "Super admin insert failed"),
  (20158, "userId not null"),
  (20172, "User information does not exist"),
  (20197, "Password reset failed"),
  (20198, "Password update failed"),
  (20199, "password:Combination of 8-12 letters and numbers with at least one capital letter"),
  (20200, "Old password can not be empty"),
  (20201, "Incorrect old password"),
  (20202, "The new password and the old password cannot be the same"),
  (20203, "The new password and the verify password do not match"),
  (20204, "New password can not be empty"),
  (20205, "New password:Combination of 8-12 letters and numbers with at least one capital letter"),
  (20206, "Verify password can not be empty"),
  (20207, "Verify password:Combination of 8-12 letters and numbers with at least one capital letter");
```
