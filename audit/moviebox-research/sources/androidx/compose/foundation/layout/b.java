package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2478a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f2479b = new i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f2480c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f2481d = new j();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f2482e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f2483f = new C0042b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f2484g = new h();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f2485h = new g();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f2486i = new f();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements k {
        @Override // androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.d.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void b(q2.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2478a.g(i11, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class C0042b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f2487a = q2.i.h(0);

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2487a;
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void b(q2.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2478a.e(i11, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void c(q2.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2478a.e(i11, iArr, iArr2, false);
            } else {
                b.f2478a.e(i11, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Center";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d {
        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.c.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void c(q2.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2478a.g(i11, iArr, iArr2, false);
            } else {
                b.f2478a.f(iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#End";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public interface d {
        float a();

        void c(q2.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public interface e extends d, k {
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f2488a = q2.i.h(0);

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2488a;
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void b(q2.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2478a.h(i11, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void c(q2.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2478a.h(i11, iArr, iArr2, false);
            } else {
                b.f2478a.h(i11, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class g implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f2489a = q2.i.h(0);

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2489a;
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void b(q2.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2478a.i(i11, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void c(q2.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2478a.i(i11, iArr, iArr2, false);
            } else {
                b.f2478a.i(i11, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class h implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f2490a = q2.i.h(0);

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2490a;
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void b(q2.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2478a.j(i11, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void c(q2.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2478a.j(i11, iArr, iArr2, false);
            } else {
                b.f2478a.j(i11, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i implements d {
        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.c.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void c(q2.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2478a.f(iArr, iArr2, false);
            } else {
                b.f2478a.g(i11, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Start";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j implements k {
        @Override // androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.d.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void b(q2.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2478a.f(iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public interface k {
        float a();

        void b(q2.e eVar, int i11, int[] iArr, int[] iArr2);
    }

    public final k a() {
        return f2482e;
    }

    public final e b() {
        return f2483f;
    }

    public final d c() {
        return f2479b;
    }

    public final k d() {
        return f2481d;
    }

    public final void e(int i11, int[] iArr, int[] iArr2, boolean z11) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float f11 = (i11 - i13) / 2;
        if (!z11) {
            int length = iArr.length;
            int i15 = 0;
            while (i12 < length) {
                int i16 = iArr[i12];
                iArr2[i15] = Math.round(f11);
                f11 += i16;
                i12++;
                i15++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i17 = iArr[length2];
            iArr2[length2] = Math.round(f11);
            f11 += i17;
        }
    }

    public final void f(int[] iArr, int[] iArr2, boolean z11) {
        int i11 = 0;
        if (!z11) {
            int length = iArr.length;
            int i12 = 0;
            int i13 = 0;
            while (i11 < length) {
                int i14 = iArr[i11];
                iArr2[i12] = i13;
                i13 += i14;
                i11++;
                i12++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i15 = iArr[length2];
            iArr2[length2] = i11;
            i11 += i15;
        }
    }

    public final void g(int i11, int[] iArr, int[] iArr2, boolean z11) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        int i15 = i11 - i13;
        if (!z11) {
            int length = iArr.length;
            int i16 = 0;
            while (i12 < length) {
                int i17 = iArr[i12];
                iArr2[i16] = i15;
                i15 += i17;
                i12++;
                i16++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i18 = iArr[length2];
            iArr2[length2] = i15;
            i15 += i18;
        }
    }

    public final void h(int i11, int[] iArr, int[] iArr2, boolean z11) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float length = (iArr.length == 0) ^ true ? (i11 - i13) / iArr.length : 0.0f;
        float f11 = length / 2;
        if (z11) {
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i15 = iArr[length2];
                iArr2[length2] = Math.round(f11);
                f11 += i15 + length;
            }
            return;
        }
        int length3 = iArr.length;
        int i16 = 0;
        while (i12 < length3) {
            int i17 = iArr[i12];
            iArr2[i16] = Math.round(f11);
            f11 += i17 + length;
            i12++;
            i16++;
        }
    }

    public final void i(int i11, int[] iArr, int[] iArr2, boolean z11) {
        if (iArr.length == 0) {
            return;
        }
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float fMax = (i11 - i13) / Math.max(kotlin.collections.d.S(iArr), 1);
        float f11 = (z11 && iArr.length == 1) ? fMax : 0.0f;
        if (z11) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i15 = iArr[length];
                iArr2[length] = Math.round(f11);
                f11 += i15 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i16 = 0;
        while (i12 < length2) {
            int i17 = iArr[i12];
            iArr2[i16] = Math.round(f11);
            f11 += i17 + fMax;
            i12++;
            i16++;
        }
    }

    public final void j(int i11, int[] iArr, int[] iArr2, boolean z11) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float length = (i11 - i13) / (iArr.length + 1);
        if (z11) {
            float f11 = length;
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i15 = iArr[length2];
                iArr2[length2] = Math.round(f11);
                f11 += i15 + length;
            }
            return;
        }
        int length3 = iArr.length;
        float f12 = length;
        int i16 = 0;
        while (i12 < length3) {
            int i17 = iArr[i12];
            iArr2[i16] = Math.round(f12);
            f12 += i17 + length;
            i12++;
            i16++;
        }
    }
}
