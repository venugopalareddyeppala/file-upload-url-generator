package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 524288000L,
        maxRequestSize = 524288000L
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Part filePart = request.getPart("file");

        String fileName =
                Paths.get(filePart.getSubmittedFileName())
                        .getFileName()
                        .toString();

        String uploadDir =
                getServletContext().getRealPath("")
                        + File.separator
                        + "uploads";

        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        filePart.write(
                uploadDir
                        + File.separator
                        + fileName
        );

        String fileUrl =
                request.getScheme()
                        + "://"
                        + request.getServerName()
                        + ":"
                        + request.getServerPort()
                        + request.getContextPath()
                        + "/uploads/"
                        + fileName;

        request.setAttribute(
                "fileName",
                fileName
        );

        request.setAttribute(
                "fileSize",
                String.format(
                        "%.2f MB",
                        filePart.getSize()
                                / 1024.0
                                / 1024.0
                )
        );

        request.setAttribute(
                "fileUrl",
                fileUrl
        );

        request
                .getRequestDispatcher(
                        "success.jsp"
                )
                .forward(
                        request,
                        response
                );
    }
}