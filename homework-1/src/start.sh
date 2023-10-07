#!/bin/bash

LOGFILE="logfile.csv"
PIDFILE="pidfile.pid"

chmod u+w $LOGFILE

monitor() {
  while true; do
    CPU=$(ps -A -o %cpu | awk '{s+=$1} END {print s}')

    TOTAL_MEMORY=$(sysctl hw.memsize | awk '{print $2}')
    FREE_MEMORY=$(vm_stat | grep "Pages free:" | awk '{print $3}')
    USED_MEMORY=$(echo "$TOTAL_MEMORY/4096 - $FREE_MEMORY" | bc)
    RAM=$(echo "$USED_MEMORY*100*4096/$TOTAL_MEMORY" | bc)

    TIMESTAMP=$(date '+%Y-%m-%d %H:%M:%S')

    echo "$TIMESTAMP;$CPU;$RAM" >>$LOGFILE

    sleep 600
  done
}

case $1 in
START)
  monitor &
  echo $! >$PIDFILE
  echo "Monitoring started with PID $!"
  ;;
STOP)
  if [ -f $PIDFILE ]; then
    kill -9 $(cat $PIDFILE)
    rm $PIDFILE
    rm $LOGFILE
    echo "Monitoring stopped"
  else
    echo "No monitoring process found"
  fi
  ;;
STATUS)
  if [ -f $PIDFILE ]; then
    echo "Monitoring is running with PID $(cat $PIDFILE)"
  else
    echo "No monitoring process found"
  fi
  ;;
*)
  echo "Usage: $0 {START|STOP|STATUS}"
  ;;
esac
