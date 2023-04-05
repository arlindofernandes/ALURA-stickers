import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //requisição HTTPs
        API api = API.IMDB_TOP_MOVIE;
        // ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();

        // ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
        String url = api.getUrl();

        ExtratorDeConteudo extrator = api.getExtrator();
       
        var httpConnect = new ClienteHttp();
        String json = httpConnect.buscaDados(url);

        List<Conteudo> listaConteudos = extrator.extraConteudos(json);

        var diretorio = new File("stickers/");
        diretorio.mkdir();

        var maker = new StickerMaker();

        for (Conteudo conteudo : listaConteudos) {

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String filename = "stickers/" + conteudo.titulo() + ".png";
            maker.cria(inputStream, filename);

            System.out.println("\u001b[1mTítulo: \u001b[m" + conteudo.titulo());
            System.out.println("\u001b[1mURL da imagem: \u001b[m" + conteudo.urlImagem());
            // var classificação = Double.parseDouble(conteudo.get("imDbRating"));
            // int estrelas = (int)classificação;
            // for (int i = 0; i <= estrelas; i++) {
            // System.out.print("⭐");

            // }
            System.out.println();
        }
    }
}
