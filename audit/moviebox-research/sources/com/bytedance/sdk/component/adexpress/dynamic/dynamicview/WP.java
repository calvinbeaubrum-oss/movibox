package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WP extends TRI {
    public WP(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.Qj += 6;
        if (this.Tf.JoC()) {
            com.bytedance.sdk.component.adexpress.TRI.sc scVar = new com.bytedance.sdk.component.adexpress.TRI.sc(context, this.Tf.qr(), this.Tf.ExN(), 1, this.Tf.Qj());
            this.BT = scVar;
            scVar.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.BT = textView;
            textView.setIncludeFontPadding(false);
        }
        this.BT.setTag(Integer.valueOf(getClickArea()));
        addView(this.BT, getWidgetLayoutParams());
    }

    private void UFX() {
        if (this.BT instanceof com.bytedance.sdk.component.adexpress.TRI.sc) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    arrayList.add(jSONArray.optString(i11));
                }
            } catch (JSONException unused) {
                arrayList.add(text);
            }
            ((com.bytedance.sdk.component.adexpress.TRI.sc) this.BT).setMaxLines(1);
            ((com.bytedance.sdk.component.adexpress.TRI.sc) this.BT).setTextColor(this.Tf.qr());
            ((com.bytedance.sdk.component.adexpress.TRI.sc) this.BT).setTextSize(this.Tf.ExN());
            ((com.bytedance.sdk.component.adexpress.TRI.sc) this.BT).setAnimationText(arrayList);
            ((com.bytedance.sdk.component.adexpress.TRI.sc) this.BT).setAnimationType(this.Tf.qKn());
            ((com.bytedance.sdk.component.adexpress.TRI.sc) this.BT).setAnimationDuration(this.Tf.CYO() * 1000);
            ((com.bytedance.sdk.component.adexpress.TRI.sc) this.BT).sc();
        }
    }

    private void WH() {
        int iSc;
        if (TextUtils.equals(this.Ql.WH().pFF(), "source") || TextUtils.equals(this.Ql.WH().pFF(), CampaignEx.JSON_KEY_TITLE) || TextUtils.equals(this.Ql.WH().pFF(), "text_star")) {
            int[] iArrPFF = com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.pFF(this.Tf.TRI(), this.Tf.ExN(), true);
            int iSc2 = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), this.Tf.pFF());
            int iSc3 = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), this.Tf.zY());
            int iSc4 = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), this.Tf.We());
            int iSc5 = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), this.Tf.sc());
            int iMin = Math.min(iSc2, iSc5);
            if (TextUtils.equals(this.Ql.WH().pFF(), "source") && (iSc = ((this.Qj - ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), this.Tf.ExN()))) - iSc2) - iSc5) > 1 && iSc <= iMin * 2) {
                int i11 = iSc / 2;
                this.BT.setPadding(iSc3, iSc2 - i11, iSc4, iSc5 - (iSc - i11));
                return;
            }
            int i12 = (((iArrPFF[1] + iSc2) + iSc5) - this.Qj) - 2;
            if (i12 <= 1) {
                return;
            }
            if (i12 <= iMin * 2) {
                int i13 = i12 / 2;
                this.BT.setPadding(iSc3, iSc2 - i13, iSc4, iSc5 - (i12 - i13));
            } else if (i12 > iSc2 + iSc5) {
                final int i14 = (i12 - iSc2) - iSc5;
                this.BT.setPadding(iSc3, 0, iSc4, 0);
                if (i14 <= ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), 1.0f)) + 1) {
                    ((TextView) this.BT).setTextSize(this.Tf.ExN() - 1.0f);
                } else if (i14 <= (((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.BT).setTextSize(this.Tf.ExN() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WP.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = WP.this.BT.getLayoutParams();
                                WP wp2 = WP.this;
                                layoutParams.height = wp2.Qj + i14;
                                wp2.BT.setLayoutParams(layoutParams);
                                WP.this.BT.setTranslationY(-i14);
                                ((ViewGroup) WP.this.BT.getParent()).setClipChildren(false);
                                ((ViewGroup) WP.this.BT.getParent().getParent()).setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iSc2 > iSc5) {
                this.BT.setPadding(iSc3, iSc2 - (i12 - iMin), iSc4, iSc5 - iMin);
            } else {
                this.BT.setPadding(iSc3, iSc2 - iMin, iSc4, iSc5 - (i12 - iMin));
            }
        }
        if (TextUtils.equals(this.Ql.WH().pFF(), "fillButton")) {
            this.BT.setTextAlignment(2);
            ((TextView) this.BT).setGravity(17);
        }
    }

    private boolean sc() {
        DynamicRootView dynamicRootView = this.SR;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.SR.getRenderRequest().WH() == 4) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        int i11;
        double d11;
        super.Ol();
        if (TextUtils.isEmpty(getText())) {
            this.BT.setVisibility(4);
            return true;
        }
        if (this.Tf.JoC()) {
            UFX();
            return true;
        }
        ((TextView) this.BT).setText(this.Tf.TRI());
        ((TextView) this.BT).setTextDirection(5);
        this.BT.setTextAlignment(this.Tf.Qj());
        ((TextView) this.BT).setTextColor(this.Tf.qr());
        ((TextView) this.BT).setTextSize(this.Tf.ExN());
        if (this.Tf.uEA()) {
            int iJPJ = this.Tf.JPJ();
            if (iJPJ > 0) {
                ((TextView) this.BT).setLines(iJPJ);
                ((TextView) this.BT).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.BT).setMaxLines(1);
            ((TextView) this.BT).setGravity(17);
            ((TextView) this.BT).setEllipsize(TextUtils.TruncateAt.END);
        }
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = this.Ql;
        if (qj2 != null && qj2.WH() != null) {
            if (com.bytedance.sdk.component.adexpress.We.pFF() && sc() && (TextUtils.equals(this.Ql.WH().pFF(), "text_star") || TextUtils.equals(this.Ql.WH().pFF(), "score-count") || TextUtils.equals(this.Ql.WH().pFF(), "score-count-type-1") || TextUtils.equals(this.Ql.WH().pFF(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.Ql.WH().pFF(), "score-count") || TextUtils.equals(this.Ql.WH().pFF(), "score-count-type-2")) {
                try {
                    try {
                        i11 = Integer.parseInt(getText());
                    } catch (NumberFormatException unused) {
                        i11 = -1;
                    }
                    if (i11 < 0) {
                        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                            setVisibility(8);
                            return true;
                        }
                        this.BT.setVisibility(0);
                    }
                    if (TextUtils.equals(this.Ql.WH().pFF(), "score-count-type-2")) {
                        ((TextView) this.BT).setText(String.format(new DecimalFormat("(###,###,###)").format(i11), Integer.valueOf(i11)));
                        ((TextView) this.BT).setGravity(17);
                        return true;
                    }
                    sc((TextView) this.BT, i11, getContext(), "tt_comment_num");
                } catch (Exception unused2) {
                }
            } else if (TextUtils.equals(this.Ql.WH().pFF(), "text_star")) {
                try {
                    d11 = Double.parseDouble(getText());
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("DynamicStarView applyNativeStyle", e11.toString());
                    d11 = -1.0d;
                }
                if (d11 < 0.0d || d11 > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                        setVisibility(8);
                        return true;
                    }
                    this.BT.setVisibility(0);
                }
                ((TextView) this.BT).setIncludeFontPadding(false);
                ((TextView) this.BT).setText(String.format("%.1f", Double.valueOf(d11)));
            } else if (TextUtils.equals("privacy-detail", this.Ql.WH().pFF())) {
                ((TextView) this.BT).setText("Permission list | Privacy policy");
            } else if (TextUtils.equals(this.Ql.WH().pFF(), "development-name")) {
                ((TextView) this.BT).setText(com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.Ql.WH().pFF(), "app-version")) {
                ((TextView) this.BT).setText(com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.BT).setText(getText());
            }
            this.BT.setTextAlignment(this.Tf.Qj());
            ((TextView) this.BT).setGravity(this.Tf.Ol());
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                WH();
            }
        }
        return true;
    }

    public String getText() {
        String strTRI = this.Tf.TRI();
        if (TextUtils.isEmpty(strTRI)) {
            if (!com.bytedance.sdk.component.adexpress.We.pFF() && TextUtils.equals(this.Ql.WH().pFF(), "text_star")) {
                strTRI = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.We.pFF() && TextUtils.equals(this.Ql.WH().pFF(), "score-count")) {
                strTRI = "6870";
            }
        }
        return (TextUtils.equals(this.Ql.WH().pFF(), CampaignEx.JSON_KEY_TITLE) || TextUtils.equals(this.Ql.WH().pFF(), "subtitle")) ? strTRI.replace("\n", "") : strTRI;
    }

    public void sc(TextView textView, int i11, Context context, String str) {
        textView.setText("(" + String.format(com.bytedance.sdk.component.utils.Sfl.sc(context, str), Integer.valueOf(i11)) + ")");
        if (i11 == -1) {
            textView.setVisibility(8);
        }
    }
}
