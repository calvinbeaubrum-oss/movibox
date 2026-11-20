package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.transsion.push.PushConstants;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new n0();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    @SafeParcelable.Field(id = 2)
    Bundle bundle;
    private Map<String, String> data;
    private b notification;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f40766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f40767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f40768e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f40769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f40770g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f40771h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f40772i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f40773j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f40774k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f40775l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f40776m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Uri f40777n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f40778o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Integer f40779p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Integer f40780q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Integer f40781r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int[] f40782s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final Long f40783t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f40784u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f40785v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f40786w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f40787x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final boolean f40788y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final long[] f40789z;

        public b(g0 g0Var) {
            this.f40764a = g0Var.p("gcm.n.title");
            this.f40765b = g0Var.h("gcm.n.title");
            this.f40766c = a(g0Var, "gcm.n.title");
            this.f40767d = g0Var.p("gcm.n.body");
            this.f40768e = g0Var.h("gcm.n.body");
            this.f40769f = a(g0Var, "gcm.n.body");
            this.f40770g = g0Var.p("gcm.n.icon");
            this.f40772i = g0Var.o();
            this.f40773j = g0Var.p("gcm.n.tag");
            this.f40774k = g0Var.p("gcm.n.color");
            this.f40775l = g0Var.p("gcm.n.click_action");
            this.f40776m = g0Var.p("gcm.n.android_channel_id");
            this.f40777n = g0Var.f();
            this.f40771h = g0Var.p("gcm.n.image");
            this.f40778o = g0Var.p("gcm.n.ticker");
            this.f40779p = g0Var.b("gcm.n.notification_priority");
            this.f40780q = g0Var.b("gcm.n.visibility");
            this.f40781r = g0Var.b("gcm.n.notification_count");
            this.f40784u = g0Var.a("gcm.n.sticky");
            this.f40785v = g0Var.a("gcm.n.local_only");
            this.f40786w = g0Var.a("gcm.n.default_sound");
            this.f40787x = g0Var.a("gcm.n.default_vibrate_timings");
            this.f40788y = g0Var.a("gcm.n.default_light_settings");
            this.f40783t = g0Var.j("gcm.n.event_time");
            this.f40782s = g0Var.e();
            this.f40789z = g0Var.q();
        }

        public static String[] a(g0 g0Var, String str) {
            Object[] objArrG = g0Var.g(str);
            if (objArrG == null) {
                return null;
            }
            String[] strArr = new String[objArrG.length];
            for (int i11 = 0; i11 < objArrG.length; i11++) {
                strArr[i11] = String.valueOf(objArrG[i11]);
            }
            return strArr;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.bundle = bundle;
    }

    private int getMessagePriority(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public String getCollapseKey() {
        return this.bundle.getString("collapse_key");
    }

    @NonNull
    public Map<String, String> getData() {
        if (this.data == null) {
            this.data = e.a.a(this.bundle);
        }
        return this.data;
    }

    @Nullable
    public String getFrom() {
        return this.bundle.getString("from");
    }

    @Nullable
    public String getMessageId() {
        String string = this.bundle.getString("google.message_id");
        return string == null ? this.bundle.getString(PushConstants.EXTRA_PUSH_MESSAGE_ID) : string;
    }

    @Nullable
    public String getMessageType() {
        return this.bundle.getString(PushConstants.EXTRA_PUSH_MESSAGE_TYPE);
    }

    @Nullable
    public b getNotification() {
        if (this.notification == null && g0.t(this.bundle)) {
            this.notification = new b(new g0(this.bundle));
        }
        return this.notification;
    }

    public int getOriginalPriority() {
        String string = this.bundle.getString("google.original_priority");
        if (string == null) {
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    public int getPriority() {
        String string = this.bundle.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    @Nullable
    @ShowFirstParty
    public byte[] getRawData() {
        return this.bundle.getByteArray("rawData");
    }

    @Nullable
    public String getSenderId() {
        return this.bundle.getString("google.c.sender.id");
    }

    public long getSentTime() {
        Object obj = this.bundle.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid sent time: " + obj);
            return 0L;
        }
    }

    @Nullable
    public String getTo() {
        return this.bundle.getString("google.to");
    }

    public int getTtl() {
        Object obj = this.bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    public void populateSendMessageIntent(Intent intent) {
        intent.putExtras(this.bundle);
    }

    @KeepForSdk
    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.bundle);
        return intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        n0.c(this, parcel, i11);
    }
}
