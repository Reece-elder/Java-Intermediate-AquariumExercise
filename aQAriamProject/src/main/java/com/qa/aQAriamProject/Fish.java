package com.qa.aQAriamProject;

public class Fish {
	
	private long id;
	private String type;
	private String colour;
	private int length; 
	private float cost;
	
	public Fish(long id, String type, String colour, int length, float cost) {
		super();
		this.id = id;
		this.type = type;
		this.colour = colour;
		this.length = length;
		this.cost = cost;
	}

	public Fish(String type, String colour, int length, float cost) {
		super();
		this.type = type;
		this.colour = colour;
		this.length = length;
		this.cost = cost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + length;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fish other = (Fish) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (length != other.length)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
