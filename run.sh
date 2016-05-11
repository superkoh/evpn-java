#!/usr/bin/env bash

start() {
    PIDS=`ps aux|grep "evpn-release"|grep -v "grep"|awk '{print $2}'`;
    if [[ ! -z PIDS ]];
        then
            stop
    fi
    nohup /root/deps/jdk1.8.0_92/bin/java -Duser.timezone="Asia/Shanghai" -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active="prod" -Denv="prod" -jar build/libs/evpn-release.jar > /dev/null 2>&1 &
}

stop() {
    PIDS=`ps aux|grep "evpn-release"|grep -v "grep"|awk '{print $2}'`;
    if [[ -z PIDS ]];
        then
            echo "no service running"
    else
        for pid in $PIDS
            do
                kill -9 $pid
        done
    fi
}

case "$1" in
  start)
    start
  ;;
  stop)
    stop
  ;;
  restart)
    stop
    sleep 5
    start
  ;;
  *)
    echo "Usage: $0 (start | stop | restart)"
    exit 1
esac

exit $?