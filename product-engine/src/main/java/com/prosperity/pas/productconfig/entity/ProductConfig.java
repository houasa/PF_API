package com.prosperity.pas.productconfig.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** JPA entity for product_config.product_config (generated from the contract data model ERD). */
@Entity
@Table(schema = "product_config", name = "product_config")
public class ProductConfig {

    @Id
    @Column(name = "config_version")
    private String configVersion;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "rates_caps_participation")
    private String ratesCapsParticipation;

    @Column(name = "index_account_catalog")
    private String indexAccountCatalog;

    @Column(name = "preset_models")
    private String presetModels;

    @Column(name = "withdrawal_charge_schedules")
    private String withdrawalChargeSchedules;

    @Column(name = "bonus_rates")
    private String bonusRates;

    @Column(name = "glwb_option_catalog")
    private String glwbOptionCatalog;

    @Column(name = "eligibility_rules")
    private String eligibilityRules;

    public ProductConfig() {
    }

    public String getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(String configVersion) {
        this.configVersion = configVersion;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRatesCapsParticipation() {
        return ratesCapsParticipation;
    }

    public void setRatesCapsParticipation(String ratesCapsParticipation) {
        this.ratesCapsParticipation = ratesCapsParticipation;
    }

    public String getIndexAccountCatalog() {
        return indexAccountCatalog;
    }

    public void setIndexAccountCatalog(String indexAccountCatalog) {
        this.indexAccountCatalog = indexAccountCatalog;
    }

    public String getPresetModels() {
        return presetModels;
    }

    public void setPresetModels(String presetModels) {
        this.presetModels = presetModels;
    }

    public String getWithdrawalChargeSchedules() {
        return withdrawalChargeSchedules;
    }

    public void setWithdrawalChargeSchedules(String withdrawalChargeSchedules) {
        this.withdrawalChargeSchedules = withdrawalChargeSchedules;
    }

    public String getBonusRates() {
        return bonusRates;
    }

    public void setBonusRates(String bonusRates) {
        this.bonusRates = bonusRates;
    }

    public String getGlwbOptionCatalog() {
        return glwbOptionCatalog;
    }

    public void setGlwbOptionCatalog(String glwbOptionCatalog) {
        this.glwbOptionCatalog = glwbOptionCatalog;
    }

    public String getEligibilityRules() {
        return eligibilityRules;
    }

    public void setEligibilityRules(String eligibilityRules) {
        this.eligibilityRules = eligibilityRules;
    }

}
