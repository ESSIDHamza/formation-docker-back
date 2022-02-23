FROM openjdk:11

LABEL maintainer="Hamza ESSID <eshamza2212@gmail.com>"

ENV CHEMIN_FICHIER /home/formation-docker.txt

RUN mkdir -p /usr/app && \
    touch ${CHEMIN_FICHIER}

WORKDIR /usr/app

EXPOSE 8080

ARG DB_URL
ARG DB_USERNAME
ARG DB_PWD

ADD target/formation-docker-1.0-RELEASE.jar .

ENTRYPOINT ["java", "-jar", "formation-docker-1.0-RELEASE.jar", \
            "--spring.datasource.url=${DB_URL}", \
            "--spring.datasource.username=${DB_USERNAME}", \
            "--spring.datasource.password=${DB_PWD}", \
            "--chemin-fichier=${CHEMIN_FICHIER}"]
