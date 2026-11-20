package com.bytedance.adsdk.pFF.zY.zY;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.pFF.YIK;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends We {
    private final LinearLayout.LayoutParams Ol;
    private LinearLayout Qj;
    private String Tf;
    private final List<TextView> UFX;
    private final List<String> WH;

    public zY(com.bytedance.adsdk.pFF.Ol ol2, ExN exN, Context context) {
        List<com.bytedance.adsdk.pFF.WH.sc> listZY;
        super(ol2, exN);
        this.Ol = new LinearLayout.LayoutParams(-2, -2);
        this.WH = new ArrayList();
        this.UFX = new ArrayList();
        com.bytedance.adsdk.pFF.WH wh2 = ((We) this).f26282qr;
        if (wh2 == null || (listZY = wh2.zY()) == null || listZY.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.Qj = linearLayout;
        int i11 = 0;
        linearLayout.setOrientation(0);
        pFF(listZY.get(0).f26161qr);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.Qj.addView(linearLayout2);
        List<String> listTf = Tf();
        while (i11 < listZY.size()) {
            com.bytedance.adsdk.pFF.WH.sc scVar = listZY.get(i11);
            TextView textView = new TextView(context);
            sc(textView, scVar, (listTf == null || i11 >= listTf.size()) ? "" : listTf.get(i11));
            int i12 = scVar.TRI;
            if (i12 != 0) {
                this.Ol.bottomMargin = (int) (i12 * com.bytedance.adsdk.pFF.TRI.TRI.sc());
                linearLayout2.addView(textView, this.Ol);
            } else {
                linearLayout2.addView(textView);
            }
            i11++;
        }
        float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc();
        sc(this.Qj, (int) (((We) this).f26282qr.sc() * fSc), (int) (((We) this).f26282qr.pFF() * fSc));
    }

    private List<String> Tf() {
        com.bytedance.adsdk.pFF.Ol ol2;
        YIK yikFI;
        List<com.bytedance.adsdk.pFF.WH.sc> listZY;
        if (((We) this).f26282qr == null || (ol2 = this.pFF) == null || (yikFI = ol2.FI()) == null) {
            return null;
        }
        String strWe = ((We) this).f26282qr.We();
        if ((!TextUtils.isEmpty(strWe) || !TextUtils.isEmpty(this.Tf)) && (listZY = ((We) this).f26282qr.zY()) != null) {
            String strSc = this.Tf;
            if (TextUtils.isEmpty(strSc)) {
                strSc = yikFI.sc(strWe);
            }
            if (!TextUtils.isEmpty(strSc)) {
                int length = strSc.length();
                this.WH.clear();
                for (int i11 = 0; i11 < listZY.size(); i11++) {
                    com.bytedance.adsdk.pFF.WH.sc scVar = listZY.get(i11);
                    int iMax = scVar.f26162sc;
                    int iMax2 = scVar.pFF;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.WH.add("");
                    } else {
                        if (listZY.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.WH.add(strSc.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.WH;
            }
        }
        return null;
    }

    private void pFF(String str) {
        if (TextUtils.isEmpty(str)) {
            this.Qj.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals(TtmlNode.LEFT)) {
            this.Qj.setGravity(3);
        } else if (str.equals(TtmlNode.RIGHT)) {
            this.Qj.setGravity(5);
        } else {
            this.Qj.setGravity(17);
        }
    }

    private static void sc(View view, int i11, int i12) {
        view.layout(0, 0, i11, i12);
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private void sc(TextView textView, com.bytedance.adsdk.pFF.WH.sc scVar, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(scVar.zY)) {
            textView.setTextColor(Color.parseColor(scVar.zY));
        }
        if (!TextUtils.isEmpty(scVar.We)) {
            textView.setBackgroundColor(Color.parseColor(scVar.We));
        }
        textView.setGravity(17);
        textView.setTextSize(scVar.ExN);
    }

    private void zY(float f11) {
        List<com.bytedance.adsdk.pFF.WH.sc> listZY;
        com.bytedance.adsdk.pFF.WH wh2 = ((We) this).f26282qr;
        if (wh2 == null || (listZY = wh2.zY()) == null || listZY.size() <= 0) {
            return;
        }
        this.Qj.setOrientation(0);
        this.Qj.setGravity(17);
        if (this.Qj.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.Qj.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.Qj.removeAllViews();
        if (linearLayout.getChildCount() != listZY.size()) {
            return;
        }
        List<String> listTf = Tf();
        this.UFX.clear();
        int i11 = 0;
        while (i11 < listZY.size()) {
            com.bytedance.adsdk.pFF.WH.sc scVar = listZY.get(i11);
            TextView textView = (TextView) linearLayout.getChildAt(i11);
            this.UFX.add(textView);
            sc(textView, scVar, (listTf == null || i11 >= listTf.size()) ? "" : listTf.get(i11));
            i11++;
        }
        linearLayout.removeAllViews();
        for (int i12 = 0; i12 < listZY.size(); i12++) {
            com.bytedance.adsdk.pFF.WH.sc scVar2 = listZY.get(i12);
            TextView textView2 = this.UFX.get(i12);
            textView2.setAlpha(f11);
            linearLayout.setAlpha(f11);
            int i13 = scVar2.TRI;
            if (i13 != 0) {
                this.Ol.bottomMargin = (int) (i13 * com.bytedance.adsdk.pFF.TRI.TRI.sc());
                linearLayout.addView(textView2, this.Ol);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.Qj.setAlpha(f11);
        this.Qj.addView(linearLayout);
        float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc();
        sc(this.Qj, (int) (((We) this).f26282qr.sc() * fSc), (int) (((We) this).f26282qr.pFF() * fSc));
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.We, com.bytedance.adsdk.pFF.zY.zY.sc
    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        if (this.Qj == null) {
            super.pFF(canvas, matrix, i11);
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        sc(i11);
        zY(TRI());
        this.Qj.draw(canvas);
        canvas.restore();
    }

    public void sc(String str) {
        this.Tf = str;
    }
}
