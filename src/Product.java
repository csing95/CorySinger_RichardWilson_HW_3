import java.io.Serializable;

public class Product implements Serializable {
    private int ProdID;
    private String ProdName;
    private String ProdDesc;
    private Double ProdPrice;
    private int ProdQuant;
    private String ProdPicLocation;

    public Product(int prodID, String prodName, String prodDesc, Double prodPrice, int prodQuant, String prodPicLocation) {
        ProdID = prodID;
        ProdName = prodName;
        ProdDesc = prodDesc;
        ProdPrice = prodPrice;
        ProdQuant = prodQuant;
        ProdPicLocation = prodPicLocation;
    }

    public Product() {
    }

    public int getProdID() {
        return ProdID;
    }

    public void setProdID(int prodID) {
        ProdID = prodID;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public String getProdDesc() {
        return ProdDesc;
    }

    public void setProdDesc(String prodDesc) {
        ProdDesc = prodDesc;
    }

    public Double getProdPrice() {
        return ProdPrice;
    }

    public void setProdPrice(Double prodPrice) {
        ProdPrice = prodPrice;
    }

    public int getProdQuant() {
        return ProdQuant;
    }

    public void setProdQuant(int prodQuant) {
        ProdQuant = prodQuant;
    }

    public String getProdPicLocation() {
        return ProdPicLocation;
    }

    public void setProdPicLocation(String prodPicLocation) {
        ProdPicLocation = prodPicLocation;
    }
}
