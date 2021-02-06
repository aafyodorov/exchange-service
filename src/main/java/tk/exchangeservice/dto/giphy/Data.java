
package tk.exchangeservice.dto.giphy;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "url",
    "slug",
    "bitly_gif_url",
    "bitly_url",
    "embed_url",
    "username",
    "source",
    "title",
    "rating",
    "content_url",
    "source_tld",
    "source_post_url",
    "is_sticker",
    "import_datetime",
    "trending_datetime",
    "images",
    "user",
    "image_original_url",
    "image_url",
    "image_mp4_url",
    "image_frames",
    "image_width",
    "image_height",
    "fixed_height_downsampled_url",
    "fixed_height_downsampled_width",
    "fixed_height_downsampled_height",
    "fixed_width_downsampled_url",
    "fixed_width_downsampled_width",
    "fixed_width_downsampled_height",
    "fixed_height_small_url",
    "fixed_height_small_still_url",
    "fixed_height_small_width",
    "fixed_height_small_height",
    "fixed_width_small_url",
    "fixed_width_small_still_url",
    "fixed_width_small_width",
    "fixed_width_small_height",
    "caption"
})
public class Data {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("bitly_gif_url")
    private String bitlyGifUrl;
    @JsonProperty("bitly_url")
    private String bitlyUrl;
    @JsonProperty("embed_url")
    private String embedUrl;
    @JsonProperty("username")
    private String username;
    @JsonProperty("source")
    private String source;
    @JsonProperty("title")
    private String title;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("content_url")
    private String contentUrl;
    @JsonProperty("source_tld")
    private String sourceTld;
    @JsonProperty("source_post_url")
    private String sourcePostUrl;
    @JsonProperty("is_sticker")
    private Integer isSticker;
    @JsonProperty("import_datetime")
    private String importDatetime;
    @JsonProperty("trending_datetime")
    private String trendingDatetime;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("user")
    private User user;
    @JsonProperty("image_original_url")
    private String imageOriginalUrl;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("image_mp4_url")
    private String imageMp4Url;
    @JsonProperty("image_frames")
    private String imageFrames;
    @JsonProperty("image_width")
    private String imageWidth;
    @JsonProperty("image_height")
    private String imageHeight;
    @JsonProperty("fixed_height_downsampled_url")
    private String fixedHeightDownsampledUrl;
    @JsonProperty("fixed_height_downsampled_width")
    private String fixedHeightDownsampledWidth;
    @JsonProperty("fixed_height_downsampled_height")
    private String fixedHeightDownsampledHeight;
    @JsonProperty("fixed_width_downsampled_url")
    private String fixedWidthDownsampledUrl;
    @JsonProperty("fixed_width_downsampled_width")
    private String fixedWidthDownsampledWidth;
    @JsonProperty("fixed_width_downsampled_height")
    private String fixedWidthDownsampledHeight;
    @JsonProperty("fixed_height_small_url")
    private String fixedHeightSmallUrl;
    @JsonProperty("fixed_height_small_still_url")
    private String fixedHeightSmallStillUrl;
    @JsonProperty("fixed_height_small_width")
    private String fixedHeightSmallWidth;
    @JsonProperty("fixed_height_small_height")
    private String fixedHeightSmallHeight;
    @JsonProperty("fixed_width_small_url")
    private String fixedWidthSmallUrl;
    @JsonProperty("fixed_width_small_still_url")
    private String fixedWidthSmallStillUrl;
    @JsonProperty("fixed_width_small_width")
    private String fixedWidthSmallWidth;
    @JsonProperty("fixed_width_small_height")
    private String fixedWidthSmallHeight;
    @JsonProperty("caption")
    private String caption;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("bitly_gif_url")
    public String getBitlyGifUrl() {
        return bitlyGifUrl;
    }

    @JsonProperty("bitly_gif_url")
    public void setBitlyGifUrl(String bitlyGifUrl) {
        this.bitlyGifUrl = bitlyGifUrl;
    }

    @JsonProperty("bitly_url")
    public String getBitlyUrl() {
        return bitlyUrl;
    }

    @JsonProperty("bitly_url")
    public void setBitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
    }

    @JsonProperty("embed_url")
    public String getEmbedUrl() {
        return embedUrl;
    }

    @JsonProperty("embed_url")
    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("content_url")
    public String getContentUrl() {
        return contentUrl;
    }

    @JsonProperty("content_url")
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @JsonProperty("source_tld")
    public String getSourceTld() {
        return sourceTld;
    }

    @JsonProperty("source_tld")
    public void setSourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
    }

    @JsonProperty("source_post_url")
    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    @JsonProperty("source_post_url")
    public void setSourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
    }

    @JsonProperty("is_sticker")
    public Integer getIsSticker() {
        return isSticker;
    }

    @JsonProperty("is_sticker")
    public void setIsSticker(Integer isSticker) {
        this.isSticker = isSticker;
    }

    @JsonProperty("import_datetime")
    public String getImportDatetime() {
        return importDatetime;
    }

    @JsonProperty("import_datetime")
    public void setImportDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
    }

    @JsonProperty("trending_datetime")
    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    @JsonProperty("trending_datetime")
    public void setTrendingDatetime(String trendingDatetime) {
        this.trendingDatetime = trendingDatetime;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @Autowired
    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("image_original_url")
    public String getImageOriginalUrl() {
        return imageOriginalUrl;
    }

    @JsonProperty("image_original_url")
    public void setImageOriginalUrl(String imageOriginalUrl) {
        this.imageOriginalUrl = imageOriginalUrl;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("image_mp4_url")
    public String getImageMp4Url() {
        return imageMp4Url;
    }

    @JsonProperty("image_mp4_url")
    public void setImageMp4Url(String imageMp4Url) {
        this.imageMp4Url = imageMp4Url;
    }

    @JsonProperty("image_frames")
    public String getImageFrames() {
        return imageFrames;
    }

    @JsonProperty("image_frames")
    public void setImageFrames(String imageFrames) {
        this.imageFrames = imageFrames;
    }

    @JsonProperty("image_width")
    public String getImageWidth() {
        return imageWidth;
    }

    @JsonProperty("image_width")
    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    @JsonProperty("image_height")
    public String getImageHeight() {
        return imageHeight;
    }

    @JsonProperty("image_height")
    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    @JsonProperty("fixed_height_downsampled_url")
    public String getFixedHeightDownsampledUrl() {
        return fixedHeightDownsampledUrl;
    }

    @JsonProperty("fixed_height_downsampled_url")
    public void setFixedHeightDownsampledUrl(String fixedHeightDownsampledUrl) {
        this.fixedHeightDownsampledUrl = fixedHeightDownsampledUrl;
    }

    @JsonProperty("fixed_height_downsampled_width")
    public String getFixedHeightDownsampledWidth() {
        return fixedHeightDownsampledWidth;
    }

    @JsonProperty("fixed_height_downsampled_width")
    public void setFixedHeightDownsampledWidth(String fixedHeightDownsampledWidth) {
        this.fixedHeightDownsampledWidth = fixedHeightDownsampledWidth;
    }

    @JsonProperty("fixed_height_downsampled_height")
    public String getFixedHeightDownsampledHeight() {
        return fixedHeightDownsampledHeight;
    }

    @JsonProperty("fixed_height_downsampled_height")
    public void setFixedHeightDownsampledHeight(String fixedHeightDownsampledHeight) {
        this.fixedHeightDownsampledHeight = fixedHeightDownsampledHeight;
    }

    @JsonProperty("fixed_width_downsampled_url")
    public String getFixedWidthDownsampledUrl() {
        return fixedWidthDownsampledUrl;
    }

    @JsonProperty("fixed_width_downsampled_url")
    public void setFixedWidthDownsampledUrl(String fixedWidthDownsampledUrl) {
        this.fixedWidthDownsampledUrl = fixedWidthDownsampledUrl;
    }

    @JsonProperty("fixed_width_downsampled_width")
    public String getFixedWidthDownsampledWidth() {
        return fixedWidthDownsampledWidth;
    }

    @JsonProperty("fixed_width_downsampled_width")
    public void setFixedWidthDownsampledWidth(String fixedWidthDownsampledWidth) {
        this.fixedWidthDownsampledWidth = fixedWidthDownsampledWidth;
    }

    @JsonProperty("fixed_width_downsampled_height")
    public String getFixedWidthDownsampledHeight() {
        return fixedWidthDownsampledHeight;
    }

    @JsonProperty("fixed_width_downsampled_height")
    public void setFixedWidthDownsampledHeight(String fixedWidthDownsampledHeight) {
        this.fixedWidthDownsampledHeight = fixedWidthDownsampledHeight;
    }

    @JsonProperty("fixed_height_small_url")
    public String getFixedHeightSmallUrl() {
        return fixedHeightSmallUrl;
    }

    @JsonProperty("fixed_height_small_url")
    public void setFixedHeightSmallUrl(String fixedHeightSmallUrl) {
        this.fixedHeightSmallUrl = fixedHeightSmallUrl;
    }

    @JsonProperty("fixed_height_small_still_url")
    public String getFixedHeightSmallStillUrl() {
        return fixedHeightSmallStillUrl;
    }

    @JsonProperty("fixed_height_small_still_url")
    public void setFixedHeightSmallStillUrl(String fixedHeightSmallStillUrl) {
        this.fixedHeightSmallStillUrl = fixedHeightSmallStillUrl;
    }

    @JsonProperty("fixed_height_small_width")
    public String getFixedHeightSmallWidth() {
        return fixedHeightSmallWidth;
    }

    @JsonProperty("fixed_height_small_width")
    public void setFixedHeightSmallWidth(String fixedHeightSmallWidth) {
        this.fixedHeightSmallWidth = fixedHeightSmallWidth;
    }

    @JsonProperty("fixed_height_small_height")
    public String getFixedHeightSmallHeight() {
        return fixedHeightSmallHeight;
    }

    @JsonProperty("fixed_height_small_height")
    public void setFixedHeightSmallHeight(String fixedHeightSmallHeight) {
        this.fixedHeightSmallHeight = fixedHeightSmallHeight;
    }

    @JsonProperty("fixed_width_small_url")
    public String getFixedWidthSmallUrl() {
        return fixedWidthSmallUrl;
    }

    @JsonProperty("fixed_width_small_url")
    public void setFixedWidthSmallUrl(String fixedWidthSmallUrl) {
        this.fixedWidthSmallUrl = fixedWidthSmallUrl;
    }

    @JsonProperty("fixed_width_small_still_url")
    public String getFixedWidthSmallStillUrl() {
        return fixedWidthSmallStillUrl;
    }

    @JsonProperty("fixed_width_small_still_url")
    public void setFixedWidthSmallStillUrl(String fixedWidthSmallStillUrl) {
        this.fixedWidthSmallStillUrl = fixedWidthSmallStillUrl;
    }

    @JsonProperty("fixed_width_small_width")
    public String getFixedWidthSmallWidth() {
        return fixedWidthSmallWidth;
    }

    @JsonProperty("fixed_width_small_width")
    public void setFixedWidthSmallWidth(String fixedWidthSmallWidth) {
        this.fixedWidthSmallWidth = fixedWidthSmallWidth;
    }

    @JsonProperty("fixed_width_small_height")
    public String getFixedWidthSmallHeight() {
        return fixedWidthSmallHeight;
    }

    @JsonProperty("fixed_width_small_height")
    public void setFixedWidthSmallHeight(String fixedWidthSmallHeight) {
        this.fixedWidthSmallHeight = fixedWidthSmallHeight;
    }

    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
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
