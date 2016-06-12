package week1.worldmap;

public class Country {
	private String code;
	private String name;
	private String continent;
	private String region;
	private double surface;
	private int population;
	private String government;
	
	public Country(String cd, String nm, String ct, String reg, double sur, int pop, String gov) {
		code = cd;
		name = nm;
		continent = ct;
		region = reg;
		surface = sur;
		population = pop;
		government = gov;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public String getRegion() {
		return region;
	}
	
	public double getSurface() {
		return surface;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public String getGovernmentForm() {
		return government;
	}
}
