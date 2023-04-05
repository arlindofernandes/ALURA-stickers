public class LoaderPropertiesImpl {
    
        private static loaderProperties loader = new loaderProperties();
        
        public static String getValor(String chave){
                return (String)loader.getValor(chave);
        }
    
    }

