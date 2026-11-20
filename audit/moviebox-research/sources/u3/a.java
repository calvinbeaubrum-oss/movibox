package u3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f78178f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f78179g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f78180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f78181b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f78182c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f78183d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f78184e;

    /* JADX INFO: renamed from: u3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class HandlerC0859a extends Handler {
        public HandlerC0859a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f78186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f78187b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f78186a = intent;
            this.f78187b = arrayList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f78188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f78189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f78190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f78191d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f78188a = intentFilter;
            this.f78189b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f78189b);
            sb2.append(" filter=");
            sb2.append(this.f78188a);
            if (this.f78191d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    public a(Context context) {
        this.f78180a = context;
        this.f78184e = new HandlerC0859a(context.getMainLooper());
    }

    @NonNull
    public static a b(@NonNull Context context) {
        a aVar;
        synchronized (f78178f) {
            try {
                if (f78179g == null) {
                    f78179g = new a(context.getApplicationContext());
                }
                aVar = f78179g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f78181b) {
                try {
                    size = this.f78183d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f78183d.toArray(bVarArr);
                    this.f78183d.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = bVarArr[i11];
                int size2 = bVar.f78187b.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    c cVar = bVar.f78187b.get(i12);
                    if (!cVar.f78191d) {
                        cVar.f78189b.onReceive(this.f78180a, bVar.f78186a);
                    }
                }
            }
        }
    }

    public void c(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f78181b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList<c> arrayList = this.f78181b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f78181b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                    String action = intentFilter.getAction(i11);
                    ArrayList<c> arrayList2 = this.f78182c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f78182c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d(@NonNull Intent intent) {
        int i11;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        String str3;
        synchronized (this.f78181b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f78180a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z11 = (intent.getFlags() & 8) != 0;
                if (z11) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<c> arrayList3 = this.f78182c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z11) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i12 = 0;
                    while (i12 < arrayList3.size()) {
                        c cVar = arrayList3.get(i12);
                        if (z11) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f78188a);
                        }
                        if (cVar.f78190c) {
                            if (z11) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i11 = i12;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = strResolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i11 = i12;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = strResolveTypeIfNeeded;
                            int iMatch = cVar.f78188a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z11) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(cVar);
                                cVar.f78190c = true;
                            } else if (z11) {
                                if (iMatch == -4) {
                                    str3 = "category";
                                } else if (iMatch == -3) {
                                    str3 = "action";
                                } else if (iMatch != -2) {
                                    str3 = iMatch != -1 ? "unknown reason" : "type";
                                } else {
                                    str3 = "data";
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str3);
                            }
                            i12 = i11 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        }
                        arrayList4 = arrayList;
                        i12 = i11 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i13 = 0; i13 < arrayList5.size(); i13++) {
                            ((c) arrayList5.get(i13)).f78190c = false;
                        }
                        this.f78183d.add(new b(intent, arrayList5));
                        if (!this.f78184e.hasMessages(1)) {
                            this.f78184e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.f78181b) {
            try {
                ArrayList<c> arrayListRemove = this.f78181b.remove(broadcastReceiver);
                if (arrayListRemove == null) {
                    return;
                }
                for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                    c cVar = arrayListRemove.get(size);
                    cVar.f78191d = true;
                    for (int i11 = 0; i11 < cVar.f78188a.countActions(); i11++) {
                        String action = cVar.f78188a.getAction(i11);
                        ArrayList<c> arrayList = this.f78182c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f78189b == broadcastReceiver) {
                                    cVar2.f78191d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f78182c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
