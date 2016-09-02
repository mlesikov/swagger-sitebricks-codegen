package io.foo.bar;

import java.util.Objects;
import io.foo.bar.Category;
import io.foo.bar.Tag;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;





public class Pet   {
  @SerializedName("id")
  public final Long id;

  @SerializedName("category")
  public final Category category;

  @SerializedName("name")
  public final String name;

  @SerializedName("photoUrls")
  public final List<String> photoUrls;

  @SerializedName("tags")
  public final List<Tag> tags;

  /**
   * pet status in the store
   */
  public enum StatusEnum {
    @SerializedName("available")
    AVAILABLE("available"),
    
    @SerializedName("pending")
    PENDING("pending"),
    
    @SerializedName("sold")
    SOLD("sold");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
  }

  @SerializedName("status")
  public final StatusEnum status;


   private Pet() {
         id = null;
         category = null;
         name = null;
         photoUrls = new ArrayList<String>();
         tags = new ArrayList<Tag>();
         status = null;
   }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet pet = (Pet) o;
    return Objects.equals(id, pet.id) &&
        Objects.equals(category, pet.category) &&
        Objects.equals(name, pet.name) &&
        Objects.equals(photoUrls, pet.photoUrls) &&
        Objects.equals(tags, pet.tags) &&
        Objects.equals(status, pet.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, name, photoUrls, tags, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

