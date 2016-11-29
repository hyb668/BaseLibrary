package com.gosuncn.core.util.storage;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import static com.gosuncn.core.util.device.SDCardUtils.existsSdcard;

public class FileUtils {
    /**
     * 删除文件(包括目录)
     *
     * @param file
     */
    public static void deleteAll(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }

        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                file.delete();
                return;
            }

            for (int i = 0; i < childFiles.length; i++) {
                deleteAll(childFiles[i]);
            }
            file.delete();
        }
    }


    /**
     * 删除文件(不包括目录)
     *
     * @param file
     */
    public static void delete(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();

            for (int i = 0; i < childFiles.length; i++) {
                delete(childFiles[i]);
            }
        }
    }

    /**
     * 删除多个文件
     * @param files
     */
    public static void delete(File[] files) {

        for (int i = 0; files != null && i < files.length; i++) {
            if (files[i].isFile()) {
                files[i].delete();
            }

            if (files[i].isDirectory()) {
                File[] childFiles = files[i].listFiles();
                if (childFiles == null || childFiles.length == 0) {
                    files[i].delete();
                }

                for (int j = 0; childFiles != null && j < childFiles.length; j++) {
                    delete(childFiles[j]);
                }
                files[i].delete();
            }
        }
    }

    /**
     * 检查磁盘空间是否大于10mb
     * @param  dSize  大小
     * @return true
     */
    public static boolean isDiskAvailable(int  dSize) {
        long size = getDiskAvailableSize();
        return size > dSize * 1024 * 1024; // > 10bm
    }

    /**
     * 获取磁盘可用空间
     *
     * @return byte 单位 kb
     */
    public static long getDiskAvailableSize() {
        if (!existsSdcard()) return 0;
        File path = Environment.getExternalStorageDirectory(); // 取得sdcard文件路径
        StatFs stat = new StatFs(path.getAbsolutePath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
        // (availableBlocks * blockSize)/1024 KIB 单位
        // (availableBlocks * blockSize)/1024 /1024 MIB单位
    }



    /**
     * 获得文件或目录大小
     * @param file
     * @return
     */
    public static long getFileOrDirSize(File file) {
        if (!file.exists()) return 0;
        if (!file.isDirectory()) return file.length();

        long length = 0;
        File[] list = file.listFiles();
        if (list != null) { // 文件夹被删除时, 子文件正在被写入, 文件属性异常返回null.
            for (File item : list) {
                length += getFileOrDirSize(item);
            }
        }

        return length;
    }

    /**
     * 创建文件并获取路径
     */
    public static String getPath(String FileDir,String FileName) {
        if (TextUtils.isEmpty(FileName)) {
            return null;
        }
        File dir = new File(FileDir);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }

        File file = new File(dir, FileName);
        if (!file.exists() || !file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Log.e("文件创建失败",e.getMessage());
                return null;
            }
        }
        return file.getPath();
    }

    /**
     * 创建文件并获取文件
     */
    public static File getFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 创建文件根目录
     */
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
