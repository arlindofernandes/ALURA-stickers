public enum API {
    IMDB_TOP_MOVIE_KEY("https://imdb-api.com/en/API/Top250Movies/"+LoaderPropertiesImpl.getValor("KEY"), new ExtratorDeConteudoDoIMDB()),
    IMDB_TOP_MOVIE("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json",new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14",new ExtratorDeConteudoDaNasa()),
    LOCAL("http://localhost:8080/linguagens",new ExtratorDeConteudoDoIMDB());

    private String url;
    private ExtratorDeConteudo extrator;

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }

    API(String url, ExtratorDeConteudo extrator){
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl(){
        return url;
    }
}
