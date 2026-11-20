package e5;

import androidx.media3.extractor.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f64029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataOutputStream f64030b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f64029a = byteArrayOutputStream;
        this.f64030b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f64029a.reset();
        try {
            b(this.f64030b, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            b(this.f64030b, str);
            this.f64030b.writeLong(eventMessage.durationMs);
            this.f64030b.writeLong(eventMessage.f11799id);
            this.f64030b.write(eventMessage.messageData);
            this.f64030b.flush();
            return this.f64029a.toByteArray();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
