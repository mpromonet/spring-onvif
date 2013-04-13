#!/bin/bash
cat probe_wsd.xml | tr -d '\n' | nc -u 239.255.255.250 3702

