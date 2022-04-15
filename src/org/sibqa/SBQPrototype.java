package org.sibqa;

import com.siebel.data.SiebelException;
import com.siebel.data.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SBQPrototype
 * A base class for all other classes in the project.
 *
 * @author <a href="mailto:alexander@sibqa.org">Alexander Shcherbatyuk</a>
 *
 **/
public class SBQPrototype {
    //Variables private
    //Variables protected
    protected String cfgSiebelConnectionString = null;

    protected String cfgSiebelUserName = null;

    protected String cfgSiebelUserPassword = null;

    protected String cfgSiebelUserLanguage = null;

    protected SiebelDataBean sbqDataBean;

    //Variables public

    //Methods private
    private void parseSiebelProperties(){
        try {
            JsonObject jsonObject = new JsonParser().parse(SBQHelper.loadData("./config/siebel.properties.json")).getAsJsonObject();

            cfgSiebelConnectionString = jsonObject.getAsJsonObject("siebel").getAsJsonObject("connection").get("string").getAsString();

            cfgSiebelUserName = jsonObject.getAsJsonObject("siebel").getAsJsonObject("user").get("name").getAsString();

            cfgSiebelUserPassword = jsonObject.getAsJsonObject("siebel").getAsJsonObject("user").get("password").getAsString();

            cfgSiebelUserLanguage = jsonObject.getAsJsonObject("siebel").getAsJsonObject("user").get("language").getAsString();

        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
    //Methods private
    //Methods protected
    //Methods Public
    public SBQPrototype(){
        sbqDataBean = new SiebelDataBean();
    }
    /*
    * Method to connect to Siebel server
    * */

    public boolean connectToSiebel(){
        boolean bResult;

        try {
            parseSiebelProperties();
            sbqDataBean.login(cfgSiebelConnectionString, cfgSiebelUserName, cfgSiebelUserPassword, cfgSiebelUserLanguage);
            bResult = true;

        }catch (SiebelException e) {
            System.out.println(e.getErrorMessage());
            bResult = false;
        }

        return bResult;
    }
    /*
     * Method to disconnect from Siebel server
     * */
    public boolean disconnectFromSiebel() {
        boolean bResult;

        try {
            sbqDataBean.logoff();
          //  sbqDataBean = null; //Destroys a SiebelDataBean instance.
            bResult = true;

        }catch (SiebelException e) {
            System.out.println(e.getErrorMessage());
            bResult = false;
        }

        return bResult;
    }

}
