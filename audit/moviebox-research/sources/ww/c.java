package ww;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.GregorianCalendar;
import javax.security.auth.x500.X500Principal;
import ys.k;
import ys.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f79658a;

    public static synchronized c b() {
        try {
            if (f79658a == null) {
                f79658a = new c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f79658a;
    }

    public synchronized boolean a(Context context) {
        try {
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
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean c() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.getEntry("crypto", null) instanceof KeyStore.PrivateKeyEntry) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
