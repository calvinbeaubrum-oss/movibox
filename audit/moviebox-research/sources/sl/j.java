package sl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.integration.cronet.BufferQueue;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f76398a = Pattern.compile("(^|.*\\s)datatransport/\\S+ android/($|\\s.*)");

    public static Long a(@NonNull HttpMessage httpMessage) {
        try {
            Header firstHeader = httpMessage.getFirstHeader(BufferQueue.CONTENT_LENGTH);
            if (firstHeader != null) {
                return Long.valueOf(Long.parseLong(firstHeader.getValue()));
            }
            return null;
        } catch (NumberFormatException unused) {
            ql.a.e().a("The content-length value is not a valid number");
            return null;
        }
    }

    public static String b(@NonNull HttpResponse httpResponse) {
        String value;
        Header firstHeader = httpResponse.getFirstHeader("content-type");
        if (firstHeader == null || (value = firstHeader.getValue()) == null) {
            return null;
        }
        return value;
    }

    public static boolean c(@Nullable String str) {
        return str == null || !f76398a.matcher(str).matches();
    }

    public static void d(com.google.firebase.perf.metrics.j jVar) {
        if (!jVar.f()) {
            jVar.k();
        }
        jVar.c();
    }
}
