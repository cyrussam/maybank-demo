package es.cyrus.dev.restexample;

import java.util.HashMap;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil
{
  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
  private static OkHttpClient client = new OkHttpClient();
  
  public static String get(String url)
  {
    try
    {
      Request request = new Request.Builder().url(url).build();
      Response response = client.newCall(request).execute();
      return response.body().string();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
  
  public static String getWithHeader(String url, HashMap<String, String> headers)
  {
    try
    {
      Headers headersParams = Headers.of(headers);
      
      Request request = new Request.Builder().headers(headersParams).url(url).build();
      Response response = client.newCall(request).execute();
      return response.body().string();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
  
  public static String post(String url, String json)
  {
    try
    {
      RequestBody body = RequestBody.create(JSON, json);
      
      Request request = new Request.Builder().url(url).post(body).build();
      Response response = client.newCall(request).execute();
      return response.body().string();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
  
  public static String post(String url, HashMap<String, String> params)
  {
    Builder paramsBuilder = new Builder();
    for (String key : params.keySet()) {
      paramsBuilder.add(key, (String)params.get(key));
    }
    try
    {
      Request request = new Request.Builder().url(url).post(paramsBuilder.build()).build();
      Response response = client.newCall(request).execute();
      return response.body().string();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
  
  public static String postWithHeader(String url, HashMap<String, String> params, HashMap<String, String> headers)
  {
    Builder paramsBuilder = new Builder();
    for (String key : params.keySet()) {
      paramsBuilder.add(key, (String)params.get(key));
    }
    Headers headersParams = Headers.of(headers);
    try
    {
      Request request = new Request.Builder().url(url).headers(headersParams).post(paramsBuilder.build()).build();
      
      Response response = client.newCall(request).execute();
      if (response.body() != null) {
        return response.body().string();
      }
      return "";
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
}
