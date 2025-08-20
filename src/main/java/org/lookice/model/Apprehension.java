package org.lookice.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "apprehensions")
public class Apprehension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arrest_id")
    private Integer arrestId;

    @Column(name = "apprehension_date")
    private LocalDateTime apprehensionDate;

    @Column(name = "apprehension_state")
    private String apprehensionState;

    @Column(name = "apprehension_county")
    private String apprehensionCounty;

    @Column(name = "apprehension_method")
    private String apprehensionMethod;

    @Column(name = "gender")
    private String gender;

    @Column(name = "citizenship_country")
    private String citizenshipCountry;

    @Column(name = "apprehension_criminality")
    private String apprehensionCriminality;

    @Column(name = "unique_identifier")
    private String uniqueIdentifier;

    // --- Getters and Setters ---
    public Integer getArrestId() {
        return arrestId;
    }

    public void setArrestId(Integer arrestId) {
        this.arrestId = arrestId;
    }

    public LocalDateTime getApprehensionDate() {
        return apprehensionDate;
    }

    public void setApprehensionDate(LocalDateTime apprehensionDate) {
        this.apprehensionDate = apprehensionDate;
    }

    public String getApprehensionState() {
        return apprehensionState;
    }

    public void setApprehensionState(String apprehensionState) {
        this.apprehensionState = apprehensionState;
    }

    public String getApprehensionCounty() {
        return apprehensionCounty;
    }

    public void setApprehensionCounty(String apprehensionCounty) {
        this.apprehensionCounty = apprehensionCounty;
    }

    public String getApprehensionMethod() {
        return apprehensionMethod;
    }

    public void setApprehensionMethod(String apprehensionMethod) {
        this.apprehensionMethod = apprehensionMethod;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenshipCountry() {
        return citizenshipCountry;
    }

    public void setCitizenshipCountry(String citizenshipCountry) {
        this.citizenshipCountry = citizenshipCountry;
    }

    public String getApprehensionCriminality() {
        return apprehensionCriminality;
    }

    public void setApprehensionCriminality(String apprehensionCriminality) {
        this.apprehensionCriminality = apprehensionCriminality;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
