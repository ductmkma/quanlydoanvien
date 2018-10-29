package com.zent.entity;

public class ReportRate {
	private Long sumRated;
	private Long sumNotRate;
	private Long sumExcellent;
	private Long sumRather;
	private Long sumMedium;
	private Long sumWeak;
	
	public ReportRate() {
		super();
	}

	public ReportRate(Long sumRated, Long sumNotRate, Long sumExcellent,
			Long sumRather, Long sumMedium, Long sumWeak) {
		super();
		this.sumRated = sumRated;
		this.sumNotRate = sumNotRate;
		this.sumExcellent = sumExcellent;
		this.sumRather = sumRather;
		this.sumMedium = sumMedium;
		this.sumWeak = sumWeak;
	}

	public Long getSumRated() {
		return sumRated;
	}

	public void setSumRated(Long sumRated) {
		this.sumRated = sumRated;
	}

	public Long getSumNotRate() {
		return sumNotRate;
	}

	public void setSumNotRate(Long sumNotRate) {
		this.sumNotRate = sumNotRate;
	}

	public Long getSumExcellent() {
		return sumExcellent;
	}

	public void setSumExcellent(Long sumExcellent) {
		this.sumExcellent = sumExcellent;
	}

	public Long getSumRather() {
		return sumRather;
	}

	public void setSumRather(Long sumRather) {
		this.sumRather = sumRather;
	}

	public Long getSumMedium() {
		return sumMedium;
	}

	public void setSumMedium(Long sumMedium) {
		this.sumMedium = sumMedium;
	}

	public Long getSumWeak() {
		return sumWeak;
	}

	public void setSumWeak(Long sumWeak) {
		this.sumWeak = sumWeak;
	}
	
	
	
}
