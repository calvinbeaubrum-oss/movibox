package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.transsion.push.PushConstants;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzm implements ServiceConnection {
    zzn zzc;
    final /* synthetic */ zzs zzf;
    int zza = 0;
    final Messenger zzb = new Messenger(new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzf
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            zzm zzmVar = this.zza;
            int i11 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb2 = new StringBuilder(41);
                sb2.append("Received response to request: ");
                sb2.append(i11);
            }
            synchronized (zzmVar) {
                try {
                    zzp<?> zzpVar = zzmVar.zze.get(i11);
                    if (zzpVar == null) {
                        StringBuilder sb3 = new StringBuilder(50);
                        sb3.append("Received response for unknown request: ");
                        sb3.append(i11);
                        Log.w("MessengerIpcClient", sb3.toString());
                        return true;
                    }
                    zzmVar.zze.remove(i11);
                    zzmVar.zzf();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        zzpVar.zzc(new zzq(4, "Not supported by GmsCore", null));
                        return true;
                    }
                    zzpVar.zza(data);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }));
    final Queue<zzp<?>> zzd = new ArrayDeque();
    final SparseArray<zzp<?>> zze = new SparseArray<>();

    public /* synthetic */ zzm(zzs zzsVar, zzl zzlVar) {
        this.zzf = zzsVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzj
            @Override // java.lang.Runnable
            public final void run() {
                zzm zzmVar = this.zza;
                IBinder iBinder2 = iBinder;
                synchronized (zzmVar) {
                    if (iBinder2 == null) {
                        zzmVar.zza(0, "Null service connection");
                        return;
                    }
                    try {
                        zzmVar.zzc = new zzn(iBinder2);
                        zzmVar.zza = 2;
                        zzmVar.zzc();
                    } catch (RemoteException e11) {
                        zzmVar.zza(0, e11.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(2, "Service disconnected");
            }
        });
    }

    public final synchronized void zza(int i11, @Nullable String str) {
        zzb(i11, str, null);
    }

    public final synchronized void zzb(int i11, @Nullable String str, @Nullable Throwable th2) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(str);
                if (strValueOf.length() != 0) {
                    "Disconnected: ".concat(strValueOf);
                }
            }
            int i12 = this.zza;
            if (i12 == 0) {
                throw new IllegalStateException();
            }
            if (i12 != 1 && i12 != 2) {
                if (i12 != 3) {
                    return;
                }
                this.zza = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.zza = 4;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            zzq zzqVar = new zzq(i11, str, th2);
            Iterator<zzp<?>> it = this.zzd.iterator();
            while (it.hasNext()) {
                it.next().zzc(zzqVar);
            }
            this.zzd.clear();
            for (int i13 = 0; i13 < this.zze.size(); i13++) {
                this.zze.valueAt(i13).zzc(zzqVar);
            }
            this.zze.clear();
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final void zzc() {
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzh
            @Override // java.lang.Runnable
            public final void run() {
                final zzp<?> zzpVarPoll;
                final zzm zzmVar = this.zza;
                while (true) {
                    synchronized (zzmVar) {
                        try {
                            if (zzmVar.zza != 2) {
                                return;
                            }
                            if (zzmVar.zzd.isEmpty()) {
                                zzmVar.zzf();
                                return;
                            } else {
                                zzpVarPoll = zzmVar.zzd.poll();
                                zzmVar.zze.put(zzpVarPoll.zza, zzpVarPoll);
                                zzmVar.zzf.zzc.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzk
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzmVar.zze(zzpVarPoll.zza);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String strValueOf = String.valueOf(zzpVarPoll);
                        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 8);
                        sb2.append("Sending ");
                        sb2.append(strValueOf);
                    }
                    Context context = zzmVar.zzf.zzb;
                    Messenger messenger = zzmVar.zzb;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = zzpVarPoll.zzc;
                    messageObtain.arg1 = zzpVarPoll.zza;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", zzpVarPoll.zzb());
                    bundle.putString(PushConstants.PROVIDER_FIELD_PKG, context.getPackageName());
                    bundle.putBundle("data", zzpVarPoll.zzd);
                    messageObtain.setData(bundle);
                    try {
                        zzmVar.zzc.zza(messageObtain);
                    } catch (RemoteException e11) {
                        zzmVar.zza(2, e11.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void zzd() {
        if (this.zza == 1) {
            zza(1, "Timed out while binding");
        }
    }

    public final synchronized void zze(int i11) {
        zzp<?> zzpVar = this.zze.get(i11);
        if (zzpVar != null) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Timing out request: ");
            sb2.append(i11);
            Log.w("MessengerIpcClient", sb2.toString());
            this.zze.remove(i11);
            zzpVar.zzc(new zzq(3, "Timed out waiting for response", null));
            zzf();
        }
    }

    public final synchronized void zzf() {
        try {
            if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.zza = 3;
                ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean zzg(zzp<?> zzpVar) {
        try {
            int i11 = this.zza;
            if (i11 != 0) {
                if (i11 == 1) {
                    this.zzd.add(zzpVar);
                    return true;
                }
                if (i11 != 2) {
                    return false;
                }
                this.zzd.add(zzpVar);
                zzc();
                return true;
            }
            this.zzd.add(zzpVar);
            Preconditions.checkState(this.zza == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.zza = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (ConnectionTracker.getInstance().bindService(this.zzf.zzb, intent, this, 1)) {
                    this.zzf.zzc.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzd();
                        }
                    }, 30L, TimeUnit.SECONDS);
                } else {
                    zza(0, "Unable to bind to service");
                }
            } catch (SecurityException e11) {
                zzb(0, "Unable to bind to service", e11);
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
