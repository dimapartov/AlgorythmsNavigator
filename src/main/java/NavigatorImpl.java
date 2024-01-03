import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
public class NavigatorImpl implements Navigator {

    private HashTable<Route> routes;

    public NavigatorImpl() {
        routes = new HashTable<>();
    }

    @Override
    public void addRoute(Route route) {
        routes.put(route.getId(), route);
    }

    @Override
    public void removeRoute(String routeId) {
        Route route = routes.getValue(routeId);
        if (route != null) {
            routes.remove(routeId);
        }
    }

    @Override
    public boolean contains(Route route) {
        return routes.findNode(route.getId()) != null;
    }

    @Override
    public int size() {
        return routes.getSize();
    }

    @Override
    public Route getRoute(String routeId) {
        return routes.getValue(routeId);
    }

    @Override
    public void chooseRoute(String routeId) {
        Route route = routes.getValue(routeId);
        if (route != null) {
            route.setPopularity(route.getPopularity() + 1);
        }
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        Collection<Route> routeCollection = (Collection<Route>) routes.values();
        return routeCollection.stream()
            .filter(route -> route.getLocationPoints().get(0).equals(startPoint) && route.getLocationPoints().get(route.getLocationPoints().size() - 1).equals(endPoint))
            .sorted(Comparator.comparing(Route::getFavourite).reversed().thenComparing(Route::getDistance).thenComparing(Route::getPopularity, Comparator.reverseOrder()))
            .distinct()
            .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String endPoint) {
        Collection<Route> routeCollection = (Collection<Route>) routes.values();
        return routeCollection.stream()
            .filter(route -> route.getFavourite() && !route.getLocationPoints().get(0).equals(endPoint) && route.getLocationPoints().get(route.getLocationPoints().size() - 1).equals(endPoint))
            .sorted(Comparator.comparing(Route::getDistance).thenComparing(Route::getPopularity, Comparator.reverseOrder()))
            .distinct()
            .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getTop3Routes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTop3Routes'");
    }
}