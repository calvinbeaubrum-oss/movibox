package com.mbridge.msdk.foundation.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43985a = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f43986d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    FastKV f43987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SharedPreferences f43988c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f43989e;

    private a() {
        d.a();
        this.f43989e = true;
    }

    public static synchronized a a() {
        try {
            if (f43986d == null) {
                f43986d = new a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f43986d;
    }

    public final int a(String str, int i11) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                return i11;
            }
            if (this.f43989e && this.f43987b == null) {
                try {
                    this.f43987b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f43987b = null;
                }
            }
            FastKV fastKV = this.f43987b;
            if (fastKV != null) {
                try {
                    return fastKV.getInt(str, i11);
                } catch (Exception unused2) {
                    return i11;
                }
            }
            if (this.f43988c == null) {
                this.f43988c = contextC.getSharedPreferences("mbridge", 0);
            }
            return this.f43988c.getInt(str, i11);
        } catch (Exception e11) {
            e11.printStackTrace();
            return i11;
        }
    }

    public final String a(String str) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                return null;
            }
            if (this.f43989e && this.f43987b == null) {
                try {
                    this.f43987b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f43987b = null;
                }
            }
            FastKV fastKV = this.f43987b;
            if (fastKV != null) {
                try {
                    return fastKV.getString(str, "");
                } catch (Exception unused2) {
                    return "";
                }
            }
            if (this.f43988c == null) {
                this.f43988c = contextC.getSharedPreferences("mbridge", 0);
            }
            return this.f43988c.getString(str, "");
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final void a(String str, long j11) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                ad.b(f43985a, "context is null in put");
                return;
            }
            if (this.f43989e && this.f43987b == null) {
                try {
                    this.f43987b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f43987b = null;
                }
            }
            FastKV fastKV = this.f43987b;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j11);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f43988c == null) {
                this.f43988c = contextC.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor editorEdit = this.f43988c.edit();
            editorEdit.putLong(str, j11);
            editorEdit.apply();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(String str, String str2) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                return;
            }
            if (this.f43989e && this.f43987b == null) {
                try {
                    this.f43987b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f43987b = null;
                }
            }
            FastKV fastKV = this.f43987b;
            if (fastKV != null) {
                try {
                    fastKV.putString(str, str2);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f43988c == null) {
                this.f43988c = contextC.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor editorEdit = this.f43988c.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final Long b(String str) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                ad.b(f43985a, "context is null in get");
                return 0L;
            }
            if (this.f43989e && this.f43987b == null) {
                try {
                    this.f43987b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f43987b = null;
                }
            }
            FastKV fastKV = this.f43987b;
            if (fastKV != null) {
                try {
                    return Long.valueOf(fastKV.getLong(str, 0L));
                } catch (Exception unused2) {
                    return 0L;
                }
            }
            if (this.f43988c == null) {
                this.f43988c = contextC.getSharedPreferences("mbridge", 0);
            }
            return Long.valueOf(this.f43988c.getLong(str, 0L));
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0L;
        }
    }

    public final void b(String str, int i11) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                return;
            }
            if (this.f43989e && this.f43987b == null) {
                try {
                    this.f43987b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f43987b = null;
                }
            }
            FastKV fastKV = this.f43987b;
            if (fastKV != null) {
                try {
                    fastKV.putInt(str, i11);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f43988c == null) {
                this.f43988c = contextC.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor editorEdit = this.f43988c.edit();
            editorEdit.putInt(str, i11);
            editorEdit.apply();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void c(String str) {
        Context contextC = c.m().c();
        if (contextC == null) {
            return;
        }
        if (this.f43989e && this.f43987b == null) {
            try {
                this.f43987b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f43987b = null;
            }
        }
        FastKV fastKV = this.f43987b;
        if (fastKV != null) {
            try {
                fastKV.remove(str);
            } catch (Exception unused2) {
            }
        } else {
            if (this.f43988c == null) {
                this.f43988c = contextC.getSharedPreferences("mbridge", 0);
            }
            this.f43988c.edit().remove(str).apply();
        }
    }
}
