package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.v0;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Rpc {
    private static int zza;
    private static PendingIntent zzb;
    private static final Executor zzc = new Executor() { // from class: com.google.android.gms.cloudmessaging.zzz
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private static final Pattern zzd = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    private final Context zzf;
    private final zzt zzg;
    private final ScheduledExecutorService zzh;
    private Messenger zzj;
    private zzd zzk;
    private final v0<String, TaskCompletionSource<Bundle>> zze = new v0<>();
    private Messenger zzi = new Messenger(new zzaa(this, Looper.getMainLooper()));

    public Rpc(@NonNull Context context) {
        this.zzf = context;
        this.zzg = new zzt(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzh = scheduledThreadPoolExecutor;
    }

    public static /* synthetic */ Task zza(Bundle bundle) throws Exception {
        return zzi(bundle) ? Tasks.forResult(null) : Tasks.forResult(bundle);
    }

    public static /* bridge */ /* synthetic */ void zzc(Rpc rpc, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzc());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.zzk = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.zzj = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String strValueOf = String.valueOf(action);
                        if (strValueOf.length() != 0) {
                            "Unexpected response action: ".concat(strValueOf);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = zzd.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (!Log.isLoggable("Rpc", 3) || stringExtra.length() == 0) {
                            return;
                        }
                        "Unexpected response string: ".concat(stringExtra);
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        rpc.zzh(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String strValueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 49);
                    sb2.append("Unexpected response, no error or registration id ");
                    sb2.append(strValueOf2);
                    Log.w("Rpc", sb2.toString());
                    return;
                }
                if (Log.isLoggable("Rpc", 3) && stringExtra2.length() != 0) {
                    "Received InstanceID error ".concat(stringExtra2);
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (rpc.zze) {
                        for (int i11 = 0; i11 < rpc.zze.size(); i11++) {
                            try {
                                rpc.zzh(rpc.zze.keyAt(i11), intent2.getExtras());
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !"ID".equals(strArrSplit[1])) {
                    Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
                rpc.zzh(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b7  */
    private final Task<Bundle> zze(Bundle bundle) {
        final String strZzf = zzf();
        final TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.zze) {
            this.zze.put(strZzf, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.zzg.zzb() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        zzg(this.zzf, intent);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strZzf).length() + 5);
        sb2.append("|ID|");
        sb2.append(strZzf);
        sb2.append("|");
        intent.putExtra("kid", sb2.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            StringBuilder sb3 = new StringBuilder(strValueOf.length() + 8);
            sb3.append("Sending ");
            sb3.append(strValueOf);
        }
        intent.putExtra("google.messenger", this.zzi);
        if (this.zzj != null || this.zzk != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.zzj;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    this.zzk.zzb(messageObtain);
                }
            } catch (RemoteException unused) {
                Log.isLoggable("Rpc", 3);
                if (this.zzg.zzb() == 2) {
                    this.zzf.sendBroadcast(intent);
                } else {
                    this.zzf.startService(intent);
                }
            }
        } else if (this.zzg.zzb() == 2) {
            this.zzf.sendBroadcast(intent);
        } else {
            this.zzf.startService(intent);
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.zzh.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzy
            @Override // java.lang.Runnable
            public final void run() {
                if (taskCompletionSource.trySetException(new IOException(InstanceID.ERROR_TIMEOUT))) {
                    Log.w("Rpc", "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.getTask().addOnCompleteListener(zzc, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzw
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzd(strZzf, scheduledFutureSchedule, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    private static synchronized String zzf() {
        int i11;
        i11 = zza;
        zza = i11 + 1;
        return Integer.toString(i11);
    }

    private static synchronized void zzg(Context context, Intent intent) {
        try {
            if (zzb == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzb = com.google.android.gms.internal.cloudmessaging.zza.zza(context, 0, intent2, com.google.android.gms.internal.cloudmessaging.zza.zza);
            }
            intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, zzb);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final void zzh(String str, @Nullable Bundle bundle) {
        synchronized (this.zze) {
            try {
                TaskCompletionSource<Bundle> taskCompletionSourceRemove = this.zze.remove(str);
                if (taskCompletionSourceRemove != null) {
                    taskCompletionSourceRemove.setResult(bundle);
                } else {
                    String strValueOf = String.valueOf(str);
                    Log.w("Rpc", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean zzi(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    @NonNull
    public Task<Bundle> send(@NonNull final Bundle bundle) {
        if (this.zzg.zza() < 12000000) {
            return this.zzg.zzb() != 0 ? zze(bundle).continueWithTask(zzc, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzu
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zzb(bundle, task);
                }
            }) : Tasks.forException(new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE));
        }
        return zzs.zzb(this.zzf).zzd(1, bundle).continueWith(zzc, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzv
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws IOException {
                if (task.isSuccessful()) {
                    return (Bundle) task.getResult();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    String strValueOf = String.valueOf(task.getException());
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 22);
                    sb2.append("Error making request: ");
                    sb2.append(strValueOf);
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", task.getException());
            }
        });
    }

    @NonNull
    public final /* synthetic */ Task zzb(@NonNull Bundle bundle, @NonNull Task task) throws Exception {
        return (task.isSuccessful() && zzi((Bundle) task.getResult())) ? zze(bundle).onSuccessTask(zzc, new SuccessContinuation() { // from class: com.google.android.gms.cloudmessaging.zzx
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Rpc.zza((Bundle) obj);
            }
        }) : task;
    }

    public final /* synthetic */ void zzd(@NonNull String str, @NonNull ScheduledFuture scheduledFuture, @NonNull Task task) {
        synchronized (this.zze) {
            this.zze.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
