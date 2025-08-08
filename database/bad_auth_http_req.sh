#!/bin/bash

curl -v -X POST http://localhost:8080/token \
  -u dmin:aoppeditinthewater\
  -H "Content-Type: application/json"
