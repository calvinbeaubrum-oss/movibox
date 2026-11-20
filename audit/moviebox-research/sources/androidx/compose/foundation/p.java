package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import kotlin.Metadata;
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
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2818c = q2.t.f74253b.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EdgeEffect f2819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EdgeEffect f2820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EdgeEffect f2821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EdgeEffect f2822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EdgeEffect f2823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EdgeEffect f2824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public EdgeEffect f2825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EdgeEffect f2826k;

    public p(Context context, int i11) {
        this.f2816a = context;
        this.f2817b = i11;
    }

    public final boolean A() {
        return x(this.f2819d);
    }

    public final void B(long j11) {
        this.f2818c = j11;
        EdgeEffect edgeEffect = this.f2819d;
        if (edgeEffect != null) {
            edgeEffect.setSize(q2.t.g(j11), q2.t.f(j11));
        }
        EdgeEffect edgeEffect2 = this.f2820e;
        if (edgeEffect2 != null) {
            edgeEffect2.setSize(q2.t.g(j11), q2.t.f(j11));
        }
        EdgeEffect edgeEffect3 = this.f2821f;
        if (edgeEffect3 != null) {
            edgeEffect3.setSize(q2.t.f(j11), q2.t.g(j11));
        }
        EdgeEffect edgeEffect4 = this.f2822g;
        if (edgeEffect4 != null) {
            edgeEffect4.setSize(q2.t.f(j11), q2.t.g(j11));
        }
        EdgeEffect edgeEffect5 = this.f2823h;
        if (edgeEffect5 != null) {
            edgeEffect5.setSize(q2.t.g(j11), q2.t.f(j11));
        }
        EdgeEffect edgeEffect6 = this.f2824i;
        if (edgeEffect6 != null) {
            edgeEffect6.setSize(q2.t.g(j11), q2.t.f(j11));
        }
        EdgeEffect edgeEffect7 = this.f2825j;
        if (edgeEffect7 != null) {
            edgeEffect7.setSize(q2.t.f(j11), q2.t.g(j11));
        }
        EdgeEffect edgeEffect8 = this.f2826k;
        if (edgeEffect8 != null) {
            edgeEffect8.setSize(q2.t.f(j11), q2.t.g(j11));
        }
    }

    public final EdgeEffect e() {
        EdgeEffect edgeEffectA = o.f2815a.a(this.f2816a);
        edgeEffectA.setColor(this.f2817b);
        if (!q2.t.e(this.f2818c, q2.t.f74253b.a())) {
            edgeEffectA.setSize(q2.t.g(this.f2818c), q2.t.f(this.f2818c));
        }
        return edgeEffectA;
    }

    public final EdgeEffect f() {
        EdgeEffect edgeEffect = this.f2820e;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2820e = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect g() {
        EdgeEffect edgeEffect = this.f2824i;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2824i = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect h() {
        EdgeEffect edgeEffect = this.f2821f;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2821f = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect i() {
        EdgeEffect edgeEffect = this.f2825j;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2825j = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect j() {
        EdgeEffect edgeEffect = this.f2822g;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2822g = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect k() {
        EdgeEffect edgeEffect = this.f2826k;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2826k = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect l() {
        EdgeEffect edgeEffect = this.f2819d;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2819d = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect m() {
        EdgeEffect edgeEffect = this.f2823h;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e();
        this.f2823h = edgeEffectE;
        return edgeEffectE;
    }

    public final boolean n(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    public final boolean o() {
        return n(this.f2820e);
    }

    public final boolean p() {
        return x(this.f2824i);
    }

    public final boolean q() {
        return x(this.f2820e);
    }

    public final boolean r() {
        return n(this.f2821f);
    }

    public final boolean s() {
        return x(this.f2825j);
    }

    public final boolean t() {
        return x(this.f2821f);
    }

    public final boolean u() {
        return n(this.f2822g);
    }

    public final boolean v() {
        return x(this.f2826k);
    }

    public final boolean w() {
        return x(this.f2822g);
    }

    public final boolean x(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !(o.f2815a.b(edgeEffect) == 0.0f);
    }

    public final boolean y() {
        return n(this.f2819d);
    }

    public final boolean z() {
        return x(this.f2823h);
    }
}
