package com.bytedance.sdk.openadsdk.common;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Xc extends Dialog {
    private static final String[] pFF = {"SDK version", "App", "App version", "OS", "Device", "Creative info"};
    private Button ExN;
    private ImageView TRI;
    private TextView We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Handler f27706sc;
    private String zY;

    public Xc(@NonNull Context context) {
        super(context, Sfl.TRI(context, "tt_privacy_dialog_theme_ad_report"));
        this.f27706sc = new Handler(Looper.getMainLooper());
        this.zY = "";
    }

    private void pFF() {
        final String strExN = cJ.ExN();
        final String strQr = cJ.qr();
        final String str = "Android " + Build.VERSION.RELEASE;
        final String str2 = Build.BRAND + " " + Build.MODEL;
        this.ExN.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.Xc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) Xc.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null) {
                    StringBuilder sb2 = new StringBuilder();
                    String[] strArr = {BuildConfig.VERSION_NAME, strExN, strQr, str, str2, Xc.this.zY};
                    for (int i11 = 0; i11 < Xc.pFF.length; i11++) {
                        sb2.append(Xc.pFF[i11]);
                        sb2.append(": ");
                        sb2.append(strArr[i11]);
                        sb2.append("\n");
                    }
                    try {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("pangle sdk build info", sb2));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        this.TRI.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.Xc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Xc.this.We.setText("loading ...");
                Xc.this.cancel();
            }
        });
    }

    private int sc(float f11) {
        return kX.zY(getContext(), f11);
    }

    private View sc(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        exN.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_ad_report_info_bg"));
        exN.setOrientation(1);
        exN.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setLayoutParams(new ViewGroup.LayoutParams(-1, sc(44.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(sc(191.0f), sc(24.0f));
        layoutParams2.addRule(13);
        qj2.setGravity(17);
        qj2.setText("Ad Report");
        qj2.setTextColor(Color.parseColor("#161823"));
        qj2.setTextSize(1, 17.0f);
        qj2.setLayoutParams(layoutParams2);
        this.TRI = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(sc(40.0f), sc(44.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = sc(8.0f);
        this.TRI.setPadding(sc(12.0f), sc(14.0f), sc(12.0f), sc(14.0f));
        this.TRI.setImageResource(Sfl.We(context, "tt_ad_xmark"));
        this.TRI.setLayoutParams(layoutParams3);
        View view = new View(context);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, sc(0.5f));
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        view.setLayoutParams(layoutParams4);
        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams5.leftMargin = sc(16.0f);
        layoutParams5.rightMargin = sc(16.0f);
        layoutParams5.weight = 1.0f;
        layoutParams5.setMarginStart(sc(16.0f));
        layoutParams5.setMarginEnd(sc(16.0f));
        scrollView.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        ViewGroup.LayoutParams layoutParams6 = new ViewGroup.LayoutParams(-1, -1);
        exN2.setOrientation(1);
        exN2.setLayoutParams(layoutParams6);
        String strExN = cJ.ExN();
        String strQr = cJ.qr();
        String str = "Android " + Build.VERSION.RELEASE;
        String str2 = Build.BRAND + " " + Build.MODEL;
        com.bytedance.sdk.openadsdk.core.ExN.ExN exNSc = sc(context, "SDK version", BuildConfig.VERSION_NAME);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exNSc2 = sc(context, "App", strExN);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exNSc3 = sc(context, "App version", strQr);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exNSc4 = sc(context, "OS", str);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exNSc5 = sc(context, "Device", str2);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exNSc6 = sc(context, "Creative info", "loading ...");
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN3 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, sc(76.0f));
        exN3.setBackgroundColor(-1);
        exN3.setLayoutParams(layoutParams7);
        this.ExN = new Button(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -1);
        int iSc = sc(16.0f);
        layoutParams8.setMargins(iSc, iSc, iSc, iSc);
        this.ExN.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_ad_report_info_button_bg"));
        this.ExN.setText("copy all");
        this.ExN.setTextColor(Color.parseColor("#333333"));
        this.ExN.setTextSize(14.0f);
        this.ExN.setLayoutParams(layoutParams8);
        exN.addView(qrVar);
        qrVar.addView(qj2);
        qrVar.addView(this.TRI);
        exN.addView(view);
        exN.addView(scrollView);
        scrollView.addView(exN2);
        exN2.addView(exNSc);
        exN2.addView(exNSc2);
        exN2.addView(exNSc3);
        exN2.addView(exNSc4);
        exN2.addView(exNSc5);
        exN2.addView(exNSc6);
        exN.addView(exN3);
        exN3.addView(this.ExN);
        return exN;
    }

    private com.bytedance.sdk.openadsdk.core.ExN.ExN sc(Context context, String str, String str2) {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, str.equals("Creative info") ? -2 : sc(74.0f));
        exN.setOrientation(1);
        exN.setPadding(0, sc(16.0f), 0, sc(16.0f));
        exN.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = sc(7.0f);
        qj2.setIncludeFontPadding(false);
        qj2.setText(str);
        qj2.setTextColor(Color.parseColor("#333333"));
        qj2.setTextSize(16.0f);
        qj2.setTypeface(Typeface.defaultFromStyle(1));
        qj2.setLayoutParams(layoutParams2);
        exN.addView(qj2);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        if (str.equals("Creative info")) {
            this.We = qj3;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        qj3.setIncludeFontPadding(false);
        qj3.setTextColor(Color.parseColor("#666666"));
        qj3.setText(str2);
        qj3.setTextSize(14.0f);
        qj3.setLayoutParams(layoutParams3);
        exN.addView(qj3);
        return exN;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(sc(getContext()), new ViewGroup.LayoutParams(kX.zY(getContext()), (int) (((double) kX.We(getContext())) * 0.9d)));
        pFF();
        if (getWindow() != null) {
            getWindow().setGravity(80);
        }
    }

    public void sc(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.zY = com.bytedance.sdk.component.utils.sc.sc(new JSONObject(str)).toString();
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTPrivacyAdReportDialog", e11.getMessage());
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.f27706sc.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.Xc.3
                @Override // java.lang.Runnable
                public void run() {
                    Xc.this.We.setText(Xc.this.zY);
                }
            }, 1000L);
        } catch (Exception e11) {
            ApmHelper.reportCustomError("showPrivacyAdReportDialogError", "showPrivacyAdReportDialogError", e11);
        }
    }
}
