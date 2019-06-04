package com.ace.wework;

public class WeworkConfig {
    public String AgentId="3010011";
    public String Secret="grP8wzPCp8Ki4o_2WKShNRCF1zY4upXch-oAmSu50Vw";
    public String corpid="ww264c888618add6be";
    public String contactSecret="nqH7bbGyzJCaCRQHvkA6Lo0lsZI7ihwR0BsRStuyjAE";

    private static WeworkConfig weworkConfig;
    public static WeworkConfig getInstance(){
        if(weworkConfig==null){
            weworkConfig=new WeworkConfig();
        }
        return weworkConfig;
    }
    public static void load(String path){
        // todo: read from yaml or json
    }

}
