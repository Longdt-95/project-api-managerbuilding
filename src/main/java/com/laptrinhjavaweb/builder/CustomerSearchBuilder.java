package com.laptrinhjavaweb.builder;

public class CustomerSearchBuilder {
	private String fullName;
	private String phone;
	private String email;
	private String staffId;

	public String getFullName() {
		return fullName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getStaffId() {
		return staffId;
	}

	public CustomerSearchBuilder(BuilderCustomer builderCustomer) {
		this.fullName = builderCustomer.fullName;
		this.phone = builderCustomer.phone;
		this.email = builderCustomer.email;
		this.staffId = builderCustomer.staffId;
	}

	 public static class BuilderCustomer {

		private String fullName;
		private String phone;
		private String email;
		private String staffId;

		public BuilderCustomer setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public BuilderCustomer setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public BuilderCustomer setEmail(String email) {
			this.email = email;
			return this;
		}

		public BuilderCustomer setStaffId(String staffId) {
			this.staffId = staffId;
			return this;
		}

		public CustomerSearchBuilder build() {
			return new CustomerSearchBuilder(this);
		}

	}
}
