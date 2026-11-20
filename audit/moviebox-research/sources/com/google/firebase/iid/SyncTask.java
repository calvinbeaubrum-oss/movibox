package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
class SyncTask implements Runnable {
    private final FirebaseInstanceId iid;
    private final long nextDelaySeconds;

    @VisibleForTesting
    ExecutorService processorExecutor = b.b();
    private final PowerManager.WakeLock syncWakeLock;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    @VisibleForTesting
    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SyncTask f40624a;

        public a(SyncTask syncTask) {
            this.f40624a = syncTask;
        }

        public void a() {
            FirebaseInstanceId.q();
            this.f40624a.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f40624a;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                FirebaseInstanceId.q();
                this.f40624a.iid.f(this.f40624a, 0L);
                this.f40624a.getContext().unregisterReceiver(this);
                this.f40624a = null;
            }
        }
    }

    @VisibleForTesting
    public SyncTask(FirebaseInstanceId firebaseInstanceId, long j11) {
        this.iid = firebaseInstanceId;
        this.nextDelaySeconds = j11;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public Context getContext() {
        return this.iid.g().j();
    }

    public boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    public boolean maybeRefreshToken() throws IOException {
        if (!this.iid.E(this.iid.o())) {
            return true;
        }
        try {
            if (this.iid.d() == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            Log.isLoggable("FirebaseInstanceId", 3);
            return true;
        } catch (IOException e11) {
            if (!k.f(e11.getMessage())) {
                if (e11.getMessage() != null) {
                    throw e11;
                }
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 52);
            sb2.append("Token retrieval failed: ");
            sb2.append(message);
            sb2.append(". Will retry token retrieval");
            Log.w("FirebaseInstanceId", sb2.toString());
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (t.a().c(getContext())) {
            this.syncWakeLock.acquire();
        }
        try {
            this.iid.B(true);
            if (!this.iid.r()) {
                this.iid.B(false);
                if (!t.a().c(getContext())) {
                }
            } else if (!t.a().b(getContext()) || isDeviceConnected()) {
                if (maybeRefreshToken()) {
                    this.iid.B(false);
                } else {
                    this.iid.D(this.nextDelaySeconds);
                }
                if (!t.a().c(getContext())) {
                }
            } else {
                new a(this).a();
                if (!t.a().c(getContext())) {
                }
            }
        } catch (IOException e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 93);
            sb2.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb2.append(message);
            sb2.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb2.toString());
            this.iid.B(false);
            if (!t.a().c(getContext())) {
            }
        } finally {
            if (t.a().c(getContext())) {
                this.syncWakeLock.release();
            }
        }
    }
}
