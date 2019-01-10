#!/usr/bin/env bash
echo "当前位置：" `pwd`
echo "当前用户：" `whoami`
docker -v
#构建docker 镜像
version=$(date +%Y%m%d)
docker build -t eurekaclientfirst:$version -f /home/jenkins/EurekaClientFirst/Dockerfile .
#推送docker镜像
#docker push $DOCKER_REGISTRY$IMAGE_NAME
#删除同名docker容器
cid=$(docker ps -a| grep "eurekaclientfirst" | awk '{print $1}')
if [ "$cid" != "" ]; then
docker rm -f $cid
fi
#启动docker 容器
docker run -d -p 8762:8080 --name eurekaclientfirst eurekaclientfirst:$version
#删除 Dockerfile 文件
#rm -f Dockerfile
#删除之前的同名镜像
imagesid==$(docker images eurekaclientfirst:$version -q)
if [ "imagesid" != "" ]; then
docker rmi -f $imagesid
fi