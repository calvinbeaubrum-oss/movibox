package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfigExtParams;
import com.cloud.tmc.offline.download.model.OfflineDownloadBuilder;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.PackageInclude;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class TmcOfflineManagerProxyImpl implements IOfflineManagerProxy {

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function1<OfflinePkgCachePath, Unit> {
        public final /* synthetic */ Function1<JsonObject, Unit> OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OooO00o(Function1<? super JsonObject, Unit> function1) {
            super(1);
            this.OooO00o = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(OfflinePkgCachePath offlinePkgCachePath) {
            String strA;
            JsonElement string;
            OfflinePkgCachePath offlinePkgCachePath2 = offlinePkgCachePath;
            if (offlinePkgCachePath2 != null) {
                try {
                    strA = o.a(offlinePkgCachePath2);
                } catch (Throwable unused) {
                    string = null;
                }
            } else {
                strA = null;
            }
            string = JsonParser.parseString(strA);
            Function1<JsonObject, Unit> function1 = this.OooO00o;
            if (function1 != null) {
                function1.invoke(string != null ? string.getAsJsonObject() : null);
            }
            return Unit.f68710a;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public void downloadPkg(String app, String group, String networkType, String pkgEncrypted, String pkgUrl, String paths, Function1<? super JsonObject, Unit> function1) {
        ArrayList arrayList;
        Intrinsics.g(app, "app");
        Intrinsics.g(group, "group");
        Intrinsics.g(networkType, "networkType");
        Intrinsics.g(pkgEncrypted, "pkgEncrypted");
        Intrinsics.g(pkgUrl, "pkgUrl");
        Intrinsics.g(paths, "paths");
        try {
            Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.TmcOfflineManagerProxyImpl$downloadPkg$tempPaths$1
            }.getType();
            Intrinsics.f(type, "object : TypeToken<ArrayList<String>>() {}.type");
            arrayList = (ArrayList) TmcGsonUtils.e(paths, type);
        } catch (Throwable th2) {
            TmcLogger.h("downloadPkg failed!", th2);
            arrayList = null;
        }
        PackageInclude packageInclude = new PackageInclude(group, arrayList, pkgUrl);
        OfflineDownloadBuilder offlineDownloadBuilder = new OfflineDownloadBuilder();
        offlineDownloadBuilder.setApp(app);
        offlineDownloadBuilder.setGroup(group);
        offlineDownloadBuilder.setNetworkType(networkType);
        offlineDownloadBuilder.setPkgEncrypted(pkgEncrypted);
        offlineDownloadBuilder.setPkgUrl(pkgUrl);
        offlineDownloadBuilder.setExtParams(new OffPkgConfigExtParams(null, f.e(packageInclude), Boolean.FALSE, null));
        OfflineManager.q(offlineDownloadBuilder, new OooO00o(function1));
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public void downloadPkgFromPlatform(String str, boolean z11) {
        OfflineManager.v(str, z11, null, 4, null);
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public boolean enableVerifyServerFile(String str) {
        return OfflineManager.w(str);
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public void getOfflinePkgCachePath(String group, String pkgUrl, Function1<? super JsonObject, Unit> function1) {
        String strA;
        JsonElement string;
        Intrinsics.g(group, "group");
        Intrinsics.g(pkgUrl, "pkgUrl");
        OfflinePkgCachePath offlinePkgCachePathH = OfflineManager.H(group, pkgUrl);
        if (offlinePkgCachePathH != null) {
            try {
                strA = o.a(offlinePkgCachePathH);
            } catch (Throwable unused) {
                string = null;
            }
        } else {
            strA = null;
        }
        string = JsonParser.parseString(strA);
        if (function1 != null) {
            function1.invoke(string != null ? string.getAsJsonObject() : null);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public File getOfflineResources(String str, String str2) {
        return OfflineManager.K(str, str2);
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public boolean verifyServerFile(String str, String str2) {
        return OfflineManager.j0(str, str2);
    }
}
