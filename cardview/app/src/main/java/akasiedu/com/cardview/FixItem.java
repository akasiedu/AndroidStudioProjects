package akasiedu.com.cardview;

/**
 * Created by kwame on 4/29/15.
 */
public class FixItem {
    String fault;
    String id;
    String cause;
    String solution;

    public FixItem(String id, String fault, String cause, String solution) {
        this.fault = fault;
        this.id = id;
        this.cause = cause;
        this.solution = solution;
    }

    public String getFault(){
        return fault;
    }

    public String getCause(){
        return fault;
    }

    public String getSolution(){
        return solution;
    }

    public String getId(){
        return id;
    }

}
