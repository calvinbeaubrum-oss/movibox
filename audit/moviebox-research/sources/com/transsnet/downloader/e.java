package com.transsnet.downloader;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsnet.downloader.util.DocumentsUtils;
import com.vungle.warren.error.VungleException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f60605a = new e();

    public static final void l(String path, Uri uri) {
        Intrinsics.g(path, "path");
        Intrinsics.g(uri, "uri");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("saveVideoToAlbum: ");
        sb2.append(path);
        sb2.append(" ");
        sb2.append(uri);
    }

    public final String b(String str) {
        try {
            if (!new File(str).exists()) {
                uo.b.f78622a.c("resource_save", "是否有相同文件，exists = false", true);
                return str;
            }
            uo.b.f78622a.c("resource_save", "是否有相同文件，exists = true", true);
            String str2 = InstructionFileId.DOT + StringsKt__StringsKt.R0(StringsKt__StringsKt.V0(str, "?", null, 2, null), InstructionFileId.DOT, null, 2, null);
            String str3 = "_" + new SimpleDateFormat("yyMMddHHmmss").format(Long.valueOf(System.currentTimeMillis())) + str2;
            uo.b.f78622a.c("resource_save", "有相同文件，加个后缀下载, fileSuffix = " + str2 + ", newFileSuffix = " + str3, true);
            return l.F(str, str2, str3, false, 4, null);
        } catch (Throwable th2) {
            uo.b.f78622a.c("resource_save", "是否有相同文件，报错， = " + th2, true);
            th2.printStackTrace();
        }
    }

    public final void c(Context context, ContentResolver contentResolver, File file, Uri uri, Function2<? super Long, ? super Long, Unit> function2) throws IOException {
        if (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return;
        }
        Intrinsics.d(uri);
        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
        FileInputStream fileInputStream = new FileInputStream(file);
        long length = file.length();
        byte[] bArr = new byte[65536];
        long j11 = 0;
        while (true) {
            int i11 = fileInputStream.read(bArr);
            if (i11 <= 0) {
                break;
            }
            if (outputStreamOpenOutputStream != null) {
                outputStreamOpenOutputStream.write(bArr, 0, i11);
            }
            j11 += (long) i11;
            function2.invoke(Long.valueOf(j11), Long.valueOf(length));
        }
        fileInputStream.close();
        if (outputStreamOpenOutputStream != null) {
            outputStreamOpenOutputStream.close();
        }
    }

    public final boolean d(Context context, String oldPath) {
        Intrinsics.g(context, "context");
        Intrinsics.g(oldPath, "oldPath");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "resource_save", "deleteAlbumAfterQ oldPath = " + oldPath + "， where = _data=?", false, 4, null);
            int iDelete = contentResolver.delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{oldPath});
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleteAlbumAfterQ row = ");
            sb2.append(iDelete);
            aVar.c("resource_save", sb2.toString(), true);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final boolean e(Context context, String oldPath) {
        Intrinsics.g(context, "context");
        Intrinsics.g(oldPath, "oldPath");
        try {
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "resource_save", "deleteSDCardAfterQ oldPath = " + oldPath, false, 4, null);
            ContentResolver contentResolver = context.getContentResolver();
            List<Uri> listF = f(context);
            if (listF != null && (!listF.isEmpty())) {
                aVar.c("resource_save", "deleteSDCardAfterQ row = " + contentResolver.delete(listF.get(0), "_data=?", new String[]{oldPath}), true);
                return true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final List<Uri> f(Context context) {
        ArrayList arrayList = new ArrayList();
        Set<String> externalVolumeNames = MediaStore.getExternalVolumeNames(context);
        Intrinsics.f(externalVolumeNames, "getExternalVolumeNames(context)");
        for (String entry : externalVolumeNames) {
            if (!Intrinsics.b(entry, "external_primary")) {
                Intrinsics.f(entry, "entry");
                arrayList.add(0, entry);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Uri contentUri = MediaStore.Downloads.getContentUri((String) it.next());
            Intrinsics.f(contentUri, "getContentUri(entry)");
            arrayList2.add(contentUri);
        }
        return arrayList2;
    }

    public final ContentValues g(Context context, File paramFile, String newName, long j11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(paramFile, "paramFile");
        Intrinsics.g(newName, "newName");
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", tr.b.f77264a.e());
        }
        if (newName.length() == 0) {
            newName = paramFile.getName();
        }
        contentValues.put(CampaignEx.JSON_KEY_TITLE, newName);
        contentValues.put("_display_name", newName);
        contentValues.put("mime_type", MimeTypes.VIDEO_MP4);
        contentValues.put("datetaken", Long.valueOf(j11));
        contentValues.put("date_modified", Long.valueOf(j11));
        contentValues.put("date_added", Long.valueOf(j11));
        contentValues.put("_size", Long.valueOf(paramFile.length()));
        return contentValues;
    }

    public final ContentValues h(Context context, File paramFile, String newName, long j11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(paramFile, "paramFile");
        Intrinsics.g(newName, "newName");
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + File.separator + context.getResources().getString(com.transsion.baseui.R$string.base_app_name));
        }
        if (newName.length() == 0) {
            newName = paramFile.getName();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getVideoContentValues title = ");
        sb2.append(newName);
        contentValues.put(CampaignEx.JSON_KEY_TITLE, newName);
        contentValues.put("_display_name", newName);
        contentValues.put("mime_type", MimeTypes.VIDEO_MP4);
        contentValues.put("datetaken", Long.valueOf(j11));
        contentValues.put("date_modified", Long.valueOf(j11));
        contentValues.put("date_added", Long.valueOf(j11));
        contentValues.put("_size", Long.valueOf(paramFile.length()));
        return contentValues;
    }

    public final boolean i(Context context, String videoFile, String beforeRootPath, Function2<? super Long, ? super Long, Unit> callback, Function1<? super String, Unit> function1) {
        Intrinsics.g(context, "context");
        Intrinsics.g(videoFile, "videoFile");
        Intrinsics.g(beforeRootPath, "beforeRootPath");
        Intrinsics.g(callback, "callback");
        uo.b.f78622a.c("resource_save", "saveVideoToAlbum() videoFile = [" + videoFile + "]", true);
        return Build.VERSION.SDK_INT < 29 ? k(context, videoFile, callback, function1) : j(context, videoFile, beforeRootPath, callback, function1);
    }

    public final boolean j(Context context, String str, String str2, Function2<? super Long, ? super Long, Unit> function2, Function1<? super String, Unit> function1) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String strF = l.F(str, str2, tr.b.f77264a.a(), false, 4, null);
            try {
                String strB = b(strF);
                uo.b.f78622a.c("resource_save", "saveVideoToAlbumAfterQ targetPath = " + strF + ", beforeRootPath = " + str2, true);
                String strR0 = StringsKt__StringsKt.R0(strB, "/", null, 2, null);
                if (function1 != null) {
                    function1.invoke(strB);
                }
                File file = new File(str);
                ContentValues contentValuesH = h(context, file, strR0, System.currentTimeMillis());
                Uri uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValuesH);
                Intrinsics.f(contentResolver, "contentResolver");
                c(context, contentResolver, file, uriInsert, function2);
                contentValuesH.clear();
                contentValuesH.put("is_pending", (Integer) 0);
                ContentResolver contentResolver2 = context.getContentResolver();
                Intrinsics.d(uriInsert);
                contentResolver2.update(uriInsert, contentValuesH, null, null);
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uriInsert));
                return true;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                uo.b.f78622a.h("resource_save", "saveVideoToAlbumAfterQ error = " + th, true);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x017c A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #5 {all -> 0x0178, blocks: (B:74:0x0174, B:78:0x017c), top: B:86:0x0174 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean k(Context context, String str, Function2<? super Long, ? super Long, Unit> function2, Function1<? super String, Unit> function1) throws Throwable {
        Throwable th2;
        BufferedOutputStream bufferedOutputStream;
        long length;
        File parentFile;
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File file = new File(str);
        InputStream inputStream = null;
        boolean zL = l.L(str, AppLovinEventTypes.USER_VIEWED_CONTENT, false, 2, null);
        String strR0 = zL ? StringsKt__StringsKt.R0(str, "%2F", null, 2, null) : file.getName();
        String absolutePath = externalStoragePublicDirectory.getAbsolutePath();
        String str2 = File.separator;
        String strB = b(absolutePath + str2 + context.getResources().getString(com.transsion.baseui.R$string.base_app_name) + str2 + strR0);
        if (function1 != null) {
            function1.invoke(strB);
        }
        File file2 = new File(strB);
        uo.b.f78622a.c("resource_save", "saveVideoToAlbumBeforeQ, isUri = " + zL + ",newPath = " + strB, true);
        try {
            File parentFile2 = file2.getParentFile();
            if ((parentFile2 == null || !parentFile2.exists()) && (parentFile = file2.getParentFile()) != null) {
                parentFile.mkdirs();
            }
        } catch (Throwable th3) {
            uo.b.f78622a.t("resource_save", "saveVideoToAlbumBeforeQ, mkdirs fail, e = " + th3, true);
            th3.printStackTrace();
        }
        long j11 = 0;
        try {
            if (zL) {
                l3.a aVarG = l3.a.g(context, Uri.parse(str));
                length = aVarG != null ? aVarG.k() : 0L;
            } else {
                length = file.length();
            }
            InputStream inputStreamOpenInputStream = zL ? context.getContentResolver().openInputStream(Uri.parse(str)) : new FileInputStream(file);
            if (inputStreamOpenInputStream == null) {
                return false;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int i11 = inputStreamOpenInputStream.read(bArr);
                        if (i11 <= 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, i11);
                        j11 += (long) i11;
                        function2.invoke(Long.valueOf(j11), Long.valueOf(length));
                    }
                    MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, new String[]{"video/*"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.transsnet.downloader.d
                        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                        public final void onScanCompleted(String str3, Uri uri) {
                            e.l(str3, uri);
                        }
                    });
                    try {
                        inputStreamOpenInputStream.close();
                        bufferedOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    return true;
                } catch (Exception e11) {
                    e = e11;
                    inputStream = inputStreamOpenInputStream;
                    try {
                        e.printStackTrace();
                        uo.b.f78622a.h("resource_save", "saveVideoToAlbumBeforeQ, save fail, e = " + e, true);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                                return false;
                            }
                        }
                        if (bufferedOutputStream == null) {
                            return false;
                        }
                        bufferedOutputStream.close();
                        return false;
                    } catch (Throwable th6) {
                        th2 = th6;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                                throw th2;
                            }
                        }
                        if (bufferedOutputStream != null) {
                            throw th2;
                        }
                        bufferedOutputStream.close();
                        throw th2;
                    }
                } catch (Throwable th8) {
                    th2 = th8;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        throw th2;
                    }
                    bufferedOutputStream.close();
                    throw th2;
                }
            } catch (Exception e12) {
                e = e12;
                bufferedOutputStream = null;
            } catch (Throwable th9) {
                th2 = th9;
                bufferedOutputStream = null;
            }
        } catch (Exception e13) {
            e = e13;
            bufferedOutputStream = null;
        } catch (Throwable th10) {
            th2 = th10;
            bufferedOutputStream = null;
        }
    }

    public final boolean m(Context context, String videoFile, String beforeRootPath, String targetRootPath, Function2<? super Long, ? super Long, Unit> callback, Function1<? super String, Unit> function1) {
        Intrinsics.g(context, "context");
        Intrinsics.g(videoFile, "videoFile");
        Intrinsics.g(beforeRootPath, "beforeRootPath");
        Intrinsics.g(targetRootPath, "targetRootPath");
        Intrinsics.g(callback, "callback");
        uo.b.f78622a.c("resource_save", "saveVideoToSDCard() videoFile = [" + videoFile + "]", true);
        return Build.VERSION.SDK_INT < 29 ? o(context, videoFile, targetRootPath, callback, function1) : n(context, videoFile, beforeRootPath, targetRootPath, callback, function1);
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final boolean n(Context context, String str, String str2, String str3, Function2<? super Long, ? super Long, Unit> function2, Function1<? super String, Unit> function1) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String strF = l.F(str, str2, str3, false, 4, null);
            uo.b.a.f(uo.b.f78622a, "resource_save", "saveVideoToSDCardAfterQ targetPath = " + strF + ", beforeRootPath = " + str2 + ", targetRootPath = " + str3, false, 4, null);
            try {
                String strB = b(strF);
                String strR0 = StringsKt__StringsKt.R0(strB, "/", null, 2, null);
                if (function1 != null) {
                    function1.invoke(strB);
                }
                File file = new File(str);
                ContentValues contentValuesG = g(context, file, strR0, System.currentTimeMillis());
                List<Uri> listF = f(context);
                if (listF == null || !(!listF.isEmpty())) {
                    return false;
                }
                Uri uriInsert = contentResolver.insert(listF.get(0), contentValuesG);
                Intrinsics.f(contentResolver, "contentResolver");
                c(context, contentResolver, file, uriInsert, function2);
                contentValuesG.clear();
                contentValuesG.put("is_pending", (Integer) 0);
                ContentResolver contentResolver2 = context.getContentResolver();
                Intrinsics.d(uriInsert);
                contentResolver2.update(uriInsert, contentValuesG, null, null);
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uriInsert));
                return true;
            } catch (Throwable th2) {
                th = th2;
                uo.b.f78622a.h("resource_save", "saveVideoToSDCardAfterQ error = " + th, true);
                th.printStackTrace();
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0175 A[DONT_GENERATE, DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0177 A[Catch: all -> 0x0173, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {all -> 0x0173, blocks: (B:56:0x016f, B:60:0x0177), top: B:82:0x016f }] */
    /* JADX WARN: Code duplicated, block: B:82:0x016f A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean o(Context context, String str, String str2, Function2<? super Long, ? super Long, Unit> function2, Function1<? super String, Unit> function1) {
        BufferedOutputStream bufferedOutputStream;
        long j11;
        long length;
        InputStream inputStreamOpenInputStream;
        byte[] bArr;
        File parentFile;
        Log.e("resource_save", "videoFile:" + str);
        File file = new File(str);
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            String it = file.getName();
            Intrinsics.f(it, "it");
            if (StringsKt__StringsKt.Q(it, "%2F", false, 2, null)) {
                it = it.substring(StringsKt__StringsKt.j0(it, "%2F", 0, false, 6, null) + 3);
                Intrinsics.f(it, "substring(...)");
            }
            try {
                String strB = b(str2 + File.separator + it);
                uo.b.f78622a.c("resource_save", "targetRootPath = " + str2 + ", targetPath = " + it + " newPath:" + strB, true);
                File file2 = new File(strB);
                try {
                    File parentFile2 = file2.getParentFile();
                    if ((parentFile2 == null || !parentFile2.exists()) && (parentFile = file2.getParentFile()) != null) {
                        parentFile.mkdirs();
                    }
                    while (true) {
                        Intrinsics.d(inputStreamOpenInputStream);
                        int i11 = inputStreamOpenInputStream.read(bArr);
                        if (i11 <= 0) {
                            try {
                                inputStreamOpenInputStream.close();
                                bufferedOutputStream2.close();
                                return true;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                return true;
                            }
                        }
                        bufferedOutputStream2.write(bArr, 0, i11);
                        j11 += (long) i11;
                        function2.invoke(Long.valueOf(j11), Long.valueOf(length));
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                j11 = 0;
                if (l.L(str, "content://", false, 2, null)) {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
                    if (inputStreamOpenInputStream != null) {
                        try {
                            length = inputStreamOpenInputStream.available();
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream = bufferedOutputStream2;
                            inputStream = inputStreamOpenInputStream;
                            try {
                                th.printStackTrace();
                                uo.b.f78622a.t("resource_save", "saveVideoToSDCardBeforeQ, save fail, e = " + th, true);
                                if (inputStream != null) {
                                    try {
                                    } catch (Throwable th5) {
                                        return false;
                                    }
                                }
                                return false;
                            } finally {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th6) {
                                        th6.printStackTrace();
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                            }
                        }
                    } else {
                        length = 0;
                    }
                } else {
                    InputStream inputStreamH = DocumentsUtils.f61126a.h(context, file);
                    try {
                        length = file.length();
                        inputStreamOpenInputStream = inputStreamH;
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedOutputStream = null;
                        inputStream = inputStreamH;
                        th.printStackTrace();
                        uo.b.f78622a.t("resource_save", "saveVideoToSDCardBeforeQ, save fail, e = " + th, true);
                        return false;
                    }
                }
                Log.e("resource_save", "videoFile:" + str + "  fileSize:" + length);
                bufferedOutputStream2 = Build.VERSION.SDK_INT < 23 ? new BufferedOutputStream(new FileOutputStream(file2)) : new BufferedOutputStream(DocumentsUtils.f61126a.i(context, file2, function1));
                bArr = new byte[65536];
            } catch (Throwable th8) {
                th = th8;
                bufferedOutputStream = null;
                th.printStackTrace();
                uo.b.f78622a.t("resource_save", "saveVideoToSDCardBeforeQ, save fail, e = " + th, true);
                return false;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }
}
