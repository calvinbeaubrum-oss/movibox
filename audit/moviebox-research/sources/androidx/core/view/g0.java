package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f8004a = new float[20];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f8005b = new long[20];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8006c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8007d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8008e = 0;

    public static float f(float f11) {
        return (f11 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f11) * 2.0f));
    }

    public void a(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f8007d != 0 && eventTime - this.f8005b[this.f8008e] > 40) {
            b();
        }
        int i11 = (this.f8008e + 1) % 20;
        this.f8008e = i11;
        int i12 = this.f8007d;
        if (i12 != 20) {
            this.f8007d = i12 + 1;
        }
        this.f8004a[i11] = motionEvent.getAxisValue(26);
        this.f8005b[this.f8008e] = eventTime;
    }

    public final void b() {
        this.f8007d = 0;
        this.f8006c = 0.0f;
    }

    public void c(int i11, float f11) {
        float fE = e() * i11;
        this.f8006c = fE;
        if (fE < (-Math.abs(f11))) {
            this.f8006c = -Math.abs(f11);
        } else if (this.f8006c > Math.abs(f11)) {
            this.f8006c = Math.abs(f11);
        }
    }

    public float d(int i11) {
        if (i11 != 26) {
            return 0.0f;
        }
        return this.f8006c;
    }

    public final float e() {
        long[] jArr;
        long j11;
        int i11 = this.f8007d;
        if (i11 < 2) {
            return 0.0f;
        }
        int i12 = this.f8008e;
        int i13 = ((i12 + 20) - (i11 - 1)) % 20;
        long j12 = this.f8005b[i12];
        while (true) {
            jArr = this.f8005b;
            j11 = jArr[i13];
            if (j12 - j11 <= 100) {
                break;
            }
            this.f8007d--;
            i13 = (i13 + 1) % 20;
        }
        int i14 = this.f8007d;
        if (i14 < 2) {
            return 0.0f;
        }
        if (i14 == 2) {
            int i15 = (i13 + 1) % 20;
            long j13 = jArr[i15];
            if (j11 == j13) {
                return 0.0f;
            }
            return this.f8004a[i15] / (j13 - j11);
        }
        int i16 = 0;
        float fAbs = 0.0f;
        for (int i17 = 0; i17 < this.f8007d - 1; i17++) {
            int i18 = i17 + i13;
            long[] jArr2 = this.f8005b;
            long j14 = jArr2[i18 % 20];
            int i19 = (i18 + 1) % 20;
            if (jArr2[i19] != j14) {
                i16++;
                float f11 = f(fAbs);
                float f12 = this.f8004a[i19] / (this.f8005b[i19] - j14);
                fAbs += (f12 - f11) * Math.abs(f12);
                if (i16 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }
}
