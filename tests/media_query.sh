#!/bin/bash
wget http://127.0.0.1:8080/onvif/webservices/Media --post-file=$1 -O - -nv

