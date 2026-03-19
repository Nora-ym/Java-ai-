# main1.py
from fastapi import FastAPI
from pydantic import BaseModel
from transformers import pipeline

# 1. 创建 FastAPI 实例
app = FastAPI()

# 2. 加载情感分析模型（首次运行会自动下载）
# 使用 distilbert 模型，速度快且准确率不错
classifier = pipeline("sentiment-analysis", model="distilbert-base-uncased-finetuned-sst-2-english")

# 3. 定义请求体格式
class TextRequest(BaseModel):
    text: str

# 4. 定义 POST 端点
@app.post("/analyze")
async def analyze_sentiment(request: TextRequest):
    """
    接收 JSON 格式的文本，返回情感分析结果
    """
    result = classifier(request.text)[0]  # 模型返回列表，取第一个
    # result 格式：{'label': 'POSITIVE', 'score': 0.9998}
    return {
        "label": result['label'],
        "score": result['score']
    }

# 5. （可选）添加 GET 根路径测试
@app.get("/")
def read_root():
    return {"message": "Sentiment Analysis API is running"}






















