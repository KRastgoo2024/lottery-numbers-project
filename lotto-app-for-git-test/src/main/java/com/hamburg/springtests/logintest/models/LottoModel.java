package com.hamburg.springtests.logintest.models;

public class LottoModel {
	
	private String lottoZahlen;
	
	public LottoModel() {
		super();
	}

	public String getLottoZahlen() {
		return lottoZahlen;
	}


	public void setLottoZahlen(String lottoZahlen) {
		this.lottoZahlen = lottoZahlen;
	}

	@Override
	public String toString() {
		return "LottoModel [lottoZahlen=" + lottoZahlen + "]";
	}

}
