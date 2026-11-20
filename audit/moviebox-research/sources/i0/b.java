package i0;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f66804a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f66805b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Runnable f66806c;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements PopWindowManager.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f66807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f66808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f66809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Unit> f66810d;

        public a(Context context, String windowToken, long j11, Function0<Unit> function0) {
            Intrinsics.g(context, "context");
            Intrinsics.g(windowToken, "windowToken");
            this.f66807a = context;
            this.f66808b = windowToken;
            this.f66809c = j11;
            this.f66810d = function0;
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void a(PopWindowManager.PopWindowData bean) {
            Intrinsics.g(bean, "bean");
            TmcLogger.c("AddHomeToastUtils", "onRefresh:" + (System.currentTimeMillis() - this.f66809c));
            b.f66804a.b(this.f66808b, this.f66809c, bean.getDelayTime() - (System.currentTimeMillis() - this.f66809c));
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void show(String appId) {
            Function0<Unit> function0;
            Intrinsics.g(appId, "appId");
            boolean zV = AppUtils.f31011a.v(this.f66807a, appId);
            TmcLogger.c("AddHomeToastUtils", "查询桌面是否存在 show()，status: " + zV);
            if (zV || (function0 = this.f66810d) == null) {
                return;
            }
            function0.invoke();
        }
    }

    public static final void a(String windowToken, long j11) {
        Intrinsics.g(windowToken, "$windowToken");
        PopWindowManager.f31020a.d(windowToken, System.currentTimeMillis() - j11);
    }

    public final void b(final String str, final long j11, long j12) {
        Runnable runnable = f66806c;
        if (runnable != null) {
            f66805b.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: i0.a
            @Override // java.lang.Runnable
            public final void run() {
                b.a(str, j11);
            }
        };
        f66806c = runnable2;
        f66805b.postDelayed(runnable2, j12);
    }
}
