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
		// ����Get����ʵ��
		HttpPost httpPost = new HttpPost(url);
		// ����һ��NameValuePair���飬���ڴ洢�����ݵĲ���
		//List params = new ArrayList();
		// ��Ӳ���
		//params.add(new BasicNameValuePair("start", "0"));
		//params.add(new BasicNameValuePair("size", "14"));
		//params.add(new BasicNameValuePair("sortType", "hot"));
		// ���ñ���
		try {
			HttpClient httpClient = new DefaultHttpClient();
			//httpPost.setEntity(new UrlEncodedFormEntity(null, HTTP.UTF_8));
			// ����Post,������һ��HttpResponse����
			HttpResponse response = httpClient.execute(httpPost);
			// ���Եõ�ָ����header
			// Header header = response.getFirstHeader("Content-Length");
			// String Length=header.getValue();
			// System.out.println(header.getName());
			// ���״̬����200������������
			if (response.getStatusLine().getStatusCode() == 200) {
				// ��÷��ص��ַ���
				String result = EntityUtils.toString(response.getEntity());
				// ��ӡ���
				System.err.println(result);
				// ��������ص��ļ���������response.getEntity().getContent����InputStream
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
