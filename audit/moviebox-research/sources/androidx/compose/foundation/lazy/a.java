package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.d0;
import androidx.compose.foundation.lazy.layout.i0;
import androidx.compose.foundation.lazy.layout.x;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

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
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2582b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x.b f2583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2584d;

    public a(int i11) {
        this.f2581a = i11;
    }

    @Override // androidx.compose.foundation.lazy.r
    public void a(d0 d0Var, int i11) {
        int i12 = this.f2581a;
        for (int i13 = 0; i13 < i12; i13++) {
            d0Var.a(i11 + i13);
        }
    }

    @Override // androidx.compose.foundation.lazy.r
    public void b(p pVar, float f11, l lVar) {
        x.b bVar;
        x.b bVar2;
        x.b bVar3;
        if (!lVar.h().isEmpty()) {
            boolean z11 = f11 < 0.0f;
            int index = z11 ? ((j) CollectionsKt___CollectionsKt.q0(lVar.h())).getIndex() + 1 : ((j) CollectionsKt___CollectionsKt.e0(lVar.h())).getIndex() - 1;
            if (index < 0 || index >= lVar.d()) {
                return;
            }
            if (index != this.f2582b) {
                if (this.f2584d != z11 && (bVar3 = this.f2583c) != null) {
                    bVar3.cancel();
                }
                this.f2584d = z11;
                this.f2582b = index;
                this.f2583c = pVar.a(index);
            }
            if (!z11) {
                if (lVar.g() - ((j) CollectionsKt___CollectionsKt.e0(lVar.h())).g() >= f11 || (bVar = this.f2583c) == null) {
                    return;
                }
                bVar.a();
                return;
            }
            j jVar = (j) CollectionsKt___CollectionsKt.q0(lVar.h());
            if (((jVar.g() + jVar.getSize()) + lVar.f()) - lVar.c() >= (-f11) || (bVar2 = this.f2583c) == null) {
                return;
            }
            bVar2.a();
        }
    }

    @Override // androidx.compose.foundation.lazy.r
    public /* synthetic */ i0 c() {
        return q.a(this);
    }

    @Override // androidx.compose.foundation.lazy.r
    public void d(p pVar, l lVar) {
        if (this.f2582b == -1 || !(!lVar.h().isEmpty())) {
            return;
        }
        if (this.f2582b != (this.f2584d ? ((j) CollectionsKt___CollectionsKt.q0(lVar.h())).getIndex() + 1 : ((j) CollectionsKt___CollectionsKt.e0(lVar.h())).getIndex() - 1)) {
            this.f2582b = -1;
            x.b bVar = this.f2583c;
            if (bVar != null) {
                bVar.cancel();
            }
            this.f2583c = null;
        }
    }
}
