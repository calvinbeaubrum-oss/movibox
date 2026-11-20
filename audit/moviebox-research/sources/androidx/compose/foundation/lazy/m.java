package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.o0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;

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
public final class m implements l, androidx.compose.ui.layout.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k0 f2761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q2.e f2762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f2763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<n> f2764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f2768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Orientation f2769o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f2770p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f2771q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ androidx.compose.ui.layout.w f2772r;

    public m(n nVar, int i11, boolean z11, float f11, androidx.compose.ui.layout.w wVar, float f12, boolean z12, k0 k0Var, q2.e eVar, long j11, List<n> list, int i12, int i13, int i14, boolean z13, Orientation orientation, int i15, int i16) {
        this.f2755a = nVar;
        this.f2756b = i11;
        this.f2757c = z11;
        this.f2758d = f11;
        this.f2759e = f12;
        this.f2760f = z12;
        this.f2761g = k0Var;
        this.f2762h = eVar;
        this.f2763i = j11;
        this.f2764j = list;
        this.f2765k = i12;
        this.f2766l = i13;
        this.f2767m = i14;
        this.f2768n = z13;
        this.f2769o = orientation;
        this.f2770p = i15;
        this.f2771q = i16;
        this.f2772r = wVar;
    }

    public /* synthetic */ m(n nVar, int i11, boolean z11, float f11, androidx.compose.ui.layout.w wVar, float f12, boolean z12, k0 k0Var, q2.e eVar, long j11, List list, int i12, int i13, int i14, boolean z13, Orientation orientation, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(nVar, i11, z11, f11, wVar, f12, z12, k0Var, eVar, j11, list, i12, i13, i14, z13, orientation, i15, i16);
    }

    @Override // androidx.compose.foundation.lazy.l
    public long a() {
        return q2.u.a(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.lazy.l
    public int b() {
        return this.f2770p;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int c() {
        return this.f2766l;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int d() {
        return this.f2767m;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int e() {
        return -g();
    }

    @Override // androidx.compose.foundation.lazy.l
    public int f() {
        return this.f2771q;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int g() {
        return this.f2765k;
    }

    @Override // androidx.compose.ui.layout.w
    public int getHeight() {
        return this.f2772r.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.l
    public Orientation getOrientation() {
        return this.f2769o;
    }

    @Override // androidx.compose.ui.layout.w
    public int getWidth() {
        return this.f2772r.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.l
    public List<n> h() {
        return this.f2764j;
    }

    public final boolean i() {
        n nVar = this.f2755a;
        return ((nVar == null || nVar.getIndex() == 0) && this.f2756b == 0) ? false : true;
    }

    public final boolean j() {
        return this.f2757c;
    }

    public final long k() {
        return this.f2763i;
    }

    @Override // androidx.compose.ui.layout.w
    public Map<androidx.compose.ui.layout.a, Integer> l() {
        return this.f2772r.l();
    }

    @Override // androidx.compose.ui.layout.w
    public void m() {
        this.f2772r.m();
    }

    @Override // androidx.compose.ui.layout.w
    public Function1<o0, Unit> n() {
        return this.f2772r.n();
    }

    public final float o() {
        return this.f2758d;
    }

    public final k0 p() {
        return this.f2761g;
    }

    public final q2.e q() {
        return this.f2762h;
    }

    public final n r() {
        return this.f2755a;
    }

    public final int s() {
        return this.f2756b;
    }

    public final float t() {
        return this.f2759e;
    }

    public final boolean u(int i11, boolean z11) {
        n nVar;
        boolean z12 = false;
        z12 = false;
        z12 = false;
        z12 = false;
        z12 = false;
        z12 = false;
        z12 = false;
        z12 = false;
        z12 = false;
        if (!this.f2760f && !h().isEmpty() && (nVar = this.f2755a) != null) {
            int iH = nVar.h();
            int i12 = this.f2756b - i11;
            if (i12 >= 0 && i12 < iH) {
                n nVar2 = (n) CollectionsKt___CollectionsKt.e0(h());
                n nVar3 = (n) CollectionsKt___CollectionsKt.q0(h());
                if (!nVar2.p() && !nVar3.p() && (i11 >= 0 ? Math.min(g() - nVar2.g(), c() - nVar3.g()) > i11 : Math.min((nVar2.g() + nVar2.h()) - g(), (nVar3.g() + nVar3.h()) - c()) > (-i11))) {
                    this.f2756b -= i11;
                    List<n> listH = h();
                    int size = listH.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        listH.get(i13).l(i11, z11);
                    }
                    this.f2758d = i11;
                    z12 = true;
                    z12 = true;
                    z12 = true;
                    if (!this.f2757c && i11 > 0) {
                        this.f2757c = true;
                    }
                }
            }
        }
        return z12;
    }
}
