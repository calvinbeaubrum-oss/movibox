package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7717a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class a extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static HandlerThread f7718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Handler f7719f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseIntArray[] f7721b = new SparseIntArray[9];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<WeakReference<Activity>> f7722c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Window.OnFrameMetricsAvailableListener f7723d = new WindowOnFrameMetricsAvailableListenerC0071a();

        /* JADX INFO: renamed from: androidx.core.app.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class WindowOnFrameMetricsAvailableListenerC0071a implements Window.OnFrameMetricsAvailableListener {
            public WindowOnFrameMetricsAvailableListenerC0071a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i11) {
                a aVar = a.this;
                if ((aVar.f7720a & 1) != 0) {
                    aVar.e(aVar.f7721b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f7720a & 2) != 0) {
                    aVar2.e(aVar2.f7721b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f7720a & 4) != 0) {
                    aVar3.e(aVar3.f7721b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f7720a & 8) != 0) {
                    aVar4.e(aVar4.f7721b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f7720a & 16) != 0) {
                    aVar5.e(aVar5.f7721b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f7720a & 64) != 0) {
                    aVar6.e(aVar6.f7721b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f7720a & 32) != 0) {
                    aVar7.e(aVar7.f7721b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f7720a & 128) != 0) {
                    aVar8.e(aVar8.f7721b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f7720a & 256) != 0) {
                    aVar9.e(aVar9.f7721b[8], frameMetrics.getMetric(2));
                }
            }
        }

        public a(int i11) {
            this.f7720a = i11;
        }

        @Override // androidx.core.app.f.b
        public void a(Activity activity) {
            if (f7718e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f7718e = handlerThread;
                handlerThread.start();
                f7719f = new Handler(f7718e.getLooper());
            }
            for (int i11 = 0; i11 <= 8; i11++) {
                SparseIntArray[] sparseIntArrayArr = this.f7721b;
                if (sparseIntArrayArr[i11] == null && (this.f7720a & (1 << i11)) != 0) {
                    sparseIntArrayArr[i11] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f7723d, f7719f);
            this.f7722c.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.f.b
        public SparseIntArray[] b() {
            return this.f7721b;
        }

        @Override // androidx.core.app.f.b
        public SparseIntArray[] c(Activity activity) {
            for (WeakReference<Activity> weakReference : this.f7722c) {
                if (weakReference.get() == activity) {
                    this.f7722c.remove(weakReference);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f7723d);
            return this.f7721b;
        }

        @Override // androidx.core.app.f.b
        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f7721b;
            this.f7721b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        public void e(SparseIntArray sparseIntArray, long j11) {
            if (sparseIntArray != null) {
                int i11 = (int) ((500000 + j11) / 1000000);
                if (j11 >= 0) {
                    sparseIntArray.put(i11, sparseIntArray.get(i11) + 1);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }
    }

    public f() {
        this(1);
    }

    public f(int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f7717a = new a(i11);
        } else {
            this.f7717a = new b();
        }
    }

    public void a(@NonNull Activity activity) {
        this.f7717a.a(activity);
    }

    @Nullable
    public SparseIntArray[] b() {
        return this.f7717a.b();
    }

    @Nullable
    public SparseIntArray[] c(@NonNull Activity activity) {
        return this.f7717a.c(activity);
    }

    @Nullable
    public SparseIntArray[] d() {
        return this.f7717a.d();
    }
}
