package com.HelloHttp.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class HttpClientApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testHttpClient() {
		//创建http客户端
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//创建get请求
		HttpGet httpUrl = new HttpGet("http://localhost:8801");

		//初始化响应
		CloseableHttpResponse response = null;

		try {
//			由客户端执行请求
			response = httpClient.execute(httpUrl);

//			获取响应对象
			HttpEntity respEntity = response.getEntity();
			System.out.println("响应状态：" + response.getStatusLine());
			if (respEntity != null) {
				System.out.println("响应内容长度："+respEntity.getContentLength());
				System.out.println("响应内容："+ EntityUtils.toString(respEntity));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
