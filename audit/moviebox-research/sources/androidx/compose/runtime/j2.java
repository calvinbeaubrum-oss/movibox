package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class j2 implements w1.a, Iterable<w1.b>, KMappedMarker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3454b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3456d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3459h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap<c, l0> f3461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.collection.c0<androidx.collection.d0> f3462k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f3453a = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f3455c = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<c> f3460i = new ArrayList<>();

    public final int A() {
        return this.f3459h;
    }

    public final boolean B() {
        return this.f3458g;
    }

    public final boolean C(int i11, c cVar) {
        if (!(!this.f3458g)) {
            k.s("Writer is active");
        }
        if (!(i11 >= 0 && i11 < this.f3454b)) {
            k.s("Invalid group index");
        }
        if (F(cVar)) {
            int I = l2.I(this.f3453a, i11) + i11;
            int iA = cVar.a();
            if (i11 <= iA && iA < I) {
                return true;
            }
        }
        return false;
    }

    public final i2 D() {
        if (this.f3458g) {
            throw new IllegalStateException("Cannot read while a writer is pending".toString());
        }
        this.f3457f++;
        return new i2(this);
    }

    public final m2 E() {
        if (!(!this.f3458g)) {
            k.s("Cannot start a writer when another writer is pending");
        }
        if (!(this.f3457f <= 0)) {
            k.s("Cannot start a writer when a reader is pending");
        }
        this.f3458g = true;
        this.f3459h++;
        return new m2(this);
    }

    public final boolean F(c cVar) {
        int iU;
        return cVar.b() && (iU = l2.U(this.f3460i, cVar.a(), this.f3454b)) >= 0 && Intrinsics.b(this.f3460i.get(iU), cVar);
    }

    public final void G(int[] iArr, int i11, Object[] objArr, int i12, ArrayList<c> arrayList, HashMap<c, l0> map, androidx.collection.c0<androidx.collection.d0> c0Var) {
        this.f3453a = iArr;
        this.f3454b = i11;
        this.f3455c = objArr;
        this.f3456d = i12;
        this.f3460i = arrayList;
        this.f3461j = map;
        this.f3462k = c0Var;
    }

    public final Object H(int i11, int i12) {
        int iV = l2.V(this.f3453a, i11);
        int i13 = i11 + 1;
        return (i12 < 0 || i12 >= (i13 < this.f3454b ? l2.F(this.f3453a, i13) : this.f3455c.length) - iV) ? i.f3413a.a() : this.f3455c[iV + i12];
    }

    public final l0 I(int i11) {
        c cVarJ;
        HashMap<c, l0> map = this.f3461j;
        if (map == null || (cVarJ = J(i11)) == null) {
            return null;
        }
        return map.get(cVarJ);
    }

    public final c J(int i11) {
        int i12;
        if (!(!this.f3458g)) {
            k.s("use active SlotWriter to crate an anchor for location instead");
        }
        if (i11 < 0 || i11 >= (i12 = this.f3454b)) {
            return null;
        }
        return l2.G(this.f3460i, i11, i12);
    }

    public final c a(int i11) {
        if (!(!this.f3458g)) {
            k.s("use active SlotWriter to create an anchor location instead");
        }
        boolean z11 = false;
        if (i11 >= 0 && i11 < this.f3454b) {
            z11 = true;
        }
        if (!z11) {
            o1.a("Parameter index is out of range");
        }
        ArrayList<c> arrayList = this.f3460i;
        int iU = l2.U(arrayList, i11, this.f3454b);
        if (iU >= 0) {
            return arrayList.get(iU);
        }
        c cVar = new c(i11);
        arrayList.add(-(iU + 1), cVar);
        return cVar;
    }

    public final int e(c cVar) {
        if (!(!this.f3458g)) {
            k.s("Use active SlotWriter to determine anchor location instead");
        }
        if (!cVar.b()) {
            o1.a("Anchor refers to a group that was removed");
        }
        return cVar.a();
    }

    public final void f(i2 i2Var, HashMap<c, l0> map) {
        if (!(i2Var.y() == this && this.f3457f > 0)) {
            k.s("Unexpected reader close()");
        }
        this.f3457f--;
        if (map != null) {
            synchronized (this) {
                try {
                    HashMap<c, l0> map2 = this.f3461j;
                    if (map2 != null) {
                        map2.putAll(map);
                    } else {
                        this.f3461j = map;
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void g(m2 m2Var, int[] iArr, int i11, Object[] objArr, int i12, ArrayList<c> arrayList, HashMap<c, l0> map, androidx.collection.c0<androidx.collection.d0> c0Var) {
        if (!(m2Var.h0() == this && this.f3458g)) {
            o1.a("Unexpected writer close()");
        }
        this.f3458g = false;
        G(iArr, i11, objArr, i12, arrayList, map, c0Var);
    }

    public final void i() {
        this.f3462k = new androidx.collection.c0<>(0, 1, null);
    }

    public boolean isEmpty() {
        return this.f3454b == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<w1.b> iterator() {
        return new j0(this, 0, this.f3454b);
    }

    public final void j() {
        this.f3461j = new HashMap<>();
    }

    public final boolean r() {
        return this.f3454b > 0 && l2.D(this.f3453a, 0);
    }

    public final ArrayList<c> s() {
        return this.f3460i;
    }

    public final androidx.collection.c0<androidx.collection.d0> u() {
        return this.f3462k;
    }

    public final int[] v() {
        return this.f3453a;
    }

    public final int w() {
        return this.f3454b;
    }

    public final Object[] x() {
        return this.f3455c;
    }

    public final int y() {
        return this.f3456d;
    }

    public final HashMap<c, l0> z() {
        return this.f3461j;
    }
}
