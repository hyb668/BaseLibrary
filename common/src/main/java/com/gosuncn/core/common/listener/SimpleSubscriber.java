/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gosuncn.core.common.listener;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * 简化RxAndroid订阅器
 */
public abstract class SimpleSubscriber<T> extends Subscriber<T> {

    protected Context context;

    public SimpleSubscriber(Context context) {
        this.context = context;
    }

    public abstract void onSuccess(T t);

    public void onFailure(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!isNetworkAvailable(context)) {
            Toast.makeText(context, "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
            onCompleted();
            return;
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            onTimeout((SocketTimeoutException) e);
        }
        onFailure(e);
    }

    public void onTimeout(SocketTimeoutException e){

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    // 检查是否连接到网络
    public boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null)
                return info.isAvailable();
        }
        return false;
    }

}
