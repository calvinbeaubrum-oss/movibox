package com.bytedance.sdk.openadsdk.zY;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends ViewGroup implements WH.zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WH f28805sc;

    public Qj(Context context, WH wh2) {
        super(context);
        this.f28805sc = wh2;
        wh2.sc(this);
    }

    private Drawable pFF() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float fZY = kX.zY(getContext(), 5.0f);
        gradientDrawable.setCornerRadius(fZY);
        gradientDrawable.setColor(Color.parseColor("#0D000000"));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setStroke(kX.zY(getContext(), 1.0f), Color.parseColor("#FE2C55"));
        gradientDrawable2.setCornerRadius(fZY);
        gradientDrawable2.setColor(Color.parseColor("#12FE2C55"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private View pFF(FilterWord filterWord) {
        TextView textView = new TextView(getContext());
        textView.setTag(filterWord);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        int iZY = kX.zY(getContext(), 8.0f);
        marginLayoutParams.leftMargin = iZY;
        marginLayoutParams.bottomMargin = iZY;
        textView.setTextColor(sc());
        textView.setText(filterWord.getName());
        textView.setPadding(iZY, iZY, iZY, iZY);
        textView.setBackground(pFF());
        textView.setSelected(false);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Qj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Qj.this.f28805sc != null) {
                    if (view.isSelected()) {
                        Qj.this.f28805sc.sc(WH.f28815sc);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof FilterWord) {
                        Qj.this.f28805sc.sc((FilterWord) tag);
                    }
                }
            }
        });
        textView.setSelected(false);
        textView.setLayoutParams(marginLayoutParams);
        return textView;
    }

    private ColorStateList sc() {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{Color.rgb(255, 44, 85), ViewCompat.MEASURED_STATE_MASK});
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int childCount = getChildCount();
        int i16 = i13 - i11;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i21 = i17 != 0 ? marginLayoutParams.leftMargin : 0;
            if (measuredWidth + i21 + i18 < i16) {
                i15 = i18 + i21;
            } else {
                i19 += marginLayoutParams.bottomMargin + measuredHeight;
                i15 = 0;
            }
            childAt.layout(i15, marginLayoutParams.topMargin + i19, i15 + measuredWidth, measuredHeight + i19);
            i18 = i15 + measuredWidth + marginLayoutParams.rightMargin;
            i17++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        View.MeasureSpec.getMode(i11);
        View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        View.MeasureSpec.getSize(i12);
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < getChildCount()) {
            View childAt = getChildAt(i13);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            measureChild(childAt, i11, i12);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i16 = i13 != 0 ? marginLayoutParams.leftMargin : 0;
            int i17 = (measuredWidth + i16) + i15 < size ? i15 + i16 : 0;
            if (i17 == 0) {
                i14 += measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
            i15 = i17 + measuredWidth + marginLayoutParams.rightMargin;
            i13++;
        }
        setMeasuredDimension(size, i14);
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.zY
    public void sc(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                if (WH.f28815sc.equals(filterWord)) {
                    childAt.setSelected(false);
                } else {
                    childAt.setSelected(filterWord.equals(childAt.getTag()));
                }
            }
        }
    }

    public void sc(List<FilterWord> list) {
        if (list == null) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            FilterWord filterWord = list.get(i11);
            if (filterWord != null) {
                addView(pFF(filterWord));
            }
        }
    }
}
