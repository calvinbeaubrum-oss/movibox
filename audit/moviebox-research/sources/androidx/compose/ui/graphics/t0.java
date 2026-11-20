package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;

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
public final class t0 {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f4347c;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f4345a = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            f4346b = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f4347c = iArr3;
        }
    }

    public static final o4 a() {
        return new s0();
    }

    public static final o4 b(Paint paint) {
        return new s0(paint);
    }

    public static final float c(Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final long d(Paint paint) {
        return y1.b(paint.getColor());
    }

    public static final int e(Paint paint) {
        return !paint.isFilterBitmap() ? z3.f4590a.b() : z3.f4590a.a();
    }

    public static final int f(Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i11 = strokeCap == null ? -1 : a.f4346b[strokeCap.ordinal()];
        if (i11 == 1) {
            return e5.f4128a.a();
        }
        if (i11 != 2) {
            return i11 != 3 ? e5.f4128a.a() : e5.f4128a.c();
        }
        return e5.f4128a.b();
    }

    public static final int g(Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i11 = strokeJoin == null ? -1 : a.f4347c[strokeJoin.ordinal()];
        if (i11 == 1) {
            return f5.f4136a.b();
        }
        if (i11 != 2) {
            return i11 != 3 ? f5.f4136a.b() : f5.f4136a.c();
        }
        return f5.f4136a.a();
    }

    public static final float h(Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final float i(Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final Paint j() {
        return new Paint(7);
    }

    public static final void k(Paint paint, float f11) {
        paint.setAlpha((int) Math.rint(f11 * 255.0f));
    }

    public static final void l(Paint paint, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            j5.f4155a.a(paint, i11);
        } else {
            paint.setXfermode(new PorterDuffXfermode(f0.c(i11)));
        }
    }

    public static final void m(Paint paint, long j11) {
        paint.setColor(y1.j(j11));
    }

    public static final void n(Paint paint, x1 x1Var) {
        paint.setColorFilter(x1Var != null ? i0.b(x1Var) : null);
    }

    public static final void o(Paint paint, int i11) {
        paint.setFilterBitmap(!z3.d(i11, z3.f4590a.b()));
    }

    public static final void p(Paint paint, r4 r4Var) {
        v0 v0Var = (v0) r4Var;
        paint.setPathEffect(v0Var != null ? v0Var.a() : null);
    }

    public static final void q(Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void r(Paint paint, int i11) {
        Paint.Cap cap;
        e5.a aVar = e5.f4128a;
        if (e5.e(i11, aVar.c())) {
            cap = Paint.Cap.SQUARE;
        } else if (e5.e(i11, aVar.b())) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = e5.e(i11, aVar.a()) ? Paint.Cap.BUTT : Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
    }

    public static final void s(Paint paint, int i11) {
        Paint.Join join;
        f5.a aVar = f5.f4136a;
        if (f5.e(i11, aVar.b())) {
            join = Paint.Join.MITER;
        } else if (f5.e(i11, aVar.a())) {
            join = Paint.Join.BEVEL;
        } else {
            join = f5.e(i11, aVar.c()) ? Paint.Join.ROUND : Paint.Join.MITER;
        }
        paint.setStrokeJoin(join);
    }

    public static final void t(Paint paint, float f11) {
        paint.setStrokeMiter(f11);
    }

    public static final void u(Paint paint, float f11) {
        paint.setStrokeWidth(f11);
    }

    public static final void v(Paint paint, int i11) {
        paint.setStyle(p4.d(i11, p4.f4317a.b()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
