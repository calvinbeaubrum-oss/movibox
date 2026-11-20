package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseLongArray f4706b = new SparseLongArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f4707c = new SparseBooleanArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c0> f4708d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4709e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4710f = -1;

    public final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.f4706b.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.f4706b;
                long j11 = this.f4705a;
                this.f4705a = 1 + j11;
                sparseLongArray.put(pointerId, j11);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.f4706b.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.f4706b;
            long j12 = this.f4705a;
            this.f4705a = 1 + j12;
            sparseLongArray2.put(pointerId2, j12);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.f4707c.put(pointerId2, true);
            }
        }
    }

    public final void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.f4709e && source == this.f4710f) {
            return;
        }
        this.f4709e = toolType;
        this.f4710f = source;
        this.f4707c.clear();
        this.f4706b.clear();
    }

    public final b0 c(MotionEvent motionEvent, l0 l0Var) {
        int actionIndex;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.f4706b.clear();
            this.f4707c.clear();
            return null;
        }
        b(motionEvent);
        a(motionEvent);
        boolean z11 = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z12 = actionMasked == 8;
        if (z11) {
            this.f4707c.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        this.f4708d.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i11 = 0;
        while (i11 < pointerCount) {
            this.f4708d.add(d(l0Var, motionEvent, i11, (z11 || i11 == actionIndex || (z12 && motionEvent.getButtonState() == 0)) ? false : true));
            i11++;
        }
        h(motionEvent);
        return new b0(motionEvent.getEventTime(), this.f4708d, motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x005b  */
    /* JADX WARN: Code duplicated, block: B:14:0x005e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0061  */
    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:20:0x0067  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Code duplicated, block: B:23:0x0077  */
    /* JADX WARN: Code duplicated, block: B:24:0x007e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0085  */
    /* JADX WARN: Code duplicated, block: B:26:0x008c  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
    public final c0 d(l0 l0Var, MotionEvent motionEvent, int i11, boolean z11) {
        long j11;
        long jMo54localToScreenMKHz9U;
        long jA;
        long jMo55screenToLocalMKHz9U;
        int toolType;
        int iE;
        int historySize;
        int i12;
        long jC;
        float historicalX;
        long jF = f(motionEvent.getPointerId(i11));
        float pressure = motionEvent.getPressure(i11);
        long jA2 = y1.h.a(motionEvent.getX(i11), motionEvent.getY(i11));
        long jG = y1.g.g(jA2, 0.0f, 0.0f, 3, null);
        if (i11 != 0) {
            if (Build.VERSION.SDK_INT >= 29) {
                jA = m.f4718a.a(motionEvent, i11);
                jMo55screenToLocalMKHz9U = l0Var.mo55screenToLocalMKHz9U(jA);
            } else {
                j11 = jA2;
                jMo54localToScreenMKHz9U = l0Var.mo54localToScreenMKHz9U(jA2);
            }
            toolType = motionEvent.getToolType(i11);
            if (toolType != 0) {
                iE = k0.f4712a.e();
            } else if (toolType != 1) {
                iE = k0.f4712a.d();
            } else if (toolType != 2) {
                iE = k0.f4712a.c();
            } else if (toolType != 3) {
                iE = k0.f4712a.b();
            } else if (toolType != 4) {
                iE = k0.f4712a.e();
            } else {
                iE = k0.f4712a.a();
            }
            int i13 = iE;
            ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
            historySize = motionEvent.getHistorySize();
            for (i12 = 0; i12 < historySize; i12++) {
                historicalX = motionEvent.getHistoricalX(i11, i12);
                float historicalY = motionEvent.getHistoricalY(i11, i12);
                if (Float.isInfinite(historicalX) && !Float.isNaN(historicalX) && !Float.isInfinite(historicalY) && !Float.isNaN(historicalY)) {
                    long jA3 = y1.h.a(historicalX, historicalY);
                    arrayList.add(new g(motionEvent.getHistoricalEventTime(i12), jA3, jA3, null));
                }
            }
            if (motionEvent.getActionMasked() == 8) {
                jC = y1.h.a(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f);
            } else {
                jC = y1.g.f81070b.c();
            }
            long j12 = jC;
            return new c0(jF, motionEvent.getEventTime(), jMo54localToScreenMKHz9U, j11, z11, pressure, i13, this.f4707c.get(motionEvent.getPointerId(i11), false), arrayList, j12, jG, null);
        }
        jA = y1.h.a(motionEvent.getRawX(), motionEvent.getRawY());
        jMo55screenToLocalMKHz9U = l0Var.mo55screenToLocalMKHz9U(jA);
        jMo54localToScreenMKHz9U = jA;
        j11 = jMo55screenToLocalMKHz9U;
        toolType = motionEvent.getToolType(i11);
        if (toolType != 0) {
            iE = k0.f4712a.e();
        } else if (toolType != 1) {
            iE = k0.f4712a.d();
        } else if (toolType != 2) {
            iE = k0.f4712a.c();
        } else if (toolType != 3) {
            iE = k0.f4712a.b();
        } else if (toolType != 4) {
            iE = k0.f4712a.e();
        } else {
            iE = k0.f4712a.a();
        }
        int i14 = iE;
        ArrayList arrayList2 = new ArrayList(motionEvent.getHistorySize());
        historySize = motionEvent.getHistorySize();
        while (i12 < historySize) {
            historicalX = motionEvent.getHistoricalX(i11, i12);
            float historicalY2 = motionEvent.getHistoricalY(i11, i12);
            if (Float.isInfinite(historicalX)) {
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            jC = y1.h.a(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f);
        } else {
            jC = y1.g.f81070b.c();
        }
        long j13 = jC;
        return new c0(jF, motionEvent.getEventTime(), jMo54localToScreenMKHz9U, j11, z11, pressure, i14, this.f4707c.get(motionEvent.getPointerId(i11), false), arrayList2, j13, jG, null);
    }

    public final void e(int i11) {
        this.f4707c.delete(i11);
        this.f4706b.delete(i11);
    }

    public final long f(int i11) {
        long jValueAt;
        int iIndexOfKey = this.f4706b.indexOfKey(i11);
        if (iIndexOfKey >= 0) {
            jValueAt = this.f4706b.valueAt(iIndexOfKey);
        } else {
            jValueAt = this.f4705a;
            this.f4705a = 1 + jValueAt;
            this.f4706b.put(i11, jValueAt);
        }
        return y.b(jValueAt);
    }

    public final boolean g(MotionEvent motionEvent, int i11) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i12 = 0; i12 < pointerCount; i12++) {
            if (motionEvent.getPointerId(i12) == i11) {
                return true;
            }
        }
        return false;
    }

    public final void h(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.f4707c.get(pointerId, false)) {
                this.f4706b.delete(pointerId);
                this.f4707c.delete(pointerId);
            }
        }
        if (this.f4706b.size() > motionEvent.getPointerCount()) {
            for (int size = this.f4706b.size() - 1; -1 < size; size--) {
                int iKeyAt = this.f4706b.keyAt(size);
                if (!g(motionEvent, iKeyAt)) {
                    this.f4706b.removeAt(size);
                    this.f4707c.delete(iKeyAt);
                }
            }
        }
    }
}
