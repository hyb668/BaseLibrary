# Sample Usage

project中有样例演示，可以在 `sample/` 文件夹找到.

## Common

### UrlInterceptor

用于拦截请求，设置ip和port。

#### 配置okhttp网络拦截器

```java
OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new UrlInterceptor())
                .build();
```

#### 设置`ip`和`port`

```java
interceptor.setHost("127.0.0.1").setPort("8080");
```

#### 对于请求是`@URL`，可以通过取消拦截

```java
interceptor.setIntercepted(false);//完成请求后，请恢复为true,不然其他请求都不会再被拦截
```