package t10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e extends h {

    /* JADX INFO: compiled from: source.java */
    public static class a extends e {
        @Override // t10.h
        public String b() {
            return "UTF-16BE";
        }

        @Override // t10.h
        public t10.b c(t10.a aVar) {
            byte[] bArr = aVar.f76714e;
            int iMin = Math.min(bArr.length, 30);
            int iD = 10;
            for (int i11 = 0; i11 < iMin - 1; i11 += 2) {
                int iE = e.e(bArr[i11], bArr[i11 + 1]);
                if (i11 == 0 && iE == 65279) {
                    iD = 100;
                    break;
                }
                iD = e.d(iE, iD);
                if (iD == 0 || iD == 100) {
                    break;
                }
            }
            int i12 = (iMin >= 4 || iD >= 100) ? iD : 0;
            if (i12 > 0) {
                return new t10.b(aVar, this, i12);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends e {
        @Override // t10.h
        public String b() {
            return "UTF-16LE";
        }

        @Override // t10.h
        public t10.b c(t10.a aVar) {
            byte[] bArr = aVar.f76714e;
            int iMin = Math.min(bArr.length, 30);
            int iD = 10;
            for (int i11 = 0; i11 < iMin - 1; i11 += 2) {
                int iE = e.e(bArr[i11 + 1], bArr[i11]);
                if (i11 == 0 && iE == 65279) {
                    iD = 100;
                    break;
                }
                iD = e.d(iE, iD);
                if (iD == 0 || iD == 100) {
                    break;
                }
            }
            int i12 = (iMin >= 4 || iD >= 100) ? iD : 0;
            if (i12 > 0) {
                return new t10.b(aVar, this, i12);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c extends e {
        /* JADX WARN: Code duplicated, block: B:26:0x0042  */
        /* JADX WARN: Code duplicated, block: B:31:0x004d  */
        @Override // t10.h
        public t10.b c(t10.a aVar) {
            byte[] bArr = aVar.f76714e;
            int i11 = (aVar.f76715f / 4) * 4;
            if (i11 == 0) {
                return null;
            }
            int i12 = 0;
            boolean z11 = f(bArr, 0) == 65279;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15 += 4) {
                int iF = f(bArr, i15);
                if (iF < 0 || iF >= 1114111 || (iF >= 55296 && iF <= 57343)) {
                    i13++;
                } else {
                    i14++;
                }
            }
            if (z11 && i13 == 0) {
                i12 = 100;
            } else if (z11 && i14 > i13 * 10) {
                i12 = 80;
            } else if (i14 > 3 && i13 == 0) {
                i12 = 100;
            } else if (i14 > 0 && i13 == 0) {
                i12 = 80;
            } else if (i14 > i13 * 10) {
                i12 = 25;
            }
            if (i12 == 0) {
                return null;
            }
            return new t10.b(aVar, this, i12);
        }

        public abstract int f(byte[] bArr, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends c {
        @Override // t10.h
        public String b() {
            return "UTF-32BE";
        }

        @Override // t10.e.c
        public int f(byte[] bArr, int i11) {
            return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
        }
    }

    /* JADX INFO: renamed from: t10.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0844e extends c {
        @Override // t10.h
        public String b() {
            return "UTF-32LE";
        }

        @Override // t10.e.c
        public int f(byte[] bArr, int i11) {
            return (bArr[i11] & 255) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 1] & 255) << 8);
        }
    }

    public static int d(int i11, int i12) {
        if (i11 == 0) {
            i12 -= 10;
        } else if ((i11 >= 32 && i11 <= 255) || i11 == 10) {
            i12 += 10;
        }
        if (i12 < 0) {
            return 0;
        }
        if (i12 > 100) {
            return 100;
        }
        return i12;
    }

    public static int e(byte b11, byte b12) {
        return ((b11 & 255) << 8) | (b12 & 255);
    }
}
