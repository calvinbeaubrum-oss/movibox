package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class StarLevelLayoutView extends LinearLayout {
    public StarLevelLayoutView(Context context) {
        super(context);
    }

    public StarLevelLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StarLevelLayoutView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public void setRating(int i11) {
        removeAllViews();
        if (i11 == 0) {
            i11 = 5;
        }
        for (int i12 = 0; i12 < 5; i12++) {
            View imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i12 < i11) {
                imageView.setBackgroundResource(v.a(getContext(), "mbridge_demo_star_sel", "drawable"));
            } else {
                imageView.setBackgroundResource(v.a(getContext(), "mbridge_demo_star_nor", "drawable"));
            }
            layoutParams.leftMargin = ai.a(getContext(), 7.0f);
            addView(imageView, layoutParams);
        }
    }
}
