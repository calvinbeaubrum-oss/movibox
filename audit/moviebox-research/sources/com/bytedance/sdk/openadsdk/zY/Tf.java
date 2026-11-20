package com.bytedance.sdk.openadsdk.zY;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.Locale;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf extends Dialog {
    private com.bytedance.sdk.openadsdk.core.ExN.Qj ExN;
    private String Ol;
    private String Qj;
    private com.bytedance.sdk.openadsdk.core.ExN.We TRI;
    private final WH WH;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj We;
    private sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f28808qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ExN.ExN f28809sc;
    private com.bytedance.sdk.openadsdk.core.ExN.pFF zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF();

        void sc();

        void sc(int i11, FilterWord filterWord, String str);

        void zY();
    }

    public Tf(@NonNull Context context, WH wh2) {
        super(context, Sfl.TRI(context, "tt_quick_option_dialog"));
        setCanceledOnTouchOutside(false);
        this.WH = wh2;
    }

    private void We() {
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.zY.Tf.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (Tf.this.pFF != null) {
                    Tf.this.pFF.zY();
                }
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.ExN.ExN sc(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        exN.setOrientation(1);
        exN.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_dislike_dialog_bg"));
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setLayoutParams(new LinearLayout.LayoutParams(-1, kX.zY(context, 48.0f)));
        this.TRI = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        int iZY = kX.zY(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZY, iZY);
        layoutParams.addRule(16);
        layoutParams.addRule(11);
        int iZY2 = kX.zY(context, 10.0f);
        layoutParams.topMargin = iZY2;
        layoutParams.rightMargin = iZY2;
        this.TRI.setLayoutParams(layoutParams);
        this.TRI.setClickable(true);
        this.TRI.setFocusable(true);
        this.TRI.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_titlebar_close_seletor"));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(16);
        layoutParams2.topMargin = kX.zY(context, 12.0f);
        qj2.setLayoutParams(layoutParams2);
        qj2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        qj2.setGravity(17);
        qj2.setSingleLine(true);
        qj2.setText(Sfl.sc(context, "tt_other_reason"));
        qj2.setTextColor(Color.parseColor("#161823"));
        qj2.setTextSize(15.0f);
        qj2.setTypeface(Typeface.defaultFromStyle(0));
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, kX.zY(context, 0.5f)));
        view.setBackgroundColor(Color.argb(51, 22, 24, 35));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        exN2.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.ExN.pFF pff = new com.bytedance.sdk.openadsdk.core.ExN.pFF(context);
        this.zY = pff;
        pff.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200), new InputFilter.AllCaps()});
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = kX.zY(context, 16.0f);
        layoutParams3.rightMargin = kX.zY(context, 16.0f);
        layoutParams3.topMargin = kX.zY(context, 11.5f);
        this.zY.setLayoutParams(layoutParams3);
        this.zY.setLines(4);
        this.zY.setGravity(48);
        this.zY.setHint(Sfl.sc(context, "tt_suggestion_description"));
        this.zY.setTextSize(15.0f);
        this.zY.setTextColor(Color.rgb(22, 24, 35));
        this.zY.setHintTextColor(Color.parseColor("#57161823"));
        this.zY.setBackground(null);
        this.zY.setImeOptions(ASTNode.DEOP);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN3 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        int iZY3 = kX.zY(context, 16.0f);
        int iZY4 = kX.zY(context, 17.0f);
        exN3.setPadding(iZY3, iZY4, iZY3, iZY4);
        exN3.setLayoutParams(layoutParams4);
        exN3.setOrientation(0);
        this.We = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2);
        layoutParams5.weight = 1.0f;
        layoutParams5.gravity = GravityCompat.START;
        this.We.setLayoutParams(layoutParams5);
        this.We.setText(String.format("0%s", "/200"));
        this.We.setGravity(GravityCompat.START);
        this.We.setTextColor(Color.parseColor("#57161823"));
        this.We.setTextSize(15.0f);
        this.ExN = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = GravityCompat.END;
        this.ExN.setLayoutParams(layoutParams6);
        this.ExN.setTextSize(14.0f);
        this.ExN.setTextColor(-1);
        this.ExN.setVisibility(0);
        this.ExN.setSingleLine(true);
        int iZY5 = kX.zY(context, 27.0f);
        int iZY6 = kX.zY(context, 5.0f);
        this.ExN.setPadding(iZY5, iZY6, iZY5, iZY6);
        int iZY7 = kX.zY(context, 6.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f11 = iZY7;
        gradientDrawable.setCornerRadius(f11);
        int iRgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(iRgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f11);
        gradientDrawable2.setColor(iRgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        this.ExN.setBackground(stateListDrawable);
        this.ExN.setText(Sfl.sc(context, "tt_done"));
        this.ExN.setEnabled(false);
        exN.addView(qrVar);
        exN.addView(view);
        exN.addView(exN2);
        qrVar.addView(this.TRI);
        qrVar.addView(qj2);
        exN2.addView(this.zY);
        exN2.addView(exN3);
        exN3.addView(this.We);
        exN3.addView(this.ExN);
        return exN;
    }

    private void sc(View view) {
        sc((EditText) this.zY);
        WH wh2 = this.WH;
        if (wh2 != null) {
            String strQr = wh2.qr();
            if (!TextUtils.isEmpty(strQr)) {
                this.zY.setText(strQr);
                this.We.setText(String.format(Locale.getDefault(), "%d%s", Integer.valueOf(strQr.length()), "/200"));
            }
            this.ExN.setEnabled(!TextUtils.isEmpty(strQr));
        }
        this.ExN.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Tf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String string = Tf.this.zY.getText().toString();
                if (Tf.this.pFF != null) {
                    Tf.this.pFF.sc(4, WH.f28815sc, string);
                }
                Tf.this.dismiss();
            }
        });
        this.TRI.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Tf.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (Tf.this.pFF != null) {
                    Tf.this.pFF.pFF();
                }
                Tf.this.dismiss();
            }
        });
        this.zY.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.zY.Tf.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                com.bytedance.sdk.openadsdk.core.ExN.Qj qj2;
                int iRound = Math.round(charSequence.length());
                Tf.this.We.setText(iRound + "/200");
                boolean z11 = true;
                if (iRound <= 0) {
                    qj2 = Tf.this.ExN;
                    if (Tf.this.WH == null || TextUtils.isEmpty(Tf.this.WH.qr())) {
                        z11 = false;
                    }
                } else if (Tf.this.ExN.isEnabled()) {
                    return;
                } else {
                    qj2 = Tf.this.ExN;
                }
                qj2.setEnabled(z11);
            }
        });
    }

    public static void sc(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.zY.Tf.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
                while (i11 < i12) {
                    int type = Character.getType(charSequence.charAt(i11));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i11++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(200)});
    }

    private void zY() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        pFF();
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exNSc = sc(Xc.sc());
        this.f28809sc = exNSc;
        setContentView(exNSc);
        sc(this.f28809sc);
        zY();
        sc();
        We();
    }

    public void pFF() {
        InputMethodManager inputMethodManager;
        com.bytedance.sdk.openadsdk.core.ExN.pFF pff = this.zY;
        if (pff == null || (inputMethodManager = (InputMethodManager) pff.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.f28809sc.getWindowToken(), 0);
    }

    public void sc() {
        com.bytedance.sdk.openadsdk.core.ExN.pFF pff = this.zY;
        if (pff == null) {
            return;
        }
        pff.requestFocus();
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    public void sc(sc scVar) {
        this.pFF = scVar;
    }

    public void sc(String str) {
        this.Ol = str;
    }

    public void sc(String str, String str2) {
        this.f28808qr = str;
        this.Qj = str2;
        WH wh2 = this.WH;
        if (wh2 != null) {
            wh2.We(str2);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        sc scVar = this.pFF;
        if (scVar != null) {
            scVar.sc();
        }
    }
}
