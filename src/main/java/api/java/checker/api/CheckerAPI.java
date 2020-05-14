package api.java.checker.api;

public class CheckerAPI {
    public static Manager getManager() {
        return new Manager();
    }

    public static ValuesRetriever getValues() {
        return new ValuesRetriever();
    }

}
