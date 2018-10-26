package com.mxz.zuul.getway.falback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class UserFallbackProvider implements FallbackProvider{

	@Override
	public String getRoute() {
		// 表明视为那个微服务提供回退
		return "S2";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}
			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("用户为服务不可用, 请稍后重试".getBytes());
			}
			@Override
			public String getStatusText() throws IOException {
				return this.getStatusCode().getReasonPhrase();
			}
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
			@Override
			public int getRawStatusCode() throws IOException {
				return this.getStatusCode().value();
			}
			@Override
			public void close() {
			}
		};
	}

}
