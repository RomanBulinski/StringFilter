import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    
//rules is a list of String predicates by which strings should be filtered.
//        Returned list contains strings, which conform to all predicates from the list.
    //    public List<String> filttr(List<Predicate<String>> rules, List<String> strings)

    //    public List<String> filttr(List<Predicate<String>> rules, List<String> strings){
//    }

    public static Predicate<String> predicate_dom(){
        return p -> p.equals("dom");
    }

    public static Predicate<String> predicate_tron(){
        return p -> p.equals("tron");
    }

    public static Predicate<String> predicate_start_h(){
        return p -> p.startsWith("h");
    }

    public static Predicate<String> predicate_end_e(){
        return p -> p.endsWith("e");
    }

    public static List<String> filttr (  Predicate<String> predicate, List<String> strings){
        return strings.stream()
                .filter( predicate )
                .collect(Collectors.toList());
    }

//    public static List<String> filtters (  List<Predicate<String>> rules, List<String> strings){
//        return strings.stream()
//                .filter( rules.get(0) )
//                .filter( rules.get(1) )
//                .collect(Collectors.toList());
//    }

    public static List<String> filttersAuto (  List<Predicate<String>> rules, List<String> strings){
        return strings.stream()
                .filter(rules.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());
    }




    public static void main(String[] args) {

        List<Predicate<String>> rules = Arrays.asList( predicate_start_h(),predicate_end_e() );

        List<String> strings = Arrays.asList("dom", "home", "tron", "history", "pledge", "holere");

        System.out.println(filttr ( predicate_end_e() ,  strings ) );

//        System.out.println( filtters ( rules,  strings ) );

        System.out.println( filttersAuto ( rules,  strings ) );



    }




}
