package n0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.transsion.push.PushConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Activity f71317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f71318k;

    public a(Activity activity) {
        Intrinsics.g(activity, "activity");
        this.f71317j = activity;
    }

    @Override // n0.i
    public boolean b() {
        h hVar = this.f71318k;
        if (hVar != null) {
            return hVar.f71335a.p();
        }
        return false;
    }

    @Override // o0.e
    public void cancel() {
        h hVar = this.f71318k;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // o0.e
    public void show() {
        try {
            h hVar = this.f71318k;
            if (hVar == null) {
                Activity activity = this.f71317j;
                Intrinsics.g(activity, "activity");
                Intrinsics.g(this, "toast");
                hVar = new h(activity, this);
                this.f71318k = hVar;
            }
            TmcLogger.c("ToastDialog", "show toast dialog");
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                hVar.f71336b.run();
                return;
            }
            Handler handler = h.f71334g;
            handler.removeCallbacks(hVar.f71336b);
            handler.post(hVar.f71336b);
        } catch (Throwable th2) {
            TmcLogger.g("ActivityToast", PushConstants.PUSH_SERVICE_TYPE_SHOW, th2);
        }
    }
}
