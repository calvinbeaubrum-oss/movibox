package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.z3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.p;
import q2.t;
import q2.u;
import y1.m;
import z1.f;
import z1.g;

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
public final class a extends Painter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g4 f4326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f4330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public x1 f4332m;

    public a(g4 g4Var, long j11, long j12) {
        this.f4326g = g4Var;
        this.f4327h = j11;
        this.f4328i = j12;
        this.f4329j = z3.f4590a.a();
        this.f4330k = k(j11, j12);
        this.f4331l = 1.0f;
    }

    public /* synthetic */ a(g4 g4Var, long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(g4Var, (i11 & 2) != 0 ? p.f74244b.a() : j11, (i11 & 4) != 0 ? u.a(g4Var.getWidth(), g4Var.getHeight()) : j12, null);
    }

    public /* synthetic */ a(g4 g4Var, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(g4Var, j11, j12);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean a(float f11) {
        this.f4331l = f11;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean b(x1 x1Var) {
        this.f4332m = x1Var;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f4326g, aVar.f4326g) && p.g(this.f4327h, aVar.f4327h) && t.e(this.f4328i, aVar.f4328i) && z3.d(this.f4329j, aVar.f4329j);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long h() {
        return u.d(this.f4330k);
    }

    public int hashCode() {
        return (((((this.f4326g.hashCode() * 31) + p.j(this.f4327h)) * 31) + t.h(this.f4328i)) * 31) + z3.e(this.f4329j);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public void j(g gVar) {
        f.e(gVar, this.f4326g, this.f4327h, this.f4328i, 0L, u.a(Math.round(m.i(gVar.i())), Math.round(m.g(gVar.i()))), this.f4331l, null, this.f4332m, 0, this.f4329j, 328, null);
    }

    public final long k(long j11, long j12) {
        if (p.h(j11) < 0 || p.i(j11) < 0 || t.g(j12) < 0 || t.f(j12) < 0 || t.g(j12) > this.f4326g.getWidth() || t.f(j12) > this.f4326g.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return j12;
    }

    public String toString() {
        return "BitmapPainter(image=" + this.f4326g + ", srcOffset=" + ((Object) p.m(this.f4327h)) + ", srcSize=" + ((Object) t.i(this.f4328i)) + ", filterQuality=" + ((Object) z3.f(this.f4329j)) + ')';
    }
}
