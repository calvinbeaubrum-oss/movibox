package androidx.compose.ui.text;

import androidx.compose.ui.unit.LayoutDirection;
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
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnotatedString f6178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f6179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AnnotatedString.b<t>> f6180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q2.e f6184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LayoutDirection f6185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.compose.ui.text.font.i.b f6186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f6187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.compose.ui.text.font.h.a f6188k;

    public z(AnnotatedString annotatedString, e0 e0Var, List<AnnotatedString.b<t>> list, int i11, boolean z11, int i12, q2.e eVar, LayoutDirection layoutDirection, androidx.compose.ui.text.font.h.a aVar, androidx.compose.ui.text.font.i.b bVar, long j11) {
        this.f6178a = annotatedString;
        this.f6179b = e0Var;
        this.f6180c = list;
        this.f6181d = i11;
        this.f6182e = z11;
        this.f6183f = i12;
        this.f6184g = eVar;
        this.f6185h = layoutDirection;
        this.f6186i = bVar;
        this.f6187j = j11;
        this.f6188k = aVar;
    }

    public z(AnnotatedString annotatedString, e0 e0Var, List<AnnotatedString.b<t>> list, int i11, boolean z11, int i12, q2.e eVar, LayoutDirection layoutDirection, androidx.compose.ui.text.font.i.b bVar, long j11) {
        this(annotatedString, e0Var, list, i11, z11, i12, eVar, layoutDirection, (androidx.compose.ui.text.font.h.a) null, bVar, j11);
    }

    public /* synthetic */ z(AnnotatedString annotatedString, e0 e0Var, List list, int i11, boolean z11, int i12, q2.e eVar, LayoutDirection layoutDirection, androidx.compose.ui.text.font.i.b bVar, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, e0Var, list, i11, z11, i12, eVar, layoutDirection, bVar, j11);
    }

    public final long a() {
        return this.f6187j;
    }

    public final q2.e b() {
        return this.f6184g;
    }

    public final androidx.compose.ui.text.font.i.b c() {
        return this.f6186i;
    }

    public final LayoutDirection d() {
        return this.f6185h;
    }

    public final int e() {
        return this.f6181d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return Intrinsics.b(this.f6178a, zVar.f6178a) && Intrinsics.b(this.f6179b, zVar.f6179b) && Intrinsics.b(this.f6180c, zVar.f6180c) && this.f6181d == zVar.f6181d && this.f6182e == zVar.f6182e && androidx.compose.ui.text.style.p.e(this.f6183f, zVar.f6183f) && Intrinsics.b(this.f6184g, zVar.f6184g) && this.f6185h == zVar.f6185h && Intrinsics.b(this.f6186i, zVar.f6186i) && q2.b.f(this.f6187j, zVar.f6187j);
    }

    public final int f() {
        return this.f6183f;
    }

    public final List<AnnotatedString.b<t>> g() {
        return this.f6180c;
    }

    public final boolean h() {
        return this.f6182e;
    }

    public int hashCode() {
        return (((((((((((((((((this.f6178a.hashCode() * 31) + this.f6179b.hashCode()) * 31) + this.f6180c.hashCode()) * 31) + this.f6181d) * 31) + androidx.compose.foundation.e.a(this.f6182e)) * 31) + androidx.compose.ui.text.style.p.f(this.f6183f)) * 31) + this.f6184g.hashCode()) * 31) + this.f6185h.hashCode()) * 31) + this.f6186i.hashCode()) * 31) + q2.b.o(this.f6187j);
    }

    public final e0 i() {
        return this.f6179b;
    }

    public final AnnotatedString j() {
        return this.f6178a;
    }

    public String toString() {
        return "TextLayoutInput(text=" + ((Object) this.f6178a) + ", style=" + this.f6179b + ", placeholders=" + this.f6180c + ", maxLines=" + this.f6181d + ", softWrap=" + this.f6182e + ", overflow=" + ((Object) androidx.compose.ui.text.style.p.g(this.f6183f)) + ", density=" + this.f6184g + ", layoutDirection=" + this.f6185h + ", fontFamilyResolver=" + this.f6186i + ", constraints=" + ((Object) q2.b.q(this.f6187j)) + ')';
    }
}
