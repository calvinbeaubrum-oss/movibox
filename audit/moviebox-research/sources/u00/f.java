package u00;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("is_sideload_enabled")
    @Expose
    private Boolean f78131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("sd_card_available")
    @Expose
    private Boolean f78132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("sound_enabled")
    @Expose
    private Boolean f78133c;

    public f(Boolean bool, Boolean bool2, Boolean bool3) {
        this.f78131a = bool;
        this.f78132b = bool2;
        this.f78133c = bool3;
    }
}
