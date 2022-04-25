#!/usr/bin/env sh

# stash 未提交的文件
git stash -qku

# 检查命令 ~= 运行测试
./gradlew clean check

# 定义变量接收上一行结果
RESULT=$?

git stash pop -q

# 退出并打印检查结果
exit $RESULT