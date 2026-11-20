package u00;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Expose
    private String f78134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("source")
    @Expose
    private String f78135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("message_version")
    @Expose
    private String f78136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName(CampaignEx.JSON_KEY_TIMESTAMP)
    @Expose
    private Long f78137d;

    public g(String str, String str2, String str3, Long l11) {
        this.f78134a = str;
        this.f78135b = str2;
        this.f78136c = str3;
        this.f78137d = l11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f78134a.equals(gVar.f78134a) && this.f78135b.equals(gVar.f78135b) && this.f78136c.equals(gVar.f78136c) && this.f78137d.equals(gVar.f78137d);
    }
}
