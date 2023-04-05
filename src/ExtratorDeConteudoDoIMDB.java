import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    public List<Conteudo> extraConteudos(String json) {
        // extrair dados (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        return listaDeAtributos.stream()
                .map(atributos -> new Conteudo(atributos.get("title"),
                        atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg")))
                .toList();

    }
}
