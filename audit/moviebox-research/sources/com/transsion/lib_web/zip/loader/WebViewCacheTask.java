package com.transsion.lib_web.zip.loader;

import android.content.Context;
import com.transsion.lib_web.zip.db.WebViewCacheConfigData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.w0;
import okhttp3.Response;
import okhttp3.ResponseBody;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class WebViewCacheTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebViewCacheConfigData f53081b;

    public WebViewCacheTask(Context context, WebViewCacheConfigData dbItem) {
        Intrinsics.g(context, "context");
        Intrinsics.g(dbItem, "dbItem");
        this.f53080a = context;
        this.f53081b = dbItem;
    }

    public final Object d(WebViewCacheConfigData webViewCacheConfigData, File file, Continuation<? super File> continuation) {
        String zipUrl = webViewCacheConfigData != null ? webViewCacheConfigData.getZipUrl() : null;
        if (zipUrl == null || zipUrl.length() == 0) {
            return null;
        }
        return h.g(w0.b(), new WebViewCacheTask$downloadAndExtractZip$2(zipUrl, this, file, null), continuation);
    }

    public final File e(Response response, File file) throws IOException {
        InputStream inputStreamByteStream;
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null || (inputStreamByteStream = responseBodyBody.byteStream()) == null) {
            return null;
        }
        ZipInputStream zipInputStream = new ZipInputStream(inputStreamByteStream);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
            File file2 = new File(file, nextEntry.getName());
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i11 = zipInputStream.read(bArr);
                        if (i11 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i11);
                    }
                    Unit unit = Unit.f68710a;
                    CloseableKt.a(fileOutputStream, null);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(fileOutputStream, th2);
                        throw th3;
                    }
                }
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
        return file;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewCacheTask)) {
            return false;
        }
        WebViewCacheTask webViewCacheTask = (WebViewCacheTask) obj;
        return Intrinsics.b(this.f53080a, webViewCacheTask.f53080a) && Intrinsics.b(this.f53081b, webViewCacheTask.f53081b);
    }

    public final String f() {
        String simpleName = WebViewCacheTask.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Context g() {
        return this.f53080a;
    }

    public final WebViewCacheConfigData h() {
        return this.f53081b;
    }

    public int hashCode() {
        return (this.f53080a.hashCode() * 31) + this.f53081b.hashCode();
    }

    public final Object i(Continuation<? super Unit> continuation) {
        Object objG = h.g(w0.b(), new WebViewCacheTask$start$2(this, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public String toString() {
        return "WebViewCacheTask(context=" + this.f53080a + ", dbItem=" + this.f53081b + ")";
    }
}
