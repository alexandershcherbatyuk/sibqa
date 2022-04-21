package org.sibqa;

import com.siebel.data.SiebelBusComp;
import com.siebel.data.SiebelBusObject;
import com.siebel.data.SiebelException;

public class SBQBusinessComponent extends SBQPrototype {

    public String getFieldData(String sBusObj, String sBusComp, String valueField, String queryField, String queryValue) {
        SiebelBusObject busObject;
        SiebelBusComp busComp;

        String sResult = "";

        try {
            busObject = sbqDataBean.getBusObject(sBusObj);
            busComp = busObject.getBusComp(sBusComp);

            busComp.setViewMode(3);
            busComp.activateField(valueField);
            busComp.clearToQuery();
            busComp.setSearchSpec(queryField, queryValue);
            busComp.executeQuery(false);
            if (busComp.firstRecord()) {
                sResult = busComp.getFieldValue(valueField);
            }

        }catch (SiebelException e) {
            System.out.println(e.getErrorMessage());
        }
        return sResult;
    }
    public SBQBusinessComponent() {
        System.out.println("SBQBusinessComponent is initialized");
    }
    public static void main(String[] args) //For test purposes only
    {
        boolean isConnected;
        boolean isDisconnected;
        String sFieldValue;
        String sFieldValueStatus;

        SBQBusinessComponent demo = new SBQBusinessComponent();
        isConnected = demo.connectToSiebel();

        System.out.printf("%s %23s%n", "Siebel server connected", "["+isConnected+"]");

        sFieldValue = demo.getFieldData("Account", "Account", "Name", "Id", "1-1B2H");
        System.out.println("sFieldValue: " + sFieldValue);

        isDisconnected = demo.disconnectFromSiebel();
        System.out.printf("%s %20s%n", "Siebel server disconnected", "["+isDisconnected+"]");
    }
}
