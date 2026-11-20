package com.cloud.tmc.integration.audio.recording;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RecorderTimer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f30420f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f30421g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f30423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f30424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f30425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f30426e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void onTick(long j11);
    }

    public final long b() {
        long jCurrentTimeMillis;
        long j11;
        if (!this.f30425d) {
            return 0L;
        }
        if (this.f30424c) {
            jCurrentTimeMillis = this.f30423b;
            j11 = this.f30422a;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            j11 = this.f30422a;
        }
        return jCurrentTimeMillis - j11;
    }

    public final void c() {
        if (this.f30425d && !this.f30424c) {
            this.f30423b = System.currentTimeMillis();
            this.f30424c = true;
        }
        e();
    }

    public final void d() {
        this.f30422a = 0L;
        this.f30423b = 0L;
        this.f30424c = false;
        this.f30425d = false;
        e();
    }

    public final void e() {
        f30421g.removeCallbacksAndMessages(null);
    }

    public final void f() {
        if (this.f30425d && this.f30424c) {
            this.f30422a += System.currentTimeMillis() - this.f30423b;
            this.f30424c = false;
        }
        g();
    }

    public final void g() {
        e();
        final b bVar = this.f30426e;
        if (bVar != null) {
            f30421g.post(new Runnable() { // from class: com.cloud.tmc.integration.audio.recording.RecorderTimer$scheduleTimer$1$1
                @Override // java.lang.Runnable
                public void run() {
                    bVar.onTick(this.b());
                    RecorderTimer.f30421g.postDelayed(this, 13L);
                }
            });
        }
    }

    public final void h(b bVar) {
        this.f30426e = bVar;
    }

    public final void i() {
        if (!this.f30425d) {
            this.f30422a = System.currentTimeMillis();
            this.f30425d = true;
        } else if (this.f30424c) {
            this.f30422a += System.currentTimeMillis() - this.f30423b;
            this.f30424c = false;
        }
        g();
    }
}
