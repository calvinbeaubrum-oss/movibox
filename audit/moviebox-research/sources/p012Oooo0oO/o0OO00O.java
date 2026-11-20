package p012Oooo0oO;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.ImageView;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$drawable;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n0.d;
import n0.i;
import o0.a;
import o0.b;
import o0.c;
import o0.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0OO00O implements b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Handler f230e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<e> f232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f233c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f234d = new Object();

    /* JADX INFO: compiled from: source.java */
    public final class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TmcLogger.c("ToastStrategy", "cancel toast run with start");
                WeakReference<e> weakReference = o0OO00O.this.f232b;
                e eVar = weakReference != null ? weakReference.get() : null;
                if (eVar != null) {
                    eVar.cancel();
                }
            } catch (Throwable th2) {
                TmcLogger.g("ToastStrategy", "cancel toast failed!", th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @SourceDebugExtension
    public final class OooO0O0 implements Runnable {
        public d OooO00o;
        public final /* synthetic */ o0OO00O OooO0O0;

        public OooO0O0(o0OO00O o0oo00o, d params) {
            Intrinsics.g(params, "params");
            this.OooO0O0 = o0oo00o;
            this.OooO00o = params;
        }

        public final void OooO00o(e eVar) {
            TmcLogger.c("ToastStrategy", "check update state");
            if (eVar instanceof i) {
                i iVar = (i) eVar;
                d params = this.OooO00o;
                iVar.getClass();
                Intrinsics.g(params, "params");
                iVar.f71355i = params;
            }
            c<?> cVar = this.OooO00o.f71326g;
            if (cVar instanceof f0.c) {
                File file = null;
                ImageView imageViewA = eVar != null ? eVar.a(eVar != null ? eVar.getView() : null) : null;
                File file2 = this.OooO00o.f71324e;
                if (file2 != null) {
                    if (file2.length() < 10485760) {
                        try {
                            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file2.getAbsolutePath());
                            if (imageViewA != null) {
                                imageViewA.setImageBitmap(bitmapDecodeFile);
                            }
                            file = file2;
                        } catch (Throwable th2) {
                            TmcLogger.h("ToastStrategy", th2);
                        }
                    }
                    if (file != null) {
                        return;
                    }
                }
                o0OO00O o0oo00o = this.OooO0O0;
                int i11 = this.OooO00o.f71325f;
                if (i11 == 0) {
                    a aVarOooO00o = cVar.OooO00o();
                    o0oo00o.getClass();
                    if (aVarOooO00o instanceof a.d) {
                        i11 = R$drawable.mini_ic_toast_success;
                    } else if (aVarOooO00o instanceof a.C0774a) {
                        i11 = R$drawable.mini_ic_toast_error;
                    } else {
                        i11 = aVarOooO00o instanceof a.b ? R$drawable.mini_ic_progress : 0;
                    }
                }
                if (i11 != 0 && imageViewA != null) {
                    imageViewA.setImageResource(i11);
                }
                Unit unit = Unit.f68710a;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TmcLogger.c("ToastStrategy", "show toast run with start");
                WeakReference<e> weakReference = this.OooO0O0.f232b;
                e eVar = weakReference != null ? weakReference.get() : null;
                if (eVar instanceof i) {
                    d dVar = ((i) eVar).f71355i;
                    c<?> cVar = dVar != null ? dVar.f71326g : null;
                    a aVarOooO00o = cVar != null ? cVar.OooO00o() : null;
                    c<?> cVar2 = this.OooO00o.f71326g;
                    if (!Intrinsics.b(aVarOooO00o, cVar2 != null ? cVar2.OooO00o() : null)) {
                        ((n0.a) ((i) eVar)).cancel();
                        eVar = null;
                    }
                }
                if (!(eVar instanceof i) || !((i) eVar).b()) {
                    if (eVar != null) {
                        eVar.cancel();
                    }
                    c<?> cVar3 = this.OooO00o.f71326g;
                    e eVarB = cVar3 != null ? this.OooO0O0.b(cVar3) : null;
                    this.OooO0O0.f232b = new WeakReference<>(eVarB);
                    eVar = eVarB;
                }
                OooO00o(eVar);
                if (eVar != null) {
                    eVar.setDuration(this.OooO00o.f71321b);
                }
                if (eVar != null) {
                    eVar.setText(this.OooO00o.f71320a);
                }
                if (eVar != null) {
                    eVar.show();
                }
                Function0<Unit> function0 = this.OooO00o.f71329j;
                if (function0 != null) {
                    function0.invoke();
                }
            } catch (Throwable th2) {
                TmcLogger.g("ToastStrategy", "show toast failed!", th2);
            }
        }
    }

    public o0OO00O(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("Please don't pass non-existent toast show strategy");
        }
    }

    @Override // o0.b
    public void OooO00o() {
        TmcLogger.c("ToastStrategy", "cancelToast");
        Handler handler = f230e;
        handler.removeCallbacksAndMessages(this.f233c);
        handler.removeCallbacksAndMessages(this.f234d);
        handler.postAtTime(new OooO00o(), this.f234d, SystemClock.uptimeMillis());
    }

    @Override // o0.b
    public void a(d params) {
        Intrinsics.g(params, "params");
        TmcLogger.c("ToastStrategy", "showToast mShowStrategyType: 0");
        Handler handler = f230e;
        handler.removeCallbacksAndMessages(this.f233c);
        handler.postAtTime(new OooO0O0(this, params), this.f233c, SystemClock.uptimeMillis() + params.f71322c + ((long) 200));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0055  */
    @SuppressLint({"ObsoleteSdkInt"})
    public e b(c<?> style) {
        e bVar;
        Intrinsics.g(style, "style");
        TmcLogger.c("ToastStrategy", "createToast");
        if (this.f231a == null) {
            throw new IllegalStateException("please provide a application for registerStrategy");
        }
        WeakReference<Activity> weakReference = a.f227b.a().f229a;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity != null) {
            TmcLogger.c("ToastStrategy", "create toast with foreground activity");
            bVar = new n0.a(activity);
        } else {
            TmcLogger.c("ToastStrategy", "create system toast!");
            Application application = this.f231a;
            Intrinsics.d(application);
            bVar = new n0.b(application);
        }
        if ((bVar instanceof i) || Build.VERSION.SDK_INT < 30) {
            Application application2 = this.f231a;
            Intrinsics.d(application2);
            bVar.setView(style.f(application2));
            bVar.setGravity(style.e(), style.d(), style.a());
            bVar.setMargin(style.b(), style.c());
        } else {
            Application application3 = this.f231a;
            Intrinsics.d(application3);
            if (application3.getApplicationInfo().targetSdkVersion < 30) {
                Application application4 = this.f231a;
                Intrinsics.d(application4);
                bVar.setView(style.f(application4));
                bVar.setGravity(style.e(), style.d(), style.a());
                bVar.setMargin(style.b(), style.c());
            }
        }
        return bVar;
    }

    public void c(Application application) {
        TmcLogger.c("ToastStrategy", "registerStrategy " + application);
        this.f231a = application;
        a aVarA = a.f227b.a();
        aVarA.getClass();
        if (application == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(aVarA);
        application.registerActivityLifecycleCallbacks(aVarA);
    }
}
