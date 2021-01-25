package ei.eseptiyadi.notesapp.model.listdatanotes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseListNotes{

	@SerializedName("code")
	private int code;

	@SerializedName("totalnotes")
	private String totalnotes;

	@SerializedName("listnotes")
	private List<ListnotesItem> listnotes;

	@SerializedName("message")
	private String message;

	@SerializedName("category")
	private String category;

	@SerializedName("status")
	private boolean status;

	public int getCode(){
		return code;
	}

	public String getTotalnotes(){
		return totalnotes;
	}

	public List<ListnotesItem> getListnotes(){
		return listnotes;
	}

	public String getMessage(){
		return message;
	}

	public String getCategory(){
		return category;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseListNotes{" + 
			"code = '" + code + '\'' + 
			",totalnotes = '" + totalnotes + '\'' + 
			",listnotes = '" + listnotes + '\'' + 
			",message = '" + message + '\'' + 
			",category = '" + category + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}