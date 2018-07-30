FROM postgres

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD dac
ENV POSTGRES_DB dac-jsf-docker

copy tabelas.sql /docker-entrypoint-initdb.d/
