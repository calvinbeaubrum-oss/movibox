package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class z0 implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f41454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f41456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41457d;

    public z0(n0 n0Var, String str, Object[] objArr) {
        String str2;
        Throwable e11;
        char cCharAt;
        this.f41454a = n0Var;
        this.f41455b = str;
        this.f41456c = objArr;
        int i11 = 1;
        try {
            cCharAt = str.charAt(0);
        } catch (StringIndexOutOfBoundsException unused) {
            char[] charArray = str.toCharArray();
            String str3 = new String(charArray);
            try {
                try {
                    cCharAt = str3.charAt(0);
                    str = str3;
                } catch (StringIndexOutOfBoundsException unused2) {
                    char[] cArr = new char[str3.length()];
                    str3.getChars(0, str3.length(), cArr, 0);
                    str2 = new String(cArr);
                    try {
                        cCharAt = str2.charAt(0);
                        str = str2;
                    } catch (ArrayIndexOutOfBoundsException e12) {
                        e11 = e12;
                        throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e11);
                    } catch (StringIndexOutOfBoundsException e13) {
                        e11 = e13;
                        throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e11);
                    }
                }
            } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e14) {
                str2 = str3;
                e11 = e14;
                throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e11);
            }
        }
        if (cCharAt < 55296) {
            this.f41457d = cCharAt;
            return;
        }
        int i12 = cCharAt & 8191;
        int i13 = 13;
        while (true) {
            int i14 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f41457d = (cCharAt2 << i13) | i12;
                return;
            } else {
                i12 |= (cCharAt2 & 8191) << i13;
                i13 += 13;
                i11 = i14;
            }
        }
    }

    @Override // com.google.protobuf.l0
    public boolean a() {
        return (this.f41457d & 2) == 2;
    }

    @Override // com.google.protobuf.l0
    public n0 b() {
        return this.f41454a;
    }

    @Override // com.google.protobuf.l0
    public ProtoSyntax c() {
        return (this.f41457d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    public Object[] d() {
        return this.f41456c;
    }

    public String e() {
        return this.f41455b;
    }
}
