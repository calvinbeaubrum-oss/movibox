package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TransferService extends Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Log f15842d = LogFactory.b(TransferService.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static TransferNetworkLossHandler f15843f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15844a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15845b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15846c = true;

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) == 0) {
            return;
        }
        printWriter.printf("network status: %s\n", Boolean.valueOf(f15843f.e()));
        Map<Integer, TransferRecord> mapE = TransferStatusUpdater.c(this).e();
        printWriter.printf("# of active transfers: %d\n", Integer.valueOf(mapE.size()));
        for (TransferRecord transferRecord : mapE.values()) {
            printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", transferRecord.f15831p, transferRecord.f15832q, transferRecord.f15830o, Long.valueOf(transferRecord.f15823h), Long.valueOf(transferRecord.f15824i));
        }
        printWriter.flush();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log log = f15842d;
        log.d("Starting Transfer Service to listen for network connectivity changes.");
        f15843f = TransferNetworkLossHandler.d(getApplicationContext());
        synchronized (this) {
            if (this.f15844a) {
                try {
                    log.d("Registering the network receiver");
                    registerReceiver(f15843f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f15844a = false;
                } catch (IllegalArgumentException unused) {
                    f15842d.j("Ignoring the exception trying to register the receiver for connectivity change.");
                } catch (IllegalStateException unused2) {
                    f15842d.j("Ignoring the leak in registering the receiver.");
                }
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    f15842d.d("Moving the service out of the Foreground state.");
                    synchronized (this) {
                        stopForeground(this.f15846c);
                    }
                    super.onDestroy();
                }
                f15842d.d("De-registering the network receiver.");
                synchronized (this) {
                    try {
                        if (!this.f15844a) {
                            unregisterReceiver(f15843f);
                            this.f15844a = true;
                            f15843f = null;
                        }
                        super.onDestroy();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (IllegalArgumentException unused) {
                f15842d.j("Exception trying to de-register the network receiver");
            }
        } catch (Exception e11) {
            f15842d.f("Error in moving the service out of the foreground state: " + e11);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                synchronized (this) {
                    try {
                        Notification notification = (Notification) intent.getParcelableExtra("notification");
                        if (notification != null) {
                            this.f15845b = intent.getIntExtra("ongoing-notification-id", this.f15845b);
                            this.f15846c = intent.getBooleanExtra("remove-notification", this.f15846c);
                            f15842d.d("Putting the service in Foreground state.");
                            startForeground(this.f15845b, notification);
                        } else {
                            f15842d.f("No notification is passed in the intent. Unable to transition to foreground.");
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Exception e11) {
                f15842d.f("Error in moving the service to foreground state: " + e11);
            }
            return 1;
        }
        synchronized (this) {
            if (this.f15844a) {
                try {
                    try {
                        f15842d.d("Registering the network receiver");
                        registerReceiver(f15843f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        this.f15844a = false;
                    } catch (IllegalStateException unused) {
                        f15842d.j("Ignoring the leak in registering the receiver.");
                    }
                } catch (IllegalArgumentException unused2) {
                    f15842d.j("Ignoring the exception trying to register the receiver for connectivity change.");
                }
            }
            return 1;
        }
    }
}
