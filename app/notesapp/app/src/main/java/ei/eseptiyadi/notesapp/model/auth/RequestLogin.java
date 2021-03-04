package ei.eseptiyadi.notesapp.model.auth;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RequestLogin{

	@SerializedName("datauserlogin")
	private List<DatauserloginItem> datauserlogin;

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDatauserlogin(List<DatauserloginItem> datauserlogin){
		this.datauserlogin = datauserlogin;
	}

	public List<DatauserloginItem> getDatauserlogin(){
		return datauserlogin;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"RequestLogin{" + 
			"datauserlogin = '" + datauserlogin + '\'' + 
			",code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}