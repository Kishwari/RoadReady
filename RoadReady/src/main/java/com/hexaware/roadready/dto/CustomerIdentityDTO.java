package com.hexaware.roadready.dto;



public class CustomerIdentityDTO {

	private Long id;
    
    private int customerId;
    
    private byte[] content;

	public CustomerIdentityDTO() {
		super();

	}

	public CustomerIdentityDTO(Long id, int customerId, byte[] content) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
}
