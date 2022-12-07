// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)

package network.udpn.common.msg.codes;

import network.udpn.common.enums.BusinessGroupEnum;

/**
* Message code enum
* @author yf
* @Date: 2021/12/28
* @version 1.0.0
*
* @history date, modifier,and description
**/
public enum MsgCodesEnum {

  MSG_CODES_ENUM_50000(50000, "Encountered internal error, please contact administrator with message code:"),
  MSG_CODES_ENUM_20000(20000, "The verification code has not expired"),
  MSG_CODES_ENUM_20001(20001, "The verification code has timed out"),
  MSG_CODES_ENUM_20002(20002, "The verification code is incorrect"),
  MSG_CODES_ENUM_20003(20003, "Transaction cannot be select"),
  MSG_CODES_ENUM_20004(20004, "Amount need to greater than 0"),
  MSG_CODES_ENUM_20005(20005, "SourceCurrencyType and TargetCurrencyType cannot be the same currency"),
  MSG_CODES_ENUM_20006(20006, "Transfer cannot be select"),
  MSG_CODES_ENUM_20007(20007, "Please bind the VN first"),
  MSG_CODES_ENUM_20008(20008, "No MQ connection information is available"),
  MSG_CODES_ENUM_20009(20009, "Check whether the Event starts normally"),
  MSG_CODES_ENUM_20010(20010, "No mail templates are available"),
  MSG_CODES_ENUM_20011(20011, "Did not exist"),
  MSG_CODES_ENUM_20012(20012, "PlatformType not null"),
  MSG_CODES_ENUM_20013(20013, "The platformType value is incorrect"),
  MSG_CODES_ENUM_20014(20014, "The currencyType value is incorrect"),
  MSG_CODES_ENUM_20015(20015, "Duplicate information"),
  MSG_CODES_ENUM_20016(20016, "CurrencyAccount is incorrect"),
  MSG_CODES_ENUM_20017(20017, "The isDefault value is incorrect"),
  MSG_CODES_ENUM_20018(20018, "This information is already set to default"),
  MSG_CODES_ENUM_20019(20019, "CurrencyType ${currencyType} save failed"),
  MSG_CODES_ENUM_20020(20020, "Account and did binding success"),
  MSG_CODES_ENUM_20021(20021, "Account and did binding error"),
  MSG_CODES_ENUM_20022(20022, "Account and did unbind success"),
  MSG_CODES_ENUM_20023(20023, "Account and did unbind error"),
  MSG_CODES_ENUM_20024(20024, "Set as default binding account success"),
  MSG_CODES_ENUM_20025(20025, "Set as default binding account error"),
  MSG_CODES_ENUM_20026(20026, "Swap submit success"),
  MSG_CODES_ENUM_20027(20027, "Swap submit error"),
  MSG_CODES_ENUM_20028(20028, "Transfer submit success"),
  MSG_CODES_ENUM_20029(20029, "Transfer submit error"),
  MSG_CODES_ENUM_20030(20030, "Vote success"),
  MSG_CODES_ENUM_20031(20031, "Vote error"),
  MSG_CODES_ENUM_20032(20032, "Bind vn success"),
  MSG_CODES_ENUM_20033(20033, "Switch vn success"),
  MSG_CODES_ENUM_20034(20034, "Sway key already exist"),
  MSG_CODES_ENUM_20035(20035, "Transfer key already exist"),
  MSG_CODES_ENUM_20036(20036, "Failed to submit node information"),
  MSG_CODES_ENUM_20037(20037, "Reapply node info error"),
  MSG_CODES_ENUM_20038(20038, "Node info already exist"),
  MSG_CODES_ENUM_20039(20039, "Account binding data does not exist"),
  MSG_CODES_ENUM_20040(20040, "SourceAccountAddress and TargetAccountAddress not the same"),
  MSG_CODES_ENUM_20041(20041, "Bind vn error"),
  MSG_CODES_ENUM_20042(20042, "Switch vn error"),
  MSG_CODES_ENUM_20043(20043, "Did document not exist"),
  MSG_CODES_ENUM_20044(20044, "UdpnPeerName verification fails"),
  MSG_CODES_ENUM_20045(20045, "The format of serviceFee is incorrect"),
  MSG_CODES_ENUM_20046(20046, "The format of fxRate is incorrect"),
  MSG_CODES_ENUM_20047(20047, "The format of swapAmount is incorrect"),
  MSG_CODES_ENUM_20048(20048, "The format of transferAmount is incorrect"),
  MSG_CODES_ENUM_20049(20049, "This data does not exist"),
  MSG_CODES_ENUM_20050(20050, "Incorrect \"transType\" values"),
  MSG_CODES_ENUM_20051(20051, "UdpnDidDocument cannot be empty"),
  MSG_CODES_ENUM_20052(20052, "UdpnPeerName cannot be empty"),
  MSG_CODES_ENUM_20053(20053, "UdpnPeerTitle cannot be empty"),
  MSG_CODES_ENUM_20054(20054, "UdpnPeerTitle length is 0-500"),
  MSG_CODES_ENUM_20055(20055, "UdpnPeerDesc cannot be empty"),
  MSG_CODES_ENUM_20056(20056, "UdpnPeerDesc length is 0-500"),
  MSG_CODES_ENUM_20057(20057, "BnEmailCode cannot be empty"),
  MSG_CODES_ENUM_20058(20058, "UdpnPeerType cannot be empty"),
  MSG_CODES_ENUM_20059(20059, "NodeCreateType cannot be empty"),
  MSG_CODES_ENUM_20060(20060, "NodeId cannot be empty"),
  MSG_CODES_ENUM_20061(20061, "UdpnPeerName length is 2-50"),
  MSG_CODES_ENUM_20062(20062, "Email cannot be empty"),
  MSG_CODES_ENUM_20063(20063, "VnId cannot be empty"),
  MSG_CODES_ENUM_20064(20064, "InPage cannot be empty"),
  MSG_CODES_ENUM_20065(20065, "Did not null"),
  MSG_CODES_ENUM_20066(20066, "PlatformType not null"),
  MSG_CODES_ENUM_20067(20067, "CurrencyType not null"),
  MSG_CODES_ENUM_20068(20068, "CurrencyAccount not null"),
  MSG_CODES_ENUM_20069(20069, "Incorrect isDefault values"),
  MSG_CODES_ENUM_20070(20070, "AccountBindingId not null"),
  MSG_CODES_ENUM_20071(20071, "SwapAmount not null"),
  MSG_CODES_ENUM_20072(20072, "SourceAccountAddress not null"),
  MSG_CODES_ENUM_20073(20073, "TargetAccountAddress not null"),
  MSG_CODES_ENUM_20074(20074, "FormPlatformType not null"),
  MSG_CODES_ENUM_20075(20075, "ToPlatformType not null"),
  MSG_CODES_ENUM_20076(20076, "FromCurrencyType not null"),
  MSG_CODES_ENUM_20077(20077, "ToCurrencyType not null"),
  MSG_CODES_ENUM_20078(20078, "Key not null"),
  MSG_CODES_ENUM_20079(20079, "ServiceFee not null"),
  MSG_CODES_ENUM_20080(20080, "FxRate not null"),
  MSG_CODES_ENUM_20081(20081, "TnSecurityMsg not null"),
  MSG_CODES_ENUM_20082(20082, "OriginalTnCode not null"),
  MSG_CODES_ENUM_20083(20083, "TransId cannot be empty"),
  MSG_CODES_ENUM_20084(20084, "TransType cannot be empty"),
  MSG_CODES_ENUM_20085(20085, "TransferAmount not null"),
  MSG_CODES_ENUM_20086(20086, "BnCode not null"),
  MSG_CODES_ENUM_20087(20087, "Access to this interface is not allowed"),
  MSG_CODES_ENUM_20088(20088, "DidSignatureValue not null"),
  MSG_CODES_ENUM_20089(20089, "Signature verification failed"),
  MSG_CODES_ENUM_20090(20090, "privateKey not null"),
  MSG_CODES_ENUM_20091(20091, "The entered did is incorrect"),
  MSG_CODES_ENUM_21001(21001, "The registerCpt method of sdk return null"),
  MSG_CODES_ENUM_21002(21002, "The registerCpt method of sdk return null"),
  MSG_CODES_ENUM_21003(21003, "The createDid method of sdk  return null"),
  MSG_CODES_ENUM_21004(21004, "The getDocument method of sdk  return null"),
  MSG_CODES_ENUM_21005(21005, "The storeDidDocumentOnChain method of sdk  return fail"),
  MSG_CODES_ENUM_21006(21006, "The registerAuthIssuer method of sdk  return  null"),
  MSG_CODES_ENUM_21007(21007, "The queryAuthIssuerList method of sdk  return  null"),
  MSG_CODES_ENUM_21008(21008, "The updateCpt method of sdk  return  null"),
  MSG_CODES_ENUM_21009(21009, "The queryCptById method of sdk  return  null"),
  MSG_CODES_ENUM_21010(21010, "The verifyDidDocument method of sdk  return  null"),
  MSG_CODES_ENUM_21011(21011, "The resetDidAuth method of sdk  return  null"),
  MSG_CODES_ENUM_21012(21012, "The isPermission method of sdk  return  null"),
  MSG_CODES_ENUM_21013(21013, "The deleteResource method of sdk  return  null"),
  MSG_CODES_ENUM_21014(21014, "The getResource method of sdk  return  null"),
  MSG_CODES_ENUM_21015(21015, "The saveResource method of sdk  return  null"),
  MSG_CODES_ENUM_21016(21016, "The deletePermission method of sdk  return  null"),
  MSG_CODES_ENUM_21017(21017, "The queryPermission method of sdk  return  null"),
  MSG_CODES_ENUM_21018(21018, "The createPermission method of sdk  return  null"),
  MSG_CODES_ENUM_21019(21019, "Did already exist"),
  MSG_CODES_ENUM_21020(21020, "Did sdk throw exception"),
  MSG_CODES_ENUM_20587(20587, "Did is invalid"),
  MSG_CODES_ENUM_20545(20545, "Save node info error"),
  MSG_CODES_ENUM_20504(20504, "The approved node corresponding to the private key was not found. Please try again later or contact the VN administrator"),
  MSG_CODES_ENUM_20506(20506, "Failed to submit node information"),
  MSG_CODES_ENUM_20662(20662, "The current vn has been withdrawn from the network, please switch to another vn"),
  MSG_CODES_ENUM_20682(20682, "The vn service fee cannot be empty!"),
  MSG_CODES_ENUM_20683(20683, "The original tn service fee cannot be empty!"),
  MSG_CODES_ENUM_20684(20684, "The target tn service fee cannot be empty!"),
  MSG_CODES_ENUM_20092(20092, "The node does not support submission"),
  MSG_CODES_ENUM_20093(20093, "The node does not exist"),
  MSG_CODES_ENUM_20094(20094, "VN connection failed, please select another VN"),
  MSG_CODES_ENUM_20095(20095, "VN information does not exist"),
  MSG_CODES_ENUM_20099(20099, "TargetTnCode not null"),
  MSG_CODES_ENUM_20112(20112, "Currency precision is empty"),
  MSG_CODES_ENUM_20113(20113, "Tn node does not exist"),
  MSG_CODES_ENUM_20114(20114, "Tn url is empty"),
  MSG_CODES_ENUM_20605(20605, "NodeCode cannot be empty"),
  MSG_CODES_ENUM_20118(20118, "serviceFee not null"),
  MSG_CODES_ENUM_20119(20119, "originalTnCode not null"),
  MSG_CODES_ENUM_20121(20121, "StartDate cannot be empty"),
  MSG_CODES_ENUM_20122(20122, "EndDate cannot be empty"),
  MSG_CODES_ENUM_20123(20123, "Contact Name can not be empty"),
  MSG_CODES_ENUM_20124(20124, "Contact Name can only contain numbers or letters, up to 50 characters"),
  MSG_CODES_ENUM_20125(20125, "Contact Phone can only contain numbers, up to 20 characters"),
  MSG_CODES_ENUM_20126(20126, "Address can only contain numbers or letters, up to 200 characters"),
  MSG_CODES_ENUM_20127(20127, "Address can not be empty"),
  MSG_CODES_ENUM_20128(20128, "Gateway url can not be empty"),
  MSG_CODES_ENUM_20129(20129, "Country id can not be empty"),
  MSG_CODES_ENUM_20130(20130, "Country information does not exist"),
  MSG_CODES_ENUM_20131(20131, "Business license does not exist"),
  MSG_CODES_ENUM_20132(20132, "Gateway url format error"),
  MSG_CODES_ENUM_20133(20133, "Email format error"),
  MSG_CODES_ENUM_20134(20134, "toAmount not null"),
  MSG_CODES_ENUM_20135(20135, "totalAmount not null"),
  MSG_CODES_ENUM_20136(20136, "The precision of toAmount is 32 digits before the decimal point and 18 digits after the decimal point"),
  MSG_CODES_ENUM_20137(20137, "The precision of totalAmount is 32 digits before the decimal point and 18 digits after the decimal point"),
  MSG_CODES_ENUM_20105(20105, "Platform and currency information does not exist"),
  MSG_CODES_ENUM_20106(20106, "Swap amount precision is incorrect,The supported precision is: ${}"),
  MSG_CODES_ENUM_20107(20107, "Service fee precision is incorrect,The supported precision is: ${}"),
  MSG_CODES_ENUM_20108(20108, "Transfer amount precision is incorrect,The supported precision is: ${}"),
  MSG_CODES_ENUM_20138(20138, "businessAccount not null"),
  MSG_CODES_ENUM_20139(20139, "bindingId not null"),
  MSG_CODES_ENUM_20140(20140, "businessAccount can be up to 50 characters"),
  MSG_CODES_ENUM_20141(20141, "transDateType not null"),
  MSG_CODES_ENUM_20142(20142, "Incorrect transDateType values"),
  MSG_CODES_ENUM_20143(20143, "Incorrect transType values"),
  MSG_CODES_ENUM_20144(20144, "Please enter the login account correctly"),
  MSG_CODES_ENUM_20145(20145, "Your password do not match"),
  MSG_CODES_ENUM_20146(20146, "Account is locked and cannot be used"),
  MSG_CODES_ENUM_20147(20147, "The account you entered is invalid"),
  MSG_CODES_ENUM_20148(20148, "Account already exists"),
  MSG_CODES_ENUM_20149(20149, "Please log in first"),
  MSG_CODES_ENUM_20150(20150, "Login failed"),
  MSG_CODES_ENUM_20151(20151, "clientName not null"),
  MSG_CODES_ENUM_20152(20152, "password not null"),
  MSG_CODES_ENUM_20153(20153, "beneficiaryType not null"),
  MSG_CODES_ENUM_20154(20154, "toBankAccount not null"),
  MSG_CODES_ENUM_20155(20155, "Your passwords do not match"),
  MSG_CODES_ENUM_20156(20156, "Incorrect beneficiaryType values"),
  MSG_CODES_ENUM_20189(20189, "swap cannot be null"),
  MSG_CODES_ENUM_20180(20180, "Super admin insert failed"),
  MSG_CODES_ENUM_20158(20158, "userId not null"),
  MSG_CODES_ENUM_20172(20172, "User information does not exist"),
  MSG_CODES_ENUM_20197(20197, "Password reset failed"),
  MSG_CODES_ENUM_20198(20198, "Password update failed"),
  MSG_CODES_ENUM_20199(20199, "password:Combination of 8-12 letters and numbers with at least one capital letter"),
  MSG_CODES_ENUM_20200(20200, "Old password can not be empty"),
  MSG_CODES_ENUM_20201(20201, "Incorrect old password"),
  MSG_CODES_ENUM_20202(20202, "The new password and the old password cannot be the same"),
  MSG_CODES_ENUM_20203(20203, "The new password and the verify password do not match"),
  MSG_CODES_ENUM_20204(20204, "New password can not be empty"),
  MSG_CODES_ENUM_20205(20205, "New password:Combination of 8-12 letters and numbers with at least one capital letter"),
  MSG_CODES_ENUM_20206(20206, "Verify password can not be empty"),
  MSG_CODES_ENUM_20207(20207, "Verify password:Combination of 8-12 letters and numbers with at least one capital letter");

  /**
   * code
   */
  private int code;

  /**
   * message
   */
  private String message;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  MsgCodesEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public static String getMessage(int state) {
    for (MsgCodesEnum temp : MsgCodesEnum.values()) {
      if (state == temp.getCode()) {
        return temp.getMessage();
      }
    }
    return "";
  }

}
