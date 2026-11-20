package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MBNativeRollView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RollingBCView f45891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f45892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NativeListener.FilpListener f45893c;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        View a(Frame frame, int i11);
    }

    public MBNativeRollView(Context context) {
        this(context, null);
    }

    public MBNativeRollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45892b = context;
        RollingBCView rollingBCView = new RollingBCView(context);
        this.f45891a = rollingBCView;
        addView(rollingBCView);
        this.f45891a.setLayoutParams(new LinearLayout.LayoutParams((int) (((double) ai.i(context)) * 0.9d), -2));
        setClipChildren(false);
    }

    public MBNativeRollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f45891a.dispatchTouchEvent(motionEvent);
    }

    public void setData(List<Frame> list, Context context, String str, a aVar) {
        this.f45891a.setData(list, context, str, aVar);
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        if (filpListener != null) {
            this.f45893c = filpListener;
            this.f45891a.setFilpListening(filpListener);
        }
    }

    public void setFrameWidth(int i11) {
        this.f45891a.setLayoutParams(new LinearLayout.LayoutParams(i11, -2));
    }
}
