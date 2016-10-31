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
public class AuthCallback extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AuthCallback() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Print out Auth token
        String authCode = Utils.getParameter(request, Constants.AUTHCODE, "");
        request.setAttribute(Constants.AUTHCODE, authCode);
        request.setAttribute("serverdomain", Constants.SERVER_DOMAIN);
        RequestDispatcher rd = request.getRequestDispatcher(Constants.AUTHCALLBACK_TPL);
        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
