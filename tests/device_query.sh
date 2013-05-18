#!/bin/bash
wget http://127.0.0.1:8080/onvif/webservices/device_service --post-file=$1 -O - -nv

