package com.bytedance.sdk.component.qr.pFF;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ol;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.SR;
import com.bytedance.sdk.component.pFF.sc.TRI;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.bytedance.sdk.component.pFF.sc.dE;
import com.bytedance.sdk.component.utils.Tf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    SR f26970sc;

    public We(UFX ufx) {
        super(ufx);
        this.f26970sc = null;
    }

    private byte[] ExN(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes("utf-8"));
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e11) {
                                Tf.sc("PostExecutor", e11.toString());
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e12) {
                            e = e12;
                            gZIPOutputStream = gZIPOutputStream2;
                            Tf.sc("PostExecutor", e.toString());
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e13) {
                                    Tf.sc("PostExecutor", e13.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPOutputStream = gZIPOutputStream2;
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e14) {
                                    Tf.sc("PostExecutor", e14.toString());
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                throw th;
                            }
                            byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException e15) {
                                Tf.sc("PostExecutor", e15.toString());
                                throw th;
                            }
                        }
                    } catch (IOException e16) {
                        e = e16;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e17) {
                Tf.sc("PostExecutor", e17.toString());
            }
        } catch (IOException e18) {
            e = e18;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Ol sc(dE dEVar) {
        try {
            return dEVar.ExN();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset sc(Ol ol2) {
        try {
            return ol2 != null ? ol2.sc(com.bytedance.sdk.component.pFF.sc.pFF.Ol.f26942sc) : com.bytedance.sdk.component.pFF.sc.pFF.Ol.f26942sc;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.pFF.sc.pFF.Ol.f26942sc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(com.bytedance.sdk.component.qr.pFF pff, BT bt2) {
        if (pff == null || bt2 == null) {
            return;
        }
        pff.sc(bt2.Ol());
    }

    public SR We() {
        return this.f26970sc;
    }

    public void We(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f26970sc = SR.sc(Ol.sc("application/json; charset=utf-8"), str);
    }

    public com.bytedance.sdk.component.qr.pFF sc() {
        com.bytedance.sdk.component.qr.pFF pff;
        try {
            Ql.sc scVar = new Ql.sc();
            if (TextUtils.isEmpty(this.Qj)) {
                return new com.bytedance.sdk.component.qr.pFF(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            scVar.pFF(this.Qj);
            if (this.f26970sc == null) {
                return new com.bytedance.sdk.component.qr.pFF(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            sc(scVar);
            scVar.sc((Object) zY());
            BT btPFF = this.zY.sc(scVar.sc(this.f26970sc).pFF()).pFF();
            if (btPFF == null) {
                return null;
            }
            HashMap map = new HashMap();
            TRI triQr = btPFF.qr();
            if (triQr != null) {
                for (int i11 = 0; i11 < triQr.sc(); i11++) {
                    String strSc = triQr.sc(i11);
                    String strPFF = triQr.pFF(i11);
                    map.put(strSc, strPFF);
                    if (strSc != null && strSc.equalsIgnoreCase("content-type")) {
                        map.put("content-type", strPFF == null ? "" : strPFF.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.qr.We.sc.sc(map)) {
                byte[] bArrWe = btPFF.TRI().We();
                pff = new com.bytedance.sdk.component.qr.pFF(btPFF.We(), btPFF.zY(), btPFF.ExN(), map, null, btPFF.pFF(), btPFF.sc());
                pff.sc(bArrWe);
            } else if (this.Ol) {
                byte[] bArrWe2 = btPFF.TRI().We();
                pff = new com.bytedance.sdk.component.qr.pFF(btPFF.We(), btPFF.zY(), btPFF.ExN(), map, new String(bArrWe2, sc(sc(btPFF.TRI()))), btPFF.pFF(), btPFF.sc());
                pff.sc(bArrWe2);
            } else {
                pff = new com.bytedance.sdk.component.qr.pFF(btPFF.We(), btPFF.zY(), btPFF.ExN(), map, btPFF.TRI().pFF(), btPFF.pFF(), btPFF.sc());
            }
            sc(pff, btPFF);
            return pff;
        } catch (Throwable th2) {
            return new com.bytedance.sdk.component.qr.pFF(false, 5001, th2.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    public void sc(final com.bytedance.sdk.component.qr.sc.sc scVar) {
        try {
            Ql.sc scVar2 = new Ql.sc();
            if (TextUtils.isEmpty(this.Qj)) {
                scVar.sc(this, new IOException("Url is Empty"));
                return;
            }
            if (!TextUtils.isEmpty(this.ExN)) {
                scVar2.sc(this.ExN);
            }
            int i11 = this.TRI;
            if (i11 > 0) {
                scVar2.sc(i11);
            }
            scVar2.pFF(this.Qj);
            if (this.f26970sc == null) {
                if (scVar != null) {
                    scVar.sc(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                sc(scVar2);
                scVar2.sc((Object) zY());
                this.zY.sc(scVar2.sc(this.f26970sc).pFF()).sc(new com.bytedance.sdk.component.pFF.sc.zY() { // from class: com.bytedance.sdk.component.qr.pFF.We.1
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
                    @Override // com.bytedance.sdk.component.pFF.sc.zY
                    public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff, BT bt2) throws IOException {
                        com.bytedance.sdk.component.qr.pFF pff2;
                        com.bytedance.sdk.component.qr.sc.sc scVar3 = scVar;
                        if (scVar3 != null) {
                            if (bt2 == null) {
                                scVar3.sc(We.this, new IOException("No response"));
                                return;
                            }
                            com.bytedance.sdk.component.qr.pFF pff3 = null;
                            IOException iOException = null;
                            try {
                                HashMap map = new HashMap();
                                TRI triQr = bt2.qr();
                                if (triQr != null) {
                                    for (int i12 = 0; i12 < triQr.sc(); i12++) {
                                        String strSc = triQr.sc(i12);
                                        String strPFF = triQr.pFF(i12);
                                        map.put(strSc, strPFF);
                                        if (strSc != null && strSc.equalsIgnoreCase("content-type")) {
                                            map.put("content-type", strPFF == null ? "" : strPFF.toLowerCase());
                                        }
                                    }
                                }
                                try {
                                    if (com.bytedance.sdk.component.qr.We.sc.sc(map)) {
                                        byte[] bArrWe = bt2.TRI().We();
                                        pff2 = new com.bytedance.sdk.component.qr.pFF(bt2.We(), bt2.zY(), bt2.ExN(), map, null, bt2.pFF(), bt2.sc());
                                        pff2.sc(bArrWe);
                                    } else if (We.this.Ol) {
                                        byte[] bArrWe2 = bt2.TRI().We();
                                        We we2 = We.this;
                                        pff2 = new com.bytedance.sdk.component.qr.pFF(bt2.We(), bt2.zY(), bt2.ExN(), map, new String(bArrWe2, we2.sc(we2.sc(bt2.TRI()))), bt2.pFF(), bt2.sc());
                                        pff2.sc(bArrWe2);
                                    } else {
                                        pff2 = new com.bytedance.sdk.component.qr.pFF(bt2.We(), bt2.zY(), bt2.ExN(), map, bt2.TRI().pFF(), bt2.pFF(), bt2.sc());
                                    }
                                    We.this.sc(pff2, bt2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    pff3 = pff2;
                                    pff2 = pff3;
                                    iOException = new IOException(th);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            if (pff2 != null) {
                                scVar.sc(We.this, pff2);
                                return;
                            }
                            com.bytedance.sdk.component.qr.sc.sc scVar4 = scVar;
                            if (!(scVar4 instanceof com.bytedance.sdk.component.qr.sc.pFF)) {
                                We we3 = We.this;
                                if (iOException == null) {
                                    iOException = new IOException("Unexpected exception");
                                }
                                scVar4.sc(we3, iOException);
                                return;
                            }
                            com.bytedance.sdk.component.qr.sc.pFF pff4 = (com.bytedance.sdk.component.qr.sc.pFF) scVar4;
                            We we4 = We.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            pff4.sc(we4, iOException, new com.bytedance.sdk.component.qr.pFF(bt2.We(), bt2.zY(), bt2.ExN(), null, null, bt2.pFF(), bt2.sc()));
                        }
                    }

                    @Override // com.bytedance.sdk.component.pFF.sc.zY
                    public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff, IOException iOException) {
                        com.bytedance.sdk.component.qr.sc.sc scVar3 = scVar;
                        if (scVar3 != null) {
                            scVar3.sc(We.this, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            scVar.sc(this, new IOException(th2.getMessage()));
        }
    }

    public void sc(String str, boolean z11) {
        if (!z11) {
            We(str);
        } else {
            sc("application/json; charset=utf-8", ExN(str));
            pFF(HttpHeaders.CONTENT_ENCODING, "gzip");
        }
    }

    public void sc(String str, byte[] bArr) {
        this.f26970sc = SR.sc(Ol.sc(str), bArr);
    }

    public void sc(JSONObject jSONObject) {
        this.f26970sc = SR.sc(Ol.sc("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }
}
