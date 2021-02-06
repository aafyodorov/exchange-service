
package tk.exchangeservice.dto.giphy;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "avatar_url",
    "banner_image",
    "banner_url",
    "profile_url",
    "username",
    "display_name",
    "description",
    "is_verified",
    "website_url",
    "instagram_url"
})
public class User {

    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("banner_image")
    private String bannerImage;
    @JsonProperty("banner_url")
    private String bannerUrl;
    @JsonProperty("profile_url")
    private String profileUrl;
    @JsonProperty("username")
    private String username;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("is_verified")
    private Boolean isVerified;
    @JsonProperty("website_url")
    private String websiteUrl;
    @JsonProperty("instagram_url")
    private String instagramUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("banner_image")
    public String getBannerImage() {
        return bannerImage;
    }

    @JsonProperty("banner_image")
    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    @JsonProperty("banner_url")
    public String getBannerUrl() {
        return bannerUrl;
    }

    @JsonProperty("banner_url")
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @JsonProperty("profile_url")
    public String getProfileUrl() {
        return profileUrl;
    }

    @JsonProperty("profile_url")
    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("is_verified")
    public Boolean getIsVerified() {
        return isVerified;
    }

    @JsonProperty("is_verified")
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    @JsonProperty("website_url")
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    @JsonProperty("website_url")
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @JsonProperty("instagram_url")
    public String getInstagramUrl() {
        return instagramUrl;
    }

    @JsonProperty("instagram_url")
    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
