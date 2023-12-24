import java.util.List;
import java.util.Objects;

public class Route {

    private String id;
    private Double distance;
    private Integer popularity;
    private Boolean isFavourite;
    private List<String> locationPoints;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route route)) return false;
        return Objects.equals(id, route.id) && Objects.equals(distance, route.distance) && Objects.equals(popularity, route.popularity) && Objects.equals(isFavourite, route.isFavourite) && Objects.equals(locationPoints, route.locationPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, popularity, isFavourite, locationPoints);
    }
}