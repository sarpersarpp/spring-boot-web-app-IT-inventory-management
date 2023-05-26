package project.app.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Item {

	@NotNull
	private long id;
	
	@NotNull
	@Size(min=3,max=50)
	private String itemBrand;
	
	@NotNull
	@Size(min=3,max=50)
	private String itemType;
	
	@NotNull
	private int itemQuantity;

	@DateTimeFormat(pattern= "dd-MM-yyyy")
	private LocalDate itemDate;
	
	@NotNull
	@Size(min=3,max=50)
	private String itemLocation;

	@NotNull
	@Size(min=3,max=50)
	private String itemPerson;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public LocalDate getItemDate() {
		return itemDate;
	}

	public void setItemDate(LocalDate itemDate) {
		this.itemDate = itemDate;
	}

	public String getItemLocation() {
		return itemLocation;
	}

	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}

	public String getItemPerson() {
		return itemPerson;
	}

	public void setItemPerson(String itemPerson) {
		this.itemPerson = itemPerson;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	
	
}
