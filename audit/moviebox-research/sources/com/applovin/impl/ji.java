package com.applovin.impl;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ji {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f19972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f19973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f19974c;

        public a(UUID uuid, int i11, byte[] bArr) {
            this.f19972a = uuid;
            this.f19973b = i11;
            this.f19974c = bArr;
        }
    }

    public static boolean a(byte[] bArr) {
        return b(bArr) != null;
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return a(uuid, null, bArr);
    }

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
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
        if (bArr != null && bArr.length != 0) {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static byte[] a(byte[] bArr, UUID uuid) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return null;
        }
        if (uuid.equals(aVarB.f19972a)) {
            return aVarB.f19974c;
        }
        pc.d("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarB.f19972a + InstructionFileId.DOT);
        return null;
    }

    private static a b(byte[] bArr) {
        bh bhVar = new bh(bArr);
        if (bhVar.e() < 32) {
            return null;
        }
        bhVar.f(0);
        if (bhVar.j() != bhVar.a() + 4 || bhVar.j() != 1886614376) {
            return null;
        }
        int iC = j1.c(bhVar.j());
        if (iC > 1) {
            pc.d("PsshAtomUtil", "Unsupported pssh version: " + iC);
            return null;
        }
        UUID uuid = new UUID(bhVar.s(), bhVar.s());
        if (iC == 1) {
            bhVar.g(bhVar.A() * 16);
        }
        int iA = bhVar.A();
        if (iA != bhVar.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iA];
        bhVar.a(bArr2, 0, iA);
        return new a(uuid, iC, bArr2);
    }

    public static UUID c(byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return null;
        }
        return aVarB.f19972a;
    }

    public static int d(byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return -1;
        }
        return aVarB.f19973b;
    }
}
