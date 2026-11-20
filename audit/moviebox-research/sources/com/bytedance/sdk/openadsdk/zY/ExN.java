package com.bytedance.sdk.openadsdk.zY;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends com.bytedance.sdk.openadsdk.core.ExN.ExN implements View.OnClickListener, WH.zY {
    private final WH ExN;
    private final int Qj;
    private FilterWord TRI;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private StateListDrawable f28797qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static FilterWord f28796sc = new FilterWord("100:1", "GOOD");
    public static FilterWord pFF = new FilterWord("100:2", "NOT_BAD");
    public static FilterWord zY = new FilterWord("100:3", "BAD");
    public static List<ExN> We = new ArrayList(3);

    public ExN(@NonNull Context context, int i11, WH wh2) {
        super(context);
        this.Qj = i11;
        this.ExN = wh2;
        if (wh2 != null) {
            wh2.sc(this);
        }
        sc(i11);
        sc();
        pFF();
        We.add(this);
    }

    private void pFF() {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(getContext());
        qj2.setTextSize(this.ExN.Ol() ? 40 : 30);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.setMargins(0, kX.zY(getContext(), 12.0f), 0, kX.zY(getContext(), this.ExN.Ol() ? 8.0f : 4.0f));
        addView(qj2, layoutParams);
        sc scVar = new sc(getContext());
        scVar.setTextSize(this.ExN.Ol() ? 17 : 12);
        scVar.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        scVar.setMaxLines(1);
        scVar.setSingleLine();
        scVar.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.setMargins(0, 0, 0, kX.zY(getContext(), 12.0f));
        addView(scVar, layoutParams2);
        int i11 = this.Qj;
        if (i11 == 1) {
            qj2.setText("😍");
            scVar.setText(Sfl.sc(getContext(), "tt_good"));
        } else if (i11 == 2) {
            scVar.setText(Sfl.sc(getContext(), "tt_not_bad"));
            qj2.setText("😐");
        } else {
            if (i11 != 3) {
                return;
            }
            scVar.setText(Sfl.sc(getContext(), "tt_bad"));
            qj2.setText("😡");
        }
    }

    private void sc() {
        if (this.f28797qr == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(kX.zY(getContext(), 12.0f));
            gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setStroke(kX.zY(getContext(), 2.0f), Color.parseColor("#FE2C55"));
            gradientDrawable2.setCornerRadius(kX.zY(getContext(), 12.0f));
            gradientDrawable2.setColor(Color.parseColor("#12FE2C55"));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f28797qr = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_selected}, gradientDrawable2);
            this.f28797qr.addState(new int[0], gradientDrawable);
        }
        setBackground(this.f28797qr);
        setSelected(false);
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setOnClickListener(this);
    }

    private void sc(int i11) {
        if (i11 == 1) {
            this.TRI = f28796sc;
        } else if (i11 == 2) {
            this.TRI = pFF;
        } else {
            if (i11 != 3) {
                return;
            }
            this.TRI = zY;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isSelected()) {
            this.ExN.sc(WH.f28815sc);
        } else {
            this.ExN.sc(this.TRI);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.zY
    public void sc(FilterWord filterWord) {
        FilterWord filterWord2;
        if (filterWord == null || (filterWord2 = this.TRI) == null) {
            return;
        }
        setSelected(filterWord.equals(filterWord2));
    }
}
