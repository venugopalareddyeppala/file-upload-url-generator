FROM tomcat:8-jre8

LABEL maintainer="file-upload-url-generator"

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/file-upload-url-generator.war \
     /usr/local/tomcat/webapps

HEALTHCHECK --interval=30s --timeout=10s --start-period=60s \
  CMD curl -f http://localhost:8080/ || exit 1

EXPOSE 8086
