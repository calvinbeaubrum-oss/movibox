package com.cloud.h5update.utils;

import android.content.Context;
import android.os.Bundle;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.DownloadEntity;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.download.DownloadManager;
import com.cloud.h5update.download.DownloadTask;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.transsion.gslb.Worker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28906a = new a();

    /* JADX INFO: renamed from: com.cloud.h5update.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0318a implements l9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreloadResource f28907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<DownloadEntity> f28908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f28909c;

        public C0318a(PreloadResource preloadResource, Ref.ObjectRef<DownloadEntity> objectRef, Context context) {
            this.f28907a = preloadResource;
            this.f28908b = objectRef;
            this.f28909c = context;
        }

        @Override // l9.a
        public void a(DownloadTask downloadTask) {
            m9.b bVarJ = TH5Update.f28868c.j();
            if (bVarJ != null) {
                bVarJ.g(this.f28907a.getStaticZipUrl());
            }
        }

        @Override // l9.a
        public void b(DownloadTask downloadTask) {
            m9.b bVarJ = TH5Update.f28868c.j();
            if (bVarJ != null) {
                bVarJ.b(this.f28907a.getStaticZipUrl(), this.f28908b.element.getCompletedSize(), this.f28908b.element.getTotalSize());
            }
        }

        @Override // l9.a
        public void c(DownloadTask downloadTask) {
        }

        @Override // l9.a
        public void d(DownloadTask downloadTask, int i11) {
            m9.b bVarJ = TH5Update.f28868c.j();
            if (bVarJ != null) {
                String staticZipUrl = this.f28907a.getStaticZipUrl();
                Intrinsics.d(staticZipUrl);
                bVarJ.onError(staticZipUrl, Worker.WHAT_SYNC_DATA, "ERROR_DOWNLOAD");
            }
        }

        @Override // l9.a
        public void e(DownloadTask downloadTask) {
            new Bundle().putString("url", this.f28907a.getStaticZipUrl());
            TH5Update.a aVar = TH5Update.f28868c;
            m9.b bVarJ = aVar.j();
            if (bVarJ != null) {
                bVarJ.c(this.f28907a.getStaticZipUrl());
            }
            l.f28923a.n(this.f28909c, this.f28907a);
            aVar.i().put(this.f28907a.getStaticZipUrl(), Boolean.TRUE);
            aVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.cloud.h5update.bean.DownloadEntity] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.cloud.h5update.bean.DownloadEntity] */
    public final void a(Context context, PreloadResource preloadResource) {
        Intrinsics.g(context, "context");
        Intrinsics.g(preloadResource, "preloadResource");
        String staticZipUrl = preloadResource.getStaticZipUrl();
        if (staticZipUrl == null || kotlin.text.l.y(staticZipUrl)) {
            return;
        }
        l lVar = l.f28923a;
        String strI = lVar.i(preloadResource);
        DownloadManager.a aVar = DownloadManager.f28882g;
        DownloadTask downloadTaskH = aVar.a().h(strI);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new DownloadEntity(preloadResource.getEncryptedStaticZip(), staticZipUrl);
        C0318a c0318a = new C0318a(preloadResource, objectRef, context);
        if (downloadTaskH == null) {
            ((DownloadEntity) objectRef.element).setTaskId(strI);
            DownloadTask downloadTask = new DownloadTask((DownloadEntity) objectRef.element);
            downloadTask.setListener(c0318a);
            m9.b bVarJ = TH5Update.f28868c.j();
            if (bVarJ != null) {
                bVarJ.f(preloadResource.getStaticZipUrl());
            }
            new Bundle().putString("url", preloadResource.getStaticZipUrl());
            DownloadManager.c(aVar.a(), downloadTask, false, 2, null);
            return;
        }
        ?? downloadEntity = downloadTaskH.getDownloadEntity();
        if (downloadEntity == 0) {
        }
        objectRef.element = downloadEntity;
        downloadTaskH.setListener(c0318a);
        DownloadManager downloadManagerA = aVar.a();
        switch (downloadEntity.getTaskStatus()) {
            case 0:
                DownloadManager.c(downloadManagerA, downloadTaskH, false, 2, null);
                break;
            case 1:
                DownloadManager.c(downloadManagerA, downloadTaskH, false, 2, null);
                break;
            case 2:
                downloadManagerA.m(downloadTaskH);
                break;
            case 3:
                DownloadManager.c(downloadManagerA, downloadTaskH, false, 2, null);
                break;
            case 4:
                DownloadManager.c(downloadManagerA, downloadTaskH, false, 2, null);
                break;
            case 5:
                DownloadManager.c(downloadManagerA, downloadTaskH, false, 2, null);
                break;
            case 6:
                lVar.n(context, preloadResource);
                break;
        }
    }

    public final void b(String packageName, PreloadResource preloadResource) {
        Intrinsics.g(packageName, "packageName");
        Intrinsics.g(preloadResource, "preloadResource");
        String staticZipUrl = preloadResource.getStaticZipUrl();
        if (staticZipUrl == null || kotlin.text.l.y(staticZipUrl)) {
            return;
        }
        TH5Update.a aVar = TH5Update.f28868c;
        m9.b bVarJ = aVar.j();
        if (bVarJ != null) {
            String url = preloadResource.getUrl();
            if (url == null) {
                url = "";
            }
            if (!bVarJ.h(packageName, url, preloadResource.getStaticZipUrl())) {
                return;
            }
        }
        Context contextC = aVar.c();
        if (!kotlin.text.l.L(staticZipUrl, "http://", false, 2, null) && !kotlin.text.l.L(staticZipUrl, AgentPageJsBridge.HTTPS, false, 2, null)) {
            po.b.f73956a.c("error url :" + staticZipUrl);
            m9.b bVarJ2 = aVar.j();
            if (bVarJ2 != null) {
                String staticZipUrl2 = preloadResource.getStaticZipUrl();
                Intrinsics.d(staticZipUrl2);
                bVarJ2.onError(staticZipUrl2, 101, "ERROR_PARAMS");
                return;
            }
            return;
        }
        if (kotlin.text.l.u(staticZipUrl, ".zip", false, 2, null)) {
            a(contextC, preloadResource);
            return;
        }
        po.b.f73956a.c("error url :" + staticZipUrl);
        m9.b bVarJ3 = aVar.j();
        if (bVarJ3 != null) {
            String staticZipUrl3 = preloadResource.getStaticZipUrl();
            Intrinsics.d(staticZipUrl3);
            bVarJ3.onError(staticZipUrl3, 101, "ERROR_PARAMS");
        }
    }
}
