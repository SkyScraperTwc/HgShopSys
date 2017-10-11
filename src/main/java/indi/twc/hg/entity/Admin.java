package indi.twc.hg.entity;

public class Admin {
		//主键
		private Integer id;
		//名字
		private String adminName; 
		//密码
		private String password;
		//性别
		private String sex;
		//描述
		private String desc;
		//真实姓名
		private String realName;
		
		public Integer getId() {
			return id; 
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getRealName() {
			return realName;
		}
		public void setRealName(String realName) { 
			this.realName = realName;
		}
		@Override
		public String toString() {
			return "Admin [id=" + id + ", adminName=" + adminName + ", password=" + password + ", sex=" + sex + ", desc=" + desc + ", realName=" + realName + "]";
		}
		
}
 