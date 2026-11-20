package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import y1.m;

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
public final class StateLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<c> f3166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Animatable<Float, androidx.compose.animation.core.k> f3167c = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<o1.f> f3168d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o1.f f3169e;

    public StateLayer(boolean z11, Function0<c> function0) {
        this.f3165a = z11;
        this.f3166b = function0;
    }

    public final void b(z1.g gVar, float f11, long j11) {
        long j12;
        float fFloatValue = this.f3167c.k().floatValue();
        if (fFloatValue <= 0.0f) {
            return;
        }
        long jK = w1.k(j11, fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.f3165a) {
            z1.f.d(gVar, jK, f11, 0L, 0.0f, null, null, 0, 124, null);
            return;
        }
        float fI = m.i(gVar.i());
        float fG = m.g(gVar.i());
        int iB = v1.f4361a.b();
        z1.d dVarQ0 = gVar.Q0();
        long jI = dVarQ0.i();
        dVarQ0.e().d();
        try {
            dVarQ0.c().a(0.0f, 0.0f, fI, fG, iB);
            j12 = jI;
            try {
                z1.f.d(gVar, jK, f11, 0L, 0.0f, null, null, 0, 124, null);
                dVarQ0.e().k();
                dVarQ0.f(j12);
            } catch (Throwable th2) {
                th = th2;
                dVarQ0.e().k();
                dVarQ0.f(j12);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j12 = jI;
        }
    }

    public final void c(o1.f fVar, k0 k0Var) {
        float fA;
        boolean z11 = fVar instanceof o1.d;
        if (z11) {
            this.f3168d.add(fVar);
        } else if (fVar instanceof o1.e) {
            this.f3168d.remove(((o1.e) fVar).a());
        } else if (fVar instanceof o1.b) {
            this.f3168d.add(fVar);
        } else if (fVar instanceof o1.c) {
            this.f3168d.remove(((o1.c) fVar).a());
        } else if (fVar instanceof o1.a.b) {
            this.f3168d.add(fVar);
        } else if (fVar instanceof o1.a.c) {
            this.f3168d.remove(((o1.a.c) fVar).a());
        } else if (!(fVar instanceof o1.a.C0776a)) {
            return;
        } else {
            this.f3168d.remove(((o1.a.C0776a) fVar).a());
        }
        o1.f fVar2 = (o1.f) CollectionsKt___CollectionsKt.r0(this.f3168d);
        if (Intrinsics.b(this.f3169e, fVar2)) {
            return;
        }
        if (fVar2 != null) {
            c cVarInvoke = this.f3166b.invoke();
            if (z11) {
                fA = cVarInvoke.c();
            } else if (fVar instanceof o1.b) {
                fA = cVarInvoke.b();
            } else {
                fA = fVar instanceof o1.a.b ? cVarInvoke.a() : 0.0f;
            }
            kotlinx.coroutines.j.d(k0Var, null, null, new StateLayer$handleInteraction$1(this, fA, h.d(fVar2), null), 3, null);
        } else {
            kotlinx.coroutines.j.d(k0Var, null, null, new StateLayer$handleInteraction$2(this, h.e(this.f3169e), null), 3, null);
        }
        this.f3169e = fVar2;
    }
}
