package com.transsion.player.helper;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.d0;
import com.tn.lib.widget.R$dimen;
import com.transsion.baselib.report.m;
import com.transsion.player.view.R$id;
import com.transsion.player.view.R$layout;
import com.transsion.player.view.R$mipmap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class VideoBrightnessVolume implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f54326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f54327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.transsion.player.orplayer.f f54329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f54330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f54331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f54332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f54333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f54334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f54335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function2<? super Boolean, ? super Integer, Unit> f54336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f54337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f54338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f54339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f54340p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v11) {
            Intrinsics.g(v11, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v11) {
            Intrinsics.g(v11, "v");
            int iC = VideoBrightnessVolume.this.c();
            if (iC > 100) {
                m mVar = m.f51277a;
                mVar.t(mVar.f(), "volume_max", r.f(new Pair("volume", String.valueOf(iC))));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.r {
        public b() {
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(u source, Lifecycle.Event event) {
            Intrinsics.g(source, "source");
            Intrinsics.g(event, "event");
            if (event == Lifecycle.Event.ON_RESUME) {
                ViewGroup viewGroup = VideoBrightnessVolume.this.f54327c;
                if (viewGroup != null) {
                    viewGroup.setFocusableInTouchMode(true);
                    viewGroup.requestFocus();
                }
                AppVolumeManager.f54318a.b();
            }
        }
    }

    public VideoBrightnessVolume(Context context, ViewGroup viewGroup) {
        Intrinsics.g(context, "context");
        this.f54326b = context;
        this.f54327c = viewGroup;
        this.f54328d = "VideoBrightnessVolume";
        this.f54330f = LayoutInflater.from(context).inflate(R$layout.orplayer_layout_brightness_volume, viewGroup, false);
        this.f54331g = LazyKt__LazyJVMKt.b(new Function0<ImageView>() { // from class: com.transsion.player.helper.VideoBrightnessVolume$iconView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) this.this$0.f54330f.findViewById(R$id.bvIV);
            }
        });
        this.f54332h = LazyKt__LazyJVMKt.b(new Function0<ProgressBar>() { // from class: com.transsion.player.helper.VideoBrightnessVolume$bvProgress$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ProgressBar invoke() {
                return (ProgressBar) this.this$0.f54330f.findViewById(R$id.bvProgress);
            }
        });
        this.f54333i = LazyKt__LazyJVMKt.b(new Function0<ProgressBar>() { // from class: com.transsion.player.helper.VideoBrightnessVolume$secProgress$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ProgressBar invoke() {
                return (ProgressBar) this.this$0.f54330f.findViewById(R$id.secProgress);
            }
        });
        this.f54334j = LazyKt__LazyJVMKt.b(new Function0<View>() { // from class: com.transsion.player.helper.VideoBrightnessVolume$tipsLL$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return this.this$0.f54330f.findViewById(R$id.tipsLL);
            }
        });
        if (viewGroup == null) {
            Log.e("VideoBrightnessVolume", " error: rootView is null !!!");
        }
        this.f54335k = (d0.c() / 3.0f) / 25.0f;
        if (viewGroup != null) {
            viewGroup.setOnKeyListener(new View.OnKeyListener() { // from class: com.transsion.player.helper.e
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                    return VideoBrightnessVolume.k(this.f54359a, view, i11, keyEvent);
                }
            });
        }
        if (viewGroup != null) {
            viewGroup.addOnAttachStateChangeListener(new a());
        }
        x();
        this.f54340p = new Runnable() { // from class: com.transsion.player.helper.f
            @Override // java.lang.Runnable
            public final void run() {
                VideoBrightnessVolume.n(this.f54360a);
            }
        };
    }

    public static final boolean k(VideoBrightnessVolume this$0, View view, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i11 == 24) {
            int iC = this$0.c();
            this$0.z((91 > iC || iC >= 100) ? 10 : 100 - iC);
        } else {
            if (i11 != 25) {
                return false;
            }
            this$0.z(-10);
        }
        return true;
    }

    public static final void n(VideoBrightnessVolume this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.w();
    }

    public static final void q(VideoBrightnessVolume this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.v().setVisibility(8);
    }

    @Override // com.transsion.player.helper.g
    public void a(float f11, float f12) {
        Context context = this.f54326b;
        Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        float f13 = 1.0f;
        float f14 = f11 + (f12 * 1.0f);
        if (f14 <= 0.0f) {
            f13 = 0.0f;
        } else if (f14 < 1.0f) {
            f13 = f14;
        }
        attributes.screenBrightness = f13;
        window.setAttributes(attributes);
        Function2<? super Boolean, ? super Integer, Unit> function2 = this.f54336l;
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, Integer.valueOf((int) (100 * f13)));
        }
        y(false, (int) (f13 * 100));
    }

    @Override // com.transsion.player.helper.g
    public float b() {
        Context context = this.f54326b;
        Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            return 0.0f;
        }
        float f11 = window.getAttributes().screenBrightness;
        return f11 == -1.0f ? s() : f11;
    }

    @Override // com.transsion.player.helper.g
    public int c() {
        return AppVolumeManager.f54318a.c();
    }

    @Override // com.transsion.player.helper.g
    public void d(float f11, float f12, int i11) {
        if (this.f54337m != f11) {
            this.f54338n = f11;
            this.f54337m = f11;
        }
        if (i11 <= 0) {
            i11 = d0.c();
        }
        int i12 = (int) ((((this.f54338n - f12) * 80.0f) / i11) + 0.5f);
        if (Math.abs(i12) == 0) {
            return;
        }
        this.f54338n = f12;
        z(i12);
    }

    @Override // com.transsion.player.helper.g
    public void e(com.transsion.player.orplayer.f fVar) {
        this.f54329e = fVar;
    }

    @Override // com.transsion.player.helper.g
    public void f(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("show:");
        sb2.append(z11);
        if (this.f54327c == null) {
            return;
        }
        if (!z11) {
            w();
            return;
        }
        View progressRootView = this.f54330f;
        Intrinsics.f(progressRootView, "progressRootView");
        progressRootView.setVisibility(0);
        try {
            Result.Companion companion = Result.Companion;
            ViewGroup viewGroup = this.f54327c;
            if (!Intrinsics.b(viewGroup.getChildAt(viewGroup.getChildCount() - 1), this.f54330f)) {
                this.f54327c.removeView(this.f54330f);
            }
            ViewGroup viewGroup2 = this.f54327c;
            View progressRootView2 = this.f54330f;
            Intrinsics.f(progressRootView2, "progressRootView");
            if (viewGroup2.indexOfChild(progressRootView2) == -1) {
                this.f54327c.addView(this.f54330f);
            }
            if (this.f54339o) {
                ViewGroup.LayoutParams layoutParams = this.f54330f.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = com.blankj.utilcode.util.d.c() + ((int) this.f54326b.getResources().getDimension(R$dimen.toolbar_height));
                    this.f54330f.setLayoutParams(marginLayoutParams);
                }
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        this.f54327c.removeCallbacks(this.f54340p);
        this.f54327c.postDelayed(this.f54340p, 500L);
    }

    @Override // com.transsion.player.helper.g
    public void g() {
        this.f54339o = true;
    }

    public final void o(int i11, int i12) {
        com.transsion.player.orplayer.f fVar;
        if (i11 > 100 && (fVar = this.f54329e) != null) {
            fVar.setVolume(i11 / 100.0f);
        }
        p(i11, i12);
    }

    public final void p(int i11, int i12) {
        if (i12 >= 100 || i11 != 100) {
            return;
        }
        v().setVisibility(0);
        v().postDelayed(new Runnable() { // from class: com.transsion.player.helper.d
            @Override // java.lang.Runnable
            public final void run() {
                VideoBrightnessVolume.q(this.f54358a);
            }
        }, 500L);
    }

    public final ProgressBar r() {
        Object value = this.f54332h.getValue();
        Intrinsics.f(value, "<get-bvProgress>(...)");
        return (ProgressBar) value;
    }

    public float s() {
        Context context = this.f54326b;
        Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
        try {
            return (Settings.System.getFloat(((Activity) context).getContentResolver(), "screen_brightness") * 1.0f) / 255;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public final ImageView t() {
        Object value = this.f54331g.getValue();
        Intrinsics.f(value, "<get-iconView>(...)");
        return (ImageView) value;
    }

    public final ProgressBar u() {
        Object value = this.f54333i.getValue();
        Intrinsics.f(value, "<get-secProgress>(...)");
        return (ProgressBar) value;
    }

    public final View v() {
        Object value = this.f54334j.getValue();
        Intrinsics.f(value, "<get-tipsLL>(...)");
        return (View) value;
    }

    public final void w() {
        ViewGroup viewGroup = this.f54327c;
        if (viewGroup != null) {
            viewGroup.removeCallbacks(this.f54340p);
            View progressRootView = this.f54330f;
            Intrinsics.f(progressRootView, "progressRootView");
            progressRootView.setVisibility(8);
        }
    }

    public final void x() {
        Context context = this.f54326b;
        if (context instanceof ComponentActivity) {
            ((ComponentActivity) context).getLifecycle().a(new b());
        }
    }

    public final void y(boolean z11, int i11) {
        int i12;
        if (i11 < 0) {
            return;
        }
        ImageView imageViewT = t();
        if (i11 == 0) {
            i12 = z11 ? R$mipmap.ic_volume_0 : R$mipmap.ic_brightness_33;
        } else if (i11 <= 33) {
            i12 = z11 ? R$mipmap.ic_volume_33 : R$mipmap.ic_brightness_33;
        } else if (i11 <= 66) {
            i12 = z11 ? R$mipmap.ic_volume_66 : R$mipmap.ic_brightness_66;
        } else if (i11 <= 100) {
            i12 = z11 ? R$mipmap.ic_volume_66 : R$mipmap.ic_brightness_100;
        } else {
            i12 = z11 ? R$mipmap.ic_volume_100 : R$mipmap.ic_brightness_100;
        }
        imageViewT.setImageResource(i12);
        r().setProgress(i11);
        int iG = kotlin.ranges.a.g(kotlin.ranges.a.d(i11 - 100, 0), 100);
        u().setVisibility(iG > 0 ? 0 : 8);
        u().setProgress(iG);
        f(true);
    }

    public final void z(int i11) {
        com.transsion.player.orplayer.f fVar;
        int iC = c();
        int iG = AppVolumeManager.f54318a.g(i11);
        if (iG <= 100 && (fVar = this.f54329e) != null) {
            fVar.setVolume(1.0f);
        }
        Function2<? super Boolean, ? super Integer, Unit> function2 = this.f54336l;
        if (function2 != null) {
            function2.invoke(Boolean.TRUE, Integer.valueOf(iG));
        }
        y(true, iG);
        o(iG, iC);
    }
}
