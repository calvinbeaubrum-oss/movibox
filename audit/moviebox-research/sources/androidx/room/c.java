package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f12819m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g6.h f12820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f12821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f12822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f12825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g6.g f12828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f12830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f12831l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(long j11, TimeUnit autoCloseTimeUnit, Executor autoCloseExecutor) {
        Intrinsics.g(autoCloseTimeUnit, "autoCloseTimeUnit");
        Intrinsics.g(autoCloseExecutor, "autoCloseExecutor");
        this.f12821b = new Handler(Looper.getMainLooper());
        this.f12823d = new Object();
        this.f12824e = autoCloseTimeUnit.toMillis(j11);
        this.f12825f = autoCloseExecutor;
        this.f12827h = SystemClock.uptimeMillis();
        this.f12830k = new Runnable() { // from class: androidx.room.a
            @Override // java.lang.Runnable
            public final void run() {
                c.f(this.f12810a);
            }
        };
        this.f12831l = new Runnable() { // from class: androidx.room.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c(this.f12815a);
            }
        };
    }

    public static final void c(c this$0) {
        Unit unit;
        Intrinsics.g(this$0, "this$0");
        synchronized (this$0.f12823d) {
            try {
                if (SystemClock.uptimeMillis() - this$0.f12827h < this$0.f12824e) {
                    return;
                }
                if (this$0.f12826g != 0) {
                    return;
                }
                Runnable runnable = this$0.f12822c;
                if (runnable != null) {
                    runnable.run();
                    unit = Unit.f68710a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());
                }
                g6.g gVar = this$0.f12828i;
                if (gVar != null && gVar.isOpen()) {
                    gVar.close();
                }
                this$0.f12828i = null;
                Unit unit2 = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static final void f(c this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f12825f.execute(this$0.f12831l);
    }

    public final void d() throws IOException {
        synchronized (this.f12823d) {
            try {
                this.f12829j = true;
                g6.g gVar = this.f12828i;
                if (gVar != null) {
                    gVar.close();
                }
                this.f12828i = null;
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e() {
        synchronized (this.f12823d) {
            try {
                int i11 = this.f12826g;
                if (i11 <= 0) {
                    throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());
                }
                int i12 = i11 - 1;
                this.f12826g = i12;
                if (i12 == 0) {
                    if (this.f12828i == null) {
                        return;
                    } else {
                        this.f12821b.postDelayed(this.f12830k, this.f12824e);
                    }
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final <V> V g(Function1<? super g6.g, ? extends V> block) {
        Intrinsics.g(block, "block");
        try {
            return block.invoke(j());
        } finally {
            e();
        }
    }

    public final g6.g h() {
        return this.f12828i;
    }

    public final g6.h i() {
        g6.h hVar = this.f12820a;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.y("delegateOpenHelper");
        return null;
    }

    public final g6.g j() {
        synchronized (this.f12823d) {
            this.f12821b.removeCallbacks(this.f12830k);
            this.f12826g++;
            if (!(!this.f12829j)) {
                throw new IllegalStateException("Attempting to open already closed database.".toString());
            }
            g6.g gVar = this.f12828i;
            if (gVar != null && gVar.isOpen()) {
                return gVar;
            }
            g6.g writableDatabase = i().getWritableDatabase();
            this.f12828i = writableDatabase;
            return writableDatabase;
        }
    }

    public final void k(g6.h delegateOpenHelper) {
        Intrinsics.g(delegateOpenHelper, "delegateOpenHelper");
        m(delegateOpenHelper);
    }

    public final void l(Runnable onAutoClose) {
        Intrinsics.g(onAutoClose, "onAutoClose");
        this.f12822c = onAutoClose;
    }

    public final void m(g6.h hVar) {
        Intrinsics.g(hVar, "<set-?>");
        this.f12820a = hVar;
    }
}
