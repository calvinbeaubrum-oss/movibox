package fm;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.journeyapps.barcodescanner.camera.CameraSettings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.journeyapps.barcodescanner.camera.h f65116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CameraSettings f65117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Sensor f65118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f65119d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f65120f = new Handler();

    public b(Context context, com.journeyapps.barcodescanner.camera.h hVar, CameraSettings cameraSettings) {
        this.f65119d = context;
        this.f65116a = hVar;
        this.f65117b = cameraSettings;
    }

    public final /* synthetic */ void b(boolean z11) {
        this.f65116a.u(z11);
    }

    public final void c(final boolean z11) {
        this.f65120f.post(new Runnable() { // from class: fm.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f65114a.b(z11);
            }
        });
    }

    public void d() {
        if (this.f65117b.d()) {
            SensorManager sensorManager = (SensorManager) this.f65119d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f65118c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void e() {
        if (this.f65118c != null) {
            ((SensorManager) this.f65119d.getSystemService("sensor")).unregisterListener(this);
            this.f65118c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f11 = sensorEvent.values[0];
        if (this.f65116a != null) {
            if (f11 <= 45.0f) {
                c(true);
            } else if (f11 >= 450.0f) {
                c(false);
            }
        }
    }
}
