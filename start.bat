@echo off
echo 考研平台资源准备工具
echo =======================

echo 1. 检查Python环境...
python --version >nul 2>&1
if %errorlevel% neq 0 (
    echo Python未安装，请安装Python 3.6以上版本
    pause
    exit /b
)

echo 2. 安装必要的Python库...
pip install requests beautifulsoup4 -q

echo 3. 创建图片目录...
if not exist images mkdir images

echo 4. 运行爬虫获取考研相关图片...
python crawler.py

echo 5. 将下载的图片替换到assets目录...
if not exist src\assets\img mkdir src\assets\img
copy /Y images\*.jpg src\assets\img\

echo 6. 启动应用...
npm install
npm run serve

echo =======================
echo 考研平台已成功启动！
pause 