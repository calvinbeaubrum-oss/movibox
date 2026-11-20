package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.TRI$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File file, File file2) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class sc implements Comparator<File> {
        private sc() {
        }

        public /* synthetic */ sc(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int sc(long j11, long j12) {
            if (j11 < j12) {
                return -1;
            }
            return j11 == j12 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return sc(file.lastModified(), file2.lastModified());
        }
    }

    private static void ExN(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            TRI(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            long j11 = length - 1;
            try {
                randomAccessFile.seek(j11);
                byte b11 = randomAccessFile.readByte();
                randomAccessFile.seek(j11);
                randomAccessFile.write(b11);
                randomAccessFile.close();
            } catch (Throwable unused) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
    }

    private static void TRI(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    public static byte[] We(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long lValueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    private static String pFF(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static void pFF(File file) throws IOException {
        if (file.exists()) {
            Tf.sc("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            ExN(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                new Date(file.lastModified()).toString();
                file.getAbsolutePath();
            }
        }
    }

    public static File sc(Context context, boolean z11, String str) {
        String absolutePath = context.getCacheDir().getAbsolutePath();
        if (z11) {
            str = sc(context) + "-" + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = absolutePath + str2;
            }
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File sc(Context context, boolean z11, String str, String str2) {
        String strPFF = pFF(context);
        if (z11) {
            str = sc(context) + "-" + str;
        }
        if (strPFF != null) {
            String str3 = File.separator;
            if (!strPFF.endsWith(str3)) {
                strPFF = strPFF + str3;
            }
        }
        String str4 = strPFF + str;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    public static String sc(Context context) {
        String strSc = wjp.sc(context);
        return (TextUtils.isEmpty(strSc) || !strSc.contains(":")) ? strSc : strSc.replace(":", "-");
    }

    public static List<File> sc(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new sc(null));
        return listAsList;
    }

    public static void zY(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            try {
                file.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    zY(file2);
                } else {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        try {
            file.delete();
        } catch (Throwable unused3) {
        }
    }
}
