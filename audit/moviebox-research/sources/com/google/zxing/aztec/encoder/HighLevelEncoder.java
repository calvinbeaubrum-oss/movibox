package com.google.zxing.aztec.encoder;

import com.google.zxing.common.CharacterSetECI;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class HighLevelEncoder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f41473c = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f41474d = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[][] f41475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[][] f41476f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f41477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f41478b;

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f41475e = iArr;
        iArr[0][32] = 1;
        for (int i11 = 65; i11 <= 90; i11++) {
            f41475e[0][i11] = i11 - 63;
        }
        f41475e[1][32] = 1;
        for (int i12 = 97; i12 <= 122; i12++) {
            f41475e[1][i12] = i12 - 95;
        }
        f41475e[2][32] = 1;
        for (int i13 = 48; i13 <= 57; i13++) {
            f41475e[2][i13] = i13 - 46;
        }
        int[] iArr2 = f41475e[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, WebSocketProtocol.PAYLOAD_SHORT, 127};
        for (int i14 = 0; i14 < 28; i14++) {
            f41475e[3][iArr3[i14]] = i14;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i15 = 0; i15 < 31; i15++) {
            int i16 = iArr4[i15];
            if (i16 > 0) {
                f41475e[4][i16] = i15;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f41476f = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f41476f;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public HighLevelEncoder(byte[] bArr, Charset charset) {
        this.f41477a = bArr;
        this.f41478b = charset;
    }

    public static Collection<e> b(Iterable<e> iterable) {
        LinkedList linkedList = new LinkedList();
        for (e eVar : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedList.addFirst(eVar);
                    break;
                }
                e eVar2 = (e) it.next();
                if (eVar2.h(eVar)) {
                    break;
                }
                if (eVar.h(eVar2)) {
                    it.remove();
                }
            }
        }
        return linkedList;
    }

    public static void d(e eVar, int i11, int i12, Collection<e> collection) {
        e eVarD = eVar.d(i11);
        collection.add(eVarD.i(4, i12));
        if (eVar.g() != 4) {
            collection.add(eVarD.j(4, i12));
        }
        if (i12 == 3 || i12 == 4) {
            collection.add(eVarD.i(2, 16 - i12).i(2, 1));
        }
        if (eVar.e() > 0) {
            collection.add(eVar.a(i11).a(i11 + 1));
        }
    }

    public static Collection<e> f(Iterable<e> iterable, int i11, int i12) {
        LinkedList linkedList = new LinkedList();
        Iterator<e> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i11, i12, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    public hm.a a() {
        int i11;
        e eVarB = e.f41489f;
        Charset charset = this.f41478b;
        if (charset != null) {
            CharacterSetECI characterSetECI = CharacterSetECI.getCharacterSetECI(charset);
            if (characterSetECI == null) {
                throw new IllegalArgumentException("No ECI code for character set " + this.f41478b);
            }
            eVarB = eVarB.b(characterSetECI.getValue());
        }
        Collection<e> collectionSingletonList = Collections.singletonList(eVarB);
        int i12 = 0;
        while (true) {
            byte[] bArr = this.f41477a;
            if (i12 >= bArr.length) {
                return ((e) Collections.min(collectionSingletonList, new Comparator<e>() { // from class: com.google.zxing.aztec.encoder.HighLevelEncoder.1
                    @Override // java.util.Comparator
                    public int compare(e eVar, e eVar2) {
                        return eVar.f() - eVar2.f();
                    }
                })).k(this.f41477a);
            }
            int i13 = i12 + 1;
            byte b11 = i13 < bArr.length ? bArr[i13] : (byte) 0;
            byte b12 = bArr[i12];
            if (b12 != 13) {
                if (b12 != 44) {
                    if (b12 != 46) {
                        if (b12 == 58 && b11 == 32) {
                            i11 = 5;
                        } else {
                            i11 = 0;
                        }
                    } else if (b11 == 32) {
                        i11 = 3;
                    } else {
                        i11 = 0;
                    }
                } else if (b11 == 32) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
            } else if (b11 == 10) {
                i11 = 2;
            } else {
                i11 = 0;
            }
            if (i11 > 0) {
                collectionSingletonList = f(collectionSingletonList, i12, i11);
                i12 = i13;
            } else {
                collectionSingletonList = e(collectionSingletonList, i12);
            }
            i12++;
        }
    }

    public final void c(e eVar, int i11, Collection<e> collection) {
        char c11 = (char) (this.f41477a[i11] & 255);
        boolean z11 = f41475e[eVar.g()][c11] > 0;
        e eVarD = null;
        for (int i12 = 0; i12 <= 4; i12++) {
            int i13 = f41475e[i12][c11];
            if (i13 > 0) {
                if (eVarD == null) {
                    eVarD = eVar.d(i11);
                }
                if (!z11 || i12 == eVar.g() || i12 == 2) {
                    collection.add(eVarD.i(i12, i13));
                }
                if (!z11 && f41476f[eVar.g()][i12] >= 0) {
                    collection.add(eVarD.j(i12, i13));
                }
            }
        }
        if (eVar.e() > 0 || f41475e[eVar.g()][c11] == 0) {
            collection.add(eVar.a(i11));
        }
    }

    public final Collection<e> e(Iterable<e> iterable, int i11) {
        LinkedList linkedList = new LinkedList();
        Iterator<e> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i11, linkedList);
        }
        return b(linkedList);
    }
}
