import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ParsePDA {
    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<>();

        Document document = Jsoup.connect("http://4pda.ru/").get(); // соединение с сайтом, с сервером

        Elements h2Elements = document.getElementsByAttributeValue("class", "list-post-title"); // выполняем анализ считанного документа

        h2Elements.forEach(h2Element ->{
            Element aElement = h2Element.child(0); // потому что ссылка находится на первой позиции
            String url = aElement.attr("href");
            String title = aElement.child(0).text();

            articleList.add(new Article(url, title));
        });

        articleList.forEach(System.out::println);
    }
}
// maven