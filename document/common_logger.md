# Sample Usage

project中有样例演示，可以在 `sample/` 文件夹找到.

## Common

### HttpLoggingInterceptorM、LogInterceptor、LogUtil

用于打印okhttp的请求和响应和普通log

#### 配置okhttp拦截器

```java
HttpLoggingInterceptorM loggingInterceptor = new HttpLoggingInterceptorM(new LogInterceptor());
loggingInterceptor.setLevel(HttpLoggingInterceptorM.Level.BODY);

OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
```

#### 设置是否打印log

```java
LogUtil.init(BuildConfig.DEBUG);
```

#### 打印普通log

```java
 LogUtil.d(TAG,"debug message");
```