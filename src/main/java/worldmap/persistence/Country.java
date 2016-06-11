package worldmap.persistence;

public class Country {
	private String code;
	private String name;
	private String continent;
	private String region;
	private double surface;
	private int population;
	private String governmentForm;

    public Country(String code, String name, String continent, String region, double surface, int population, String governmentForm) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surface = surface;
        this.population = population;
        this.governmentForm = governmentForm;
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
        return governmentForm;
    }
}
