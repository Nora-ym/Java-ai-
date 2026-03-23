# FastAPI + Spring Boot 情感分析微服务项目
用 Python 搭建 AI 情感分析 API，Java 客户端调用，完整微服务架构实战

## 📌 项目介绍
本项目实现了一个跨语言的情感分析服务：
- Python 端：用 FastAPI 搭建 AI 情感分析接口（基于 Hugging Face 模型）
- Java 端：用 Spring Boot 作为客户端，调用 Python 的 AI 接口

## 🛠 技术栈
### Python 端
- FastAPI：轻量 API 框架
- uvicorn：ASGI 服务器
- transformers：Hugging Face 模型库
- torch：AI 模型运行依赖

### Java 端
- Spring Boot 3.x：Java Web 框架
- RestTemplate：HTTP 请求工具
- Maven：项目构建工具

## 一、启动 Python 情感分析服务

### 1. 进入文件夹
cd fastapi-server

### 2. 安装依赖
pip install fastapi uvicorn transformers torch

### 3. 配置国内镜像
#### Windows
$env:HF_ENDPOINT = "https://hf-mirror.com"

#### Mac/Linux
export HF_ENDPOINT="https://hf-mirror.com"

### 4. 启动服务
uvicorn main1:app --reload

### 5. 验证启动
访问 http://localhost:8000
返回：{"message": "Sentiment Analysis API is running"}

---

## 二、启动 Java Spring Boot 客户端

### 1. 启动项目
运行 FastapiSpringbootApplication.java

### 2. 测试接口
http://localhost:8080/api/sentiment/analyze?text=I love this movie!

### 3. 返回结果
{
    "label": "POSITIVE",
    "score": 0.9998765
}

---

## 三、项目结构
```bash
sentiment-project/
├── fastapi-server/       # Python 服务
│   └── main.py           # FastAPI 情感分析接口
├── springboot-client/    # Java 客户端
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   └── demo/
│   │                       ├── config/        # RestTemplate 配置
│   │                       ├── controller/  # 接口控制器
│   │                       ├── service/     # 业务逻辑
│   │                       └── DemoApplication.java  # 启动类
│   └── pom.xml           # Maven 依赖配置
├── .gitignore            # Git 忽略文件
└── README.md             # 项目说明（本文）
```

---

## 四、注意事项

1. Python 必须先启动
2. 首次运行会自动下载模型
3. 国内必须配置镜像才能正常下载
