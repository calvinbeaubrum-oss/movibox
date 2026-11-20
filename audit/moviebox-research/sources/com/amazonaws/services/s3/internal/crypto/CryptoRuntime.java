package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class CryptoRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Log f15988a = LogFactory.b(CryptoRuntime.class);

    /* JADX INFO: compiled from: source.java */
    public static final class AesGcm {
        public static boolean b(Provider provider) {
            try {
                Cipher.getInstance(ContentCryptoScheme.f15986b.b(), provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static synchronized void a() {
        if (c()) {
            return;
        }
        try {
            Security.addProvider((Provider) Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider").newInstance());
        } catch (Exception e11) {
            f15988a.g("Bouncy Castle not available", e11);
        }
    }

    public static boolean b(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return AesGcm.b(provider);
    }

    public static synchronized boolean c() {
        return Security.getProvider("BC") != null;
    }
}
