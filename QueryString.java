# URL-QueryString

public class QueryString {
    private StringBuffer query = new StringBuffer();
    public QueryString(String name,String value){
        encode(name,value);
    }
    public QueryString(String name,int value){
        encode(name,value);
    }

    public synchronized void add(String name,String value) {
        query.append("&");
        encode(name,value);
    }
    public synchronized void add(String name,int value) {
        query.append("&");
        encode(name,value);
    }

    private synchronized void encode(String name, String value){
        try {
            query.append(URLEncoder.encode(name,"UTF-8"));
            query.append("=");
            query.append(URLEncoder.encode(value,"UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private synchronized void encode(String name, int value){
        try {
            query.append(URLEncoder.encode(name,"UTF-8"));
            query.append("=");
            query.append(value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getQuery(){
        return query.toString();
    }

    @Override
    public String toString() {
        return getQuery();
    }
}
