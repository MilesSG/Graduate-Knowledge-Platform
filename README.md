# 📚 考研知识平台 | Graduate Knowledge Platform

## 🌟 项目介绍

考研知识平台是一个专为备考研究生考试的学生打造的全方位学习平台。本平台汇集了丰富的考研资料、视频课程和专业分类，并提供社区互动功能，帮助考生更高效地备考，实现梦想院校的目标。

![考研知识平台](images\image.png)

## ✨ 核心功能

### 📊 考试倒计时
- ⏱️ 直观显示距离国家硕士研究生入学考试的剩余时间
- 📅 精确到天、小时、分钟和秒，帮助考生合理规划备考时间

### 📖 学习资源
- 📑 海量考研资料，包括真题、模拟题和学习笔记
- 🎬 优质视频课程，覆盖各专业核心知识点
- 📋 按专业分类的学习指南和备考策略

### 👥 学习社区
- 💬 与其他考生交流学习经验和心得
- 📝 分享个人笔记和学习方法
- 👍 点赞和收藏有价值的内容

### 🛠️ 实用工具箱
- 📊 院校分数线查询
- 📝 学习计划制定工具
- 📈 备考进度跟踪

### 🤝 资源贡献
- 📤 上传笔记、资料和视频
- 🌟 分享学习心得
- 🏆 贡献者积分奖励机制

## 🚀 快速入门

### 环境要求
- Node.js 12.0+
- npm 6.0+
- JDK 1.8+
- Maven 3.6+
- MySQL 8.0+

### 📥 安装步骤

1. 克隆项目仓库
```bash
git clone https://github.com/MilesSG/Graduate-Knowledge-Platform.git
cd Graduate-Knowledge-Platform
```

2. 前端项目安装依赖并启动
```bash
npm install
npm run serve
```

3. 后端项目

   项目已集成Spring Boot后端，通过RESTful API提供数据服务。后端服务自动运行，无需额外启动。
   
4. 访问应用
```
前端页面：http://localhost:8081
后端API：http://localhost:8081/api
```

## 🔧 技术栈

### 前端技术
- 🖼️ 前端框架：Vue.js 2.6
- 🎨 UI组件库：Element UI
- 🔄 状态管理：Vuex
- 🛣️ 路由管理：Vue Router
- 💅 样式：Less
- 📝 富文本编辑：WangEditor、Mavon Editor
- 🎬 视频播放：DPlayer

### 后端技术
- 🔧 核心框架：Spring Boot 2.7
- 🔐 安全框架：Spring Security
- 🗄️ ORM框架：Spring Data JPA
- 🧭 API规范：RESTful API
- 📦 数据库：MySQL 8.0
- 🔑 认证授权：JWT
- 📝 接口文档：Swagger UI

## 📱 响应式设计

平台采用响应式设计，完美适配不同尺寸的设备：
- 💻 桌面电脑
- 💻 笔记本电脑
- 📱 平板设备
- 📱 移动手机

## 📈 项目结构

### 前端结构
```
src/
├── api/             # API接口
├── assets/          # 静态资源文件
├── components/      # 公共组件
├── pages/           # 页面组件
├── router/          # 路由配置
├── store/           # Vuex状态管理
├── utils/           # 工具函数
├── App.vue          # 根组件
└── main.js          # 入口文件
```

### 后端结构
```
server/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── graduateknowledge/
│   │   │           └── platform/
│   │   │               ├── config/        # 配置类
│   │   │               ├── controller/    # 控制器
│   │   │               ├── model/         # 实体类
│   │   │               ├── repository/    # 数据访问层
│   │   │               ├── service/       # 业务逻辑层
│   │   │               └── GraduateKnowledgePlatformApplication.java
│   │   └── resources/
│   │       ├── application.properties     # 应用配置文件
│   │       ├── static/                    # 静态资源
│   │       └── templates/                 # 模板文件
│   └── test/                              # 测试代码
└── pom.xml                                # Maven配置文件
```

## 🤝 参与贡献

1. Fork 本仓库
2. 创建您的特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交您的修改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 开启一个 Pull Request

## 📄 开源许可

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件

## 📮 联系我们

如有任何问题或建议，欢迎通过GitHub Issues联系我们

---

💪 祝所有考研学子金榜题名，梦想成真！💪



