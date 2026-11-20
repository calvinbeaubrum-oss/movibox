package com.facebook.ads.redexgen.uinode;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.29, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass29 extends Handler {
    public static byte[] A0A;
    public static String[] A0B = {"gcJlMo3lQ2pvKCdW2p1sJtuziP4vmf3g", "UeVkxUw", "", "mK9oSbAokt8TQ0dXUmD3wWyanMNanYZS", "2sppJEO", "qJx5aWB0ThxzYc01mDGkt7c3QG7aYNlh", "VEMLINTEzdP6zY82lzj", "ayakGQouLRgcgrHEvJCPTB1FEKY99m"};
    public Messenger A00;
    public boolean A01;
    public boolean A02;
    public final ServiceConnection A03;
    public final Handler A04;
    public final Messenger A05;
    public final AbstractC1867aa A06;
    public final C1795Yn A07;
    public final C1794Ym A08;
    public final KT A09;

    static {
        A07();
    }

    public AnonymousClass29(C1795Yn c1795Yn, AbstractC1867aa abstractC1867aa) {
        super(Looper.getMainLooper());
        this.A04 = new Handler(Looper.getMainLooper());
        this.A03 = new ServiceConnection() { // from class: com.facebook.ads.redexgen.X.28
            public static String[] A01 = {"ngGkpjAbiDqI5fNUZWfzpCs8", "ylP2urmrE90IxK0i7RWiCIXAIvzpBsdL", "aCR9COQiNO48m8MJLWSqKzp9WCyMnAsM", "D6rFEeRczM8yhG0IGlJtc", "Gyb732F4U9eQ07zP9Trhv", "a9bhlsDHuS7BulfVZwvbOQGE", "j3d2vbC0NzSo803R6jxXYJhh", "6nNXm2ki7xJE9GeftnLn59FQ"};

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                this.A00.A07.A0E().AEv();
                this.A00.A04.removeCallbacks(this.A00.A09);
                if (iBinder == null) {
                    this.A00.A07.A0E().AEx();
                    this.A00.A06();
                    return;
                }
                this.A00.A00 = new Messenger(iBinder);
                if (this.A00.A02) {
                    this.A00.A02 = false;
                    String[] strArr = A01;
                    if (strArr[2].charAt(5) == strArr[1].charAt(5)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[6] = "V9K6AFDlQ4uBqxixw85LWbfF";
                    strArr2[0] = "hRlL1oGWdG4Ka1T6AUojuR5g";
                    this.A00.A06.A06();
                }
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                this.A00.A07.A0E().AEw();
                if (this.A00.A01) {
                    this.A00.A06();
                }
            }
        };
        this.A07 = c1795Yn;
        this.A08 = c1795Yn.A01();
        this.A05 = new Messenger(this);
        this.A06 = abstractC1867aa;
        this.A09 = new C1853aM(this);
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A01) {
            A0C();
            if (A0B[0].charAt(10) != 'p') {
                throw new RuntimeException();
            }
            A0B[0] = "nLMfglhqWUp8cQyLFKCyrpcnfEaexaDa";
            this.A00 = null;
        }
        this.A06.A09();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        this.A00 = null;
        A0C();
        if (this.A06.A03().A5v() == AnonymousClass20.A07 || this.A06.A03().A5w() == AnonymousClass20.A08) {
            this.A07.A0E().AEm();
            this.A06.A0B(10, AdErrorType.INTERNAL_ERROR, null);
        } else if (this.A06.A03().A5v() == AnonymousClass20.A06) {
            this.A07.A0E().AEs();
            this.A06.A03().AG0(new AdError(2008, A04(26, 21, 94)));
        }
    }

    public static void A07() {
        A0A = new byte[]{106, 109, 119, 124, 113, 117, 124, 98, 115, 115, 124, 108, 113, 106, 102, 109, 119, 98, 119, 106, 108, 109, 124, 104, 102, 122, 124, 75, 67, 65, 90, 75, Ascii.SO, 93, 75, 92, 88, 71, 77, 75, Ascii.SO, 75, 92, 92, 65, 92, 0, 1, 6, 0, Ascii.CR, 19, Ascii.SYN, Ascii.CR, Ascii.ESC, Ascii.SYN, Ascii.CR, Ascii.EM, Ascii.ETB, Ascii.VT, 0, Ascii.US, 19, 1, 34, Ascii.SI, 6, 19};
    }

    private void A08(Messenger messenger, int i11, Bundle bundle) throws RemoteException {
        Message messageObtain = Message.obtain((Handler) null, i11);
        messageObtain.replyTo = this.A05;
        if (bundle != null) {
            messageObtain.setData(bundle);
        }
        messageObtain.getData().putString(A04(47, 13, 34), this.A06.A04());
        messenger.send(messageObtain);
    }

    public static void A0B(C1795Yn c1795Yn) {
        c1795Yn.A0E().AEg();
        C2F c2f = (C2F) c1795Yn.A0G();
        if (c2f == null || c2f.A01() == null || c2f.A00() == null) {
            return;
        }
        c2f.A01().onError(c2f.A00(), AdError.AD_PRESENTATION_ERROR);
    }

    public final void A0C() {
        if (this.A01) {
            this.A07.A0E().AF3();
            this.A01 = false;
            this.A08.unbindService(this.A03);
        }
    }

    public final void A0D(C1795Yn c1795Yn, int i11) {
        this.A07.A0E().AF2();
        AdActivityIntent adActivityIntentA04 = C1433Kj.A04(c1795Yn);
        adActivityIntentA04.putExtra(A04(60, 8, 6), KB.A0E);
        adActivityIntentA04.putExtra(A04(47, 13, 34), this.A06.A04());
        adActivityIntentA04.putExtra(A04(0, 26, 83), i11);
        try {
            if (C1433Kj.A0E(c1795Yn, adActivityIntentA04)) {
                return;
            }
            A0B(c1795Yn);
        } catch (C1431Kh unused) {
            A0B(c1795Yn);
        }
    }

    public final void A0E(boolean z11) {
        boolean zA04 = C2A.A04(this.A08, z11, this.A03);
        this.A01 = zA04;
        if (zA04) {
            this.A07.A0E().AEi();
            this.A04.postDelayed(this.A09, AbstractC1386Ik.A00(this.A08));
        } else {
            this.A07.A0E().AEq();
            this.A02 = false;
            this.A06.A09();
        }
    }

    public final boolean A0F(int i11, Bundle bundle) {
        try {
            Messenger messenger = this.A00;
            if (messenger == null) {
                return false;
            }
            A08(messenger, i11, bundle);
            return true;
        } catch (RemoteException e11) {
            A0C();
            this.A07.A0E().AEl(e11);
            return false;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (message.what == 3) {
                return;
            }
            if (message.what == 20 || message.what == 30 || message.what == 40) {
                if (message.what == 20) {
                    this.A07.A0E().AEz();
                    AbstractC1386Ik.A06(this.A08);
                } else {
                    this.A07.A0E().AEy();
                }
                A05();
                return;
            }
            if (!this.A06.A04().equals(message.getData().getString(A04(47, 13, 34)))) {
                this.A07.A0E().AF4();
                return;
            }
            if (message.what != 2001) {
                int i11 = message.what;
                if (A0B[7].length() == 29) {
                    throw new RuntimeException();
                }
                A0B[6] = "2Ci3XLBIg3EoaCOidfd";
                if (i11 != 1011) {
                    this.A07.A0E().AEr(message.what);
                    this.A06.A0C(message);
                    return;
                }
            }
            C2A.A02(this.A08, message);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
