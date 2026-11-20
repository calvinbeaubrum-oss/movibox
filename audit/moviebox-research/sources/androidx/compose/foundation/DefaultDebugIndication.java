package androidx.compose.foundation;

import androidx.compose.ui.graphics.w1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DefaultDebugIndication implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultDebugIndication f2222a = new DefaultDebugIndication();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DefaultDebugIndicationInstance extends androidx.compose.ui.f.c implements androidx.compose.ui.node.n {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final o1.g f2223o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f2224p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f2225q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f2226r;

        public DefaultDebugIndicationInstance(o1.g gVar) {
            this.f2223o = gVar;
        }

        @Override // androidx.compose.ui.node.n
        public void A(z1.c cVar) {
            cVar.a1();
            if (this.f2224p) {
                z1.f.j(cVar, w1.k(w1.f4564b.a(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, cVar.i(), 0.0f, null, null, 0, 122, null);
            } else if (this.f2225q || this.f2226r) {
                z1.f.j(cVar, w1.k(w1.f4564b.a(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0L, cVar.i(), 0.0f, null, null, 0, 122, null);
            }
        }

        @Override // androidx.compose.ui.node.n
        public /* synthetic */ void F0() {
            androidx.compose.ui.node.m.a(this);
        }

        @Override // androidx.compose.ui.f.c
        public void r1() {
            kotlinx.coroutines.j.d(h1(), null, null, new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this, null), 3, null);
        }
    }

    @Override // androidx.compose.foundation.b0
    public androidx.compose.ui.node.f a(o1.g gVar) {
        return new DefaultDebugIndicationInstance(gVar);
    }

    @Override // androidx.compose.foundation.x
    public /* synthetic */ y b(o1.g gVar, androidx.compose.runtime.i iVar, int i11) {
        return w.a(this, gVar, iVar, i11);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return -1;
    }
}
