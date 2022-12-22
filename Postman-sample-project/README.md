**In the sample Postman project (try to import from UDPN-BN.postman_collection.json), there are 11 request and please follow the below guide to modify corresponding request.**


**1. Login**

no need for correction

**2.Upload DID document**

The parameter that needs to be modified is: didDocument

**3.Llink DID to account**

The modified parameter is: did (from did in 2)

**4.Swap pre-process**

The parameter that needs to be modified is: did (from did in 2)

**5. Permit**

no need for correction

**6.Send swap transaction**

The modified parameters are: did (from did in 2), key (from the return value key of 4), tnSecurityMsg (from the return value permitHash of 5)

**7.Query transaction status**

The modified parameter is: key (return value data from 6)

**8. Transfer pre-process**

The modified parameter is: did (from did in 2)

**9. Permit**

no need for correction

**10.Send transfer transaction**

The modified parameters are: did (from did in 2), key from the return value key of 8), tnSecurityMsg (from the return value permitHash of 9)

**11.Query transaction status**

The modified parameter is: key (return value data from 10)
