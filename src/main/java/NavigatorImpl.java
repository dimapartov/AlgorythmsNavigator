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
//        todo
        throw new UnsupportedOperationException("Unsdasdasd");
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFavoriteRoutes'");
    }

    @Override
    public Iterable<Route> getTop3Routes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTop3Routes'");
    }
}