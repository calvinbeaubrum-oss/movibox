package com.transsion.subtitle_download.utils;

import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.l;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.io.File;
import java.util.Locale;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f58376a = new c();

    public final void a(String directoryPath) {
        Intrinsics.g(directoryPath, "directoryPath");
        File file = new File(directoryPath);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public final void b(String str) {
        Object objM163constructorimpl;
        String str2;
        try {
            Result.Companion companion = Result.Companion;
            File file = new File(str == null ? "" : str);
            if (file.exists()) {
                str2 = file.delete() ? "文件删除成功" : "文件删除失败";
            } else {
                str2 = "文件不存在";
            }
            b.f58375a.a(f58376a.d() + " --> deleteFile() --> " + str2 + " --> path = " + str);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        b.f58375a.b(f58376a.d() + " --> deleteFile() --> 删除文件发生异常 --> it = " + thM166exceptionOrNullimpl);
    }

    public final String c(int i11) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public final String d() {
        String simpleName = c.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final String e() {
        return "en";
    }

    public final String f() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            String string = RoomAppMMKV.f51271a.a().getString("k_language_short_name", null);
            Locale locale = Build.VERSION.SDK_INT >= 24 ? Utils.a().getResources().getConfiguration().getLocales().get(0) : Utils.a().getResources().getConfiguration().locale;
            objM163constructorimpl = Result.m163constructorimpl((Intrinsics.b(locale.getLanguage(), string) || string == null || string.length() <= 0) ? locale.getLanguage() : new Locale(string, locale.getCountry()).getLanguage());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = "";
        }
        return (String) objM163constructorimpl;
    }

    public final String g() {
        return qp.a.f74869a.a(System.currentTimeMillis() + c(10));
    }

    public final boolean h(String str) {
        if (str != null) {
            return new File(str).exists();
        }
        return false;
    }

    public final boolean i(SubtitleDownloadTable subtitleBean) {
        Intrinsics.g(subtitleBean, "subtitleBean");
        String path = subtitleBean.getPath();
        if (path == null) {
            path = "";
        }
        if (!new File(path).exists()) {
            return false;
        }
        try {
            String path2 = subtitleBean.getPath();
            Intrinsics.d(path2);
            String fileCharsetName = s10.a.b(l.b(path2), true);
            b.f58375a.a(d() + " --> parseFileCharsetName() --> fileCharsetName = " + fileCharsetName);
            Intrinsics.f(fileCharsetName, "fileCharsetName");
            if (fileCharsetName.length() > 0) {
                subtitleBean.setFileCharsetName(fileCharsetName);
            }
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }
}
