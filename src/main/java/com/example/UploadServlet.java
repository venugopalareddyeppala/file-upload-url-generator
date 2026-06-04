package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

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
                          HttpServletResponse response) {

        try {

            Part filePart = request.getPart("file");

            if (filePart == null ||
                filePart.getSubmittedFileName() == null ||
                filePart.getSubmittedFileName().isBlank()) {

                response.sendError(
                        HttpServletResponse.SC_BAD_REQUEST,
                        "No file selected"
                );
                return;
            }

            String fileName = Paths.get(
                    filePart.getSubmittedFileName())
                    .getFileName()
                    .toString()
                    .replaceAll("[^a-zA-Z0-9._-]", "_");

            String uploadDir =
                    getServletContext().getRealPath("")
                            + File.separator
                            + "uploads";

            File dir = new File(uploadDir);

            if (!dir.exists() && !dir.mkdirs()) {
                throw new IOException(
                        "Unable to create upload directory"
                );
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

            request.getRequestDispatcher("success.jsp")
                    .forward(request, response);

        } catch (ServletException e) {

            log("Servlet error during upload", e);

            try {
                response.sendError(
                        HttpServletResponse.SC_BAD_REQUEST,
                        "Invalid upload request"
                );
            } catch (IOException ignored) {
                log("Failed to send error response", ignored);
            }

        } catch (IOException e) {

            log("File upload failed", e);

            try {
                response.sendError(
                        HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        "File upload failed"
                );
            } catch (IOException ignored) {
                log("Failed to send error response", ignored);
            }
        }
    }
}
