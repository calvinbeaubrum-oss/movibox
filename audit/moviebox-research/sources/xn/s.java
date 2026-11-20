package xn;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f80638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowManager f80639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OrientationEventListener f80640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f80641d;

    /* JADX INFO: compiled from: source.java */
    public class a extends OrientationEventListener {
        public a(Context context, int i11) {
            super(context, i11);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i11) {
            int rotation;
            WindowManager windowManager = s.this.f80639b;
            r rVar = s.this.f80641d;
            if (s.this.f80639b == null || rVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == s.this.f80638a) {
                return;
            }
            s.this.f80638a = rotation;
            rVar.a(rotation);
        }
    }

    public void e(Context context, r rVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f80641d = rVar;
        this.f80639b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f80640c = aVar;
        aVar.enable();
        this.f80638a = this.f80639b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f80640c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f80640c = null;
        this.f80639b = null;
        this.f80641d = null;
    }
}
