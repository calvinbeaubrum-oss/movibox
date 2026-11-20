package m2;

import android.text.Layout;
import android.text.TextUtils;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Layout f70606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f70607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Bidi> f70608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean[] f70609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public char[] f70610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f70611f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f70612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f70613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f70614c;

        public a(int i11, int i12, boolean z11) {
            this.f70612a = i11;
            this.f70613b = i12;
            this.f70614c = z11;
        }

        public final int a() {
            return this.f70613b;
        }

        public final int b() {
            return this.f70612a;
        }

        public final boolean c() {
            return this.f70614c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f70612a == aVar.f70612a && this.f70613b == aVar.f70613b && this.f70614c == aVar.f70614c;
        }

        public int hashCode() {
            return (((this.f70612a * 31) + this.f70613b) * 31) + androidx.compose.foundation.e.a(this.f70614c);
        }

        public String toString() {
            return "BidiRun(start=" + this.f70612a + ", end=" + this.f70613b + ", isRtl=" + this.f70614c + ')';
        }
    }

    public h0(Layout layout) {
        this.f70606a = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iC0 = StringsKt__StringsKt.c0(this.f70606a.getText(), '\n', length, false, 4, null);
            length = iC0 < 0 ? this.f70606a.getText().length() : iC0 + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < this.f70606a.getText().length());
        this.f70607b = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList2.add(null);
        }
        this.f70608c = arrayList2;
        this.f70609d = new boolean[this.f70607b.size()];
        this.f70611f = this.f70607b.size();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    public final Bidi a(int i11) {
        Bidi bidi;
        if (this.f70609d[i11]) {
            return this.f70608c.get(i11);
        }
        int iIntValue = i11 == 0 ? 0 : this.f70607b.get(i11 - 1).intValue();
        int iIntValue2 = this.f70607b.get(i11).intValue();
        int i12 = iIntValue2 - iIntValue;
        char[] cArr = this.f70610e;
        if (cArr == null || cArr.length < i12) {
            cArr = new char[i12];
        }
        char[] cArr2 = cArr;
        TextUtils.getChars(this.f70606a.getText(), iIntValue, iIntValue2, cArr2, 0);
        if (Bidi.requiresBidi(cArr2, 0, i12)) {
            bidi = new Bidi(cArr2, 0, null, 0, i12, h(i11) ? 1 : 0);
            if (bidi.getRunCount() == 1) {
                bidi = null;
            }
        } else {
            bidi = null;
        }
        this.f70608c.set(i11, bidi);
        this.f70609d[i11] = true;
        if (bidi != null) {
            char[] cArr3 = this.f70610e;
            cArr2 = cArr2 == cArr3 ? null : cArr3;
        }
        this.f70610e = cArr2;
        return bidi;
    }

    public final float b(int i11, boolean z11) {
        int iG = kotlin.ranges.a.g(i11, this.f70606a.getLineEnd(this.f70606a.getLineForOffset(i11)));
        return z11 ? this.f70606a.getPrimaryHorizontal(iG) : this.f70606a.getSecondaryHorizontal(iG);
    }

    public final float c(int i11, boolean z11, boolean z12) {
        int i12 = i11;
        if (!z12) {
            return b(i11, z11);
        }
        int iA = g0.a(this.f70606a, i12, z12);
        int lineStart = this.f70606a.getLineStart(iA);
        int lineEnd = this.f70606a.getLineEnd(iA);
        if (i12 != lineStart && i12 != lineEnd) {
            return b(i11, z11);
        }
        if (i12 == 0 || i12 == this.f70606a.getText().length()) {
            return b(i11, z11);
        }
        int iE = e(i12, z12);
        boolean zH = h(iE);
        int i13 = i(lineEnd, lineStart);
        int iF = f(iE);
        int i14 = lineStart - iF;
        int i15 = i13 - iF;
        Bidi bidiA = a(iE);
        Bidi bidiCreateLineBidi = bidiA != null ? bidiA.createLineBidi(i14, i15) : null;
        if (bidiCreateLineBidi == null || bidiCreateLineBidi.getRunCount() == 1) {
            boolean zIsRtlCharAt = this.f70606a.isRtlCharAt(lineStart);
            if (z11 || zH == zIsRtlCharAt) {
                zH = !zH;
            }
            return (i12 != lineStart ? zH : !zH) ? this.f70606a.getLineRight(iA) : this.f70606a.getLineLeft(iA);
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        a[] aVarArr = new a[runCount];
        for (int i16 = 0; i16 < runCount; i16++) {
            aVarArr[i16] = new a(bidiCreateLineBidi.getRunStart(i16) + lineStart, bidiCreateLineBidi.getRunLimit(i16) + lineStart, bidiCreateLineBidi.getRunLevel(i16) % 2 == 1);
        }
        int runCount2 = bidiCreateLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i17 = 0; i17 < runCount2; i17++) {
            bArr[i17] = (byte) bidiCreateLineBidi.getRunLevel(i17);
        }
        Bidi.reorderVisually(bArr, 0, aVarArr, 0, runCount);
        int i18 = -1;
        if (i12 == lineStart) {
            for (int i19 = 0; i19 < runCount; i19++) {
                if (aVarArr[i19].b() == i12) {
                    i18 = i19;
                    break;
                }
            }
            a aVar = aVarArr[i18];
            if (z11 || zH == aVar.c()) {
                zH = !zH;
            }
            if (i18 == 0 && zH) {
                return this.f70606a.getLineLeft(iA);
            }
            if (i18 != kotlin.collections.d.U(aVarArr) || zH) {
                return zH ? this.f70606a.getPrimaryHorizontal(aVarArr[i18 - 1].b()) : this.f70606a.getPrimaryHorizontal(aVarArr[i18 + 1].b());
            }
            return this.f70606a.getLineRight(iA);
        }
        if (i12 > i13) {
            i12 = i(i12, lineStart);
        }
        for (int i21 = 0; i21 < runCount; i21++) {
            if (aVarArr[i21].a() == i12) {
                i18 = i21;
                break;
            }
        }
        a aVar2 = aVarArr[i18];
        if (!z11 && zH != aVar2.c()) {
            zH = !zH;
        }
        if (i18 == 0 && zH) {
            return this.f70606a.getLineLeft(iA);
        }
        if (i18 != kotlin.collections.d.U(aVarArr) || zH) {
            return zH ? this.f70606a.getPrimaryHorizontal(aVarArr[i18 - 1].a()) : this.f70606a.getPrimaryHorizontal(aVarArr[i18 + 1].a());
        }
        return this.f70606a.getLineRight(iA);
    }

    public final int d(int i11) {
        return i(this.f70606a.getLineEnd(i11), this.f70606a.getLineStart(i11));
    }

    public final int e(int i11, boolean z11) {
        int iK = kotlin.collections.g.k(this.f70607b, Integer.valueOf(i11), 0, 0, 6, null);
        int i12 = iK < 0 ? -(iK + 1) : iK + 1;
        if (z11 && i12 > 0) {
            int i13 = i12 - 1;
            if (i11 == this.f70607b.get(i13).intValue()) {
                return i13;
            }
        }
        return i12;
    }

    public final int f(int i11) {
        if (i11 == 0) {
            return 0;
        }
        return this.f70607b.get(i11 - 1).intValue();
    }

    public final boolean g(char c11) {
        return c11 == ' ' || c11 == '\n' || c11 == 5760 || (Intrinsics.i(c11, 8192) >= 0 && Intrinsics.i(c11, 8202) <= 0 && c11 != 8199) || c11 == 8287 || c11 == 12288;
    }

    public final boolean h(int i11) {
        return this.f70606a.getParagraphDirection(this.f70606a.getLineForOffset(f(i11))) == -1;
    }

    public final int i(int i11, int i12) {
        while (i11 > i12 && g(this.f70606a.getText().charAt(i11 - 1))) {
            i11--;
        }
        return i11;
    }
}
