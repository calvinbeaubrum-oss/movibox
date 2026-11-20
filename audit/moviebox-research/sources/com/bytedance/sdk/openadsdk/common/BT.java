package com.bytedance.sdk.openadsdk.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT extends com.bytedance.sdk.openadsdk.core.ExN.zY implements com.bytedance.sdk.openadsdk.zY.WH.pFF {
    private String ExN;
    private boolean TRI;
    private Context We;
    private Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.zY.WH f27683qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private View f27684sc;
    private sc zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF(View view);

        void sc(View view);

        void sc(FilterWord filterWord);
    }

    public BT(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public BT(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BT(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.TRI = false;
        this.f27683qr = new com.bytedance.sdk.openadsdk.zY.WH();
        sc(context, attributeSet);
    }

    public BT(@NonNull Context context, @NonNull Sfl sfl) {
        this(context.getApplicationContext());
        this.pFF = sfl;
        this.We = context;
        We();
        ExN();
    }

    private void ExN() {
        com.bytedance.sdk.openadsdk.zY.WH wh2;
        Sfl sfl = this.pFF;
        if (sfl == null || (wh2 = this.f27683qr) == null) {
            return;
        }
        wh2.sc(sfl.IEI());
    }

    private com.bytedance.sdk.openadsdk.zY.Tf.sc TRI() {
        return new com.bytedance.sdk.openadsdk.zY.Tf.sc() { // from class: com.bytedance.sdk.openadsdk.common.BT.2
            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void pFF() {
                BT.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void sc() {
                BT.this.setVisibility(8);
            }

            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void sc(int i11, FilterWord filterWord, String str) {
                BT.this.f27683qr.zY(str);
                BT.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void zY() {
                BT.this.setVisibility(0);
            }
        };
    }

    private void We() {
        this.f27683qr.sc(this.pFF.mD());
        this.f27683qr.sc(this);
    }

    private void sc(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.BT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BT.this.f27683qr != null) {
                    BT.this.f27683qr.ExN();
                } else {
                    BT.this.pFF();
                }
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f27684sc = new com.bytedance.sdk.openadsdk.zY.Ol(context, this.f27683qr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = kX.zY(getContext(), 20.0f);
        layoutParams.rightMargin = kX.zY(getContext(), 20.0f);
        this.f27684sc.setLayoutParams(layoutParams);
        this.f27684sc.setClickable(true);
        ExN();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.sdk.openadsdk.zY.WH wh2 = this.f27683qr;
        if (wh2 != null) {
            wh2.sc();
        }
    }

    public void pFF() {
        setVisibility(8);
        this.TRI = false;
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.pFF(this);
        }
    }

    public void sc() {
        if (this.f27684sc.getParent() == null) {
            addView(this.f27684sc);
        }
        setVisibility(0);
        this.TRI = true;
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.sc(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.pFF
    public void sc(int i11) {
        if (com.bytedance.sdk.openadsdk.zY.WH.pFF != i11) {
            if (com.bytedance.sdk.openadsdk.zY.WH.zY == i11) {
                pFF();
                return;
            } else {
                if (com.bytedance.sdk.openadsdk.zY.WH.ExN == i11) {
                    zY();
                    return;
                }
                return;
            }
        }
        FilterWord filterWordPFF = this.f27683qr.pFF();
        if (filterWordPFF == null || com.bytedance.sdk.openadsdk.zY.WH.f28815sc.equals(filterWordPFF)) {
            return;
        }
        sc scVar = this.zY;
        if (scVar != null) {
            try {
                scVar.sc(filterWordPFF);
            } catch (Throwable unused) {
            }
        }
        pFF();
    }

    public void setCallback(sc scVar) {
        this.zY = scVar;
    }

    public void setDislikeSource(String str) {
        this.ExN = str;
        this.f27683qr.pFF(str);
    }

    public void zY() {
        Context context = this.We;
        if (context instanceof Activity) {
            boolean z11 = !((Activity) context).isFinishing();
            com.bytedance.sdk.openadsdk.zY.Tf tf2 = new com.bytedance.sdk.openadsdk.zY.Tf(this.We, this.f27683qr);
            tf2.sc(TRI());
            tf2.sc(this.pFF.mD(), this.pFF.JP().toString());
            tf2.sc(this.ExN);
            if (!z11 || tf2.isShowing()) {
                return;
            }
            tf2.show();
        }
    }
}
