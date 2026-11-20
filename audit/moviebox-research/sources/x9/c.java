package x9;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends GestureDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public a f80449a;

    /* JADX INFO: compiled from: source.java */
    public static class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f80450a = false;

        public boolean a() {
            return this.f80450a;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f80450a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public c(@NonNull Context context) {
        this(context, new a());
    }

    public c(Context context, @NonNull a aVar) {
        super(context, aVar);
        this.f80449a = aVar;
        setIsLongpressEnabled(false);
    }

    public boolean a() {
        return this.f80449a.a();
    }
}
