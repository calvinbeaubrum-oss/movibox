package com.noober.background.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import com.noober.background.BackgroundFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BLRadioGroup extends RadioGroup {
    public BLRadioGroup(Context context) {
        super(context);
    }

    public BLRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        BackgroundFactory.setViewBackground(context, attributeSet, this);
    }
}
