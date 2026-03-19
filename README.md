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

## 🚀 快速运行（分两步）
### 1. 启动 Python 情感分析服务
#### 1.1 进入项目目录
```bash
# 进入 Python 服务所在文件夹（根据你的实际路径改）
cd fastapi-server
1.2 安装依赖
bash
运行
# 安装 FastAPI、模型库等
pip install fastapi uvicorn transformers torch
1.3 配置 Hugging Face 镜像（国内用户必做）
加速下载 AI 模型，否则可能超时：
powershell
# Windows PowerShell
$env:HF_ENDPOINT = "https://hf-mirror.com"
bash
运行
# Linux/macOS
export HF_ENDPOINT="https://hf-mirror.com"
1.4 启动服务
bash
运行
# 命令格式：uvicorn 文件名:实例名 --reload
# 你的文件是 main.py，实例名是 app，执行：
uvicorn main:app --reload
1.5 验证启动
服务启动后，访问 http://localhost:8000，看到以下内容表示成功：
json
{"message": "Sentiment Analysis API is running"}
也可以访问 http://localhost:8000/docs 查看自动生成的 API 文档。
2. 启动 Java Spring Boot 客户端
2.1 前置条件
确保 Python 服务已经启动（端口 8000 占用正常）。
2.2 启动 Java 项目
用 IDEA/Eclipse 打开 springboot-client 文件夹
找到启动类：com.example.demo.DemoApplication
点击「运行」启动 Spring Boot 应用
2.3 验证启动
Spring Boot 默认运行在 8080 端口。访问以下地址测试接口：
plaintext
http://localhost:8080/api/sentiment/analyze?text=I love this movie!
2.4 预期返回结果
json
{
    "label": "POSITIVE",
    "score": 0.9998765
}
label：情感标签，POSITIVE= 正面，NEGATIVE= 负面
score：置信度，0~1 之间，数值越高表示判断越准确



📁 项目结构
plaintext
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
✅ 核心功能说明
Python 端提供 /analyze POST 接口，接收文本，返回情感分析结果
Java 端通过 RestTemplate 调用 Python 接口
Java 对外提供 /api/sentiment/analyze GET 接口，方便前端调用
完整的跨语言微服务调用流程
📝 注意事项
Python 服务必须先启动，否则 Java 调用会报错（连接超时）
AI 模型首次启动会自动下载，时间较长，请耐心等待
国内用户务必配置 HF 镜像，否则模型下载大概率失败
plaintext


