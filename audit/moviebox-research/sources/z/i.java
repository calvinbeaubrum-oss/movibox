package z;

import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import hd.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SubPackageInfo f81687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f81689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppModel f81690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f81691e = 1;

    public final PointAnalyseType a(PointAnalyseType bundle) {
        Intrinsics.g(bundle, "bundle");
        if (this.f81688b) {
            String str = this.f81689c;
            if (str != null && str.length() != 0) {
                StringBuilder sbA = j.a("sub_");
                sbA.append(this.f81689c);
                bundle.putData("mpu_special_subpkg", sbA.toString());
            }
        } else {
            bundle.putData("mpu_special_subpkg", "mainPkg");
        }
        return bundle;
    }

    public final String b(AppModel appModel) {
        if (this.f81688b) {
            SubPackageInfo subPackageInfo = this.f81687a;
            if (subPackageInfo != null) {
                return subPackageInfo.getSubPackageUrlMD5();
            }
        } else if (appModel != null) {
            return appModel.getMainPackageUrlEncryption();
        }
        return null;
    }

    public final void c() {
        String appId;
        try {
            AppModel appModel = this.f81690d;
            if (appModel == null || (appId = appModel.getAppId()) == null || appId.length() == 0 || this.f81688b) {
                return;
            }
            IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) tc.a.a(IPackageResourceManager.class);
            AppModel appModel2 = this.f81690d;
            String vhost = iPackageResourceManager.getVhost(appModel2 != null ? appModel2.getAppId() : null);
            for (Map.Entry<String, String> entry : iPackageResourceManager.getVUrl2FilePathMap().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() != 0) {
                    String key2 = entry.getKey();
                    Intrinsics.f(key2, "entry.key");
                    Intrinsics.f(vhost, "vhost");
                    if (l.L(key2, vhost, false, 2, null)) {
                        iPackageResourceManager.getVUrl2FilePathMap().remove(entry.getKey());
                        TmcLogger.c("SubpackageStepHelper", "remove vurlPathMap key:" + entry.getKey() + ",value:" + entry.getValue());
                    }
                }
            }
            for (Map.Entry<String, String> entry2 : iPackageResourceManager.getFilePath2VUrlMap().entrySet()) {
                String value = entry2.getValue();
                if (value != null && value.length() != 0) {
                    String value2 = entry2.getValue();
                    Intrinsics.f(value2, "entry.value");
                    Intrinsics.f(vhost, "vhost");
                    if (l.L(value2, vhost, false, 2, null)) {
                        iPackageResourceManager.getFilePath2VUrlMap().remove(entry2.getKey());
                        TmcLogger.c("SubpackageStepHelper", "remove vurlMap key:" + entry2.getKey() + ",value:" + entry2.getValue());
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("SubpackageStepHelper", "", th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    /* JADX WARN: Code duplicated, block: B:29:0x006e A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:3:0x0005, B:5:0x0019, B:8:0x002b, B:10:0x0031, B:11:0x0036, B:13:0x003c, B:20:0x0051, B:22:0x0057, B:24:0x005e, B:26:0x0064, B:27:0x0068, B:29:0x006e, B:31:0x007a, B:34:0x0081, B:36:0x0087, B:37:0x008b, B:39:0x0091, B:41:0x00b5, B:42:0x00bb, B:45:0x00c5, B:47:0x00cb, B:50:0x00d2, B:52:0x00d8, B:53:0x00dc, B:55:0x00e2, B:57:0x00f4), top: B:61:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0091 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:3:0x0005, B:5:0x0019, B:8:0x002b, B:10:0x0031, B:11:0x0036, B:13:0x003c, B:20:0x0051, B:22:0x0057, B:24:0x005e, B:26:0x0064, B:27:0x0068, B:29:0x006e, B:31:0x007a, B:34:0x0081, B:36:0x0087, B:37:0x008b, B:39:0x0091, B:41:0x00b5, B:42:0x00bb, B:45:0x00c5, B:47:0x00cb, B:50:0x00d2, B:52:0x00d8, B:53:0x00dc, B:55:0x00e2, B:57:0x00f4), top: B:61:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:? A[LOOP:2: B:37:0x008b->B:79:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0091, please report this as an issue */
    public final void d(AppModel appModel, String str, lb.g context, Integer num) {
        List<SubPackageInfo> subPackagePages;
        List<SubPackageInfo> subPackagePages2;
        List<SubPackageInfo> subPackagePages3;
        List<SubPackageInfo> subPackagePages4;
        List<String> pages;
        List<String> pages2;
        Iterator<T> it;
        List<String> mainPackagePages;
        Intrinsics.g(context, "context");
        try {
            this.f81690d = appModel;
            this.f81688b = !TextUtils.isEmpty(str);
            this.f81689c = str;
            this.f81691e = num;
            if (TextUtils.isEmpty(str)) {
                String string = context.q().getString("page");
                if (!TextUtils.isEmpty(string)) {
                    if (appModel != null && (mainPackagePages = appModel.getMainPackagePages()) != null) {
                        Iterator<T> it2 = mainPackagePages.iterator();
                        boolean z11 = false;
                        while (it2.hasNext()) {
                            if (TextUtils.equals((String) it2.next(), string)) {
                                z11 = true;
                            }
                        }
                        if (!z11) {
                            if (appModel != null) {
                                loop1: for (SubPackageInfo subPackageInfo : subPackagePages4) {
                                    pages = subPackageInfo.getPages();
                                    if (pages != null) {
                                        it = pages2.iterator();
                                        while (it.hasNext()) {
                                            if (TextUtils.equals(subPackageInfo.getRoot() + '/' + ((String) it.next()), string)) {
                                                this.f81689c = subPackageInfo.getRoot();
                                                break loop1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (appModel != null && (subPackagePages3 = appModel.getSubPackagePages()) != null && (!subPackagePages3.isEmpty()) && (subPackagePages4 = appModel.getSubPackagePages()) != null) {
                        loop1: while (r7.hasNext()) {
                            pages = subPackageInfo.getPages();
                            if (pages != null && !pages.isEmpty() && (pages2 = subPackageInfo.getPages()) != null) {
                                it = pages2.iterator();
                                while (it.hasNext()) {
                                    if (TextUtils.equals(subPackageInfo.getRoot() + '/' + ((String) it.next()), string)) {
                                        this.f81689c = subPackageInfo.getRoot();
                                        break loop1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(this.f81689c) || appModel == null || (subPackagePages = appModel.getSubPackagePages()) == null || subPackagePages.isEmpty() || (subPackagePages2 = appModel.getSubPackagePages()) == null) {
                return;
            }
            for (SubPackageInfo subPackageInfo2 : subPackagePages2) {
                if (Intrinsics.b(this.f81689c, subPackageInfo2.getRoot())) {
                    this.f81687a = subPackageInfo2;
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("", th2);
        }
    }

    public final SubPackageInfo e() {
        if (this.f81688b) {
            return this.f81687a;
        }
        return null;
    }
}
