# 情感分析微服务演示项目

一个超级简易的跨语言微服务项目，展示如何用 **Python FastAPI** 构建一个 AI 情感分析服务，并通过 **Java Spring Boot** 客户端调用它。

## 功能特点

- ✅ **Python 服务**：接收 JSON 文本，返回情感标签（`POSITIVE` / `NEGATIVE`）和置信度。
- ✅ **Java 服务**：作为客户端，对外提供 REST API，调用 Python 服务并返回结果。
- ✅ 使用 Hugging Face 预训练模型（`distilbert-base-uncased-finetuned-sst-2-english`），轻量高效。
- ✅ 支持通过 `http://localhost:8080/api/sentiment/analyze?text=...` 快速测试。

## 技术栈

| 模块             | 技术                                                     |
| ---------------- | -------------------------------------------------------- |
| **Python 服务**  | FastAPI, Hugging Face Transformers, PyTorch, Uvicorn     |
| **Java 客户端**  | Spring Boot, RestTemplate, Maven                         |
| **开发工具**     | IntelliJ IDEA, Git                              |



## 快速开始
### 1. 启动 Python 情感分析服务

```bash
cd python-service   # 如果你将 Python 文件放在了独立目录，请先进入该目录
# 安装依赖
pip install -r requirements.txt


# 设置 Hugging Face 镜像（国内用户推荐）
# Windows PowerShell:
$env:HF_ENDPOINT = "https://hf-mirror.com"
# Linux/macOS:
export HF_ENDPOINT="https://hf-mirror.com"


# 启动服务（注意：如果文件名是 main1.py，请将 main 替换为 main1）
uvicorn main1:app --reload
服务将运行在 http://localhost:8000，可通过 http://localhost:8000/docs 查看自动生成的 API 文档。
显示：
{
  "message": "Sentiment Analysis API is running"
}

### 2.启动 Java Spring Boot 客户端
确保 Python 服务已运行，然后启动 Java 应用
应用将运行在 http://localhost:8080。

浏览器或 curl 访问：http://localhost:8080/api/sentiment/analyze?text=I love this movie!

返回示例：
{
  "label": "POSITIVE",
  "score": 0.9998
}


##注意事项：
Python 服务文件名：当前文件名为 main1.py，启动命令需使用 main1:app。如果希望使用默认的 main:app，可将文件重命名为 main.py。

端口占用：确保 8000 和 8080 端口未被其他程序占用。

首次启动：Python 服务第一次运行时，会自动下载约 500MB 的模型文件，请耐心等待，并确保网络畅通。

网络问题：若模型下载失败，请设置 HF_ENDPOINT 环境变量为国内镜像（如上所示）。

Java 版本：本项目基于 Java 17，请确保使用兼容的 JDK。

贡献
欢迎提交 Issue 或 Pull Request 改进本项目。
