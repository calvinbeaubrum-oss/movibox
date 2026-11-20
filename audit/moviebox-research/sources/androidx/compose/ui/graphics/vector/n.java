package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.f5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.s4;
import java.util.List;
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
public final class n extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f4551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l1 f4553d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l1 f4555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f4557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f4560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f4561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f4562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f4563o;

    /* JADX WARN: Multi-variable type inference failed */
    public n(String str, List<? extends e> list, int i11, l1 l1Var, float f11, l1 l1Var2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17) {
        super(null);
        this.f4550a = str;
        this.f4551b = list;
        this.f4552c = i11;
        this.f4553d = l1Var;
        this.f4554f = f11;
        this.f4555g = l1Var2;
        this.f4556h = f12;
        this.f4557i = f13;
        this.f4558j = i12;
        this.f4559k = i13;
        this.f4560l = f14;
        this.f4561m = f15;
        this.f4562n = f16;
        this.f4563o = f17;
    }

    public /* synthetic */ n(String str, List list, int i11, l1 l1Var, float f11, l1 l1Var2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i11, l1Var, f11, l1Var2, f12, f13, i12, i13, f14, f15, f16, f17);
    }

    public final l1 a() {
        return this.f4553d;
    }

    public final float e() {
        return this.f4554f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            return Intrinsics.b(this.f4550a, nVar.f4550a) && Intrinsics.b(this.f4553d, nVar.f4553d) && this.f4554f == nVar.f4554f && Intrinsics.b(this.f4555g, nVar.f4555g) && this.f4556h == nVar.f4556h && this.f4557i == nVar.f4557i && e5.e(this.f4558j, nVar.f4558j) && f5.e(this.f4559k, nVar.f4559k) && this.f4560l == nVar.f4560l && this.f4561m == nVar.f4561m && this.f4562n == nVar.f4562n && this.f4563o == nVar.f4563o && s4.d(this.f4552c, nVar.f4552c) && Intrinsics.b(this.f4551b, nVar.f4551b);
        }
        return false;
    }

    public final String f() {
        return this.f4550a;
    }

    public final List<e> g() {
        return this.f4551b;
    }

    public int hashCode() {
        int iHashCode = ((this.f4550a.hashCode() * 31) + this.f4551b.hashCode()) * 31;
        l1 l1Var = this.f4553d;
        int iHashCode2 = (((iHashCode + (l1Var != null ? l1Var.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f4554f)) * 31;
        l1 l1Var2 = this.f4555g;
        return ((((((((((((((((((iHashCode2 + (l1Var2 != null ? l1Var2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f4556h)) * 31) + Float.floatToIntBits(this.f4557i)) * 31) + e5.f(this.f4558j)) * 31) + f5.f(this.f4559k)) * 31) + Float.floatToIntBits(this.f4560l)) * 31) + Float.floatToIntBits(this.f4561m)) * 31) + Float.floatToIntBits(this.f4562n)) * 31) + Float.floatToIntBits(this.f4563o)) * 31) + s4.e(this.f4552c);
    }

    public final int i() {
        return this.f4552c;
    }

    public final l1 j() {
        return this.f4555g;
    }

    public final float r() {
        return this.f4556h;
    }

    public final int s() {
        return this.f4558j;
    }

    public final int u() {
        return this.f4559k;
    }

    public final float v() {
        return this.f4560l;
    }

    public final float w() {
        return this.f4557i;
    }

    public final float x() {
        return this.f4562n;
    }

    public final float y() {
        return this.f4563o;
    }

    public final float z() {
        return this.f4561m;
    }
}
