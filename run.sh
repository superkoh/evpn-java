#!/usr/bin/env bash
nohup /root/jdk1.8.0_92/bin/java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active="prod" -Denv="prod" -jar build/libs/evpn-service-1.0.0.jar > /dev/null 2>&1 &