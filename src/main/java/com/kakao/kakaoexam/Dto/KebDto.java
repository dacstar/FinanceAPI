package com.kakao.kakaoexam.Dto;

public class KebDto {

		private int maxyear;
		private int minyear;
		private long maxamount;
		private long minamount;
		
		
		public KebDto(int maxyear, int minyear, long maxamount, long minamount) {
			super();
			this.maxyear = maxyear;
			this.minyear = minyear;
			this.maxamount = maxamount;
			this.minamount = minamount;
		}


		@Override
		public String toString() {
			return "KebDto [maxyear=" + maxyear + ", minyear=" + minyear + ", maxamount=" + maxamount + ", minamount="
					+ minamount + "]";
		}
		
		
}
