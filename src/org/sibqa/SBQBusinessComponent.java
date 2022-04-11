package org.sibqa;

public class SBQBusinessComponent extends SBQPrototype {

    public SBQBusinessComponent() {
        System.out.println("SBQBusinessComponent is initialized");
    }
    public static void main(String[] args)
    {
        boolean isConnected;
        boolean isDisconnected;
        SBQBusinessComponent demo = new SBQBusinessComponent();
        isConnected = demo.connectToSiebel();
        System.out.println("Siebel server connected      ["+isConnected+"]");
        isDisconnected = demo.disconnectFromSiebel();
        System.out.println ("Siebel server disconnected.      ["+isDisconnected+"]");
    }
}
