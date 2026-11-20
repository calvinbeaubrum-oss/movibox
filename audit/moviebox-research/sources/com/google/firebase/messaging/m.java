package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@KeepForSdk
public class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f40867c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e1 f40868d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f40870b = new b6.m();

    public m(Context context) {
        this.f40869a = context;
    }

    public static Task<Integer> e(Context context, Intent intent, boolean z11) {
        Log.isLoggable("FirebaseMessaging", 3);
        e1 e1VarF = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z11) {
            return e1VarF.c(intent).continueWith(new b6.m(), new Continuation() { // from class: com.google.firebase.messaging.l
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return m.g(task);
                }
            });
        }
        if (q0.b().e(context)) {
            z0.f(context, e1VarF, intent);
        } else {
            e1VarF.c(intent);
        }
        return Tasks.forResult(-1);
    }

    public static e1 f(Context context, String str) {
        e1 e1Var;
        synchronized (f40867c) {
            try {
                if (f40868d == null) {
                    f40868d = new e1(context, str);
                }
                e1Var = f40868d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return e1Var;
    }

    public static /* synthetic */ Integer g(Task task) throws Exception {
        return -1;
    }

    public static /* synthetic */ Integer h(Context context, Intent intent) throws Exception {
        return Integer.valueOf(q0.b().g(context, intent));
    }

    public static /* synthetic */ Integer i(Task task) throws Exception {
        return 403;
    }

    public static /* synthetic */ Task j(Context context, Intent intent, boolean z11, Task task) throws Exception {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? e(context, intent, z11).continueWith(new b6.m(), new Continuation() { // from class: com.google.firebase.messaging.k
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return m.i(task2);
            }
        }) : task;
    }

    @KeepForSdk
    public Task<Integer> k(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return l(this.f40869a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> l(final Context context, final Intent intent) {
        boolean z11 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z12 = (intent.getFlags() & ASTNode.DEOP) != 0;
        return (!z11 || z12) ? Tasks.call(this.f40870b, new Callable() { // from class: com.google.firebase.messaging.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m.h(context, intent);
            }
        }).continueWithTask(this.f40870b, new Continuation() { // from class: com.google.firebase.messaging.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return m.j(context, intent, z12, task);
            }
        }) : e(context, intent, z12);
    }
}
