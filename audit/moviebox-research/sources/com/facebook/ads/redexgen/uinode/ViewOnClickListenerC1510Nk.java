package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1510Nk implements View.OnClickListener {
    public static String[] A03 = {"5NPsaGxTntAZUh5vvPpYLifVDwpYE9gO", "yAdF8jFrPkVudWekKgJT40sKzU7M", "P84QernMh58Oht", "HVjKxCVNtxzSBN1ofjZs3kMRuF4TzLwS", "c9t8G7uI59pglLVDHXf1Cg7BVtBq", "zkFcC9XFE44gS7Ii7sdayH8FvB1qc1Nx", "mQLKSBYKXRgBaCP29rEHxwq0", "ifKB8OntsRJFcWFaLpGEPIeHfTRm85bo"};
    public float A00;
    public float A01;
    public View.OnClickListener A02;

    public ViewOnClickListenerC1510Nk(View.OnClickListener onClickListener) {
        this.A02 = onClickListener;
    }

    public final void A00(float f11, float f12) {
        this.A00 = f11;
        this.A01 = f12;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0050 A[Catch: all -> 0x0088, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0088, blocks: (B:6:0x0008, B:9:0x001c, B:18:0x0050, B:29:0x0082), top: B:34:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        float f11;
        float f12;
        if (KL.A02(this)) {
            return;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            int iAbs = Math.abs(width - height) / 2;
            if (width != height) {
                if (width > height) {
                    float f13 = this.A00;
                    if (f13 >= iAbs) {
                        int i11 = width - iAbs;
                        String[] strArr = A03;
                        if (strArr[1].length() != strArr[4].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A03;
                        strArr2[1] = "IaFg43gDfmav4cpS3tfI5ukrEyaV";
                        strArr2[4] = "YCQU4nAsEaYrX5eT9av2YKK9p1Sz";
                        if (f13 > i11) {
                            if (height <= width) {
                                return;
                            }
                            f11 = this.A01;
                            f12 = iAbs;
                            if (A03[5].charAt(3) != 'B') {
                                A03[0] = "DOfOMptgN0kFoREvgd3Bxl9Eys2o9Nt4";
                                if (f11 < f12) {
                                    return;
                                }
                            } else {
                                String[] strArr3 = A03;
                                strArr3[1] = "SME7OxnBFewA4wdZ4tQVNxKrxX7o";
                                strArr3[4] = "dj4w34xtzstsWLpNapZgfCztNtRS";
                                if (f11 < f12) {
                                    return;
                                }
                            }
                            if (f11 > height - iAbs) {
                                return;
                            }
                        }
                    } else {
                        if (height <= width) {
                            return;
                        }
                        f11 = this.A01;
                        f12 = iAbs;
                        if (A03[5].charAt(3) != 'B') {
                            A03[0] = "DOfOMptgN0kFoREvgd3Bxl9Eys2o9Nt4";
                            if (f11 < f12) {
                                return;
                            }
                        } else {
                            String[] strArr4 = A03;
                            strArr4[1] = "SME7OxnBFewA4wdZ4tQVNxKrxX7o";
                            strArr4[4] = "dj4w34xtzstsWLpNapZgfCztNtRS";
                            if (f11 < f12) {
                                return;
                            }
                        }
                        if (f11 > height - iAbs) {
                            return;
                        }
                    }
                } else {
                    if (height <= width) {
                        return;
                    }
                    f11 = this.A01;
                    f12 = iAbs;
                    if (A03[5].charAt(3) != 'B') {
                        A03[0] = "DOfOMptgN0kFoREvgd3Bxl9Eys2o9Nt4";
                        if (f11 < f12) {
                            return;
                        }
                    } else {
                        String[] strArr5 = A03;
                        strArr5[1] = "SME7OxnBFewA4wdZ4tQVNxKrxX7o";
                        strArr5[4] = "dj4w34xtzstsWLpNapZgfCztNtRS";
                        if (f11 < f12) {
                            return;
                        }
                    }
                    if (f11 > height - iAbs) {
                        return;
                    }
                }
            }
            this.A02.onClick(view);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
