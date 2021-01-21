
package com.example.types;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * An address similar to http://microformats.org/wiki/h-card
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "post-office-box",
    "extended-address",
    "street-address",
    "locality",
    "region",
    "postal-code",
    "country-name"
})
public class AddressSchema {

    @JsonProperty("post-office-box")
    private String postOfficeBox;
    @JsonProperty("extended-address")
    private String extendedAddress;
    @JsonProperty("street-address")
    private String streetAddress;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("locality")
    private String locality;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("region")
    private String region;
    @JsonProperty("postal-code")
    private String postalCode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("country-name")
    private String countryName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("post-office-box")
    public String getPostOfficeBox() {
        return postOfficeBox;
    }

    @JsonProperty("post-office-box")
    public void setPostOfficeBox(String postOfficeBox) {
        this.postOfficeBox = postOfficeBox;
    }

    @JsonProperty("extended-address")
    public String getExtendedAddress() {
        return extendedAddress;
    }

    @JsonProperty("extended-address")
    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    @JsonProperty("street-address")
    public String getStreetAddress() {
        return streetAddress;
    }

    @JsonProperty("street-address")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("postal-code")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postal-code")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("country-name")
    public String getCountryName() {
        return countryName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("country-name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddressSchema.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("postOfficeBox");
        sb.append('=');
        sb.append(((this.postOfficeBox == null)?"<null>":this.postOfficeBox));
        sb.append(',');
        sb.append("extendedAddress");
        sb.append('=');
        sb.append(((this.extendedAddress == null)?"<null>":this.extendedAddress));
        sb.append(',');
        sb.append("streetAddress");
        sb.append('=');
        sb.append(((this.streetAddress == null)?"<null>":this.streetAddress));
        sb.append(',');
        sb.append("locality");
        sb.append('=');
        sb.append(((this.locality == null)?"<null>":this.locality));
        sb.append(',');
        sb.append("region");
        sb.append('=');
        sb.append(((this.region == null)?"<null>":this.region));
        sb.append(',');
        sb.append("postalCode");
        sb.append('=');
        sb.append(((this.postalCode == null)?"<null>":this.postalCode));
        sb.append(',');
        sb.append("countryName");
        sb.append('=');
        sb.append(((this.countryName == null)?"<null>":this.countryName));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.postOfficeBox == null)? 0 :this.postOfficeBox.hashCode()));
        result = ((result* 31)+((this.streetAddress == null)? 0 :this.streetAddress.hashCode()));
        result = ((result* 31)+((this.postalCode == null)? 0 :this.postalCode.hashCode()));
        result = ((result* 31)+((this.locality == null)? 0 :this.locality.hashCode()));
        result = ((result* 31)+((this.countryName == null)? 0 :this.countryName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.extendedAddress == null)? 0 :this.extendedAddress.hashCode()));
        result = ((result* 31)+((this.region == null)? 0 :this.region.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressSchema) == false) {
            return false;
        }
        AddressSchema rhs = ((AddressSchema) other);
        return (((((((((this.postOfficeBox == rhs.postOfficeBox)||((this.postOfficeBox!= null)&&this.postOfficeBox.equals(rhs.postOfficeBox)))&&((this.streetAddress == rhs.streetAddress)||((this.streetAddress!= null)&&this.streetAddress.equals(rhs.streetAddress))))&&((this.postalCode == rhs.postalCode)||((this.postalCode!= null)&&this.postalCode.equals(rhs.postalCode))))&&((this.locality == rhs.locality)||((this.locality!= null)&&this.locality.equals(rhs.locality))))&&((this.countryName == rhs.countryName)||((this.countryName!= null)&&this.countryName.equals(rhs.countryName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.extendedAddress == rhs.extendedAddress)||((this.extendedAddress!= null)&&this.extendedAddress.equals(rhs.extendedAddress))))&&((this.region == rhs.region)||((this.region!= null)&&this.region.equals(rhs.region))));
    }

}
