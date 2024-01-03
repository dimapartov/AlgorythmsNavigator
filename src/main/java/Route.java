import java.util.List;
import java.util.Objects;

public class Route {

    private String id;
    private Double distance;
    private Integer popularity;
    private Boolean isFavourite;
    private List<String> locationPoints;

    public Route(String id, Double distance, Boolean isFavourite, List<String> locationPoints) {
        this.id = id;
        this.distance = distance;
        this.popularity = 0;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Double.compare(route.getDistance(), getDistance()) == 0 &&
               Objects.equals(getLocationPoints().get(0), route.getLocationPoints().get(0)) &&
               Objects.equals(getLocationPoints().get(getLocationPoints().size() - 1), route.getLocationPoints().get(route.getLocationPoints().size() - 1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocationPoints().get(0), getLocationPoints().get(getLocationPoints().size() - 1), getDistance());
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