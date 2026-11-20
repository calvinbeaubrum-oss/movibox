package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import com.android.volley.Request;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k<T> extends Request<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", "utf-8");

    @Nullable
    private com.android.volley.i.b<T> mListener;
    private final Object mLock;

    @Nullable
    private final String mRequestBody;

    public k(int i11, String str, @Nullable String str2, com.android.volley.i.b<T> bVar, @Nullable com.android.volley.i.a aVar) {
        super(i11, str, aVar);
        this.mLock = new Object();
        this.mListener = bVar;
        this.mRequestBody = str2;
    }

    @Deprecated
    public k(String str, String str2, com.android.volley.i.b<T> bVar, com.android.volley.i.a aVar) {
        this(-1, str, str2, bVar, aVar);
    }

    @Override // com.android.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    @Override // com.android.volley.Request
    public void deliverResponse(T t11) {
        com.android.volley.i.b<T> bVar;
        synchronized (this.mLock) {
            bVar = this.mListener;
        }
        if (bVar != null) {
            bVar.onResponse(t11);
        }
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        try {
            String str = this.mRequestBody;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            com.android.volley.l.f("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, "utf-8");
            return null;
        }
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.android.volley.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.android.volley.Request
    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // com.android.volley.Request
    public abstract com.android.volley.i<T> parseNetworkResponse(com.android.volley.g gVar);
}
