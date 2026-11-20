package kn;

import com.iab.omid.library.mmadbridge.adsession.CreativeType;
import com.iab.omid.library.mmadbridge.adsession.ImpressionType;
import com.iab.omid.library.mmadbridge.adsession.Owner;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Owner f68639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Owner f68640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f68641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CreativeType f68642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImpressionType f68643e;

    public c(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z11) {
        this.f68642d = creativeType;
        this.f68643e = impressionType;
        this.f68639a = owner;
        if (owner2 == null) {
            this.f68640b = Owner.NONE;
        } else {
            this.f68640b = owner2;
        }
        this.f68641c = z11;
    }

    public static c a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z11) {
        nn.g.c(creativeType, "CreativeType is null");
        nn.g.c(impressionType, "ImpressionType is null");
        nn.g.c(owner, "Impression owner is null");
        nn.g.b(owner, creativeType, impressionType);
        return new c(creativeType, impressionType, owner, owner2, z11);
    }

    public boolean b() {
        return Owner.NATIVE == this.f68639a;
    }

    public boolean c() {
        return Owner.NATIVE == this.f68640b;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        nn.c.i(jSONObject, "impressionOwner", this.f68639a);
        nn.c.i(jSONObject, "mediaEventsOwner", this.f68640b);
        nn.c.i(jSONObject, "creativeType", this.f68642d);
        nn.c.i(jSONObject, "impressionType", this.f68643e);
        nn.c.i(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f68641c));
        return jSONObject;
    }
}
