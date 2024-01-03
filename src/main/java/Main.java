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

        Route route21 = new Route("Route21", (double) (100 / 3), false, Arrays.asList("A","B","C"));

//        add, remove, contains, size
        navigator.addRoute(route21);
        System.out.println("contains Route21: " + navigator.contains(route21));
        navigator.removeRoute("Route21");
        System.out.println("contains Route21 after delete: " + navigator.contains(route21));
        System.out.println("navigator size: " + navigator.size());

//        get route, choose route
        Route route2 = navigator.getRoute("Route2");
        System.out.println(route2);
        navigator.chooseRoute("Route2");
        System.out.println(route2);


        Iterable<Route> findRoutes = navigator.searchRoutes("Point0", "Point3");
        System.out.println("0-3 routes: ");
        for (Route route : findRoutes) {
            System.out.println(route);
        }
    }
}