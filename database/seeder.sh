#!/bin/bash
# this script is used to populate the database with the user defined in ./init/init.sql

cat ./init.sql | docker exec -i SSDB psql -U sleepy -d ssdb
