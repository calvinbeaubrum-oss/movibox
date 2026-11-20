package l5;

import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.nio.ByteBuffer;
import java.util.UUID;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f69915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f69916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f69917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final UUID[] f69918d;

        public a(UUID uuid, int i11, byte[] bArr, @Nullable UUID[] uuidArr) {
            this.f69915a = uuid;
            this.f69916b = i11;
            this.f69917c = bArr;
            this.f69918d = uuidArr;
        }
    }

    public static byte[] a(UUID uuid, @Nullable byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            byteBufferAllocate.putInt(0);
        } else {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    @Nullable
    public static a d(byte[] bArr) {
        UUID[] uuidArr;
        c0 c0Var = new c0(bArr);
        if (c0Var.g() < 32) {
            return null;
        }
        c0Var.U(0);
        int iA = c0Var.a();
        int iQ = c0Var.q();
        if (iQ != iA) {
            z3.o.h("PsshAtomUtil", "Advertised atom size (" + iQ + ") does not match buffer size: " + iA);
            return null;
        }
        int iQ2 = c0Var.q();
        if (iQ2 != 1886614376) {
            z3.o.h("PsshAtomUtil", "Atom type is not pssh: " + iQ2);
            return null;
        }
        int iC = l5.a.c(c0Var.q());
        if (iC > 1) {
            z3.o.h("PsshAtomUtil", "Unsupported pssh version: " + iC);
            return null;
        }
        UUID uuid = new UUID(c0Var.A(), c0Var.A());
        if (iC == 1) {
            int iL = c0Var.L();
            uuidArr = new UUID[iL];
            for (int i11 = 0; i11 < iL; i11++) {
                uuidArr[i11] = new UUID(c0Var.A(), c0Var.A());
            }
        } else {
            uuidArr = null;
        }
        int iL2 = c0Var.L();
        int iA2 = c0Var.a();
        if (iL2 == iA2) {
            byte[] bArr2 = new byte[iL2];
            c0Var.l(bArr2, 0, iL2);
            return new a(uuid, iC, bArr2, uuidArr);
        }
        z3.o.h("PsshAtomUtil", "Atom data size (" + iL2 + ") does not match the bytes left: " + iA2);
        return null;
    }

    @Nullable
    public static byte[] e(byte[] bArr, UUID uuid) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        if (uuid.equals(aVarD.f69915a)) {
            return aVarD.f69917c;
        }
        z3.o.h("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarD.f69915a + InstructionFileId.DOT);
        return null;
    }

    @Nullable
    public static UUID f(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        return aVarD.f69915a;
    }

    public static int g(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return -1;
        }
        return aVarD.f69916b;
    }
}
