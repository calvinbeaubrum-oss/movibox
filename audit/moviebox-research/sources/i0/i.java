package i0;

import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f66819a = new i();

    public final File a(String str, App app, boolean z11) {
        try {
            if (app == null) {
                TmcLogger.c("RefreshUtils", "请检查 app is null");
                return null;
            }
            if (str != null && str.length() != 0) {
                if (z11 && !kotlin.text.l.u(str, ".gif", false, 2, null)) {
                    TmcLogger.c("RefreshUtils", "请检查gif图片是否配置正确。url: " + str);
                    return null;
                }
                if (i0.b(str) && !StringsKt__StringsKt.Q(str, ".miniapp.transsion.com", false, 2, null)) {
                    TmcLogger.c("RefreshUtils", "请检查地址仅支持小程序包内的图片资源文件。url: " + str);
                    return null;
                }
                File fileJ = FileUtil.J(app, str);
                if (!FileUtil.c(fileJ)) {
                    TmcLogger.c("RefreshUtils", "请检查图片资源是否存在。url: " + str);
                    return null;
                }
                if (z11) {
                    if (!Intrinsics.b(fileJ != null ? xb.b.c(fileJ) : null, fd.a.a().get("gif"))) {
                        TmcLogger.c("RefreshUtils", "请检查gif图片的类型是否正确。url: " + str);
                        return null;
                    }
                }
                return fileJ;
            }
            TmcLogger.c("RefreshUtils", "请检查LoadingImage链接，链接为空。url: " + str);
            return null;
        } catch (Throwable th2) {
            TmcLogger.g("RefreshUtils", "", th2);
            return null;
        }
    }
}
