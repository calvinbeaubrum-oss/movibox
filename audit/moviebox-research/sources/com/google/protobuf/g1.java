package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g1 {

    /* JADX INFO: compiled from: source.java */
    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteString f41277a;

        public a(ByteString byteString) {
            this.f41277a = byteString;
        }

        @Override // com.google.protobuf.g1.b
        public byte a(int i11) {
            return this.f41277a.byteAt(i11);
        }

        @Override // com.google.protobuf.g1.b
        public int size() {
            return this.f41277a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        byte a(int i11);

        int size();
    }

    public static String a(ByteString byteString) {
        return b(new a(byteString));
    }

    public static String b(b bVar) {
        StringBuilder sb2 = new StringBuilder(bVar.size());
        for (int i11 = 0; i11 < bVar.size(); i11++) {
            byte bA = bVar.a(i11);
            if (bA == 34) {
                sb2.append("\\\"");
            } else if (bA == 39) {
                sb2.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bA >>> 6) & 3) + 48));
                            sb2.append((char) (((bA >>> 3) & 7) + 48));
                            sb2.append((char) ((bA & 7) + 48));
                        } else {
                            sb2.append((char) bA);
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static String c(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
