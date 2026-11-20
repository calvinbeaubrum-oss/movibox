package com.transsion.postdetail.layer;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;

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
public final class SystemTimeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f55080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f55081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f55082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HandlerThread f55083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f55084e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        long a();
    }

    public SystemTimeManager(a aVar) {
        HandlerThread handlerThread = new HandlerThread("SystemTimeManager");
        this.f55083d = handlerThread;
        this.f55084e = new Runnable() { // from class: com.transsion.postdetail.layer.SystemTimeManager$mTrackingRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.f55081b == null) {
                    this.this$0.e();
                    return;
                }
                SystemTimeManager.a aVar2 = this.this$0.f55081b;
                Long lValueOf = aVar2 != null ? Long.valueOf(aVar2.a()) : null;
                if (lValueOf != null) {
                    if (lValueOf.longValue() <= 0) {
                        this.this$0.e();
                        return;
                    }
                    Handler handler = this.this$0.f55080a;
                    if (handler != null) {
                        handler.postDelayed(this, lValueOf.longValue());
                    }
                }
            }
        };
        handlerThread.start();
        this.f55080a = new Handler(handlerThread.getLooper());
        this.f55081b = aVar;
    }

    public final void c() {
        e();
        this.f55082c = false;
        Handler handler = this.f55080a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f55080a = null;
        this.f55081b = null;
        this.f55083d.quitSafely();
    }

    public final void d() {
        if (this.f55082c) {
            return;
        }
        this.f55082c = true;
        Handler handler = this.f55080a;
        if (handler != null) {
            handler.removeCallbacks(this.f55084e);
        }
        Handler handler2 = this.f55080a;
        if (handler2 != null) {
            handler2.post(this.f55084e);
        }
    }

    public final void e() {
        if (this.f55082c) {
            this.f55082c = false;
            Handler handler = this.f55080a;
            if (handler != null) {
                handler.removeCallbacks(this.f55084e);
            }
        }
    }
}
