package jd;

import OooO0o0.OooO0OO;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e0;
import androidx.lifecycle.t;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.miniapp.ad.interstitial.AdInterstitialHtmlView$Builder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends OooO0OO.OooO00o<AdInterstitialHtmlView$Builder> implements t {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f67980t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f67981u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f67982v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f67983w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f67984x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Runnable f67985y;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements OooO0OO.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f67987b;

        public a(Context context) {
            this.f67987b = context;
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0OO oooO0OO) {
            b bVar = b.this;
            Context context = this.f67987b;
            bVar.getClass();
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().d(bVar);
            }
            b bVar2 = b.this;
            bVar2.f67983w.removeCallbacks(bVar2.f67985y);
            b.this.y(true);
        }
    }

    /* JADX INFO: renamed from: jd.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0729b implements OooO0OO.j {
        public C0729b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            b.this.B();
            b bVar = b.this;
            AdShowBean adShowBean = new AdShowBean(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null);
            b bVar2 = b.this;
            adShowBean.setImageWidth(bVar2.A());
            adShowBean.setImageHeight(bVar2.z());
            adShowBean.setShowTs(bVar2.f67980t);
            adShowBean.setEffectiveShow(bVar2.f67982v ? 1 : 0);
            adShowBean.setShowDuration(System.currentTimeMillis() - bVar2.f67980t);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adShowBean.getImageWidth());
            sb2.append('*');
            sb2.append(adShowBean.getImageHeight());
            adShowBean.setShowArea(sb2.toString());
            adShowBean.setShowReportTimeType(1);
            adShowBean.setShowTimes(bVar2.f67981u);
            bVar.w(adShowBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f67983w = new Handler(Looper.getMainLooper());
        this.f67985y = new Runnable() { // from class: jd.a
            @Override // java.lang.Runnable
            public final void run() {
                b.x(this.f67979a);
            }
        };
        v(context);
        d(new a(context));
        e(new C0729b());
    }

    public static final void x(b this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f67982v = true;
        AdShowBean adShowBean = new AdShowBean(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null);
        adShowBean.setImageWidth(this$0.A());
        adShowBean.setImageHeight(this$0.z());
        adShowBean.setShowTs(this$0.f67980t);
        adShowBean.setEffectiveShow(this$0.f67982v ? 1 : 0);
        adShowBean.setShowDuration(System.currentTimeMillis() - this$0.f67980t);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(adShowBean.getImageWidth());
        sb2.append('*');
        sb2.append(adShowBean.getImageHeight());
        adShowBean.setShowArea(sb2.toString());
        adShowBean.setShowReportTimeType(2);
        adShowBean.setShowTimes(this$0.f67981u);
        this$0.w(adShowBean);
    }

    public abstract int A();

    public final void B() {
        this.f67980t = System.currentTimeMillis();
        this.f67981u++;
        this.f67983w.postDelayed(this.f67985y, 1000L);
    }

    @e0(Lifecycle.Event.ON_PAUSE)
    public final void onLifeCycleOnPause() {
        if (p()) {
            y(false);
        }
    }

    @e0(Lifecycle.Event.ON_RESUME)
    public final void onLifeCycleOnResume() {
        if (p()) {
            B();
        }
    }

    public final void v(Context context) {
        if (context instanceof AppCompatActivity) {
            ((AppCompatActivity) context).getLifecycle().a(this);
        }
    }

    public abstract void w(AdShowBean adShowBean);

    public final void y(boolean z11) {
        AdShowBean adShowBean = new AdShowBean(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null);
        adShowBean.setImageWidth(A());
        adShowBean.setImageHeight(z());
        adShowBean.setShowTs(this.f67980t);
        adShowBean.setEffectiveShow(this.f67982v ? 1 : 0);
        adShowBean.setShowDuration(System.currentTimeMillis() - this.f67980t);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(adShowBean.getImageWidth());
        sb2.append('*');
        sb2.append(adShowBean.getImageHeight());
        adShowBean.setShowArea(sb2.toString());
        adShowBean.setShowReportTimeType(3);
        adShowBean.setShowTimes(this.f67981u);
        adShowBean.setClose(z11);
        w(adShowBean);
    }

    public abstract int z();
}
