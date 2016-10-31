<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth Sample</title>
    <h1>Auth Server</h1>
    <h2>Request Permission</h2>
    <script type="text/javascript">
        function callServlet(end_point) {
            var serverdomain = "${serverdomain}";
            var callback = "authcallback";
            document.location.href = serverdomain + end_point
                    + "?client_id=123"
                    + "&granted=" + true
                    + "&logged=true&callback=" + encodeURIComponent(serverdomain + callback);
        }
    </script>
</head>
<body>
<p>Request permission from<strong>: tend.ag</strong>?</p>
<div>
    <input type="button" id="Accept" name="Accept" value="Accept"
           onclick="callServlet('/auth/getauthcode')">
</div>
</body>
</html>