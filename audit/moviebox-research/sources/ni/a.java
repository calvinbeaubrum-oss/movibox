package ni;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Dialog f71993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f71995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f71996d;

    public a(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.f71993a = dialog;
        this.f71994b = rect.left;
        this.f71995c = rect.top;
        this.f71996d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f71994b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = this.f71995c + viewFindViewById.getTop();
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i11 = this.f71996d;
            motionEventObtain.setLocation((-i11) - 1, (-i11) - 1);
        }
        view.performClick();
        return this.f71993a.onTouchEvent(motionEventObtain);
    }
}
