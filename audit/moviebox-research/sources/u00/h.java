package u00;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("config_extension")
    @Expose
    public String f78138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("ordinal_view")
    @Expose
    private Integer f78139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("precached_tokens")
    @Expose
    private List<String> f78140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("sdk_user_agent")
    @Expose
    private String f78141d;

    public h(String str, Integer num, List<String> list, String str2) {
        this.f78138a = str;
        this.f78139b = num;
        this.f78140c = list;
        this.f78141d = str2;
    }
}
