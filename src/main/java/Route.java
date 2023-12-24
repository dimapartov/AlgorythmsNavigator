import java.util.List;
import java.util.Objects;

public class Route {

    private String id;
    private Double distance;
    private Integer popularity;
    private Boolean isFavourite;
    private List<String> locationPoints;

    public Route(String id, Double distance, Integer popularity, Boolean isFavourite, List<String> locationPoints) {
        this.id = id;
        this.distance = distance;
        this.popularity = popularity;
        this.isFavourite = isFavourite;
        this.locationPoints = locationPoints;
    }

    public String getId() {
        return id;
    }
    public Double getDistance() {
        return distance;
    }
    public Integer getPopularity() {
        return popularity;
    }
    public Boolean getFavourite() {
        return isFavourite;
    }
    public List<String> getLocationPoints() {
        return locationPoints;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
    public void setLocationPoints(List<String> locationPoints) {
        this.locationPoints = locationPoints;
    }

//    TODO remake equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route route)) return false;
        return Objects.equals(id, route.id) && Objects.equals(distance, route.distance) && Objects.equals(popularity, route.popularity) && Objects.equals(isFavourite, route.isFavourite) && Objects.equals(locationPoints, route.locationPoints);
    }

//    TODO remake hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", distance=" + distance +
                ", popularity=" + popularity +
                ", isFavourite=" + isFavourite +
                ", locationPoints=" + locationPoints +
                '}';
    }
}