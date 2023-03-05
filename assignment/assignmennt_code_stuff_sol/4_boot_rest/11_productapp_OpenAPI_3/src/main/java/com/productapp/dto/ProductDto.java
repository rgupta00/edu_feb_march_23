package com.productapp.dto;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDto  {
	@Id
	private Integer id;

	@Schema(description = "Product Name")
	@NotNull(message = "{product.name.absent}")
	@Pattern(regexp = "[A-za-z]{5,50}", message = "{product.name.invalid}")
	private String name;

	@Schema(description = "Product Price")
	@NotNull(message = "{product.price.absent}")
	@Range(min = 10, max = 100000, message = "{product.price.invalid}")
	private BigDecimal price;

	public ProductDto(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
