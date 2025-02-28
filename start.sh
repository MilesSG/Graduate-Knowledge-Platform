#!/bin/bash

echo "考研平台资源准备工具"
echo "======================="

echo "1. 检查Python环境..."
if ! command -v python3 &> /dev/null; then
    echo "Python未安装，请安装Python 3.6以上版本"
    exit 1
fi

echo "2. 安装必要的Python库..."
pip3 install requests beautifulsoup4 -q

echo "3. 创建图片目录..."
mkdir -p images

echo "4. 运行爬虫获取考研相关图片..."
python3 crawler.py

echo "5. 将下载的图片替换到assets目录..."
mkdir -p src/assets/img
cp -f images/*.jpg src/assets/img/ 2>/dev/null || :

echo "6. 启动应用..."
npm install
npm run serve

echo "======================="
echo "考研平台已成功启动！" 