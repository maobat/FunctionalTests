// ItemDetails.java

package dataobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"sku", "color", "size"})
public class ItemDetails {

    private String sku;
    private String color;
    private String size;

    public ItemDetails(String sku, String color, String size){
        this.sku = sku;
        this.color = color;
        this.size = size;
    }

    @JsonProperty("sku")
    public String getSku(){
        return sku;
    }

    @JsonProperty("color")
    public String getColor(){
        return color;
    }

    @JsonProperty("size")
    public String getSize(){
        return size;
    }

    @Test
    public void verifyPostItemsEndpointReturnsSuccessStatusCode(){

        ItemDetails greenShirt = new ItemDetails("98765490", "Green", "M");

        given().
                contentType(ContentType.JSON).
                body(greenShirt).
                log().body().
                when().
                post("http://localhost:1000/items").
                then().
                assertThat().
                statusCode(200);
    }
}