import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Navigator navigator = new NavigatorImpl();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
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
        }

        Route route21 = new Route("Route21", (double) (10 * 3), false, Arrays.asList("Point1","Point232","Point3"));
        Route route22 = new Route("Route22", (double) (10 * 3), true, Arrays.asList("Point1","Point2131231","Point3"));
        Route route23 = new Route("Route23", (double) (10 * 3), false, Arrays.asList("Point1","Point4345","Point3"));
        Route route24 = new Route("Route24", (double) (10 * 3), false, Arrays.asList("Point1","Point346346","Point3"));
        Route route25 = new Route("Route25", (double) (10 * 3), true, Arrays.asList("Point1","Point4656","Point3"));
        Route route26 = new Route("Route26", (double) (10 * 3), false, Arrays.asList("Point1","Point0","Point3"));
        Route route27 = new Route("Route27", (double) (10 * 3), false, Arrays.asList("Point1","Point13","Point3"));
        Route route28 = new Route("Route28", (double) (10 * 4), false, Arrays.asList("Point1","Point13", "Point23", "Point3"));

        navigator.addRoute(route21);
        navigator.addRoute(route22);
        navigator.addRoute(route23);
        navigator.addRoute(route24);
        navigator.addRoute(route25);
        navigator.addRoute(route26);
        navigator.addRoute(route27);
        navigator.addRoute(route28);

        /*System.out.println("contains Route21: " + navigator.contains(route21));

        navigator.removeRoute("Route21");

        System.out.println("contains Route21 after delete: " + navigator.contains(route21));

        Route route2 = navigator.getRoute("Route2");

        System.out.println(route2);

        navigator.chooseRoute("Route2");

        System.out.println(route2);*/

//        System.out.println("navigator size: " + navigator.size());

        Iterable<Route> findRoutes = navigator.searchRoutes("Point1", "Point3");
        System.out.println("Point1 - Point3 routes:");
        for (Route route : findRoutes) {
            System.out.println(route);
        }
    }
}