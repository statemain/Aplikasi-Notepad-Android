package ei.eseptiyadi.notesapp.model.update;

import com.google.gson.annotations.SerializedName;

public class DataupadatedItem{

	@SerializedName("id_notes")
	private String idNotes;

	@SerializedName("titleof_notes")
	private String titleofNotes;

	@SerializedName("date_created")
	private String dateCreated;

	@SerializedName("contentof_notes")
	private String contentofNotes;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("categoryof_notes")
	private String categoryofNotes;

	public void setIdNotes(String idNotes){
		this.idNotes = idNotes;
	}

	public String getIdNotes(){
		return idNotes;
	}

	public void setTitleofNotes(String titleofNotes){
		this.titleofNotes = titleofNotes;
	}

	public String getTitleofNotes(){
		return titleofNotes;
	}

	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
	}

	public String getDateCreated(){
		return dateCreated;
	}

	public void setContentofNotes(String contentofNotes){
		this.contentofNotes = contentofNotes;
	}

	public String getContentofNotes(){
		return contentofNotes;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setCategoryofNotes(String categoryofNotes){
		this.categoryofNotes = categoryofNotes;
	}

	public String getCategoryofNotes(){
		return categoryofNotes;
	}

	@Override
 	public String toString(){
		return 
			"DataupadatedItem{" + 
			"id_notes = '" + idNotes + '\'' + 
			",titleof_notes = '" + titleofNotes + '\'' + 
			",date_created = '" + dateCreated + '\'' + 
			",contentof_notes = '" + contentofNotes + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",categoryof_notes = '" + categoryofNotes + '\'' + 
			"}";
		}
}