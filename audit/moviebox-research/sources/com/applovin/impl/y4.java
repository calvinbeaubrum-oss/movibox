package com.applovin.impl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.applovin.creative.MaxCreativeDebuggerActivity;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class y4 implements s6.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static WeakReference f24495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicBoolean f24496n = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f24497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f24498b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x4 f24501e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private s6 f24503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private go f24504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f24506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f24507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f24508l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f24499c = new ArrayList(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f24500d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference f24502f = new WeakReference(null);

    /* JADX INFO: compiled from: source.java */
    public class a extends p {
        public a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Started Creative Debugger");
                if (!y4.this.h() || y4.f24495m.get() != activity) {
                    MaxCreativeDebuggerActivity maxCreativeDebuggerActivity = (MaxCreativeDebuggerActivity) activity;
                    WeakReference unused = y4.f24495m = new WeakReference(maxCreativeDebuggerActivity);
                    maxCreativeDebuggerActivity.a(y4.this.f24501e, y4.this.f24497a.e());
                }
                y4.f24496n.set(false);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Creative Debugger destroyed");
                WeakReference unused = y4.f24495m = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f24510a;

        public b(Object obj) {
            this.f24510a = obj;
        }

        @Override // com.applovin.impl.r.b
        public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
            maxCreativeDebuggerDisplayedAdActivity.a(new w6(this.f24510a, y4.this.f24497a.C().b()), y4.this.f24497a);
            y4.f24496n.set(false);
        }
    }

    public y4(com.applovin.impl.sdk.j jVar) {
        this.f24497a = jVar;
        Context contextL = com.applovin.impl.sdk.j.l();
        this.f24498b = contextL;
        this.f24501e = new x4(contextL);
    }

    private Bundle a(Object obj) {
        this.f24497a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24497a.J().a("CreativeDebuggerService", "Retrieving Ad Review info for ad: " + obj);
        }
        String strA = yp.a(obj);
        Bundle bundleA = this.f24497a.h().a(strA);
        this.f24497a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24497a.J().a("CreativeDebuggerService", "Serve id: " + strA);
        }
        this.f24497a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24497a.J().a("CreativeDebuggerService", "Public data: " + bundleA);
        }
        if (bundleA == null) {
            return null;
        }
        for (String str : bundleA.keySet()) {
            Object obj2 = bundleA.get(str);
            bundleA.remove(str);
            BundleUtils.put(StringUtils.toHumanReadableString(str), obj2, bundleA);
        }
        return bundleA;
    }

    private View a(final FrameLayout frameLayout, Activity activity) {
        View view;
        int iDpToPx = AppLovinSdkUtils.dpToPx(activity, 40);
        int i11 = iDpToPx / 10;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx, 8388629);
        layoutParams.setMargins(i11, i11, i11, i11);
        try {
            ImageButton imageButton = new ImageButton(activity);
            imageButton.setImageDrawable(activity.getResources().getDrawable(R.drawable.applovin_ic_white_small));
            imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageButton.setPadding(i11, i11, i11, i11 * 2);
            view = imageButton;
        } catch (Throwable unused) {
            Button button = new Button(activity);
            button.setText("ⓘ");
            button.setTextColor(-1);
            button.setAllCaps(false);
            button.setTextSize(2, 20.0f);
            button.setPadding(0, 0, 0, 0);
            view = button;
        }
        view.setLayoutParams(layoutParams);
        view.setBackground(f());
        if (this.f24506j) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.n90
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f21302a.a(frameLayout, view2, motionEvent);
                }
            });
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.o90
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f21476a.a(view2);
                }
            });
        }
        if (z3.f()) {
            view.setElevation(AppLovinSdkUtils.dpToPx(activity, 5));
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout) {
        if (view.getParent() != null || this.f24502f.get() == null) {
            return;
        }
        frameLayout.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (this.f24507k <= 0 || !this.f24506j) {
            b(view, frameLayout);
        } else {
            view.setVisibility(4);
        }
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(FrameLayout frameLayout, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f24507k = SystemClock.elapsedRealtime();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.s90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22318a.i();
                }
            }, TimeUnit.SECONDS.toMillis(10L));
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (view.getVisibility() == 0) {
                this.f24507k = 0L;
                n();
            } else {
                b(view, frameLayout);
            }
        }
        return true;
    }

    private void b(View view, FrameLayout frameLayout) {
        if (this.f24506j) {
            view.setOnTouchListener(null);
            this.f24507k = 0L;
        }
        frameLayout.removeView(view);
        this.f24502f = new WeakReference(null);
    }

    private boolean c(Object obj) {
        MaxAdFormat format;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            format = ((com.applovin.impl.sdk.ad.b) obj).getAdZone().d();
        } else {
            format = obj instanceof ge ? ((ge) obj).getFormat() : null;
        }
        return format != null && format.isFullscreenAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (g() && this.f24502f.get() == null && !h()) {
            Activity activityB = this.f24497a.e().b();
            if (activityB == null) {
                this.f24497a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24497a.J().b("AppLovinSdk", "Failed to display Creative Debugger button");
                    return;
                }
                return;
            }
            View viewFindViewById = activityB.findViewById(android.R.id.content);
            if (viewFindViewById instanceof FrameLayout) {
                final FrameLayout frameLayout = (FrameLayout) viewFindViewById;
                final View viewA = a(frameLayout, activityB);
                frameLayout.addView(viewA);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150L);
                viewA.startAnimation(alphaAnimation);
                final ViewTreeObserver viewTreeObserver = viewFindViewById.getViewTreeObserver();
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.applovin.impl.p90
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        this.f21704a.a(viewA, frameLayout);
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.q90
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21914a.a(viewA, frameLayout, viewTreeObserver, onGlobalLayoutListener);
                    }
                }, TimeUnit.SECONDS.toMillis(5L));
                this.f24502f = new WeakReference(viewA);
            }
        }
    }

    private void e(Object obj) {
        com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting Creative Debugger for current fullscreen ad...");
        r.a(this.f24498b, MaxCreativeDebuggerDisplayedAdActivity.class, this.f24497a.e(), new b(obj));
    }

    private Drawable f() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, 131, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        WeakReference weakReference = f24495m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.f24507k);
        if (this.f24507k == 0 || seconds < 10) {
            return;
        }
        this.f24497a.E().a(la.f20375d, "showingMediationDebuggerFromHoldingCreativeDebuggerButton");
        this.f24497a.U0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f24505i = 0;
    }

    private void m() {
        this.f24497a.e().a(new a());
    }

    public String a(w6 w6Var) {
        Object objA = w6Var.a();
        qc qcVar = new qc();
        qcVar.b("Ad Info:\n");
        if (objA instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) objA;
            qcVar.a("Network", "APPLOVIN").a(bVar).b(bVar);
        } else if (objA instanceof ge) {
            qcVar.a((ge) objA);
        }
        qcVar.a(this.f24497a);
        qcVar.a("Epoch Timestamp (ms)", Long.valueOf(w6Var.b()));
        qcVar.a("\nDebug Info:\n").a("Platform", "fireos".equals(this.f24497a.y().v()) ? "Fire OS" : "Android").a("AppLovin SDK Version", AppLovinSdk.VERSION).a("Plugin Version", this.f24497a.a(sj.U3)).a("App Package Name", this.f24498b.getPackageName()).a("Device", String.format("%s %s (%s)", Build.BRAND, Build.MODEL, Build.DEVICE)).a("OS Version", Build.VERSION.RELEASE).a("AppLovin Random Token", this.f24497a.a0()).a("Ad Review Version", v.b()).a(a(objA)).a("User ID", this.f24497a.q0().c() != null ? this.f24497a.q0().c() : "None").a("MD", this.f24497a.a(sj.f23076v));
        return qcVar.toString();
    }

    @Override // com.applovin.impl.s6.a
    public void a() {
        int i11 = this.f24505i;
        if (i11 % 2 == 1) {
            this.f24505i = i11 + 1;
        }
        if (this.f24505i / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20637a.e();
                }
            });
            this.f24505i = 0;
            this.f24504h.a();
        }
    }

    public void a(w6 w6Var, Context context, boolean z11) {
        Object objA = w6Var.a();
        String strA = a(w6Var);
        qc qcVar = new qc();
        if (z11) {
            qcVar.b("Please describe the issue you had with this ad:\n\n\n\n");
        }
        qcVar.b(strA);
        String strB = this.f24497a.w().b(objA);
        if (strB != null) {
            qcVar.a("\nBid Response:\n");
            qcVar.a(strB);
        }
        Intent intentCreateChooser = Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.SUBJECT", objA instanceof com.applovin.impl.sdk.ad.b ? "AppLovin Ad Report" : "MAX Ad Report").putExtra("android.intent.extra.TEXT", qcVar.toString()).setPackage(null), "Share Ad Report");
        if (!z11) {
            context.startActivity(intentCreateChooser);
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:")).putExtra("android.intent.extra.SUBJECT", objA instanceof com.applovin.impl.sdk.ad.b ? "AppLovin Ad Report" : "MAX Ad Report").putExtra("android.intent.extra.TEXT", qcVar.toString()).setPackage("com.google.android.gm"));
        } catch (ActivityNotFoundException unused) {
            context.startActivity(intentCreateChooser);
        }
    }

    public String b(Object obj) {
        JSONObject jSONObjectA;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            return ((com.applovin.impl.sdk.ad.b) obj).getOriginalFullResponse().toString();
        }
        if (!(obj instanceof ge)) {
            return null;
        }
        String strE = ((ge) obj).E();
        return (!af.b(obj) || (jSONObjectA = new w(strE, this.f24497a).a()) == null) ? strE : jSONObjectA.toString();
    }

    @Override // com.applovin.impl.s6.a
    public void b() {
        if (this.f24505i == 0) {
            this.f24504h = go.a(TimeUnit.SECONDS.toMillis(3L), this.f24497a, new Runnable() { // from class: com.applovin.impl.r90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22072a.j();
                }
            });
        }
        int i11 = this.f24505i;
        if (i11 % 2 == 0) {
            this.f24505i = i11 + 1;
        }
    }

    public void d(Object obj) {
        if (g() && obj != null) {
            if (!af.a(obj) || c(obj)) {
                if (af.b(obj) && c(obj)) {
                    return;
                }
                synchronized (this.f24500d) {
                    try {
                        this.f24499c.add(0, new w6(obj, System.currentTimeMillis()));
                        if (this.f24499c.size() > 10) {
                            List list = this.f24499c;
                            list.remove(list.size() - 1);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    public boolean g() {
        return ((Boolean) this.f24497a.a(sj.D1)).booleanValue() && this.f24497a.g0().isCreativeDebuggerEnabled();
    }

    public void k() {
        s6 s6Var = this.f24503g;
        if (s6Var != null) {
            s6Var.b();
        }
    }

    public void l() {
        if (g()) {
            this.f24506j = ((Boolean) this.f24497a.a(sj.E1)).booleanValue();
            if (this.f24503g == null) {
                this.f24503g = new s6(this.f24497a, this);
            }
            this.f24503g.a();
        }
    }

    public void n() {
        ArrayList arrayList;
        if (h() || !f24496n.compareAndSet(false, true)) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Creative Debugger is already showing");
            return;
        }
        Object objA = this.f24497a.C().a();
        if (objA != null) {
            e(objA);
            return;
        }
        synchronized (this.f24500d) {
            arrayList = new ArrayList(this.f24499c);
        }
        this.f24501e.a(arrayList, this.f24497a);
        if (!this.f24508l) {
            m();
            this.f24508l = true;
        }
        com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting Creative Debugger...");
        r.a(this.f24498b, MaxCreativeDebuggerActivity.class);
    }
}
