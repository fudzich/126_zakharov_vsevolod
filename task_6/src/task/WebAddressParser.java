package task;

import java.util.HashMap;

public class WebAddressParser {
    private String stroka;
    private String login="";
    private String password="";
    private String scheme="";
    private String host="";
    private String port="";
    private String url="";
    private String fragment="";
    private boolean key = false;
    //private HashMap<String, String> parameters = new HashMap<>();

    public WebAddressParser(String stroka) {
        this.stroka = stroka;
        //boolean key=false;
        int i_s=0;
        char[] str = stroka.toCharArray();
        for(int i = 0; i<str.length; i++){
            if(str[i] == ':'){
                if(str[i+1] == '/'){
                    if(str[i+2] == '/'){
                        key = true;
                        i_s=i+3;
                        char[] strS = new char [i];
                        for( int j = 0; j<i;j++){
                            strS[j] = str[j];
                        }
                        scheme = String.valueOf(strS);
                        break;
                    }
                }
            }
        }
        if(key == true){
            int begin_of_f=str.length;
            int begin_of_para=str.length;
            int begin_of_u=str.length;
            int end_of_pas=i_s;
            int begin_of_port=str.length;
            for(int i=i_s;i <str.length;i++){
                if(str[i]=='#'){
                    begin_of_f=i;
                    char[] strF = new char[(str.length-1)-i];
                    int sch=i+1;
                    for(int j=0;j<((str.length-1)-i);j++){
                        strF[j] = str[sch];
                        sch++;
                    }
                    fragment = String.valueOf(strF);
                }
            }
            for(int i=i_s;i <begin_of_f;i++){
                if(str[i]=='?'){
                    begin_of_para = i;
                }
            }
            for(int i=i_s;i < begin_of_para;i++){
                if(str[i] == '/'){
                    begin_of_u=i;
                    char[] strU = new char [(begin_of_para-1)-i];
                    int sch=i+1;
                    for(int j=0;j<((begin_of_para-1)-i);j++){
                        strU[j] = str[sch];
                        sch++;
                    }
                    url = String.valueOf(strU);
                }
            }
            for(int i=i_s;i < begin_of_u;i++){
                if(str[i] == '@'){
                    end_of_pas=i+1;
                    int end_of_l=i_s;
                    for(int ii=i_s;ii<i;ii++){
                        if(str[ii] == ':'){
                            end_of_l=ii+1;
                            char[] strL = new char [ii-i_s];
                            int sch=i_s;
                            for(int j=0;j<ii-i_s;j++){
                                strL[j]=str[sch];
                                sch++;
                            }
                            login = String.valueOf(strL);
                            break;
                        }
                    }
                    //for(int ii=end_of_l;ii<i;ii++){
                        char[] strPas = new char [i-end_of_l];
                        int sch=end_of_l;
                        for(int j=0;j< i-end_of_l;j++){
                            strPas[j] = str[sch];
                            sch++;
                        }
                        password = String.valueOf(strPas);
                        break;
                    //}

                }
            }
            for(int i =end_of_pas;i<begin_of_u;i++){
                if(str[i]==':'){
                    begin_of_port = i;
                    char[] strPort = new char[(begin_of_u-1)-i];
                    int sch=i+1;
                    for(int j=0;j<(begin_of_u-1)-i;j++){
                        strPort[j]=str[sch];
                        sch++;
                    }
                    port = String.valueOf(strPort);
                    break;
                }
            }
            //for(int i=end_of_pas;i<begin_of_port;i++){
                char[] strH = new char [begin_of_port-end_of_pas];
                int sch=end_of_pas;
                for(int j =0; j < (begin_of_port-end_of_pas);j++){
                    strH[j]=str[sch];
                    sch++;
                }
                host = String.valueOf(strH);

            //}

        }
        //parameters.put("login",login);
        //parameters.put("password",password);
        //parameters.put("scheme",scheme);
        //parameters.put("host",host);
        //parameters.put("port",port);
        //parameters.put("url",url);
        //fragment.put("fragment",fragment);
    }


    public String getLogin(){
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getScheme() {
        return scheme;
    }
    public String getHost() {
        return host;
    }
    public String getPort() {
        return port;
    }
    public String getUrl() {
        return url;
    }
    public String getFragment() {
        return fragment;
    }
    public HashMap<String, String> getParameters(){
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("login",login);
        parameters.put("password",password);
        parameters.put("scheme",scheme);
        parameters.put("host",host);
        parameters.put("port",port);
        parameters.put("url",url);
        parameters.put("fragment",fragment);
        return parameters;
    }
    public boolean isValid(){
        if(key == true){
            return true;
        }
        else {return false;}
    }
}
