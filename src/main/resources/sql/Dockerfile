FROM mysql:8

LABEL maintainer="Hamza ESSID <eshamza2212@gmail.com>"

ENV MYSQL_ROOT_PASSWORD P@ssw0rd!123 # username = root

ADD 1.0-database_creation.sql /docker-entrypoint-initdb.d/
