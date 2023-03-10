package com.example.geektrust;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class PowerOfGMan {

	public static void main(String[] args) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(args[0]);
			readFileForG_Man(fileInputStream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void readFileForG_Man(FileInputStream fileInputStream) {
		
		InputValues inputValues = new InputValues();
		
		Integer sourceX;
		
		Integer sourceY;
		
		Integer destinationX;
		
		Integer destinationY;
		
		String direction;
		
		try {
			Scanner scan = new Scanner(fileInputStream);
			while(scan.hasNextLine()){
				
				String firstLine = scan.nextLine();
				String[] firstLineStringArray = firstLine.split(" ");
				HashSet<String> hashSetObject = new HashSet<String>();
				hashSetObject.add(firstLineStringArray[0]);
				hashSetObject.add(firstLineStringArray[1]);
				hashSetObject.add(firstLineStringArray[2]);
				
				Integer[] setValue = new Integer[2];
				setValue = parseValue(hashSetObject);
				
				if(hashSetObject.contains("SOURCE")){
					inputValues.setSourceX(setValue[0]);
					inputValues.setSourceY(setValue[1]);
					inputValues.setDirection(firstLineStringArray[3]);
					
				}
				else if (hashSetObject.contains("DESTINATION")) {
					inputValues.setDestinationX(setValue[0]);
					inputValues.setDestinationY(setValue[1]);
				}
				else if (hashSetObject.contains("PRINT_POWER")) {
					
					sourceX = inputValues.getSourceX();
					sourceY = inputValues.getSourceY();
					
					destinationX = inputValues.getDestinationX();
					destinationY = inputValues.getDestinationY();
					
					direction = inputValues.getDirection();
					
					Integer remainingPowerQuantity = calculateRemainingPowerQuantity(sourceX, sourceY,
														destinationX, destinationY, direction);
					
					System.out.println("POWER " +remainingPowerQuantity);
					
				}
						
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public Integer[] parseValue(HashSet<String> hashset) {
		
		Integer[] parsingArrayObject = new Integer[2];
		String[] toArrayObject = hashset.toArray(new String[hashset.size()]);
		parsingArrayObject[0] = Integer.parseInt(toArrayObject[1]);
		parsingArrayObject[1] = Integer.parseInt(toArrayObject[2]);
		
		
		return parsingArrayObject;
		
	}
	
	public Integer calculateRemainingPowerQuantity(Integer sourceX, Integer sourceY, Integer destinationX,
			Integer destinationY, String direction) {
		// TODO Auto-generated method stub
		Integer xTotal = 0;
		Integer yTotal = 0;
		int turns = 0;
		if(sourceX == destinationX) {
			
		}
		else if(sourceX > destinationX){
			xTotal = sourceX - destinationX;
			turns = totalTurn(direction);
		}
		else if(sourceX < destinationX) {
			xTotal = destinationX - sourceX;
			turns = totalTurn(direction);
		}
		
		if(sourceY == destinationY) {
			
		}
		else if (sourceY > destinationY) {
			yTotal = sourceY - destinationY;
			turns = totalTurn(direction);
			
		}
		else if (sourceY < destinationY) {
			yTotal = destinationY - sourceY;
			turns = totalTurn(direction);
			
		}
		
		Integer finalTotal = xTotal + yTotal;
		
		Integer remainingPower = 200 - ((finalTotal * 10) - (turns * 5));
		
		return remainingPower;
	}
	
	public Integer totalTurn(String direction) {
		
		Integer turn = 0;
		
		if(direction == "E") {
			turn++;
		}
		else if(direction == "S") {
			turn++;
		}
		else if (direction == "N") {
			turn++;
		}
		else if(direction == "W") {
			turn++;
		}
		
		return turn;
		
	}
	

}
