package com.facebook.ads.redexgen.uinode;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C8 extends AbstractC1771Xp<C5, AbstractC1232Br, C1316Fp> implements WL {
    public static byte[] A01;
    public final String A00;

    static {
        A0J();
    }

    public C8(String str) {
        super(new C5[2], new AbstractC1232Br[2]);
        this.A00 = str;
        A0Y(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.6Q] */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC1771Xp
    /* JADX INFO: renamed from: A0E, reason: merged with bridge method [inline-methods] */
    public final C6Q A0V() {
        return new AbstractC1232Br(this) { // from class: com.facebook.ads.redexgen.X.6Q
            public final C8 A00;

            {
                this.A00 = this;
            }

            @Override // com.facebook.ads.redexgen.uinode.AbstractC1232Br
            public final void A08() {
                this.A00.A0c(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC1771Xp
    /* JADX INFO: renamed from: A0F, reason: merged with bridge method [inline-methods] */
    public final C1316Fp A0W(C5 c11, AbstractC1232Br abstractC1232Br, boolean z11) {
        try {
            ByteBuffer byteBuffer = c11.A01;
            abstractC1232Br.A09(((C1773Xr) c11).A00, A0b(byteBuffer.array(), byteBuffer.limit(), z11), c11.A00);
            abstractC1232Br.A01(Integer.MIN_VALUE);
            return null;
        } catch (C1316Fp e11) {
            return e11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC1771Xp
    /* JADX INFO: renamed from: A0G, reason: merged with bridge method [inline-methods] */
    public final C1316Fp A0X(Throwable th2) {
        return new C1316Fp(A0I(0, 23, 36), th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC1771Xp
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final C5 A0T() {
        return new C5();
    }

    public static String A0I(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0J() {
        A01 = new byte[]{-68, -43, -52, -33, -41, -52, -54, -37, -52, -53, -121, -53, -52, -54, -42, -53, -52, -121, -52, -39, -39, -42, -39};
    }

    public abstract InterfaceC1315Fo A0b(byte[] bArr, int i11, boolean z11) throws C1316Fp;

    public final void A0c(AbstractC1232Br abstractC1232Br) {
        super.A0a(abstractC1232Br);
    }

    @Override // com.facebook.ads.redexgen.uinode.WL
    public final void AGB(long j11) {
    }
}
