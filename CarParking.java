package biydaalt2;

import dataStructures.ArrayStack;
import lab3.MyStack;

import java.util.*;
import java.io.*;


public class CarParking extends ArrayStack{
	
	MyStack zogsool = new MyStack();
	
	public void process(Car car) {
		if(car.getChiglel().equals("A"))
			input(car);
		else if(car.getChiglel().equals("D"))
			output(car);
	}
	
	public void input(Car orohCar) {
		if(zogsool.size() < 10){
			zogsool.push(orohCar);
			System.out.println("Arrival " + orohCar.getDugaar() + " -> There is room. ");
		}
		else
		{
			System.out.println("Arrival " + orohCar.getDugaar() + " -> Garage full, this car cannot enter.");
		}
	}
	


	
	public void output(Car garahCar) 
	{
		
		boolean carExist = false;
		
		MyStack gadaa = new MyStack();
		
		while(zogsool.size() > 0) {
			if(((Car) zogsool.peek()).getDugaar().equals(garahCar.getDugaar())) {
				zogsool.pop();
				carExist = true;
				System.out.println("Departure " + garahCar.getDugaar() + " -> " + gadaa.size() + " cars moved out.");
				break;
			}
			else {
				gadaa.push(zogsool.peek());
				zogsool.pop();
			}
		}
		if(!carExist)
			System.out.println("Departure " + garahCar.getDugaar() + " -> This car not in the garage.");
		
		while(gadaa.size() > 0) {
			zogsool.push(gadaa.peek());
			gadaa.pop();
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		CarParking parking = new CarParking();
		
		try {
			String line = null;
			String array[];
			
			File fileName = new File("cars.txt");
			Scanner scan = new Scanner(fileName);
			
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				array = line.split(" ");
				Car newCar = new Car(array[0], array[1]);
				parking.process(newCar);
			}
			System.out.println("Amjilttai.");
			scan.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File oldsongui!");
		}

	}

}