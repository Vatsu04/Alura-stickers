import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws Exception {
        System.setProperty("console.encoding", "UTF-8");
        
        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair só os dados que interessam(título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDefilmes = parser.parse(body);
        
        System.out.println("Lista de filmes:");
        System.out.println();
        System.out.println();
        // exibir e manipular os dados
        for (Map<String, String> filme : listaDefilmes){
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo.replace(":", "_") + ".png";
            
            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);
            System.out.println("\u001b[1mTítulo: \u001b[m" +filme.get("title"));
            
            System.out.println("\u001b[1mPoster: \u001b[m" +filme.get("image"));
            
            System.out.println("\u001b[1m\u001b[37m\u001b[44mNota:\u001b[m " +filme.get("imDbRating"));
           // double classficacao = Double.parseDouble(filme.get("imDbRating"));
           /*  int numeroEstrelinhas = (int) classficacao;
            for (int n = 1; n<= numeroEstrelinhas;n++){
                System.out.print("⭐");
            } */
            
            System.out.println("\n");
        }
    }
}
