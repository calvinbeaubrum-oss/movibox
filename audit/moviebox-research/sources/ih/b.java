package ih;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f67199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataOutputStream f67200b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f67199a = byteArrayOutputStream;
        this.f67200b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f67199a.reset();
        try {
            b(this.f67200b, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            b(this.f67200b, str);
            this.f67200b.writeLong(eventMessage.durationMs);
            this.f67200b.writeLong(eventMessage.f33578id);
            this.f67200b.write(eventMessage.messageData);
            this.f67200b.flush();
            return this.f67199a.toByteArray();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
