package jj;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f68029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f68030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f68031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f68032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f68033g;

    public k(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f68028b = str;
        this.f68027a = str2;
        this.f68029c = str3;
        this.f68030d = str4;
        this.f68031e = str5;
        this.f68032f = str6;
        this.f68033g = str7;
    }

    @Nullable
    public static k a(@NonNull Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new k(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    @NonNull
    public String b() {
        return this.f68027a;
    }

    @NonNull
    public String c() {
        return this.f68028b;
    }

    @Nullable
    public String d() {
        return this.f68031e;
    }

    @Nullable
    public String e() {
        return this.f68033g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Objects.equal(this.f68028b, kVar.f68028b) && Objects.equal(this.f68027a, kVar.f68027a) && Objects.equal(this.f68029c, kVar.f68029c) && Objects.equal(this.f68030d, kVar.f68030d) && Objects.equal(this.f68031e, kVar.f68031e) && Objects.equal(this.f68032f, kVar.f68032f) && Objects.equal(this.f68033g, kVar.f68033g);
    }

    public int hashCode() {
        return Objects.hashCode(this.f68028b, this.f68027a, this.f68029c, this.f68030d, this.f68031e, this.f68032f, this.f68033g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f68028b).add("apiKey", this.f68027a).add("databaseUrl", this.f68029c).add("gcmSenderId", this.f68031e).add("storageBucket", this.f68032f).add("projectId", this.f68033g).toString();
    }
}
