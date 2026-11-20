package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.apm.insight.entity.Header;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q f17110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f17111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f17112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f17113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f17114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f17115f = null;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f17118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f17119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private File f17120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f17121d;

        private a(File file) {
            this.f17121d = null;
            this.f17120c = file;
            String[] strArrSplit = file.getName().split("-|\\.");
            if (strArrSplit.length >= 2) {
                this.f17118a = Long.parseLong(strArrSplit[0]);
                this.f17119b = Long.parseLong(strArrSplit[1]);
                return;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name) || name.length() < 13) {
                return;
            }
            String strSubstring = name.substring(0, 13);
            if (TextUtils.isDigitsOnly(strSubstring)) {
                long j11 = Long.parseLong(strSubstring);
                this.f17118a = j11;
                this.f17119b = j11;
            }
        }

        public /* synthetic */ a(File file, byte b11) {
            this(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject a() {
            if (this.f17121d == null) {
                try {
                    this.f17121d = new JSONObject(com.apm.insight.l.f.a(this.f17120c.getAbsolutePath(), "\n"));
                } catch (Throwable unused) {
                }
                if (this.f17121d == null) {
                    this.f17121d = new JSONObject();
                }
            }
            return this.f17121d;
        }

        public static /* synthetic */ boolean a(a aVar, long j11) {
            long j12 = aVar.f17118a;
            if (j12 > j11 && j12 - j11 > 604800000) {
                return true;
            }
            long j13 = aVar.f17119b;
            if (j13 >= j11 || j11 - j13 <= 604800000) {
                return aVar.f17120c.lastModified() < j11 && j11 - aVar.f17120c.lastModified() > 604800000;
            }
            return true;
        }

        public static /* synthetic */ void d(a aVar) {
            aVar.f17120c.delete();
        }
    }

    private q(Context context) {
        File fileC = com.apm.insight.l.j.c(context);
        if (!fileC.exists() || (!fileC.isDirectory() && fileC.delete())) {
            fileC.mkdirs();
            com.apm.insight.runtime.a.b.a();
        }
        this.f17111b = fileC;
        this.f17112c = new File(fileC, "did");
        this.f17113d = new File(fileC, "device_uuid");
        this.f17114e = context;
    }

    public static q a() {
        if (f17110a == null) {
            f17110a = new q(com.apm.insight.e.g());
        }
        return f17110a;
    }

    private void a(long j11, long j12, JSONObject jSONObject, JSONArray jSONArray) {
        File file = new File(this.f17111b, j11 + "-" + j12 + ".ctx");
        File file2 = new File(this.f17111b, j11 + "-" + j12 + ".allData");
        try {
            com.apm.insight.l.f.a(file, jSONObject);
            com.apm.insight.l.f.a(file2, jSONArray);
            this.f17115f = new a(file, (byte) 0);
        } catch (IOException e11) {
            com.apm.insight.c.a();
            k.a(e11, "NPTH_CATCH");
        }
    }

    private ArrayList<a> c(final String str) {
        File[] fileArrListFiles = this.f17111b.listFiles(new FilenameFilter() { // from class: com.apm.insight.runtime.q.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return str2.endsWith(str) && Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(str2).matches();
            }
        });
        ArrayList<a> arrayList = new ArrayList<>();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        com.apm.insight.a.a((Object) ("foundRuntimeContextFiles " + fileArrListFiles.length));
        byte b11 = 0;
        a aVar = null;
        for (File file : fileArrListFiles) {
            try {
                a aVar2 = new a(file, b11);
                arrayList.add(aVar2);
                if (this.f17115f == null && ".ctx".equals(str) && (aVar == null || aVar2.f17119b >= aVar.f17119b)) {
                    aVar = aVar2;
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                k.a(th2, "NPTH_CATCH");
            }
        }
        if (this.f17115f == null && aVar != null) {
            this.f17115f = aVar;
        }
        return arrayList;
    }

    @Nullable
    public final JSONObject a(long j11) {
        JSONObject jSONObject;
        File file;
        boolean z11;
        String strA;
        Iterator<a> it = c(".ctx").iterator();
        while (true) {
            jSONObject = null;
            if (!it.hasNext()) {
                file = null;
                break;
            }
            a next = it.next();
            if (j11 >= next.f17118a && j11 <= next.f17119b) {
                file = next.f17120c;
                break;
            }
        }
        if (file == null) {
            a aVar = null;
            for (a aVar2 : c(".ctx")) {
                if (aVar == null || Math.abs(aVar.f17119b - j11) > Math.abs(aVar2.f17119b - j11)) {
                    aVar = aVar2;
                }
            }
            file = aVar == null ? null : aVar.f17120c;
            z11 = true;
        } else {
            z11 = false;
        }
        if (file != null) {
            try {
                strA = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
                try {
                    jSONObject = new JSONObject(strA);
                } catch (Throwable th2) {
                    th = th2;
                    com.apm.insight.c.a();
                    k.a(new IOException("content :".concat(String.valueOf(strA)), th), "NPTH_CATCH");
                }
            } catch (Throwable th3) {
                th = th3;
                strA = null;
            }
        }
        if (jSONObject != null && z11) {
            try {
                jSONObject.put("unauthentic_version", 1);
            } catch (JSONException e11) {
                com.apm.insight.c.a();
                k.a(e11, "NPTH_CATCH");
            }
        }
        return jSONObject;
    }

    public final void a(String str) {
        try {
            com.apm.insight.l.f.a(this.f17112c, str, false);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005e  */
    public final void a(Map<String, Object> map, JSONArray jSONArray) {
        char c11;
        JSONObject jSONObjectA = Header.a(this.f17114e).a(map);
        if (Header.c(jSONObjectA)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f17115f == null) {
            c(".ctx");
        }
        a aVar = this.f17115f;
        if (aVar == null) {
            a(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectA, jSONArray);
            return;
        }
        JSONObject jSONObjectA2 = aVar.a();
        if (Header.c(jSONObjectA2)) {
            c11 = 2;
        } else if (Header.c(jSONObjectA)) {
            c11 = 0;
        } else if (String.valueOf(jSONObjectA.opt("update_version_code")).equals(String.valueOf(jSONObjectA2.opt("update_version_code"))) && Header.d(jSONObjectA2)) {
            c11 = 1;
        } else {
            c11 = 2;
        }
        if (c11 == 1) {
            a(aVar.f17118a, jCurrentTimeMillis, jSONObjectA, jSONArray);
            com.apm.insight.l.f.a(aVar.f17120c);
        } else if (c11 == 2) {
            a(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectA, jSONArray);
        }
        try {
            ArrayList<a> arrayListC = c("");
            if (arrayListC.size() <= 6) {
                return;
            }
            for (a aVar2 : arrayListC) {
                if (a.a(aVar2, jCurrentTimeMillis)) {
                    a.d(aVar2);
                }
            }
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            k.a(th2, "NPTH_CATCH");
        }
    }

    public final String b() {
        try {
            return com.apm.insight.l.f.a(this.f17112c.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return "0";
        }
    }

    @Nullable
    public final JSONArray b(long j11) {
        File file;
        String strA;
        Iterator<a> it = c(".allData").iterator();
        while (true) {
            if (!it.hasNext()) {
                file = null;
                break;
            }
            a next = it.next();
            if (j11 >= next.f17118a && j11 <= next.f17119b) {
                file = next.f17120c;
                break;
            }
        }
        if (file == null) {
            a aVar = null;
            for (a aVar2 : c(".allData")) {
                if (aVar == null || Math.abs(aVar.f17119b - j11) > Math.abs(aVar2.f17119b - j11)) {
                    aVar = aVar2;
                }
            }
            file = aVar == null ? null : aVar.f17120c;
        }
        if (file == null) {
            return null;
        }
        try {
            strA = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
            try {
                return new JSONArray(strA);
            } catch (Throwable th2) {
                th = th2;
                com.apm.insight.c.a();
                k.a(new IOException("content :".concat(String.valueOf(strA)), th), "NPTH_CATCH");
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            strA = null;
        }
    }

    public final void b(String str) {
        try {
            com.apm.insight.l.f.a(this.f17113d, str, false);
        } catch (Throwable unused) {
        }
    }

    public final String c() {
        try {
            return com.apm.insight.l.f.a(this.f17113d.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return null;
        }
    }
}
