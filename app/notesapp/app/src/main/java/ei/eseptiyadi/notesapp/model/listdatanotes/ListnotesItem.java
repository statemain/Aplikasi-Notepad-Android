package ei.eseptiyadi.notesapp.model.listdatanotes;

import com.google.gson.annotations.SerializedName;

public class ListnotesItem{

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

	@SerializedName("username")
	private String username;

	public String getIdNotes(){
		return idNotes;
	}

	public String getTitleofNotes(){
		return titleofNotes;
	}

	public String getDateCreated(){
		return dateCreated;
	}

	public String getContentofNotes(){
		return contentofNotes;
	}

	public String getIdUser(){
		return idUser;
	}

	public String getCategoryofNotes(){
		return categoryofNotes;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"ListnotesItem{" + 
			"id_notes = '" + idNotes + '\'' + 
			",titleof_notes = '" + titleofNotes + '\'' + 
			",date_created = '" + dateCreated + '\'' + 
			",contentof_notes = '" + contentofNotes + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",categoryof_notes = '" + categoryofNotes + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}