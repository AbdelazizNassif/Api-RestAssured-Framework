package apiBasePathes;

public enum  ApiBasePathesAndEndPointsEnumClass {
    API_AddPlaceEP("/maps/api/place/add/json"),
    API_GetPlaceEP("/maps/api/place/get/json"),
    API_DeletePlaceEP("/maps/api/place/delete/json");
    private String resource;

    ApiBasePathesAndEndPointsEnumClass(String resource)
    {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
