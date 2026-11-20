package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static String sEnabledNotificationListeners;
    private static j sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    private static final Object sEnabledNotificationListenersLock = new Object();
    private static Set<String> sEnabledNotificationListenerPackages = new HashSet();
    private static final Object sLock = new Object();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(23)
    public static class a {
        public static List<StatusBarNotification> a(NotificationManager notificationManager) {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            return activeNotifications == null ? new ArrayList() : Arrays.asList(activeNotifications);
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getCurrentInterruptionFilter();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(24)
    public static class b {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(26)
    public static class c {
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        public static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        public static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        public static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        public static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        public static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        public static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        public static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        public static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        public static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(28)
    public static class d {
        public static NotificationChannelGroup a(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannelGroup(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(30)
    public static class e {
        public static NotificationChannel a(NotificationManager notificationManager, String str, String str2) {
            return notificationManager.getNotificationChannel(str, str2);
        }

        public static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(34)
    public static class f {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Notification f7670c;
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class h implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f7674d;

        public h(String str, int i11, String str2, Notification notification) {
            this.f7671a = str;
            this.f7672b = i11;
            this.f7673c = str2;
            this.f7674d = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.k
        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f7671a, this.f7672b, this.f7673c, this.f7674d);
        }

        @NonNull
        public String toString() {
            return "NotifyTask[packageName:" + this.f7671a + ", id:" + this.f7672b + ", tag:" + this.f7673c + "]";
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f7675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f7676b;

        public i(ComponentName componentName, IBinder iBinder) {
            this.f7675a = componentName;
            this.f7676b = iBinder;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class j implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f7678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f7679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<ComponentName, a> f7680d = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Set<String> f7681f = new HashSet();

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f7682a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public INotificationSideChannel f7684c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f7683b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque<k> f7685d = new ArrayDeque<>();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f7686e = 0;

            public a(ComponentName componentName) {
                this.f7682a = componentName;
            }
        }

        public j(Context context) {
            this.f7677a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f7678b = handlerThread;
            handlerThread.start();
            this.f7679c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f7683b) {
                return true;
            }
            boolean zBindService = this.f7677a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(aVar.f7682a), this, 33);
            aVar.f7683b = zBindService;
            if (zBindService) {
                aVar.f7686e = 0;
            } else {
                Log.w(NotificationManagerCompat.TAG, "Unable to bind to listener " + aVar.f7682a);
                this.f7677a.unbindService(this);
            }
            return aVar.f7683b;
        }

        public final void b(a aVar) {
            if (aVar.f7683b) {
                this.f7677a.unbindService(this);
                aVar.f7683b = false;
            }
            aVar.f7684c = null;
        }

        public final void c(k kVar) {
            j();
            for (a aVar : this.f7680d.values()) {
                aVar.f7685d.add(kVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = this.f7680d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f7680d.get(componentName);
            if (aVar != null) {
                aVar.f7684c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f7686e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = this.f7680d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Processing component ");
                sb2.append(aVar.f7682a);
                sb2.append(", ");
                sb2.append(aVar.f7685d.size());
                sb2.append(" queued tasks");
            }
            if (aVar.f7685d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f7684c == null) {
                i(aVar);
                return;
            }
            while (true) {
                k kVarPeek = aVar.f7685d.peek();
                if (kVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Sending task ");
                        sb3.append(kVarPeek);
                    }
                    kVarPeek.a(aVar.f7684c);
                    aVar.f7685d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Remote service has died: ");
                        sb4.append(aVar.f7682a);
                    }
                } catch (RemoteException e11) {
                    Log.w(NotificationManagerCompat.TAG, "RemoteException communicating with " + aVar.f7682a, e11);
                }
            }
            if (aVar.f7685d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(k kVar) {
            this.f7679c.obtainMessage(0, kVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                c((k) message.obj);
                return true;
            }
            if (i11 == 1) {
                i iVar = (i) message.obj;
                e(iVar.f7675a, iVar.f7676b);
                return true;
            }
            if (i11 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i11 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f7679c.hasMessages(3, aVar.f7682a)) {
                return;
            }
            int i11 = aVar.f7686e;
            int i12 = i11 + 1;
            aVar.f7686e = i12;
            if (i12 <= 6) {
                int i13 = (1 << i11) * 1000;
                if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Scheduling retry for ");
                    sb2.append(i13);
                    sb2.append(" ms");
                }
                this.f7679c.sendMessageDelayed(this.f7679c.obtainMessage(3, aVar.f7682a), i13);
                return;
            }
            Log.w(NotificationManagerCompat.TAG, "Giving up on delivering " + aVar.f7685d.size() + " tasks to " + aVar.f7682a + " after " + aVar.f7686e + " retries");
            aVar.f7685d.clear();
        }

        public final void j() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f7677a);
            if (enabledListenerPackages.equals(this.f7681f)) {
                return;
            }
            this.f7681f = enabledListenerPackages;
            List<ResolveInfo> listQueryIntentServices = this.f7677a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w(NotificationManagerCompat.TAG, "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f7680d.containsKey(componentName2)) {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding listener record for ");
                        sb2.append(componentName2);
                    }
                    this.f7680d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f7680d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Removing listener record for ");
                        sb3.append(next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Connected to service ");
                sb2.append(componentName);
            }
            this.f7679c.obtainMessage(1, new i(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Disconnected from service ");
                sb2.append(componentName);
            }
            this.f7679c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface k {
        void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public NotificationManagerCompat(@NonNull NotificationManager notificationManager, @NonNull Context context) {
        this.mContext = context;
        this.mNotificationManager = notificationManager;
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        synchronized (sEnabledNotificationListenersLock) {
            if (string != null) {
                try {
                    if (!string.equals(sEnabledNotificationListeners)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        sEnabledNotificationListenerPackages = hashSet;
                        sEnabledNotificationListeners = string;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            set = sEnabledNotificationListenerPackages;
        }
        return set;
    }

    private void pushSideChannelQueue(k kVar) {
        synchronized (sLock) {
            try {
                if (sSideChannelManager == null) {
                    sSideChannelManager = new j(this.mContext.getApplicationContext());
                }
                sSideChannelManager.h(kVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(this.mNotificationManager);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        String packageName = this.mContext.getApplicationContext().getPackageName();
        int i11 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod(CHECK_OP_NO_THROW, cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i11), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public boolean canUseFullScreenIntent() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 29) {
            return true;
        }
        if (i11 < 34) {
            return this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0;
        }
        return f.a(this.mNotificationManager);
    }

    public void cancel(int i11) {
        cancel(null, i11);
    }

    public void cancel(@Nullable String str, int i11) {
        this.mNotificationManager.cancel(str, i11);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.a(this.mNotificationManager, notificationChannel);
        }
    }

    public void createNotificationChannel(@NonNull o oVar) {
        createNotificationChannel(oVar.a());
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.b(this.mNotificationManager, notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroup(@NonNull q qVar) {
        createNotificationChannelGroup(qVar.b());
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.c(this.mNotificationManager, list);
        }
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<q> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<q> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        c.c(this.mNotificationManager, arrayList);
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.d(this.mNotificationManager, list);
        }
    }

    public void createNotificationChannelsCompat(@NonNull List<o> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<o> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        c.d(this.mNotificationManager, arrayList);
    }

    public void deleteNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.e(this.mNotificationManager, str);
        }
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.f(this.mNotificationManager, str);
        }
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            Iterator<NotificationChannel> it = c.k(this.mNotificationManager).iterator();
            while (it.hasNext()) {
                NotificationChannel notificationChannelA = v.a(it.next());
                if (!collection.contains(c.g(notificationChannelA)) && (Build.VERSION.SDK_INT < 30 || !collection.contains(e.b(notificationChannelA)))) {
                    c.e(this.mNotificationManager, c.g(notificationChannelA));
                }
            }
        }
    }

    @NonNull
    public List<StatusBarNotification> getActiveNotifications() {
        return Build.VERSION.SDK_INT >= 23 ? a.a(this.mNotificationManager) : new ArrayList();
    }

    public int getCurrentInterruptionFilter() {
        if (Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        return a.b(this.mNotificationManager);
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.b(this.mNotificationManager);
        }
        return -1000;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.i(this.mNotificationManager, str);
        }
        return null;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str, @NonNull String str2) {
        return Build.VERSION.SDK_INT >= 30 ? e.a(this.mNotificationManager, str, str2) : getNotificationChannel(str);
    }

    @Nullable
    public o getNotificationChannelCompat(@NonNull String str) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str)) == null) {
            return null;
        }
        return new o(notificationChannel);
    }

    @Nullable
    public o getNotificationChannelCompat(@NonNull String str, @NonNull String str2) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str, str2)) == null) {
            return null;
        }
        return new o(notificationChannel);
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return d.a(this.mNotificationManager, str);
        }
        if (i11 >= 26) {
            Iterator<NotificationChannelGroup> it = getNotificationChannelGroups().iterator();
            while (it.hasNext()) {
                NotificationChannelGroup notificationChannelGroupA = x.a(it.next());
                if (c.h(notificationChannelGroupA).equals(str)) {
                    return notificationChannelGroupA;
                }
            }
        }
        return null;
    }

    @Nullable
    public q getNotificationChannelGroupCompat(@NonNull String str) {
        NotificationChannelGroup notificationChannelGroup;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            NotificationChannelGroup notificationChannelGroup2 = getNotificationChannelGroup(str);
            if (notificationChannelGroup2 != null) {
                return new q(notificationChannelGroup2);
            }
            return null;
        }
        if (i11 < 26 || (notificationChannelGroup = getNotificationChannelGroup(str)) == null) {
            return null;
        }
        return new q(notificationChannelGroup, getNotificationChannels());
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return Build.VERSION.SDK_INT >= 26 ? c.j(this.mNotificationManager) : Collections.emptyList();
    }

    @NonNull
    public List<q> getNotificationChannelGroupsCompat() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            List<NotificationChannelGroup> notificationChannelGroups = getNotificationChannelGroups();
            if (!notificationChannelGroups.isEmpty()) {
                List<NotificationChannel> listEmptyList = i11 >= 28 ? Collections.emptyList() : getNotificationChannels();
                ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
                Iterator<NotificationChannelGroup> it = notificationChannelGroups.iterator();
                while (it.hasNext()) {
                    NotificationChannelGroup notificationChannelGroupA = x.a(it.next());
                    if (Build.VERSION.SDK_INT >= 28) {
                        arrayList.add(new q(notificationChannelGroupA));
                    } else {
                        arrayList.add(new q(notificationChannelGroupA, listEmptyList));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        return Build.VERSION.SDK_INT >= 26 ? c.k(this.mNotificationManager) : Collections.emptyList();
    }

    @NonNull
    public List<o> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = getNotificationChannels();
            if (!notificationChannels.isEmpty()) {
                ArrayList arrayList = new ArrayList(notificationChannels.size());
                Iterator<NotificationChannel> it = notificationChannels.iterator();
                while (it.hasNext()) {
                    arrayList.add(new o(v.a(it.next())));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(int i11, @NonNull Notification notification) {
        notify(null, i11, notification);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@Nullable String str, int i11, @NonNull Notification notification) {
        if (!useSideChannelForNotification(notification)) {
            this.mNotificationManager.notify(str, i11, notification);
        } else {
            pushSideChannelQueue(new h(this.mContext.getPackageName(), i11, str, notification));
            this.mNotificationManager.cancel(str, i11);
        }
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@NonNull List<g> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = list.get(i11);
            notify(gVar.f7668a, gVar.f7669b, gVar.f7670c);
        }
    }
}
