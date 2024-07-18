package com.Avsoft.Model;

import java.time.LocalDate; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String batchId;
	private String name;
	private LocalDate expiryDate;
	private String manufacturers;
	private String saltComposition;
	private String introduction;
	private String benefits;
	private String description;
	private String howToUse;
	private String safetyAdvise;
	private String ifMiss;
	private String packaging;
	private Integer packages;
	private Integer quantity;
	private Integer stripSize;
	private Double mrp;
	private Boolean prescriptionRequired;
	private String label;
	private String factBox;
	private String primaryUse;
	private String storage;
	private String useOf;
	private String commonSideEffect;
	private String alcoholInteraction;
	private String pregnancyInteraction;
	private String lactationInteraction;
	private String drivingInteraction;
	private String kidneyInteraction;
	private String liverInteraction;
	private String manufacturerAddress;
	private String countryOfOrigin;

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
	}

	public String getSaltComposition() {
		return saltComposition;
	}

	public void setSaltComposition(String saltComposition) {
		this.saltComposition = saltComposition;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHowToUse() {
		return howToUse;
	}

	public void setHowToUse(String howToUse) {
		this.howToUse = howToUse;
	}

	public String getSafetyAdvise() {
		return safetyAdvise;
	}

	public void setSafetyAdvise(String safetyAdvise) {
		this.safetyAdvise = safetyAdvise;
	}

	public String getIfMiss() {
		return ifMiss;
	}

	public void setIfMiss(String ifMiss) {
		this.ifMiss = ifMiss;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public Integer getPackages() {
		return packages;
	}

	public void setPackages(Integer packages) {
		this.packages = packages;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getStripSize() {
		return stripSize;
	}

	public void setStripSize(Integer stripSize) {
		this.stripSize = stripSize;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Boolean getPrescriptionRequired() {
		return prescriptionRequired;
	}

	public void setPrescriptionRequired(Boolean prescriptionRequired) {
		this.prescriptionRequired = prescriptionRequired;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFactBox() {
		return factBox;
	}

	public void setFactBox(String factBox) {
		this.factBox = factBox;
	}

	public String getPrimaryUse() {
		return primaryUse;
	}

	public void setPrimaryUse(String primaryUse) {
		this.primaryUse = primaryUse;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getUseOf() {
		return useOf;
	}

	public void setUseOf(String useOf) {
		this.useOf = useOf;
	}

	public String getCommonSideEffect() {
		return commonSideEffect;
	}

	public void setCommonSideEffect(String commonSideEffect) {
		this.commonSideEffect = commonSideEffect;
	}

	public String getAlcoholInteraction() {
		return alcoholInteraction;
	}

	public void setAlcoholInteraction(String alcoholInteraction) {
		this.alcoholInteraction = alcoholInteraction;
	}

	public String getPregnancyInteraction() {
		return pregnancyInteraction;
	}

	public void setPregnancyInteraction(String pregnancyInteraction) {
		this.pregnancyInteraction = pregnancyInteraction;
	}

	public String getLactationInteraction() {
		return lactationInteraction;
	}

	public void setLactationInteraction(String lactationInteraction) {
		this.lactationInteraction = lactationInteraction;
	}

	public String getDrivingInteraction() {
		return drivingInteraction;
	}

	public void setDrivingInteraction(String drivingInteraction) {
		this.drivingInteraction = drivingInteraction;
	}

	public String getKidneyInteraction() {
		return kidneyInteraction;
	}

	public void setKidneyInteraction(String kidneyInteraction) {
		this.kidneyInteraction = kidneyInteraction;
	}

	public String getLiverInteraction() {
		return liverInteraction;
	}

	public void setLiverInteraction(String liverInteraction) {
		this.liverInteraction = liverInteraction;
	}

	public String getManufacturerAddress() {
		return manufacturerAddress;
	}

	public void setManufacturerAddress(String manufacturerAddress) {
		this.manufacturerAddress = manufacturerAddress;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

}