package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.o0;
import androidx.compose.ui.layout.s0;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class r implements q, androidx.compose.ui.layout.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LazyLayoutItemContentFactory f2732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f2733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f2734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Integer, List<androidx.compose.ui.layout.k0>> f2735d = new HashMap<>();

    public r(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, s0 s0Var) {
        this.f2732a = lazyLayoutItemContentFactory;
        this.f2733b = s0Var;
        this.f2734c = lazyLayoutItemContentFactory.d().invoke();
    }

    @Override // q2.e
    public float H0(float f11) {
        return this.f2733b.H0(f11);
    }

    @Override // q2.n
    public long M(float f11) {
        return this.f2733b.M(f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f2733b.M0();
    }

    @Override // q2.e
    public float N0(float f11) {
        return this.f2733b.N0(f11);
    }

    @Override // q2.n
    public float O(long j11) {
        return this.f2733b.O(j11);
    }

    @Override // androidx.compose.ui.layout.y
    public androidx.compose.ui.layout.w S0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super o0, Unit> function1, Function1<? super androidx.compose.ui.layout.k0.a, Unit> function2) {
        return this.f2733b.S0(i11, i12, map, function1, function2);
    }

    @Override // q2.e
    public long V0(long j11) {
        return this.f2733b.V0(j11);
    }

    @Override // q2.e
    public long X(float f11) {
        return this.f2733b.X(f11);
    }

    @Override // androidx.compose.foundation.lazy.layout.q
    public List<androidx.compose.ui.layout.k0> Z(int i11, long j11) {
        List<androidx.compose.ui.layout.k0> list = this.f2735d.get(Integer.valueOf(i11));
        if (list != null) {
            return list;
        }
        Object objB = this.f2734c.b(i11);
        List<androidx.compose.ui.layout.t> listJ = this.f2733b.J(objB, this.f2732a.b(i11, objB, this.f2734c.c(i11)));
        int size = listJ.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(listJ.get(i12).L(j11));
        }
        this.f2735d.put(Integer.valueOf(i11), arrayList);
        return arrayList;
    }

    @Override // androidx.compose.ui.layout.k
    public boolean d0() {
        return this.f2733b.d0();
    }

    @Override // q2.e
    public float getDensity() {
        return this.f2733b.getDensity();
    }

    @Override // androidx.compose.ui.layout.k
    public LayoutDirection getLayoutDirection() {
        return this.f2733b.getLayoutDirection();
    }

    @Override // q2.e
    public int k0(float f11) {
        return this.f2733b.k0(f11);
    }

    @Override // q2.e
    public float p0(long j11) {
        return this.f2733b.p0(j11);
    }

    @Override // androidx.compose.ui.layout.y
    public androidx.compose.ui.layout.w y0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super androidx.compose.ui.layout.k0.a, Unit> function1) {
        return this.f2733b.y0(i11, i12, map, function1);
    }
}
