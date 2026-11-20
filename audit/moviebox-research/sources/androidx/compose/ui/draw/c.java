package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class c implements q2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f3851a = j.f3857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f3852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z1.c f3853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<? extends c4> f3854d;

    public final void A(i iVar) {
        this.f3852b = iVar;
    }

    public final void C(Function0<? extends c4> function0) {
        this.f3854d = function0;
    }

    @Override // q2.e
    public /* synthetic */ float H0(float f11) {
        return q2.d.b(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ long M(float f11) {
        return q2.m.b(this, f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f3851a.getDensity().M0();
    }

    @Override // q2.e
    public /* synthetic */ float N0(float f11) {
        return q2.d.d(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ float O(long j11) {
        return q2.m.a(this, j11);
    }

    @Override // q2.e
    public /* synthetic */ long V0(long j11) {
        return q2.d.e(this, j11);
    }

    @Override // q2.e
    public /* synthetic */ long X(float f11) {
        return q2.d.f(this, f11);
    }

    @Override // q2.e
    public float getDensity() {
        return this.f3851a.getDensity().getDensity();
    }

    public final LayoutDirection getLayoutDirection() {
        return this.f3851a.getLayoutDirection();
    }

    public final long i() {
        return this.f3851a.i();
    }

    public final i k() {
        return this.f3852b;
    }

    @Override // q2.e
    public /* synthetic */ int k0(float f11) {
        return q2.d.a(this, f11);
    }

    public final i l(Function1<? super z1.c, Unit> function1) {
        i iVar = new i(function1);
        this.f3852b = iVar;
        return iVar;
    }

    public final void m(a aVar) {
        this.f3851a = aVar;
    }

    @Override // q2.e
    public /* synthetic */ float p0(long j11) {
        return q2.d.c(this, j11);
    }

    public final void x(z1.c cVar) {
        this.f3853c = cVar;
    }
}
