public class WeworkConfig {
    public String AgentId="1000005";
    public String Secret="1JPyY9GvPLZfpvxEDjok-Xt_9v7HIBYJhZUoO6EgNGY";
    public String corpid="wwd6da61649bd66fea";
    public String contactSecret="C7uGOrNyxWWzwBsUyWEbLQdOqoWPz4hNvxj9RIFv-4U";

    private static WeworkConfig weworkConfig;
    public static WeworkConfig getInstance(){
        if(weworkConfig==null){
            weworkConfig=new WeworkConfig();
        }
        return weworkConfig;
    }

}
