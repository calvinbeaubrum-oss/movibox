package r2;

import androidx.collection.w0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.o;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f75090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f75091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile w0<a> f75092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object[] f75093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f75094e;

    static {
        b bVar = new b();
        f75090a = bVar;
        f75091b = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
        f75092c = new w0<>(0, 1, null);
        Object[] objArr = new Object[0];
        f75093d = objArr;
        synchronized (objArr) {
            bVar.h(f75092c, 1.15f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            bVar.h(f75092c, 1.3f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            bVar.h(f75092c, 1.5f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            bVar.h(f75092c, 1.8f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            bVar.h(f75092c, 2.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
            Unit unit = Unit.f68710a;
        }
        if (!(bVar.e(f75092c.l(0)) - 0.01f > 1.03f)) {
            o.b("You should only apply non-linear scaling to font scales > 1");
        }
        f75094e = 8;
    }

    public final a a(a aVar, a aVar2, float f11) {
        float[] fArr = f75091b;
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            float f12 = f75091b[i11];
            fArr2[i11] = d.f75099a.b(aVar.b(f12), aVar2.b(f12), f11);
        }
        return new c(f75091b, fArr2);
    }

    public final a b(float f11) {
        a aVarR;
        float f12;
        if (!f(f11)) {
            return null;
        }
        a aVarC = f75090a.c(f11);
        if (aVarC != null) {
            return aVarC;
        }
        int iJ = f75092c.j(d(f11));
        if (iJ >= 0) {
            return f75092c.r(iJ);
        }
        int i11 = -(iJ + 1);
        int i12 = i11 - 1;
        if (i11 >= f75092c.q()) {
            c cVar = new c(new float[]{1.0f}, new float[]{f11});
            g(f11, cVar);
            return cVar;
        }
        if (i12 < 0) {
            float[] fArr = f75091b;
            aVarR = new c(fArr, fArr);
            f12 = 1.0f;
        } else {
            float fE = e(f75092c.l(i12));
            aVarR = f75092c.r(i12);
            f12 = fE;
        }
        a aVarA = a(aVarR, f75092c.r(i11), d.f75099a.a(0.0f, 1.0f, f12, e(f75092c.l(i11)), f11));
        g(f11, aVarA);
        return aVarA;
    }

    public final a c(float f11) {
        return f75092c.g(d(f11));
    }

    public final int d(float f11) {
        return (int) (f11 * 100.0f);
    }

    public final float e(int i11) {
        return i11 / 100.0f;
    }

    public final boolean f(float f11) {
        return f11 >= 1.03f;
    }

    public final void g(float f11, a aVar) {
        synchronized (f75093d) {
            w0<a> w0VarClone = f75092c.clone();
            f75090a.h(w0VarClone, f11, aVar);
            f75092c = w0VarClone;
            Unit unit = Unit.f68710a;
        }
    }

    public final void h(w0<a> w0Var, float f11, a aVar) {
        w0Var.m(d(f11), aVar);
    }
}
