package com.bytedance.adsdk.sc.pFF.ExN;

import com.bytedance.adsdk.sc.pFF.We.zY;
import com.bytedance.adsdk.sc.pFF.pFF.sc.ExN;
import com.bytedance.adsdk.sc.pFF.pFF.sc.Ol;
import com.bytedance.adsdk.sc.pFF.pFF.sc.Qj;
import com.bytedance.adsdk.sc.pFF.pFF.sc.Ql;
import com.bytedance.adsdk.sc.pFF.pFF.sc.SR;
import com.bytedance.adsdk.sc.pFF.pFF.sc.Sfl;
import com.bytedance.adsdk.sc.pFF.pFF.sc.TRI;
import com.bytedance.adsdk.sc.pFF.pFF.sc.Tf;
import com.bytedance.adsdk.sc.pFF.pFF.sc.UFX;
import com.bytedance.adsdk.sc.pFF.pFF.sc.We;
import com.bytedance.adsdk.sc.pFF.pFF.sc.Xc;
import com.bytedance.adsdk.sc.pFF.pFF.sc.wjp;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {

    /* JADX INFO: renamed from: com.bytedance.adsdk.sc.pFF.ExN.pFF$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26290sc;

        static {
            int[] iArr = new int[zY.values().length];
            f26290sc = iArr;
            try {
                iArr[zY.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26290sc[zY.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26290sc[zY.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26290sc[zY.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26290sc[zY.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26290sc[zY.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26290sc[zY.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26290sc[zY.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26290sc[zY.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f26290sc[zY.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f26290sc[zY.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f26290sc[zY.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f26290sc[zY.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> pFF(List<com.bytedance.adsdk.sc.pFF.pFF.sc> list, String str, int i11) {
        LinkedList<com.bytedance.adsdk.sc.pFF.pFF.sc> linkedList = new LinkedList(list);
        int i12 = 5;
        while (i12 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.sc.pFF.pFF.sc scVar : linkedList) {
                if (!linkedList2.isEmpty() && zY.sc(((com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList2.peekLast()).sc()) && ((zY) ((com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList2.peekLast()).sc()).pFF() == i12) {
                    com.bytedance.adsdk.sc.pFF.pFF.sc scVar2 = (com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList2.pollLast();
                    com.bytedance.adsdk.sc.pFF.pFF.sc scVar3 = (com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList2.pollLast();
                    if (zY.sc(scVar3.sc()) || zY.sc(scVar.sc())) {
                        throw new IllegalArgumentException(str.substring(0, i11));
                    }
                    linkedList2.addLast(sc(scVar3, scVar2, scVar));
                } else {
                    linkedList2.addLast(scVar);
                }
            }
            i12--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static com.bytedance.adsdk.sc.pFF.pFF.sc sc(com.bytedance.adsdk.sc.pFF.pFF.sc scVar, com.bytedance.adsdk.sc.pFF.pFF.sc scVar2, com.bytedance.adsdk.sc.pFF.pFF.sc scVar3) {
        Xc ufx;
        switch (AnonymousClass1.f26290sc[((zY) scVar2.sc()).ordinal()]) {
            case 1:
                ufx = new UFX();
                break;
            case 2:
                ufx = new wjp();
                break;
            case 3:
                ufx = new com.bytedance.adsdk.sc.pFF.pFF.sc.sc();
                break;
            case 4:
                ufx = new Ql();
                break;
            case 5:
                ufx = new Tf();
                break;
            case 6:
                ufx = new We();
                break;
            case 7:
                ufx = new SR();
                break;
            case 8:
                ufx = new TRI();
                break;
            case 9:
                ufx = new Ol();
                break;
            case 10:
                ufx = new ExN();
                break;
            case 11:
                ufx = new Qj();
                break;
            case 12:
                ufx = new com.bytedance.adsdk.sc.pFF.pFF.sc.pFF();
                break;
            case 13:
                ufx = new com.bytedance.adsdk.sc.pFF.pFF.sc.zY();
                break;
            default:
                throw new UnsupportedOperationException(scVar2.sc().toString());
        }
        ufx.sc(scVar);
        ufx.pFF(scVar3);
        return ufx;
    }

    public static com.bytedance.adsdk.sc.pFF.pFF.sc sc(List<com.bytedance.adsdk.sc.pFF.pFF.sc> list, String str, int i11) {
        zY(list, str, i11);
        Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> dequeSc = sc(pFF(list, str, i11));
        if (dequeSc.size() == 1) {
            return dequeSc.getFirst();
        }
        throw new IllegalStateException();
    }

    private static Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> sc(Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.sc.pFF.pFF.sc scVar : deque) {
            if (linkedList.isEmpty() || ((com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList.peekLast()).sc() != zY.COLON) {
                linkedList.addLast(scVar);
            } else {
                linkedList.pollLast();
                com.bytedance.adsdk.sc.pFF.pFF.sc scVar2 = (com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList.pollLast();
                if (((com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList.pollLast()).sc() != zY.QUESTION) {
                    throw new IllegalStateException();
                }
                com.bytedance.adsdk.sc.pFF.pFF.sc scVar3 = (com.bytedance.adsdk.sc.pFF.pFF.sc) linkedList.pollLast();
                Sfl sfl = new Sfl();
                sfl.sc(scVar3);
                sfl.pFF(scVar2);
                sfl.zY(scVar);
                linkedList.addLast(sfl);
            }
        }
        return linkedList;
    }

    public static boolean sc(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }

    private static void zY(List<com.bytedance.adsdk.sc.pFF.pFF.sc> list, String str, int i11) {
        Iterator<com.bytedance.adsdk.sc.pFF.pFF.sc> it = list.iterator();
        while (it.hasNext()) {
            if (com.bytedance.adsdk.sc.pFF.We.We.sc(it.next().sc())) {
                throw new IllegalArgumentException(str.substring(0, i11));
            }
        }
    }
}
