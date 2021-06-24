package apiBasePathes;
// The usage of this class is replaced by the enum class in the same package
public class ApiBasePathesAndEndPoints {

    private String addPlaceBP = "/maps/api/place/add/json";
    private String getPlaceBP = "/maps/api/place/get/json";
    private String deletePlaceBP = "/maps/api/place/delete/json";

    public String getAddPlaceBP() {
        return addPlaceBP;
    }

    public String getGetPlaceBP() {
        return getPlaceBP;
    }

    public String getDeletePlaceBP() {
        return deletePlaceBP;
    }
}
