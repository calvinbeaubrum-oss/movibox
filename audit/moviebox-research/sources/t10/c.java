package t10;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c extends h {

    /* JADX INFO: compiled from: source.java */
    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[][] f76727a = {new byte[]{Ascii.ESC, 36, 41, 65}, new byte[]{Ascii.ESC, 36, 41, 71}, new byte[]{Ascii.ESC, 36, 42, 72}, new byte[]{Ascii.ESC, 36, 41, 69}, new byte[]{Ascii.ESC, 36, 43, 73}, new byte[]{Ascii.ESC, 36, 43, 74}, new byte[]{Ascii.ESC, 36, 43, 75}, new byte[]{Ascii.ESC, 36, 43, 76}, new byte[]{Ascii.ESC, 36, 43, 77}, new byte[]{Ascii.ESC, 78}, new byte[]{Ascii.ESC, 79}};

        @Override // t10.h
        public String b() {
            return "ISO-2022-CN";
        }

        @Override // t10.h
        public t10.b c(t10.a aVar) {
            int iD = d(aVar.f76710a, aVar.f76711b, this.f76727a);
            if (iD == 0) {
                return null;
            }
            return new t10.b(aVar, this, iD);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[][] f76728a = {new byte[]{Ascii.ESC, 36, 40, 67}, new byte[]{Ascii.ESC, 36, 40, 68}, new byte[]{Ascii.ESC, 36, 64}, new byte[]{Ascii.ESC, 36, 65}, new byte[]{Ascii.ESC, 36, 66}, new byte[]{Ascii.ESC, 38, 64}, new byte[]{Ascii.ESC, 40, 66}, new byte[]{Ascii.ESC, 40, 72}, new byte[]{Ascii.ESC, 40, 73}, new byte[]{Ascii.ESC, 40, 74}, new byte[]{Ascii.ESC, 46, 65}, new byte[]{Ascii.ESC, 46, 70}};

        @Override // t10.h
        public String b() {
            return "ISO-2022-JP";
        }

        @Override // t10.h
        public t10.b c(t10.a aVar) {
            int iD = d(aVar.f76710a, aVar.f76711b, this.f76728a);
            if (iD == 0) {
                return null;
            }
            return new t10.b(aVar, this, iD);
        }
    }

    /* JADX INFO: renamed from: t10.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0843c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[][] f76729a = {new byte[]{Ascii.ESC, 36, 41, 67}};

        @Override // t10.h
        public String b() {
            return "ISO-2022-KR";
        }

        @Override // t10.h
        public t10.b c(t10.a aVar) {
            int iD = d(aVar.f76710a, aVar.f76711b, this.f76729a);
            if (iD == 0) {
                return null;
            }
            return new t10.b(aVar, this, iD);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003e  */
    public int d(byte[] bArr, int i11, byte[][] bArr2) {
        byte b11;
        int length = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (length < i11) {
            if (bArr[length] == 27) {
                int i15 = 0;
                while (true) {
                    if (i15 < bArr2.length) {
                        byte[] bArr3 = bArr2[i15];
                        if (i11 - length >= bArr3.length) {
                            int i16 = 1;
                            while (true) {
                                if (i16 >= bArr3.length) {
                                    i12++;
                                    length += bArr3.length - 1;
                                } else if (bArr3[i16] == bArr[length + i16]) {
                                    i16++;
                                }
                            }
                        }
                        i15++;
                    } else {
                        i13++;
                        b11 = bArr[length];
                        if (b11 != 14 || b11 == 15) {
                            i14++;
                        }
                    }
                }
            } else {
                b11 = bArr[length];
                if (b11 != 14) {
                    i14++;
                } else {
                    i14++;
                }
            }
            length++;
        }
        if (i12 == 0) {
            return 0;
        }
        int i17 = ((i12 * 100) - (i13 * 100)) / (i13 + i12);
        int i18 = i12 + i14;
        if (i18 < 5) {
            i17 -= (5 - i18) * 10;
        }
        if (i17 < 0) {
            return 0;
        }
        return i17;
    }
}
