package ei.eseptiyadi.notesapp.model.update;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RequestUpdate{

	@SerializedName("dataupadated")
	private List<DataupadatedItem> dataupadated;

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDataupadated(List<DataupadatedItem> dataupadated){
		this.dataupadated = dataupadated;
	}

	public List<DataupadatedItem> getDataupadated(){
		return dataupadated;
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
			"RequestUpdate{" + 
			"dataupadated = '" + dataupadated + '\'' + 
			",code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}