package com.gosuncn.core.util.app;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

import java.io.File;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.value;

/**
 * App辅助类
 *
 * @author HWJ
 */
public class AppUtils {

    private AppUtils() {
        throw new UnsupportedOperationException("sorry,AppUtil cannot be instantiated");
    }

    /**
     * 获取应用程序名称
     *
     * @param context
     * @return
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取应用版本名称
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得当前应用的版本号<br>
     *
     * @param context     上下文
     * @param defaultCode 如果获取失败，则返回默认值
     * @return 版本号
     */
    public static String getVersionCode(Context context, String defaultCode) {

        try {
            // 获取packageManager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo;
            packInfo = packageManager.getPackageInfo(context.getPackageName(),
                    0);
            String version = packInfo.versionName;
            if (version == null) {
                return defaultCode;
            } else {
                return version;
            }

        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return defaultCode;
        }

    }

    /**
     * 获得Uid
     *
     * @param packageName 包名
     * @param context
     * @return
     */
    public static int getUid(Context context, String packageName) {
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, PackageManager.GET_ACTIVITIES);
            return ai.uid;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 判断app是否安装
     *
     * @param context
     * @param packageName 包名
     * @return
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> info = packageManager.getInstalledPackages(0);
        List<String> pName = new ArrayList<>();
        if (info != null) {
            for (int i = 0; i < info.size(); i++) {
                String pn = info.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);
    }

    /**
     * 打开app
     *
     * @param context
     * @param packageName 包名
     */
    public static boolean openApp(Context context, String packageName) {
        if (isAppInstalled(context, packageName)) {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            context.startActivity(intent);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否安装目标应用
     * @param packageName 目标应用安装后的包名
     * @return 是否已安装目标应用
     */
    @Deprecated
    public  static boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }


    /**
     * 判断某个界面是否在前台</br>
     * 需要权限：android.permission.GET_TASKS
     * @param context
     * @param className
     *            某个界面名称
     */
    @Deprecated
    public static boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className)) {
            return false;
        }

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }
        return false;
    }

}
