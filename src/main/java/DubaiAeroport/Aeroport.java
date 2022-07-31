package DubaiAeroport;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Aeroport {
   static List<FlightModel>flightModelList= new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String link = "https://www.dubai-airport.xyz/en/arrivals/";
        Document document = Jsoup.connect(link).maxBodySize(0).get();
        Elements arrivals = document.getElementsByClass("searchable");
        for (Element i:arrivals ) {
           arrivals(i.text());
        }
        for (FlightModel i : flightModelList) {
           // System.out.println(i);
        }
        aeroportcount();

    }
    public static List<FlightModel> arrivals (String a){
        String [] array = a.split(">>");

       // System.out.println(array.length);
        for (String i : array) {
            if (check(i)){
                String [] array2= i.split("\\(");// названия аэропортов
                String array3[] = array2[1].split("\\) ");
                String [] array4 = array3[1].split(" ");
                //  System.out.println(array4[3]);
                FlightModel flightModel = new FlightModel(array2[0],array3[0],array4[0],array4[1],array4[2]);
                flightModelList.add(flightModel);
            }
        }
        return flightModelList;
    }
    public static boolean check (String a){
        int count =0;
        for (int i = 0; i < a.length();i++){
            if (a.charAt(i)=='('){
                count = count + 1;
            }
        }
        if (count==1){
            return true;
        }
        return false;
    }

    public static void  aeroportcount(){
        Map<String,Integer>integerMap = new HashMap<>();
        for (FlightModel i: flightModelList) {
            if (integerMap.containsKey(i.getAeroport())){
                int a = integerMap.get(i.getAeroport());
                a++;
                integerMap.replace(i.getAeroport(), a);
            }
            else {
                integerMap.put(i.getAeroport(),1);
            }
        }
         Set<Map.Entry<String,Integer>> entries =integerMap.entrySet();
        entries.stream().collect(Collectors.toList()).stream().sorted((a, b)->b.getValue().compareTo(a.getValue())).
                forEach(a-> System.out.println(a));

    }
}
