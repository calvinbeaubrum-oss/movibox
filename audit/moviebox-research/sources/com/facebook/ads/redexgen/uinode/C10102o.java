package com.facebook.ads.redexgen.uinode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10102o {
    public static C10102o A05;
    public static byte[] A06;
    public static final Object A07;
    public final Context A00;
    public final Handler A01;
    public final HashMap<BroadcastReceiver, ArrayList<C10092n>> A04 = new HashMap<>();
    public final HashMap<String, ArrayList<C10092n>> A03 = new HashMap<>();
    public final ArrayList<C10082m> A02 = new ArrayList<>();

    static {
        A03();
        A07 = new Object();
    }

    public C10102o(Context context) {
        this.A00 = context;
        final Looper mainLooper = context.getMainLooper();
        this.A01 = new Handler(mainLooper) { // from class: com.facebook.ads.redexgen.X.2l
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.A00.A02();
                        break;
                    default:
                        super.handleMessage(message);
                        break;
                }
            }
        };
    }

    public static C10102o A00(Context context) {
        C10102o c10102o;
        synchronized (A07) {
            if (A05 == null) {
                A05 = new C10102o(context.getApplicationContext());
            }
            c10102o = A05;
        }
        return c10102o;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 80);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C10082m[] c10082mArr;
        while (true) {
            synchronized (this.A04) {
                int size = this.A02.size();
                if (size <= 0) {
                    return;
                }
                c10082mArr = new C10082m[size];
                this.A02.toArray(c10082mArr);
                this.A02.clear();
            }
            for (C10082m c10082m : c10082mArr) {
                int size2 = c10082m.A01.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    C10092n c10092n = c10082m.A01.get(i11);
                    if (!c10092n.A01) {
                        c10092n.A02.onReceive(this.A00, c10082m.A00);
                    }
                }
            }
        }
    }

    public static void A03() {
        A06 = new byte[]{-116, -116, -78, -43, -40, -32, -47, -34, -116, -48, -43, -48, -116, -38, -37, -32, -116, -39, -51, -32, -49, -44, -90, -116, -111, -111, -73, -38, -35, -27, -42, -29, -111, -34, -46, -27, -44, -39, -42, -43, -110, -111, -111, -34, -46, -27, -44, -39, -82, -95, -23, -102, -23, -32, -102, -29, -24, -18, -33, -24, -18, -102, 126, -47, -63, -58, -61, -53, -61, 126, -88, -54, -37, -48, -42, -43, -121, -45, -48, -38, -37, -95, -121, Ascii.ESC, 62, 50, 48, 59, 17, 65, 62, 48, 51, 50, 48, 66, 67, Ascii.FS, 48, 61, 48, 54, 52, 65, -51, -31, -12, -29, -24, -23, -18, -25, -96, -31, -25, -31, -23, -18, -13, -12, -96, -26, -23, -20, -12, -27, -14, -96, -80, -61, -47, -51, -54, -44, -57, -52, -59, 126, -46, -41, -50, -61, 126, -19, -17, 0, -11, -5, -6, -3, -5, Ascii.SO, -1, 1, 9, Ascii.FF, 19, 9, 6, Ascii.EM, 6, Ascii.GS, 34, Ascii.EM, Ascii.SO, -53, -60, -63, -60, -59, -51, -60, 118, -56, -69, -73, -55, -59, -60};
    }

    public final void A05(BroadcastReceiver broadcastReceiver) {
        synchronized (this.A04) {
            ArrayList<C10092n> arrayListRemove = this.A04.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                C10092n c10092n = arrayListRemove.get(size);
                c10092n.A01 = true;
                for (int i11 = 0; i11 < c10092n.A03.countActions(); i11++) {
                    String action = c10092n.A03.getAction(i11);
                    ArrayList<C10092n> arrayList = this.A03.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            C10092n c10092n2 = arrayList.get(size2);
                            if (c10092n2.A02 == broadcastReceiver) {
                                c10092n2.A01 = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.A03.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final void A06(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.A04) {
            C10092n c10092n = new C10092n(intentFilter, broadcastReceiver);
            ArrayList<C10092n> arrayList = this.A04.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.A04.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c10092n);
            for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                String action = intentFilter.getAction(i11);
                ArrayList<C10092n> arrayList2 = this.A03.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.A03.put(action, arrayList2);
                }
                arrayList2.add(c10092n);
            }
        }
    }

    public final boolean A07(Intent intent) {
        String strA01;
        synchronized (this.A04) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.A00.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z11 = (intent.getFlags() & 8) != 0;
            if (z11) {
                String str = A01(128, 15, 14) + strResolveTypeIfNeeded + A01(62, 8, 14) + scheme + A01(51, 11, 42) + intent;
            }
            ArrayList<C10092n> arrayList = this.A03.get(intent.getAction());
            if (arrayList != null) {
                if (z11) {
                    String str2 = A01(70, 13, 23) + arrayList;
                }
                ArrayList arrayList2 = null;
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    C10092n c10092n = arrayList.get(i11);
                    if (z11) {
                        String str3 = A01(104, 24, 48) + c10092n.A03;
                    }
                    if (!c10092n.A00) {
                        int iMatch = c10092n.A03.match(action, strResolveTypeIfNeeded, scheme, data, categories, A01(83, 21, 127));
                        if (iMatch >= 0) {
                            if (z11) {
                                String str4 = A01(24, 27, 33) + Integer.toHexString(iMatch);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(c10092n);
                            c10092n.A00 = true;
                        } else if (z11) {
                            switch (iMatch) {
                                case C.RESULT_BUFFER_READ /* -4 */:
                                    strA01 = A01(149, 8, 74);
                                    break;
                                case C.RESULT_NOTHING_READ /* -3 */:
                                    strA01 = A01(143, 6, 60);
                                    break;
                                case -2:
                                    strA01 = A01(157, 4, 85);
                                    break;
                                case -1:
                                    strA01 = A01(161, 4, 89);
                                    break;
                                default:
                                    strA01 = A01(165, 14, 6);
                                    break;
                            }
                            String str5 = A01(0, 24, 28) + strA01;
                        }
                    }
                }
                if (arrayList2 != null) {
                    for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                        ((C10092n) arrayList2.get(i12)).A00 = false;
                    }
                    this.A02.add(new C10082m(intent, arrayList2));
                    if (!this.A01.hasMessages(1)) {
                        this.A01.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
