<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>File URL Generator</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="card">

    <h1>Upload Your File</h1>

    <p>
        Upload files up to 500 MB
    </p>

    <form
            action="upload"
            method="post"
            enctype="multipart/form-data">

        <input
                type="file"
                name="file"
                required>

        <button type="submit">
            Upload File
        </button>

    </form>

</div>

</body>
</html>