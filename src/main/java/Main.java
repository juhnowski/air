import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {

    public static HashMap<String,Boolean> flights = new HashMap();

    public static void main(String[] args) {
        port(1234);
        // http://localhost:1234/123
        get("/:id", (req, res) -> {
            String id = req.params(":id");

            Boolean fligth = flights.get(id);

            if (fligth==null){
                return "рейс не найден";
            } else {
                if (fligth==true) {
                    return "разрешено";
                } else {
                    return "запрещено";
                }
            }
        });


        post("/:id", (req, res) -> {
            String id = req.params(":id");
            System.out.println("id="+id + " true");
            flights.put(id,true);
            return "вылет " + flights.get(id);
        });
    }
}
