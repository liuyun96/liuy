package com.finance.stock.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String post(String url) {
		// 创建Get方法实例
		HttpPost httpPost = new HttpPost(url);
		// 建立一个NameValuePair数组，用于存储欲传递的参数
		//List params = new ArrayList();
		// 添加参数
		//params.add(new BasicNameValuePair("start", "0"));
		//params.add(new BasicNameValuePair("size", "14"));
		//params.add(new BasicNameValuePair("sortType", "hot"));
		// 设置编码
		try {
			HttpClient httpClient = new DefaultHttpClient();
			//httpPost.setEntity(new UrlEncodedFormEntity(null, HTTP.UTF_8));
			// 发送Post,并返回一个HttpResponse对象
			HttpResponse response = httpClient.execute(httpPost);
			// 可以得到指定的header
			// Header header = response.getFirstHeader("Content-Length");
			// String Length=header.getValue();
			// System.out.println(header.getName());
			// 如果状态码是200，则正常返回
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得返回的字符串
				String result = EntityUtils.toString(response.getEntity());
				// 打印输出
				System.err.println(result);
				// 如果是下载的文件，可以用response.getEntity().getContent返回InputStream
				return result;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		HttpUtil.post("http://hq.sinajs.cn/?_=0.3388963919132948&list=sh600255");
	}
}
