package androidx.media3.exoplayer.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import t4.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f11719a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f11720b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f11721c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f11722d = new float[3];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Display f11723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC0109a[] f11724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11725h;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.video.spherical.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0109a {
        void a(float[] fArr, float f11);
    }

    public a(Display display, InterfaceC0109a... interfaceC0109aArr) {
        this.f11723f = display;
        this.f11724g = interfaceC0109aArr;
    }

    public static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public final float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f11720b);
        SensorManager.getOrientation(this.f11720b, this.f11722d);
        return this.f11722d[2];
    }

    public final void b(float[] fArr, float f11) {
        for (InterfaceC0109a interfaceC0109a : this.f11724g) {
            interfaceC0109a.a(fArr, f11);
        }
    }

    public final void c(float[] fArr) {
        if (!this.f11725h) {
            c.a(this.f11721c, fArr);
            this.f11725h = true;
        }
        float[] fArr2 = this.f11720b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f11720b, 0, this.f11721c, 0);
    }

    public final void d(float[] fArr, int i11) {
        if (i11 != 0) {
            int i12 = TsExtractor.TS_STREAM_TYPE_AC3;
            int i13 = 1;
            if (i11 == 1) {
                i12 = 2;
                i13 = TsExtractor.TS_STREAM_TYPE_AC3;
            } else if (i11 == 2) {
                i13 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException();
                }
                i12 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
            }
            float[] fArr2 = this.f11720b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f11720b, i12, i13, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f11719a, sensorEvent.values);
        d(this.f11719a, this.f11723f.getRotation());
        float fA = a(this.f11719a);
        e(this.f11719a);
        c(this.f11719a);
        b(this.f11719a, fA);
    }
}
