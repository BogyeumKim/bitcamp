package phonebook;

public class phoneInfo_basic {

	
	
		private int Idx;
		private String fr_name;
		private String fr_phonenumber;
		private String fr_email;
		private String fr_address;
		private String date;
		
		
		
		
		public phoneInfo_basic() {
			
		}


		public phoneInfo_basic(int Idx, String fr_name, String fr_phonenumber, String fr_email, String fr_address,
				String date) {
			this.Idx = Idx;
			this.fr_name = fr_name;
			this.fr_phonenumber = fr_phonenumber;
			this.fr_email = fr_email;
			this.fr_address = fr_address;
			this.date = date;
		}
		
		
		public int getIdx() {
			return Idx;
		}
		public void setIdx(int Idx) {
			this.Idx = Idx;
		}
		public String getFr_name() {
			return fr_name;
		}
		public void setFr_name(String fr_name) {
			this.fr_name = fr_name;
		}
		public String getFr_phonenumber() {
			return fr_phonenumber;
		}
		public void setFr_phonenumber(String fr_phonenumber) {
			this.fr_phonenumber = fr_phonenumber;
		}
		public String getFr_email() {
			return fr_email;
		}
		public void setFr_email(String fr_email) {
			this.fr_email = fr_email;
		}
		public String getFr_address() {
			return fr_address;
		}
		public void setFr_address(String fr_address) {
			this.fr_address = fr_address;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}


		@Override
		public String toString() {
			return "phoneInfo_basic [idx=" + Idx + ", fr_name=" + fr_name + ", fr_phonenumber=" + fr_phonenumber
					+ ", fr_email=" + fr_email + ", fr_address=" + fr_address + ", date=" + date + "]";
		}

		
		
		
	

}
