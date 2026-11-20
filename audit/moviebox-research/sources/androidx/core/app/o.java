package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f7729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f7730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Uri f7735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioAttributes f7736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long[] f7740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f7742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7745q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7746r;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class a {
        public static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        public static boolean b(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        public static NotificationChannel c(String str, CharSequence charSequence, int i11) {
            return new NotificationChannel(str, charSequence, i11);
        }

        public static void d(NotificationChannel notificationChannel, boolean z11) {
            notificationChannel.enableLights(z11);
        }

        public static void e(NotificationChannel notificationChannel, boolean z11) {
            notificationChannel.enableVibration(z11);
        }

        public static AudioAttributes f(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        public static String h(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        public static String i(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        public static int j(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        public static int k(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        public static int l(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        public static CharSequence m(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        public static Uri n(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        public static long[] o(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        public static void p(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        public static void q(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        public static void r(NotificationChannel notificationChannel, int i11) {
            notificationChannel.setLightColor(i11);
        }

        public static void s(NotificationChannel notificationChannel, boolean z11) {
            notificationChannel.setShowBadge(z11);
        }

        public static void t(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        public static void u(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }

        public static boolean v(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        public static boolean w(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class b {
        public static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class c {
        public static String a(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        public static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        public static boolean c(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        public static void d(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }
    }

    @RequiresApi(26)
    public o(@NonNull NotificationChannel notificationChannel) {
        this(a.i(notificationChannel), a.j(notificationChannel));
        this.f7730b = a.m(notificationChannel);
        this.f7732d = a.g(notificationChannel);
        this.f7733e = a.h(notificationChannel);
        this.f7734f = a.b(notificationChannel);
        this.f7735g = a.n(notificationChannel);
        this.f7736h = a.f(notificationChannel);
        this.f7737i = a.v(notificationChannel);
        this.f7738j = a.k(notificationChannel);
        this.f7739k = a.w(notificationChannel);
        this.f7740l = a.o(notificationChannel);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.f7741m = c.b(notificationChannel);
            this.f7742n = c.a(notificationChannel);
        }
        this.f7743o = a.a(notificationChannel);
        this.f7744p = a.l(notificationChannel);
        if (i11 >= 29) {
            this.f7745q = b.a(notificationChannel);
        }
        if (i11 >= 30) {
            this.f7746r = c.c(notificationChannel);
        }
    }

    public o(@NonNull String str, int i11) {
        this.f7734f = true;
        this.f7735g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.f7738j = 0;
        this.f7729a = (String) androidx.core.util.i.g(str);
        this.f7731c = i11;
        this.f7736h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public NotificationChannel a() {
        String str;
        String str2;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return null;
        }
        NotificationChannel notificationChannelC = a.c(this.f7729a, this.f7730b, this.f7731c);
        a.p(notificationChannelC, this.f7732d);
        a.q(notificationChannelC, this.f7733e);
        a.s(notificationChannelC, this.f7734f);
        a.t(notificationChannelC, this.f7735g, this.f7736h);
        a.d(notificationChannelC, this.f7737i);
        a.r(notificationChannelC, this.f7738j);
        a.u(notificationChannelC, this.f7740l);
        a.e(notificationChannelC, this.f7739k);
        if (i11 >= 30 && (str = this.f7741m) != null && (str2 = this.f7742n) != null) {
            c.d(notificationChannelC, str, str2);
        }
        return notificationChannelC;
    }
}
