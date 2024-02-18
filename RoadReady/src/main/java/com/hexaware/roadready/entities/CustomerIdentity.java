package com.hexaware.roadready.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Min;

@Entity
public class CustomerIdentity {
    
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity_seq")
	    @SequenceGenerator(name = "identity_seq", sequenceName = "identity_seq", initialValue = 5001)
	    
	    private Long id;
	    
	    private int customerId;
	    
	    @Lob
	    @Column(length = 10485760)  //10mb
	    private byte[] content;

		public CustomerIdentity() {
			super();
		
		}

		public CustomerIdentity(Long id, int customerId, byte[] content) {
			super();
			this.id = id;
			this.customerId = customerId;
			this.content = content;
		}
        
		@Min(100)
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
