package androidx.compose.ui.text.font;

import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f5838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f5839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5842e;

    public n0(i iVar, u uVar, int i11, int i12, Object obj) {
        this.f5838a = iVar;
        this.f5839b = uVar;
        this.f5840c = i11;
        this.f5841d = i12;
        this.f5842e = obj;
    }

    public /* synthetic */ n0(i iVar, u uVar, int i11, int i12, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, uVar, i11, i12, obj);
    }

    public static /* synthetic */ n0 b(n0 n0Var, i iVar, u uVar, int i11, int i12, Object obj, int i13, Object obj2) {
        if ((i13 & 1) != 0) {
            iVar = n0Var.f5838a;
        }
        if ((i13 & 2) != 0) {
            uVar = n0Var.f5839b;
        }
        u uVar2 = uVar;
        if ((i13 & 4) != 0) {
            i11 = n0Var.f5840c;
        }
        int i14 = i11;
        if ((i13 & 8) != 0) {
            i12 = n0Var.f5841d;
        }
        int i15 = i12;
        if ((i13 & 16) != 0) {
            obj = n0Var.f5842e;
        }
        return n0Var.a(iVar, uVar2, i14, i15, obj);
    }

    public final n0 a(i iVar, u uVar, int i11, int i12, Object obj) {
        return new n0(iVar, uVar, i11, i12, obj, null);
    }

    public final i c() {
        return this.f5838a;
    }

    public final int d() {
        return this.f5840c;
    }

    public final int e() {
        return this.f5841d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return Intrinsics.b(this.f5838a, n0Var.f5838a) && Intrinsics.b(this.f5839b, n0Var.f5839b) && q.f(this.f5840c, n0Var.f5840c) && r.e(this.f5841d, n0Var.f5841d) && Intrinsics.b(this.f5842e, n0Var.f5842e);
    }

    public final u f() {
        return this.f5839b;
    }

    public int hashCode() {
        i iVar = this.f5838a;
        int iHashCode = (((((((iVar == null ? 0 : iVar.hashCode()) * 31) + this.f5839b.hashCode()) * 31) + q.g(this.f5840c)) * 31) + r.f(this.f5841d)) * 31;
        Object obj = this.f5842e;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "TypefaceRequest(fontFamily=" + this.f5838a + ", fontWeight=" + this.f5839b + ", fontStyle=" + ((Object) q.h(this.f5840c)) + ", fontSynthesis=" + ((Object) r.i(this.f5841d)) + ", resourceLoaderCacheKey=" + this.f5842e + ')';
    }
}
