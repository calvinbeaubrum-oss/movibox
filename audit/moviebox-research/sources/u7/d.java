package u7;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f78496a;

    public d(Bundle bundle) {
        this.f78496a = bundle;
    }

    public boolean a() {
        return this.f78496a.getBoolean("google_play_instant");
    }

    public long b() {
        return this.f78496a.getLong("install_begin_timestamp_seconds");
    }

    public String c() {
        return this.f78496a.getString("install_referrer");
    }

    public long d() {
        return this.f78496a.getLong("referrer_click_timestamp_seconds");
    }

    public long e() {
        return this.f78496a.getLong("referrer_click_timestamp_server_seconds");
    }
}
