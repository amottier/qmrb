package com.quelmarabout.dto;

import java.util.List;
import java.util.Set;

public class Marabout {

	private long id;

	private String name;

	private String title;

	private boolean guaranty;

	private int guarantyTimeframe;

	private int nbYearsExperience;

	private boolean onSite;

	private boolean onThePremise;

	private boolean remotePhone;

	private boolean remoteMail;

	private Set<Service> services;

	private Set<PhoneType> phone;

	private List<OpeningHours> weekOpeningHours;

	public int getGuarantyTimeframe() {
		return guarantyTimeframe;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNbYearsExperience() {
		return nbYearsExperience;
	}

	public Set<PhoneType> getPhone() {
		return phone;
	}

	public Set<Service> getServices() {
		return services;
	}

	public String getTitle() {
		return title;
	}

	public List<OpeningHours> getWeekOpeningHours() {
		return weekOpeningHours;
	}

	public boolean isGuaranty() {
		return guaranty;
	}

	public boolean isOnSite() {
		return onSite;
	}

	public boolean isOnThePremise() {
		return onThePremise;
	}

	public boolean isRemoteMail() {
		return remoteMail;
	}

	public boolean isRemotePhone() {
		return remotePhone;
	}

	public void setGuaranty(boolean guaranty) {
		this.guaranty = guaranty;
	}

	public void setGuarantyTimeframe(int guarantyTimeframe) {
		this.guarantyTimeframe = guarantyTimeframe;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNbYearsExperience(int nbYearsExperience) {
		this.nbYearsExperience = nbYearsExperience;
	}

	public void setOnSite(boolean onSite) {
		this.onSite = onSite;
	}

	public void setOnThePremise(boolean onThePremise) {
		this.onThePremise = onThePremise;
	}

	public void setPhone(Set<PhoneType> phone) {
		this.phone = phone;
	}

	public void setRemoteMail(boolean remoteMail) {
		this.remoteMail = remoteMail;
	}

	public void setRemotePhone(boolean remotePhone) {
		this.remotePhone = remotePhone;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWeekOpeningHours(List<OpeningHours> weekOpeningHours) {
		this.weekOpeningHours = weekOpeningHours;
	}

}
