package indi.twc.hg.entity;

public class Brand {
		private Integer id; 
		private String cnName;
		private String enName;
		private String bigPhoto;//小图片
		private String smallPhoto;//大图片
		private String desc;
		
		public Brand() {
			super();
		}
		public Brand(Integer id) {
			super();
			this.id = id; 
		}
		public Brand(Integer brandId, String cnName, String enName) {
			this.id = brandId;
			this.cnName = cnName;
			this.enName = enName;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCnName() {
			return cnName;
		}
		public void setCnName(String cnName) {
			this.cnName = cnName;
		}
		public String getEnName() {
			return enName;
		}
		public void setEnName(String enName) {
			this.enName = enName;
		}
		public String getBigPhoto() {
			return bigPhoto;
		}
		public void setBigPhoto(String bigPhoto) {
			this.bigPhoto = bigPhoto;
		}
		public String getSmallPhoto() {
			return smallPhoto;
		}
		public void setSmallPhoto(String smallPhoto) {
			this.smallPhoto = smallPhoto;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		@Override
		public String toString() {
			return "Brand [id=" + id + ", cnName=" + cnName + ", enName=" + enName + ", bigPhoto=" + bigPhoto
					+ ", smallPhoto=" + smallPhoto + ", desc=" + desc + "]";
		}
		
}
