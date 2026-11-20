package wd;

import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.model.DeliveryDimensionData;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import com.cloud.tmc.offline.download.utils.OfflineUtils;
import com.cloud.tmc.offline.download.utils.g;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m9.b;

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
@SourceDebugExtension
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0887a f79412b = new C0887a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vd.b f79413a;

    /* JADX INFO: renamed from: wd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0887a {
        public C0887a() {
        }

        public /* synthetic */ C0887a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(vd.b bVar) {
        this.f79413a = bVar;
    }

    public /* synthetic */ a(vd.b bVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bVar);
    }

    @Override // m9.b
    public void a(String url) {
        Intrinsics.g(url, "url");
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onNoNeedDownload: " + url);
        vd.b bVar = this.f79413a;
        if (bVar != null) {
            bVar.a(url);
        }
    }

    @Override // m9.b
    public void b(String url, long j11, long j12) {
        String str;
        Intrinsics.g(url, "url");
        try {
            str = new DecimalFormat("#.##").format((j11 / j12) * ((double) 100)) + '%';
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: UpdateListenerImpl", "onDownloadProcess failed!", th2);
            str = "0%";
        }
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onDownloadProcess: " + url + ", percentage: " + str + ", size: " + de.a.a(j11) + ", totoalSize: " + de.a.a(j12));
        vd.b bVar = this.f79413a;
        if (bVar != null) {
            bVar.b(url, j11, j12);
        }
    }

    @Override // m9.b
    public void c(String url) {
        Intrinsics.g(url, "url");
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onZipDownloadFinish: " + url);
        vd.b bVar = this.f79413a;
        if (bVar != null) {
            bVar.c(url);
        }
    }

    @Override // m9.b
    public boolean d(String url) {
        Intrinsics.g(url, "url");
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onZipDownloaded: " + url);
        vd.b bVar = this.f79413a;
        if (bVar == null) {
            return true;
        }
        bVar.d(url);
        return true;
    }

    @Override // m9.b
    public void e(String url, String zipUnCompressPath, File zipFile) {
        Intrinsics.g(url, "url");
        Intrinsics.g(zipUnCompressPath, "zipUnCompressPath");
        Intrinsics.g(zipFile, "zipFile");
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onUnZipDownloadFinish: " + url + " zipUnCompressPath: " + zipUnCompressPath + " zipFile: " + zipFile);
        vd.b bVar = this.f79413a;
        if (bVar != null) {
            bVar.e(url, zipUnCompressPath, zipFile);
        }
    }

    @Override // m9.b
    public void f(String url) {
        Intrinsics.g(url, "url");
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onZipDownloadStart: " + url);
        vd.b bVar = this.f79413a;
        if (bVar != null) {
            bVar.f(url);
        }
    }

    @Override // m9.b
    public void g(String url) {
        Intrinsics.g(url, "url");
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onZipDownloadCancel: " + url);
        vd.b bVar = this.f79413a;
        if (bVar != null) {
            bVar.g(url);
        }
    }

    @Override // m9.b
    public boolean h(String packageName, String pageUrl, String zipUrl) {
        List<DeliveryDimensionData> allowDeliveryDimension;
        List<String> mcc;
        Intrinsics.g(packageName, "packageName");
        Intrinsics.g(pageUrl, "pageUrl");
        Intrinsics.g(zipUrl, "zipUrl");
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onZipTryDownload -> packageName:" + packageName + ", pageUrl:" + pageUrl + ", zipUrl:" + zipUrl);
        OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(packageName);
        if (offPkgConfigD != null && (allowDeliveryDimension = offPkgConfigD.getAllowDeliveryDimension()) != null) {
            for (DeliveryDimensionData deliveryDimensionData : allowDeliveryDimension) {
                OfflineUtils offlineUtils = OfflineUtils.f32081a;
                String strW = offlineUtils.w(pageUrl);
                String appId = deliveryDimensionData.getAppId();
                if (appId != null && appId.length() > 0 && Intrinsics.b(deliveryDimensionData.getAppId(), strW)) {
                    String strB = g.f32096a.b();
                    TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onZipTryDownload -> localMcc:" + strB + ", mccList:" + deliveryDimensionData.getMcc());
                    List<String> mcc2 = deliveryDimensionData.getMcc();
                    if (mcc2 != null && (!mcc2.isEmpty()) && strB != null && ((mcc = deliveryDimensionData.getMcc()) == null || !mcc.contains(strB))) {
                        return false;
                    }
                    String networkType = deliveryDimensionData.getNetworkType();
                    if (!offlineUtils.c((networkType == null || networkType.length() <= 0) ? offPkgConfigD.getNetworkType() : deliveryDimensionData.getNetworkType())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // m9.b
    public boolean i(UpdateEntity updateEntity) {
        TmcLogger.c("TmcOfflineDownload: UpdateListenerImpl", "onGetEntity: " + updateEntity);
        return false;
    }

    public final void j(vd.b bVar) {
        this.f79413a = bVar;
    }

    @Override // m9.b
    public void onError(String url, int i11, String errMsg) {
        Intrinsics.g(url, "url");
        Intrinsics.g(errMsg, "errMsg");
        TmcLogger.f("TmcOfflineDownload: UpdateListenerImpl", "onError: " + url + " errCode: " + i11 + " errorMsg: " + errMsg);
        vd.b bVar = this.f79413a;
        if (bVar != null) {
            bVar.onError(url, i11, errMsg);
        }
    }
}
