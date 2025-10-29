#!/bin/bash
# monitor_backend.sh - 监控后端Git更新

echo "开始监控后端Git仓库更新..."
echo "监控间隔: 30秒"
echo "按 Ctrl+C 停止监控"

while true; do
    echo "[$(date)] 检查后端更新..."
    ./auto_deploy_backend.sh
    sleep 30
done