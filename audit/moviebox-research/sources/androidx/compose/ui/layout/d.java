package androidx.compose.ui.layout;

import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class d implements c, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.node.y f4853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4855c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<androidx.compose.ui.layout.a, Integer> f4858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<o0, Unit> f4859d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<k0.a, Unit> f4860e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d f4861f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super o0, Unit> function1, Function1<? super k0.a, Unit> function2, d dVar) {
            this.f4860e = function2;
            this.f4861f = dVar;
            this.f4856a = i11;
            this.f4857b = i12;
            this.f4858c = map;
            this.f4859d = function1;
        }

        @Override // androidx.compose.ui.layout.w
        public int getHeight() {
            return this.f4857b;
        }

        @Override // androidx.compose.ui.layout.w
        public int getWidth() {
            return this.f4856a;
        }

        @Override // androidx.compose.ui.layout.w
        public Map<androidx.compose.ui.layout.a, Integer> l() {
            return this.f4858c;
        }

        @Override // androidx.compose.ui.layout.w
        public void m() {
            this.f4860e.invoke(this.f4861f.m().b1());
        }

        @Override // androidx.compose.ui.layout.w
        public Function1<o0, Unit> n() {
            return this.f4859d;
        }
    }

    public d(androidx.compose.ui.node.y yVar, b bVar) {
        this.f4853a = yVar;
        this.f4854b = bVar;
    }

    public final void A(boolean z11) {
        this.f4855c = z11;
    }

    public final void C(b bVar) {
        this.f4854b = bVar;
    }

    @Override // q2.e
    public float H0(float f11) {
        return this.f4853a.H0(f11);
    }

    @Override // q2.n
    public long M(float f11) {
        return this.f4853a.M(f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f4853a.M0();
    }

    @Override // q2.e
    public float N0(float f11) {
        return this.f4853a.N0(f11);
    }

    @Override // q2.n
    public float O(long j11) {
        return this.f4853a.O(j11);
    }

    @Override // androidx.compose.ui.layout.y
    public w S0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super o0, Unit> function1, Function1<? super k0.a, Unit> function2) {
        if (!((i11 & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & i12) == 0)) {
            h2.a.b("Size(" + i11 + " x " + i12 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new a(i11, i12, map, function1, function2, this);
    }

    @Override // q2.e
    public long V0(long j11) {
        return this.f4853a.V0(j11);
    }

    @Override // q2.e
    public long X(float f11) {
        return this.f4853a.X(f11);
    }

    @Override // androidx.compose.ui.layout.k
    public boolean d0() {
        return false;
    }

    @Override // q2.e
    public float getDensity() {
        return this.f4853a.getDensity();
    }

    @Override // androidx.compose.ui.layout.k
    public LayoutDirection getLayoutDirection() {
        return this.f4853a.getLayoutDirection();
    }

    public final boolean k() {
        return this.f4855c;
    }

    @Override // q2.e
    public int k0(float f11) {
        return this.f4853a.k0(f11);
    }

    public final b l() {
        return this.f4854b;
    }

    public final androidx.compose.ui.node.y m() {
        return this.f4853a;
    }

    @Override // q2.e
    public float p0(long j11) {
        return this.f4853a.p0(j11);
    }

    public long x() {
        androidx.compose.ui.node.j0 j0VarT1 = this.f4853a.T1();
        Intrinsics.d(j0VarT1);
        w wVarY0 = j0VarT1.Y0();
        return q2.u.a(wVarY0.getWidth(), wVarY0.getHeight());
    }

    @Override // androidx.compose.ui.layout.y
    public w y0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super k0.a, Unit> function1) {
        return this.f4853a.y0(i11, i12, map, function1);
    }
}
