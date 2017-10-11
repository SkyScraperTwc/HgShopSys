package indi.twc.hg.entity;

public class User {
		//主键
		private Integer id;
		//名字
		private String username; 
		//密码
		private String password;
		//手机号码
		private String mobile;
		//邮箱地址
		private String email;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id; 
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPwd() {
			return password;
		}
		public void setPwd(String pwd) {
			this.password = pwd;
		}
		public String getMobile() { 
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email; 
		}
		
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", mobile=" + mobile + ", email="
					+ email + "]";
		}
}
