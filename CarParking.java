package biydaalt2;

import java.util.*;
import java.io.*;

public class CarParking {
    
    private Stack<Car> zogsool = new Stack<>();
    private static final int MAX_SIZE = 10;
    
    public void process(Car car) {
        if(car.getChiglel().equals("A"))
            input(car);
        else if(car.getChiglel().equals("D"))
            output(car);
    }
    
    public void input(Car orohCar) {
        if(zogsool.size() < MAX_SIZE){
            zogsool.push(orohCar);
            System.out.println("Arrival " + orohCar.getDugaar() + " -> There is room.");
        }
        else {
            System.out.println("Arrival " + orohCar.getDugaar() + " -> Garage full, this car cannot enter.");
        }
    }
    
    public void output(Car garahCar) {
        boolean carExist = false;
        Stack<Car> gadaa = new Stack<>();
        int movedCars = 0;
        
        while(!zogsool.isEmpty()) {
            if(zogsool.peek().getDugaar().equals(garahCar.getDugaar())) {
                zogsool.pop();
                carExist = true;
                System.out.println("Departure " + garahCar.getDugaar() + " -> " + movedCars + " cars moved out.");
                break;
            }
            else {
                gadaa.push(zogsool.pop());
                movedCars++;
            }
        }
        
        if(!carExist) {
            System.out.println("Departure " + garahCar.getDugaar() + " -> This car not in the garage.");
        }
        
        while(!gadaa.isEmpty()) {
            zogsool.push(gadaa.pop());
        }
    }
    
    public static void main(String[] args) {
        CarParking parking = new CarParking();
        
        try {
            File fileName = new File("cars.txt");
            Scanner scan = new Scanner(fileName);
            
            while(scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if(!line.isEmpty()) {
                    String[] array = line.split("\\s+");
                    if(array.length >= 2) {
                        Car newCar = new Car(array[0], array[1]);
                        parking.process(newCar);
                    }
                }
            }
            System.out.println("Amjilttai.");
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File oldsongui!");
        }
    }
}
