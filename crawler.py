import os
import requests
from bs4 import BeautifulSoup
import re
import random
import time
from urllib.parse import urljoin

# 创建保存图片的目录
if not os.path.exists('images'):
    os.makedirs('images')

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36',
}

# 考研相关网站列表
websites = [
    'https://kaoyan.eol.cn/',
    'https://www.kaoyan.com/',
    'https://yz.chsi.com.cn/',
    'http://www.chinakaoyan.com/'
]

downloaded_images = []

def download_image(img_url, filename):
    try:
        response = requests.get(img_url, headers=headers, stream=True, timeout=10)
        if response.status_code == 200:
            with open(f'images/{filename}', 'wb') as f:
                f.write(response.content)
            print(f"下载成功: {filename}")
            return True
        else:
            print(f"下载失败: {img_url}, 状态码: {response.status_code}")
            return False
    except Exception as e:
        print(f"下载出错: {img_url}, 错误: {e}")
        return False

def crawl_images_from_website(url):
    print(f"爬取网站: {url}")
    try:
        response = requests.get(url, headers=headers, timeout=10)
        if response.status_code == 200:
            soup = BeautifulSoup(response.text, 'html.parser')
            
            # 查找所有图片标签
            img_tags = soup.find_all('img')
            
            count = 0
            for img in img_tags:
                # 获取图片链接
                img_url = img.get('src')
                if not img_url:
                    continue
                
                # 处理相对链接
                if not img_url.startswith(('http://', 'https://')):
                    img_url = urljoin(url, img_url)
                
                # 检查图片格式和大小要求
                if any(ext in img_url.lower() for ext in ['.jpg', '.jpeg', '.png', '.gif']):
                    # 生成唯一文件名
                    filename = f"kaoyan_{len(downloaded_images) + 1}_{int(time.time())}_{random.randint(1000, 9999)}.jpg"
                    
                    # 下载图片
                    if download_image(img_url, filename):
                        downloaded_images.append({
                            'url': img_url,
                            'filename': filename,
                            'source': url
                        })
                        count += 1
                    
                    # 随机延迟，避免请求过快
                    time.sleep(random.uniform(0.5, 2))
                    
                    # 限制每个网站下载的图片数量
                    if count >= 5:
                        break
            
            print(f"从 {url} 成功下载 {count} 张图片")
            
            # 查找并访问子页面
            if count < 5:
                links = soup.find_all('a', href=True)
                sub_pages = []
                
                for link in links:
                    href = link['href']
                    # 过滤出考研相关的页面
                    if re.search(r'(kaoyan|考研|postgraduate)', href, re.IGNORECASE):
                        if not href.startswith(('http://', 'https://')):
                            href = urljoin(url, href)
                        if url in href and href not in sub_pages:  # 确保是同一域名下的页面
                            sub_pages.append(href)
                
                # 随机选择1-2个子页面访问
                if sub_pages:
                    sub_count = min(2, len(sub_pages))
                    for sub_url in random.sample(sub_pages, sub_count):
                        print(f"访问子页面: {sub_url}")
                        try:
                            sub_response = requests.get(sub_url, headers=headers, timeout=10)
                            if sub_response.status_code == 200:
                                sub_soup = BeautifulSoup(sub_response.text, 'html.parser')
                                sub_img_tags = sub_soup.find_all('img')
                                
                                sub_img_count = 0
                                for img in sub_img_tags:
                                    img_url = img.get('src')
                                    if not img_url:
                                        continue
                                    
                                    if not img_url.startswith(('http://', 'https://')):
                                        img_url = urljoin(sub_url, img_url)
                                    
                                    if any(ext in img_url.lower() for ext in ['.jpg', '.jpeg', '.png', '.gif']):
                                        filename = f"kaoyan_sub_{len(downloaded_images) + 1}_{int(time.time())}_{random.randint(1000, 9999)}.jpg"
                                        
                                        if download_image(img_url, filename):
                                            downloaded_images.append({
                                                'url': img_url,
                                                'filename': filename,
                                                'source': sub_url
                                            })
                                            sub_img_count += 1
                                        
                                        time.sleep(random.uniform(0.5, 2))
                                        
                                        if sub_img_count >= 3:
                                            break
                                
                                print(f"从子页面 {sub_url} 成功下载 {sub_img_count} 张图片")
                        except Exception as e:
                            print(f"访问子页面出错: {sub_url}, 错误: {e}")
        else:
            print(f"获取页面失败: {url}, 状态码: {response.status_code}")
    except Exception as e:
        print(f"爬取出错: {url}, 错误: {e}")

def main():
    print("开始爬取考研相关图片...")
    
    for website in websites:
        crawl_images_from_website(website)
        
        # 如果已经下载了足够多的图片，就停止
        if len(downloaded_images) >= 20:
            break
        
        # 在不同网站之间添加较长的延迟
        time.sleep(random.uniform(3, 5))
    
    print(f"爬取完成，共下载 {len(downloaded_images)} 张图片")
    
    # 输出下载的图片信息
    with open('downloaded_images.txt', 'w', encoding='utf-8') as f:
        for img in downloaded_images:
            f.write(f"文件名: {img['filename']}, 来源: {img['source']}, URL: {img['url']}\n")

if __name__ == "__main__":
    main() 