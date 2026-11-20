package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f7748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<o> f7751e;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class a {
        public static NotificationChannelGroup a(String str, CharSequence charSequence) {
            return new NotificationChannelGroup(str, charSequence);
        }

        public static List<NotificationChannel> b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getChannels();
        }

        public static String c(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        public static String d(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        public static CharSequence e(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getName();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class b {
        public static String a(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getDescription();
        }

        public static boolean b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.isBlocked();
        }

        public static void c(NotificationChannelGroup notificationChannelGroup, String str) {
            notificationChannelGroup.setDescription(str);
        }
    }

    @RequiresApi(28)
    public q(@NonNull NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    @RequiresApi(26)
    public q(@NonNull NotificationChannelGroup notificationChannelGroup, @NonNull List<NotificationChannel> list) {
        this(a.d(notificationChannelGroup));
        this.f7748b = a.e(notificationChannelGroup);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            this.f7749c = b.a(notificationChannelGroup);
        }
        if (i11 < 28) {
            this.f7751e = a(list);
        } else {
            this.f7750d = b.b(notificationChannelGroup);
            this.f7751e = a(a.b(notificationChannelGroup));
        }
    }

    public q(@NonNull String str) {
        this.f7751e = Collections.emptyList();
        this.f7747a = (String) androidx.core.util.i.g(str);
    }

    @RequiresApi(26)
    public final List<o> a(List<NotificationChannel> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<NotificationChannel> it = list.iterator();
        while (it.hasNext()) {
            NotificationChannel notificationChannelA = p.a(it.next());
            if (this.f7747a.equals(a.c(notificationChannelA))) {
                arrayList.add(new o(notificationChannelA));
            }
        }
        return arrayList;
    }

    public NotificationChannelGroup b() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroupA = a.a(this.f7747a, this.f7748b);
        if (i11 >= 28) {
            b.c(notificationChannelGroupA, this.f7749c);
        }
        return notificationChannelGroupA;
    }
}
