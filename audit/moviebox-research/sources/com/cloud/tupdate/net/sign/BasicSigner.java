package com.cloud.tupdate.net.sign;

import android.util.Base64;
import com.cloud.tupdate.net.utils.LogUtil;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BasicSigner extends Signer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32208a;

    public BasicSigner(String str) {
        this.f32208a = str;
    }

    @Override // com.cloud.tupdate.net.sign.Signer
    public String a(SignAlgorithm signAlgorithm, String str) {
        try {
            Mac mac = Mac.getInstance(signAlgorithm.name());
            mac.init(new SecretKeySpec(Base64.decode(this.f32208a, 2), signAlgorithm.name()));
            return Base64.encodeToString(mac.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
            return "";
        }
    }
}
