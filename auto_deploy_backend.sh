#!/bin/bash
# auto_deploy_backend.sh - Spring Boot 自动部署脚本

echo "=== 开始后端自动部署 ==="
echo "时间: $(date)"

# 检查是否有更新
git fetch origin

LOCAL=$(git rev-parse HEAD)
REMOTE=$(git rev-parse origin/main)

if [ "$LOCAL" = "$REMOTE" ]; then
    echo "后端代码已是最新版本"
    exit 0
fi

echo "检测到后端新版本，开始更新..."

# 拉取最新代码
git pull origin main

echo "开始构建Spring Boot后端..."

# 检查Maven Wrapper是否存在
if [ ! -f "./mvnw" ]; then
    echo "Maven Wrapper不存在，正在下载..."
    mvn -N io.takari:maven:wrapper
fi

# 给mvnw执行权限
chmod +x ./mvnw

# 清理并编译
echo "清理和编译项目..."
./mvnw clean compile -DskipTests

# 停止现有的Spring Boot应用
echo "停止现有Spring Boot应用..."
pkill -f 'spring-boot:run' || true
sleep 2

# 后台启动Spring Boot
echo "启动新的Spring Boot应用..."
nohup ./mvnw spring-boot:run > spring-boot.log 2>&1 &

# 检查启动状态
sleep 5
if pgrep -f 'spring-boot:run' > /dev/null; then
    echo "✅ Spring Boot启动成功"
    echo "🔗 访问地址: http://localhost:8080"
    echo "📋 查看日志: tail -f spring-boot.log"
else
    echo "❌ Spring Boot启动失败，请检查日志"
    tail -20 spring-boot.log
fi

echo "=== 后端自动部署完成 ==="