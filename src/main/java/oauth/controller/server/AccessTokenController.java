package oauth.controller.server;

import oauth.utils.Constants;
import oauth.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class OAuth2Client
 */
public class AccessTokenController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AccessTokenController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String callbackURL = Utils.getParameter(request, Constants.CALLBACK, "");

        // valid clientID
        boolean isclientIDValid = Utils.validClientID(request);
        if (!isclientIDValid) {
            response.sendRedirect(String.format("%s?%s=%s", callbackURL, "msg", "invalid ClientID"));
            return;
        }

        // valid authCode
        boolean isauthCodeValid = Utils.validAuthCode(request);
        if (!isauthCodeValid) {
            response.sendRedirect(String.format("%s?%s=%s", callbackURL, "msg", "invalid AuthCode"));
            return;
        }

        // Generate Access token
        String accessToken = "at_123";
        response.sendRedirect(String.format("%s?%s=%s", callbackURL, Constants.ACCESS_TOKEN, accessToken));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
