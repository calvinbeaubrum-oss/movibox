package com.hisavana.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hisavana.common.base.BaseNativeViewHolder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TIconView extends FrameLayout {
    private static final String TAG = "TAdIconView";

    public TIconView(@NonNull Context context) {
        super(context);
    }

    public TIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public void attachLayout(@NonNull BaseNativeViewHolder baseNativeViewHolder) {
        View iconView;
        if (baseNativeViewHolder == null || (iconView = baseNativeViewHolder.getIconView(getContext())) == null) {
            return;
        }
        removeAllViews();
        addView(iconView, new FrameLayout.LayoutParams(-1, -1));
    }

    public View getIconView() {
        return getChildAt(0);
    }
}
