#!/bin/bash

mvn liquibase:update \
  -Dliquibase.url="jdbc:postgresql://${ASSETS_DB_SERVER}/${ASSETS_DB_NAME}" \
  -Dliquibase.username="${ASSETS_DB_USERNAME}" \
  -Dliquibase.password="${ASSETS_DB_PASSWORD}"
