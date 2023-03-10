package com.example.geektrust;

public class InputValues {
	
	private Integer sourceX;
	
	private Integer sourceY;
	
	private String direction;
	
	private Integer destinationX;
	
	private Integer destinationY;

	public Integer getSourceX() {
		return sourceX;
	}

	public void setSourceX(Integer sourceX) {
		this.sourceX = sourceX;
	}

	public Integer getSourceY() {
		return sourceY;
	}

	public void setSourceY(Integer sourceY) {
		this.sourceY = sourceY;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getDestinationX() {
		return destinationX;
	}

	public void setDestinationX(Integer destinationX) {
		this.destinationX = destinationX;
	}

	public Integer getDestinationY() {
		return destinationY;
	}

	public void setDestinationY(Integer destinationY) {
		this.destinationY = destinationY;
	}

	@Override
	public String toString() {
		return "InputValues [sourceX=" + sourceX + ", sourceY=" + sourceY + ", direction=" + direction
				+ ", destinationX=" + destinationX + ", destinationY=" + destinationY + "]";
	}
	
}
