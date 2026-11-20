package d10;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enabled")
    public boolean f62861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    @SerializedName("aggregation_filters")
    public String[] f62862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    @SerializedName("aggregation_time_windows")
    public int[] f62863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    @SerializedName("view_limit")
    public a f62864d;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("device")
        public int f62865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("wifi")
        public int f62866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("mobile")
        public int f62867c;
    }
}
