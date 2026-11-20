package u00;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("battery_saver_enabled")
    @Expose
    private Boolean f78123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("language")
    @Expose
    private String f78124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("time_zone")
    @Expose
    private String f78125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("volume_level")
    @Expose
    private Double f78126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("ifa")
    @Expose
    private String f78127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SerializedName("amazon")
    @Expose
    private a f78128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SerializedName("android")
    @Expose
    private a f78129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("extension")
    @Expose
    private f f78130h;

    public e(Boolean bool, String str, String str2, Double d11, String str3, a aVar, a aVar2, f fVar) {
        this.f78123a = bool;
        this.f78124b = str;
        this.f78125c = str2;
        this.f78126d = d11;
        this.f78127e = str3;
        this.f78128f = aVar;
        this.f78129g = aVar2;
        this.f78130h = fVar;
    }
}
