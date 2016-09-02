package io.foo.bar;

import java.util.Objects;
import org.joda.time.DateTime;
import com.google.gson.annotations.SerializedName;





public class Order   {
  @SerializedName("id")
  public final Long id;

  @SerializedName("petId")
  public final Long petId;

  @SerializedName("quantity")
  public final Integer quantity;

  @SerializedName("shipDate")
  public final DateTime shipDate;

  /**
   * Order Status
   */
  public enum StatusEnum {
    @SerializedName("placed")
    PLACED("placed"),
    
    @SerializedName("approved")
    APPROVED("approved"),
    
    @SerializedName("delivered")
    DELIVERED("delivered");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
  }

  @SerializedName("status")
  public final StatusEnum status;

  @SerializedName("complete")
  public final Boolean complete;


   private Order() {
         id = null;
         petId = null;
         quantity = null;
         shipDate = null;
         status = null;
         complete = false;
   }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(id, order.id) &&
        Objects.equals(petId, order.petId) &&
        Objects.equals(quantity, order.quantity) &&
        Objects.equals(shipDate, order.shipDate) &&
        Objects.equals(status, order.status) &&
        Objects.equals(complete, order.complete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, petId, quantity, shipDate, status, complete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    petId: ").append(toIndentedString(petId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    shipDate: ").append(toIndentedString(shipDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
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

