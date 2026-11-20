package e;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f63566a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(List<ScanResult> list);

        void c(int i11);

        void d(int i11, ScanResult scanResult);
    }

    public f(a aVar) {
        this.f63566a = aVar;
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> list) {
        super.onBatchScanResults(list);
        a aVar = this.f63566a;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanFailed(int i11) {
        super.onScanFailed(i11);
        a aVar = this.f63566a;
        if (aVar != null) {
            aVar.c(i11);
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int i11, ScanResult scanResult) {
        super.onScanResult(i11, scanResult);
        a aVar = this.f63566a;
        if (aVar != null) {
            aVar.d(i11, scanResult);
        }
    }
}
