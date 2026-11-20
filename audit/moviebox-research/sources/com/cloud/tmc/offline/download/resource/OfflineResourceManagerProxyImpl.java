package com.cloud.tmc.offline.download.resource;

import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.offline.download.resource.OfflineResourceManagerProxyImpl;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class OfflineResourceManagerProxyImpl implements IOfflineResourceManagerProxy {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f32011a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f32012b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f32013c = new AtomicInteger(0);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OfflineResourceManagerProxyImpl() {
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: zd.a
                @Override // java.lang.Runnable
                public final void run() {
                    OfflineResourceManagerProxyImpl.b(this.f81896a);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineResourceManagerProxyImpl", th2.getMessage(), th2);
        }
    }

    public static final void b(OfflineResourceManagerProxyImpl this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.c();
    }

    public final void c() {
        try {
            int iF = OfflineStoreCache.f32077a.f();
            this.f32013c.set(iF);
            if (1 <= iF) {
                int i11 = 1;
                while (true) {
                    String strG = OfflineStoreCache.f32077a.g(String.valueOf(i11));
                    if (strG != null && strG.length() != 0) {
                        String[] strArr = (String[]) StringsKt__StringsKt.E0(strG, new String[]{"->"}, false, 0, 6, null).toArray(new String[0]);
                        if (strArr.length == 2) {
                            this.f32011a.put(strArr[0], strArr[1]);
                            this.f32012b.put(strArr[1], strArr[0]);
                        }
                    }
                    if (i11 == iF) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            TmcLogger.c("TmcOfflineDownload: OfflineResourceManagerProxyImpl", "init file vUrl finished, size: " + iF);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineResourceManagerProxyImpl", th2.getMessage(), th2);
        }
    }

    public final void d(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        this.f32011a.put(str, str2);
        this.f32012b.put(str2, str);
    }

    public final void e(String str, String str2) {
        int i11 = this.f32013c.get();
        if (1 > i11) {
            return;
        }
        int i12 = 1;
        while (true) {
            OfflineStoreCache offlineStoreCache = OfflineStoreCache.f32077a;
            String strG = offlineStoreCache.g(String.valueOf(i12));
            if (strG != null && strG.length() != 0) {
                String[] strArr = (String[]) StringsKt__StringsKt.E0(strG, new String[]{"->"}, false, 0, 6, null).toArray(new String[0]);
                if (strArr.length == 2 && Intrinsics.b(str, strArr[0]) && Intrinsics.b(str2, strArr[1])) {
                    offlineStoreCache.l(String.valueOf(i12));
                    return;
                }
            }
            if (i12 == i11) {
                return;
            } else {
                i12++;
            }
        }
    }

    @Override // com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy
    public String generateVUrl(String filePath, String appId, String fileName, String path, boolean z11) {
        Intrinsics.g(filePath, "filePath");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(fileName, "fileName");
        Intrinsics.g(path, "path");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileUtil.U(appId));
        if (path.length() > 0) {
            if (!l.L(path, "/", false, 2, null)) {
                sb2.append("/");
            }
            sb2.append(path);
        }
        sb2.append("/");
        sb2.append(fileName);
        String string = sb2.toString();
        Intrinsics.f(string, "builder.toString()");
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        d(lowerCase, filePath);
        if (z11) {
            synchronized (this) {
                int iAddAndGet = this.f32013c.addAndGet(1);
                OfflineStoreCache offlineStoreCache = OfflineStoreCache.f32077a;
                offlineStoreCache.q(iAddAndGet);
                offlineStoreCache.r(String.valueOf(iAddAndGet), lowerCase + "->" + filePath);
                Unit unit = Unit.f68710a;
            }
        }
        return lowerCase;
    }

    @Override // com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy
    public String getFilePath(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f32011a;
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String str3 = concurrentHashMap.get(lowerCase);
        if (str3 != null && str3.length() != 0) {
            return str3;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.f(locale2, "getDefault()");
        String lowerCase2 = str.toLowerCase(locale2);
        Intrinsics.f(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        String strD = r.d(lowerCase2);
        if (strD == null || strD.length() == 0 || (str2 = this.f32011a.get(strD)) == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    @Override // com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy
    public String getVhost(String appId) {
        Intrinsics.g(appId, "appId");
        return FileUtil.U(appId);
    }

    @Override // com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy
    public void removeByFilePath(String str, boolean z11) {
        if (str == null || str.length() == 0 || !this.f32012b.containsKey(str)) {
            return;
        }
        String strRemove = this.f32012b.remove(str);
        TypeIntrinsics.d(this.f32011a).remove(strRemove);
        if (z11) {
            e(strRemove, str);
        }
    }

    @Override // com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy
    public void removeByVUrl(String str, boolean z11) {
        if (str == null || str.length() == 0 || !this.f32011a.containsKey(str)) {
            return;
        }
        String strRemove = this.f32011a.remove(str);
        TypeIntrinsics.d(this.f32012b).remove(strRemove);
        if (z11) {
            e(str, strRemove);
        }
    }
}
