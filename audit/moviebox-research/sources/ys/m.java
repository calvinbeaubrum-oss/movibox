package ys;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.GregorianCalendar;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f81631a;

    public static synchronized m b() {
        try {
            if (f81631a == null) {
                f81631a = new m();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f81631a;
    }

    public boolean a(Context context) {
        if (c()) {
            return true;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 100);
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            if (Build.VERSION.SDK_INT < 23) {
                keyPairGenerator.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("crypto").setSubject(new X500Principal("CN=crypto")).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(gregorianCalendar.getTime()).setEndDate(gregorianCalendar2.getTime()).build());
            } else {
                l.a();
                KeyGenParameterSpec.Builder builderA = k.a("crypto", 3);
                builderA.setCertificateSubject(new X500Principal("CN=crypto")).setEncryptionPaddings("PKCS1Padding").setCertificateSerialNumber(BigInteger.valueOf(1337L)).setCertificateNotBefore(gregorianCalendar.getTime()).setCertificateNotAfter(gregorianCalendar2.getTime());
                keyPairGenerator.initialize(builderA.build());
            }
            keyPairGenerator.generateKeyPair();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean c() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (((PrivateKey) keyStore.getKey("crypto", null)) == null || keyStore.getCertificate("crypto").getPublicKey() == null) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }
}
