package q7;

import javax.annotation.Priority;
import org.glassfish.jersey.internal.spi.AutoDiscoverable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Priority(1999)
public class a implements AutoDiscoverable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f74444a = true;

    static {
        try {
            f74444a = Boolean.parseBoolean(System.getProperty("fastjson.auto.discoverable", String.valueOf(f74444a)));
        } catch (Throwable unused) {
        }
    }
}
