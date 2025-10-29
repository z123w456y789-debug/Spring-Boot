#!/bin/bash
# auto_deploy_backend.sh - Spring Boot 自动部署脚本

echo "=== 开始后端自动部署 ==="
echo "时间: $(date)"

# 检查Git更新
if git fetch origin 2>/dev/null; then
    LOCAL=$(git rev-parse HEAD)
    REMOTE=$(git rev-parse origin/main 2>/dev/null)
    
    if [ $? -eq 0 ] && [ "$LOCAL" != "$REMOTE" ]; then
        echo "🔄 发现新版本: ${LOCAL:0:8} -> ${REMOTE:0:8}"
        
        # 拉取更新
        git pull origin main
        
        echo "构建Spring Boot应用..."
        # 确保Maven Wrapper存在
        [ -f "./mvnw" ] || mvn -N io.takari:maven:wrapper
        chmod +x ./mvnw
        
        # 编译项目
        ./mvnw clean compile -DskipTests -q
        
        echo "重启应用..."
        # 停止现有应用
        pkill -f 'spring-boot:run' || echo "没有运行中的应用"
        sleep 3
        
        # 启动新应用
        export SPRING_PROFILES_ACTIVE=dev
        nohup ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev > spring-boot.log 2>&1 &
        
        echo "等待应用启动..."
        sleep 10
        
        # 检查应用状态
        if curl -s http://localhost:2222/actuator/health >/dev/null; then
            echo "✅ Spring Boot启动成功!"
            echo "🌐 访问地址: http://localhost:2222"
        else
            echo "⚠️  应用启动中，请检查日志: tail -f spring-boot.log"
        fi
    else
        echo "✅ 代码已是最新版本"
    fi
else
    echo "🌐 网络连接失败"
fi

echo "=== 后端自动部署完成 ==="
