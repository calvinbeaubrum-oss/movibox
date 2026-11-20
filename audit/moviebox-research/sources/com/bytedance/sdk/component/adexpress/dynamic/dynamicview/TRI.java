package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.transsion.gslb.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends ExN {
    private static String YIK = "";
    private volatile boolean Dl;
    protected com.bytedance.sdk.component.adexpress.dynamic.zY.Ol Sfl;
    private Runnable pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Runnable f26801sc;
    private ImageView uEA;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements com.bytedance.sdk.component.ExN.dE<Bitmap> {
        private final WeakReference<ExN> pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<View> f26809sc;

        public pFF(View view, ExN exN) {
            this.f26809sc = new WeakReference<>(view);
            this.pFF = new WeakReference<>(exN);
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, @Nullable Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
            Bitmap bitmapPFF;
            ExN exN;
            View view = this.f26809sc.get();
            if (view == null || (bitmapPFF = ufx.pFF()) == null || ufx.zY() == null || (exN = this.pFF.get()) == null) {
                return;
            }
            view.setBackground(exN.sc(bitmapPFF));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.ExN.dE<Bitmap> {
        private final WeakReference<DynamicRootView> pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<View> f26810sc;
        private final com.bytedance.sdk.component.adexpress.dynamic.We.Qj zY;

        public sc(View view, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
            this.f26810sc = new WeakReference<>(view);
            this.pFF = new WeakReference<>(dynamicRootView);
            this.zY = qj2;
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, @Nullable Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
            View view = this.f26810sc.get();
            if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
                DynamicRootView dynamicRootView = this.pFF.get();
                if (dynamicRootView == null) {
                    return;
                }
                if ("open_ad".equals(dynamicRootView.getRenderRequest().We()) || "splash_ad".equals(dynamicRootView.getRenderRequest().We())) {
                    view.setBackground(new BitmapDrawable(ufx.pFF()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(ufx.pFF()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(ufx.pFF()));
            com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = this.zY;
            if (qj2 == null || qj2.WH() == null || 6 != this.zY.WH().sc() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY implements com.bytedance.sdk.component.ExN.Qj {
        private final int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<Context> f26811sc;

        public zY(Context context, int i11) {
            this.f26811sc = new WeakReference<>(context);
            this.pFF = i11;
        }

        @Override // com.bytedance.sdk.component.ExN.Qj
        public Bitmap sc(Bitmap bitmap) {
            Context context = this.f26811sc.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.We.sc.sc(context, bitmap, this.pFF);
            }
            return null;
        }
    }

    public TRI(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.Dl = true;
        setTag(Integer.valueOf(getClickArea()));
        String strPFF = qj2.WH().pFF();
        if ("logo-union".equals(strPFF)) {
            dynamicRootView.setLogoUnionHeight(this.Qj - ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, this.Tf.pFF() + this.Tf.sc())));
        } else if ("scoreCountWithIcon".equals(strPFF)) {
            dynamicRootView.setScoreCountWithIcon(this.Qj - ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, this.Tf.pFF() + this.Tf.sc())));
        }
    }

    private static String getBuildModel() {
        try {
            YIK = com.bytedance.sdk.component.utils.Dl.sc();
        } catch (Throwable unused) {
            YIK = Build.MODEL;
        }
        if (TextUtils.isEmpty(YIK)) {
            YIK = Build.MODEL;
        }
        return YIK;
    }

    private String pFF(String str) {
        try {
            Map<String, String> mapUFX = this.SR.getRenderRequest().UFX();
            if (mapUFX != null && mapUFX.size() > 0) {
                return mapUFX.get(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private String sc(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return sc(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return sc((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void sc() {
        if (this.Dl) {
            int iYL = this.Tf.yL();
            int iYhz = this.Tf.Yhz();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI.6
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = TRI.this.SR;
                    if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                        TRI tri = TRI.this;
                        TRI tri2 = TRI.this;
                        tri.Sfl = new com.bytedance.sdk.component.adexpress.dynamic.zY.Ol(tri2.UFX, tri2, tri2.Tf);
                    } else {
                        com.bytedance.sdk.component.adexpress.pFF.Ql renderRequest = TRI.this.SR.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.We.WH wh2 = new com.bytedance.sdk.component.adexpress.dynamic.We.WH();
                        wh2.sc(renderRequest.BT());
                        wh2.pFF(renderRequest.dE());
                        wh2.zY(renderRequest.Xc());
                        wh2.sc(renderRequest.wjp());
                        wh2.pFF(renderRequest.Sfl());
                        wh2.zY(renderRequest.YIK());
                        wh2.We(renderRequest.Dl());
                        wh2.ExN(renderRequest.uEA());
                        TRI tri3 = TRI.this;
                        TRI tri4 = TRI.this;
                        tri3.Sfl = new com.bytedance.sdk.component.adexpress.dynamic.zY.Ol(tri4.UFX, tri4, tri4.Tf, wh2, renderRequest);
                    }
                    TRI tri5 = TRI.this;
                    tri5.pFF(tri5.Sfl);
                    if (TRI.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) TRI.this.getParent()).setClipChildren(false);
                    }
                    TRI.this.setClipChildren(false);
                    TRI.this.Sfl.setTag(2);
                    TRI tri6 = TRI.this;
                    tri6.sc((ViewGroup) tri6);
                    TRI tri7 = TRI.this;
                    tri7.addView(tri7.Sfl, new FrameLayout.LayoutParams(-1, -1));
                    TRI.this.Sfl.zY();
                }
            };
            this.f26801sc = runnable;
            postDelayed(runnable, ((long) iYL) * 1000);
            if (this.Tf.qfG() || iYhz >= Integer.MAX_VALUE || iYL >= iYhz) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI.7
                @Override // java.lang.Runnable
                public void run() {
                    TRI tri = TRI.this;
                    if (tri.Sfl != null) {
                        tri.Dl = false;
                        TRI.this.Sfl.We();
                        TRI.this.Sfl.setVisibility(4);
                        TRI tri2 = TRI.this;
                        tri2.removeView(tri2.Sfl);
                    }
                }
            };
            this.pFF = runnable2;
            postDelayed(runnable2, ((long) iYhz) * 1000);
        }
    }

    private void sc(double d11, final View view) {
        if (d11 > 0.0d) {
            com.bytedance.sdk.component.utils.qr.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI.5
                @Override // java.lang.Runnable
                public void run() {
                    if (TRI.this.Ql.WH().ExN().GOt() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    TRI.this.setVisibility(0);
                }
            }, (long) (d11 * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            if (viewGroup.getChildAt(i11) instanceof com.bytedance.sdk.component.adexpress.dynamic.zY.Ol) {
                viewGroup.removeViewAt(i11);
            }
        }
    }

    private static void sc(com.bytedance.sdk.component.ExN.WH wh2) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            wh2.sc(Bitmap.Config.ARGB_8888);
        }
    }

    private void sc(com.bytedance.sdk.component.ExN.WH wh2, final View view) {
        wh2.sc(new com.bytedance.sdk.component.ExN.dE<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI.3
            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(int i11, String str, @Nullable Throwable th2) {
            }

            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
                DynamicRootView dynamicRootView = TRI.this.SR;
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().We()) && !"splash_ad".equals(TRI.this.SR.getRenderRequest().We())) {
                    view.setBackground(new BitmapDrawable(ufx.pFF()));
                } else {
                    if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
                        view.setBackground(new BitmapDrawable(ufx.pFF()));
                        return;
                    }
                    view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sc(ufx.pFF(), ((wjp) TRI.this.SR.getChildAt(0)).f26829sc));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable zY(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                if (jSONArray.getString(i11).startsWith(Utils.SEPARATOR)) {
                    arrayList.add(jSONArray.getString(i11));
                } else if (jSONArray.getString(i11).endsWith("deg")) {
                    string = jSONArray.getString(i11);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                iArr[i12] = com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(((String) arrayList.get(i12)).substring(0, 7));
            }
            GradientDrawable gradientDrawableSc = sc(sc(string), iArr);
            gradientDrawableSc.setShape(0);
            gradientDrawableSc.setCornerRadius(com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.BT()));
            return gradientDrawableSc;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean Ol() {
        int iBT;
        int iDE;
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject jSONObjectOptJSONObject;
        View view = this.BT;
        final View view2 = view;
        if (view == null) {
            view2 = this;
        }
        setContentDescription(this.Ql.sc(this.Tf.II()));
        String strGsl = this.Tf.gsl();
        String strFI = null;
        String strSc = (TextUtils.isEmpty(strGsl) || (dynamicRootView = this.SR) == null || dynamicRootView.getRenderRequest() == null || this.SR.getRenderRequest().zY() == null || (jSONObjectOptJSONObject = this.SR.getRenderRequest().zY().optJSONObject("creative")) == null) ? null : sc(jSONObjectOptJSONObject.opt(strGsl));
        if (TextUtils.isEmpty(strSc)) {
            strSc = this.Tf.Dl();
        }
        com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
        if (zYVarZY != null) {
            iBT = zYVarZY.BT();
            iDE = zYVarZY.dE();
        } else {
            iBT = 0;
            iDE = 0;
        }
        if (this.Tf.YIK()) {
            int iSfl = this.Tf.Sfl();
            String str = this.Tf.pFF;
            com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().ExN().sc(str).sc(this.f26791qr).pFF(this.Qj).We(iBT).ExN(iDE).sc(pFF(str)).zY(2).sc(new zY(this.UFX, iSfl)).sc(new pFF(view2, this));
        } else if (!TextUtils.isEmpty(strSc)) {
            if (!strSc.startsWith("http:") && !strSc.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.SR;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    strFI = this.SR.getRenderRequest().FI();
                }
                strSc = com.bytedance.sdk.component.adexpress.dynamic.ExN.Ol.pFF(strSc, strFI);
            }
            com.bytedance.sdk.component.ExN.WH whZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().ExN().sc(strSc).sc(this.f26791qr).pFF(this.Qj).We(iBT).ExN(iDE).sc(pFF(strSc)).zY(2);
            sc(whZY);
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                whZY.sc(new sc(view2, this.SR, this.Ql));
            } else if ((view2 instanceof FrameLayout) && TextUtils.equals(this.Ql.WH().pFF(), "vessel")) {
                if (com.bytedance.sdk.component.adexpress.We.WH.pFF(strSc)) {
                    this.uEA = new com.bytedance.sdk.component.adexpress.TRI.Ql(this.UFX);
                } else {
                    this.uEA = new ImageView(this.UFX);
                }
                ((FrameLayout) view2).addView(this.uEA, new FrameLayout.LayoutParams(-1, -1));
                whZY.zY(3).sc(new com.bytedance.sdk.component.ExN.dE() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI.1
                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(int i11, String str2, Throwable th2) {
                    }

                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(com.bytedance.sdk.component.ExN.UFX ufx) {
                        Object objPFF = ufx.pFF();
                        if (objPFF instanceof byte[]) {
                            TRI tri = TRI.this;
                            com.bytedance.sdk.component.adexpress.We.TRI.pFF(TRI.this.uEA, (byte[]) objPFF, tri.f26791qr, tri.Qj);
                        }
                    }
                });
            } else {
                sc(whZY, view2);
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view2.setBackground(backgroundDrawable);
        }
        if (this.Tf.HJN() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (TRI.this.Tf.cJ() > 0) {
                            TRI tri = TRI.this;
                            Drawable drawableZY = tri.zY(tri.SR.getBgMaterialCenterCalcColor().get(Integer.valueOf(TRI.this.Tf.cJ())));
                            if (drawableZY == null) {
                                TRI tri2 = TRI.this;
                                drawableZY = tri2.sc(true, tri2.SR.getBgMaterialCenterCalcColor().get(Integer.valueOf(TRI.this.Tf.cJ())));
                            }
                            if (drawableZY != null) {
                                view2.setBackground(drawableZY);
                                return;
                            }
                            View view3 = view2;
                            TRI tri3 = TRI.this;
                            view3.setBackground(tri3.sc(true, tri3.SR.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.Tf.HJN() * 1000.0d));
        }
        View view3 = this.BT;
        if (view3 != null) {
            view3.setPadding((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.zY()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.pFF()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.We()), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.sc()));
        }
        if (this.dE || this.Tf.SR() > 0.0d) {
            setShouldInvisible(true);
            view2.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.BT;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        double dYIK = this.Ql.WH().ExN().YIK();
        if (dYIK < 90.0d && dYIK > 0.0d) {
            com.bytedance.sdk.component.utils.qr.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI.4
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.setVisibility(8);
                }
            }, (long) (dYIK * 1000.0d));
        }
        sc(this.Ql.WH().ExN().Sfl(), view2);
        if (!TextUtils.isEmpty(this.Tf.pc())) {
            sc();
        }
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.f26801sc);
            removeCallbacks(this.pFF);
        } catch (Exception unused) {
        }
    }
}
