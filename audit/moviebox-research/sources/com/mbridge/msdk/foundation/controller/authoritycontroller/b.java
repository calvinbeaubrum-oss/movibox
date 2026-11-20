package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.e;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.OnCompletionListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f44062c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f44063d = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected AuthorityInfoBean f44065b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f44068g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f44064a = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44066e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f44067f = "";

    public b() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        try {
            if (this.f44068g == null) {
                e eVar = new e(context);
                this.f44068g = eVar;
                eVar.a(new e.a() { // from class: com.mbridge.msdk.foundation.controller.authoritycontroller.b.2
                    @Override // com.mbridge.msdk.foundation.controller.e.a
                    public final void a() {
                        b.this.j();
                    }
                });
            }
            j();
        } catch (Throwable th2) {
            ad.b("SDKAuthorityController", th2.getMessage());
        }
    }

    public static void a(boolean z11) {
        f44062c = z11;
    }

    public static boolean a() {
        return f44062c;
    }

    public static void b(boolean z11) {
        f44063d = z11;
    }

    public static boolean b() {
        return f44063d;
    }

    private void c(int i11) {
        this.f44066e = i11 != 1 ? 2 : 1;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f44067f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public void j() {
        boolean zB = this.f44068g.b();
        c(this.f44068g.a());
        c(zB ? 1 : 2);
        this.f44065b.authDeviceIdStatus(zB ? 1 : 0);
    }

    public final int a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
                if (TextUtils.isEmpty(strA)) {
                    return 0;
                }
                return Integer.parseInt(strA);
            }
        } catch (Exception e11) {
            ad.b("SDKAuthorityController", e11.getMessage());
        }
        return 0;
    }

    public final void a(int i11) {
        if (this.f44065b != null) {
            c(i11);
        }
    }

    public final void a(final Context context, final OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.authoritycontroller.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(context);
                    onCompletionListener.onCompletion();
                }
            });
        } else {
            a(context);
        }
    }

    public final void a(String str, int i11) {
        if (this.f44065b != null) {
            if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                this.f44065b.authGenDataStatus(i11);
                return;
            }
            if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                this.f44065b.authDeviceIdStatus(i11);
                return;
            }
            if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
                this.f44065b.a(i11);
            } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
                this.f44065b.authSerialIdStatus(i11);
            } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
                this.f44065b.authOther(i11);
            }
        }
    }

    public abstract int b(String str);

    public final void b(int i11) {
        com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DNT, i11);
    }

    public final void c() {
        this.f44065b = new AuthorityInfoBean();
        try {
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.f44065b.authGenDataStatus(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.f44065b.authDeviceIdStatus(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.f44065b.authSerialIdStatus(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.f44065b.authOther(1);
            }
            this.f44064a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.f44064a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.f44064a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.f44064a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final AuthorityInfoBean d() {
        AuthorityInfoBean authorityInfoBean = this.f44065b;
        if (authorityInfoBean != null) {
            return authorityInfoBean;
        }
        AuthorityInfoBean authorityInfoBean2 = new AuthorityInfoBean();
        authorityInfoBean2.a(1);
        return authorityInfoBean2;
    }

    public final boolean e() {
        int i11 = this.f44066e;
        return i11 == 1 || i11 == 3;
    }

    public final int f() {
        return com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_COPPA, 0);
    }

    public final int g() {
        return this.f44066e;
    }

    public final String h() {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < this.f44064a.size(); i11++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.f44064a.get(i11)));
                jSONObject.put("client_status", a(this.f44064a.get(i11)));
                jSONObject.put("server_status", b(this.f44064a.get(i11)));
                jSONArray.put(jSONObject);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final String i() {
        return this.f44067f;
    }
}
