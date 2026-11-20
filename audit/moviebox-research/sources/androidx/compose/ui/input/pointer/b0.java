package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
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
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c0> f4674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MotionEvent f4675c;

    public b0(long j11, List<c0> list, MotionEvent motionEvent) {
        this.f4673a = j11;
        this.f4674b = list;
        this.f4675c = motionEvent;
    }

    public final MotionEvent a() {
        return this.f4675c;
    }

    public final List<c0> b() {
        return this.f4674b;
    }
}
