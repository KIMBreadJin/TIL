package class222;

public class Furniture {
	private String name;
	private List<Tv> tvs = new ArrayList<Tv>();
	
	public String getName() {return this.name;}
	public Tv[] getTvs() {return this.tvs;}
	
	public void setName(String name) { this.name=name;}
	public void setTvs(Tv[] tvs) { this.tvs=tvs;}
	
	public Tv pick() {
		return this.tvs[0];
	}
	public Tv pick(int index) {
		return this.tvs[index];
	}
}
