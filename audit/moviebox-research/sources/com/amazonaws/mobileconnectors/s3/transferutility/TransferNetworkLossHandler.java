package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TransferNetworkLossHandler extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Log f15800d = LogFactory.b(TransferNetworkLossHandler.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static TransferNetworkLossHandler f15801e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f15802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TransferDBUtil f15803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TransferStatusUpdater f15804c;

    public TransferNetworkLossHandler(Context context) {
        this.f15802a = (ConnectivityManager) context.getSystemService("connectivity");
        this.f15803b = new TransferDBUtil(context);
        this.f15804c = TransferStatusUpdater.c(context);
    }

    public static synchronized TransferNetworkLossHandler c() throws TransferUtilityException {
        TransferNetworkLossHandler transferNetworkLossHandler;
        transferNetworkLossHandler = f15801e;
        if (transferNetworkLossHandler == null) {
            f15800d.f("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
            throw new TransferUtilityException("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
        }
        return transferNetworkLossHandler;
    }

    public static synchronized TransferNetworkLossHandler d(Context context) {
        try {
            if (f15801e == null) {
                f15801e = new TransferNetworkLossHandler(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f15801e;
    }

    public boolean e() {
        NetworkInfo activeNetworkInfo = this.f15802a.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final synchronized void f() {
        for (TransferRecord transferRecord : this.f15804c.e().values()) {
            AmazonS3 amazonS3A = S3ClientReference.a(Integer.valueOf(transferRecord.f15816a));
            if (amazonS3A != null && transferRecord.h(amazonS3A, this.f15804c, this.f15802a)) {
                this.f15804c.l(transferRecord.f15816a, TransferState.WAITING_FOR_NETWORK);
            }
        }
    }

    public final synchronized void g() {
        TransferRecord transferRecordD;
        try {
            int i11 = 0;
            TransferState[] transferStateArr = {TransferState.WAITING_FOR_NETWORK};
            f15800d.a("Loading transfers from database...");
            ArrayList<Integer> arrayList = new ArrayList();
            Cursor cursorO = null;
            try {
                cursorO = this.f15803b.o(TransferType.ANY, transferStateArr);
                while (cursorO.moveToNext()) {
                    int i12 = cursorO.getInt(cursorO.getColumnIndexOrThrow("_id"));
                    if (this.f15804c.d(i12) == null) {
                        TransferRecord transferRecord = new TransferRecord(i12);
                        transferRecord.j(cursorO);
                        this.f15804c.b(transferRecord);
                        i11++;
                    }
                    arrayList.add(Integer.valueOf(i12));
                }
                f15800d.a("Closing the cursor for resumeAllTransfers");
                cursorO.close();
                try {
                    for (Integer num : arrayList) {
                        AmazonS3 amazonS3A = S3ClientReference.a(num);
                        if (amazonS3A != null && (transferRecordD = this.f15804c.d(num.intValue())) != null && !transferRecordD.f()) {
                            transferRecordD.i(amazonS3A, this.f15803b, this.f15804c, this.f15802a);
                        }
                    }
                } catch (Exception e11) {
                    f15800d.f("Error in resuming the transfers." + e11.getMessage());
                }
                f15800d.a(i11 + " transfers are loaded from database.");
            } catch (Throwable th2) {
                if (cursorO != null) {
                    f15800d.a("Closing the cursor for resumeAllTransfers");
                    cursorO.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            Log log = f15800d;
            log.d("Network connectivity changed detected.");
            log.d("Network connected: " + e());
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TransferNetworkLossHandler.this.e()) {
                        TransferNetworkLossHandler.this.g();
                    } else {
                        TransferNetworkLossHandler.this.f();
                    }
                }
            }).start();
        }
    }
}
