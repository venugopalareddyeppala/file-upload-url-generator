# 🚀 File Upload URL Generator

A modern Java web application built using **Java 17, Maven, JSP, Servlets, Apache Tomcat, and GitHub Actions** that allows users to upload files and instantly generate shareable URLs.

---

## 📋 Features

* 📂 Upload files up to **500 MB**
* 🔗 Generate shareable file URLs
* 📄 Display uploaded file details
* 📋 Copy URL with one click
* 🎨 Modern responsive UI
* ⚡ JSP & Servlet based architecture
* 📦 Maven build automation
* 🚀 GitHub Actions CI/CD pipeline
* 🌍 Multi-environment deployment

  * DEV
  * TEST
  * PREPROD
  * PROD
* 🖥️ Apache Tomcat deployment

---

## 🛠️ Technology Stack

| Technology     | Version           |
| -------------- | ----------------- |
| Java           | 17                |
| Maven          | 3.x               |
| JSP            | Jakarta EE        |
| Servlet API    | Jakarta Servlet 6 |
| Apache Tomcat  | 10.x              |
| GitHub Actions | Latest            |
| HTML5          | Latest            |
| CSS3           | Latest            |

---

## 📁 Project Structure

```text
file-upload-url-generator
│
├── pom.xml
├── README.md
│
├── .github
│   └── workflows
│       └── deploy.yml
│
└── src
    └── main
        ├── java
        │   └── com/example
        │       └── UploadServlet.java
        │
        ├── resources
        │
        └── webapp
            ├── index.jsp
            ├── success.jsp
            │
            ├── css
            │   └── style.css
            │
            ├── uploads
            │   └── .gitkeep
            │
            └── WEB-INF
                └── web.xml
```

---

## ⚙️ Build Project

### Clone Repository

```bash
git clone https://github.com/<your-org>/file-upload-url-generator.git
```

### Navigate to Project

```bash
cd file-upload-url-generator
```

### Build Application

```bash
mvn clean package
```

Generated WAR file:

```text
target/file-upload-url-generator.war
```

---

## 🚀 Run Locally

### Deploy to Tomcat

Copy WAR file:

```text
target/file-upload-url-generator.war
```

to:

```text
apache-tomcat/webapps/
```

Start Tomcat.

Access application:

```text
http://localhost:8080/file-upload-url-generator
```

---

## 🔄 Application Workflow

1. Select a file
2. Upload the file
3. File is stored on the server
4. URL is generated automatically
5. User can copy and share the URL

---

## 🔐 GitHub Secrets

Configure the following secrets in GitHub Repository Settings.

### DEV

```text
TOMCAT_URL_DEV
TOMCAT_USER_DEV
TOMCAT_PASSWORD_DEV
```

### TEST

```text
TOMCAT_URL_TEST
TOMCAT_USER_TEST
TOMCAT_PASSWORD_TEST
```

### PREPROD

```text
TOMCAT_URL_PREPROD
TOMCAT_USER_PREPROD
TOMCAT_PASSWORD_PREPROD
```

### PROD

```text
TOMCAT_URL_PROD
TOMCAT_USER_PROD
TOMCAT_PASSWORD_PROD
```

---

## 🏗️ CI/CD Pipeline

The GitHub Actions workflow performs:

### Build Stage

* Checkout Source Code
* Setup Java 17
* Maven Validate
* Maven Compile
* Maven Test
* Maven Package
* Publish WAR Artifact

### Deployment Stage

Sequential deployment:

```text
Build
  ↓
DEV
  ↓
TEST
  ↓
PREPROD
  ↓
PROD
```

The same WAR artifact is promoted through all environments ensuring deployment consistency.

---

## 🌍 Environments

| Environment | Purpose                 |
| ----------- | ----------------------- |
| DEV         | Development Testing     |
| TEST        | Functional Testing      |
| PREPROD     | User Acceptance Testing |
| PROD        | Production Environment  |

---

## 🔒 Tomcat Configuration

Create deployment user in:

```text
conf/tomcat-users.xml
```

```xml
<role rolename="manager-script"/>

<user
    username="deployuser"
    password="StrongPassword"
    roles="manager-script"/>
```

Restart Tomcat after changes.

---

## 📈 Future Enhancements

* Drag & Drop Upload
* QR Code Generation
* AWS S3 Integration
* Azure Blob Storage Integration
* Database Metadata Storage
* User Authentication
* File Expiry Links
* Audit Logging
* Monitoring Dashboard
* Blue-Green Deployment

---

## 👨‍💻 Author

Developed using Java, Maven, Apache Tomcat, and GitHub Actions.

---

## 📄 License

This project is intended for educational, demonstration, and enterprise CI/CD learning purposes.
