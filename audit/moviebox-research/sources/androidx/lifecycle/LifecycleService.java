package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class LifecycleService extends Service implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ServiceLifecycleDispatcher f8660a = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.u
    public Lifecycle getLifecycle() {
        return this.f8660a.a();
    }

    @Override // android.app.Service
    @CallSuper
    public IBinder onBind(Intent intent) {
        Intrinsics.g(intent, "intent");
        this.f8660a.b();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.f8660a.c();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.f8660a.d();
        super.onDestroy();
    }

    @Override // android.app.Service
    @Deprecated
    @CallSuper
    public void onStart(Intent intent, int i11) {
        this.f8660a.e();
        super.onStart(intent, i11);
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(Intent intent, int i11, int i12) {
        return super.onStartCommand(intent, i11, i12);
    }
}
