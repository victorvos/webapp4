<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Dynamic Example</title>
</head>
<body>
<div id="messagebox">
    <%
        Object msgs = request.getAttribute("msgs");
        Object client = request.getAttribute("client");

        if (msgs != null) {
            out.println(msgs);
            out.println(client);
        }
    %>
</div>
</body>
</html>