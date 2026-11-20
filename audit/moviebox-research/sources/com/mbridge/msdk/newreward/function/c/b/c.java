package com.mbridge.msdk.newreward.function.c.b;

import com.mbridge.msdk.newreward.function.c.b.a.g;
import com.mbridge.msdk.newreward.function.c.b.a.h;
import com.mbridge.msdk.newreward.function.c.b.a.j;
import com.mbridge.msdk.newreward.function.c.b.a.k;
import com.mbridge.msdk.newreward.function.c.b.a.l;
import com.mbridge.msdk.newreward.function.c.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f46239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<e, Object> f46240b;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.c.b.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46241a;

        static {
            int[] iArr = new int[e.values().length];
            f46241a = iArr;
            try {
                iArr[e.RESTORE_DB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46241a[e.SMART_LOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46241a[e.NORMAL_LOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46241a[e.PRE_HANDLE_LOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46241a[e.UNIT_INIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46241a[e.CHECK_IS_REQUEST_CONTROL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46241a[e.UPDATE_CAM_TOKEN_RULE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f46241a[e.START_LOAD_CHECK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46241a[e.CANDIDATE_LOAD_ACTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f46239a == null) {
            synchronized (c.class) {
                try {
                    if (f46239a == null) {
                        f46239a = new c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f46239a;
    }

    public final <T extends a> T a(e eVar) {
        int i11 = AnonymousClass1.f46241a[eVar.ordinal()];
        if (i11 == 1) {
            return new h();
        }
        if (i11 == 2) {
            return new j();
        }
        if (i11 == 3) {
            return new com.mbridge.msdk.newreward.function.c.b.a.d();
        }
        if (i11 == 4) {
            return new com.mbridge.msdk.newreward.function.c.b.a.e();
        }
        if (i11 != 5) {
            return null;
        }
        return new k();
    }

    public final <T extends d> T b(e eVar) {
        switch (AnonymousClass1.f46241a[eVar.ordinal()]) {
            case 6:
                return new g();
            case 7:
                return new l();
            case 8:
                return new com.mbridge.msdk.newreward.function.c.b.a.c();
            case 9:
                if (this.f46240b == null) {
                    this.f46240b = new HashMap();
                }
                Map<e, Object> map = this.f46240b;
                e eVar2 = e.CANDIDATE_LOAD_ACTION;
                T t11 = map.containsKey(eVar2) ? (T) this.f46240b.get(eVar2) : null;
                if (t11 != null) {
                    return t11;
                }
                com.mbridge.msdk.newreward.function.c.b.a.a aVar = new com.mbridge.msdk.newreward.function.c.b.a.a();
                this.f46240b.put(eVar2, aVar);
                return aVar;
            default:
                return null;
        }
    }
}
