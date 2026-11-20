package androidx.compose.ui.input.pointer.util;

import f2.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class VelocityTracker1D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Strategy f4752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f2.a[] f4754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f4756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f4757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f4758h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum Strategy {
        Lsq2,
        Impulse
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4759a;

        static {
            int[] iArr = new int[Strategy.values().length];
            try {
                iArr[Strategy.Impulse.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Strategy.Lsq2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f4759a = iArr;
        }
    }

    public VelocityTracker1D(boolean z11, Strategy strategy) {
        this.f4751a = z11;
        this.f4752b = strategy;
        if (z11 && strategy.equals(Strategy.Lsq2)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int i11 = a.f4759a[strategy.ordinal()];
        int i12 = 2;
        if (i11 != 1) {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i12 = 3;
        }
        this.f4753c = i12;
        this.f4754d = new f2.a[20];
        this.f4756f = new float[20];
        this.f4757g = new float[20];
        this.f4758h = new float[3];
    }

    public /* synthetic */ VelocityTracker1D(boolean z11, Strategy strategy, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? Strategy.Lsq2 : strategy);
    }

    public final void a(long j11, float f11) {
        int i11 = (this.f4755e + 1) % 20;
        this.f4755e = i11;
        c.j(this.f4754d, i11, j11, f11);
    }

    public final float b(float[] fArr, float[] fArr2, int i11) {
        try {
            return c.i(fArr2, fArr, i11, 2, this.f4758h)[1];
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    public final float c() {
        float f11;
        float[] fArr = this.f4756f;
        float[] fArr2 = this.f4757g;
        int i11 = this.f4755e;
        f2.a aVar = this.f4754d[i11];
        if (aVar == null) {
            return 0.0f;
        }
        int i12 = 0;
        f2.a aVar2 = aVar;
        while (true) {
            f2.a aVar3 = this.f4754d[i11];
            if (aVar3 == null) {
                break;
            }
            float fB = aVar.b() - aVar3.b();
            float fAbs = Math.abs(aVar3.b() - aVar2.b());
            f2.a aVar4 = (this.f4752b == Strategy.Lsq2 || this.f4751a) ? aVar3 : aVar;
            if (fB > 100.0f || fAbs > 40.0f) {
                break;
            }
            fArr[i12] = aVar3.a();
            fArr2[i12] = -fB;
            if (i11 == 0) {
                i11 = 20;
            }
            i11--;
            i12++;
            if (i12 >= 20) {
                break;
            }
            aVar2 = aVar4;
        }
        if (i12 < this.f4753c) {
            return 0.0f;
        }
        int i13 = a.f4759a[this.f4752b.ordinal()];
        if (i13 == 1) {
            f11 = c.f(fArr, fArr2, i12, this.f4751a);
        } else {
            if (i13 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f11 = b(fArr, fArr2, i12);
        }
        return f11 * 1000;
    }

    public final float d(float f11) {
        if (!(f11 > 0.0f)) {
            h2.a.b("maximumVelocity should be a positive value. You specified=" + f11);
        }
        float fC = c();
        if (fC == 0.0f || Float.isNaN(fC)) {
            return 0.0f;
        }
        return fC > 0.0f ? kotlin.ranges.a.f(fC, f11) : kotlin.ranges.a.c(fC, -f11);
    }

    public final void e() {
        ArraysKt___ArraysJvmKt.x(this.f4754d, null, 0, 0, 6, null);
        this.f4755e = 0;
    }
}
