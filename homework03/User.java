/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment03
 * User.java : define user object and getter & setter methods for each field
 * Reporting Date : 2019-04-08
 */

package homework03;

public class User // It is a kind of DAO(Data Access Object) for user account
{
	/** Member Field */
	private String user_id; // user ID
	private String user_pw; // user password
	
	/** Member Method */
	/* Constructor */
	public User(String user_id, String user_pw) 
	{
		this.setUser_id(user_id);
		this.setUser_pw(user_pw);
	}

	/* Getter & Setter Methods for each field */
	public String getUser_id() 
	{
		return this.user_id;
	}

	public void setUser_id(String user_id) 
	{
		this.user_id = user_id;
	}

	public String getUser_pw() 
	{
		return this.user_pw;
	}

	public void setUser_pw(String user_pw) 
	{
		this.user_pw = user_pw;
	}
	
	/* Login Method */
	public boolean login(String user_id, String user_pw)
	{
		return (this.user_id.equals(user_id) && this.user_pw.equals(user_pw));
		// if ID and password is correct, let user access the data the system provides
	}
}