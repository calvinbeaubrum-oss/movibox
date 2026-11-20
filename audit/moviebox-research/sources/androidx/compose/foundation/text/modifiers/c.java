package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.f0;
import androidx.compose.ui.text.q;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
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
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f2937h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2938i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static c f2939j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutDirection f2940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f2941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q2.e f2942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.text.font.i.b f2943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e0 f2944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2946g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a(c cVar, LayoutDirection layoutDirection, e0 e0Var, q2.e eVar, androidx.compose.ui.text.font.i.b bVar) {
            if (cVar != null && layoutDirection == cVar.g() && Intrinsics.b(e0Var, cVar.f()) && eVar.getDensity() == cVar.d().getDensity() && bVar == cVar.e()) {
                return cVar;
            }
            c cVar2 = c.f2939j;
            if (cVar2 != null && layoutDirection == cVar2.g() && Intrinsics.b(e0Var, cVar2.f()) && eVar.getDensity() == cVar2.d().getDensity() && bVar == cVar2.e()) {
                return cVar2;
            }
            c cVar3 = new c(layoutDirection, f0.c(e0Var, layoutDirection), q2.g.a(eVar.getDensity(), eVar.M0()), bVar, null);
            c.f2939j = cVar3;
            return cVar3;
        }
    }

    public c(LayoutDirection layoutDirection, e0 e0Var, q2.e eVar, androidx.compose.ui.text.font.i.b bVar) {
        this.f2940a = layoutDirection;
        this.f2941b = e0Var;
        this.f2942c = eVar;
        this.f2943d = bVar;
        this.f2944e = f0.c(e0Var, layoutDirection);
        this.f2945f = Float.NaN;
        this.f2946g = Float.NaN;
    }

    public /* synthetic */ c(LayoutDirection layoutDirection, e0 e0Var, q2.e eVar, androidx.compose.ui.text.font.i.b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutDirection, e0Var, eVar, bVar);
    }

    public final long c(long j11, int i11) {
        float height = this.f2946g;
        float height2 = this.f2945f;
        if (Float.isNaN(height) || Float.isNaN(height2)) {
            height = q.a(d.f2947a, this.f2944e, q2.c.b(0, 0, 0, 0, 15, null), this.f2942c, this.f2943d, (96 & 32) != 0 ? kotlin.collections.g.l() : null, (96 & 64) != 0 ? kotlin.collections.g.l() : null, (96 & 128) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 1, (96 & 256) != 0 ? false : false).getHeight();
            height2 = q.a(d.f2948b, this.f2944e, q2.c.b(0, 0, 0, 0, 15, null), this.f2942c, this.f2943d, (96 & 32) != 0 ? kotlin.collections.g.l() : null, (96 & 64) != 0 ? kotlin.collections.g.l() : null, (96 & 128) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 2, (96 & 256) != 0 ? false : false).getHeight() - height;
            this.f2946g = height;
            this.f2945f = height2;
        }
        return q2.c.a(q2.b.n(j11), q2.b.l(j11), i11 != 1 ? kotlin.ranges.a.g(kotlin.ranges.a.d(Math.round(height + (height2 * (i11 - 1))), 0), q2.b.k(j11)) : q2.b.m(j11), q2.b.k(j11));
    }

    public final q2.e d() {
        return this.f2942c;
    }

    public final androidx.compose.ui.text.font.i.b e() {
        return this.f2943d;
    }

    public final e0 f() {
        return this.f2941b;
    }

    public final LayoutDirection g() {
        return this.f2940a;
    }
}
