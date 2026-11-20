package androidx.compose.ui.text.input;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f5954g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p f5955h = new p(false, 0, false, 0, 0, null, null, 127, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p2.i f5961f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a() {
            return p.f5955h;
        }
    }

    public p(boolean z11, int i11, boolean z12, int i12, int i13, w wVar, p2.i iVar) {
        this.f5956a = z11;
        this.f5957b = i11;
        this.f5958c = z12;
        this.f5959d = i12;
        this.f5960e = i13;
        this.f5961f = iVar;
    }

    public /* synthetic */ p(boolean z11, int i11, boolean z12, int i12, int i13, w wVar, p2.i iVar, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? false : z11, (i14 & 2) != 0 ? t.f5962a.b() : i11, (i14 & 4) != 0 ? true : z12, (i14 & 8) != 0 ? u.f5968a.h() : i12, (i14 & 16) != 0 ? o.f5943b.a() : i13, (i14 & 32) != 0 ? null : wVar, (i14 & 64) != 0 ? p2.i.f73512c.b() : iVar, null);
    }

    public /* synthetic */ p(boolean z11, int i11, boolean z12, int i12, int i13, w wVar, p2.i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, i11, z12, i12, i13, wVar, iVar);
    }

    public final boolean b() {
        return this.f5958c;
    }

    public final int c() {
        return this.f5957b;
    }

    public final int d() {
        return this.f5960e;
    }

    public final int e() {
        return this.f5959d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f5956a != pVar.f5956a || !t.f(this.f5957b, pVar.f5957b) || this.f5958c != pVar.f5958c || !u.k(this.f5959d, pVar.f5959d) || !o.l(this.f5960e, pVar.f5960e)) {
            return false;
        }
        pVar.getClass();
        return Intrinsics.b(null, null) && Intrinsics.b(this.f5961f, pVar.f5961f);
    }

    public final w f() {
        return null;
    }

    public final boolean g() {
        return this.f5956a;
    }

    public int hashCode() {
        return (((((((((androidx.compose.foundation.e.a(this.f5956a) * 31) + t.g(this.f5957b)) * 31) + androidx.compose.foundation.e.a(this.f5958c)) * 31) + u.l(this.f5959d)) * 31) + o.m(this.f5960e)) * 961) + this.f5961f.hashCode();
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.f5956a + ", capitalization=" + ((Object) t.h(this.f5957b)) + ", autoCorrect=" + this.f5958c + ", keyboardType=" + ((Object) u.m(this.f5959d)) + ", imeAction=" + ((Object) o.n(this.f5960e)) + ", platformImeOptions=" + ((Object) null) + ", hintLocales=" + this.f5961f + ')';
    }
}
