FROM mysql

ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_USER springuser
ENV MYSQL_PASSWORD ThePassword
ENV MYSQL_DATABASE livefoxdb

COPY DATAv1.sql /docker-entrypoint-initdb.d/