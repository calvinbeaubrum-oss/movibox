package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.core.widget.dE;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.hisavana.common.tracking.TrackingKey;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends com.bytedance.sdk.openadsdk.core.ExN.ExN {
    private boolean ExN;
    private com.bytedance.sdk.openadsdk.component.reward.sc.sc TRI;
    private TextView We;
    private TextView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private dE f27971sc;
    private Xc zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.ExN.dE<Bitmap> {
        private final WeakReference<ImageView> We;
        private final String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final Sfl f27976sc;
        private final String zY;

        public sc(ImageView imageView, Sfl sfl, String str, String str2) {
            this.We = new WeakReference<>(imageView);
            this.f27976sc = sfl;
            this.pFF = str;
            this.zY = str2;
        }

        private void sc(final int i11, final String str, final String str2) {
            com.bytedance.sdk.openadsdk.We.zY.sc(new com.bytedance.sdk.component.Qj.Qj("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.view.zY.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(TrackingKey.ERROR_CODE, i11);
                        jSONObject.put(TrackingKey.DESCRIPTION, i11 + ":" + str);
                        jSONObject.put("url", str2);
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.We.zY.pFF(sc.this.f27976sc, sc.this.zY, "load_vast_icon_fail", jSONObject);
                }
            });
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, @Nullable Throwable th2) {
            sc(i11, str, this.pFF);
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
            if (ufx == null || ufx.pFF() == null) {
                return;
            }
            ImageView imageView = this.We.get();
            if (imageView != null) {
                imageView.setImageBitmap(ufx.pFF());
            }
            com.bytedance.sdk.openadsdk.We.zY.pFF(this.f27976sc, this.zY, "load_vast_icon_success", (JSONObject) null);
        }
    }

    public zY(@NonNull Context context) {
        super(context);
        setOrientation(1);
        setVisibility(8);
        setBackgroundColor(-1);
    }

    private void ExN() {
        Context context = getContext();
        setPadding(kX.zY(context, 16.0f), kX.zY(context, 16.0f), kX.zY(context, 16.0f), kX.zY(context, 24.0f));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(0);
        exN.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = kX.zY(context, 12.0f);
        addView(exN, layoutParams);
        Xc xc2 = new Xc(context);
        this.zY = xc2;
        xc2.setBackgroundColor(0);
        this.zY.setId(SR.pFF);
        exN.addView(this.zY, new LinearLayout.LayoutParams(kX.zY(context, 48.0f), kX.zY(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = kX.zY(context, 12.0f);
        exN.addView(exN2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.We = qj2;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj2.setEllipsize(truncateAt);
        this.We.setGravity(16);
        this.We.setSingleLine(true);
        this.We.setTextSize(2, 17.0f);
        this.We.setId(SR.zY);
        this.We.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        exN2.addView(this.We, new LinearLayout.LayoutParams(-1, -2));
        dE dEVar = new dE(context);
        this.f27971sc = dEVar;
        dEVar.setId(SR.ExN);
        exN2.addView(this.f27971sc, new LinearLayout.LayoutParams(-2, kX.zY(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.pFF = qj3;
        qj3.setGravity(17);
        this.pFF.setEllipsize(truncateAt);
        this.pFF.setSingleLine(true);
        this.pFF.setTextColor(-1);
        this.pFF.setTextSize(2, 16.0f);
        this.pFF.setId(520093705);
        this.pFF.setBackground(sc(context));
        this.pFF.setText(this.TRI.pFF.NQ());
        addView(this.pFF, new LinearLayout.LayoutParams(-1, kX.zY(context, 36.0f)));
    }

    private void We() {
        setOrientation(0);
        setGravity(16);
        Context context = getContext();
        setPadding(kX.zY(context, 16.0f), kX.zY(context, 12.0f), kX.zY(context, 16.0f), kX.zY(context, 12.0f));
        Xc xc2 = new Xc(context);
        this.zY = xc2;
        xc2.setBackgroundColor(0);
        this.zY.setId(SR.pFF);
        addView(this.zY, new LinearLayout.LayoutParams(kX.zY(context, 48.0f), kX.zY(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = kX.zY(context, 12.0f);
        layoutParams.weight = 1.0f;
        addView(exN, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.We = qj2;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj2.setEllipsize(truncateAt);
        this.We.setGravity(16);
        this.We.setSingleLine(true);
        this.We.setTextSize(2, 17.0f);
        this.We.setId(SR.zY);
        this.We.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        exN.addView(this.We, new LinearLayout.LayoutParams(-1, -2));
        dE dEVar = new dE(context);
        this.f27971sc = dEVar;
        dEVar.setId(SR.ExN);
        exN.addView(this.f27971sc, new LinearLayout.LayoutParams(-2, kX.zY(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.pFF = qj3;
        qj3.setGravity(17);
        this.pFF.setEllipsize(truncateAt);
        this.pFF.setSingleLine(true);
        this.pFF.setTextColor(-1);
        this.pFF.setTextSize(2, 16.0f);
        this.pFF.setId(520093705);
        this.pFF.setBackground(sc(context));
        this.pFF.setText(this.TRI.pFF.NQ());
        addView(this.pFF, new LinearLayout.LayoutParams(kX.zY(context, 164.0f), kX.zY(context, 36.0f)));
    }

    private String getCnOrEnBtnText() {
        return this.TRI.pFF.QLv() != 4 ? "View" : "Install";
    }

    private static Drawable sc(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1A73E8"));
        gradientDrawable.setCornerRadius(kX.zY(context, 18.0f));
        return gradientDrawable;
    }

    private void zY() {
        this.ExN = true;
        if (this.TRI.OKY == 1) {
            ExN();
        } else {
            We();
        }
        if (this.pFF == null) {
            this.pFF = (TextView) this.TRI.JoC.findViewById(520093705);
        }
        Sfl sfl = this.TRI.pFF;
        TextView textView = this.pFF;
        if (textView != null) {
            textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.zY.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    int width = ((ViewGroup) zY.this.pFF.getParent()).getWidth();
                    if (width > 0) {
                        zY.this.pFF.setMaxWidth((int) (width * 0.45f));
                    }
                }
            });
            if (!sfl.ymG()) {
                this.pFF.setText(sfl.Gb() == 3 ? getButtonTextForNewStyleBar() : sfl.NQ());
            } else if (sfl.GOt() != null && TextUtils.isEmpty(sfl.GOt().TRI())) {
                kX.sc((View) this.pFF, 8);
            }
        }
        if (this.zY != null && sfl.qfG() != null && !TextUtils.isEmpty(sfl.qfG().sc())) {
            String strSc = sfl.qfG().sc();
            if (sfl.ymG()) {
                com.bytedance.sdk.openadsdk.Ol.We.sc(sfl.qfG()).zY(2).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, sfl.qfG().sc(), new sc(this.zY, sfl, strSc, this.TRI.ExN)));
                if (sfl.GOt() != null && sfl.GOt().pFF() != null) {
                    sfl.GOt().pFF().pFF(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(sfl.qfG(), this.zY, sfl);
            }
        }
        TextView textView2 = this.We;
        if (textView2 != null) {
            textView2.setText(sfl.YdT());
        }
        dE dEVar = this.f27971sc;
        if (dEVar != null) {
            kX.sc((TextView) null, dEVar, sfl);
        }
        if (this.TRI.OKY == 2 && sfl.Gb() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.pFF.getLayoutParams();
            layoutParams.height = kX.zY(this.TRI.f27911pc, 55.0f);
            layoutParams.topMargin = kX.zY(this.TRI.f27911pc, 20.0f);
            this.pFF.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams2.bottomMargin = kX.zY(this.TRI.f27911pc, 12.0f);
            setLayoutParams(layoutParams2);
        }
        pFF();
    }

    public String getButtonTextForNewStyleBar() {
        boolean zEquals;
        String strNQ;
        String strQr = cJ.qr(this.TRI.f27911pc);
        if (strQr == null) {
            strQr = "";
        }
        try {
            zEquals = strQr.equals(Locale.ENGLISH.getLanguage());
        } catch (Throwable unused) {
            zEquals = false;
        }
        if (TextUtils.isEmpty(this.TRI.pFF.NQ())) {
            strNQ = this.TRI.pFF.QLv() != 4 ? "View" : "Install";
        } else {
            strNQ = this.TRI.pFF.NQ();
            if (strNQ == null || !cJ.TRI(strNQ) || strNQ.length() <= 2) {
                if (strNQ != null && !cJ.TRI(strNQ) && strNQ.length() > 7 && zEquals) {
                    strNQ = getCnOrEnBtnText();
                }
            } else if (zEquals) {
                strNQ = getCnOrEnBtnText();
            }
        }
        if (zEquals && !cJ.TRI(strNQ)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.pFF.getLayoutParams();
            layoutParams.bottomMargin = kX.zY(this.TRI.f27911pc, 4.0f);
            this.pFF.setLayoutParams(layoutParams);
        }
        return strNQ;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void pFF() {
        com.bytedance.sdk.openadsdk.core.pFF.ExN ExN = this.TRI.McK.ExN();
        final com.bytedance.sdk.openadsdk.core.pFF.pFF pffWe = this.TRI.McK.We();
        final Sfl sfl = this.TRI.pFF;
        if (sfl.cD() == null) {
            return;
        }
        if (sfl.Gb() != 5 && this.pFF != null) {
            if (sfl.cD().ExN) {
                this.pFF.setOnClickListener(ExN);
                this.pFF.setOnTouchListener(ExN);
            } else {
                this.pFF.setOnClickListener(pffWe);
            }
        }
        if (sfl.Gb() != 5) {
            this.pFF.setOnClickListener(ExN);
            this.We.setOnClickListener(ExN);
            this.f27971sc.setOnClickListener(ExN);
            this.zY.setOnClickListener(ExN);
            return;
        }
        String str = "VAST_ICON";
        if (!sfl.cD().ExN) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.zY.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    View.OnClickListener onClickListener2 = pffWe;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                    }
                    if (view == null || !"VAST_ICON".equals(view.getTag(570425345))) {
                        if (sfl.GOt() != null) {
                            sfl.GOt().sc().qr(zY.this.TRI.JPJ.qr());
                        }
                    } else {
                        if (sfl.GOt() == null || sfl.GOt().pFF() == null) {
                            return;
                        }
                        sfl.GOt().pFF().sc(zY.this.TRI.JPJ.qr());
                    }
                }
            };
            TextView textView = this.pFF;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
            TextView textView2 = this.We;
            if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
                this.We.setOnClickListener(onClickListener);
            }
            Xc xc2 = this.zY;
            if (xc2 != null) {
                xc2.setTag(570425345, "VAST_ICON");
                this.zY.setOnClickListener(pffWe);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.pFF.qr qrVar = new com.bytedance.sdk.openadsdk.core.pFF.qr("VAST_ACTION_BUTTON", sfl.GOt(), ExN) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.zY.2
        };
        com.bytedance.sdk.openadsdk.core.pFF.qr qrVar2 = new com.bytedance.sdk.openadsdk.core.pFF.qr(str, sfl.GOt(), ExN) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.zY.3
        };
        TextView textView3 = this.pFF;
        if (textView3 != null) {
            textView3.setOnClickListener(qrVar);
            this.pFF.setOnTouchListener(qrVar);
        }
        Xc xc3 = this.zY;
        if (xc3 != null) {
            xc3.setOnClickListener(qrVar2);
            this.zY.setOnTouchListener(qrVar2);
        }
        TextView textView4 = this.We;
        if (textView4 == null || TextUtils.isEmpty(textView4.getText())) {
            return;
        }
        this.We.setOnClickListener(qrVar);
        this.We.setOnTouchListener(qrVar);
    }

    public void sc() {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    public void sc(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.TRI = scVar;
        if (scVar.pFF.Gb() == 1) {
            zY();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 != 0 || this.ExN) {
            return;
        }
        zY();
    }
}
