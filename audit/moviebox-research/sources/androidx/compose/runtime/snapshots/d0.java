package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public abstract class d0 implements c0 {
    public static final int $stable = 0;
    private final AtomicInt readerKind = new AtomicInt(0);

    /* JADX INFO: renamed from: isReadIn-h_f27i8$runtime_release, reason: not valid java name */
    public final boolean m47isReadInh_f27i8$runtime_release(int i11) {
        return (i11 & f.a(this.readerKind.get())) != 0;
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public /* synthetic */ e0 mergeRecords(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        return b0.a(this, e0Var, e0Var2, e0Var3);
    }

    /* JADX INFO: renamed from: recordReadIn-h_f27i8$runtime_release, reason: not valid java name */
    public final void m48recordReadInh_f27i8$runtime_release(int i11) {
        int iA;
        do {
            iA = f.a(this.readerKind.get());
            if ((iA & i11) != 0) {
                return;
            }
        } while (!this.readerKind.compareAndSet(iA, f.a(iA | i11)));
    }
}
