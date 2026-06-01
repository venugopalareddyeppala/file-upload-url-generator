<%@ page contentType="text/html;charset=UTF-8" %>

<%
String fileName =
(String) request.getAttribute("fileName");

String fileSize =
(String) request.getAttribute("fileSize");

String fileUrl =
(String) request.getAttribute("fileUrl");
%>

<!DOCTYPE html>
<html>
<head>

<title>Success</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="card">

    <div class="success">
        ✓
    </div>

    <h1>
        File Uploaded Successfully!
    </h1>

    <p>
        <strong>File:</strong>
        <%= fileName %>
    </p>

    <p>
        <strong>Size:</strong>
        <%= fileSize %>
    </p>

    <input
            type="text"
            id="fileUrl"
            value="<%= fileUrl %>"
            readonly>

    <button onclick="copyUrl()">
        Copy URL
    </button>

    <a href="index.jsp">
        Upload Another File
    </a>

</div>

<script>

function copyUrl() {

    let copyText =
        document.getElementById(
            "fileUrl"
        );

    copyText.select();

    navigator.clipboard.writeText(
        copyText.value
    );

    alert("URL Copied");
}

</script>

</body>
</html>