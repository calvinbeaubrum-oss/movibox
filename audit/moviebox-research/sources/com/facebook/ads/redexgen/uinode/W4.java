package com.facebook.ads.redexgen.uinode;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W4 implements InterfaceC1346Gu {
    public static byte[] A07;
    public static String[] A08 = {"LByWpbEPJA", "7zBd1gTQe", "KuygTrv8nulqhNSWOngA1uKtSEuZHgRN", "Njgdt1gsnhQwK4o", "BeNPg2roj36bAWsP0", "RQRmVWofVgKwOSOG8v2k1lAFTXU782LE", "P3wGsXlJvJ2cmEHDxz1oaqJg", "cQN91p4HTGgxD32"};
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public FileInputStream A03;
    public boolean A04;
    public final ContentResolver A05;
    public final HG<? super W4> A06;

    static {
        A01();
    }

    public W4(Context context, HG<? super W4> hg2) {
        this.A05 = context.getContentResolver();
        this.A06 = hg2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{77, 97, 123, 98, 106, 46, 96, 97, 122, 46, 97, 126, 107, 96, 46, 104, 103, 98, 107, 46, 106, 107, 125, 109, 124, 103, 126, 122, 97, 124, 46, 104, 97, 124, 52, 46, 88};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final Uri A8E() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final long ADl(C1350Gy c1350Gy) throws C1342Gq {
        try {
            Uri uri = c1350Gy.A04;
            this.A02 = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.A05.openAssetFileDescriptor(uri, A00(36, 1, 66));
            this.A01 = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException(A00(0, 36, 102) + this.A02);
            }
            this.A03 = new FileInputStream(this.A01.getFileDescriptor());
            long startOffset = this.A01.getStartOffset();
            long jSkip = this.A03.skip(c1350Gy.A03 + startOffset) - startOffset;
            if (jSkip != c1350Gy.A03) {
                throw new EOFException();
            }
            if (c1350Gy.A02 != -1) {
                this.A00 = c1350Gy.A02;
            } else {
                long length = this.A01.getLength();
                if (length == -1) {
                    FileChannel channel = this.A03.getChannel();
                    long size = channel.size();
                    this.A00 = size != 0 ? size - channel.position() : -1L;
                } else {
                    this.A00 = length - jSkip;
                }
            }
            this.A04 = true;
            HG<? super W4> hg2 = this.A06;
            if (hg2 != null) {
                hg2.ADP(this, c1350Gy);
            }
            return this.A00;
        } catch (IOException e11) {
            throw new C1342Gq(e11);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x002b */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() throws C1342Gq {
        this.A02 = null;
        try {
            try {
                FileInputStream fileInputStream = this.A03;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.A03 = null;
                try {
                    AssetFileDescriptor assetFileDescriptor = this.A01;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.A01 = null;
                    if (this.A04) {
                        this.A04 = false;
                        HG<? super W4> hg2 = this.A06;
                        if (hg2 != null) {
                            hg2.ADO(this);
                        }
                    }
                } catch (IOException e11) {
                    throw new C1342Gq(e11);
                }
            } catch (Throwable th2) {
                this.A03 = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.A01;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.A01 = null;
                        if (this.A04) {
                            this.A04 = false;
                            HG<? super W4> hg3 = this.A06;
                            if (hg3 != null) {
                                hg3.ADO(this);
                            }
                        }
                        throw th2;
                    } catch (Throwable th3) {
                        this.A01 = null;
                        if (this.A04) {
                            this.A04 = false;
                            HG<? super W4> hg4 = this.A06;
                            if (hg4 != null) {
                                hg4.ADO(this);
                            }
                        }
                        throw th3;
                    }
                } catch (IOException e12) {
                    throw new C1342Gq(e12);
                }
            }
        } catch (IOException e13) {
            throw new C1342Gq(e13);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final int read(byte[] bArr, int i11, int i12) throws C1342Gq {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.A00;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new C1342Gq(e11);
            }
        }
        int i13 = this.A03.read(bArr, i11, i12);
        if (i13 == -1) {
            long j12 = this.A00;
            String[] strArr = A08;
            if (strArr[3].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A08[0] = "iixlGiSV2y9Sj4FhSzJ8n8KndyylS";
            if (j12 == -1) {
                return -1;
            }
            throw new C1342Gq(new EOFException());
        }
        long j13 = this.A00;
        if (A08[0].length() != 5) {
            A08[0] = "YPxf1aEs9O2Lc7g4LGclNCu";
            if (j13 != -1) {
                this.A00 = j13 - ((long) i13);
            }
        } else if (j13 != -1) {
            this.A00 = j13 - ((long) i13);
        }
        HG<? super W4> hg2 = this.A06;
        if (A08[4].length() != 17) {
            A08[0] = "Oz3XLfSc2A979xkKdF0NMgeVRm8";
            if (hg2 != null) {
                hg2.AB1(this, i13);
            }
        } else {
            String[] strArr2 = A08;
            strArr2[1] = "uqZ1tM2xm";
            strArr2[6] = "4bkl7P4p23vj4jNsoeIfag2n";
            if (hg2 != null) {
                hg2.AB1(this, i13);
            }
        }
        return i13;
    }
}
