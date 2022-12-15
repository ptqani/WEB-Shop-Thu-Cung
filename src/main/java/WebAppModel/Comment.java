package WebAppModel;
public class Comment {
	private String name;
	private String command;
	private String datetime;
	private String idpro;
	public Comment(String name, String command, String datetime, String idpro) {
		super();
		this.name = name;
		this.command = command;
		this.datetime = datetime;
		this.idpro = idpro;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getIdpro() {
		return idpro;
	}
	public void setIdpro(String idpro) {
		this.idpro = idpro;
	}

	

}
