package athena;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.data.AppIdData;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.PushConstants;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c0 extends y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f13613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x0 f13614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final z f13615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ar.a f13616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<AppIdData> f13617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SparseArray<String> f13618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final u0 f13619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f13620l = false;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f13621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Integer> f13623c;

        public a(byte[] bArr, int i11, List<Integer> list, int i12) {
            this.f13621a = bArr;
            this.f13622b = i11;
            this.f13623c = list;
        }

        public static a a(byte[] bArr, int i11, List<Integer> list, int i12) {
            return new a(bArr, i11, list, i12);
        }
    }

    public c0(String str, @NonNull x0 x0Var, @NonNull z zVar, @NonNull List<AppIdData> list, @NonNull ar.a aVar, @NonNull u0 u0Var, boolean z11, @NonNull SparseArray<String> sparseArray) {
        this.f13613e = str;
        this.f13614f = x0Var;
        this.f13615g = zVar;
        this.f13617i = list;
        this.f13616h = aVar;
        this.f13619k = u0Var;
        this.f13612d = z11;
        this.f13618j = sparseArray;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Pair<String, List<AppIdData>> a(long j11, String str) {
        String string;
        LinkedList linkedList = new LinkedList();
        int i11 = 0;
        int i12 = 0;
        loop0: for (AppIdData appIdData : this.f13617i) {
            if (TextUtils.equals(appIdData.f50752f, this.f13613e)) {
                br.b bVarL = this.f13616h.l(appIdData.f50747a);
                List<br.a> listW = bVarL != null ? bVarL.w() : null;
                if (br.d.l(listW)) {
                    int i13 = i12;
                    int i14 = i11;
                    for (br.a aVar : listW) {
                        if (aVar.b(j11)) {
                            if (this.f13612d) {
                                try {
                                    this.f13615g.f(aVar.d(), new z.a() { // from class: athena.e
                                        @Override // athena.z.a
                                        public final void a(y yVar) {
                                            this.f13630a.a(yVar);
                                        }
                                    });
                                } catch (Exception e11) {
                                    a0.d("Upload 1.x events exception : %s", e11.getMessage());
                                    com.transsion.ga.e.a("checkUploadFile", e11);
                                }
                            }
                            cr.d dVarD = this.f13615g.d(aVar.d(), j11, str, 921600 - i13, 2000 - i14);
                            if (dVarD != null && (linkedList.contains(appIdData) || linkedList.add(appIdData))) {
                                appIdData.f50751e.add(dVarD);
                                i14 += dVarD.f62797f;
                                i13 += dVarD.f62798g;
                                if (i14 >= 2000 || i13 >= 921600) {
                                    a0.f("Packet size out of limit, packetSize [%d], eventCount [%d]", Integer.valueOf(i13), Integer.valueOf(i14));
                                    break loop0;
                                }
                            }
                        }
                    }
                    i11 = i14;
                    i12 = i13;
                } else {
                    a0.d("Appid [%d] checkUpload tid config is null.", Integer.valueOf(appIdData.f50747a));
                }
                if (br.d.k(appIdData.f50751e)) {
                    this.f13615g.k(Collections.singletonList(appIdData));
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            String str2 = j0.f13693a;
            Random random = new Random();
            StringBuilder sb2 = new StringBuilder();
            for (int i15 = 0; i15 < 8; i15++) {
                sb2.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36)));
            }
            string = sb2.toString();
            this.f13615g.n(linkedList, string);
        } else {
            string = str;
        }
        return new Pair<>(string, linkedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(SparseArray sparseArray) {
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            cr.e eVar = (cr.e) sparseArray.valueAt(i11);
            Bundle bundle = new Bundle();
            bundle.putInt(SafeStringUtils.SP_APPID, eVar.f62804a);
            bundle.putString("date", eVar.f62805b);
            bundle.putInt("count", eVar.f62806c);
            bundle.putInt("packet", eVar.f62807d);
            new dr.a("day_up_record", 9999).c(bundle, null).b();
            if (cr.b.d() > 0) {
                new dr.a("day_up_record", cr.b.d()).c(bundle, null).b();
            }
        }
    }

    private void a(b bVar, List<AppIdData> list, long j11, int i11) {
        br.a aVarN;
        TimeZone timeZone = TimeZone.getTimeZone(this.f13616h.q());
        String str = j0.f13693a;
        Calendar calendar = Calendar.getInstance(timeZone);
        this.f13615g.m(list, j11, calendar.get(1) + "-" + (calendar.get(2) + 1) + "-" + calendar.get(5), new l0() { // from class: athena.f
            @Override // athena.l0
            public final void a(Object obj) {
                c0.a((SparseArray) obj);
            }
        });
        if (j0.o(ws.a.a())) {
            m0.a(ws.a.a()).g("first_launch", "false");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", i11);
            jSONObject.put(TrackingKey.CODE, bVar.f13599a);
            jSONObject.put("message", bVar.f13600b);
            jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, bVar.f13601c);
            JSONArray jSONArray = new JSONArray();
            Iterator<AppIdData> it = list.iterator();
            while (it.hasNext()) {
                for (cr.d dVar : it.next().f50751e) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tid", dVar.f62792a);
                    jSONObject2.put(NotificationCompat.CATEGORY_EVENT, dVar.f62793b);
                    jSONObject2.put("count", dVar.f62797f);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("events", jSONArray);
            a0.f("<-- upload success:%s", jSONObject.toString().replace("\\", ""));
        } catch (Exception e11) {
            a0.d("exception when print upload events success: ", e11.getMessage());
        }
        if (this.f13620l) {
            Iterator<AppIdData> it2 = list.iterator();
            while (it2.hasNext()) {
                int i12 = it2.next().f50747a;
                if (this.f13618j.indexOfKey(i12) >= 0) {
                    this.f13618j.put(i12, "");
                    m0.a(ws.a.a()).g("first_page_enter_" + i12, "");
                }
            }
        }
        Iterator<AppIdData> it3 = list.iterator();
        while (it3.hasNext()) {
            for (cr.d dVar2 : it3.next().f50751e) {
                if (dVar2.f62799h && (aVarN = this.f13616h.n(dVar2.f62792a)) != null) {
                    aVarN.e().j(j11);
                    aVarN.e().b(0);
                }
            }
        }
        List<b.a> list2 = bVar.f13601c;
        if (list2 != null) {
            for (b.a aVar : list2) {
                br.b bVarL = this.f13616h.l(aVar.f13603a);
                if (bVarL != null && !TextUtils.equals(bVarL.r(), aVar.a())) {
                    int i13 = aVar.f13604b;
                    if (i13 == 1) {
                        String strA = aVar.a();
                        try {
                            if (this.f13615g.p(bVarL.a())) {
                                bVarL.n(strA);
                                bVarL.m(0L);
                                bVarL.j(-1L);
                                this.f13615g.h(bVarL, false);
                            }
                        } catch (Exception e12) {
                            a0.d("Handle cleanup data exception : %s", e12.getMessage());
                            com.transsion.ga.e.a("handleCleanupData", e12);
                        }
                    } else if (i13 == 2) {
                        a(bVarL, aVar.a(), true);
                    } else if (i13 == 3) {
                        a(bVarL, aVar.a(), false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(y yVar) {
        x0 x0Var = this.f13614f;
        if (x0Var != null) {
            x0Var.f(yVar);
        }
    }

    private void a(br.b bVar, String str, boolean z11) {
        int iAbs;
        if (z11) {
            try {
                String strC = j0.c();
                if (TextUtils.isEmpty(strC)) {
                    strC = com.transsion.ga.g.a();
                }
                iAbs = (TextUtils.isEmpty(strC) || strC.hashCode() == 0) ? 1800000 : (Math.abs(strC.hashCode()) % 30) * 60000;
            } catch (Exception e11) {
                a0.d("Handle pull config exception after upload : %s", e11.getMessage());
                com.transsion.ga.e.a("handlePullConfig", e11);
                return;
            }
        } else {
            iAbs = 0;
        }
        bVar.n(str);
        bVar.m(0L);
        bVar.j(System.currentTimeMillis() + ((long) iAbs));
        this.f13615g.h(bVar, false);
    }

    /* JADX WARN: Code duplicated, block: B:307:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:308:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:311:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:322:0x0616 A[Catch: Exception -> 0x0648, TryCatch #17 {Exception -> 0x0648, blocks: (B:319:0x0604, B:320:0x0610, B:322:0x0616, B:323:0x0622, B:325:0x0628, B:327:0x063f, B:331:0x064f, B:333:0x0657, B:335:0x065b, B:337:0x0662, B:340:0x0674), top: B:416:0x0604 }] */
    /* JADX WARN: Code duplicated, block: B:325:0x0628 A[Catch: Exception -> 0x0648, TRY_LEAVE, TryCatch #17 {Exception -> 0x0648, blocks: (B:319:0x0604, B:320:0x0610, B:322:0x0616, B:323:0x0622, B:325:0x0628, B:327:0x063f, B:331:0x064f, B:333:0x0657, B:335:0x065b, B:337:0x0662, B:340:0x0674), top: B:416:0x0604 }] */
    /* JADX WARN: Code duplicated, block: B:335:0x065b A[Catch: Exception -> 0x0648, TRY_LEAVE, TryCatch #17 {Exception -> 0x0648, blocks: (B:319:0x0604, B:320:0x0610, B:322:0x0616, B:323:0x0622, B:325:0x0628, B:327:0x063f, B:331:0x064f, B:333:0x0657, B:335:0x065b, B:337:0x0662, B:340:0x0674), top: B:416:0x0604 }] */
    /* JADX WARN: Code duplicated, block: B:339:0x0671  */
    /* JADX WARN: Code duplicated, block: B:358:0x06e4  */
    /* JADX WARN: Code duplicated, block: B:363:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:364:0x06f4 A[Catch: Exception -> 0x0714, TryCatch #9 {Exception -> 0x0714, blocks: (B:354:0x06ce, B:356:0x06e0, B:359:0x06e5, B:361:0x06ea, B:365:0x06f6, B:367:0x06fb, B:369:0x0703, B:364:0x06f4), top: B:400:0x06ce }] */
    /* JADX WARN: Code duplicated, block: B:380:0x0771  */
    /* JADX WARN: Code duplicated, block: B:400:0x06ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:429:0x06b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:439:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x011b A[Catch: Exception -> 0x0111, TryCatch #10 {Exception -> 0x0111, blocks: (B:32:0x00e4, B:35:0x00e9, B:37:0x00ef, B:40:0x00f4, B:42:0x00fa, B:45:0x00ff, B:48:0x0106, B:54:0x011b, B:56:0x0121, B:58:0x012d, B:57:0x0127), top: B:402:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0121 A[Catch: Exception -> 0x0111, TryCatch #10 {Exception -> 0x0111, blocks: (B:32:0x00e4, B:35:0x00e9, B:37:0x00ef, B:40:0x00f4, B:42:0x00fa, B:45:0x00ff, B:48:0x0106, B:54:0x011b, B:56:0x0121, B:58:0x012d, B:57:0x0127), top: B:402:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0127 A[Catch: Exception -> 0x0111, TryCatch #10 {Exception -> 0x0111, blocks: (B:32:0x00e4, B:35:0x00e9, B:37:0x00ef, B:40:0x00f4, B:42:0x00fa, B:45:0x00ff, B:48:0x0106, B:54:0x011b, B:56:0x0121, B:58:0x012d, B:57:0x0127), top: B:402:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0131  */
    /* JADX WARN: Code duplicated, block: B:65:0x0142  */
    /* JADX WARN: Code duplicated, block: B:67:0x0147  */
    /* JADX WARN: Code duplicated, block: B:69:0x014c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0152 A[Catch: Exception -> 0x015a, TRY_ENTER, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:77:0x015c A[Catch: Exception -> 0x015a, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0162  */
    /* JADX WARN: Code duplicated, block: B:80:0x0164 A[Catch: Exception -> 0x015a, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:82:0x016a  */
    /* JADX WARN: Code duplicated, block: B:83:0x016c A[Catch: Exception -> 0x015a, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0172  */
    /* JADX WARN: Code duplicated, block: B:86:0x0174  */
    /* JADX WARN: Code duplicated, block: B:88:0x0177  */
    /* JADX WARN: Code duplicated, block: B:90:0x017a  */
    /* JADX WARN: Code duplicated, block: B:92:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x017f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0180 A[Catch: Exception -> 0x015a, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0188 A[Catch: Exception -> 0x015a, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0190 A[Catch: Exception -> 0x015a, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0198 A[Catch: Exception -> 0x015a, TryCatch #16 {Exception -> 0x015a, blocks: (B:98:0x019f, B:100:0x01bd, B:72:0x0152, B:94:0x0180, B:95:0x0188, B:96:0x0190, B:97:0x0198, B:77:0x015c, B:80:0x0164, B:83:0x016c), top: B:414:0x019f }] */
    private void a(List<AppIdData> list, String str, long j11, long j12, int i11) throws Throwable {
        long j13;
        long j14;
        String str2;
        String str3;
        CharSequence charSequence;
        String str4;
        CharSequence charSequence2;
        int i12;
        int i13;
        a aVarA;
        String strB;
        c cVarA;
        String str5;
        CharSequence charSequence3;
        CharSequence charSequence4;
        y0<b> y0VarC;
        b bVar;
        int i14;
        CharSequence charSequence5;
        JSONArray jSONArray;
        Iterator<AppIdData> it;
        String str6;
        LinkedList linkedList;
        boolean z11;
        JSONArray jSONArray2;
        boolean z12;
        String str7;
        String str8;
        String str9;
        boolean z13;
        String str10;
        JSONObject jSONObject;
        String str11;
        int iHashCode;
        byte b11;
        String str12 = "requestId";
        String str13 = "opid";
        String str14 = "app_active";
        long jA = j11;
        long jMin = j12;
        int i15 = i11;
        while (true) {
            if (!j0.r(ws.a.a())) {
                a0.b("tryUploadEvents interrupted : %s", "network unavailable");
                break;
            }
            Context contextA = ws.a.a();
            boolean zO = j0.o(contextA);
            LinkedList linkedList2 = new LinkedList();
            JSONArray jSONArray3 = new JSONArray();
            Iterator<AppIdData> it2 = list.iterator();
            int i16 = 0;
            while (true) {
                boolean zHasNext = it2.hasNext();
                String str15 = "events";
                String str16 = "net";
                j13 = jMin;
                String str17 = "\\";
                String str18 = "Assemble events packet exception : %s";
                j14 = jA;
                String str19 = "tid";
                String str20 = NotificationCompat.CATEGORY_EVENT;
                str2 = str12;
                String str21 = "";
                if (!zHasNext) {
                    break;
                }
                int i17 = i15;
                AppIdData next = it2.next();
                String str22 = str13;
                JSONArray jSONArray4 = new JSONArray();
                Context context = contextA;
                HashSet hashSet = new HashSet();
                Iterator<cr.d> it3 = next.f50751e.iterator();
                int i18 = 0;
                while (true) {
                    linkedList = linkedList2;
                    String str23 = "eparam";
                    if (!it3.hasNext()) {
                        break;
                    }
                    JSONArray jSONArray5 = jSONArray3;
                    cr.d next2 = it3.next();
                    for (cr.d.a aVar : next2.f62794c) {
                        str15 = str15;
                        try {
                            str7 = str17;
                            str8 = str18;
                            try {
                                JSONObject jSONObjectPut = new JSONObject().put(str19, next2.f62792a);
                                String str24 = aVar.f62800a;
                                if (str24 == null) {
                                    str24 = str21;
                                }
                                str20 = str20;
                                String str25 = str19;
                                try {
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put(str20, str24).put("ts", aVar.f62801b).put(str16, aVar.f62803d);
                                    String str26 = aVar.f62802c;
                                    if (str26 == null) {
                                        str26 = str21;
                                    }
                                    String str27 = aVar.f62800a;
                                    if (str27 == null) {
                                        str27 = str21;
                                    }
                                    str19 = str25;
                                    str9 = str16;
                                    if (str27.equals(str14)) {
                                        if (TextUtils.isEmpty(str26)) {
                                            jSONObject = new JSONObject();
                                        } else {
                                            jSONObject = new JSONObject(str26);
                                        }
                                        str11 = aVar.f62800a;
                                        if (str11 == null) {
                                            str11 = str21;
                                        }
                                        z13 = zO;
                                        iHashCode = str11.hashCode();
                                        str10 = str23;
                                        str21 = str21;
                                        if (iHashCode != -1801031586) {
                                            if (iHashCode != 753371876) {
                                                if (iHashCode != 1066479505) {
                                                    if (iHashCode != 1616733480) {
                                                        b11 = -1;
                                                    } else {
                                                        b11 = 1;
                                                    }
                                                } else if (str11.equals("app_launch")) {
                                                    b11 = 2;
                                                } else {
                                                    b11 = -1;
                                                }
                                            } else if (str11.equals(str14)) {
                                                b11 = 0;
                                            } else {
                                                b11 = -1;
                                            }
                                        } else if (str11.equals("app_heartbeat")) {
                                            b11 = 3;
                                        } else {
                                            b11 = -1;
                                        }
                                        if (b11 != 0) {
                                            a(jSONObjectPut2, jSONObject, br.g.m());
                                        } else if (b11 != 1) {
                                            a(jSONObjectPut2, jSONObject, br.g.y());
                                        } else if (b11 != 2) {
                                            a(jSONObjectPut2, jSONObject, br.g.s());
                                        } else if (b11 != 3) {
                                            a(jSONObjectPut2, jSONObject, br.g.r());
                                        }
                                    } else {
                                        try {
                                            String str28 = aVar.f62800a;
                                            if (str28 == null) {
                                                str28 = str21;
                                            }
                                            if (str28.equals("page_enter")) {
                                                if (TextUtils.isEmpty(str26)) {
                                                    jSONObject = new JSONObject();
                                                } else {
                                                    jSONObject = new JSONObject(str26);
                                                }
                                                str11 = aVar.f62800a;
                                                if (str11 == null) {
                                                    str11 = str21;
                                                }
                                                z13 = zO;
                                                try {
                                                    iHashCode = str11.hashCode();
                                                    str10 = str23;
                                                    str21 = str21;
                                                    if (iHashCode != -1801031586) {
                                                        if (iHashCode != 753371876) {
                                                            if (iHashCode != 1066479505) {
                                                                if (iHashCode != 1616733480 && str11.equals("page_enter")) {
                                                                    b11 = 1;
                                                                } else {
                                                                    b11 = -1;
                                                                }
                                                            } else if (str11.equals("app_launch")) {
                                                                b11 = 2;
                                                            } else {
                                                                b11 = -1;
                                                            }
                                                        } else if (str11.equals(str14)) {
                                                            b11 = 0;
                                                        } else {
                                                            b11 = -1;
                                                        }
                                                    } else if (str11.equals("app_heartbeat")) {
                                                        b11 = 3;
                                                    } else {
                                                        b11 = -1;
                                                    }
                                                    if (b11 != 0) {
                                                        a(jSONObjectPut2, jSONObject, br.g.m());
                                                    } else if (b11 != 1) {
                                                        a(jSONObjectPut2, jSONObject, br.g.y());
                                                    } else if (b11 != 2) {
                                                        a(jSONObjectPut2, jSONObject, br.g.s());
                                                    } else if (b11 != 3) {
                                                        a(jSONObjectPut2, jSONObject, br.g.r());
                                                    }
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    str21 = str21;
                                                    str10 = str23;
                                                    String str29 = str8;
                                                    a0.d(str29, e.getMessage());
                                                    str18 = str29;
                                                    str17 = str7;
                                                    str20 = str20;
                                                    str19 = str19;
                                                    str16 = str9;
                                                    zO = z13;
                                                    str23 = str10;
                                                    str21 = str21;
                                                }
                                            } else {
                                                String str30 = aVar.f62800a;
                                                if (str30 == null) {
                                                    str30 = str21;
                                                }
                                                if (str30.equals("app_launch")) {
                                                    if (TextUtils.isEmpty(str26)) {
                                                        jSONObject = new JSONObject();
                                                    } else {
                                                        jSONObject = new JSONObject(str26);
                                                    }
                                                    str11 = aVar.f62800a;
                                                    if (str11 == null) {
                                                        str11 = str21;
                                                    }
                                                    z13 = zO;
                                                    iHashCode = str11.hashCode();
                                                    str10 = str23;
                                                    str21 = str21;
                                                    if (iHashCode != -1801031586) {
                                                        if (iHashCode != 753371876) {
                                                            if (iHashCode != 1066479505) {
                                                                if (iHashCode != 1616733480) {
                                                                    b11 = -1;
                                                                } else {
                                                                    b11 = 1;
                                                                }
                                                            } else if (str11.equals("app_launch")) {
                                                                b11 = 2;
                                                            } else {
                                                                b11 = -1;
                                                            }
                                                        } else if (str11.equals(str14)) {
                                                            b11 = 0;
                                                        } else {
                                                            b11 = -1;
                                                        }
                                                    } else if (str11.equals("app_heartbeat")) {
                                                        b11 = 3;
                                                    } else {
                                                        b11 = -1;
                                                    }
                                                    if (b11 != 0) {
                                                        a(jSONObjectPut2, jSONObject, br.g.m());
                                                    } else if (b11 != 1) {
                                                        a(jSONObjectPut2, jSONObject, br.g.y());
                                                    } else if (b11 != 2) {
                                                        a(jSONObjectPut2, jSONObject, br.g.s());
                                                    } else if (b11 != 3) {
                                                        a(jSONObjectPut2, jSONObject, br.g.r());
                                                    }
                                                } else {
                                                    String str31 = aVar.f62800a;
                                                    if (str31 == null) {
                                                        str31 = str21;
                                                    }
                                                    if (str31.equals("app_heartbeat")) {
                                                        if (TextUtils.isEmpty(str26)) {
                                                            jSONObject = new JSONObject();
                                                        } else {
                                                            jSONObject = new JSONObject(str26);
                                                        }
                                                        str11 = aVar.f62800a;
                                                        if (str11 == null) {
                                                            str11 = str21;
                                                        }
                                                        z13 = zO;
                                                        iHashCode = str11.hashCode();
                                                        str10 = str23;
                                                        str21 = str21;
                                                        if (iHashCode != -1801031586) {
                                                            if (iHashCode != 753371876) {
                                                                if (iHashCode != 1066479505) {
                                                                    if (iHashCode != 1616733480) {
                                                                        b11 = -1;
                                                                    } else {
                                                                        b11 = 1;
                                                                    }
                                                                } else if (str11.equals("app_launch")) {
                                                                    b11 = 2;
                                                                } else {
                                                                    b11 = -1;
                                                                }
                                                            } else if (str11.equals(str14)) {
                                                                b11 = 0;
                                                            } else {
                                                                b11 = -1;
                                                            }
                                                        } else if (str11.equals("app_heartbeat")) {
                                                            b11 = 3;
                                                        } else {
                                                            b11 = -1;
                                                        }
                                                        if (b11 != 0) {
                                                            a(jSONObjectPut2, jSONObject, br.g.m());
                                                        } else if (b11 != 1) {
                                                            a(jSONObjectPut2, jSONObject, br.g.y());
                                                        } else if (b11 != 2) {
                                                            a(jSONObjectPut2, jSONObject, br.g.s());
                                                        } else if (b11 != 3) {
                                                            a(jSONObjectPut2, jSONObject, br.g.r());
                                                        }
                                                    } else {
                                                        jSONObjectPut2.put(str23, str26);
                                                        str21 = str21;
                                                        z13 = zO;
                                                        str10 = str23;
                                                    }
                                                }
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            str21 = str21;
                                            z13 = zO;
                                            str10 = str23;
                                            String str210 = str8;
                                            a0.d(str210, e.getMessage());
                                            str18 = str210;
                                            str17 = str7;
                                            str20 = str20;
                                            str19 = str19;
                                            str16 = str9;
                                            zO = z13;
                                            str23 = str10;
                                            str21 = str21;
                                        }
                                    }
                                    try {
                                        String str32 = aVar.f62800a + "-" + aVar.f62801b;
                                        if (!hashSet.contains(str32)) {
                                            hashSet.add(str32);
                                            jSONArray4.put(jSONObjectPut2);
                                        }
                                        str17 = str7;
                                        str18 = str8;
                                    } catch (Exception e13) {
                                        e = e13;
                                        String str211 = str8;
                                        a0.d(str211, e.getMessage());
                                        str18 = str211;
                                        str17 = str7;
                                    }
                                } catch (Exception e14) {
                                    e = e14;
                                    str21 = str21;
                                    str9 = str16;
                                    str19 = str25;
                                }
                            } catch (Exception e15) {
                                e = e15;
                                str9 = str16;
                                z13 = zO;
                                str10 = str23;
                                String str212 = str8;
                                a0.d(str212, e.getMessage());
                                str18 = str212;
                                str17 = str7;
                                str20 = str20;
                                str19 = str19;
                                str16 = str9;
                                zO = z13;
                                str23 = str10;
                                str21 = str21;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            str7 = str17;
                            str8 = str18;
                        }
                        str20 = str20;
                        str19 = str19;
                        str16 = str9;
                        zO = z13;
                        str23 = str10;
                        str21 = str21;
                    }
                    i18 += next2.f62797f;
                    linkedList2 = linkedList;
                    jSONArray3 = jSONArray5;
                    str21 = str21;
                }
                String str33 = str21;
                String str34 = str20;
                String str35 = str19;
                String str36 = str17;
                String str37 = str18;
                String str38 = str15;
                boolean z14 = zO;
                JSONArray jSONArray6 = jSONArray3;
                String str39 = this.f13618j.get(next.f50747a, str33);
                if (!TextUtils.isEmpty(str39)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str39);
                        String string = jSONObject2.has("eparam") ? jSONObject2.getString("eparam") : str33;
                        a(jSONObject2, TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string), br.g.y());
                        if (jSONObject2.getLong(str35) < 9999) {
                            br.a aVarK = ar.b.a().k(next.f50747a, jSONObject2.getString(str34));
                            if (aVarK != null) {
                                jSONObject2.put(str35, aVarK.d());
                                jSONArray4.put(jSONObject2);
                            } else {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(SafeStringUtils.SP_APPID, next.f50747a);
                                jSONObject3.put(str34, jSONObject2.getString(str34));
                                a0.d("invalid or not registered:%s", jSONObject3.toString().replace(str36, str33));
                            }
                            z11 = true;
                            this.f13620l = z11;
                        } else {
                            jSONArray4.put(jSONObject2);
                        }
                        i18++;
                        z11 = true;
                    } catch (Exception e17) {
                        z11 = true;
                        a0.d("Insert FPE event exception : %s", e17.getMessage());
                    }
                    this.f13620l = z11;
                }
                int i19 = i18;
                try {
                    JSONObject jSONObject4 = TextUtils.isEmpty(next.f50748b) ? new JSONObject() : new JSONObject(next.f50748b);
                    JSONObject jSONObjectPut3 = new JSONObject().put(SafeStringUtils.SP_APPID, next.f50747a).put("hostid", cr.b.d());
                    String strOptString = jSONObject4.optString("pkgName");
                    if (strOptString == null) {
                        strOptString = str33;
                    }
                    JSONObject jSONObjectPut4 = jSONObjectPut3.put(PushConstants.PROVIDER_FIELD_PKG, strOptString);
                    String strOptString2 = jSONObject4.optString("versionName");
                    if (strOptString2 == null) {
                        strOptString2 = str33;
                    }
                    JSONObject jSONObjectPut5 = jSONObjectPut4.put("vn", strOptString2);
                    String strOptString3 = jSONObject4.optString("versionCode");
                    if (strOptString3 == null) {
                        strOptString3 = str33;
                    }
                    JSONObject jSONObjectPut6 = jSONObjectPut5.put("vc", strOptString3).put("sdkv", "3.0.0.5");
                    String strOptString4 = jSONObject4.optString("installer");
                    if (strOptString4 == null) {
                        strOptString4 = str33;
                    }
                    JSONObject jSONObjectPut7 = jSONObjectPut6.put("ins", strOptString4);
                    z12 = z14;
                    try {
                        JSONObject jSONObjectPut8 = jSONObjectPut7.put("isfl", z12).put("cnt", i19).put(str38, jSONArray4);
                        jSONArray2 = jSONArray6;
                        try {
                            jSONArray2.put(jSONObjectPut8);
                        } catch (Exception e18) {
                            e = e18;
                            a0.d(str37, e.getMessage());
                        }
                    } catch (Exception e19) {
                        e = e19;
                        jSONArray2 = jSONArray6;
                    }
                } catch (Exception e21) {
                    e = e21;
                    jSONArray2 = jSONArray6;
                    z12 = z14;
                }
                i16 += i19;
                linkedList.add(Integer.valueOf(next.f50747a));
                jSONArray3 = jSONArray2;
                linkedList2 = linkedList;
                zO = z12;
                jA = j14;
                str12 = str2;
                i15 = i17;
                str13 = str22;
                contextA = context;
                jMin = j13;
            }
            String str40 = str13;
            int i21 = i15;
            Context context2 = contextA;
            JSONArray jSONArray7 = jSONArray3;
            LinkedList linkedList3 = linkedList2;
            int i22 = i16;
            CharSequence charSequenceB = com.transsion.ga.g.b(0);
            try {
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    String strT = br.g.t();
                    if (strT == null) {
                        strT = "";
                    }
                    JSONObject jSONObjectPut9 = jSONObject5.put("channel", strT);
                    try {
                        try {
                            try {
                                try {
                                    String strI = j0.i(context2, str40);
                                    if (strI == null) {
                                        strI = "";
                                    }
                                    JSONObject jSONObjectPut10 = jSONObjectPut9.put(str40, strI);
                                    str3 = str14;
                                    try {
                                        String strI2 = j0.i(context2, "oneid");
                                        if (strI2 == null) {
                                            strI2 = "";
                                        }
                                        JSONObject jSONObjectPut11 = jSONObjectPut10.put("tsid", strI2);
                                        String strA = i0.a();
                                        if (strA == null) {
                                            strA = "";
                                        }
                                        JSONObject jSONObjectPut12 = jSONObjectPut11.put(PushConstants.PROVIDER_VAID, strA);
                                        JSONObject jSONObjectU = br.g.u();
                                        str40 = str40;
                                        try {
                                            jSONObjectU.put("ossv", j0.s());
                                            if (jSONObjectU.length() > 0) {
                                                int length = jSONObjectU.toString().getBytes(StandardCharsets.UTF_8).length;
                                                charSequence = "";
                                                if (length > 2000) {
                                                    try {
                                                        str4 = "events";
                                                        charSequence2 = "\\";
                                                        try {
                                                            String str41 = String.format(Locale.getDefault(), "custom param is too long, limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                                                            a0.d("%s", str41);
                                                            JSONObject jSONObject6 = new JSONObject();
                                                            jSONObject6.put("errorMsg", str41);
                                                            jSONObjectPut12.put("cparam", jSONObject6.toString());
                                                        } catch (Exception e22) {
                                                            e = e22;
                                                            i12 = i21;
                                                            i13 = 0;
                                                            a0.d("Assemble events packet exception : %s", e.getMessage());
                                                            aVarA = null;
                                                            String str42 = this.f13613e;
                                                            byte[] bArr = aVarA.f13621a;
                                                            int i23 = aVarA.f13622b;
                                                            List<Integer> list2 = aVarA.f13623c;
                                                            if (TextUtils.isEmpty(com.transsion.ga.g.b(i13))) {
                                                                strB = j0.c();
                                                            } else {
                                                                strB = com.transsion.ga.g.b(i13);
                                                            }
                                                            if (TextUtils.isEmpty(strB)) {
                                                                strB = com.transsion.ga.g.a();
                                                            }
                                                            Locale locale = Locale.getDefault();
                                                            Object[] objArr = new Object[2];
                                                            objArr[i13] = strB;
                                                            objArr[1] = Integer.valueOf(cr.b.d());
                                                            cVarA = c.a(str42, bArr, i23, list2, str, String.format(locale, "%s_%d", objArr));
                                                            JSONObject jSONObject7 = new JSONObject();
                                                            jSONObject7.put("host", this.f13613e);
                                                            str5 = str2;
                                                            jSONObject7.put(str5, cVarA.hashCode());
                                                            jSONObject7.put("packetId", str);
                                                            jSONArray = new JSONArray();
                                                            it = list.iterator();
                                                            while (it.hasNext()) {
                                                                for (cr.d dVar : it.next().f50751e) {
                                                                    JSONObject jSONObject8 = new JSONObject();
                                                                    jSONObject8.put("tid", dVar.f62792a);
                                                                    jSONObject8.put(NotificationCompat.CATEGORY_EVENT, dVar.f62793b);
                                                                    jSONObject8.put("count", dVar.f62797f);
                                                                    jSONArray.put(jSONObject8);
                                                                }
                                                            }
                                                            jSONObject7.put(str4, jSONArray);
                                                            Object[] objArr2 = new Object[2];
                                                            if (i12 > 0) {
                                                                str6 = String.format(Locale.getDefault(), "--> retry [%d] times upload", Integer.valueOf(i12));
                                                            } else {
                                                                str6 = "--> upload";
                                                            }
                                                            objArr2[0] = str6;
                                                            charSequence3 = charSequence2;
                                                            charSequence4 = charSequence;
                                                            objArr2[1] = jSONObject7.toString().replace(charSequence3, charSequence4);
                                                            a0.f("%s:%s", objArr2);
                                                            y0VarC = v.c(cVarA.f13606a, cVarA.f13607b, cVarA.f13608c, cVarA.f13609d, cVarA.f13610e, cVarA.f13611f);
                                                            if (y0VarC.f13772a == 0) {
                                                                a(y0VarC.f13773b, list, j14, cVarA.hashCode());
                                                                break;
                                                            }
                                                            try {
                                                                bVar = y0VarC.f13773b;
                                                                JSONObject jSONObject9 = new JSONObject();
                                                                jSONObject9.put(str5, cVarA.hashCode());
                                                                i14 = bVar.f13599a;
                                                                if (i14 == 0) {
                                                                    i14 = -1;
                                                                }
                                                                jSONObject9.put(TrackingKey.CODE, i14);
                                                                if (TextUtils.isEmpty(bVar.f13600b)) {
                                                                    charSequence5 = charSequence4;
                                                                } else {
                                                                    charSequence5 = bVar.f13600b;
                                                                }
                                                                jSONObject9.put("message", charSequence5);
                                                                jSONObject9.put("ex", bVar.f13602d);
                                                                a0.f("<-- upload failed:%s", jSONObject9.toString().replace(charSequence3, charSequence4));
                                                            } catch (Exception e23) {
                                                                a0.d("exception when print upload events success: ", e23.getMessage());
                                                            }
                                                            jMin = Math.min((j13 * 2) + 1000, 1800000L);
                                                            i15 = i12 + 1;
                                                            this.f13615g.l(list, i15);
                                                            try {
                                                                Thread.sleep(jMin);
                                                                str12 = str5;
                                                                jA = this.f13619k.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                                                                str14 = str3;
                                                                str13 = str40;
                                                            } catch (InterruptedException e24) {
                                                                a0.b("Retry upload interrupted!! : %s", e24.getMessage());
                                                            }
                                                            if (this.f13770b.hasMessages(298)) {
                                                            }
                                                            this.f13770b.sendEmptyMessageDelayed(298, 0L);
                                                        }
                                                    } catch (Exception e25) {
                                                        e = e25;
                                                        str4 = "events";
                                                        charSequence2 = "\\";
                                                        i12 = i21;
                                                        i13 = 0;
                                                        a0.d("Assemble events packet exception : %s", e.getMessage());
                                                        aVarA = null;
                                                        String str43 = this.f13613e;
                                                        byte[] bArr2 = aVarA.f13621a;
                                                        int i24 = aVarA.f13622b;
                                                        List<Integer> list3 = aVarA.f13623c;
                                                        if (TextUtils.isEmpty(com.transsion.ga.g.b(i13))) {
                                                            strB = j0.c();
                                                        } else {
                                                            strB = com.transsion.ga.g.b(i13);
                                                        }
                                                        if (TextUtils.isEmpty(strB)) {
                                                            strB = com.transsion.ga.g.a();
                                                        }
                                                        Locale locale2 = Locale.getDefault();
                                                        Object[] objArr3 = new Object[2];
                                                        objArr3[i13] = strB;
                                                        objArr3[1] = Integer.valueOf(cr.b.d());
                                                        cVarA = c.a(str43, bArr2, i24, list3, str, String.format(locale2, "%s_%d", objArr3));
                                                        JSONObject jSONObject10 = new JSONObject();
                                                        jSONObject10.put("host", this.f13613e);
                                                        str5 = str2;
                                                        jSONObject10.put(str5, cVarA.hashCode());
                                                        jSONObject10.put("packetId", str);
                                                        jSONArray = new JSONArray();
                                                        it = list.iterator();
                                                        while (it.hasNext()) {
                                                            while (r9.hasNext()) {
                                                                JSONObject jSONObject11 = new JSONObject();
                                                                jSONObject11.put("tid", dVar.f62792a);
                                                                jSONObject11.put(NotificationCompat.CATEGORY_EVENT, dVar.f62793b);
                                                                jSONObject11.put("count", dVar.f62797f);
                                                                jSONArray.put(jSONObject11);
                                                            }
                                                        }
                                                        jSONObject10.put(str4, jSONArray);
                                                        Object[] objArr4 = new Object[2];
                                                        if (i12 > 0) {
                                                            str6 = String.format(Locale.getDefault(), "--> retry [%d] times upload", Integer.valueOf(i12));
                                                        } else {
                                                            str6 = "--> upload";
                                                        }
                                                        objArr4[0] = str6;
                                                        charSequence3 = charSequence2;
                                                        charSequence4 = charSequence;
                                                        objArr4[1] = jSONObject10.toString().replace(charSequence3, charSequence4);
                                                        a0.f("%s:%s", objArr4);
                                                        y0VarC = v.c(cVarA.f13606a, cVarA.f13607b, cVarA.f13608c, cVarA.f13609d, cVarA.f13610e, cVarA.f13611f);
                                                        if (y0VarC.f13772a == 0) {
                                                            a(y0VarC.f13773b, list, j14, cVarA.hashCode());
                                                            break;
                                                        }
                                                        bVar = y0VarC.f13773b;
                                                        JSONObject jSONObject12 = new JSONObject();
                                                        jSONObject12.put(str5, cVarA.hashCode());
                                                        i14 = bVar.f13599a;
                                                        if (i14 == 0) {
                                                            i14 = -1;
                                                        }
                                                        jSONObject12.put(TrackingKey.CODE, i14);
                                                        if (TextUtils.isEmpty(bVar.f13600b)) {
                                                            charSequence5 = charSequence4;
                                                        } else {
                                                            charSequence5 = bVar.f13600b;
                                                        }
                                                        jSONObject12.put("message", charSequence5);
                                                        jSONObject12.put("ex", bVar.f13602d);
                                                        a0.f("<-- upload failed:%s", jSONObject12.toString().replace(charSequence3, charSequence4));
                                                        jMin = Math.min((j13 * 2) + 1000, 1800000L);
                                                        i15 = i12 + 1;
                                                        this.f13615g.l(list, i15);
                                                        Thread.sleep(jMin);
                                                        str12 = str5;
                                                        jA = this.f13619k.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                                                        str14 = str3;
                                                        str13 = str40;
                                                        if (this.f13770b.hasMessages(298)) {
                                                            this.f13770b.sendEmptyMessageDelayed(298, 0L);
                                                        }
                                                    }
                                                } else {
                                                    str4 = "events";
                                                    charSequence2 = "\\";
                                                    jSONObjectPut12.put("cparam", jSONObjectU.toString());
                                                }
                                            } else {
                                                charSequence = "";
                                                str4 = "events";
                                                charSequence2 = "\\";
                                            }
                                            JSONObject jSONObjectPut13 = new JSONObject().put("actype", (int) br.g.j());
                                            CharSequence charSequence6 = Build.VERSION.RELEASE;
                                            if (charSequence6 == null) {
                                                charSequence6 = charSequence;
                                            }
                                            JSONObject jSONObjectPut14 = jSONObjectPut13.put("aver", charSequence6).put("appids", jSONArray7);
                                            CharSequence charSequence7 = Build.BRAND;
                                            if (charSequence7 == null) {
                                                charSequence7 = charSequence;
                                            }
                                            JSONObject jSONObjectPut15 = jSONObjectPut14.put("brand", charSequence7);
                                            CharSequence charSequence8 = Build.DISPLAY;
                                            if (charSequence8 == null) {
                                                charSequence8 = charSequence;
                                            }
                                            JSONObject jSONObjectPut16 = jSONObjectPut15.put("build", charSequence8).put("ekey", jSONObjectPut12.toString());
                                            CharSequence charSequenceH = j0.h();
                                            if (charSequenceH == null) {
                                                charSequenceH = charSequence;
                                            }
                                            JSONObject jSONObjectPut17 = jSONObjectPut16.put("gaid", charSequenceH);
                                            CharSequence language = Locale.getDefault().getLanguage();
                                            if (language == null) {
                                                language = charSequence;
                                            }
                                            JSONObject jSONObjectPut18 = jSONObjectPut17.put("lang", language);
                                            CharSequence charSequenceG = com.transsion.ga.g.g();
                                            if (charSequenceG == null) {
                                                charSequenceG = charSequence;
                                            }
                                            JSONObject jSONObjectPut19 = jSONObjectPut18.put("mcc", charSequenceG);
                                            CharSequence charSequenceH2 = com.transsion.ga.g.h();
                                            if (charSequenceH2 == null) {
                                                charSequenceH2 = charSequence;
                                            }
                                            JSONObject jSONObjectPut20 = jSONObjectPut19.put("mnc", charSequenceH2);
                                            CharSequence charSequence9 = Build.MODEL;
                                            if (charSequence9 == null) {
                                                charSequence9 = charSequence;
                                            }
                                            JSONObject jSONObjectPut21 = jSONObjectPut20.put("model", charSequence9).put("net", j0.b(context2).ordinal());
                                            CharSequence charSequenceI = com.transsion.ga.g.i();
                                            if (charSequenceI == null) {
                                                charSequenceI = charSequence;
                                            }
                                            JSONObject jSONObjectPut22 = jSONObjectPut21.put("osver", charSequenceI);
                                            CharSequence charSequenceH3 = br.g.h();
                                            if (charSequenceH3 == null) {
                                                charSequenceH3 = charSequence;
                                            }
                                            JSONObject jSONObjectPut23 = jSONObjectPut22.put("tuid", charSequenceH3);
                                            i12 = i21;
                                            try {
                                                JSONObject jSONObjectPut24 = jSONObjectPut23.put("try", i12);
                                                CharSequence charSequenceM = j0.m();
                                                if (charSequenceM == null) {
                                                    charSequenceM = charSequence;
                                                }
                                                JSONObject jSONObjectPut25 = jSONObjectPut24.put("tz", charSequenceM).put("uts", System.currentTimeMillis());
                                                if (AthenaAnalytics.I()) {
                                                    if (charSequenceB == null) {
                                                        charSequenceB = charSequence;
                                                    }
                                                    jSONObjectPut25.put("iid", charSequenceB);
                                                }
                                                aVarA = a.a(jSONObjectPut25.toString().getBytes(StandardCharsets.UTF_8), i22, linkedList3, i12);
                                                i13 = 0;
                                            } catch (Exception e26) {
                                                e = e26;
                                                i13 = 0;
                                                a0.d("Assemble events packet exception : %s", e.getMessage());
                                                aVarA = null;
                                            }
                                        } catch (Exception e27) {
                                            e = e27;
                                            charSequence = "";
                                            str4 = "events";
                                            charSequence2 = "\\";
                                            i12 = i21;
                                            i13 = 0;
                                            a0.d("Assemble events packet exception : %s", e.getMessage());
                                            aVarA = null;
                                            String str44 = this.f13613e;
                                            byte[] bArr3 = aVarA.f13621a;
                                            int i25 = aVarA.f13622b;
                                            List<Integer> list4 = aVarA.f13623c;
                                            if (TextUtils.isEmpty(com.transsion.ga.g.b(i13))) {
                                                strB = j0.c();
                                            } else {
                                                strB = com.transsion.ga.g.b(i13);
                                            }
                                            if (TextUtils.isEmpty(strB)) {
                                                strB = com.transsion.ga.g.a();
                                            }
                                            Locale locale3 = Locale.getDefault();
                                            Object[] objArr5 = new Object[2];
                                            objArr5[i13] = strB;
                                            objArr5[1] = Integer.valueOf(cr.b.d());
                                            cVarA = c.a(str44, bArr3, i25, list4, str, String.format(locale3, "%s_%d", objArr5));
                                            JSONObject jSONObject13 = new JSONObject();
                                            jSONObject13.put("host", this.f13613e);
                                            str5 = str2;
                                            jSONObject13.put(str5, cVarA.hashCode());
                                            jSONObject13.put("packetId", str);
                                            jSONArray = new JSONArray();
                                            it = list.iterator();
                                            while (it.hasNext()) {
                                                while (r9.hasNext()) {
                                                    JSONObject jSONObject14 = new JSONObject();
                                                    jSONObject14.put("tid", dVar.f62792a);
                                                    jSONObject14.put(NotificationCompat.CATEGORY_EVENT, dVar.f62793b);
                                                    jSONObject14.put("count", dVar.f62797f);
                                                    jSONArray.put(jSONObject14);
                                                }
                                            }
                                            jSONObject13.put(str4, jSONArray);
                                            Object[] objArr6 = new Object[2];
                                            if (i12 > 0) {
                                                str6 = String.format(Locale.getDefault(), "--> retry [%d] times upload", Integer.valueOf(i12));
                                            } else {
                                                str6 = "--> upload";
                                            }
                                            objArr6[0] = str6;
                                            charSequence3 = charSequence2;
                                            charSequence4 = charSequence;
                                            objArr6[1] = jSONObject13.toString().replace(charSequence3, charSequence4);
                                            a0.f("%s:%s", objArr6);
                                            y0VarC = v.c(cVarA.f13606a, cVarA.f13607b, cVarA.f13608c, cVarA.f13609d, cVarA.f13610e, cVarA.f13611f);
                                            if (y0VarC.f13772a == 0) {
                                                a(y0VarC.f13773b, list, j14, cVarA.hashCode());
                                                break;
                                            }
                                            bVar = y0VarC.f13773b;
                                            JSONObject jSONObject15 = new JSONObject();
                                            jSONObject15.put(str5, cVarA.hashCode());
                                            i14 = bVar.f13599a;
                                            if (i14 == 0) {
                                                i14 = -1;
                                            }
                                            jSONObject15.put(TrackingKey.CODE, i14);
                                            if (TextUtils.isEmpty(bVar.f13600b)) {
                                                charSequence5 = charSequence4;
                                            } else {
                                                charSequence5 = bVar.f13600b;
                                            }
                                            jSONObject15.put("message", charSequence5);
                                            jSONObject15.put("ex", bVar.f13602d);
                                            a0.f("<-- upload failed:%s", jSONObject15.toString().replace(charSequence3, charSequence4));
                                            jMin = Math.min((j13 * 2) + 1000, 1800000L);
                                            i15 = i12 + 1;
                                            this.f13615g.l(list, i15);
                                            Thread.sleep(jMin);
                                            str12 = str5;
                                            jA = this.f13619k.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                                            str14 = str3;
                                            str13 = str40;
                                            if (this.f13770b.hasMessages(298)) {
                                                this.f13770b.sendEmptyMessageDelayed(298, 0L);
                                            }
                                        }
                                    } catch (Exception e28) {
                                        e = e28;
                                        charSequence = "";
                                        str40 = str40;
                                        str4 = "events";
                                        charSequence2 = "\\";
                                        i12 = i21;
                                        i13 = 0;
                                        a0.d("Assemble events packet exception : %s", e.getMessage());
                                        aVarA = null;
                                        String str45 = this.f13613e;
                                        byte[] bArr4 = aVarA.f13621a;
                                        int i26 = aVarA.f13622b;
                                        List<Integer> list5 = aVarA.f13623c;
                                        if (TextUtils.isEmpty(com.transsion.ga.g.b(i13))) {
                                            strB = j0.c();
                                        } else {
                                            strB = com.transsion.ga.g.b(i13);
                                        }
                                        if (TextUtils.isEmpty(strB)) {
                                            strB = com.transsion.ga.g.a();
                                        }
                                        Locale locale4 = Locale.getDefault();
                                        Object[] objArr7 = new Object[2];
                                        objArr7[i13] = strB;
                                        objArr7[1] = Integer.valueOf(cr.b.d());
                                        cVarA = c.a(str45, bArr4, i26, list5, str, String.format(locale4, "%s_%d", objArr7));
                                        JSONObject jSONObject16 = new JSONObject();
                                        jSONObject16.put("host", this.f13613e);
                                        str5 = str2;
                                        jSONObject16.put(str5, cVarA.hashCode());
                                        jSONObject16.put("packetId", str);
                                        jSONArray = new JSONArray();
                                        it = list.iterator();
                                        while (it.hasNext()) {
                                            while (r9.hasNext()) {
                                                JSONObject jSONObject17 = new JSONObject();
                                                jSONObject17.put("tid", dVar.f62792a);
                                                jSONObject17.put(NotificationCompat.CATEGORY_EVENT, dVar.f62793b);
                                                jSONObject17.put("count", dVar.f62797f);
                                                jSONArray.put(jSONObject17);
                                            }
                                        }
                                        jSONObject16.put(str4, jSONArray);
                                        Object[] objArr8 = new Object[2];
                                        if (i12 > 0) {
                                            str6 = String.format(Locale.getDefault(), "--> retry [%d] times upload", Integer.valueOf(i12));
                                        } else {
                                            str6 = "--> upload";
                                        }
                                        objArr8[0] = str6;
                                        charSequence3 = charSequence2;
                                        charSequence4 = charSequence;
                                        objArr8[1] = jSONObject16.toString().replace(charSequence3, charSequence4);
                                        a0.f("%s:%s", objArr8);
                                        y0VarC = v.c(cVarA.f13606a, cVarA.f13607b, cVarA.f13608c, cVarA.f13609d, cVarA.f13610e, cVarA.f13611f);
                                        if (y0VarC.f13772a == 0) {
                                            a(y0VarC.f13773b, list, j14, cVarA.hashCode());
                                            break;
                                        }
                                        bVar = y0VarC.f13773b;
                                        JSONObject jSONObject18 = new JSONObject();
                                        jSONObject18.put(str5, cVarA.hashCode());
                                        i14 = bVar.f13599a;
                                        if (i14 == 0) {
                                            i14 = -1;
                                        }
                                        jSONObject18.put(TrackingKey.CODE, i14);
                                        if (TextUtils.isEmpty(bVar.f13600b)) {
                                            charSequence5 = charSequence4;
                                        } else {
                                            charSequence5 = bVar.f13600b;
                                        }
                                        jSONObject18.put("message", charSequence5);
                                        jSONObject18.put("ex", bVar.f13602d);
                                        a0.f("<-- upload failed:%s", jSONObject18.toString().replace(charSequence3, charSequence4));
                                        jMin = Math.min((j13 * 2) + 1000, 1800000L);
                                        i15 = i12 + 1;
                                        this.f13615g.l(list, i15);
                                        Thread.sleep(jMin);
                                        str12 = str5;
                                        jA = this.f13619k.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                                        str14 = str3;
                                        str13 = str40;
                                        if (this.f13770b.hasMessages(298)) {
                                            this.f13770b.sendEmptyMessageDelayed(298, 0L);
                                        }
                                    }
                                } catch (Exception e29) {
                                    e = e29;
                                    str3 = str14;
                                }
                                objArr8[1] = jSONObject16.toString().replace(charSequence3, charSequence4);
                                a0.f("%s:%s", objArr8);
                            } catch (Exception e31) {
                                e = e31;
                                a0.d("exception when print upload events : ", e.getMessage());
                            }
                            jSONObject16.put("packetId", str);
                            jSONArray = new JSONArray();
                            it = list.iterator();
                            while (it.hasNext()) {
                                while (r9.hasNext()) {
                                    JSONObject jSONObject19 = new JSONObject();
                                    jSONObject19.put("tid", dVar.f62792a);
                                    jSONObject19.put(NotificationCompat.CATEGORY_EVENT, dVar.f62793b);
                                    jSONObject19.put("count", dVar.f62797f);
                                    jSONArray.put(jSONObject19);
                                }
                            }
                            jSONObject16.put(str4, jSONArray);
                            Object[] objArr9 = new Object[2];
                            if (i12 > 0) {
                                str6 = String.format(Locale.getDefault(), "--> retry [%d] times upload", Integer.valueOf(i12));
                            } else {
                                str6 = "--> upload";
                            }
                            objArr9[0] = str6;
                            charSequence3 = charSequence2;
                            charSequence4 = charSequence;
                        } catch (Exception e32) {
                            e = e32;
                            charSequence3 = charSequence2;
                            charSequence4 = charSequence;
                            a0.d("exception when print upload events : ", e.getMessage());
                            y0VarC = v.c(cVarA.f13606a, cVarA.f13607b, cVarA.f13608c, cVarA.f13609d, cVarA.f13610e, cVarA.f13611f);
                            if (y0VarC.f13772a == 0) {
                                a(y0VarC.f13773b, list, j14, cVarA.hashCode());
                                break;
                            }
                            bVar = y0VarC.f13773b;
                            JSONObject jSONObject110 = new JSONObject();
                            jSONObject110.put(str5, cVarA.hashCode());
                            i14 = bVar.f13599a;
                            if (i14 == 0) {
                                i14 = -1;
                            }
                            jSONObject110.put(TrackingKey.CODE, i14);
                            if (TextUtils.isEmpty(bVar.f13600b)) {
                                charSequence5 = charSequence4;
                            } else {
                                charSequence5 = bVar.f13600b;
                            }
                            jSONObject110.put("message", charSequence5);
                            jSONObject110.put("ex", bVar.f13602d);
                            a0.f("<-- upload failed:%s", jSONObject110.toString().replace(charSequence3, charSequence4));
                            jMin = Math.min((j13 * 2) + 1000, 1800000L);
                            i15 = i12 + 1;
                            this.f13615g.l(list, i15);
                            Thread.sleep(jMin);
                            str12 = str5;
                            jA = this.f13619k.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                            str14 = str3;
                            str13 = str40;
                            if (this.f13770b.hasMessages(298)) {
                                this.f13770b.sendEmptyMessageDelayed(298, 0L);
                            }
                        }
                        jSONObject16.put(str5, cVarA.hashCode());
                    } catch (Exception e33) {
                        e = e33;
                    }
                } catch (Exception e34) {
                    e = e34;
                    str3 = str14;
                }
                JSONObject jSONObject111 = new JSONObject();
                jSONObject111.put("host", this.f13613e);
                str5 = str2;
            } catch (Exception e35) {
                e = e35;
                str5 = str2;
            }
            String str46 = this.f13613e;
            byte[] bArr5 = aVarA.f13621a;
            int i27 = aVarA.f13622b;
            List<Integer> list6 = aVarA.f13623c;
            if (TextUtils.isEmpty(com.transsion.ga.g.b(i13))) {
                strB = j0.c();
            } else {
                strB = com.transsion.ga.g.b(i13);
            }
            if (TextUtils.isEmpty(strB)) {
                strB = com.transsion.ga.g.a();
            }
            Locale locale5 = Locale.getDefault();
            Object[] objArr10 = new Object[2];
            objArr10[i13] = strB;
            objArr10[1] = Integer.valueOf(cr.b.d());
            cVarA = c.a(str46, bArr5, i27, list6, str, String.format(locale5, "%s_%d", objArr10));
            y0VarC = v.c(cVarA.f13606a, cVarA.f13607b, cVarA.f13608c, cVarA.f13609d, cVarA.f13610e, cVarA.f13611f);
            if (y0VarC.f13772a == 0) {
                a(y0VarC.f13773b, list, j14, cVarA.hashCode());
                break;
            }
            bVar = y0VarC.f13773b;
            JSONObject jSONObject112 = new JSONObject();
            jSONObject112.put(str5, cVarA.hashCode());
            i14 = bVar.f13599a;
            if (i14 == 0) {
                i14 = -1;
            }
            jSONObject112.put(TrackingKey.CODE, i14);
            if (TextUtils.isEmpty(bVar.f13600b)) {
                charSequence5 = charSequence4;
            } else {
                charSequence5 = bVar.f13600b;
            }
            jSONObject112.put("message", charSequence5);
            jSONObject112.put("ex", bVar.f13602d);
            a0.f("<-- upload failed:%s", jSONObject112.toString().replace(charSequence3, charSequence4));
            jMin = Math.min((j13 * 2) + 1000, 1800000L);
            i15 = i12 + 1;
            this.f13615g.l(list, i15);
            Thread.sleep(jMin);
            str12 = str5;
            jA = this.f13619k.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
            str14 = str3;
            str13 = str40;
        }
        if (this.f13770b.hasMessages(298)) {
            this.f13770b.sendEmptyMessageDelayed(298, 0L);
        }
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject3 != null) {
                try {
                    if (jSONObject3.length() > 0) {
                        JSONObject jSONObject4 = new JSONObject();
                        if (jSONObject2.has("_ext")) {
                            jSONObject4 = jSONObject2.getJSONObject("_ext");
                        }
                        Iterator<String> itKeys = jSONObject3.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            String str = "_" + next;
                            Object obj = jSONObject3.get(next);
                            if (!jSONObject4.has(str)) {
                                jSONObject4.putOpt(str, obj);
                            }
                        }
                        int length = jSONObject4.toString().getBytes(StandardCharsets.UTF_8).length;
                        if (length > 2000) {
                            String str2 = String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                            a0.c(str2);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("errorMsg", str2);
                            jSONObject2.put("_ext", jSONObject5);
                        } else {
                            jSONObject2.put("_ext", jSONObject4);
                        }
                    }
                } catch (Exception e11) {
                    a0.d("Insert common params exception : %s", e11.getMessage());
                    return;
                }
            }
            jSONObject.put("eparam", jSONObject2.toString());
        }
    }

    @Override // athena.y
    public void a() throws Throwable {
        long jA = this.f13619k.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        int i11 = 0;
        AppIdData appIdData = null;
        for (AppIdData appIdData2 : this.f13617i) {
            if (!TextUtils.isEmpty(appIdData2.f50749c) && TextUtils.equals(appIdData2.f50752f, this.f13613e)) {
                if (appIdData != null) {
                    if (!TextUtils.equals(appIdData.f50749c, appIdData2.f50749c)) {
                        i11++;
                        break;
                    }
                } else {
                    i11++;
                    appIdData = appIdData2;
                }
            }
        }
        if (i11 != 1) {
            if (i11 > 1) {
                ArrayList arrayList = new ArrayList();
                for (AppIdData appIdData3 : this.f13617i) {
                    if (!TextUtils.isEmpty(appIdData3.f50749c) && TextUtils.equals(appIdData3.f50752f, this.f13613e)) {
                        arrayList.add(appIdData3);
                    }
                }
                this.f13615g.k(arrayList);
            }
            appIdData = null;
        }
        long jP = ((long) this.f13616h.p()) * 1000;
        if (appIdData != null) {
            Pair<String, List<AppIdData>> pairA = a(0L, appIdData.f50749c);
            List<AppIdData> list = (List) pairA.second;
            if (br.d.l(list)) {
                a(list, (String) pairA.first, jA, jP, appIdData.f50750d);
                return;
            }
            return;
        }
        Pair<String, List<AppIdData>> pairA2 = a(jA, null);
        String str = (String) pairA2.first;
        List<AppIdData> list2 = (List) pairA2.second;
        if (br.d.l(list2)) {
            a(list2, str, jA, jP, 0);
        }
    }

    @Override // athena.y
    public void c() {
        Thread thread = this.f13771c;
        if (thread == null || thread.isInterrupted()) {
            return;
        }
        this.f13771c.interrupt();
    }

    @Override // athena.y
    public String d() {
        if (TextUtils.isEmpty(this.f13613e)) {
            return "Default";
        }
        try {
            String[] strArrSplit = this.f13613e.split("//");
            if (strArrSplit.length > 0) {
                return strArrSplit[1].split("\\.")[0];
            }
        } catch (Exception e11) {
            a0.d("get domain exception : %s", e11.getMessage());
        }
        return "Default";
    }
}
