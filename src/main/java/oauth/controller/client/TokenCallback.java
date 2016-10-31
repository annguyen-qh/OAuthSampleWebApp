package oauth.controller.client;

import oauth.utils.Constants;
import oauth.utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class OAuth2Client
 */
public class TokenCallback extends HttpServlet {

    public TokenCallback() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Print out Access token
        String authCode = Utils.getParameter(request, Constants.ACCESS_TOKEN, "");
        request.setAttribute(Constants.ACCESS_TOKEN, authCode);
        RequestDispatcher rd = request.getRequestDispatcher(Constants.ATCALLBACK_TPL);
        rd.forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
