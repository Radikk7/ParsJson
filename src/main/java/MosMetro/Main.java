package MosMetro;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Line>lineList=new ArrayList<>();
        String link = "https://www.moscowmap.ru/metro.html#lines";
        Document doc = Jsoup.connect(link).maxBodySize(0).get();

        Elements lines = doc.getElementsByClass("js-metro-line");
        for (Element i: lines) {

          String [] array =  i.toString().split("\"");
           // System.out.println(array[3]);
            Line line = new Line(i.text(),array[3]);
            //System.out.println(line);
            lineList.add(line);

        }
          for (Line j:lineList) {
             // System.out.println(j);
          }
               Elements stations = doc.getElementsByClass("js-metro-stations");
        for (Element i: stations) {
            String [] array = i.toString().split("\"");
           String numberOfLine =i.attr("data-line");//attr ищет атрибут и выводит его значение
          Line one =  lineList.stream().filter(x-> x.getNumber().equals(numberOfLine)).findFirst().get();
         //   System.out.println(i);
           Elements element= i.getElementsByAttribute("data-metrost");
           lineList.remove(one);
           List<Station>stationList=new ArrayList<>();
            for (Element e: element) {
           String []array2 =  e.text().split("\\.");
                Station station = new Station(array2[1],one,array2[0]);
                stationList.add(station);
            }
            one.setStations(stationList);
            lineList.add(one);

            //System.out.println(array[22]);
           // Station station = new Station(i.text(),);


           //System.out.println(i.text());
        }
              for (Line i:lineList) {
                  System.out.print("Name of Line- ");
                  System.out.println(i.getName() + i.getNumber());
                  System.out.println();
                  for (Station j: i.getStations() ) {
                      System.out.println(j);
                  }
              }
        System.out.println("Longest line" + maxLine(lineList));
    }
    public static Line maxLine(List<Line> lines){ // ищем самую длинную линию
        Line line=lines.stream().max((x,y)-> x.getStations().size() - y.getStations().size()).get();
        System.out.println(line.getStations().size());
        return line;
    }
}
