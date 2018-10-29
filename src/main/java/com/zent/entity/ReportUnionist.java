package com.zent.entity;

public class ReportUnionist {
	private int sumUnionist;
	private int nationUnionist;
	private int religionUnionist;
	private int party;
	private int unionistNew;
	private int unionistCard;
	private int unionistBook;
	
	public ReportUnionist() {
		super();
	}
	public ReportUnionist(int sumUnionist, int nationUnionist,
			int religionUnionist, int party, int unionistNew, int unionistCard,
			int unionistBook) {
		super();
		this.sumUnionist = sumUnionist;
		this.nationUnionist = nationUnionist;
		this.religionUnionist = religionUnionist;
		this.party = party;
		this.unionistNew = unionistNew;
		this.unionistCard = unionistCard;
		this.unionistBook = unionistBook;
	}
	public int getSumUnionist() {
		return sumUnionist;
	}
	public void setSumUnionist(int sumUnionist) {
		this.sumUnionist = sumUnionist;
	}
	public int getNationUnionist() {
		return nationUnionist;
	}
	public void setNationUnionist(int nationUnionist) {
		this.nationUnionist = nationUnionist;
	}
	public int getReligionUnionist() {
		return religionUnionist;
	}
	public void setReligionUnionist(int religionUnionist) {
		this.religionUnionist = religionUnionist;
	}
	public int getParty() {
		return party;
	}
	public void setParty(int party) {
		this.party = party;
	}
	public int getUnionistNew() {
		return unionistNew;
	}
	public void setUnionistNew(int unionistNew) {
		this.unionistNew = unionistNew;
	}
	public int getUnionistCard() {
		return unionistCard;
	}
	public void setUnionistCard(int unionistCard) {
		this.unionistCard = unionistCard;
	}
	public int getUnionistBook() {
		return unionistBook;
	}
	public void setUnionistBook(int unionistBook) {
		this.unionistBook = unionistBook;
	}
	
	
}
