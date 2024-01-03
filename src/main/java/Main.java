import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Navigator navigator = new NavigatorImpl();
        Random random = new Random();

        /*for (int i = 0; i < 20; i++) {
            String id = "Route" + i;
            int numPoints = random.nextInt(10) + 1; // Random number of points between 1 and 10
            Double distance = 10.0 * numPoints; // Distance is inversely proportional to number of points
            Boolean isFavourite = i % 2 == 0; // Alternate between favourite and not favourite
            List<String> locationPoints = new ArrayList<>();
            for (int j = 0; j < numPoints; j++) {
                locationPoints.add("Point" + j);
            }
            Route route = new Route(id, distance, isFavourite, locationPoints);
            navigator.addRoute(route);
        }*/


        Route route1 = new Route("Route1", (double) (10 * 3), false, Arrays.asList("Point1","Point232","Point3"));
        Route route2 = new Route("Route2", (double) (10 * 3), true, Arrays.asList("Point1","Point2131231","Point3"));
        Route route3 = new Route("Route3", (double) (10 * 3), false, Arrays.asList("Point1","Point4345","Point3"));
        Route route4 = new Route("Route4", (double) (10 * 3), false, Arrays.asList("Point1","Point346346","Point3"));
        Route route5 = new Route("Route5", (double) (10 * 3), true, Arrays.asList("Point1","Point4656","Point3"));
        Route route6 = new Route("Route6", (double) (10 * 3), false, Arrays.asList("Point1","Point0","Point3"));
        Route route7 = new Route("Route7", (double) (10 * 3), false, Arrays.asList("Point1","Point13","Point3"));
        Route route8 = new Route("Route8", (double) (10 * 4), false, Arrays.asList("Point1","Point13", "Point23", "Point3"));

        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);
        navigator.addRoute(route5);
        navigator.addRoute(route6);
        navigator.addRoute(route7);
        navigator.addRoute(route8);

        Iterable<Route> searchRoutes = navigator.searchRoutes("Point1", "Point3");
        System.out.println("Point1 - Point3 routes:");
        for (Route route : searchRoutes) {
            System.out.println(route);
        }

        Iterable<Route> getFavoriteRoutes = navigator.getFavoriteRoutes("Point3");
        System.out.println("Get favorite routes to Point3:");
        for (Route route : getFavoriteRoutes) {
            System.out.println(route);
        }
    }
}