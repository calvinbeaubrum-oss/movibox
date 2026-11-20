package com.cloud.tmc.miniutils.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d0 {
    /* JADX WARN: Code duplicated, block: B:37:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.InputStream] */
    public static File a(Uri uri) throws Throwable {
        Throwable th2;
        InputStream inputStreamOpenInputStream;
        try {
            try {
                inputStreamOpenInputStream = e0.a().getContentResolver().openInputStream(uri);
                try {
                    File file = new File(e0.a().getCacheDir(), "" + System.currentTimeMillis());
                    h0.B(file.getAbsolutePath(), inputStreamOpenInputStream);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    return file;
                } catch (FileNotFoundException e12) {
                    e = e12;
                    e.printStackTrace();
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (uri != 0) {
                    try {
                        uri.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (FileNotFoundException e15) {
            e = e15;
            inputStreamOpenInputStream = null;
        } catch (Throwable th4) {
            th2 = th4;
            uri = 0;
            if (uri != 0) {
                uri.close();
            }
            throw th2;
        }
    }

    public static File b(Uri uri, String str) {
        return c(uri, null, null, str);
    }

    public static File c(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor cursorQuery = e0.a().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (cursorQuery == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(uri.toString());
                sb2.append(" parse failed(cursor is null). -> ");
                sb2.append(str2);
                return null;
            }
            if (!cursorQuery.moveToFirst()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(uri.toString());
                sb3.append(" parse failed(moveToFirst return false). -> ");
                sb3.append(str2);
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex > -1) {
                return new File(cursorQuery.getString(columnIndex));
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(uri.toString());
            sb4.append(" parse failed(columnIndex: ");
            sb4.append(columnIndex);
            sb4.append(" is wrong). -> ");
            sb4.append(str2);
            return null;
        } catch (Exception unused) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(uri.toString());
            sb5.append(" parse failed. -> ");
            sb5.append(str2);
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public static File d(Uri uri) {
        if (uri == null) {
            return null;
        }
        File fileE = e(uri);
        return fileE != null ? fileE : a(uri);
    }

    public static File e(Uri uri) {
        Uri uri2;
        String str;
        File file;
        uri.toString();
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (Build.VERSION.SDK_INT >= 24 && path != null) {
            String[] strArr = {"/external/", "/external_path/"};
            for (int i11 = 0; i11 < 2; i11++) {
                String str2 = strArr[i11];
                if (path.startsWith(str2)) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace(str2, "/"));
                    if (file2.exists()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(uri.toString());
                        sb2.append(" -> ");
                        sb2.append(str2);
                        return file2;
                    }
                }
            }
            if (path.startsWith("/files_path/")) {
                file = new File(e0.a().getFilesDir().getAbsolutePath() + path.replace("/files_path/", "/"));
            } else if (path.startsWith("/cache_path/")) {
                file = new File(e0.a().getCacheDir().getAbsolutePath() + path.replace("/cache_path/", "/"));
            } else if (path.startsWith("/external_files_path/")) {
                file = new File(e0.a().getExternalFilesDir(null).getAbsolutePath() + path.replace("/external_files_path/", "/"));
            } else if (path.startsWith("/external_cache_path/")) {
                file = new File(e0.a().getExternalCacheDir().getAbsolutePath() + path.replace("/external_cache_path/", "/"));
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(uri.toString());
                sb3.append(" -> ");
                sb3.append(path);
                return file;
            }
        }
        if ("file".equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(uri.toString());
            sb4.append(" parse failed. -> 0");
            return null;
        }
        if (!DocumentsContract.isDocumentUri(e0.a(), uri)) {
            if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
                return b(uri, "2");
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(uri.toString());
            sb5.append(" parse failed. -> 3");
            return null;
        }
        if ("com.android.externalstorage.documents".equals(authority)) {
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
            String str3 = strArrSplit[0];
            if ("primary".equalsIgnoreCase(str3)) {
                return new File(Environment.getExternalStorageDirectory() + "/" + strArrSplit[1]);
            }
            StorageManager storageManager = (StorageManager) e0.a().getSystemService(PlaceTypes.STORAGE);
            try {
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                Method method2 = cls.getMethod("getUuid", new Class[0]);
                Method method3 = cls.getMethod("getState", new Class[0]);
                Method method4 = cls.getMethod("getPath", new Class[0]);
                Method method5 = cls.getMethod("isPrimary", new Class[0]);
                Method method6 = cls.getMethod("isEmulated", new Class[0]);
                Object objInvoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(objInvoke);
                for (int i12 = 0; i12 < length; i12++) {
                    Object obj = Array.get(objInvoke, i12);
                    if ("mounted".equals(method3.invoke(obj, new Object[0])) || "mounted_ro".equals(method3.invoke(obj, new Object[0]))) {
                        if ((!((Boolean) method5.invoke(obj, new Object[0])).booleanValue() || !((Boolean) method6.invoke(obj, new Object[0])).booleanValue()) && (str = (String) method2.invoke(obj, new Object[0])) != null && str.equals(str3)) {
                            return new File(method4.invoke(obj, new Object[0]) + "/" + strArrSplit[1]);
                        }
                    }
                }
            } catch (Exception e11) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(uri.toString());
                sb6.append(" parse failed. ");
                sb6.append(e11.toString());
                sb6.append(" -> 1_0");
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(uri.toString());
            sb7.append(" parse failed. -> 1_0");
            return null;
        }
        if (!"com.android.providers.downloads.documents".equals(authority)) {
            if (!"com.android.providers.media.documents".equals(authority)) {
                if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
                    return b(uri, "1_3");
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append(uri.toString());
                sb8.append(" parse failed. -> 1_4");
                return null;
            }
            String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
            String str4 = strArrSplit2[0];
            if ("image".equals(str4)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str4)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                if (!MimeTypes.BASE_TYPE_AUDIO.equals(str4)) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(uri.toString());
                    sb9.append(" parse failed. -> 1_2");
                    return null;
                }
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return c(uri2, "_id=?", new String[]{strArrSplit2[1]}, "1_2");
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        if (TextUtils.isEmpty(documentId)) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(uri.toString());
            sb10.append(" parse failed(id is null). -> 1_1");
            return null;
        }
        if (documentId.startsWith("raw:")) {
            return new File(documentId.substring(4));
        }
        if (documentId.startsWith("msf:")) {
            documentId = documentId.split(":")[1];
        }
        try {
            long j11 = Long.parseLong(documentId);
            String[] strArr2 = {"content://downloads/public_downloads", "content://downloads/all_downloads", "content://downloads/my_downloads"};
            for (int i13 = 0; i13 < 3; i13++) {
                try {
                    File fileB = b(ContentUris.withAppendedId(Uri.parse(strArr2[i13]), j11), "1_1");
                    if (fileB != null) {
                        return fileB;
                    }
                } catch (Exception e12) {
                    Log.e("UriUtils", "uri2FileReal: ", e12);
                }
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append(uri.toString());
            sb11.append(" parse failed. -> 1_1");
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
