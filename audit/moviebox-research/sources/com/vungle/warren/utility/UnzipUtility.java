package com.vungle.warren.utility;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class UnzipUtility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f62590a = "com.vungle.warren.utility.UnzipUtility";

    /* JADX INFO: compiled from: source.java */
    public static class ZipSecurityException extends IOException {
        public ZipSecurityException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean a(String str);
    }

    public static void a(InputStream inputStream, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        i.b(file);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i11 = inputStream.read(bArr);
                        if (i11 == -1) {
                            i.a(inputStream);
                            i.a(bufferedOutputStream2);
                            i.a(fileOutputStream);
                            return;
                        }
                        bufferedOutputStream2.write(bArr, 0, i11);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    i.a(inputStream);
                    i.a(bufferedOutputStream);
                    i.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static List<File> b(String str, String str2, a aVar) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new IOException("Path is empty");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdir();
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String str3 = str2 + File.separator + zipEntryNextElement.getName();
                    if (aVar == null || aVar.a(str3)) {
                        c(str3, str2);
                        if (zipEntryNextElement.isDirectory()) {
                            File file3 = new File(str3);
                            if (!file3.exists()) {
                                file3.mkdir();
                            }
                        } else {
                            a(zipFile2.getInputStream(zipEntryNextElement), str3);
                            arrayList.add(new File(str3));
                        }
                    }
                }
                try {
                    zipFile2.close();
                } catch (IOException unused) {
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String c(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath;
        }
        Log.e(f62590a, "File is outside extraction target directory.");
        throw new ZipSecurityException("File is outside extraction target directory.");
    }
}
