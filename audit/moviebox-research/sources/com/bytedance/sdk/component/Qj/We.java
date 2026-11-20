package com.bytedance.sdk.component.Qj;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.Tf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private static AtomicInteger zY = new AtomicInteger(0);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final String[] f26558sc = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] pFF = {"tt_pangle", "bd_tracker"};
    private static int We = 0;
    private static int ExN = 0;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public String We;
        public String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f26559sc;
        public String zY;

        public sc(String str, int i11, String str2, String str3) {
            this.zY = str;
            this.f26559sc = i11;
            this.We = str2;
            this.pFF = str3;
        }

        public int sc() {
            return this.f26559sc;
        }

        public void sc(int i11) {
            this.f26559sc = i11;
        }

        public String toString() {
            return "ThreadModel{times=" + this.f26559sc + ", name='" + this.pFF + "', lastStackStack='" + this.zY + "'}";
        }
    }

    private static void pFF() {
        zY zYVarOl = TRI.Ol();
        if (zYVarOl == null) {
            return;
        }
        int i11 = 1;
        int iAddAndGet = zY.addAndGet(1);
        int i12 = TRI.zY;
        if (i12 < 0 || iAddAndGet % i12 != 0 || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        HashMap map = new HashMap();
        if (allStackTraces == null) {
            return;
        }
        boolean zSc = Tf.sc();
        int size = allStackTraces.size();
        if (size > ExN) {
            ExN = size;
        }
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i13 = 0;
        int i14 = 0;
        while (it.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            i14 += i11;
            Thread key = next.getKey();
            StackTraceElement[] value = next.getValue();
            StringBuilder sb2 = new StringBuilder("\n");
            if (zSc) {
                sb2.append("Thread Name is : " + key.getName());
                sb2.append("\n");
            }
            int length = value.length;
            String str = null;
            int i15 = 0;
            while (i15 < length) {
                String string = value[i15].toString();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                if (zSc) {
                    sb2.append(string + "\n");
                }
                if (TextUtils.isEmpty(str) && (sc(string, f26558sc) || sc(key.getName(), pFF))) {
                    i13++;
                    str = string;
                }
                i15++;
                it = it2;
            }
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
            if (zSc) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = str + "&" + key.getName();
                    sc scVar = (sc) map.get(str2);
                    if (scVar != null) {
                        scVar.sc(scVar.sc() + 1);
                    } else {
                        scVar = new sc(str2, 1, sb2.toString(), key.getName());
                    }
                    map.put(str2, scVar);
                }
                if (!TextUtils.isEmpty(sb2.toString())) {
                    Log.e("PoolTaskStatistics", "Thread index = " + i14 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    Log.w("PoolTaskStatistics", sb2.toString());
                }
            }
            it = it3;
            i11 = 1;
        }
        if (i13 > We) {
            We = i13;
        }
        if (zSc) {
            Log.e("PoolTaskStatistics", "SDK current threads=" + i13 + ", SDK Max threads=" + We + ", Application threads = " + size + ", Application max threads = " + ExN);
            Iterator it4 = map.entrySet().iterator();
            while (it4.hasNext()) {
                ((sc) ((Map.Entry) it4.next()).getValue()).toString();
            }
        }
        zYVarOl.sc(new com.bytedance.sdk.component.Qj.pFF.sc(i13, We, size, ExN));
    }

    public static void sc() {
        try {
            pFF();
        } catch (Throwable unused) {
        }
    }

    private static boolean sc(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
