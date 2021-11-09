package task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebAddressParser {
    private URL address;

    public WebAddressParser(String stroka) {
        try{
            this.address = new URL(stroka);
        }
        catch(MalformedURLException a){
            this.address = null;
        }

    }


    public String getLogin() {
        if(this.address != null) {
            String[] authority = this.address.getAuthority().split("@");
            if(authority.length >= 2) {
                String[] userInfo = authority[0].split(":");
                if (userInfo.length >= 2) {
                    return userInfo[0];
                }
            }
        }
        //else {
        return "";
        //}
    }

    public String getPassword() {
        if (this.address != null) {
            String[] authority = this.address.getAuthority().split("@");
            if (authority.length >= 2) {
                String[] userInfo = authority[0].split(":");
                if (userInfo.length >= 2) {
                    return userInfo[1];
                }
            }
        }

        return "";
    }

    public String getScheme() {return (this.address != null ? this.address.getProtocol() : "");}
    public String getHost() {return (this.address != null ? this.address.getHost() : "");}
    public String getPort() {return (this.address != null && this.address.getPort() != -1 ? Integer.toString(this.address.getPort()) : "");}
    public String getUrl() {return (this.address != null ? this.address.getPath().replaceFirst("/", "") : "");}
    public String getFragment() {return (this.address != null && this.address.getRef() != null ? this.address.getRef() : "");}

    public boolean isValid() {
        return this.address != null;
    }

    public HashMap<String, String> getParameters() {
        if ((this.address != null) && (this.address.getQuery() != null)) {
            String[] query = this.address.getQuery().split("&");
            HashMap<String, String> parameters = new HashMap();

            for(int i = 0; i < query.length; i++) {
                String[] b = query[i].split("=");
                parameters.put(b[0], b[1]);
            }

            return parameters;
        }

        else {
            return new HashMap();
        }
    }


}
