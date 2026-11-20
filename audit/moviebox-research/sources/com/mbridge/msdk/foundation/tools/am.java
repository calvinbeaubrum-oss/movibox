package com.mbridge.msdk.foundation.tools;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class am implements FastKV.a<Set<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final am f45015a = new am();

    private am() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ Set<String> a(byte[] bArr, int i11, int i12) {
        int i13;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i12 > 0) {
            p pVar = new p(bArr, i11);
            int i14 = i11 + i12;
            while (true) {
                i13 = pVar.f45081b;
                if (i13 >= i14) {
                    break;
                }
                byte[] bArr2 = pVar.f45080a;
                int i15 = i13 + 1;
                pVar.f45081b = i15;
                int i16 = bArr2[i13];
                if ((i16 >> 7) != 0) {
                    int i17 = i13 + 2;
                    pVar.f45081b = i17;
                    i16 = (i16 & 127) | (bArr2[i15] << 7);
                    if ((i16 >> 14) != 0) {
                        int i18 = i16 & 16383;
                        int i19 = i13 + 3;
                        pVar.f45081b = i19;
                        int i21 = i18 | (bArr2[i17] << 14);
                        if ((i21 >> 21) == 0) {
                            i16 = i21;
                        } else {
                            int i22 = i13 + 4;
                            pVar.f45081b = i22;
                            i16 = (bArr2[i19] << 21) | (i21 & 2097151);
                            if ((i16 >> 28) != 0) {
                                pVar.f45081b = i13 + 5;
                                i16 = (268435455 & i16) | (bArr2[i22] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(pVar.a(i16));
            }
            if (i13 != i14) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final String a() {
        return "StringSet";
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ byte[] a(Set<String> set) {
        int i11;
        Set<String> set2 = set;
        if (set2.isEmpty()) {
            return new byte[0];
        }
        int size = set2.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i12 = 0;
        int i13 = 0;
        for (String str : set2) {
            if (str == null) {
                i12 += 5;
                iArr[i13] = -1;
            } else {
                int iA = p.a(str);
                strArr[i13] = str;
                iArr[i13] = iA;
                if ((iA >> 7) == 0) {
                    i11 = 1;
                } else if ((iA >> 14) == 0) {
                    i11 = 2;
                } else if ((iA >> 21) == 0) {
                    i11 = 3;
                } else {
                    i11 = (iA >> 28) == 0 ? 4 : 5;
                }
                i12 += i11 + iA;
            }
            i13++;
        }
        p pVar = new p(i12);
        for (int i14 = 0; i14 < size; i14++) {
            int i15 = iArr[i14];
            int i16 = pVar.f45081b;
            int i17 = i15;
            while ((i17 & (-128)) != 0) {
                pVar.f45080a[i16] = (byte) ((i17 & 127) | 128);
                i17 >>>= 7;
                i16++;
            }
            pVar.f45080a[i16] = (byte) i17;
            pVar.f45081b = i16 + 1;
            if (i15 >= 0) {
                pVar.b(strArr[i14]);
            }
        }
        return pVar.f45080a;
    }
}
