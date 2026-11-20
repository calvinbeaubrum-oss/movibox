package com.cloud.tmc.miniapp.utils;

import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.render.proxy.SessionUtilProxy;
import hd.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionUtils implements SessionUtilProxy {
    public final ConcurrentHashMap<String, a> OooO00o = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f31810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f31811b;

        public a() {
            this(false, null, 3);
        }

        public a(boolean z11, String id2) {
            Intrinsics.g(id2, "id");
            this.f31810a = z11;
            this.f31811b = id2;
        }

        public /* synthetic */ a(boolean z11, String str, int i11) {
            this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? "" : str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f31810a == aVar.f31810a && Intrinsics.b(this.f31811b, aVar.f31811b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public int hashCode() {
            boolean z11 = this.f31810a;
            ?? r11 = z11;
            if (z11) {
                r11 = 1;
            }
            return this.f31811b.hashCode() + (r11 * 31);
        }

        public String toString() {
            StringBuilder sbA = j.a("IdData(isColdOpen=");
            sbA.append(this.f31810a);
            sbA.append(", id=");
            sbA.append(this.f31811b);
            sbA.append(')');
            return sbA.toString();
        }
    }

    @Override // com.cloud.tmc.render.proxy.SessionUtilProxy
    public String getId(String str) {
        a aVar;
        String str2;
        if (str == null) {
            return "";
        }
        try {
            return (!this.OooO00o.containsKey(str) || (aVar = this.OooO00o.get(str)) == null || (str2 = aVar.f31811b) == null) ? "" : str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.cloud.tmc.render.proxy.SessionUtilProxy
    public void removeSession(String str) {
        if (str != null) {
            try {
                this.OooO00o.remove(str);
            } catch (Throwable unused) {
                Unit unit = Unit.f68710a;
            }
        }
    }

    @Override // com.cloud.tmc.render.proxy.SessionUtilProxy
    public void updateSession(String str, boolean z11, boolean z12) {
        if (str != null) {
            int i11 = 1;
            boolean z13 = false;
            try {
                if (z12) {
                    this.OooO00o.remove(str);
                    this.OooO00o.put(str, new a(z13, q.d() + '_' + System.currentTimeMillis(), i11));
                } else if (this.OooO00o.containsKey(str)) {
                    a aVar = (a) s.i(this.OooO00o, str);
                    boolean z14 = aVar.f31810a;
                    if (z14 && z11) {
                        aVar.f31810a = false;
                    } else if (z11 && !z14) {
                        String str2 = q.d() + '_' + System.currentTimeMillis();
                        Intrinsics.g(str2, "<set-?>");
                        aVar.f31811b = str2;
                    }
                } else {
                    this.OooO00o.put(str, new a(z13, q.d() + '_' + System.currentTimeMillis(), i11));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
