package n;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.v;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniutils.util.j;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kd.k;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import wc.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f71308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static n.a f71309c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f71307a = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f71310d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new e(), new d());

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(String str, String str2, String str3, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements a {
        @Override // n.c.a
        public void a(String appId, String logoUrl, String path, boolean z11) {
            n.a aVar;
            Intrinsics.g(appId, "appId");
            Intrinsics.g(logoUrl, "logoUrl");
            Intrinsics.g(path, "path");
            TmcLogger.c("IconDownloadManager", "[downloadIcon] appId:" + appId + ", logoUrl:" + logoUrl + ", path:" + path + ", success:" + z11);
            if (z11 && c.f71307a.c(appId, logoUrl, path) && (aVar = c.f71309c) != null) {
                aVar.a(appId, logoUrl, path);
            }
        }
    }

    /* JADX INFO: renamed from: n.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0763c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f71311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f71312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f71313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f71314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f71315e;

        public C0763c(a aVar, String str, String str2, String str3, Ref.ObjectRef<String> objectRef) {
            this.f71311a = aVar;
            this.f71312b = str;
            this.f71313c = str2;
            this.f71314d = str3;
            this.f71315e = objectRef;
        }

        @Override // wc.f
        public void a(String url1, int i11, String callbackId1, long j11, long j12) {
            Intrinsics.g(url1, "url1");
            Intrinsics.g(callbackId1, "callbackId1");
        }

        @Override // wc.f
        public void b(String str, String errorCode, String errorMsg, IOException e11, String str2) {
            Intrinsics.g(errorCode, "errorCode");
            Intrinsics.g(errorMsg, "errorMsg");
            Intrinsics.g(e11, "e");
            this.f71311a.a(this.f71312b, this.f71313c, "", false);
        }

        @Override // wc.f
        public void c(String str, String str2) {
            String strGenerateVUrl;
            try {
                if (v.f31133a.b(this.f71312b)) {
                    strGenerateVUrl = ((IImageResourceManager) tc.a.a(IImageResourceManager.class)).generateVUrl(this.f71314d, "1000886706715795456", this.f71315e.element);
                    Intrinsics.f(strGenerateVUrl, "manager.generateVUrl(downloadPath, MC_APPID, name)");
                } else {
                    strGenerateVUrl = ((IFileResourceManager) tc.a.a(IFileResourceManager.class)).generateVUrl(this.f71314d, "1000886706715795456", this.f71315e.element, "temp_data");
                    Intrinsics.f(strGenerateVUrl, "manager.generateVUrl(dow…Constants.TEMP_DATA_PATH)");
                }
                this.f71311a.a(this.f71312b, this.f71313c, strGenerateVUrl, true);
            } catch (Throwable th2) {
                TmcLogger.g("IconDownloadManager", "[downloadIcon] error", th2);
                this.f71311a.a(this.f71312b, this.f71313c, "", false);
            }
        }

        @Override // wc.f
        public void f(String url1, int i11, String callbackId1) {
            Intrinsics.g(url1, "url1");
            Intrinsics.g(callbackId1, "callbackId1");
        }

        @Override // wc.f
        public void g(String str, String str2) {
            this.f71311a.a(this.f71312b, this.f71313c, "", false);
        }
    }

    public static final void d(String appId, String logoUrl) {
        Intrinsics.g(appId, "$appId");
        Intrinsics.g(logoUrl, "$logoUrl");
        try {
            c cVar = f71307a;
            if (cVar.f(appId, logoUrl)) {
                cVar.b(appId, logoUrl, new b());
            }
        } catch (Throwable th2) {
            TmcLogger.g("IconDownloadManager", "[addTask] error", th2);
        }
    }

    public final void a(final String appId, final String logoUrl) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(logoUrl, "logoUrl");
        if (((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("offlineAppsAbilitySwitch", true)) {
            f71310d.submit(new Runnable() { // from class: n.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(appId, logoUrl);
                }
            });
        } else {
            TmcLogger.c("IconDownloadManager", "[addTask] offlineAppsAbilitySwitch is close");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [T, java.lang.Object] */
    public final void b(String str, String str2, a aVar) {
        List listL;
        if (str.length() == 0) {
            TmcLogger.f("IconDownloadManager", "[downloadIcon] appId isEmpty");
            return;
        }
        if (str2.length() == 0) {
            TmcLogger.f("IconDownloadManager", "[downloadIcon] appid:" + str + " logoUrl isEmpty");
            return;
        }
        String path = Uri.parse(str2).getPath();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (!TextUtils.isEmpty(path)) {
            if (path == null || (listL = StringsKt__StringsKt.E0(path, new String[]{"/"}, false, 0, 6, null)) == null) {
                listL = g.l();
            }
            if (!listL.isEmpty()) {
                objectRef.element = listL.get(listL.size() - 1);
            }
        }
        if (((CharSequence) objectRef.element).length() == 0) {
            TmcLogger.f("IconDownloadManager", "[downloadIcon] name is empty");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath("1000886706715795456"));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("temp_data");
        sb2.append(str3);
        sb2.append((String) objectRef.element);
        String string = sb2.toString();
        if (j.h(string)) {
            ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).downloadPackage(str, str2, string, null, String.valueOf(System.currentTimeMillis()), new C0763c(aVar, str, str2, string, objectRef));
        } else {
            TmcLogger.f("IconDownloadManager", "[downloadIcon] createFileByDeleteOldFile fail");
        }
    }

    public final boolean c(String str, String str2, String str3) {
        boolean z11;
        try {
            Application application = f71308b;
            if (application != null) {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(application, str, str2, str3);
                z11 = true;
            } else {
                z11 = false;
            }
        } catch (Throwable th2) {
            TmcLogger.g("IconDownloadManager", "[saveDownloadIconCache] error", th2);
        }
        TmcLogger.c("IconDownloadManager", "[saveDownloadIconCache] appId:" + str + ", logoUrl:" + str2 + ", path:" + str3 + ", ret:" + z11);
        return z11;
    }

    public final String e(String appId, String logoUrl) {
        String string;
        Intrinsics.g(appId, "appId");
        Intrinsics.g(logoUrl, "logoUrl");
        try {
            Application application = f71308b;
            string = application != null ? ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(application, appId, logoUrl) : null;
        } catch (Throwable th2) {
            TmcLogger.g("IconDownloadManager", "[getIconPath] error", th2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[getIconPath] appId:");
        sb2.append(appId);
        sb2.append(", logoUrl:");
        sb2.append(logoUrl);
        sb2.append(", path:");
        k.a(sb2, string, "IconDownloadManager");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002f  */
    public final boolean f(String str, String str2) {
        boolean z11;
        String string;
        if (str.length() <= 0 || str2.length() <= 0) {
            z11 = false;
        } else {
            z11 = true;
            try {
                Application application = f71308b;
                if (application != null && (string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(application, str, str2)) != null && string.length() != 0) {
                    z11 = false;
                }
            } catch (Throwable th2) {
                TmcLogger.g("IconDownloadManager", "[iconIsNeedDownload] error", th2);
            }
        }
        TmcLogger.c("IconDownloadManager", "[iconIsNeedDownload] appId:" + str + ", logoUrl:" + str2 + ", needDownload:" + z11);
        return z11;
    }
}
