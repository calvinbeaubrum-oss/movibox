package androidx.compose.foundation.text.selection;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public enum SelectionMode {
    Vertical { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo36compare3MmeM6k$foundation_release(long j11, y1.i iVar) {
            if (i.a(iVar, j11)) {
                return 0;
            }
            if (y1.g.n(j11) < iVar.i()) {
                return -1;
            }
            return (y1.g.m(j11) >= iVar.f() || y1.g.n(j11) >= iVar.c()) ? 1 : -1;
        }
    },
    Horizontal { // from class: androidx.compose.foundation.text.selection.SelectionMode.Horizontal
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo36compare3MmeM6k$foundation_release(long j11, y1.i iVar) {
            if (i.a(iVar, j11)) {
                return 0;
            }
            if (y1.g.m(j11) < iVar.f()) {
                return -1;
            }
            return (y1.g.n(j11) >= iVar.i() || y1.g.m(j11) >= iVar.g()) ? 1 : -1;
        }
    };

    /* synthetic */ SelectionMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    private final boolean m35containsInclusiveUv8p0NA(y1.i iVar, long j11) {
        float f11 = iVar.f();
        float fG = iVar.g();
        float fM = y1.g.m(j11);
        if (f11 <= fM && fM <= fG) {
            float fI = iVar.i();
            float fC = iVar.c();
            float fN = y1.g.n(j11);
            if (fI <= fN && fN <= fC) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo36compare3MmeM6k$foundation_release(long j11, y1.i iVar);

    /* JADX INFO: renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m37isSelected2x9bVx0$foundation_release(y1.i iVar, long j11, long j12) {
        if (m35containsInclusiveUv8p0NA(iVar, j11) || m35containsInclusiveUv8p0NA(iVar, j12)) {
            return true;
        }
        return (mo36compare3MmeM6k$foundation_release(j11, iVar) > 0) ^ (mo36compare3MmeM6k$foundation_release(j12, iVar) > 0);
    }
}
