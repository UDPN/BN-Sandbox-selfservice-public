#!/bin/bash

# 检查参数个数
if [ $# -ne 2 ]; then
  echo "使用方法: $0 <mysql的data目录> <redisi的data目录>"
  exit 1
fi

source_directory_mysql="$1"
source_directory_redis="$2"

# 设置要检查的目录路径
target_directory_mysql="/bsn/bn_volume/mysql"
target_directory_redis="/bsn/bn_volume/redis"


# 检查源目录是否存在
if [ ! -d "$source_directory_mysql" ]; then
  echo "源目录 $source_directory_mysql 不存在！"
  exit 1
fi

if [ ! -d "$source_directory_redis" ]; then
  echo "源目录 $source_directory_redis 不存在！"
  exit 1
fi


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



# 备份目录到目标目录
cp -r "$source_directory_mysql" "$target_directory_mysql"
echo "mysql目录备份完成！"

cp -r "$source_directory_redis" "$target_directory_redis"
echo "redis目录备份完成！"

cp ./redis/redis.conf $target_directory_redis
cp ./mysql/my.cnf $target_directory_mysql

docker-compose up -d 
