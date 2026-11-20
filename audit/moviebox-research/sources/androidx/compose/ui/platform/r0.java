package androidx.compose.ui.platform;

import android.view.ViewConfiguration;
import kotlin.Metadata;

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
public final class r0 implements r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewConfiguration f5545a;

    public r0(ViewConfiguration viewConfiguration) {
        this.f5545a = viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.r2
    public long a() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // androidx.compose.ui.platform.r2
    public long b() {
        return 40L;
    }

    @Override // androidx.compose.ui.platform.r2
    public long c() {
        return ViewConfiguration.getLongPressTimeout();
    }

    @Override // androidx.compose.ui.platform.r2
    public /* synthetic */ long d() {
        return q2.b(this);
    }

    @Override // androidx.compose.ui.platform.r2
    public float e() {
        return this.f5545a.getScaledMaximumFlingVelocity();
    }

    @Override // androidx.compose.ui.platform.r2
    public float f() {
        return this.f5545a.getScaledTouchSlop();
    }
}
