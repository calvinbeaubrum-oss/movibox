package com.bytedance.adsdk.pFF.zY.zY;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.pFF.YIK;
import com.bytedance.adsdk.pFF.sc.pFF.BT;
import com.bytedance.adsdk.pFF.zY.pFF.dE;
import com.bytedance.adsdk.pFF.zY.sc.UFX;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends com.bytedance.adsdk.pFF.zY.zY.sc {
    private final BT BT;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> Dl;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> FI;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Typeface, Typeface> II;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> JPJ;
    private final Matrix Ol;
    private final RectF Qj;
    private final LongSparseArray<String> Ql;
    private final List<sc> SR;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> Sfl;
    private final Map<com.bytedance.adsdk.pFF.zY.We, List<com.bytedance.adsdk.pFF.sc.sc.We>> Tf;
    private final Paint UFX;
    private final Paint WH;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> WP;
    private final com.bytedance.adsdk.pFF.qr Xc;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> YIK;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> cvk;
    private final com.bytedance.adsdk.pFF.Ol dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final StringBuilder f26276qr;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> uEA;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> wjp;

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.zY.zY.Ol$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26279sc;

        static {
            int[] iArr = new int[com.bytedance.adsdk.pFF.zY.pFF.sc.values().length];
            f26279sc = iArr;
            try {
                iArr[com.bytedance.adsdk.pFF.zY.pFF.sc.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26279sc[com.bytedance.adsdk.pFF.zY.pFF.sc.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26279sc[com.bytedance.adsdk.pFF.zY.pFF.sc.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private float pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f26280sc;

        private sc() {
            this.f26280sc = "";
            this.pFF = 0.0f;
        }

        public void sc(String str, float f11) {
            this.f26280sc = str;
            this.pFF = f11;
        }
    }

    public Ol(com.bytedance.adsdk.pFF.Ol ol2, ExN exN) {
        com.bytedance.adsdk.pFF.zY.sc.pFF pff;
        com.bytedance.adsdk.pFF.zY.sc.pFF pff2;
        com.bytedance.adsdk.pFF.zY.sc.sc scVar;
        com.bytedance.adsdk.pFF.zY.sc.sc scVar2;
        super(ol2, exN);
        this.f26276qr = new StringBuilder(2);
        this.Qj = new RectF();
        this.Ol = new Matrix();
        int i11 = 1;
        this.WH = new Paint(i11) { // from class: com.bytedance.adsdk.pFF.zY.zY.Ol.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.UFX = new Paint(i11) { // from class: com.bytedance.adsdk.pFF.zY.zY.Ol.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Tf = new HashMap();
        this.Ql = new LongSparseArray<>();
        this.SR = new ArrayList();
        this.dE = ol2;
        this.Xc = exN.sc();
        BT btSc = exN.Sfl().sc();
        this.BT = btSc;
        btSc.sc(this);
        sc(btSc);
        UFX ufxYIK = exN.YIK();
        if (ufxYIK != null && (scVar2 = ufxYIK.f26268sc) != null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVarSc = scVar2.sc();
            this.wjp = scVarSc;
            scVarSc.sc(this);
            sc(this.wjp);
        }
        if (ufxYIK != null && (scVar = ufxYIK.pFF) != null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVarSc2 = scVar.sc();
            this.YIK = scVarSc2;
            scVarSc2.sc(this);
            sc(this.YIK);
        }
        if (ufxYIK != null && (pff2 = ufxYIK.zY) != null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc3 = pff2.sc();
            this.uEA = scVarSc3;
            scVarSc3.sc(this);
            sc(this.uEA);
        }
        if (ufxYIK == null || (pff = ufxYIK.We) == null) {
            return;
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc4 = pff.sc();
        this.FI = scVarSc4;
        scVarSc4.sc(this);
        sc(this.FI);
    }

    private sc pFF(int i11) {
        for (int size = this.SR.size(); size < i11; size++) {
            this.SR.add(new sc());
        }
        return this.SR.get(i11 - 1);
    }

    private Typeface sc(com.bytedance.adsdk.pFF.zY.zY zYVar) {
        Typeface typefaceQr;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Typeface, Typeface> scVar = this.II;
        if (scVar != null && (typefaceQr = scVar.qr()) != null) {
            return typefaceQr;
        }
        Typeface typefaceSc = this.dE.sc(zYVar);
        return typefaceSc != null ? typefaceSc : zYVar.We();
    }

    private String sc(String str, int i11) {
        int iCodePointAt = str.codePointAt(i11);
        int iCharCount = Character.charCount(iCodePointAt) + i11;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!zY(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j11 = iCodePointAt;
        if (this.Ql.indexOfKey(j11) >= 0) {
            return this.Ql.get(j11);
        }
        this.f26276qr.setLength(0);
        while (i11 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i11);
            this.f26276qr.appendCodePoint(iCodePointAt3);
            i11 += Character.charCount(iCodePointAt3);
        }
        String string = this.f26276qr.toString();
        this.Ql.put(j11, string);
        return string;
    }

    private List<com.bytedance.adsdk.pFF.sc.sc.We> sc(com.bytedance.adsdk.pFF.zY.We we2) {
        if (this.Tf.containsKey(we2)) {
            return this.Tf.get(we2);
        }
        List<dE> listSc = we2.sc();
        int size = listSc.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new com.bytedance.adsdk.pFF.sc.sc.We(this.dE, this, listSc.get(i11), this.Xc));
        }
        this.Tf.put(we2, arrayList);
        return arrayList;
    }

    private List<String> sc(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private List<sc> sc(String str, float f11, com.bytedance.adsdk.pFF.zY.zY zYVar, float f12, float f13, boolean z11) {
        float fMeasureText;
        float f14 = 0.0f;
        int i11 = 0;
        int i12 = 0;
        boolean z12 = false;
        float f15 = 0.0f;
        int i13 = 0;
        float f16 = 0.0f;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char cCharAt = str.charAt(i14);
            if (z11) {
                com.bytedance.adsdk.pFF.zY.We we2 = this.Xc.SR().get(com.bytedance.adsdk.pFF.zY.We.sc(cCharAt, zYVar.sc(), zYVar.zY()));
                if (we2 != null) {
                    fMeasureText = ((float) we2.pFF()) * f12 * com.bytedance.adsdk.pFF.TRI.TRI.sc();
                }
            } else {
                fMeasureText = this.WH.measureText(str.substring(i14, i14 + 1));
            }
            float f17 = fMeasureText + f13;
            if (cCharAt == ' ') {
                z12 = true;
                f16 = f17;
            } else if (z12) {
                i13 = i14;
                f15 = f17;
                z12 = false;
            } else {
                f15 += f17;
            }
            f14 += f17;
            if (f11 > 0.0f && f14 >= f11 && cCharAt != ' ') {
                i11++;
                sc scVarPFF = pFF(i11);
                if (i13 == i12) {
                    String strSubstring = str.substring(i12, i14);
                    String strTrim = strSubstring.trim();
                    scVarPFF.sc(strTrim, (f14 - f17) - ((strTrim.length() - strSubstring.length()) * f16));
                    i12 = i14;
                    i13 = i12;
                    f14 = f17;
                    f15 = f14;
                } else {
                    String strSubstring2 = str.substring(i12, i13 - 1);
                    String strTrim2 = strSubstring2.trim();
                    scVarPFF.sc(strTrim2, ((f14 - f15) - ((strSubstring2.length() - strTrim2.length()) * f16)) - f16);
                    f14 = f15;
                    i12 = i13;
                }
            }
        }
        if (f14 > 0.0f) {
            i11++;
            pFF(i11).sc(str.substring(i12), f14);
        }
        return this.SR.subList(0, i11);
    }

    private void sc(Canvas canvas, com.bytedance.adsdk.pFF.zY.pFF pff, int i11, float f11) {
        PointF pointF = pff.Tf;
        PointF pointF2 = pff.Ql;
        float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc();
        float f12 = (i11 * pff.TRI * fSc) + (pointF == null ? 0.0f : (pff.TRI * 0.6f * fSc) + pointF.y);
        float f13 = pointF == null ? 0.0f : pointF.x;
        float f14 = pointF2 != null ? pointF2.x : 0.0f;
        int i12 = AnonymousClass3.f26279sc[pff.We.ordinal()];
        if (i12 == 1) {
            canvas.translate(f13, f12);
        } else if (i12 == 2) {
            canvas.translate((f13 + f14) - f11, f12);
        } else {
            if (i12 != 3) {
                return;
            }
            canvas.translate((f13 + (f14 / 2.0f)) - (f11 / 2.0f), f12);
        }
    }

    private void sc(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void sc(com.bytedance.adsdk.pFF.zY.We we2, float f11, com.bytedance.adsdk.pFF.zY.pFF pff, Canvas canvas) {
        List<com.bytedance.adsdk.pFF.sc.sc.We> listSc = sc(we2);
        for (int i11 = 0; i11 < listSc.size(); i11++) {
            Path pathWe = listSc.get(i11).We();
            pathWe.computeBounds(this.Qj, false);
            this.Ol.reset();
            this.Ol.preTranslate(0.0f, (-pff.f26229qr) * com.bytedance.adsdk.pFF.TRI.TRI.sc());
            this.Ol.preScale(f11, f11);
            pathWe.transform(this.Ol);
            if (pff.UFX) {
                sc(pathWe, this.WH, canvas);
                sc(pathWe, this.UFX, canvas);
            } else {
                sc(pathWe, this.UFX, canvas);
                sc(pathWe, this.WH, canvas);
            }
        }
    }

    private void sc(com.bytedance.adsdk.pFF.zY.pFF pff, Matrix matrix) {
        com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar = this.Sfl;
        if (scVar != null) {
            this.WH.setColor(scVar.qr().intValue());
        } else {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar2 = this.wjp;
            if (scVar2 != null) {
                this.WH.setColor(scVar2.qr().intValue());
            } else {
                this.WH.setColor(pff.Qj);
            }
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar3 = this.Dl;
        if (scVar3 != null) {
            this.UFX.setColor(scVar3.qr().intValue());
        } else {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVar4 = this.YIK;
            if (scVar4 != null) {
                this.UFX.setColor(scVar4.qr().intValue());
            } else {
                this.UFX.setColor(pff.Ol);
            }
        }
        int iIntValue = ((this.We.sc() == null ? 100 : this.We.sc().qr().intValue()) * 255) / 100;
        this.WH.setAlpha(iIntValue);
        this.UFX.setAlpha(iIntValue);
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar5 = this.JPJ;
        if (scVar5 != null) {
            this.UFX.setStrokeWidth(scVar5.qr().floatValue());
            return;
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar6 = this.uEA;
        if (scVar6 != null) {
            this.UFX.setStrokeWidth(scVar6.qr().floatValue());
        } else {
            this.UFX.setStrokeWidth(pff.WH * com.bytedance.adsdk.pFF.TRI.TRI.sc());
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0053  */
    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0061  */
    /* JADX WARN: Code duplicated, block: B:23:0x007b A[LOOP:1: B:21:0x0075->B:23:0x007b, LOOP_END] */
    private void sc(com.bytedance.adsdk.pFF.zY.pFF pff, Matrix matrix, com.bytedance.adsdk.pFF.zY.zY zYVar, Canvas canvas) {
        float fFloatValue;
        float f11;
        int i11;
        int i12;
        PointF pointF;
        float f12;
        List<sc> listSc;
        int i13;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar = this.cvk;
        float fFloatValue2 = (scVar != null ? scVar.qr().floatValue() : pff.zY) / 100.0f;
        float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc(matrix);
        List<String> listSc2 = sc(pff.f26230sc);
        int size = listSc2.size();
        float f13 = pff.ExN / 10.0f;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar2 = this.WP;
        if (scVar2 == null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar3 = this.FI;
            if (scVar3 != null) {
                fFloatValue = scVar3.qr().floatValue();
            }
            f11 = f13;
            i11 = 0;
            i12 = -1;
            while (i11 < size) {
                String str = listSc2.get(i11);
                pointF = pff.Ql;
                if (pointF == null) {
                    f12 = 0.0f;
                } else {
                    f12 = pointF.x;
                }
                int i14 = i11;
                listSc = sc(str, f12, zYVar, fFloatValue2, f11, true);
                i13 = 0;
                while (i13 < listSc.size()) {
                    sc scVar4 = listSc.get(i13);
                    int i15 = i12 + 1;
                    canvas.save();
                    sc(canvas, pff, i15, scVar4.pFF);
                    sc(scVar4.f26280sc, pff, zYVar, canvas, fSc, fFloatValue2, f11);
                    canvas.restore();
                    i13++;
                    listSc = listSc;
                    i12 = i15;
                }
                i11 = i14 + 1;
            }
        }
        fFloatValue = scVar2.qr().floatValue();
        f13 += fFloatValue;
        f11 = f13;
        i11 = 0;
        i12 = -1;
        while (i11 < size) {
            String str2 = listSc2.get(i11);
            pointF = pff.Ql;
            if (pointF == null) {
                f12 = 0.0f;
            } else {
                f12 = pointF.x;
            }
            int i16 = i11;
            listSc = sc(str2, f12, zYVar, fFloatValue2, f11, true);
            i13 = 0;
            while (i13 < listSc.size()) {
                sc scVar5 = listSc.get(i13);
                int i17 = i12 + 1;
                canvas.save();
                sc(canvas, pff, i17, scVar5.pFF);
                sc(scVar5.f26280sc, pff, zYVar, canvas, fSc, fFloatValue2, f11);
                canvas.restore();
                i13++;
                listSc = listSc;
                i12 = i17;
            }
            i11 = i16 + 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0097  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bf A[LOOP:1: B:26:0x00b9->B:28:0x00bf, LOOP_END] */
    private void sc(com.bytedance.adsdk.pFF.zY.pFF pff, com.bytedance.adsdk.pFF.zY.zY zYVar, Canvas canvas) {
        float fFloatValue;
        float fSc;
        List<String> listSc;
        int size;
        int i11;
        int i12;
        PointF pointF;
        float f11;
        List<sc> listSc2;
        int i13;
        Typeface typefaceSc = sc(zYVar);
        if (typefaceSc == null) {
            return;
        }
        String strPFF = pff.f26230sc;
        YIK yikFI = this.dE.FI();
        if (yikFI != null) {
            strPFF = yikFI.pFF(Ol(), strPFF);
        }
        this.WH.setTypeface(typefaceSc);
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar = this.cvk;
        float fFloatValue2 = scVar != null ? scVar.qr().floatValue() : pff.zY;
        this.WH.setTextSize(com.bytedance.adsdk.pFF.TRI.TRI.sc() * fFloatValue2);
        this.UFX.setTypeface(this.WH.getTypeface());
        this.UFX.setTextSize(this.WH.getTextSize());
        float f12 = pff.ExN / 10.0f;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar2 = this.WP;
        if (scVar2 == null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar3 = this.FI;
            if (scVar3 != null) {
                fFloatValue = scVar3.qr().floatValue();
            }
            fSc = ((f12 * com.bytedance.adsdk.pFF.TRI.TRI.sc()) * fFloatValue2) / 100.0f;
            listSc = sc(strPFF);
            size = listSc.size();
            i11 = 0;
            i12 = -1;
            while (i11 < size) {
                String str = listSc.get(i11);
                pointF = pff.Ql;
                if (pointF == null) {
                    f11 = 0.0f;
                } else {
                    f11 = pointF.x;
                }
                int i14 = i11;
                listSc2 = sc(str, f11, zYVar, 0.0f, fSc, false);
                for (i13 = 0; i13 < listSc2.size(); i13++) {
                    sc scVar4 = listSc2.get(i13);
                    i12++;
                    canvas.save();
                    sc(canvas, pff, i12, scVar4.pFF);
                    sc(scVar4.f26280sc, pff, canvas, fSc);
                    canvas.restore();
                }
                i11 = i14 + 1;
            }
        }
        fFloatValue = scVar2.qr().floatValue();
        f12 += fFloatValue;
        fSc = ((f12 * com.bytedance.adsdk.pFF.TRI.TRI.sc()) * fFloatValue2) / 100.0f;
        listSc = sc(strPFF);
        size = listSc.size();
        i11 = 0;
        i12 = -1;
        while (i11 < size) {
            String str2 = listSc.get(i11);
            pointF = pff.Ql;
            if (pointF == null) {
                f11 = 0.0f;
            } else {
                f11 = pointF.x;
            }
            int i15 = i11;
            listSc2 = sc(str2, f11, zYVar, 0.0f, fSc, false);
            while (i13 < listSc2.size()) {
                sc scVar5 = listSc2.get(i13);
                i12++;
                canvas.save();
                sc(canvas, pff, i12, scVar5.pFF);
                sc(scVar5.f26280sc, pff, canvas, fSc);
                canvas.restore();
            }
            i11 = i15 + 1;
        }
    }

    private void sc(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void sc(String str, com.bytedance.adsdk.pFF.zY.pFF pff, Canvas canvas) {
        if (pff.UFX) {
            sc(str, this.WH, canvas);
            sc(str, this.UFX, canvas);
        } else {
            sc(str, this.UFX, canvas);
            sc(str, this.WH, canvas);
        }
    }

    private void sc(String str, com.bytedance.adsdk.pFF.zY.pFF pff, Canvas canvas, float f11) {
        int length = 0;
        while (length < str.length()) {
            String strSc = sc(str, length);
            length += strSc.length();
            sc(strSc, pff, canvas);
            canvas.translate(this.WH.measureText(strSc) + f11, 0.0f);
        }
    }

    private void sc(String str, com.bytedance.adsdk.pFF.zY.pFF pff, com.bytedance.adsdk.pFF.zY.zY zYVar, Canvas canvas, float f11, float f12, float f13) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            com.bytedance.adsdk.pFF.zY.We we2 = this.Xc.SR().get(com.bytedance.adsdk.pFF.zY.We.sc(str.charAt(i11), zYVar.sc(), zYVar.zY()));
            if (we2 != null) {
                sc(we2, f12, pff, canvas);
                canvas.translate((((float) we2.pFF()) * f12 * com.bytedance.adsdk.pFF.TRI.TRI.sc()) + f13, 0.0f);
            }
        }
    }

    private boolean zY(int i11) {
        return Character.getType(i11) == 16 || Character.getType(i11) == 27 || Character.getType(i11) == 6 || Character.getType(i11) == 28 || Character.getType(i11) == 8 || Character.getType(i11) == 19;
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        super.pFF(canvas, matrix, i11);
        com.bytedance.adsdk.pFF.zY.pFF pffQr = this.BT.qr();
        com.bytedance.adsdk.pFF.zY.zY zYVar = this.Xc.BT().get(pffQr.pFF);
        if (zYVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        sc(pffQr, matrix);
        if (this.dE.WP()) {
            sc(pffQr, matrix, zYVar, canvas);
        } else {
            sc(pffQr, zYVar, canvas);
        }
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc, com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        super.sc(rectF, matrix, z11);
        rectF.set(0.0f, 0.0f, this.Xc.We().width(), this.Xc.We().height());
    }
}
