package com.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto
{

	
	private int categoryId;
	@NotBlank
	@Size(min=4)
	
	private String categoryTital;
	@NotBlank
	@Size(min=4)
	private String categoryDescription;
	
}
