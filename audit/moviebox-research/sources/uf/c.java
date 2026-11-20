package uf;

import com.facebook.biddingkit.http.client.HttpMethod;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends d {
    public c(String str, Map<String, String> map, String str2, byte[] bArr) {
        super(str, map);
        this.f78530b = HttpMethod.POST;
        this.f78531c = str2;
        this.f78532d = bArr;
    }
}
