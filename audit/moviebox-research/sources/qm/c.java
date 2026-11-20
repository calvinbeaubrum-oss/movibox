package qm;

import com.google.zxing.NotFoundException;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f74813a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    public static int h(hm.a aVar, int[] iArr, int i11) throws NotFoundException {
        q.f(aVar, i11, iArr);
        float f11 = 0.25f;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            int[][] iArr2 = f74813a;
            if (i13 >= iArr2.length) {
                break;
            }
            float fE = q.e(iArr, iArr2[i13], 0.7f);
            if (fE < f11) {
                i12 = i13;
                f11 = fE;
            }
            i13++;
        }
        if (i12 >= 0) {
            return i12;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] i(hm.a aVar) throws NotFoundException {
        int iM = aVar.m();
        int iK = aVar.k(0);
        int[] iArr = new int[6];
        int i11 = iK;
        boolean z11 = false;
        int i12 = 0;
        while (iK < iM) {
            if (aVar.h(iK) != z11) {
                iArr[i12] = iArr[i12] + 1;
            } else {
                if (i12 == 5) {
                    int i13 = -1;
                    float f11 = 0.25f;
                    for (int i14 = Worker.WHAT_SYNC_DATA; i14 <= 105; i14++) {
                        float fE = q.e(iArr, f74813a[i14], 0.7f);
                        if (fE < f11) {
                            i13 = i14;
                            f11 = fE;
                        }
                    }
                    if (i13 >= 0 && aVar.o(Math.max(0, i11 - ((iK - i11) / 2)), i11, false)) {
                        return new int[]{i11, iK, i13};
                    }
                    i11 += iArr[0] + iArr[1];
                    int i15 = i12 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i15);
                    iArr[i15] = 0;
                    iArr[i12] = 0;
                    i12--;
                } else {
                    i12++;
                }
                iArr[i12] = 1;
                z11 = !z11;
            }
            iK++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0167  */
    /* JADX WARN: Code duplicated, block: B:103:0x016b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0175 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0177  */
    /* JADX WARN: Code duplicated, block: B:108:0x017b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0180  */
    /* JADX WARN: Code duplicated, block: B:112:0x0186  */
    /* JADX WARN: Code duplicated, block: B:113:0x0189  */
    /* JADX WARN: Code duplicated, block: B:115:0x0190  */
    /* JADX WARN: Code duplicated, block: B:117:0x0194  */
    /* JADX WARN: Code duplicated, block: B:119:0x019a  */
    /* JADX WARN: Code duplicated, block: B:120:0x019f  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:122:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:157:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005c  */
    /* JADX WARN: Code duplicated, block: B:19:0x006c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:0x007b A[LOOP:1: B:23:0x0079->B:24:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0085  */
    /* JADX WARN: Code duplicated, block: B:28:0x008c  */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0095  */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a5 A[FALL_THROUGH, PHI: r3 r21 r22
  0x00a5: PHI (r3v17 boolean) = (r3v1 boolean), (r3v1 boolean), (r3v1 boolean), (r3v1 boolean), (r3v1 boolean), (r3v15 boolean), (r3v1 boolean) binds: [B:108:0x017b, B:116:0x0192, B:120:0x019f, B:119:0x019a, B:104:0x0170, B:34:0x00a2, B:28:0x008c] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r21v18 boolean) = (r21v3 boolean), (r21v3 boolean), (r21v3 boolean), (r21v3 boolean), (r21v2 boolean), (r21v2 boolean), (r21v2 boolean) binds: [B:108:0x017b, B:116:0x0192, B:120:0x019f, B:119:0x019a, B:104:0x0170, B:34:0x00a2, B:28:0x008c] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r22v15 int) = (r22v1 int), (r22v3 int), (r22v3 int), (r22v3 int), (r22v1 int), (r22v1 int), (r22v1 int) binds: [B:108:0x017b, B:116:0x0192, B:120:0x019f, B:119:0x019a, B:104:0x0170, B:34:0x00a2, B:28:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c3 A[FALL_THROUGH, PHI: r21 r22
  0x00c3: PHI (r21v14 boolean) = 
  (r21v5 boolean)
  (r21v5 boolean)
  (r21v5 boolean)
  (r21v5 boolean)
  (r21v15 boolean)
  (r21v15 boolean)
  (r21v15 boolean)
  (r21v15 boolean)
 binds: [B:77:0x012b, B:85:0x0141, B:89:0x014d, B:88:0x0149, B:43:0x00c0, B:51:0x00d7, B:55:0x00e3, B:54:0x00df] A[DONT_GENERATE, DONT_INLINE]
  0x00c3: PHI (r22v10 int) = (r22v1 int), (r22v6 int), (r22v6 int), (r22v6 int), (r22v1 int), (r22v12 int), (r22v12 int), (r22v12 int) binds: [B:77:0x012b, B:85:0x0141, B:89:0x014d, B:88:0x0149, B:43:0x00c0, B:51:0x00d7, B:55:0x00e3, B:54:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00df  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00eb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ed A[PHI: r21
  0x00ed: PHI (r21v12 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:93:0x0159, B:57:0x00eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:60:0x00f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f5 A[PHI: r21
  0x00f5: PHI (r21v11 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:96:0x015e, B:60:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x00f9 A[PHI: r21
  0x00f9: PHI (r21v10 boolean) = (r21v5 boolean), (r21v5 boolean), (r21v15 boolean), (r21v15 boolean) binds: [B:95:0x015c, B:96:0x015e, B:59:0x00f1, B:60:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:65:0x0100 A[PHI: r21
  0x0100: PHI (r21v9 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:77:0x012b, B:43:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0104  */
    /* JADX WARN: Code duplicated, block: B:67:0x0106 A[PHI: r21
  0x0106: PHI (r21v8 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:77:0x012b, B:43:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x010a A[PHI: r21
  0x010a: PHI (r21v7 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:76:0x0129, B:42:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0114 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0116  */
    /* JADX WARN: Code duplicated, block: B:73:0x011d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0127  */
    /* JADX WARN: Code duplicated, block: B:77:0x012b  */
    /* JADX WARN: Code duplicated, block: B:79:0x012f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0135  */
    /* JADX WARN: Code duplicated, block: B:82:0x0138  */
    /* JADX WARN: Code duplicated, block: B:84:0x013f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0143  */
    /* JADX WARN: Code duplicated, block: B:88:0x0149  */
    /* JADX WARN: Code duplicated, block: B:89:0x014d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0153  */
    /* JADX WARN: Code duplicated, block: B:92:0x0157  */
    /* JADX WARN: Code duplicated, block: B:93:0x0159 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x015e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:98:0x0161  */
    /* JADX WARN: Code duplicated, block: B:99:0x0163  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:50:0x00d5
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // qm.q
    public com.google.zxing.j c(int r26, hm.a r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: qm.c.c(int, hm.a, java.util.Map):com.google.zxing.j");
    }
}
