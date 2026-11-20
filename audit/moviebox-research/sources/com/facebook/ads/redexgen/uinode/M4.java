package com.facebook.ads.redexgen.uinode;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.widget.Toast;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M4 implements SensorEventListener {
    public static byte[] A0A;
    public long A04;
    public long A05;
    public long A06;
    public SensorManager A07;
    public final C1795Yn A08;
    public int A03 = 0;
    public float A00 = -1.0f;
    public float A01 = -1.0f;
    public float A02 = -1.0f;
    public final Set<M3> A09 = new CopyOnWriteArraySet();

    static {
        A02();
    }

    public M4(C1795Yn c1795Yn) {
        this.A08 = c1795Yn;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() {
        SensorManager sensorManager;
        SensorManager sensorManager2 = (SensorManager) this.A08.getSystemService(A00(42, 6, 41));
        this.A07 = sensorManager2;
        if (sensorManager2 == null) {
            Toast.makeText(this.A08, A00(0, 21, 107), 1).show();
        }
        boolean zRegisterListener = false;
        try {
            SensorManager sensorManager3 = this.A07;
            zRegisterListener = sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(1), 3);
        } catch (Exception unused) {
            Toast.makeText(this.A08, A00(21, 21, 13), 1).show();
        }
        if (zRegisterListener || (sensorManager = this.A07) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    public static void A02() {
        A0A = new byte[]{119, 65, 74, 87, 75, 86, 87, 4, 74, 75, 80, 4, 87, 81, 84, 84, 75, 86, 80, 65, 64, 17, 42, 35, 41, 43, 44, 37, 98, 44, 45, 54, 98, 49, 55, 50, 50, 45, 48, 54, 39, 38, Ascii.NAK, 3, 8, Ascii.NAK, 9, Ascii.DC4};
    }

    public final void A03(M3 m11) {
        if (this.A09.isEmpty()) {
            A01();
        } else if (this.A09.contains(m11)) {
            return;
        }
        this.A09.add(m11);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 1) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.A04 > 500) {
            this.A03 = 0;
        }
        long j11 = this.A06;
        if (jElapsedRealtime - j11 > 100) {
            if ((Math.abs(((((sensorEvent.values[0] + sensorEvent.values[1]) + sensorEvent.values[2]) - this.A00) - this.A01) - this.A02) / (jElapsedRealtime - j11)) * 10000.0f > 800.0f) {
                int i11 = this.A03 + 1;
                this.A03 = i11;
                if (i11 >= 3 && jElapsedRealtime - this.A05 > 1000) {
                    this.A05 = jElapsedRealtime;
                    this.A03 = 0;
                    Iterator<M3> it = this.A09.iterator();
                    while (it.hasNext()) {
                        it.next().AD6();
                    }
                }
                this.A04 = jElapsedRealtime;
            }
            this.A06 = jElapsedRealtime;
            this.A00 = sensorEvent.values[0];
            this.A01 = sensorEvent.values[1];
            this.A02 = sensorEvent.values[2];
        }
    }
}
