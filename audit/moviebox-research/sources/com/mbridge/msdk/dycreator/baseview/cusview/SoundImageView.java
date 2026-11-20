package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class SoundImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f43503a;

    public SoundImageView(Context context) {
        super(context);
        this.f43503a = true;
    }

    public SoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43503a = true;
    }

    public SoundImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43503a = true;
    }

    public boolean getStatus() {
        return this.f43503a;
    }

    public void setSoundStatus(boolean z11) {
        this.f43503a = z11;
        if (z11) {
            setImageResource(v.a(getContext(), "mbridge_reward_sound_open", "drawable"));
        } else {
            setImageResource(v.a(getContext(), "mbridge_reward_sound_close", "drawable"));
        }
    }
}
