#!/bin/bash

echo "--------------- 서버 배포 시작 -----------------"
cd /home/ubuntu/distribution
sudo fuser -k -n tcp 8080 || true
nohup java -jar project.jar > /home/ubuntu/output.log 2>&1 &
echo "--------------- 서버 배포 끝 -----------------"
