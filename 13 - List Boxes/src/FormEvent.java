import java.util.EventObject;

public class FormEvent extends EventObject {

//	source raiseEvent - this case is FormPanel - okBtn
	// store information
	private String name;
	private String occupation;
	
	// constructor de lay data
	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	// constructor de truyen data
	public FormEvent(Object source, String name, String occupation) {
		super(source);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
