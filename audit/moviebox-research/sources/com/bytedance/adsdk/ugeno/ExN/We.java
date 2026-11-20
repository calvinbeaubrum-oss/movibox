package com.bytedance.adsdk.ugeno.ExN;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class We {
    static final /* synthetic */ boolean zY = true;
    private boolean[] ExN;
    private long[] TRI;
    private final com.bytedance.adsdk.ugeno.ExN.sc We;
    long[] pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    int[] f26316sc;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements Comparable<pFF> {
        int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        int f26317sc;

        private pFF() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public int compareTo(pFF pff) {
            int i11 = this.pFF;
            int i12 = pff.pFF;
            return i11 != i12 ? i11 - i12 : this.f26317sc - pff.f26317sc;
        }

        public String toString() {
            return "Order{order=" + this.pFF + ", index=" + this.f26317sc + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        List<zY> f26318sc;

        public void sc() {
            this.f26318sc = null;
            this.pFF = 0;
        }
    }

    public We(com.bytedance.adsdk.ugeno.ExN.sc scVar) {
        this.We = scVar;
    }

    private int ExN(com.bytedance.adsdk.ugeno.ExN.pFF pff, boolean z11) {
        return z11 ? pff.SR() : pff.Ql();
    }

    private int TRI(com.bytedance.adsdk.ugeno.ExN.pFF pff, boolean z11) {
        return z11 ? pff.dE() : pff.BT();
    }

    private int We(com.bytedance.adsdk.ugeno.ExN.pFF pff, boolean z11) {
        return z11 ? pff.BT() : pff.dE();
    }

    private int We(boolean z11) {
        return z11 ? this.We.getPaddingBottom() : this.We.getPaddingEnd();
    }

    private int pFF(int i11, com.bytedance.adsdk.ugeno.ExN.pFF pff, int i12) {
        com.bytedance.adsdk.ugeno.ExN.sc scVar = this.We;
        int iPFF = scVar.pFF(i11, scVar.getPaddingTop() + this.We.getPaddingBottom() + pff.SR() + pff.dE() + i12, pff.pFF());
        int size = View.MeasureSpec.getSize(iPFF);
        if (size > pff.WH()) {
            return View.MeasureSpec.makeMeasureSpec(pff.WH(), View.MeasureSpec.getMode(iPFF));
        }
        return size < pff.Qj() ? View.MeasureSpec.makeMeasureSpec(pff.Qj(), View.MeasureSpec.getMode(iPFF)) : iPFF;
    }

    private int pFF(View view, boolean z11) {
        return z11 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int pFF(com.bytedance.adsdk.ugeno.ExN.pFF pff, boolean z11) {
        return z11 ? pff.pFF() : pff.sc();
    }

    private int pFF(boolean z11) {
        return z11 ? this.We.getPaddingEnd() : this.We.getPaddingBottom();
    }

    private List<pFF> pFF(int i11) {
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) this.We.sc(i12).getLayoutParams();
            pFF pff2 = new pFF();
            pff2.pFF = pff.zY();
            pff2.f26317sc = i12;
            arrayList.add(pff2);
        }
        return arrayList;
    }

    private void pFF(int i11, int i12, zY zYVar, int i13, int i14, boolean z11) {
        int i15;
        int i16;
        int iMax;
        int i17 = zYVar.ExN;
        float f11 = zYVar.UFX;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 > i17) {
            return;
        }
        float f13 = (i17 - i13) / f11;
        zYVar.ExN = i14 + zYVar.TRI;
        if (!z11) {
            zYVar.f26319qr = Integer.MIN_VALUE;
        }
        int i18 = 0;
        boolean z12 = false;
        int i19 = 0;
        float f14 = 0.0f;
        while (i18 < zYVar.Qj) {
            int i21 = zYVar.BT + i18;
            View viewPFF = this.We.pFF(i21);
            if (viewPFF == null || viewPFF.getVisibility() == 8) {
                i15 = i17;
                i16 = i18;
            } else {
                com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) viewPFF.getLayoutParams();
                int flexDirection = this.We.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i15 = i17;
                    int i22 = i18;
                    int measuredWidth = viewPFF.getMeasuredWidth();
                    long[] jArr = this.TRI;
                    if (jArr != null) {
                        measuredWidth = sc(jArr[i21]);
                    }
                    int measuredHeight = viewPFF.getMeasuredHeight();
                    long[] jArr2 = this.TRI;
                    if (jArr2 != null) {
                        measuredHeight = pFF(jArr2[i21]);
                    }
                    if (this.ExN[i21] || pff.ExN() <= 0.0f) {
                        i16 = i22;
                    } else {
                        float fExN = measuredWidth - (pff.ExN() * f13);
                        if (i16 == zYVar.Qj - 1) {
                            i16 = i22;
                            fExN += f14;
                            f14 = 0.0f;
                        }
                        i16 = i22;
                        int iRound = Math.round(fExN);
                        if (iRound < pff.qr()) {
                            iRound = pff.qr();
                            this.ExN[i21] = true;
                            zYVar.UFX -= pff.ExN();
                            z12 = true;
                        } else {
                            f14 += fExN - iRound;
                            double d11 = f14;
                            if (d11 > 1.0d) {
                                iRound++;
                                f14 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                iRound--;
                                f14 += 1.0f;
                            }
                        }
                        int iPFF = pFF(i12, pff, zYVar.Ql);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewPFF.measure(iMakeMeasureSpec, iPFF);
                        int measuredWidth2 = viewPFF.getMeasuredWidth();
                        int measuredHeight2 = viewPFF.getMeasuredHeight();
                        sc(i21, iMakeMeasureSpec, iPFF, viewPFF);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i19, measuredHeight + pff.SR() + pff.dE() + this.We.sc(viewPFF));
                    zYVar.ExN += measuredWidth + pff.Ql() + pff.BT();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewPFF.getMeasuredHeight();
                    long[] jArr3 = this.TRI;
                    if (jArr3 != null) {
                        measuredHeight3 = pFF(jArr3[i21]);
                    }
                    int measuredWidth3 = viewPFF.getMeasuredWidth();
                    long[] jArr4 = this.TRI;
                    if (jArr4 != null) {
                        measuredWidth3 = sc(jArr4[i21]);
                    }
                    if (this.ExN[i21] || pff.ExN() <= f12) {
                        i15 = i17;
                        i16 = i18;
                    } else {
                        float fExN2 = measuredHeight3 - (pff.ExN() * f13);
                        if (i18 == zYVar.Qj - 1) {
                            fExN2 += f14;
                            f14 = 0.0f;
                        }
                        int iRound2 = Math.round(fExN2);
                        if (iRound2 < pff.Qj()) {
                            iRound2 = pff.Qj();
                            this.ExN[i21] = true;
                            zYVar.UFX -= pff.ExN();
                            i15 = i17;
                            i16 = i18;
                            z12 = true;
                        } else {
                            f14 += fExN2 - iRound2;
                            i15 = i17;
                            i16 = i18;
                            double d12 = f14;
                            if (d12 > 1.0d) {
                                iRound2++;
                                f14 -= 1.0f;
                            } else if (d12 < -1.0d) {
                                iRound2--;
                                f14 += 1.0f;
                            }
                        }
                        int iSc = sc(i11, pff, zYVar.Ql);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewPFF.measure(iSc, iMakeMeasureSpec2);
                        measuredWidth3 = viewPFF.getMeasuredWidth();
                        int measuredHeight4 = viewPFF.getMeasuredHeight();
                        sc(i21, iSc, iMakeMeasureSpec2, viewPFF);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i19, measuredWidth3 + pff.Ql() + pff.BT() + this.We.sc(viewPFF));
                    zYVar.ExN += measuredHeight3 + pff.SR() + pff.dE();
                }
                zYVar.f26319qr = Math.max(zYVar.f26319qr, iMax);
                i19 = iMax;
            }
            i18 = i16 + 1;
            i17 = i15;
            f12 = 0.0f;
        }
        int i23 = i17;
        if (!z12 || i23 == zYVar.ExN) {
            return;
        }
        pFF(i11, i12, zYVar, i13, i14, true);
    }

    private void pFF(View view, int i11, int i12) {
        com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i11 - pff.Ql()) - pff.BT()) - this.We.sc(view), pff.qr()), pff.Ol());
        long[] jArr = this.TRI;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? pFF(jArr[i12]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        sc(i12, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    private int sc(int i11, com.bytedance.adsdk.ugeno.ExN.pFF pff, int i12) {
        com.bytedance.adsdk.ugeno.ExN.sc scVar = this.We;
        int iSc = scVar.sc(i11, scVar.getPaddingLeft() + this.We.getPaddingRight() + pff.Ql() + pff.BT() + i12, pff.sc());
        int size = View.MeasureSpec.getSize(iSc);
        if (size > pff.Ol()) {
            return View.MeasureSpec.makeMeasureSpec(pff.Ol(), View.MeasureSpec.getMode(iSc));
        }
        return size < pff.qr() ? View.MeasureSpec.makeMeasureSpec(pff.qr(), View.MeasureSpec.getMode(iSc)) : iSc;
    }

    private int sc(View view, boolean z11) {
        return z11 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int sc(com.bytedance.adsdk.ugeno.ExN.pFF pff, boolean z11) {
        return z11 ? pff.sc() : pff.pFF();
    }

    private int sc(boolean z11) {
        return z11 ? this.We.getPaddingStart() : this.We.getPaddingTop();
    }

    private List<zY> sc(List<zY> list, int i11, int i12) {
        int i13 = (i11 - i12) / 2;
        ArrayList arrayList = new ArrayList();
        zY zYVar = new zY();
        zYVar.f26319qr = i13;
        int size = list.size();
        for (int i14 = 0; i14 < size; i14++) {
            if (i14 == 0) {
                arrayList.add(zYVar);
            }
            arrayList.add(list.get(i14));
            if (i14 == list.size() - 1) {
                arrayList.add(zYVar);
            }
        }
        return arrayList;
    }

    private void sc(int i11, int i12, int i13, View view) {
        long[] jArr = this.pFF;
        if (jArr != null) {
            jArr[i11] = pFF(i12, i13);
        }
        long[] jArr2 = this.TRI;
        if (jArr2 != null) {
            jArr2[i11] = pFF(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void sc(int i11, int i12, zY zYVar, int i13, int i14, boolean z11) {
        int i15;
        int i16;
        int iMax;
        double d11;
        int i17;
        double d12;
        float f11 = zYVar.WH;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 < (i15 = zYVar.ExN)) {
            return;
        }
        float f13 = (i13 - i15) / f11;
        zYVar.ExN = i14 + zYVar.TRI;
        if (!z11) {
            zYVar.f26319qr = Integer.MIN_VALUE;
        }
        int i18 = 0;
        boolean z12 = false;
        int i19 = 0;
        float f14 = 0.0f;
        while (i18 < zYVar.Qj) {
            int i21 = zYVar.BT + i18;
            View viewPFF = this.We.pFF(i21);
            if (viewPFF == null || viewPFF.getVisibility() == 8) {
                i16 = i15;
            } else {
                com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) viewPFF.getLayoutParams();
                int flexDirection = this.We.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i22 = i15;
                    int measuredWidth = viewPFF.getMeasuredWidth();
                    long[] jArr = this.TRI;
                    if (jArr != null) {
                        measuredWidth = sc(jArr[i21]);
                    }
                    int measuredHeight = viewPFF.getMeasuredHeight();
                    long[] jArr2 = this.TRI;
                    i16 = i22;
                    if (jArr2 != null) {
                        measuredHeight = pFF(jArr2[i21]);
                    }
                    if (!this.ExN[i21] && pff.We() > 0.0f) {
                        float fWe = measuredWidth + (pff.We() * f13);
                        if (i18 == zYVar.Qj - 1) {
                            fWe += f14;
                            f14 = 0.0f;
                        }
                        int iRound = Math.round(fWe);
                        if (iRound > pff.Ol()) {
                            iRound = pff.Ol();
                            this.ExN[i21] = true;
                            zYVar.WH -= pff.We();
                            z12 = true;
                        } else {
                            f14 += fWe - iRound;
                            double d13 = f14;
                            if (d13 > 1.0d) {
                                iRound++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                iRound--;
                                d11 = d13 + 1.0d;
                            }
                            f14 = (float) d11;
                        }
                        int iPFF = pFF(i12, pff, zYVar.Ql);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewPFF.measure(iMakeMeasureSpec, iPFF);
                        int measuredWidth2 = viewPFF.getMeasuredWidth();
                        int measuredHeight2 = viewPFF.getMeasuredHeight();
                        sc(i21, iMakeMeasureSpec, iPFF, viewPFF);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i19, measuredHeight + pff.SR() + pff.dE() + this.We.sc(viewPFF));
                    zYVar.ExN += measuredWidth + pff.Ql() + pff.BT();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewPFF.getMeasuredHeight();
                    long[] jArr3 = this.TRI;
                    if (jArr3 != null) {
                        measuredHeight3 = pFF(jArr3[i21]);
                    }
                    int measuredWidth3 = viewPFF.getMeasuredWidth();
                    long[] jArr4 = this.TRI;
                    if (jArr4 != null) {
                        measuredWidth3 = sc(jArr4[i21]);
                    }
                    if (this.ExN[i21] || pff.We() <= f12) {
                        i17 = i15;
                    } else {
                        float fWe2 = measuredHeight3 + (pff.We() * f13);
                        if (i18 == zYVar.Qj - 1) {
                            fWe2 += f14;
                            f14 = 0.0f;
                        }
                        int iRound2 = Math.round(fWe2);
                        if (iRound2 > pff.WH()) {
                            iRound2 = pff.WH();
                            this.ExN[i21] = true;
                            zYVar.WH -= pff.We();
                            i17 = i15;
                            z12 = true;
                        } else {
                            f14 += fWe2 - iRound2;
                            i17 = i15;
                            double d14 = f14;
                            if (d14 > 1.0d) {
                                iRound2++;
                                d12 = d14 - 1.0d;
                            } else if (d14 < -1.0d) {
                                iRound2--;
                                d12 = d14 + 1.0d;
                            }
                            f14 = (float) d12;
                        }
                        int iSc = sc(i11, pff, zYVar.Ql);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewPFF.measure(iSc, iMakeMeasureSpec2);
                        measuredWidth3 = viewPFF.getMeasuredWidth();
                        int measuredHeight4 = viewPFF.getMeasuredHeight();
                        sc(i21, iSc, iMakeMeasureSpec2, viewPFF);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i19, measuredWidth3 + pff.Ql() + pff.BT() + this.We.sc(viewPFF));
                    zYVar.ExN += measuredHeight3 + pff.SR() + pff.dE();
                    i16 = i17;
                }
                zYVar.f26319qr = Math.max(zYVar.f26319qr, iMax);
                i19 = iMax;
            }
            i18++;
            i15 = i16;
            f12 = 0.0f;
        }
        int i23 = i15;
        if (!z12 || i23 == zYVar.ExN) {
            return;
        }
        sc(i11, i12, zYVar, i13, i14, true);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void sc(View view, int i11) {
        boolean z11;
        com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z12 = true;
        if (measuredWidth >= pff.qr()) {
            if (measuredWidth > pff.Ol()) {
                measuredWidth = pff.Ol();
            } else {
                z11 = false;
            }
            if (measuredHeight < pff.Qj()) {
                measuredHeight = pff.Qj();
            } else if (measuredHeight > pff.WH()) {
                measuredHeight = pff.WH();
            } else {
                z12 = z11;
            }
            if (z12) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                sc(i11, iMakeMeasureSpec, iMakeMeasureSpec2, view);
            }
        }
        measuredWidth = pff.qr();
        z11 = true;
        if (measuredHeight < pff.Qj()) {
            measuredHeight = pff.Qj();
        } else if (measuredHeight > pff.WH()) {
            measuredHeight = pff.WH();
        } else {
            z12 = z11;
        }
        if (z12) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            sc(i11, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
        }
    }

    private void sc(View view, int i11, int i12) {
        com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i11 - pff.SR()) - pff.dE()) - this.We.sc(view), pff.Qj()), pff.WH());
        long[] jArr = this.TRI;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? sc(jArr[i12]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        sc(i12, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void sc(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) compoundButton.getLayoutParams();
        int iQr = pff.qr();
        int iQj = pff.Qj();
        Drawable drawableSc = com.bytedance.adsdk.ugeno.qr.ExN.sc(compoundButton);
        int minimumWidth = drawableSc == null ? 0 : drawableSc.getMinimumWidth();
        int minimumHeight = drawableSc != null ? drawableSc.getMinimumHeight() : 0;
        if (iQr == -1) {
            iQr = minimumWidth;
        }
        pff.sc(iQr);
        if (iQj == -1) {
            iQj = minimumHeight;
        }
        pff.pFF(iQj);
    }

    private void sc(List<zY> list, zY zYVar, int i11, int i12) {
        zYVar.Ql = i12;
        this.We.sc(zYVar);
        zYVar.dE = i11;
        list.add(zYVar);
    }

    private boolean sc(int i11, int i12, zY zYVar) {
        return i11 == i12 - 1 && zYVar.pFF() != 0;
    }

    private boolean sc(View view, int i11, int i12, int i13, int i14, com.bytedance.adsdk.ugeno.ExN.pFF pff, int i15, int i16, int i17) {
        if (this.We.getFlexWrap() == 0) {
            return false;
        }
        if (pff.UFX()) {
            return true;
        }
        if (i11 == 0) {
            return false;
        }
        int maxLine = this.We.getMaxLine();
        if (maxLine != -1 && maxLine <= i17 + 1) {
            return false;
        }
        int iSc = this.We.sc(view, i15, i16);
        if (iSc > 0) {
            i14 += iSc;
        }
        return i12 < i13 + i14;
    }

    private int[] sc(int i11, List<pFF> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i11];
        int i12 = 0;
        for (pFF pff : list) {
            int i13 = pff.f26317sc;
            iArr[i12] = i13;
            sparseIntArray.append(i13, pff.pFF);
            i12++;
        }
        return iArr;
    }

    private int zY(com.bytedance.adsdk.ugeno.ExN.pFF pff, boolean z11) {
        return z11 ? pff.Ql() : pff.SR();
    }

    private int zY(boolean z11) {
        return z11 ? this.We.getPaddingTop() : this.We.getPaddingStart();
    }

    private void zY(int i11) {
        boolean[] zArr = this.ExN;
        if (zArr == null) {
            this.ExN = new boolean[Math.max(i11, 10)];
        } else if (zArr.length < i11) {
            this.ExN = new boolean[Math.max(zArr.length * 2, i11)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public int pFF(long j11) {
        return (int) (j11 >> 32);
    }

    public long pFF(int i11, int i12) {
        return (((long) i11) & 4294967295L) | (((long) i12) << 32);
    }

    public void pFF(int i11, int i12, int i13) {
        int mode;
        int size;
        int flexDirection = this.We.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i12);
            int size2 = View.MeasureSpec.getSize(i12);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            mode = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
        }
        List<zY> flexLinesInternal = this.We.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.We.getSumOfCrossSize() + i13;
            int i14 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f26319qr = size - i13;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.We.getAlignContent();
                if (alignContent == 1) {
                    int i15 = size - sumOfCrossSize;
                    zY zYVar = new zY();
                    zYVar.f26319qr = i15;
                    flexLinesInternal.add(0, zYVar);
                    return;
                }
                if (alignContent == 2) {
                    this.We.setFlexLines(sc(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f11 = 0.0f;
                        while (i14 < size4) {
                            arrayList.add(flexLinesInternal.get(i14));
                            if (i14 != flexLinesInternal.size() - 1) {
                                zY zYVar2 = new zY();
                                if (i14 == flexLinesInternal.size() - 2) {
                                    zYVar2.f26319qr = Math.round(f11 + size3);
                                    f11 = 0.0f;
                                } else {
                                    zYVar2.f26319qr = Math.round(size3);
                                }
                                int i16 = zYVar2.f26319qr;
                                f11 += size3 - i16;
                                if (f11 > 1.0f) {
                                    zYVar2.f26319qr = i16 + 1;
                                    f11 -= 1.0f;
                                } else if (f11 < -1.0f) {
                                    zYVar2.f26319qr = i16 - 1;
                                    f11 += 1.0f;
                                }
                                arrayList.add(zYVar2);
                            }
                            i14++;
                        }
                        this.We.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.We.setFlexLines(sc(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    zY zYVar3 = new zY();
                    zYVar3.f26319qr = size5;
                    for (zY zYVar4 : flexLinesInternal) {
                        arrayList2.add(zYVar3);
                        arrayList2.add(zYVar4);
                        arrayList2.add(zYVar3);
                    }
                    this.We.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f12 = 0.0f;
                    while (i14 < size7) {
                        zY zYVar5 = flexLinesInternal.get(i14);
                        float f13 = zYVar5.f26319qr + size6;
                        if (i14 == flexLinesInternal.size() - 1) {
                            f13 += f12;
                            f12 = 0.0f;
                        }
                        int iRound = Math.round(f13);
                        f12 += f13 - iRound;
                        if (f12 > 1.0f) {
                            iRound++;
                            f12 -= 1.0f;
                        } else if (f12 < -1.0f) {
                            iRound--;
                            f12 += 1.0f;
                        }
                        zYVar5.f26319qr = iRound;
                        i14++;
                    }
                }
            }
        }
    }

    public void pFF(sc scVar, int i11, int i12) {
        sc(scVar, i12, i11, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, (List<zY>) null);
    }

    public boolean pFF(SparseIntArray sparseIntArray) {
        int flexItemCount = this.We.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i11 = 0; i11 < flexItemCount; i11++) {
            View viewSc = this.We.sc(i11);
            if (viewSc != null && ((com.bytedance.adsdk.ugeno.ExN.pFF) viewSc.getLayoutParams()).zY() != sparseIntArray.get(i11)) {
                return true;
            }
        }
        return false;
    }

    public int sc(long j11) {
        return (int) j11;
    }

    public void sc() {
        sc(0);
    }

    public void sc(int i11) {
        View viewPFF;
        if (i11 >= this.We.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.We.getFlexDirection();
        if (this.We.getAlignItems() != 4) {
            for (zY zYVar : this.We.getFlexLinesInternal()) {
                for (Integer num : zYVar.SR) {
                    View viewPFF2 = this.We.pFF(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        sc(viewPFF2, zYVar.f26319qr, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                        }
                        pFF(viewPFF2, zYVar.f26319qr, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f26316sc;
        List<zY> flexLinesInternal = this.We.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i12 = iArr != null ? iArr[i11] : 0; i12 < size; i12++) {
            zY zYVar2 = flexLinesInternal.get(i12);
            int i13 = zYVar2.Qj;
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = zYVar2.BT + i14;
                if (i14 < this.We.getFlexItemCount() && (viewPFF = this.We.pFF(i15)) != null && viewPFF.getVisibility() != 8) {
                    com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) viewPFF.getLayoutParams();
                    if (pff.TRI() == -1 || pff.TRI() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            sc(viewPFF, zYVar2.f26319qr, i15);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                            pFF(viewPFF, zYVar2.f26319qr, i15);
                        }
                    }
                }
            }
        }
    }

    public void sc(int i11, int i12) {
        sc(i11, i12, 0);
    }

    public void sc(int i11, int i12, int i13) {
        int size;
        int paddingLeft;
        int paddingRight;
        zY(this.We.getFlexItemCount());
        if (i13 >= this.We.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.We.getFlexDirection();
        int flexDirection2 = this.We.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            int largestMainSize = this.We.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.We.getPaddingLeft();
            paddingRight = this.We.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode2 = View.MeasureSpec.getMode(i12);
            size = View.MeasureSpec.getSize(i12);
            if (mode2 != 1073741824) {
                size = this.We.getLargestMainSize();
            }
            paddingLeft = this.We.getPaddingTop();
            paddingRight = this.We.getPaddingBottom();
        }
        int i14 = paddingLeft + paddingRight;
        int[] iArr = this.f26316sc;
        List<zY> flexLinesInternal = this.We.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i15 = iArr != null ? iArr[i13] : 0; i15 < size2; i15++) {
            zY zYVar = flexLinesInternal.get(i15);
            int i16 = zYVar.ExN;
            if (i16 < size && zYVar.Xc) {
                sc(i11, i12, zYVar, size, i14, false);
            } else if (i16 > size && zYVar.wjp) {
                pFF(i11, i12, zYVar, size, i14, false);
            }
        }
    }

    public void sc(View view, zY zYVar, int i11, int i12, int i13, int i14) {
        com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) view.getLayoutParams();
        int alignItems = this.We.getAlignItems();
        if (pff.TRI() != -1) {
            alignItems = pff.TRI();
        }
        int i15 = zYVar.f26319qr;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.We.getFlexWrap() == 2) {
                    view.layout(i11, (i12 - i15) + view.getMeasuredHeight() + pff.SR(), i13, (i14 - i15) + view.getMeasuredHeight() + pff.SR());
                    return;
                } else {
                    int i16 = i12 + i15;
                    view.layout(i11, (i16 - view.getMeasuredHeight()) - pff.dE(), i13, i16 - pff.dE());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i15 - view.getMeasuredHeight()) + pff.SR()) - pff.dE()) / 2;
                if (this.We.getFlexWrap() != 2) {
                    int i17 = i12 + measuredHeight;
                    view.layout(i11, i17, i13, view.getMeasuredHeight() + i17);
                    return;
                } else {
                    int i18 = i12 - measuredHeight;
                    view.layout(i11, i18, i13, view.getMeasuredHeight() + i18);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.We.getFlexWrap() != 2) {
                    int iMax = Math.max(zYVar.Tf - view.getBaseline(), pff.SR());
                    view.layout(i11, i12 + iMax, i13, i14 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((zYVar.Tf - view.getMeasuredHeight()) + view.getBaseline(), pff.dE());
                    view.layout(i11, i12 - iMax2, i13, i14 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.We.getFlexWrap() != 2) {
            view.layout(i11, i12 + pff.SR(), i13, i14 + pff.SR());
        } else {
            view.layout(i11, i12 - pff.dE(), i13, i14 - pff.dE());
        }
    }

    public void sc(View view, zY zYVar, boolean z11, int i11, int i12, int i13, int i14) {
        com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) view.getLayoutParams();
        int alignItems = this.We.getAlignItems();
        if (pff.TRI() != -1) {
            alignItems = pff.TRI();
        }
        int i15 = zYVar.f26319qr;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z11) {
                    view.layout((i11 - i15) + view.getMeasuredWidth() + pff.Ql(), i12, (i13 - i15) + view.getMeasuredWidth() + pff.Ql(), i14);
                    return;
                } else {
                    view.layout(((i11 + i15) - view.getMeasuredWidth()) - pff.BT(), i12, ((i13 + i15) - view.getMeasuredWidth()) - pff.BT(), i14);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i15 - view.getMeasuredWidth()) + com.bytedance.adsdk.ugeno.qr.TRI.sc(marginLayoutParams)) - com.bytedance.adsdk.ugeno.qr.TRI.pFF(marginLayoutParams)) / 2;
                if (z11) {
                    view.layout(i11 - measuredWidth, i12, i13 - measuredWidth, i14);
                    return;
                } else {
                    view.layout(i11 + measuredWidth, i12, i13 + measuredWidth, i14);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z11) {
            view.layout(i11 - pff.BT(), i12, i13 - pff.BT(), i14);
        } else {
            view.layout(i11 + pff.Ql(), i12, i13 + pff.Ql(), i14);
        }
    }

    public void sc(sc scVar, int i11, int i12) {
        sc(scVar, i11, i12, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, (List<zY>) null);
    }

    public void sc(sc scVar, int i11, int i12, int i13, int i14, int i15, List<zY> list) {
        int i16;
        int i17;
        List<zY> list2;
        int i18;
        View view;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27 = i12;
        int i28 = i15;
        boolean zSc = this.We.sc();
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        List<zY> arrayList = list == null ? new ArrayList() : list;
        scVar.f26318sc = arrayList;
        boolean z11 = i28 == -1;
        int iSc = sc(zSc);
        int iPFF = pFF(zSc);
        int iZY = zY(zSc);
        int iWe = We(zSc);
        zY zYVar = new zY();
        int i29 = i14;
        zYVar.BT = i29;
        int i31 = iPFF + iSc;
        zYVar.ExN = i31;
        int flexItemCount = this.We.getFlexItemCount();
        boolean z12 = z11;
        int i32 = 0;
        int iCombineMeasuredStates = 0;
        int i33 = 0;
        int i34 = Integer.MIN_VALUE;
        while (i29 < flexItemCount) {
            View viewPFF = this.We.pFF(i29);
            if (viewPFF != null) {
                if (viewPFF.getVisibility() == 8) {
                    zYVar.Ol++;
                    zYVar.Qj++;
                    if (sc(i29, flexItemCount, zYVar)) {
                        sc(arrayList, zYVar, i29, i32);
                    }
                } else {
                    if (viewPFF instanceof CompoundButton) {
                        sc((CompoundButton) viewPFF);
                    }
                    com.bytedance.adsdk.ugeno.ExN.pFF pff = (com.bytedance.adsdk.ugeno.ExN.pFF) viewPFF.getLayoutParams();
                    int i35 = flexItemCount;
                    if (pff.TRI() == 4) {
                        zYVar.SR.add(Integer.valueOf(i29));
                    }
                    int iSc2 = sc(pff, zSc);
                    if (pff.Tf() != -1.0f && mode == 1073741824) {
                        iSc2 = Math.round(size * pff.Tf());
                    }
                    if (zSc) {
                        int iSc3 = this.We.sc(i11, i31 + zY(pff, true) + We(pff, true), iSc2);
                        int iPFF2 = this.We.pFF(i27, iZY + iWe + ExN(pff, true) + TRI(pff, true) + i32, pFF(pff, true));
                        viewPFF.measure(iSc3, iPFF2);
                        sc(i29, iSc3, iPFF2, viewPFF);
                        i17 = iSc3;
                    } else {
                        int iSc4 = this.We.sc(i27, iZY + iWe + ExN(pff, false) + TRI(pff, false) + i32, pFF(pff, false));
                        int iPFF3 = this.We.pFF(i11, zY(pff, false) + i31 + We(pff, false), iSc2);
                        viewPFF.measure(iSc4, iPFF3);
                        sc(i29, iSc4, iPFF3, viewPFF);
                        i17 = iPFF3;
                    }
                    sc(viewPFF, i29);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewPFF.getMeasuredState());
                    int i36 = i32;
                    int i37 = i31;
                    zY zYVar2 = zYVar;
                    int i38 = i29;
                    list2 = arrayList;
                    int i39 = i17;
                    if (sc(viewPFF, mode, size, zYVar.ExN, We(pff, zSc) + sc(viewPFF, zSc) + zY(pff, zSc), pff, i38, i33, arrayList.size())) {
                        i29 = i38;
                        if (zYVar2.pFF() > 0) {
                            sc(list2, zYVar2, i29 > 0 ? i29 - 1 : 0, i36);
                            i32 = zYVar2.f26319qr + i36;
                        } else {
                            i32 = i36;
                        }
                        if (!zSc) {
                            i18 = i12;
                            view = viewPFF;
                            i22 = -1;
                            if (pff.sc() == -1) {
                                com.bytedance.adsdk.ugeno.ExN.sc scVar2 = this.We;
                                view.measure(scVar2.sc(i18, scVar2.getPaddingLeft() + this.We.getPaddingRight() + pff.Ql() + pff.BT() + i32, pff.sc()), i39);
                                sc(view, i29);
                            }
                        } else if (pff.pFF() == -1) {
                            com.bytedance.adsdk.ugeno.ExN.sc scVar3 = this.We;
                            i18 = i12;
                            i22 = -1;
                            view = viewPFF;
                            view.measure(i39, scVar3.pFF(i18, scVar3.getPaddingTop() + this.We.getPaddingBottom() + pff.SR() + pff.dE() + i32, pff.pFF()));
                            sc(view, i29);
                        } else {
                            i18 = i12;
                            view = viewPFF;
                            i22 = -1;
                        }
                        zYVar = new zY();
                        i21 = 1;
                        zYVar.Qj = 1;
                        i19 = i37;
                        zYVar.ExN = i19;
                        zYVar.BT = i29;
                        i23 = 0;
                        i24 = Integer.MIN_VALUE;
                    } else {
                        i18 = i12;
                        i29 = i38;
                        view = viewPFF;
                        zYVar = zYVar2;
                        i19 = i37;
                        i21 = 1;
                        i22 = -1;
                        zYVar.Qj++;
                        i23 = i33 + 1;
                        i32 = i36;
                        i24 = i34;
                    }
                    zYVar.Xc |= pff.We() != 0.0f;
                    zYVar.wjp |= pff.ExN() != 0.0f;
                    int[] iArr = this.f26316sc;
                    if (iArr != null) {
                        iArr[i29] = list2.size();
                    }
                    zYVar.ExN += sc(view, zSc) + zY(pff, zSc) + We(pff, zSc);
                    zYVar.WH += pff.We();
                    zYVar.UFX += pff.ExN();
                    this.We.sc(view, i29, i23, zYVar);
                    int iMax = Math.max(i24, pFF(view, zSc) + ExN(pff, zSc) + TRI(pff, zSc) + this.We.sc(view));
                    zYVar.f26319qr = Math.max(zYVar.f26319qr, iMax);
                    if (zSc) {
                        if (this.We.getFlexWrap() != 2) {
                            zYVar.Tf = Math.max(zYVar.Tf, view.getBaseline() + pff.SR());
                        } else {
                            zYVar.Tf = Math.max(zYVar.Tf, (view.getMeasuredHeight() - view.getBaseline()) + pff.dE());
                        }
                    }
                    i25 = i35;
                    if (sc(i29, i25, zYVar)) {
                        sc(list2, zYVar, i29, i32);
                        i32 += zYVar.f26319qr;
                    }
                    i26 = i15;
                    if (i26 != i22 && list2.size() > 0 && list2.get(list2.size() - i21).dE >= i26 && i29 >= i26 && !z12) {
                        i32 = -zYVar.sc();
                        z12 = true;
                    }
                    if (i32 > i13 && z12) {
                        i16 = iCombineMeasuredStates;
                        scVar.pFF = i16;
                    } else {
                        i33 = i23;
                        i34 = iMax;
                    }
                }
                i29++;
                flexItemCount = i25;
                i27 = i18;
                i31 = i19;
                arrayList = list2;
                size = size;
                mode = mode;
                i28 = i26;
            } else if (sc(i29, flexItemCount, zYVar)) {
                sc(arrayList, zYVar, i29, i32);
            }
            size = size;
            mode = mode;
            i18 = i27;
            i26 = i28;
            i19 = i31;
            list2 = arrayList;
            i25 = flexItemCount;
            i29++;
            flexItemCount = i25;
            i27 = i18;
            i31 = i19;
            arrayList = list2;
            size = size;
            mode = mode;
            i28 = i26;
        }
        i16 = iCombineMeasuredStates;
        scVar.pFF = i16;
    }

    public int[] sc(SparseIntArray sparseIntArray) {
        int flexItemCount = this.We.getFlexItemCount();
        return sc(flexItemCount, pFF(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] sc(View view, int i11, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.We.getFlexItemCount();
        List<pFF> listPFF = pFF(flexItemCount);
        pFF pff = new pFF();
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.ExN.pFF)) {
            pff.pFF = 1;
        } else {
            pff.pFF = ((com.bytedance.adsdk.ugeno.ExN.pFF) layoutParams).zY();
        }
        if (i11 == -1 || i11 == flexItemCount || i11 >= this.We.getFlexItemCount()) {
            pff.f26317sc = flexItemCount;
        } else {
            pff.f26317sc = i11;
            while (i11 < flexItemCount) {
                listPFF.get(i11).f26317sc++;
                i11++;
            }
        }
        listPFF.add(pff);
        return sc(flexItemCount + 1, listPFF, sparseIntArray);
    }
}
