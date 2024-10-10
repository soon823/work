package 개인프로젝트;

public class Bread extends Dao {a

	private String bname;
	private String stuff;
	private String recipe;
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getStuff() {
		return stuff;
	}
	public void setStuff(String stuff) {
		this.stuff = stuff;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	
	@Override
	public String toString() {
		return "Bread [bname=" + bname + ", stuff=" + stuff + ", recipe=" + recipe + "]";
	}
	
	
	
}//end class
