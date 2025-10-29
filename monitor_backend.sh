#!/bin/bash
# monitor_backend.sh - Spring Boot 监控脚本

echo "🚀 Spring Boot自动监控启动"
echo "📡 每30秒检查一次GitHub更新"
echo "⏹️  按 Ctrl + C 停止监控"
echo "----------------------------------------"

while true; do
    echo "[$(date +%H:%M:%S)] 检查更新..."
    ./auto_deploy_backend.sh
    echo "等待30秒..."
    sleep 30
    echo "----------------------------------------"
done
