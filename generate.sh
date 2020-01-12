#!/bin/bash
# 生成题目, 默认使用java, scala可以手动声明

if [ $# -eq 0 ];then
    echo 'usage: ./show number language'
    exit 1
fi

num=$1
language=${2:-"java"}

if [[ "$language" != "java" && "$language" != "scala" ]];then
    echo 'only support java and scala now'
    exit 1
fi

if ! type leetcode &> /dev/null; then
    echo 'run npn install leetcode -g first'
    exit 1
fi

cd ./src/main/$language
if leetcode show $num -g -l $language; then
    echo 'generate success!'
else
    echo 'generate failed'
fi
