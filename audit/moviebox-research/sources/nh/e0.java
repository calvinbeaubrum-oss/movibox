package nh;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e0 {

    /* JADX INFO: compiled from: source.java */
    public static class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Random f71902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f71903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f71904c;

        public a(int i11) {
            this(i11, new Random());
        }

        public a(int i11, Random random) {
            this(b(i11, random), random);
        }

        public a(int[] iArr, Random random) {
            this.f71903b = iArr;
            this.f71902a = random;
            this.f71904c = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.f71904c[iArr[i11]] = i11;
            }
        }

        public static int[] b(int i11, Random random) {
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                int iNextInt = random.nextInt(i13);
                iArr[i12] = iArr[iNextInt];
                iArr[iNextInt] = i12;
                i12 = i13;
            }
            return iArr;
        }

        @Override // nh.e0
        public e0 a(int i11, int i12) {
            int i13 = i12 - i11;
            int[] iArr = new int[this.f71903b.length - i13];
            int i14 = 0;
            int i15 = 0;
            while (true) {
                int[] iArr2 = this.f71903b;
                if (i14 >= iArr2.length) {
                    return new a(iArr, new Random(this.f71902a.nextLong()));
                }
                int i16 = iArr2[i14];
                if (i16 < i11 || i16 >= i12) {
                    int i17 = i14 - i15;
                    if (i16 >= i11) {
                        i16 -= i13;
                    }
                    iArr[i17] = i16;
                } else {
                    i15++;
                }
                i14++;
            }
        }

        @Override // nh.e0
        public e0 cloneAndClear() {
            return new a(0, new Random(this.f71902a.nextLong()));
        }

        @Override // nh.e0
        public e0 cloneAndInsert(int i11, int i12) {
            int[] iArr = new int[i12];
            int[] iArr2 = new int[i12];
            int i13 = 0;
            int i14 = 0;
            while (i14 < i12) {
                iArr[i14] = this.f71902a.nextInt(this.f71903b.length + 1);
                int i15 = i14 + 1;
                int iNextInt = this.f71902a.nextInt(i15);
                iArr2[i14] = iArr2[iNextInt];
                iArr2[iNextInt] = i14 + i11;
                i14 = i15;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f71903b.length + i12];
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f71903b;
                if (i13 >= iArr4.length + i12) {
                    return new a(iArr3, new Random(this.f71902a.nextLong()));
                }
                if (i16 >= i12 || i17 != iArr[i16]) {
                    int i18 = i17 + 1;
                    int i19 = iArr4[i17];
                    iArr3[i13] = i19;
                    if (i19 >= i11) {
                        iArr3[i13] = i19 + i12;
                    }
                    i17 = i18;
                } else {
                    iArr3[i13] = iArr2[i16];
                    i16++;
                }
                i13++;
            }
        }

        @Override // nh.e0
        public int getFirstIndex() {
            int[] iArr = this.f71903b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // nh.e0
        public int getLastIndex() {
            int[] iArr = this.f71903b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // nh.e0
        public int getLength() {
            return this.f71903b.length;
        }

        @Override // nh.e0
        public int getNextIndex(int i11) {
            int i12 = this.f71904c[i11] + 1;
            int[] iArr = this.f71903b;
            if (i12 < iArr.length) {
                return iArr[i12];
            }
            return -1;
        }

        @Override // nh.e0
        public int getPreviousIndex(int i11) {
            int i12 = this.f71904c[i11] - 1;
            if (i12 >= 0) {
                return this.f71903b[i12];
            }
            return -1;
        }
    }

    e0 a(int i11, int i12);

    e0 cloneAndClear();

    e0 cloneAndInsert(int i11, int i12);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i11);

    int getPreviousIndex(int i11);
}
