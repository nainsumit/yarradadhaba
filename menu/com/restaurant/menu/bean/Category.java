package com.restaurant.menu.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "CATEGORY" , schema = CoreConstants.SCHEMA_NAME)
public class Category
{
	private Integer categoryId;
	private String categoryName;
	private Set<Item> item;
	private String status;
	private Date createdOn;
	private Date modifiedOn;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "CATEGORY_ID" , nullable = false , unique = true)
	public Integer getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(Integer categoryId)
	{
		this.categoryId = categoryId;
	}

	@Column(name =  "CATEGORY_NAME" , nullable = false , unique = true , length = 40)
	public String getCategoryName()
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "category")
	public Set<Item> getItem()
	{
		return item;
	}

	public void setItem(Set<Item> item)
	{
		this.item = item;
	}
	
	@Column(name = "STATUS", nullable = false , length = 5)
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_ON", nullable = false)
	public Date getModifiedOn()
	{
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn)
	{
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString()
	{
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", status="
				+ status + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryId == null)
		{
			if (other.categoryId != null)
				return false;
		}
		else if (!categoryId.equals(other.categoryId))
			return false;
		if (categoryName == null)
		{
			if (other.categoryName != null)
				return false;
		}
		else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}
}
