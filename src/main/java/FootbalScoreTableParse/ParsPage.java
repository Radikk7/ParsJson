package FootbalScoreTableParse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParsPage {
    static Scanner console = new Scanner(System.in);


    static String url = "https://www.liveresult.ru/football/England/Premier-League/standings";
    static String urlLaliga="https://www.liveresult.ru/football/Spain/LaLiga/standings";
    static String urlSeriaA = "https://www.liveresult.ru/football/Italy/Serie-A/standings";
    static String urlBundesliga = "https://www.liveresult.ru/football/Germany/Bundesliga-I/standings";
    static String urlLiga1 = "https://www.liveresult.ru/football/France/Ligue-1/standings";
    static List<TableModel>arrayListArrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        while (true){
            System.out.println("Выберите лигу");
            System.out.println(1 + "  Английская Примьер-Лига АПЛ");
            System.out.println(2 + "  Испанская Ла-Лига");
            System.out.println(3 + "  Итальянская Серия А");
            System.out.println(4 + "  Немецкая Бундеслига");
            System.out.println(5 + "  Французская Лига1");
            String champion= console.nextLine();
            if (champion.equals("1")){
                arrayListArrayList= returnTables(url);
                for (TableModel i: arrayListArrayList) {
                    System.out.println(i);
                }
            }
            else if (champion.equals("2")){
                arrayListArrayList = returnTables(urlLaliga);
                for (TableModel i: arrayListArrayList) {
                    System.out.println(i);
                }
            }
            else if (champion.equals("3")){
                arrayListArrayList = returnTables(urlSeriaA);
                for (TableModel i: arrayListArrayList) {
                    System.out.println(i);
                }
            }
            else if (champion.equals("4")){
                arrayListArrayList = returnTables(urlBundesliga);
                for (TableModel i: arrayListArrayList) {
                    System.out.println(i);
                }
            }
            else if (champion.equals("5")){
                arrayListArrayList = returnTables(urlLiga1);
                for (TableModel i:arrayListArrayList) {
                    System.out.println(i);
                }
            }
        }

    }
    public static TableModel addtableModeles(String url){
      String [] array= url.split("Заявка");
        String [] array1space = array[0].split(" ",2);
        String []array2space = array[1].split(" ");
        TableModel tableModel = new TableModel(array1space[0].replaceAll("\\.", ""),array1space[1],array2space[0],array2space[1],array2space[2],
                array2space[3],array2space[4] + " " +  array2space[5]+ array2space[6] + array2space[7],array2space[8]);
        return tableModel;
    }
    public static List<TableModel> returnTables(String url) throws IOException {
        Document document = Jsoup.connect(url).maxBodySize(0).get();
        Elements documents = document.getElementsByClass("alt1");
        Elements doc2 = document.getElementsByClass("alt2");
        ArrayList<TableModel>tableModels=new ArrayList<>();
        int count = 0;
        for (Element i: documents) {
            TableModel tableModel =addtableModeles(i.text());
            count++;
            tableModels.add(tableModel);
            if (count >= 10){
                break;
            }
        }
        for (Element i : doc2) {
            TableModel tableModel =addtableModeles(i.text());
            count++;
            tableModels.add(tableModel);
            if (count >= 20){
                break;
            }
        }
       return tableModels.stream().sorted((x,y) -> Integer.parseInt(x.getReating())- Integer.parseInt(y.getReating())).collect(Collectors.toList());

    }
}
