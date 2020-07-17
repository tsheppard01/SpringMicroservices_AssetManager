#!/bin/bash

mvn liquibase:update \
  -Dliquibase.url="jdbc:postgresql://${ASSET_REQUESTS_DB_SERVER}/${ASSET_REQUESTS_DB_NAME}" \
  -Dliquibase.username="${ASSET_REQUESTS_DB_USERNAME}" \
  -Dliquibase.password="${ASSET_REQUESTS_DB_PASSWORD}"
