#!/bin/bash
URI=${1%_*}
echo "=======${URI}"
if [ "${URI}" != "" ]
then
	wget http://127.0.0.1:8080/onvif/webservices/${URI} --post-file=$1 -O - -nv
fi

