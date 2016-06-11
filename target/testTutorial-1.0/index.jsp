<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        @import url("css/font-awesome.min.css");
        @import url("css/style.css");

        @import url("css/index.css");
        @import url("css/fab.css");

        @import url("css/agenda.css");
        @import url("css/settings.css");
    </style>
    <script src="jquery.min.js">
        $("input").keypress(function () {
            console.log("hey");
            tmpval = $(this).val();
            if (tmpval == "") {
                $(this).addClass("red");
            } else {
                $(this).removeClass("red");
            }
        });
    </script>
</head>
<body>

<%@include file="/header.jsp" %>

<%@include file="/info.jsp"%>

<%@include file="/fab.jsp"%>

<%@include file="/agenda.jsp"%>

<%@include file="/register.jsp"%>

<%@include file="/settings.jsp"%>

<%@include file="/indi.jsp" %>

</body>
</html>
