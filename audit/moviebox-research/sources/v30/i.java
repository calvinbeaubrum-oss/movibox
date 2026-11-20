package v30;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78728a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f78729b;

    public i(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f78729b = new FileInputStream(file).getChannel();
    }

    public final long a(d dVar, long j11, long j12) throws IOException {
        for (long j13 = 0; j13 < j11; j13++) {
            e eVarB = dVar.b(j13);
            if (eVarB.f78721a == 1) {
                long j14 = eVarB.f78723c;
                if (j14 <= j12 && j12 <= eVarB.f78724d + j14) {
                    return (j12 - j14) + eVarB.f78722b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d b() throws IOException {
        this.f78729b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (j(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sE = e(byteBufferAllocate, 4L);
        boolean z11 = e(byteBufferAllocate, 5L) == 2;
        if (sE == 1) {
            return new g(z11, this);
        }
        if (sE == 2) {
            return new h(z11, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List<String> c() throws IOException {
        long j11;
        this.f78729b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarB = b();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarB.f78712a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j12 = dVarB.f78717f;
        int i11 = 0;
        if (j12 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j12 = dVarB.c(0).f78725a;
        }
        long j13 = 0;
        while (true) {
            if (j13 >= j12) {
                j11 = 0;
                break;
            }
            e eVarB = dVarB.b(j13);
            if (eVarB.f78721a == 2) {
                j11 = eVarB.f78722b;
                break;
            }
            j13++;
        }
        if (j11 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j14 = 0;
        while (true) {
            c cVarA = dVarB.a(j11, i11);
            long j15 = j11;
            long j16 = cVarA.f78710a;
            if (j16 == 1) {
                arrayList2.add(Long.valueOf(cVarA.f78711b));
            } else if (j16 == 5) {
                j14 = cVarA.f78711b;
            }
            i11++;
            if (cVarA.f78710a == 0) {
                break;
            }
            j11 = j15;
        }
        if (j14 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(dVarB, j12, j14);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(i(byteBufferAllocate, ((Long) it.next()).longValue() + jA));
        }
        return arrayList;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f78729b.close();
    }

    public void d(ByteBuffer byteBuffer, long j11, int i11) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i11);
        long j12 = 0;
        while (j12 < i11) {
            int i12 = this.f78729b.read(byteBuffer, j11 + j12);
            if (i12 == -1) {
                throw new EOFException();
            }
            j12 += (long) i12;
        }
        byteBuffer.position(0);
    }

    public short e(ByteBuffer byteBuffer, long j11) throws IOException {
        d(byteBuffer, j11, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int g(ByteBuffer byteBuffer, long j11) throws IOException {
        d(byteBuffer, j11, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long h(ByteBuffer byteBuffer, long j11) throws IOException {
        d(byteBuffer, j11, 8);
        return byteBuffer.getLong();
    }

    public String i(ByteBuffer byteBuffer, long j11) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j12 = 1 + j11;
            short sE = e(byteBuffer, j11);
            if (sE == 0) {
                return sb2.toString();
            }
            sb2.append((char) sE);
            j11 = j12;
        }
    }

    public long j(ByteBuffer byteBuffer, long j11) throws IOException {
        d(byteBuffer, j11, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }
}
