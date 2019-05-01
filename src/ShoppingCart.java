
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemCart> theCart;

    public ShoppingCart() {
        theCart = new ArrayList<>();
    }

    public ArrayList<ItemCart> getTheCart() {
        return theCart;
    }

    public int getItemsInCart(){
        return theCart.size();
    }

    public void setTheCart(ArrayList<ItemCart> theCart) {
        this.theCart = theCart;
    }

    public void AddToCart(ItemCart newProd){
        String newProdId = newProd.getProdID();
        int newProdNo = newProd.getProdQuant();

        for(int i=0; i< theCart.size(); i ++){
            ItemCart ic = theCart.get(i);
            if(ic.getProdID().equals(newProdId)){
                System.out.println("Before: " + ic.getProdQuant());
                //ic.setProdQuant(ic.getProdQuant() + newProdNo);
                ic.setProdQuant(ic.getProdQuant() + 1);
                ProductDB.updateQuantity(newProdId, ic.getProdQuant());
                System.out.println("=============================================================================");
                System.out.println("Add to cart test");
                System.out.println("else if test: ic.getProdQuant() = " + ic.getProdQuant());
                System.out.println("else if test: newProdNo = " + newProdNo);
                System.out.println("=============================================================================");
                return;
            }
        }
        theCart.add(newProd);
    }


    public void RemoveFromCart(ItemCart theProd){
        theCart.remove(theProd);
    }


    public void RemoveFromCart(String prid, int prquant) {
        String prodId = prid;
        int prodQuant = prquant;

        for (int i = 0; i < theCart.size(); i++) {
            ItemCart ic = theCart.get(i);

            if (ic.getProdID().equals(prodId)) {
                if (prodQuant <= 0) {
                    theCart.remove(i);
                    ProductDB.updateQuantity(prid, 1);
                } else if (prodQuant < ic.getProdQuant()) {
                    //int newQuant = ic.getProdQuant() - prodQuant;
                    int newQuant = prodQuant;
                    System.out.println("=============================================================================");
                    System.out.println("else if test: ic.getProdQuant() = " + ic.getProdQuant());
                    System.out.println("else if test: ProdQuant = " + prodQuant);
                    System.out.println(newQuant);
                    System.out.println("=============================================================================");
                    ic.setProdQuant(newQuant);
                    //do a call for an update and pass in newQuant
                    ProductDB.updateQuantity(prid, newQuant);

                } else {
                    ic.setProdQuant(prodQuant);
                    //do a call for an update and pass in newQuant
                    ProductDB.updateQuantity(prid, prquant);
                    System.out.println(prid+"//"+prquant);
                }
                return;
            }

        }
    }




}