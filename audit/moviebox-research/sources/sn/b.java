package sn;

import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Owner f76414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Owner f76415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f76416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CreativeType f76417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImpressionType f76418e;

    public b(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z11) {
        this.f76417d = creativeType;
        this.f76418e = impressionType;
        this.f76414a = owner;
        if (owner2 == null) {
            this.f76415b = Owner.NONE;
        } else {
            this.f76415b = owner2;
        }
        this.f76416c = z11;
    }

    public static b a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z11) {
        un.e.c(creativeType, "CreativeType is null");
        un.e.c(impressionType, "ImpressionType is null");
        un.e.c(owner, "Impression owner is null");
        un.e.b(owner, creativeType, impressionType);
        return new b(creativeType, impressionType, owner, owner2, z11);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        un.b.g(jSONObject, "impressionOwner", this.f76414a);
        un.b.g(jSONObject, "mediaEventsOwner", this.f76415b);
        un.b.g(jSONObject, "creativeType", this.f76417d);
        un.b.g(jSONObject, "impressionType", this.f76418e);
        un.b.g(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f76416c));
        return jSONObject;
    }
}
