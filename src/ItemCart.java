import java.io.Serializable;

public class ItemCart implements Serializable {
    private String prodID;
    private String prodName;
    private String prodDesc;
    private Integer prodQuant;
    private Double prodPrice;
    private String prodPicLocation;

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getProdQuant() {
        return prodQuant;
    }

    public void setProdQuant(Integer prodQuant) {
        this.prodQuant = prodQuant;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdPicLocation() {
        return prodPicLocation;
    }

    public void setProdPicLocation(String prodPicLocation) {
        this.prodPicLocation = prodPicLocation;
    }


    public ItemCart(String prodID, String prodName, String prodDesc, Integer prodQuant, Double prodPrice, String prodPicLocation) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodQuant = prodQuant;
        this.prodPrice = prodPrice;
        this.prodPicLocation = prodPicLocation;
    }
}
