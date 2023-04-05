import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class loaderProperties {
    
    private Properties props;
    private String nomeDoProperties = "key.properties";

    protected loaderProperties(){
            props = new Properties();
            InputStream in = this.getClass().getResourceAsStream(nomeDoProperties);
            try{
                    props.load(in);
                    in.close();
            }
            catch(IOException e){e.printStackTrace();}
    }

    protected String getValor(String chave){
            return (String)props.getProperty(chave);
    }
}

