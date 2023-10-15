FROM postgres:16.0
COPY sql/create-database.sql /docker-entrypoint-initdb.d/
EXPOSE 5433
CMD ["postgres"]
