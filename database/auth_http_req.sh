#!/bin/bash

curl -v -X POST http://localhost:8080/token \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=admin&password=awnoidroppeditinthewater"
