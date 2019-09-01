package com.restaurant.menu.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.order.bean.OrderItemDetails;
import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "ITEM", schema = CoreConstants.SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ITEM_NAME" }) })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ITEM_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Item implements Serializable, Comparable<Item>
{
	private static final long serialVersionUID = 3L;

	@JsonProperty(value=CoreConstants.Menu.ITEM_ID)
	private Integer itemId;

	@JsonProperty(value=CoreConstants.Menu.NAME)
	private String itemName;
	
	@JsonProperty(value=CoreConstants.Menu.PRICE)
	private Double price;

	@JsonIgnore
	private Category category;

	@JsonIgnore
	private Set<OrderItemDetails> orderItemDetails;

	@JsonIgnore
	private String status;

	@JsonIgnore
	private Date createdOn;

	@JsonIgnore
	private Date modifiedOn;

	public Item()
	{
	}

	public Item(Integer itemId)
	{
		this.itemId = itemId;
	}

	@Transient
	public abstract String getType();
	
	@Id
	@Column(name = "ITEM_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getItemId()
	{
		return itemId;
	}

	public void setItemId(Integer itemId)
	{
		this.itemId = itemId;
	}

	@Column(name = "ITEM_NAME", nullable = false)
	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID", nullable = false, foreignKey = @ForeignKey(name = "fk_category_item"))
	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	@Column(name = "PRICE", nullable = false)
	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemId")
	public Set<OrderItemDetails> getOrderItemDetails()
	{
		return orderItemDetails;
	}

	public void setOrderItemDetails(Set<OrderItemDetails> orderItemDetails)
	{
		this.orderItemDetails = orderItemDetails;
	}

	@Column(name = "STATUS", nullable = false, length = 5)
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
	public int compareTo(Item item)
	{
		return item.getCategory().getCategoryName().compareTo(this.category.getCategoryName());
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Item other = (Item) obj;
		if (category == null)
		{
			if (other.category != null)
				return false;
		}
		else if (!category.equals(other.category))
			return false;
		if (itemId == null)
		{
			if (other.itemId != null)
				return false;
		}
		else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null)
		{
			if (other.itemName != null)
				return false;
		}
		else if (!itemName.equals(other.itemName))
			return false;
		if (price == null)
		{
			if (other.price != null)
				return false;
		}
		else if (!price.equals(other.price))
			return false;
		return true;
	}
}
