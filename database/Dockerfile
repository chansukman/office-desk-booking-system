FROM mysql:latest
WORKDIR /home/gradle/src/database
ENV AUTO_RUN_DIR /docker-entrypoint-initdb.d
ENV INSTALL_DATA_SHELL setup.sh
ENV FILE_0 adms2.sql
ENV INSTALL_DATA_SHELL setup.sh
RUN mkdir -p /home/gradle/src/database
COPY ./adms2.sql /home/gradle/src/database/
COPY ./setup.sh /docker-entrypoint-initdb.d/
RUN chmod a+x /docker-entrypoint-initdb.d/setup.sh