package oauth.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by annguyen on 10/31/16.
 */
public class Utils {
    public static boolean validAuthCode(HttpServletRequest request) {
        String authCode = Utils.getParameter(request, Constants.AUTHCODE, "");
        return !authCode.isEmpty();

    }
    public static boolean validClientID(HttpServletRequest request) {
        String clientID = Utils.getParameter(request, Constants.CLIENT_ID, "");
        return !clientID.isEmpty();

    }
    public static boolean isLogged(HttpServletRequest request) {
        String logged = Utils.getParameter(request, "logged", "false");
        return  Boolean.valueOf(logged);

    }
    public static boolean isGrantedPermission(HttpServletRequest request) {
        String granted = Utils.getParameter(request, "granted", "false");
        return  Boolean.valueOf(granted);

    }

    public static String getParameter(HttpServletRequest request, String paramName, String defaultValue) {
        String value = request.getParameter(paramName);
        if (value != null)
            return value;
        return defaultValue;
    }
}
