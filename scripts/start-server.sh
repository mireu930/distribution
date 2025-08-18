#!/bin/bash

echo "--------------- 서버 배포 시작 -----------------"
docker stop distribution || true
docker rm distribution || true
docker pull 221082169763.dkr.ecr.ap-northeast-2.amazonaws.com/distribution:latest
docker run -d --name distribution -p 8080:8080 221082169763.dkr.ecr.ap-northeast-2.amazonaws.com/distribution
echo "--------------- 서버 배포 끝 -----------------"
