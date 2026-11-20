package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.d0;
import androidx.work.impl.e;
import androidx.work.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import p6.c;
import p6.d;
import s6.m;
import s6.u;
import s6.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class SystemForegroundDispatcher implements c, e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13436l = j.i("SystemFgDispatcher");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f13438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t6.c f13439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f13440d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f13441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<m, androidx.work.e> f13442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<m, u> f13443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<u> f13444i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f13445j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public a f13446k;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(int i11, @NonNull Notification notification);

        void c(int i11, int i12, @NonNull Notification notification);

        void d(int i11);

        void stop();
    }

    public SystemForegroundDispatcher(@NonNull Context context) {
        this.f13437a = context;
        d0 d0VarP = d0.p(context);
        this.f13438b = d0VarP;
        this.f13439c = d0VarP.v();
        this.f13441f = null;
        this.f13442g = new LinkedHashMap();
        this.f13444i = new HashSet();
        this.f13443h = new HashMap();
        this.f13445j = new p6.e(this.f13438b.t(), this);
        this.f13438b.r().g(this);
    }

    @NonNull
    public static Intent d(@NonNull Context context, @NonNull m mVar, @NonNull androidx.work.e eVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", mVar.b());
        intent.putExtra("KEY_GENERATION", mVar.a());
        return intent;
    }

    @NonNull
    public static Intent f(@NonNull Context context, @NonNull m mVar, @NonNull androidx.work.e eVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", mVar.b());
        intent.putExtra("KEY_GENERATION", mVar.a());
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        return intent;
    }

    @NonNull
    public static Intent g(@NonNull Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    @Override // p6.c
    public void b(@NonNull List<u> list) {
        if (list.isEmpty()) {
            return;
        }
        for (u uVar : list) {
            String str = uVar.f76199a;
            j.e().a(f13436l, "Constraints unmet for WorkSpec " + str);
            this.f13438b.C(x.a(uVar));
        }
    }

    @Override // androidx.work.impl.e
    /* JADX INFO: renamed from: c */
    public void l(@NonNull m mVar, boolean z11) {
        Map.Entry<m, androidx.work.e> entry;
        synchronized (this.f13440d) {
            try {
                u uVarRemove = this.f13443h.remove(mVar);
                if (uVarRemove != null && this.f13444i.remove(uVarRemove)) {
                    this.f13445j.a(this.f13444i);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        androidx.work.e eVarRemove = this.f13442g.remove(mVar);
        if (mVar.equals(this.f13441f) && this.f13442g.size() > 0) {
            Iterator<Map.Entry<m, androidx.work.e>> it = this.f13442g.entrySet().iterator();
            Map.Entry<m, androidx.work.e> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.f13441f = entry.getKey();
            if (this.f13446k != null) {
                androidx.work.e value = entry.getValue();
                this.f13446k.c(value.c(), value.a(), value.b());
                this.f13446k.d(value.c());
            }
        }
        a aVar = this.f13446k;
        if (eVarRemove == null || aVar == null) {
            return;
        }
        j.e().a(f13436l, "Removing Notification (id: " + eVarRemove.c() + ", workSpecId: " + mVar + ", notificationType: " + eVarRemove.a());
        aVar.d(eVarRemove.c());
    }

    @Override // p6.c
    public void e(@NonNull List<u> list) {
    }

    public final void h(@NonNull Intent intent) {
        j.e().f(f13436l, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.f13438b.j(UUID.fromString(stringExtra));
    }

    public final void i(@NonNull Intent intent) {
        int iA = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        m mVar = new m(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        j.e().a(f13436l, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification == null || this.f13446k == null) {
            return;
        }
        this.f13442g.put(mVar, new androidx.work.e(intExtra, notification, intExtra2));
        if (this.f13441f == null) {
            this.f13441f = mVar;
            this.f13446k.c(intExtra, intExtra2, notification);
            return;
        }
        this.f13446k.a(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator<Map.Entry<m, androidx.work.e>> it = this.f13442g.entrySet().iterator();
        while (it.hasNext()) {
            iA |= it.next().getValue().a();
        }
        androidx.work.e eVar = this.f13442g.get(this.f13441f);
        if (eVar != null) {
            this.f13446k.c(eVar.c(), iA, eVar.b());
        }
    }

    public final void j(@NonNull Intent intent) {
        j.e().f(f13436l, "Started foreground service " + intent);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        this.f13439c.c(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                u uVarH = SystemForegroundDispatcher.this.f13438b.r().h(stringExtra);
                if (uVarH == null || !uVarH.h()) {
                    return;
                }
                synchronized (SystemForegroundDispatcher.this.f13440d) {
                    SystemForegroundDispatcher.this.f13443h.put(x.a(uVarH), uVarH);
                    SystemForegroundDispatcher.this.f13444i.add(uVarH);
                    SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                    systemForegroundDispatcher.f13445j.a(systemForegroundDispatcher.f13444i);
                }
            }
        });
    }

    public void k(@NonNull Intent intent) {
        j.e().f(f13436l, "Stopping foreground service");
        a aVar = this.f13446k;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public void l() {
        this.f13446k = null;
        synchronized (this.f13440d) {
            this.f13445j.reset();
        }
        this.f13438b.r().n(this);
    }

    public void m(@NonNull Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            j(intent);
            i(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            i(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            h(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            k(intent);
        }
    }

    public void n(@NonNull a aVar) {
        if (this.f13446k != null) {
            j.e().c(f13436l, "A callback already exists.");
        } else {
            this.f13446k = aVar;
        }
    }
}
