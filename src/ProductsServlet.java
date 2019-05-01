import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProductsServlet")
public class ProductsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url ="/index.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ShoppingCart theCart = (ShoppingCart) session.getAttribute("aCart");

        if(theCart == null){
            theCart = new ShoppingCart();
        }

        if(action == null){
            url="/index.jsp";
        }else if(action.equals("add")){
            String prodID = request.getParameter("prodid");
            String prodName = request.getParameter("prodname");
            String prodDesc = request.getParameter("proddesc");
            Integer prodQuant = Integer.parseInt(request.getParameter("prodquanth"));
            Double prodPrice = Double.parseDouble(request.getParameter("prodpriceh"));
            String prodPicLocation = request.getParameter("prodpich");

            System.out.println(prodID+"//"+prodName+"//"+prodDesc+"//"+prodQuant+"//"+prodPrice+"//"+prodPicLocation);

            ItemCart newItem = new ItemCart(prodID,prodName,prodDesc,prodQuant,prodPrice,prodPicLocation);
            theCart.AddToCart(newItem);
            session.setAttribute("aCart", theCart);
            //add call to update
            url = "/cart.jsp";

        }else if(action.equals("update")){
            String prodID = request.getParameter("prodID");
            Integer prodQuant = Integer.parseInt(request.getParameter("prodQuant"));

            theCart.RemoveFromCart(prodID, prodQuant);

            session.setAttribute("aCart", theCart);
            url = "/cart.jsp";

        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
