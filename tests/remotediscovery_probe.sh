#!/bin/bash
wget http://127.0.0.1:8080/onvif/webservices/DiscoveryLookupPort --post-file=remotediscovery_probe.xml -O - -nv

