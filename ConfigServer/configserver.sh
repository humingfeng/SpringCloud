#!/usr/bin/env bash
echo "当前位置：" `pwd`
echo "当前用户：" `whoami`
docker -v
#删除同名docker容器
cid=$(docker ps -a| grep "configserver" | awk '{print $1}')
if [ "$cid" != "" ]; then
docker rm -f $cid
fi
#删除之前的同名镜像
imagesid=$(docker images configserver -q)
if [ "$imagesid" != "" ]; then
docker rmi -f $imagesid
fi
#构建docker 镜像
version=$(date +%Y%m%d)
docker build -t configserver:$version -f /home/jenkins/ConfigServer/Dockerfile .
#推送docker镜像
#docker push $DOCKER_REGISTRY$IMAGE_NAME
#启动docker 容器
docker run -d -p 8888:8888 --name configserver configserver:$version
#删除 Dockerfile 文件
#rm -f Dockerfile
