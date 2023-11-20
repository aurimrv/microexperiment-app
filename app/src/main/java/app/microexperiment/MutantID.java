package app.microexperiment;

public class MutantID {
    private static String STATIC_NON_FINAL_STATIC_PARAMETER;
    public static String getMUID(){
        return STATIC_NON_FINAL_STATIC_PARAMETER;
    }
    public static void setMUID(String id) {
        STATIC_NON_FINAL_STATIC_PARAMETER=id;
    }
}

