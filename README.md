# Spring AI Moderation API (NSFW Model)

## Overview
This project provides a **Spring Boot REST API** for AI-powered content moderation.  
It integrates an **NSFW (Not Safe For Work) detection model** to automatically classify and filter inappropriate or unsafe content such as explicit images, text, or media.

The API is designed to be lightweight, scalable, and easy to integrate into applications that require automated moderation.

---

## Features
- **NSFW Detection**: Classifies content as safe or unsafe using a trained AI model.
- **RESTful API**: Simple endpoints for submitting text or image content.
- **Configurable Policies**: Define thresholds for blocking or flagging content.
- **JSON Responses**: Clear moderation results with confidence scores.
- **Spring Boot Integration**: Built with Spring Boot for rapid deployment and scalability.

---

## API Endpoints

### 1. Health Check
```http
GET /api/v1/health
