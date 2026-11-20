package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.newreward.function.d.c.q;
import com.mbridge.msdk.newreward.function.d.c.x;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.c f46016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f46017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46018c = 0;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.a.b.d$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46021a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.c.e.values().length];
            f46021a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46021a[com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.c.e eVar, com.mbridge.msdk.newreward.function.d.a.b bVar, int i11, String str) {
        com.mbridge.msdk.newreward.function.c.c cVar = this.f46016a;
        if (cVar == null || this.f46017b == null) {
            return;
        }
        try {
            Map mapA = cVar.a("resource_type", 1, "url", bVar.u().j());
            int i12 = AnonymousClass2.f46021a[eVar.ordinal()];
            if (i12 == 1) {
                mapA.put("cache", Integer.valueOf(this.f46018c));
                this.f46016a.a(this.f46017b, eVar, mapA);
            } else if (i12 == 2 && this.f46018c == 2) {
                mapA.put("result", Integer.valueOf(i11));
                if (i11 != 1) {
                    mapA.put("reason", str);
                }
                this.f46016a.a(this.f46017b, eVar, mapA);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, final b bVar) throws IOException {
        com.mbridge.msdk.newreward.function.d.a.b bVar2 = (com.mbridge.msdk.newreward.function.d.a.b) obj;
        com.mbridge.msdk.newreward.function.d.c.d<?> dVarU = bVar2.u();
        if (bVar2.F() != null) {
            if (bVar2.F().containsKey("command_manager")) {
                this.f46016a = (com.mbridge.msdk.newreward.function.c.c) bVar2.F().get("command_manager");
            }
            if (bVar2.F().containsKey("adapter_model")) {
                this.f46017b = (com.mbridge.msdk.newreward.a.e) bVar2.F().get("adapter_model");
            }
        }
        if (dVarU == null) {
            bVar.a(bVar2);
            return;
        }
        if (dVarU.e() == 1) {
            this.f46018c = 1;
        } else {
            this.f46018c = 2;
        }
        a(com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_START, bVar2, 0, "");
        dVarU.k().a(0, new x() { // from class: com.mbridge.msdk.newreward.a.b.d.1
            private void a(com.mbridge.msdk.newreward.function.d.a.b bVar3, b bVar4, MBridgeError mBridgeError, String str) {
                int errorCode;
                String errorMessage;
                if (bVar3.x()) {
                    try {
                        bVar4.a(bVar3);
                        return;
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.a("ReqDownBigTempleService", "doReq: ", e11);
                            return;
                        }
                        return;
                    }
                }
                if (mBridgeError != null) {
                    try {
                        errorCode = mBridgeError.getErrorCode();
                        errorMessage = mBridgeError.getErrorMessage();
                    } catch (Exception e12) {
                        if (MBridgeConstans.DEBUG) {
                            ad.a("ReqDownBigTempleService", "doReq: ", e12);
                            return;
                        }
                        return;
                    }
                } else {
                    errorMessage = "big temp load fail ";
                    errorCode = -1;
                }
                bVar4.a(com.mbridge.msdk.foundation.c.a.a(errorCode, 880005, str + errorMessage));
            }

            @Override // com.mbridge.msdk.newreward.function.d.c.x
            public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar3, com.mbridge.msdk.newreward.function.d.a.a aVar, q qVar) {
            }

            @Override // com.mbridge.msdk.newreward.function.d.c.x
            public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar3, com.mbridge.msdk.newreward.function.d.a.a aVar, q qVar, MBridgeError mBridgeError) {
                d.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_END, bVar3, 3, mBridgeError != null ? mBridgeError.getErrorMessage() : "");
                a(bVar3, bVar, mBridgeError, "errorCode: 3203 errorMessage:");
            }

            @Override // com.mbridge.msdk.newreward.function.d.c.x
            public final void b(com.mbridge.msdk.newreward.function.d.a.b bVar3, com.mbridge.msdk.newreward.function.d.a.a aVar, q qVar) {
                d.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_END, bVar3, 1, "");
                bVar.a(bVar3);
            }

            @Override // com.mbridge.msdk.newreward.function.d.c.x
            public final void b(com.mbridge.msdk.newreward.function.d.a.b bVar3, com.mbridge.msdk.newreward.function.d.a.a aVar, q qVar, MBridgeError mBridgeError) {
                d.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_END, bVar3, 2, mBridgeError != null ? mBridgeError.getErrorMessage() : "");
                a(bVar3, bVar, mBridgeError, "errorCode: 3401 errorMessage: ");
            }
        });
    }
}
