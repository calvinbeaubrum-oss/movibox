package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class h0 implements u {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f8724j = new b(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h0 f8725k = new h0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8727b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f8730f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8728c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8729d = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f8731g = new w(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f8732h = new Runnable() { // from class: androidx.lifecycle.g0
        @Override // java.lang.Runnable
        public final void run() {
            h0.i(this.f8721a);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j0.a f8733i = new d();

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8734a = new a();

        @JvmStatic
        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.g(activity, "activity");
            Intrinsics.g(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final u a() {
            return h0.f8725k;
        }

        @JvmStatic
        public final void b(Context context) {
            Intrinsics.g(context, "context");
            h0.f8725k.h(context);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends j {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends j {
            final /* synthetic */ h0 this$0;

            public a(h0 h0Var) {
                this.this$0 = h0Var;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                Intrinsics.g(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                Intrinsics.g(activity, "activity");
                this.this$0.f();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.j, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.g(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                j0.f8742b.b(activity).f(h0.this.f8733i);
            }
        }

        @Override // androidx.lifecycle.j, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.g(activity, "activity");
            h0.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            Intrinsics.g(activity, "activity");
            a.a(activity, new a(h0.this));
        }

        @Override // androidx.lifecycle.j, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.g(activity, "activity");
            h0.this.g();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements j0.a {
        public d() {
        }

        @Override // androidx.lifecycle.j0.a
        public void onCreate() {
        }

        @Override // androidx.lifecycle.j0.a
        public void onResume() {
            h0.this.e();
        }

        @Override // androidx.lifecycle.j0.a
        public void onStart() {
            h0.this.f();
        }
    }

    public static final void i(h0 this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.j();
        this$0.k();
    }

    public final void d() {
        int i11 = this.f8727b - 1;
        this.f8727b = i11;
        if (i11 == 0) {
            Handler handler = this.f8730f;
            Intrinsics.d(handler);
            handler.postDelayed(this.f8732h, 700L);
        }
    }

    public final void e() {
        int i11 = this.f8727b + 1;
        this.f8727b = i11;
        if (i11 == 1) {
            if (this.f8728c) {
                this.f8731g.i(Lifecycle.Event.ON_RESUME);
                this.f8728c = false;
            } else {
                Handler handler = this.f8730f;
                Intrinsics.d(handler);
                handler.removeCallbacks(this.f8732h);
            }
        }
    }

    public final void f() {
        int i11 = this.f8726a + 1;
        this.f8726a = i11;
        if (i11 == 1 && this.f8729d) {
            this.f8731g.i(Lifecycle.Event.ON_START);
            this.f8729d = false;
        }
    }

    public final void g() {
        this.f8726a--;
        k();
    }

    @Override // androidx.lifecycle.u
    public Lifecycle getLifecycle() {
        return this.f8731g;
    }

    public final void h(Context context) {
        Intrinsics.g(context, "context");
        this.f8730f = new Handler();
        this.f8731g.i(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.e(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void j() {
        if (this.f8727b == 0) {
            this.f8728c = true;
            this.f8731g.i(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f8726a == 0 && this.f8728c) {
            this.f8731g.i(Lifecycle.Event.ON_STOP);
            this.f8729d = true;
        }
    }
}
