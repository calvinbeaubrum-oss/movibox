package com.transsnet.downloader.proxy;

import android.content.Context;
import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.q;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tr.g;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpProxyCacheServer f61108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadFileCache f61109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f61110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f61111d = "";

    public final void a(String resourceId, b callback) {
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(callback, "callback");
        DownloadFileCache downloadFileCache = this.f61109b;
        if (downloadFileCache != null) {
            downloadFileCache.e(resourceId, callback);
        }
    }

    public final void b() {
        DownloadFileCache downloadFileCache = this.f61109b;
        if (downloadFileCache != null) {
            downloadFileCache.B();
        }
    }

    public final void c() {
        HttpProxyCacheServer httpProxyCacheServer = this.f61108a;
        if (httpProxyCacheServer != null) {
            httpProxyCacheServer.g();
        }
    }

    public final DownloadBean d() {
        DownloadFileCache downloadFileCache;
        DownloadFileCache downloadFileCache2 = this.f61109b;
        if ((downloadFileCache2 == null || !downloadFileCache2.k()) && (downloadFileCache = this.f61109b) != null) {
            return downloadFileCache.h();
        }
        return null;
    }

    public final g e() {
        DownloadFileCache downloadFileCache = this.f61109b;
        if (downloadFileCache != null) {
            return downloadFileCache.i();
        }
        return null;
    }

    public final String f(DownloadBean bean) {
        DownloadFileCache downloadFileCache;
        Intrinsics.g(bean, "bean");
        DownloadFileCache downloadFileCache2 = this.f61109b;
        DownloadBean downloadBeanH = downloadFileCache2 != null ? downloadFileCache2.h() : null;
        if ((downloadBeanH == null || !Intrinsics.b(downloadBeanH.getResourceId(), bean.getResourceId())) && (downloadFileCache = this.f61109b) != null) {
            downloadFileCache.o(bean);
        }
        String resourceId = bean.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        this.f61111d = resourceId;
        HttpProxyCacheServer httpProxyCacheServer = this.f61108a;
        String strJ = httpProxyCacheServer != null ? httpProxyCacheServer.j(bean.getUrl(), bean.getPath(), true) : null;
        return strJ == null ? bean.getUrl() : strJ;
    }

    public final void g(Context context) {
        Intrinsics.g(context, "context");
        if (this.f61110c) {
            return;
        }
        this.f61110c = true;
        q.d(false);
        this.f61109b = new DownloadFileCache();
        this.f61108a = new HttpProxyCacheServer.a(context).c(new File(DownloadEsHelper.f60994m.a().d().getAbsolutePath())).d(this.f61109b).a();
    }

    public final void h() {
        this.f61111d = "";
        DownloadFileCache downloadFileCache = this.f61109b;
        if (downloadFileCache != null) {
            downloadFileCache.m();
        }
    }

    public final void i(String resourceId) {
        Intrinsics.g(resourceId, "resourceId");
        DownloadFileCache downloadFileCache = this.f61109b;
        if (downloadFileCache != null) {
            downloadFileCache.l(resourceId);
        }
    }

    public final void j(String contentType, String resourceId) {
        Intrinsics.g(contentType, "contentType");
        Intrinsics.g(resourceId, "resourceId");
        if (this.f61111d.length() <= 0 || Intrinsics.b(this.f61111d, resourceId)) {
            DownloadFileCache downloadFileCache = this.f61109b;
            if (downloadFileCache != null) {
                downloadFileCache.n(contentType);
            }
            q.a("setCurDownloadContentType, contentType = " + contentType);
        }
    }
}
