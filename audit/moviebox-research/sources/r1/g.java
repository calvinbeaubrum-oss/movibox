package r1;

import androidx.compose.runtime.a2;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.o1;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class g extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f75075i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f75076j = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75078b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f75080d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f75082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f75083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f75084h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d[] f75077a = new d[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f75079c = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f75081e = new Object[16];

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f75085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f75086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f75087c;

        public b() {
        }

        @Override // r1.e
        public <T> T a(int i11) {
            return (T) g.this.f75081e[this.f75087c + i11];
        }

        @Override // r1.e
        public int b(int i11) {
            return g.this.f75079c[this.f75086b + i11];
        }

        public final d c() {
            d dVar = g.this.f75077a[this.f75085a];
            Intrinsics.d(dVar);
            return dVar;
        }

        public final boolean d() {
            if (this.f75085a >= g.this.f75078b) {
                return false;
            }
            d dVarC = c();
            this.f75086b += dVarC.b();
            this.f75087c += dVarC.d();
            int i11 = this.f75085a + 1;
            this.f75085a = i11;
            return i11 < g.this.f75078b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    @SourceDebugExtension
    public static final class c {
        public static g a(g gVar) {
            return gVar;
        }

        public static final d b(g gVar) {
            return gVar.v();
        }

        public static final void c(g gVar, int i11, int i12) {
            int i13 = 1 << i11;
            if (!((gVar.f75083g & i13) == 0)) {
                o1.b("Already pushed argument " + b(gVar).e(i11));
            }
            gVar.f75083g |= i13;
            gVar.f75079c[gVar.z(i11)] = i12;
        }

        public static final <T> void d(g gVar, int i11, T t11) {
            int i12 = 1 << i11;
            if (!((gVar.f75084h & i12) == 0)) {
                o1.b("Already pushed argument " + b(gVar).f(i11));
            }
            gVar.f75084h |= i12;
            gVar.f75081e[gVar.A(i11)] = t11;
        }
    }

    public final int A(int i11) {
        return (this.f75082f - v().d()) + i11;
    }

    public final void m() {
        this.f75078b = 0;
        this.f75080d = 0;
        ArraysKt___ArraysJvmKt.u(this.f75081e, null, 0, this.f75082f);
        this.f75082f = 0;
    }

    public final int n(int i11) {
        if (i11 == 0) {
            return 0;
        }
        return (-1) >>> (32 - i11);
    }

    public final int o(int i11, int i12) {
        return kotlin.ranges.a.d(i11 + kotlin.ranges.a.g(i11, 1024), i12);
    }

    public final void p(int i11) {
        int[] iArr = this.f75079c;
        int length = iArr.length;
        if (i11 > length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, o(length, i11));
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f75079c = iArrCopyOf;
        }
    }

    public final void q(int i11) {
        Object[] objArr = this.f75081e;
        int length = objArr.length;
        if (i11 > length) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, o(length, i11));
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f75081e = objArrCopyOf;
        }
    }

    public final void r(androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
        if (u()) {
            b bVar = new b();
            do {
                bVar.c().a(bVar, fVar, m2Var, a2Var);
            } while (bVar.d());
        }
        m();
    }

    public final int s() {
        return this.f75078b;
    }

    public final boolean t() {
        return s() == 0;
    }

    @Deprecated
    public String toString() {
        return super.toString();
    }

    public final boolean u() {
        return s() != 0;
    }

    public final d v() {
        d dVar = this.f75077a[this.f75078b - 1];
        Intrinsics.d(dVar);
        return dVar;
    }

    public final void w(g gVar) {
        if (t()) {
            throw new NoSuchElementException("Cannot pop(), because the stack is empty.");
        }
        d[] dVarArr = this.f75077a;
        int i11 = this.f75078b - 1;
        this.f75078b = i11;
        d dVar = dVarArr[i11];
        Intrinsics.d(dVar);
        this.f75077a[this.f75078b] = null;
        gVar.y(dVar);
        int i12 = this.f75082f;
        int i13 = gVar.f75082f;
        int iD = dVar.d();
        for (int i14 = 0; i14 < iD; i14++) {
            i13--;
            i12--;
            Object[] objArr = gVar.f75081e;
            Object[] objArr2 = this.f75081e;
            objArr[i13] = objArr2[i12];
            objArr2[i12] = null;
        }
        int i15 = this.f75080d;
        int i16 = gVar.f75080d;
        int iB = dVar.b();
        for (int i17 = 0; i17 < iB; i17++) {
            i16--;
            i15--;
            int[] iArr = gVar.f75079c;
            int[] iArr2 = this.f75079c;
            iArr[i16] = iArr2[i15];
            iArr2[i15] = 0;
        }
        this.f75082f -= dVar.d();
        this.f75080d -= dVar.b();
    }

    public final void x(d dVar) {
        if (!(dVar.b() == 0 && dVar.d() == 0)) {
            o1.a("Cannot push " + dVar + " without arguments because it expects " + dVar.b() + " ints and " + dVar.d() + " objects.");
        }
        y(dVar);
    }

    public final void y(d dVar) {
        this.f75083g = 0;
        this.f75084h = 0;
        int i11 = this.f75078b;
        if (i11 == this.f75077a.length) {
            Object[] objArrCopyOf = Arrays.copyOf(this.f75077a, this.f75078b + kotlin.ranges.a.g(i11, 1024));
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f75077a = (d[]) objArrCopyOf;
        }
        p(this.f75080d + dVar.b());
        q(this.f75082f + dVar.d());
        d[] dVarArr = this.f75077a;
        int i12 = this.f75078b;
        this.f75078b = i12 + 1;
        dVarArr[i12] = dVar;
        this.f75080d += dVar.b();
        this.f75082f += dVar.d();
    }

    public final int z(int i11) {
        return (this.f75080d - v().b()) + i11;
    }
}
