package ei.eseptiyadi.notesapp.model.auth;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RequestRegister{

	@SerializedName("code")
	private int code;

	@SerializedName("userbaru")
	private List<UserbaruItem> userbaru;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setUserbaru(List<UserbaruItem> userbaru){
		this.userbaru = userbaru;
	}

	public List<UserbaruItem> getUserbaru(){
		return userbaru;
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
			"RequestRegister{" + 
			"code = '" + code + '\'' + 
			",userbaru = '" + userbaru + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}