package wt;

import android.util.LruCache;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<vt.e, String> f79637a = new LruCache<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.f<b> f79638b = bu.c.c(10, new a(this));

    /* JADX INFO: compiled from: source.java */
    public class a implements bu.c.a<b> {
        public a(i iVar) {
        }

        @Override // bu.c.a
        public b create() {
            try {
                return new b(MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256));
            } catch (NoSuchAlgorithmException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements bu.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageDigest f79639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f79640b = new k.b(null);

        public b(MessageDigest messageDigest) {
            this.f79639a = messageDigest;
        }

        @Override // bu.c.b
        public k getVerifier() {
            return this.f79640b;
        }
    }

    public String a(vt.e eVar) {
        String strA;
        synchronized (this.f79637a) {
            strA = this.f79637a.get(eVar);
        }
        if (strA == null) {
            b bVarAcquire = this.f79638b.acquire();
            try {
                eVar.a(bVarAcquire.f79639a);
                strA = d.a(bVarAcquire.f79639a.digest());
                this.f79638b.release(bVarAcquire);
            } catch (Throwable th2) {
                this.f79638b.release(bVarAcquire);
                throw th2;
            }
        }
        synchronized (this.f79637a) {
            this.f79637a.put(eVar, strA);
        }
        return strA;
    }
}
