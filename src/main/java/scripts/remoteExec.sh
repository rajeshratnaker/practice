#!/bin/sh

sshcmd() {
    server=$1
    cmd=$2
    ssh -q `whoami`@$server "$cmd"
}

run() {
    server=$1
    cmd=$2
    ret=`sshcmd $server "$cmd"`
    echo "$server=[$ret]"
}

cmd=$1

for server in @host.list@
do
    run $server "$cmd"
done

