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
public class AuthController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AuthController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String callbackURL = request.getParameter(Constants.CALLBACK);
        try {
            // valid clientID
            boolean isclientIDValid = Utils.validClientID(request);
            if (!isclientIDValid) {
                response.sendRedirect(String.format("%s?%s=%s", callbackURL, "msg", "invalid ClientID"));
            }

            // check if user logged
            boolean isLogged = Utils.isLogged(request);
            if (!isLogged) { //redirect to login page
                response.sendRedirect("https://dev.retailkit.com/login.html?redirect=http%3A%2F%2Flocalhost%3A8080%2Fauth%2Fgetauthcode%3Fclient_id%3Dtrue%26logged%3Dtrue%26callback%3Dhttp%253A%252F%252Flocalhost%253A8080%252Fauthcallback");
                return;
            }

            // check if user granted permission
            boolean isGranted = Utils.isGrantedPermission(request);
            if (!isGranted) { //redirect to Permission page
                response.sendRedirect(Constants.SERVER_DOMAIN + "auth/permission");
                return;
            }

            // Generate Access token
            String authCode = "auth_123";
            response.sendRedirect(String.format("%s?%s=%s", callbackURL, Constants.AUTHCODE, authCode));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
