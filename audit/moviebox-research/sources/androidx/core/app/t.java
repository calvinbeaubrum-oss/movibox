package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f7753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NotificationCompat.m f7754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f7755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f7756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Bundle> f7757f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f7758g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f7760i;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(20)
    public static class a {
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder e(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i11, charSequence, pendingIntent);
        }

        public static String f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z11) {
            return builder.setGroupSummary(z11);
        }

        public static Notification.Builder i(Notification.Builder builder, boolean z11) {
            return builder.setLocalOnly(z11);
        }

        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class b {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i11) {
            return builder.setColor(i11);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i11) {
            return builder.setVisibility(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class c {
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class d {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z11) {
            return builder.setAllowGeneratedReplies(z11);
        }

        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class e {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i11) {
            return builder.setBadgeIconType(i11);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z11) {
            return builder.setColorized(z11);
        }

        public static Notification.Builder d(Notification.Builder builder, int i11) {
            return builder.setGroupAlertBehavior(i11);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j11) {
            return builder.setTimeoutAfter(j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i11) {
            return builder.setSemanticAction(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class g {
        public static Notification.Builder a(Notification.Builder builder, boolean z11) {
            return builder.setAllowSystemGeneratedContextualActions(z11);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z11) {
            return builder.setContextual(z11);
        }

        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static class h {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z11) {
            return builder.setAuthenticationRequired(z11);
        }

        public static Notification.Builder b(Notification.Builder builder, int i11) {
            return builder.setForegroundServiceBehavior(i11);
        }
    }

    public t(NotificationCompat.m mVar) {
        int i11;
        Object obj;
        this.f7754c = mVar;
        Context context = mVar.f7628a;
        this.f7752a = context;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 26) {
            this.f7753b = e.a(context, mVar.L);
        } else {
            this.f7753b = new Notification.Builder(mVar.f7628a);
        }
        Notification notification = mVar.U;
        this.f7753b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, mVar.f7636i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(mVar.f7632e).setContentText(mVar.f7633f).setContentInfo(mVar.f7638k).setContentIntent(mVar.f7634g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(mVar.f7635h, (notification.flags & 128) != 0).setNumber(mVar.f7639l).setProgress(mVar.f7648u, mVar.f7649v, mVar.f7650w);
        if (i12 < 23) {
            Notification.Builder builder = this.f7753b;
            IconCompat iconCompat = mVar.f7637j;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.m());
        } else {
            Notification.Builder builder2 = this.f7753b;
            IconCompat iconCompat2 = mVar.f7637j;
            c.b(builder2, iconCompat2 == null ? null : iconCompat2.z(context));
        }
        this.f7753b.setSubText(mVar.f7645r).setUsesChronometer(mVar.f7642o).setPriority(mVar.f7640m);
        NotificationCompat.p pVar = mVar.f7644q;
        if (pVar instanceof NotificationCompat.n) {
            Iterator<NotificationCompat.b> it = ((NotificationCompat.n) pVar).q().iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        } else {
            Iterator<NotificationCompat.b> it2 = mVar.f7629b.iterator();
            while (it2.hasNext()) {
                b(it2.next());
            }
        }
        Bundle bundle = mVar.E;
        if (bundle != null) {
            this.f7758g.putAll(bundle);
        }
        int i13 = Build.VERSION.SDK_INT;
        this.f7755d = mVar.I;
        this.f7756e = mVar.J;
        this.f7753b.setShowWhen(mVar.f7641n);
        a.i(this.f7753b, mVar.A);
        a.g(this.f7753b, mVar.f7651x);
        a.j(this.f7753b, mVar.f7653z);
        a.h(this.f7753b, mVar.f7652y);
        this.f7759h = mVar.Q;
        b.b(this.f7753b, mVar.D);
        b.c(this.f7753b, mVar.F);
        b.f(this.f7753b, mVar.G);
        b.d(this.f7753b, mVar.H);
        b.e(this.f7753b, notification.sound, notification.audioAttributes);
        List listE = i13 < 28 ? e(g(mVar.f7630c), mVar.X) : mVar.X;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                b.a(this.f7753b, (String) it3.next());
            }
        }
        this.f7760i = mVar.K;
        if (mVar.f7631d.size() > 0) {
            Bundle bundle2 = mVar.g().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i14 = 0; i14 < mVar.f7631d.size(); i14++) {
                bundle4.putBundle(Integer.toString(i14), u.e(mVar.f7631d.get(i14)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            mVar.g().putBundle("android.car.EXTENSIONS", bundle2);
            this.f7758g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i15 = Build.VERSION.SDK_INT;
        if (i15 >= 23 && (obj = mVar.W) != null) {
            c.c(this.f7753b, obj);
        }
        if (i15 >= 24) {
            this.f7753b.setExtras(mVar.E);
            d.e(this.f7753b, mVar.f7647t);
            RemoteViews remoteViews = mVar.I;
            if (remoteViews != null) {
                d.c(this.f7753b, remoteViews);
            }
            RemoteViews remoteViews2 = mVar.J;
            if (remoteViews2 != null) {
                d.b(this.f7753b, remoteViews2);
            }
            RemoteViews remoteViews3 = mVar.K;
            if (remoteViews3 != null) {
                d.d(this.f7753b, remoteViews3);
            }
        }
        if (i15 >= 26) {
            e.b(this.f7753b, mVar.M);
            e.e(this.f7753b, mVar.f7646s);
            e.f(this.f7753b, mVar.N);
            e.g(this.f7753b, mVar.P);
            e.d(this.f7753b, mVar.Q);
            if (mVar.C) {
                e.c(this.f7753b, mVar.B);
            }
            if (!TextUtils.isEmpty(mVar.L)) {
                this.f7753b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i15 >= 28) {
            Iterator<a0> it4 = mVar.f7630c.iterator();
            while (it4.hasNext()) {
                f.a(this.f7753b, it4.next().i());
            }
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 29) {
            g.a(this.f7753b, mVar.S);
            g.b(this.f7753b, NotificationCompat.l.k(mVar.T));
            z2.c cVar = mVar.O;
            if (cVar != null) {
                g.d(this.f7753b, cVar.b());
            }
        }
        if (i16 >= 31 && (i11 = mVar.R) != 0) {
            h.b(this.f7753b, i11);
        }
        if (mVar.V) {
            if (this.f7754c.f7652y) {
                this.f7759h = 2;
            } else {
                this.f7759h = 1;
            }
            this.f7753b.setVibrate(null);
            this.f7753b.setSound(null);
            int i17 = notification.defaults & (-4);
            notification.defaults = i17;
            this.f7753b.setDefaults(i17);
            if (i16 >= 26) {
                if (TextUtils.isEmpty(this.f7754c.f7651x)) {
                    a.g(this.f7753b, NotificationCompat.GROUP_KEY_SILENT);
                }
                e.d(this.f7753b, this.f7759h);
            }
        }
    }

    @Nullable
    public static List<String> e(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.b bVar = new androidx.collection.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    @Nullable
    public static List<String> g(@Nullable List<a0> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<a0> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().h());
        }
        return arrayList;
    }

    @Override // androidx.core.app.n
    public Notification.Builder a() {
        return this.f7753b;
    }

    public final void b(NotificationCompat.b bVar) {
        int i11 = Build.VERSION.SDK_INT;
        IconCompat iconCompatD = bVar.d();
        Notification.Action.Builder builderA = i11 >= 23 ? c.a(iconCompatD != null ? iconCompatD.y() : null, bVar.h(), bVar.a()) : a.e(iconCompatD != null ? iconCompatD.n() : 0, bVar.h(), bVar.a());
        if (bVar.e() != null) {
            for (RemoteInput remoteInput : c0.b(bVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = bVar.c() != null ? new Bundle(bVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", bVar.b());
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 24) {
            d.a(builderA, bVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", bVar.f());
        if (i12 >= 28) {
            f.b(builderA, bVar.f());
        }
        if (i12 >= 29) {
            g.c(builderA, bVar.j());
        }
        if (i12 >= 31) {
            h.a(builderA, bVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", bVar.g());
        a.b(builderA, bundle);
        a.a(this.f7753b, a.d(builderA));
    }

    public Notification c() {
        Bundle extras;
        RemoteViews remoteViewsO;
        RemoteViews remoteViewsM;
        NotificationCompat.p pVar = this.f7754c.f7644q;
        if (pVar != null) {
            pVar.b(this);
        }
        RemoteViews remoteViewsN = pVar != null ? pVar.n(this) : null;
        Notification notificationD = d();
        if (remoteViewsN != null) {
            notificationD.contentView = remoteViewsN;
        } else {
            RemoteViews remoteViews = this.f7754c.I;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (pVar != null && (remoteViewsM = pVar.m(this)) != null) {
            notificationD.bigContentView = remoteViewsM;
        }
        if (pVar != null && (remoteViewsO = this.f7754c.f7644q.o(this)) != null) {
            notificationD.headsUpContentView = remoteViewsO;
        }
        if (pVar != null && (extras = NotificationCompat.getExtras(notificationD)) != null) {
            pVar.a(extras);
        }
        return notificationD;
    }

    public Notification d() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            return this.f7753b.build();
        }
        if (i11 >= 24) {
            Notification notificationBuild = this.f7753b.build();
            if (this.f7759h != 0) {
                if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f7759h == 2) {
                    h(notificationBuild);
                }
                if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f7759h == 1) {
                    h(notificationBuild);
                }
            }
            return notificationBuild;
        }
        this.f7753b.setExtras(this.f7758g);
        Notification notificationBuild2 = this.f7753b.build();
        RemoteViews remoteViews = this.f7755d;
        if (remoteViews != null) {
            notificationBuild2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f7756e;
        if (remoteViews2 != null) {
            notificationBuild2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f7760i;
        if (remoteViews3 != null) {
            notificationBuild2.headsUpContentView = remoteViews3;
        }
        if (this.f7759h != 0) {
            if (a.f(notificationBuild2) != null && (notificationBuild2.flags & 512) != 0 && this.f7759h == 2) {
                h(notificationBuild2);
            }
            if (a.f(notificationBuild2) != null && (notificationBuild2.flags & 512) == 0 && this.f7759h == 1) {
                h(notificationBuild2);
            }
        }
        return notificationBuild2;
    }

    public Context f() {
        return this.f7752a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }
}
