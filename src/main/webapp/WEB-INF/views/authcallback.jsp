<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth Sample</title>
    <h1>AuthCallback</h1>
    <script type="text/javascript">
        function callServlet(end_point, auth_code) {
            var serverdomain = "${serverdomain}";
            var callback = "tokencallback";
            document.location.href = serverdomain + end_point
                    + "?client_id=123"
            +"&auth_code=" + auth_code
            + "&callback=" + encodeURIComponent(serverdomain + callback);
        }
    </script>
</head>
<body>
<p>Receive Authcode<strong>: ${auth_code}</strong></p>
<div>
    <input type="button" id="accessToken" name="accessToken" value="Request accessToken"
           onclick="callServlet('auth/getaccesstoken','${auth_code}')">
</div>
</body>
</html>