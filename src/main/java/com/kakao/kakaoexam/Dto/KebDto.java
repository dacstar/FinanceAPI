package com.kakao.kakaoexam.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
public class KebDto implements Comparable<KebDto>  {

		private int year;
		private long amount;
	
		
		
		public KebDto(int year, long amount) {
			super();
			this.year = year;
			this.amount = amount;
		}

	@Override
	public int compareTo(KebDto o) {
		// TODO Auto-generated method stub
		return this.amount > o.amount ? 1 : -1;
	}

	@Override
	public String toString() {
		return "KebDto [year=" + year + ", amount=" + amount +"]";
	}




		
		
		
}
