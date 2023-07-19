package org.mesoma;
import org.mesoma.Bookings.CarBooking;
import org.mesoma.Bookings.CarBookingDAO;
import org.mesoma.Bookings.CarBookingService;
import org.mesoma.Cars.Brand;
import org.mesoma.Cars.Car;
import org.mesoma.Cars.CarDAO;
import org.mesoma.Cars.CarService;
import org.mesoma.User.User;
import org.mesoma.User.UserFakerDataAccessService;
import org.mesoma.User.UserFileDataAccessService;
import org.mesoma.User.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.printf("hello");
        // write your code here
        //Instantiate Data stores
        CarDAO carDAO = new CarDAO();
        //UserFileDataAccessService userFileDataAccessService = new UserFileDataAccessService();
        UserFakerDataAccessService userFakerDataAccessService = new UserFakerDataAccessService();
        CarBookingDAO carBookingDAO = new CarBookingDAO();
        //create new cars
        Car toyota = new Car("1234",80.05, Brand.TOYOTA, true);
        Car audi = new Car("1235",80.05,Brand.AUDI, true);
        Car hyundai = new Car("1236",80.05,Brand.HYUNDAI, false);
        //instantiate service classes
        CarService carService = new CarService(carDAO);
        UserService userService = new UserService(userFakerDataAccessService);
        CarBookingService carBookingService = new CarBookingService(carBookingDAO, carService);
        //add cars
        carService.addNewCar(toyota);
        carService.addNewCar(audi);
        carService.addNewCar(hyundai);
        String menu = getMenu();
        boolean condition = true;
        while(condition){
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input){
                case 1: bookCar(userService,carBookingService); break;
                case 2: viewAllUserBookedCars(userService,carBookingService); break;
                case 3: viewBookings(carBookingService);break;
                case 4: viewAllAvailableCars(carBookingService);break;
                case 5: viewAllAvailableElectricCars(carBookingService);break;
                case 6: viewAllUsers(userService);break;
                case 7:condition = false; break;
                default:System.out.println(input + " is not a valid option ❌\n");break;
            }
        }
    }

    private static String getMenu() {
        return "\n"+
                "1️⃣-Book Car\n" +
                "2️⃣-View All User Booked cars\n" +
                "3️⃣-View All bookings\n" +
                "4️⃣-View Available Cars\n" +
                "5️⃣-View Available Electric cars\n" +
                "6️⃣-View All Users\n" +
                "7️⃣-Exit\n";
    }

    public static void viewAllUsers(UserService userService){
        List<User> users = userService.getUsers();
        if (users.isEmpty()) {
            System.out.println("❌ No users in the system");
            return;
        }
        users.forEach(System.out::println);
    }

    public static void viewBookings(CarBookingService carBookingService){
        List<CarBooking> bookings = carBookingService.getBookings();
        if (bookings.isEmpty()){
            System.out.println("No bookings available \uD83D\uDE15");
        }else{
            bookings.forEach(System.out::println);
        }
    }

    public static void viewAllUserBookedCars(UserService userService, CarBookingService carBookingService){
        for(User user: userService.getUsers()){
            System.out.println(user);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("➡️ Select user id");
        String input = scanner.nextLine();
        String response = "";
        int tracker = 1;
        for(CarBooking booking:carBookingService.getBookings()){
            if (input.equals(booking.getUser().getUserId().toString())){
                response = "user " + booking.getUser() +" has booked a car " + booking.getCar();
                tracker = 0;
                break;
            }
        }
        if(tracker != 0){
            try{
                User user = userService.getUserById(UUID.fromString(input));
                response = "❌ user "+user.toString()+" has no cars booked";
            }catch (IllegalArgumentException e){
                System.out.println("❌ invalid UserId");
                System.out.println(e.getMessage());
            }catch (NullPointerException e){
                System.out.println("❌ UserID does not exist");
            }
        }
        System.out.println(response);
    }

    public static void bookCar(UserService userService, CarBookingService carBookingService){
        if(carBookingService.getAllCars().size() == 0){
            System.out.println("No cars have been added yet");
        }else{
            List<Car> currentCars = carBookingService.getAllCars();
            List<Car> availableCars = new ArrayList<>();
            for (Car currentCar : currentCars) {
                if(currentCar.isAvailable()){
                    System.out.println(currentCar);
                    availableCars.add(currentCar);
                }
            }
            System.out.println("➡️ Select car reg number");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int tracker = 1;
            Car carToBeBooked = new Car();
            for(Car car: availableCars) {
                if (input.equalsIgnoreCase(car.getRegNumber())) {
                    tracker = 0;
                    carToBeBooked = car;
                    break;
                }
            }
            if(tracker != 0){
                System.out.println("reg number does not exist \uD83D\uDE14 " + "try booking a different car");
            }else{
                userService.getUsers().forEach(System.out::println);
                tracker = 1;
                System.out.println("➡️ Select user id");
                input = scanner.nextLine();
                for(User user: userService.getUsers()){
                    if(input.equals(user.getUserId().toString())){
                        tracker = 0;
                        CarBooking booking = new CarBooking(UUID.randomUUID(),user,carToBeBooked);
                        carBookingService.saveBookingToDAO(booking);
                        System.out.println("\uD83C\uDF89 Successfully booked car with regNumber "+carToBeBooked.getRegNumber()+
                                " for User " + user + "\n" +"Booking ref: "+ booking.getBookingId());
                        carToBeBooked.setAvailable(false);
                        break;
                    }
                }
                if(tracker!= 0){
                    System.out.println("no user with that Id found \uD83D\uDE14");
                }
            }
        }
    }

    public static void viewAllAvailableCars(CarBookingService carBookingService){
        if(carBookingService.getAllCars().size() == 0){
            System.out.println("No cars have been added yet");
        }else{
            List<Car> allCars = carBookingService.getAllCars();
            printAvailableCars(allCars);
        }
    }

    public static void viewAllAvailableElectricCars(CarBookingService carBookingService){
        if(carBookingService.getAllCars().size() == 0){
            System.out.println("No cars have been added yet");
        }else{
            List<Car> allElectricCars = carBookingService.getAllElectricCars();
            printAvailableCars(allElectricCars);
        }
    }

    private static void printAvailableCars(List<Car> currentCars) {
        List<Car> availableElectricCars = currentCars.stream().filter(Car::isAvailable).collect(Collectors.toList());
        availableElectricCars.forEach(System.out::println);
    }


}