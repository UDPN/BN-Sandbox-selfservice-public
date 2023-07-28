#!/bin/bash

# 设置要检查的目录路径
target_directory_mysql="/bsn/bn_volume/mysql"
target_directory_redis="/bsn/bn_volume/redis"

# 判断目录是否存在
if [ ! -d "$target_directory_mysql" ]; then
  # 如果目录不存在，则创建它
  mkdir -p "$target_directory_mysql"
  echo "目录已创建：$target_directory_mysql"
else
  echo "目录已存在：$target_directory_mysql"
fi

if [ ! -d "$target_directory_redis" ]; then
  # 如果目录不存在，则创建它
  mkdir -p "$target_directory_redis"
  echo "目录已创建：$target_directory_redis"
else
  echo "目录已存在：$target_directory_redis"
fi

cp ./redis/redis.conf $target_directory_redis
cp ./mysql/my.cnf $target_directory_mysql

docker-compose up -d