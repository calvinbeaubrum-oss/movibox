package com.cloud.hisavana.sdk;

import android.util.Base64;
import android.util.Log;
import com.cloud.hisavana.sdk.sign.SignAlgorithm;
import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class l3 extends i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29852a;

    public l3(String str) {
        this.f29852a = str;
    }

    @Override // com.cloud.hisavana.sdk.i1
    public String a(SignAlgorithm signAlgorithm, String str) {
        try {
            Mac mac = Mac.getInstance(signAlgorithm.name());
            mac.init(new SecretKeySpec(Base64.decode(this.f29852a, 2), signAlgorithm.name()));
            return Base64.encodeToString(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2);
        } catch (Exception e11) {
            z.a().e(Log.getStackTraceString(e11));
            return "";
        }
    }
}
