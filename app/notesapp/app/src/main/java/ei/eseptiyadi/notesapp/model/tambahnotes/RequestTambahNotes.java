package ei.eseptiyadi.notesapp.model.tambahnotes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RequestTambahNotes{

	@SerializedName("code")
	private int code;

	@SerializedName("insert_into")
	private String insertInto;

	@SerializedName("totalnotes")
	private String totalnotes;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	@SerializedName("datanotes")
	private List<DatanotesItem> datanotes;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setInsertInto(String insertInto){
		this.insertInto = insertInto;
	}

	public String getInsertInto(){
		return insertInto;
	}

	public void setTotalnotes(String totalnotes){
		this.totalnotes = totalnotes;
	}

	public String getTotalnotes(){
		return totalnotes;
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

	public void setDatanotes(List<DatanotesItem> datanotes){
		this.datanotes = datanotes;
	}

	public List<DatanotesItem> getDatanotes(){
		return datanotes;
	}

	@Override
 	public String toString(){
		return 
			"RequestTambahNotes{" + 
			"code = '" + code + '\'' + 
			",insert_into = '" + insertInto + '\'' + 
			",totalnotes = '" + totalnotes + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			",datanotes = '" + datanotes + '\'' + 
			"}";
		}
}