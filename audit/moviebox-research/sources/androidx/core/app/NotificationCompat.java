package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.R$color;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$id;
import androidx.core.R$integer;
import androidx.core.R$layout;
import androidx.core.R$string;
import androidx.core.graphics.drawable.IconCompat;
import com.vungle.warren.error.VungleException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BIG_TEXT = "android.bigText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON = "android.callPerson";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_TYPE = "android.callType";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COLORIZED = "android.colorized";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_INFO_TEXT = "android.infoText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGES = "android.messages";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE = "android.picture";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS = "android.progress";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SMALL_ICON = "android.icon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUB_TEXT = "android.subText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEMPLATE = "android.template";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT = "android.text";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT_LINES = "android.textLines";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE = "android.title";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE_BIG = "android.title.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";

    @SuppressLint({"ActionValue"})
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f7586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public IconCompat f7587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0[] f7588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c0[] f7589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7590e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7592g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f7593h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f7594i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f7595j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public PendingIntent f7596k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f7597l;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f7598a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f7599b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f7600c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f7601d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f7602e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList<c0> f7603f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f7604g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f7605h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f7606i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f7607j;

            public a(int i11, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(i11 != 0 ? IconCompat.l(null, "", i11) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public a(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public a(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @NonNull Bundle bundle, @Nullable c0[] c0VarArr, boolean z11, int i11, boolean z12, boolean z13, boolean z14) {
                this.f7601d = true;
                this.f7605h = true;
                this.f7598a = iconCompat;
                this.f7599b = m.k(charSequence);
                this.f7600c = pendingIntent;
                this.f7602e = bundle;
                this.f7603f = c0VarArr == null ? null : new ArrayList<>(Arrays.asList(c0VarArr));
                this.f7601d = z11;
                this.f7604g = i11;
                this.f7605h = z12;
                this.f7606i = z13;
                this.f7607j = z14;
            }

            @NonNull
            public b a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<c0> arrayList3 = this.f7603f;
                if (arrayList3 != null) {
                    for (c0 c0Var : arrayList3) {
                        if (c0Var.j()) {
                            arrayList.add(c0Var);
                        } else {
                            arrayList2.add(c0Var);
                        }
                    }
                }
                return new b(this.f7598a, this.f7599b, this.f7600c, this.f7602e, arrayList2.isEmpty() ? null : (c0[]) arrayList2.toArray(new c0[arrayList2.size()]), arrayList.isEmpty() ? null : (c0[]) arrayList.toArray(new c0[arrayList.size()]), this.f7601d, this.f7604g, this.f7605h, this.f7606i, this.f7607j);
            }

            public final void b() {
                if (this.f7606i && this.f7600c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }
        }

        public b(int i11, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(i11 != 0 ? IconCompat.l(null, "", i11) : null, charSequence, pendingIntent);
        }

        public b(int i11, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable c0[] c0VarArr, @Nullable c0[] c0VarArr2, boolean z11, int i12, boolean z12, boolean z13, boolean z14) {
            this(i11 != 0 ? IconCompat.l(null, "", i11) : null, charSequence, pendingIntent, bundle, c0VarArr, c0VarArr2, z11, i12, z12, z13, z14);
        }

        public b(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (c0[]) null, (c0[]) null, true, 0, true, false, false);
        }

        public b(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable c0[] c0VarArr, @Nullable c0[] c0VarArr2, boolean z11, int i11, boolean z12, boolean z13, boolean z14) {
            this.f7591f = true;
            this.f7587b = iconCompat;
            if (iconCompat != null && iconCompat.q() == 2) {
                this.f7594i = iconCompat.n();
            }
            this.f7595j = m.k(charSequence);
            this.f7596k = pendingIntent;
            this.f7586a = bundle == null ? new Bundle() : bundle;
            this.f7588c = c0VarArr;
            this.f7589d = c0VarArr2;
            this.f7590e = z11;
            this.f7592g = i11;
            this.f7591f = z12;
            this.f7593h = z13;
            this.f7597l = z14;
        }

        @Nullable
        public PendingIntent a() {
            return this.f7596k;
        }

        public boolean b() {
            return this.f7590e;
        }

        @NonNull
        public Bundle c() {
            return this.f7586a;
        }

        @Nullable
        public IconCompat d() {
            int i11;
            if (this.f7587b == null && (i11 = this.f7594i) != 0) {
                this.f7587b = IconCompat.l(null, "", i11);
            }
            return this.f7587b;
        }

        @Nullable
        public c0[] e() {
            return this.f7588c;
        }

        public int f() {
            return this.f7592g;
        }

        public boolean g() {
            return this.f7591f;
        }

        @Nullable
        public CharSequence h() {
            return this.f7595j;
        }

        public boolean i() {
            return this.f7597l;
        }

        public boolean j() {
            return this.f7593h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(20)
    public static class c {
        public static boolean a(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        public static CharSequence[] b(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        public static Bundle c(Notification.Action action) {
            return action.getExtras();
        }

        public static Bundle d(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        public static String e(Notification notification) {
            return notification.getGroup();
        }

        public static CharSequence f(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        public static RemoteInput[] g(Notification.Action action) {
            return action.getRemoteInputs();
        }

        public static String h(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        public static String i(Notification notification) {
            return notification.getSortKey();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class d {
        public static Icon a(Notification.Action action) {
            return action.getIcon();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class e {
        public static boolean a(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class f {
        public static int a(Notification notification) {
            return notification.getBadgeIconType();
        }

        public static String b(Notification notification) {
            return notification.getChannelId();
        }

        public static int c(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        public static CharSequence d(Notification notification) {
            return notification.getSettingsText();
        }

        public static String e(Notification notification) {
            return notification.getShortcutId();
        }

        public static long f(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class g {
        public static int a(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class h {
        public static boolean a(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        public static Notification.BubbleMetadata b(Notification notification) {
            return notification.getBubbleMetadata();
        }

        public static int c(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        public static LocusId d(Notification notification) {
            return notification.getLocusId();
        }

        public static boolean e(Notification.Action action) {
            return action.isContextual();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static class i {
        public static boolean a(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IconCompat f7608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IconCompat f7609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f7610g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f7611h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f7612i;

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(23)
        public static class a {
            @RequiresApi(23)
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(VungleException.WEB_CRASH)
        public static class b {
            @RequiresApi(VungleException.WEB_CRASH)
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            @RequiresApi(VungleException.WEB_CRASH)
            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @RequiresApi(VungleException.WEB_CRASH)
            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z11) {
                bigPictureStyle.showBigPictureWhenCollapsed(z11);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.n nVar) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(nVar.a()).setBigContentTitle(this.f7665b);
            IconCompat iconCompat = this.f7608e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    b.a(bigContentTitle, this.f7608e.z(nVar instanceof t ? ((t) nVar).f() : null));
                } else if (iconCompat.q() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f7608e.m());
                }
            }
            if (this.f7610g) {
                IconCompat iconCompat2 = this.f7609f;
                if (iconCompat2 == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    a.a(bigContentTitle, this.f7609f.z(nVar instanceof t ? ((t) nVar).f() : null));
                } else if (iconCompat2.q() == 1) {
                    bigContentTitle.bigLargeIcon(this.f7609f.m());
                } else {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                }
            }
            if (this.f7667d) {
                bigContentTitle.setSummaryText(this.f7666c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                b.c(bigContentTitle, this.f7612i);
                b.b(bigContentTitle, this.f7611h);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        @NonNull
        public String k() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @NonNull
        public j q(@Nullable Bitmap bitmap) {
            this.f7609f = bitmap == null ? null : IconCompat.h(bitmap);
            this.f7610g = true;
            return this;
        }

        @NonNull
        public j r(@Nullable Bitmap bitmap) {
            this.f7608e = bitmap == null ? null : IconCompat.h(bitmap);
            return this;
        }

        @NonNull
        public j s(@Nullable CharSequence charSequence) {
            this.f7665b = m.k(charSequence);
            return this;
        }

        @NonNull
        public j t(@Nullable CharSequence charSequence) {
            this.f7666c = m.k(charSequence);
            this.f7667d = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f7613e;

        @Override // androidx.core.app.NotificationCompat.p
        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.n nVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(nVar.a()).setBigContentTitle(this.f7665b).bigText(this.f7613e);
            if (this.f7667d) {
                bigTextStyleBigText.setSummaryText(this.f7666c);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        @NonNull
        public String k() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @NonNull
        public k q(@Nullable CharSequence charSequence) {
            this.f7613e = m.k(charSequence);
            return this;
        }

        @NonNull
        public k r(@Nullable CharSequence charSequence) {
            this.f7665b = m.k(charSequence);
            return this;
        }

        @NonNull
        public k s(@Nullable CharSequence charSequence) {
            this.f7666c = m.k(charSequence);
            this.f7667d = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PendingIntent f7614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PendingIntent f7615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IconCompat f7616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7618e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7619f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f7620g;

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
        public static class a {
            @Nullable
            @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
            public static l a(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                c cVarG = new c(bubbleMetadata.getIntent(), IconCompat.c(bubbleMetadata.getIcon())).b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).g(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    cVarG.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    cVarG.e(bubbleMetadata.getDesiredHeightResId());
                }
                return cVarG.a();
            }

            @Nullable
            @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
            public static Notification.BubbleMetadata b(@Nullable l lVar) {
                if (lVar == null || lVar.g() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(lVar.f().y()).setIntent(lVar.g()).setDeleteIntent(lVar.c()).setAutoExpandBubble(lVar.b()).setSuppressNotification(lVar.i());
                if (lVar.d() != 0) {
                    suppressNotification.setDesiredHeight(lVar.d());
                }
                if (lVar.e() != 0) {
                    suppressNotification.setDesiredHeightResId(lVar.e());
                }
                return suppressNotification.build();
            }
        }

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(30)
        public static class b {
            @Nullable
            @RequiresApi(30)
            public static l a(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                c cVar = bubbleMetadata.getShortcutId() != null ? new c(bubbleMetadata.getShortcutId()) : new c(bubbleMetadata.getIntent(), IconCompat.c(bubbleMetadata.getIcon()));
                cVar.b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).g(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    cVar.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    cVar.e(bubbleMetadata.getDesiredHeightResId());
                }
                return cVar.a();
            }

            @Nullable
            @RequiresApi(30)
            public static Notification.BubbleMetadata b(@Nullable l lVar) {
                if (lVar == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = lVar.h() != null ? new Notification.BubbleMetadata.Builder(lVar.h()) : new Notification.BubbleMetadata.Builder(lVar.g(), lVar.f().y());
                builder.setDeleteIntent(lVar.c()).setAutoExpandBubble(lVar.b()).setSuppressNotification(lVar.i());
                if (lVar.d() != 0) {
                    builder.setDesiredHeight(lVar.d());
                }
                if (lVar.e() != 0) {
                    builder.setDesiredHeightResId(lVar.e());
                }
                return builder.build();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public PendingIntent f7621a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public IconCompat f7622b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f7623c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f7624d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f7625e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public PendingIntent f7626f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f7627g;

            public c(@NonNull PendingIntent pendingIntent, @NonNull IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat == null) {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                this.f7621a = pendingIntent;
                this.f7622b = iconCompat;
            }

            @RequiresApi(30)
            public c(@NonNull String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new NullPointerException("Bubble requires a non-null shortcut id");
                }
                this.f7627g = str;
            }

            @NonNull
            public l a() {
                String str = this.f7627g;
                if (str == null && this.f7621a == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.f7622b == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                l lVar = new l(this.f7621a, this.f7626f, this.f7622b, this.f7623c, this.f7624d, this.f7625e, str);
                lVar.j(this.f7625e);
                return lVar;
            }

            @NonNull
            public c b(boolean z11) {
                f(1, z11);
                return this;
            }

            @NonNull
            public c c(@Nullable PendingIntent pendingIntent) {
                this.f7626f = pendingIntent;
                return this;
            }

            @NonNull
            public c d(int i11) {
                this.f7623c = Math.max(i11, 0);
                this.f7624d = 0;
                return this;
            }

            @NonNull
            public c e(int i11) {
                this.f7624d = i11;
                this.f7623c = 0;
                return this;
            }

            @NonNull
            public final c f(int i11, boolean z11) {
                if (z11) {
                    this.f7625e = i11 | this.f7625e;
                } else {
                    this.f7625e = (~i11) & this.f7625e;
                }
                return this;
            }

            @NonNull
            public c g(boolean z11) {
                f(2, z11);
                return this;
            }
        }

        public l(@Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable IconCompat iconCompat, int i11, int i12, int i13, @Nullable String str) {
            this.f7614a = pendingIntent;
            this.f7616c = iconCompat;
            this.f7617d = i11;
            this.f7618e = i12;
            this.f7615b = pendingIntent2;
            this.f7619f = i13;
            this.f7620g = str;
        }

        @Nullable
        public static l a(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                return b.a(bubbleMetadata);
            }
            if (i11 == 29) {
                return a.a(bubbleMetadata);
            }
            return null;
        }

        @Nullable
        public static Notification.BubbleMetadata k(@Nullable l lVar) {
            if (lVar == null) {
                return null;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                return b.b(lVar);
            }
            if (i11 == 29) {
                return a.b(lVar);
            }
            return null;
        }

        public boolean b() {
            return (this.f7619f & 1) != 0;
        }

        @Nullable
        public PendingIntent c() {
            return this.f7615b;
        }

        public int d() {
            return this.f7617d;
        }

        public int e() {
            return this.f7618e;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public IconCompat f() {
            return this.f7616c;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent g() {
            return this.f7614a;
        }

        @Nullable
        public String h() {
            return this.f7620g;
        }

        public boolean i() {
            return (this.f7619f & 2) != 0;
        }

        public void j(int i11) {
            this.f7619f = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m {
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public z2.c O;
        public long P;
        public int Q;
        public int R;
        public boolean S;
        public l T;
        public Notification U;
        public boolean V;
        public Object W;

        @Deprecated
        public ArrayList<String> X;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f7628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<b> f7629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public ArrayList<a0> f7630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<b> f7631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f7632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f7633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f7634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f7635h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f7636i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public IconCompat f7637j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f7638k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7639l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7640m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7641n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7642o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f7643p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public p f7644q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f7645r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence f7646s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public CharSequence[] f7647t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f7648u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f7649v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f7650w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f7651x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f7652y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f7653z;

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(21)
        public static class a {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i11) {
                return builder.setContentType(i11);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i11) {
                return builder.setLegacyStreamType(i11);
            }

            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i11) {
                return builder.setUsage(i11);
            }
        }

        @Deprecated
        public m(@NonNull Context context) {
            this(context, null);
        }

        public m(@NonNull Context context, @NonNull String str) {
            this.f7629b = new ArrayList<>();
            this.f7630c = new ArrayList<>();
            this.f7631d = new ArrayList<>();
            this.f7641n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.Q = 0;
            this.R = 0;
            Notification notification = new Notification();
            this.U = notification;
            this.f7628a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.U.audioStreamType = -1;
            this.f7640m = 0;
            this.X = new ArrayList<>();
            this.S = true;
        }

        @Nullable
        public static CharSequence k(@Nullable CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        @NonNull
        public m A(boolean z11) {
            this.f7652y = z11;
            return this;
        }

        @NonNull
        public m B(@Nullable Bitmap bitmap) {
            this.f7637j = bitmap == null ? null : IconCompat.h(NotificationCompat.reduceLargeIconSize(this.f7628a, bitmap));
            return this;
        }

        @NonNull
        public m C(int i11, int i12, int i13) {
            Notification notification = this.U;
            notification.ledARGB = i11;
            notification.ledOnMS = i12;
            notification.ledOffMS = i13;
            notification.flags = ((i12 == 0 || i13 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        @NonNull
        public m D(boolean z11) {
            this.A = z11;
            return this;
        }

        @NonNull
        public m E(int i11) {
            this.f7639l = i11;
            return this;
        }

        @NonNull
        public m F(boolean z11) {
            w(2, z11);
            return this;
        }

        @NonNull
        public m G(boolean z11) {
            w(8, z11);
            return this;
        }

        @NonNull
        public m H(int i11) {
            this.f7640m = i11;
            return this;
        }

        @NonNull
        public m I(int i11, int i12, boolean z11) {
            this.f7648u = i11;
            this.f7649v = i12;
            this.f7650w = z11;
            return this;
        }

        @NonNull
        public m J(boolean z11) {
            this.f7641n = z11;
            return this;
        }

        @NonNull
        public m K(int i11) {
            this.U.icon = i11;
            return this;
        }

        @NonNull
        public m L(@Nullable Uri uri) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderE = a.e(a.c(a.b(), 4), 5);
            this.U.audioAttributes = a.a(builderE);
            return this;
        }

        @NonNull
        public m M(@Nullable p pVar) {
            if (this.f7644q != pVar) {
                this.f7644q = pVar;
                if (pVar != null) {
                    pVar.p(this);
                }
            }
            return this;
        }

        @NonNull
        public m N(@Nullable CharSequence charSequence) {
            this.U.tickerText = k(charSequence);
            return this;
        }

        @NonNull
        public m O(@Nullable long[] jArr) {
            this.U.vibrate = jArr;
            return this;
        }

        @NonNull
        public m P(int i11) {
            this.G = i11;
            return this;
        }

        @NonNull
        public m Q(long j11) {
            this.U.when = j11;
            return this;
        }

        @NonNull
        public m a(int i11, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.f7629b.add(new b(i11, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public m b(@Nullable b bVar) {
            if (bVar != null) {
                this.f7629b.add(bVar);
            }
            return this;
        }

        @NonNull
        public Notification c() {
            return new t(this).c();
        }

        public RemoteViews d() {
            return this.J;
        }

        public int e() {
            return this.F;
        }

        public RemoteViews f() {
            return this.I;
        }

        @NonNull
        public Bundle g() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public RemoteViews h() {
            return this.K;
        }

        public int i() {
            return this.f7640m;
        }

        public long j() {
            if (this.f7641n) {
                return this.U.when;
            }
            return 0L;
        }

        @NonNull
        public m l(boolean z11) {
            w(16, z11);
            return this;
        }

        @NonNull
        public m m(int i11) {
            this.M = i11;
            return this;
        }

        @NonNull
        public m n(@NonNull String str) {
            this.L = str;
            return this;
        }

        @NonNull
        public m o(int i11) {
            this.F = i11;
            return this;
        }

        @NonNull
        public m p(@Nullable PendingIntent pendingIntent) {
            this.f7634g = pendingIntent;
            return this;
        }

        @NonNull
        public m q(@Nullable CharSequence charSequence) {
            this.f7633f = k(charSequence);
            return this;
        }

        @NonNull
        public m r(@Nullable CharSequence charSequence) {
            this.f7632e = k(charSequence);
            return this;
        }

        @NonNull
        public m s(@Nullable RemoteViews remoteViews) {
            this.J = remoteViews;
            return this;
        }

        @NonNull
        public m t(@Nullable RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        @NonNull
        public m u(int i11) {
            Notification notification = this.U;
            notification.defaults = i11;
            if ((i11 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public m v(@Nullable PendingIntent pendingIntent) {
            this.U.deleteIntent = pendingIntent;
            return this;
        }

        public final void w(int i11, boolean z11) {
            if (z11) {
                Notification notification = this.U;
                notification.flags = i11 | notification.flags;
            } else {
                Notification notification2 = this.U;
                notification2.flags = (~i11) & notification2.flags;
            }
        }

        @NonNull
        public m x(int i11) {
            this.R = i11;
            return this;
        }

        @NonNull
        public m y(@Nullable PendingIntent pendingIntent, boolean z11) {
            this.f7635h = pendingIntent;
            w(128, z11);
            return this;
        }

        @NonNull
        public m z(@Nullable String str) {
            this.f7651x = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class n extends p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public a0 f7655f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f7656g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f7657h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PendingIntent f7658i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f7659j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f7660k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f7661l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconCompat f7662m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CharSequence f7663n;

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(21)
        public static class a {
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            public static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(23)
        public static class b {
            public static Parcelable a(Icon icon) {
                return icon;
            }

            public static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            public static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(28)
        public static class c {
            public static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            public static Parcelable b(Person person) {
                return person;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(VungleException.WEB_CRASH)
        public static class d {
            public static Notification.CallStyle a(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle b(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            public static Notification.CallStyle c(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i11) {
                return callStyle.setAnswerButtonColorHint(i11);
            }

            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z11) {
                return builder.setAuthenticationRequired(z11);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, int i11) {
                return callStyle.setDeclineButtonColorHint(i11);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z11) {
                return callStyle.setIsVideo(z11);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, @Nullable Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle i(Notification.CallStyle callStyle, @Nullable CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
            bundle.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.f7654e);
            bundle.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.f7659j);
            a0 a0Var = this.f7655f;
            if (a0Var != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, c.b(a0Var.i()));
                } else {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON_COMPAT, a0Var.j());
                }
            }
            IconCompat iconCompat = this.f7662m;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    bundle.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, b.a(iconCompat.z(this.f7664a.f7628a)));
                } else {
                    bundle.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT, iconCompat.x());
                }
            }
            bundle.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.f7663n);
            bundle.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.f7656g);
            bundle.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.f7657h);
            bundle.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.f7658i);
            Integer num = this.f7660k;
            if (num != null) {
                bundle.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, num.intValue());
            }
            Integer num2 = this.f7661l;
            if (num2 != null) {
                bundle.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, num2.intValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.n nVar) {
            int i11 = Build.VERSION.SDK_INT;
            CharSequence charSequenceR = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceR = null;
            if (i11 < 31) {
                Notification.Builder builderA = nVar.a();
                a0 a0Var = this.f7655f;
                builderA.setContentTitle(a0Var != null ? a0Var.d() : null);
                Bundle bundle = this.f7664a.E;
                if (bundle != null && bundle.containsKey(NotificationCompat.EXTRA_TEXT)) {
                    charSequenceR = this.f7664a.E.getCharSequence(NotificationCompat.EXTRA_TEXT);
                }
                if (charSequenceR == null) {
                    charSequenceR = r();
                }
                builderA.setContentText(charSequenceR);
                a0 a0Var2 = this.f7655f;
                if (a0Var2 != null) {
                    if (i11 >= 23 && a0Var2.b() != null) {
                        b.c(builderA, this.f7655f.b().z(this.f7664a.f7628a));
                    }
                    if (i11 >= 28) {
                        c.a(builderA, this.f7655f.i());
                    } else {
                        a.a(builderA, this.f7655f.e());
                    }
                }
                a.b(builderA, NotificationCompat.CATEGORY_CALL);
                return;
            }
            int i12 = this.f7654e;
            if (i12 == 1) {
                callStyleA = d.a(this.f7655f.i(), this.f7657h, this.f7656g);
            } else if (i12 == 2) {
                callStyleA = d.b(this.f7655f.i(), this.f7658i);
            } else if (i12 == 3) {
                callStyleA = d.c(this.f7655f.i(), this.f7658i, this.f7656g);
            } else if (Log.isLoggable(NotificationCompat.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unrecognized call type in CallStyle: ");
                sb2.append(String.valueOf(this.f7654e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(nVar.a());
                Integer num = this.f7660k;
                if (num != null) {
                    d.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f7661l;
                if (num2 != null) {
                    d.f(callStyleA, num2.intValue());
                }
                d.i(callStyleA, this.f7663n);
                IconCompat iconCompat = this.f7662m;
                if (iconCompat != null) {
                    d.h(callStyleA, iconCompat.z(this.f7664a.f7628a));
                }
                d.g(callStyleA, this.f7659j);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        @NonNull
        public String k() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @NonNull
        @RequiresApi(20)
        public ArrayList<b> q() {
            b bVarV = v();
            b bVarU = u();
            ArrayList<b> arrayList = new ArrayList<>(3);
            arrayList.add(bVarV);
            ArrayList<b> arrayList2 = this.f7664a.f7629b;
            int i11 = 2;
            if (arrayList2 != null) {
                for (b bVar : arrayList2) {
                    if (bVar.j()) {
                        arrayList.add(bVar);
                    } else if (!s(bVar) && i11 > 1) {
                        arrayList.add(bVar);
                        i11--;
                    }
                    if (bVarU != null && i11 == 1) {
                        arrayList.add(bVarU);
                        i11--;
                    }
                }
            }
            if (bVarU != null && i11 >= 1) {
                arrayList.add(bVarU);
            }
            return arrayList;
        }

        @Nullable
        public final String r() {
            int i11 = this.f7654e;
            if (i11 == 1) {
                return this.f7664a.f7628a.getResources().getString(R$string.call_notification_incoming_text);
            }
            if (i11 == 2) {
                return this.f7664a.f7628a.getResources().getString(R$string.call_notification_ongoing_text);
            }
            if (i11 != 3) {
                return null;
            }
            return this.f7664a.f7628a.getResources().getString(R$string.call_notification_screening_text);
        }

        public final boolean s(b bVar) {
            return bVar != null && bVar.c().getBoolean("key_action_priority");
        }

        @NonNull
        @RequiresApi(20)
        public final b t(int i11, int i12, Integer num, int i13, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(z2.a.getColor(this.f7664a.f7628a, i13));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f7664a.f7628a.getResources().getString(i12));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            b bVarA = new b.a(IconCompat.k(this.f7664a.f7628a, i11), spannableStringBuilder, pendingIntent).a();
            bVarA.c().putBoolean("key_action_priority", true);
            return bVarA;
        }

        @Nullable
        @RequiresApi(20)
        public final b u() {
            int i11 = R$drawable.ic_call_answer_video;
            int i12 = R$drawable.ic_call_answer;
            PendingIntent pendingIntent = this.f7656g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z11 = this.f7659j;
            return t(z11 ? i11 : i12, z11 ? R$string.call_notification_answer_video_action : R$string.call_notification_answer_action, this.f7660k, R$color.call_notification_answer_color, pendingIntent);
        }

        @NonNull
        @RequiresApi(20)
        public final b v() {
            int i11 = R$drawable.ic_call_decline;
            PendingIntent pendingIntent = this.f7657h;
            return pendingIntent == null ? t(i11, R$string.call_notification_hang_up_action, this.f7661l, R$color.call_notification_decline_color, this.f7658i) : t(i11, R$string.call_notification_decline_action, this.f7661l, R$color.call_notification_decline_color, pendingIntent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o extends p {

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(24)
        public static class a {
            public static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        public static List<b> s(List<b> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                if (!bVar.j()) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.n nVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                nVar.a().setStyle(a.a());
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        @NonNull
        public String k() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.p
        public RemoteViews m(androidx.core.app.n nVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsD = this.f7664a.d();
            if (remoteViewsD == null) {
                remoteViewsD = this.f7664a.f();
            }
            if (remoteViewsD == null) {
                return null;
            }
            return q(remoteViewsD, true);
        }

        @Override // androidx.core.app.NotificationCompat.p
        public RemoteViews n(androidx.core.app.n nVar) {
            if (Build.VERSION.SDK_INT < 24 && this.f7664a.f() != null) {
                return q(this.f7664a.f(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.p
        public RemoteViews o(androidx.core.app.n nVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsH = this.f7664a.h();
            RemoteViews remoteViewsF = remoteViewsH != null ? remoteViewsH : this.f7664a.f();
            if (remoteViewsH == null) {
                return null;
            }
            return q(remoteViewsF, true);
        }

        public final RemoteViews q(RemoteViews remoteViews, boolean z11) {
            int iMin;
            int i11 = 0;
            RemoteViews remoteViewsC = c(true, R$layout.notification_template_custom_big, false);
            remoteViewsC.removeAllViews(R$id.actions);
            List<b> listS = s(this.f7664a.f7629b);
            if (!z11 || listS == null || (iMin = Math.min(listS.size(), 3)) <= 0) {
                i11 = 8;
            } else {
                for (int i12 = 0; i12 < iMin; i12++) {
                    remoteViewsC.addView(R$id.actions, r(listS.get(i12)));
                }
            }
            remoteViewsC.setViewVisibility(R$id.actions, i11);
            remoteViewsC.setViewVisibility(R$id.action_divider, i11);
            d(remoteViewsC, remoteViews);
            return remoteViewsC;
        }

        public final RemoteViews r(b bVar) {
            boolean z11 = bVar.f7596k == null;
            RemoteViews remoteViews = new RemoteViews(this.f7664a.f7628a.getPackageName(), z11 ? R$layout.notification_action_tombstone : R$layout.notification_action);
            IconCompat iconCompatD = bVar.d();
            if (iconCompatD != null) {
                remoteViews.setImageViewBitmap(R$id.action_image, h(iconCompatD, R$color.notification_action_color_filter));
            }
            remoteViews.setTextViewText(R$id.action_text, bVar.f7595j);
            if (!z11) {
                remoteViews.setOnClickPendingIntent(R$id.action_container, bVar.f7596k);
            }
            remoteViews.setContentDescription(R$id.action_container, bVar.f7595j);
            return remoteViews;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f7664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f7665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f7666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7667d = false;

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(24)
        public static class a {
            public static void a(RemoteViews remoteViews, int i11, boolean z11) {
                remoteViews.setChronometerCountDown(i11, z11);
            }
        }

        public static float f(float f11, float f12, float f13) {
            if (f11 < f12) {
                return f12;
            }
            return f11 > f13 ? f13 : f11;
        }

        public void a(@NonNull Bundle bundle) {
            if (this.f7667d) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.f7666c);
            }
            CharSequence charSequence = this.f7665b;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, charSequence);
            }
            String strK = k();
            if (strK != null) {
                bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, strK);
            }
        }

        public abstract void b(androidx.core.app.n nVar);

        /* JADX WARN: Code duplicated, block: B:34:0x010a  */
        /* JADX WARN: Code duplicated, block: B:36:0x0115  */
        /* JADX WARN: Code duplicated, block: B:38:0x0121  */
        /* JADX WARN: Code duplicated, block: B:40:0x0138  */
        /* JADX WARN: Code duplicated, block: B:43:0x0149  */
        /* JADX WARN: Code duplicated, block: B:45:0x014f  */
        /* JADX WARN: Code duplicated, block: B:50:0x0182  */
        /* JADX WARN: Code duplicated, block: B:51:0x0195  */
        /* JADX WARN: Code duplicated, block: B:54:0x019a  */
        /* JADX WARN: Code duplicated, block: B:55:0x019c  */
        /* JADX WARN: Code duplicated, block: B:59:0x01a6  */
        @NonNull
        public RemoteViews c(boolean z11, int i11, boolean z12) {
            boolean z13;
            boolean z14;
            CharSequence charSequence;
            int i12;
            boolean z15;
            CharSequence charSequence2;
            Resources resources = this.f7664a.f7628a.getResources();
            RemoteViews remoteViews = new RemoteViews(this.f7664a.f7628a.getPackageName(), i11);
            this.f7664a.i();
            int i13 = Build.VERSION.SDK_INT;
            m mVar = this.f7664a;
            if (mVar.f7637j != null) {
                remoteViews.setViewVisibility(R$id.icon, 0);
                remoteViews.setImageViewBitmap(R$id.icon, h(this.f7664a.f7637j, 0));
                if (z11 && this.f7664a.U.icon != 0) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_right_icon_size);
                    int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R$dimen.notification_small_icon_background_padding) * 2);
                    m mVar2 = this.f7664a;
                    remoteViews.setImageViewBitmap(R$id.right_icon, j(mVar2.U.icon, dimensionPixelSize, dimensionPixelSize2, mVar2.e()));
                    remoteViews.setViewVisibility(R$id.right_icon, 0);
                }
            } else if (z11 && mVar.U.icon != 0) {
                remoteViews.setViewVisibility(R$id.icon, 0);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R$dimen.notification_big_circle_margin);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R$dimen.notification_small_icon_size_as_large);
                m mVar3 = this.f7664a;
                remoteViews.setImageViewBitmap(R$id.icon, j(mVar3.U.icon, dimensionPixelSize3, dimensionPixelSize4, mVar3.e()));
            }
            CharSequence charSequence3 = this.f7664a.f7632e;
            if (charSequence3 != null) {
                remoteViews.setTextViewText(R$id.title, charSequence3);
            }
            CharSequence charSequence4 = this.f7664a.f7633f;
            boolean z16 = true;
            if (charSequence4 != null) {
                remoteViews.setTextViewText(R$id.text, charSequence4);
                z13 = true;
            } else {
                z13 = false;
            }
            m mVar4 = this.f7664a;
            CharSequence charSequence5 = mVar4.f7638k;
            if (charSequence5 == null) {
                if (mVar4.f7639l > 0) {
                    if (this.f7664a.f7639l > resources.getInteger(R$integer.status_bar_notification_info_maxnum)) {
                        remoteViews.setTextViewText(R$id.info, resources.getString(R$string.status_bar_notification_info_overflow));
                    } else {
                        remoteViews.setTextViewText(R$id.info, NumberFormat.getIntegerInstance().format(this.f7664a.f7639l));
                    }
                    remoteViews.setViewVisibility(R$id.info, 0);
                } else {
                    remoteViews.setViewVisibility(R$id.info, 8);
                    z14 = false;
                }
                charSequence = this.f7664a.f7645r;
                if (charSequence != null) {
                    remoteViews.setTextViewText(R$id.text, charSequence);
                    charSequence2 = this.f7664a.f7633f;
                    if (charSequence2 != null) {
                        remoteViews.setTextViewText(R$id.text2, charSequence2);
                        remoteViews.setViewVisibility(R$id.text2, 0);
                        if (z12) {
                            remoteViews.setTextViewTextSize(R$id.text, 0, resources.getDimensionPixelSize(R$dimen.notification_subtext_size));
                        }
                        remoteViews.setViewPadding(R$id.line1, 0, 0, 0, 0);
                    } else {
                        remoteViews.setViewVisibility(R$id.text2, 8);
                    }
                }
                if (this.f7664a.j() != 0) {
                    z16 = z14;
                } else if (this.f7664a.f7642o) {
                    remoteViews.setViewVisibility(R$id.chronometer, 0);
                    remoteViews.setLong(R$id.chronometer, "setBase", this.f7664a.j() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                    remoteViews.setBoolean(R$id.chronometer, "setStarted", true);
                    z15 = this.f7664a.f7643p;
                    if (z15 && i13 >= 24) {
                        a.a(remoteViews, R$id.chronometer, z15);
                    }
                } else {
                    remoteViews.setViewVisibility(R$id.time, 0);
                    remoteViews.setLong(R$id.time, "setTime", this.f7664a.j());
                }
                int i14 = R$id.right_side;
                if (z16) {
                    i12 = 0;
                } else {
                    i12 = 8;
                }
                remoteViews.setViewVisibility(i14, i12);
                remoteViews.setViewVisibility(R$id.line3, z13 ? 0 : 8);
                return remoteViews;
            }
            remoteViews.setTextViewText(R$id.info, charSequence5);
            remoteViews.setViewVisibility(R$id.info, 0);
            z13 = true;
            z14 = true;
            charSequence = this.f7664a.f7645r;
            if (charSequence != null) {
                remoteViews.setTextViewText(R$id.text, charSequence);
                charSequence2 = this.f7664a.f7633f;
                if (charSequence2 != null) {
                    remoteViews.setTextViewText(R$id.text2, charSequence2);
                    remoteViews.setViewVisibility(R$id.text2, 0);
                    if (z12) {
                        remoteViews.setTextViewTextSize(R$id.text, 0, resources.getDimensionPixelSize(R$dimen.notification_subtext_size));
                    }
                    remoteViews.setViewPadding(R$id.line1, 0, 0, 0, 0);
                } else {
                    remoteViews.setViewVisibility(R$id.text2, 8);
                }
            }
            if (this.f7664a.j() != 0) {
                z16 = z14;
            } else if (this.f7664a.f7642o) {
                remoteViews.setViewVisibility(R$id.chronometer, 0);
                remoteViews.setLong(R$id.chronometer, "setBase", this.f7664a.j() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                remoteViews.setBoolean(R$id.chronometer, "setStarted", true);
                z15 = this.f7664a.f7643p;
                if (z15) {
                    a.a(remoteViews, R$id.chronometer, z15);
                }
            } else {
                remoteViews.setViewVisibility(R$id.time, 0);
                remoteViews.setLong(R$id.time, "setTime", this.f7664a.j());
            }
            int i15 = R$id.right_side;
            if (z16) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            remoteViews.setViewVisibility(i15, i12);
            remoteViews.setViewVisibility(R$id.line3, z13 ? 0 : 8);
            return remoteViews;
        }

        public void d(RemoteViews remoteViews, RemoteViews remoteViews2) {
            l(remoteViews);
            remoteViews.removeAllViews(R$id.notification_main_column);
            remoteViews.addView(R$id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(R$id.notification_main_column, 0);
            remoteViews.setViewPadding(R$id.notification_main_column_container, 0, e(), 0, 0);
        }

        public final int e() {
            Resources resources = this.f7664a.f7628a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.notification_top_pad_large_text);
            float f11 = (f(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - f11) * dimensionPixelSize) + (f11 * dimensionPixelSize2));
        }

        public final Bitmap g(int i11, int i12, int i13) {
            return i(IconCompat.k(this.f7664a.f7628a, i11), i12, i13);
        }

        public Bitmap h(@NonNull IconCompat iconCompat, int i11) {
            return i(iconCompat, i11, 0);
        }

        public final Bitmap i(@NonNull IconCompat iconCompat, int i11, int i12) {
            Drawable drawableT = iconCompat.t(this.f7664a.f7628a);
            int intrinsicWidth = i12 == 0 ? drawableT.getIntrinsicWidth() : i12;
            if (i12 == 0) {
                i12 = drawableT.getIntrinsicHeight();
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, i12, Bitmap.Config.ARGB_8888);
            drawableT.setBounds(0, 0, intrinsicWidth, i12);
            if (i11 != 0) {
                drawableT.mutate().setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_IN));
            }
            drawableT.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }

        public final Bitmap j(int i11, int i12, int i13, int i14) {
            int i15 = R$drawable.notification_icon_background;
            if (i14 == 0) {
                i14 = 0;
            }
            Bitmap bitmapG = g(i15, i14, i12);
            Canvas canvas = new Canvas(bitmapG);
            Drawable drawableMutate = this.f7664a.f7628a.getResources().getDrawable(i11).mutate();
            drawableMutate.setFilterBitmap(true);
            int i16 = (i12 - i13) / 2;
            int i17 = i13 + i16;
            drawableMutate.setBounds(i16, i16, i17, i17);
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            drawableMutate.draw(canvas);
            return bitmapG;
        }

        @Nullable
        public String k() {
            return null;
        }

        public final void l(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R$id.title, 8);
            remoteViews.setViewVisibility(R$id.text2, 8);
            remoteViews.setViewVisibility(R$id.text, 8);
        }

        public RemoteViews m(androidx.core.app.n nVar) {
            return null;
        }

        public RemoteViews n(androidx.core.app.n nVar) {
            return null;
        }

        public RemoteViews o(androidx.core.app.n nVar) {
            return null;
        }

        public void p(@Nullable m mVar) {
            if (this.f7664a != mVar) {
                this.f7664a = mVar;
                if (mVar != null) {
                    mVar.M(this);
                }
            }
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    @Nullable
    public static b getAction(@NonNull Notification notification, int i11) {
        return getActionCompatFromAction(notification.actions[i11]);
    }

    @NonNull
    @RequiresApi(20)
    public static b getActionCompatFromAction(@NonNull Notification.Action action) {
        c0[] c0VarArr;
        int i11;
        RemoteInput[] remoteInputArrG = c.g(action);
        if (remoteInputArrG == null) {
            c0VarArr = null;
        } else {
            c0[] c0VarArr2 = new c0[remoteInputArrG.length];
            for (int i12 = 0; i12 < remoteInputArrG.length; i12++) {
                RemoteInput remoteInput = remoteInputArrG[i12];
                c0VarArr2[i12] = new c0(c.h(remoteInput), c.f(remoteInput), c.b(remoteInput), c.a(remoteInput), Build.VERSION.SDK_INT >= 29 ? h.c(remoteInput) : 0, c.d(remoteInput), null);
            }
            c0VarArr = c0VarArr2;
        }
        int i13 = Build.VERSION.SDK_INT;
        boolean z11 = i13 >= 24 ? c.c(action).getBoolean("android.support.allowGeneratedReplies") || e.a(action) : c.c(action).getBoolean("android.support.allowGeneratedReplies");
        boolean z12 = c.c(action).getBoolean("android.support.action.showsUserInterface", true);
        int iA = i13 >= 28 ? g.a(action) : c.c(action).getInt("android.support.action.semanticAction", 0);
        boolean zE = i13 >= 29 ? h.e(action) : false;
        boolean zA = i13 >= 31 ? i.a(action) : false;
        if (i13 < 23) {
            return new b(action.icon, action.title, action.actionIntent, c.c(action), c0VarArr, (c0[]) null, z11, iA, z12, zE, zA);
        }
        if (d.a(action) != null || (i11 = action.icon) == 0) {
            return new b(d.a(action) != null ? IconCompat.d(d.a(action)) : null, action.title, action.actionIntent, c.c(action), c0VarArr, (c0[]) null, z11, iA, z12, zE, zA);
        }
        return new b(i11, action.title, action.actionIntent, c.c(action), c0VarArr, (c0[]) null, z11, iA, z12, zE, zA);
    }

    public static int getActionCount(@NonNull Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return h.a(notification);
        }
        return false;
    }

    public static boolean getAutoCancel(@NonNull Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int getBadgeIconType(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.a(notification);
        }
        return 0;
    }

    @Nullable
    public static l getBubbleMetadata(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return l.a(h.b(notification));
        }
        return null;
    }

    @Nullable
    public static String getCategory(@NonNull Notification notification) {
        return notification.category;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.b(notification);
        }
        return null;
    }

    public static int getColor(@NonNull Notification notification) {
        return notification.color;
    }

    @Nullable
    public static CharSequence getContentInfo(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @Nullable
    public static CharSequence getContentText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    @Nullable
    public static CharSequence getContentTitle(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification notification) {
        return notification.extras;
    }

    @Nullable
    public static String getGroup(@NonNull Notification notification) {
        return c.e(notification);
    }

    public static int getGroupAlertBehavior(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.c(notification);
        }
        return 0;
    }

    public static boolean getHighPriority(@NonNull Notification notification) {
        return (notification.flags & 128) != 0;
    }

    @NonNull
    @RequiresApi(21)
    public static List<b> getInvisibleActions(@NonNull Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle2 != null && (bundle = bundle2.getBundle("invisible_actions")) != null) {
            for (int i11 = 0; i11 < bundle.size(); i11++) {
                arrayList.add(u.c(bundle.getBundle(Integer.toString(i11))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(@NonNull Notification notification) {
        return (notification.flags & 256) != 0;
    }

    @Nullable
    public static z2.c getLocusId(@NonNull Notification notification) {
        LocusId locusIdD;
        if (Build.VERSION.SDK_INT < 29 || (locusIdD = h.d(notification)) == null) {
            return null;
        }
        return z2.c.c(locusIdD);
    }

    @NonNull
    public static Notification[] getNotificationArrayFromBundle(@NonNull Bundle bundle, @NonNull String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i11 = 0; i11 < parcelableArray.length; i11++) {
            notificationArr[i11] = (Notification) parcelableArray[i11];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static boolean getOngoing(@NonNull Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification notification) {
        return (notification.flags & 8) != 0;
    }

    @NonNull
    public static List<a0> getPeople(@NonNull Notification notification) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(a0.a(r.a(it.next())));
                }
            }
        } else {
            String[] stringArray = notification.extras.getStringArray(EXTRA_PEOPLE);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    arrayList.add(new a0.b().g(str).a());
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification notification) {
        return notification.publicVersion;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.d(notification);
        }
        return null;
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.e(notification);
        }
        return null;
    }

    public static boolean getShowWhen(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @Nullable
    public static String getSortKey(@NonNull Notification notification) {
        return c.i(notification);
    }

    @Nullable
    public static CharSequence getSubText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.f(notification);
        }
        return 0L;
    }

    public static boolean getUsesChronometer(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@NonNull Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(@NonNull Notification notification) {
        return (notification.flags & 512) != 0;
    }

    @Nullable
    public static Bitmap reduceLargeIconSize(@NonNull Context context, @Nullable Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }
}
