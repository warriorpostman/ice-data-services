package org.lookice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "detainers", schema = "ice_data")
@Data
public class Detainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detainer_id")
    private Long detainerId;

    @Column(name = "detainer_prepare_date")
    private java.sql.Date detainerPrepareDate;

    @Column(name = "facility_state")
    private String facilityState;

    @Column(name = "facility_aor")
    private String facilityAor;

    @Column(name = "port_of_departure")
    private String portOfDeparture;

    @Column(name = "departure_country")
    private String departureCountry;

    @Column(name = "departed_date")
    private java.sql.Date departedDate;

    @Column(name = "case_status")
    private String caseStatus;

    @Column(name = "detainer_prepared_criminality")
    private String detainerPreparedCriminality;

    @Column(name = "detention_facility")
    private String detentionFacility;

    @Column(name = "detention_facility_code")
    private String detentionFacilityCode;

    @Column(name = "facility_city")
    private String facilityCity;

    @Column(name = "detainer_prep_threat_level")
    private String detainerPrepThreatLevel;

    @Column(name = "gender")
    private String gender;

    @Column(name = "citizenship_country")
    private String citizenshipCountry;

    @Column(name = "birth_country")
    private String birthCountry;

    @Column(name = "birth_date")
    private String birthDate; // varchar in DB

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "entry_status")
    private String entryStatus;

    @Column(name = "msc_charge")
    private String mscCharge;

    @Column(name = "msc_sentence_days")
    private Integer mscSentenceDays;

    @Column(name = "msc_sentence_months")
    private Integer mscSentenceMonths;

    @Column(name = "msc_sentence_years")
    private Integer mscSentenceYears;

    @Column(name = "msc_charge_code")
    private String mscChargeCode;

    @Column(name = "msc_charge_date")
    private java.sql.Date mscChargeDate;

    @Column(name = "msc_conviction_date")
    private java.sql.Date mscConvictionDate;

    @Column(name = "felon")
    private String felon;

    @Column(name = "processing_disposition")
    private String processingDisposition;

    @Column(name = "case_category")
    private String caseCategory;

    @Column(name = "final_program")
    private String finalProgram;

    @Column(name = "time_of_apprehension_case_category")
    private String timeOfApprehensionCaseCategory;

    @Column(name = "time_of_apprehension_current_program")
    private String timeOfApprehensionCurrentProgram;

    @Column(name = "apprehension_method")
    private String apprehensionMethod;

    @Column(name = "case_final_order_yes_no")
    private Boolean caseFinalOrderYesNo;

    @Column(name = "final_order_date")
    private java.sql.Date finalOrderDate;

    @Column(name = "apprehension_date")
    private java.sql.Date apprehensionDate;

    @Column(name = "entry_date")
    private java.sql.Date entryDate;

    @Column(name = "prior_felony_yes_no")
    private Boolean priorFelonyYesNo;

    @Column(name = "multiple_prior_misd_yes_no")
    private Boolean multiplePriorMisdYesNo;

    @Column(name = "violent_misdemeanor_yes_no")
    private Boolean violentMisdemeanorYesNo;

    @Column(name = "illegal_entry_yes_no")
    private Boolean illegalEntryYesNo;

    @Column(name = "illegal_reentry_yes_no")
    private Boolean illegalReentryYesNo;

    @Column(name = "immigration_fraud_yes_no")
    private Boolean immigrationFraudYesNo;

    @Column(name = "significant_risk_yes_no")
    private Boolean significantRiskYesNo;

    @Column(name = "other_removal_reason_yes_no")
    private Boolean otherRemovalReasonYesNo;

    @Column(name = "other_removal_reason")
    private String otherRemovalReason;

    @Column(name = "criminal_street_gang_yes_no")
    private Boolean criminalStreetGangYesNo;

    @Column(name = "aggravated_felony_yes_no")
    private Boolean aggravatedFelonyYesNo;

    @Column(name = "deportation_ordered_yes_no")
    private Boolean deportationOrderedYesNo;

    @Column(name = "order_to_show_cause_served_yes_no")
    private Boolean orderToShowCauseServedYesNo;

    @Column(name = "order_to_show_cause_served_date")
    private java.sql.Date orderToShowCauseServedDate;

    @Column(name = "biometric_match_yes_no")
    private Boolean biometricMatchYesNo;

    @Column(name = "statements_made_yes_no")
    private Boolean statementsMadeYesNo;

    @Column(name = "unlawful_attempt_yes_no")
    private Boolean unlawfulAttemptYesNo;

    @Column(name = "unlawful_entry_yes_no")
    private Boolean unlawfulEntryYesNo;

    @Column(name = "visa_yes_no")
    private Boolean visaYesNo;

    @Column(name = "final_order_yes_no")
    private Boolean finalOrderYesNo;

    @Column(name = "federal_interest_yes_no")
    private Boolean federalInterestYesNo;

    @Column(name = "resume_custody_yes_no")
    private Boolean resumeCustodyYesNo;

    @Column(name = "detainer_lift_reason")
    private String detainerLiftReason;

    @Column(name = "detainer_type")
    private String detainerType;

    @Column(name = "alien_file_number")
    private String alienFileNumber;

    @Column(name = "eid_case_id")
    private String eidCaseId;

    @Column(name = "eid_subject_id")
    private String eidSubjectId;

    @Column(name = "eid_dta_id")
    private String eidDtaId;

    @Column(name = "unique_identifier")
    private String uniqueIdentifier;

}
