package com.alibaba.fastjson;

import com.transsion.baselib.db.download.DownloadBean;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class JSONValidator implements Cloneable, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15460a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f15462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Type f15463d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f15464f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15461b = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15465g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15466h = false;

    /* JADX INFO: compiled from: source.java */
    public enum Type {
        Object,
        Array,
        Value
    }

    /* JADX INFO: compiled from: source.java */
    public static class a extends JSONValidator {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f15467i;

        public a(String str) {
            this.f15467i = str;
            g();
            h();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public final void b() {
            char cCharAt;
            int i11 = this.f15461b;
            do {
                i11++;
                if (i11 >= this.f15467i.length() || (cCharAt = this.f15467i.charAt(i11)) == '\\') {
                    g();
                    while (true) {
                        char c11 = this.f15462c;
                        if (c11 == '\\') {
                            g();
                            if (this.f15462c == 'u') {
                                g();
                                g();
                                g();
                                g();
                                g();
                            } else {
                                g();
                            }
                        } else if (c11 == '\"') {
                            g();
                            return;
                        } else if (this.f15460a) {
                            return;
                        } else {
                            g();
                        }
                    }
                }
            } while (cCharAt != '\"');
            int i12 = i11 + 1;
            this.f15462c = this.f15467i.charAt(i12);
            this.f15461b = i12;
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void g() {
            int i11 = this.f15461b + 1;
            this.f15461b = i11;
            if (i11 < this.f15467i.length()) {
                this.f15462c = this.f15467i.charAt(this.f15461b);
            } else {
                this.f15462c = (char) 0;
                this.f15460a = true;
            }
        }
    }

    public static JSONValidator c(String str) {
        return new a(str);
    }

    public static final boolean d(char c11) {
        return c11 == ' ' || c11 == '\t' || c11 == '\r' || c11 == '\n' || c11 == '\f' || c11 == '\b';
    }

    /* JADX WARN: Code duplicated, block: B:127:0x017d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:130:0x0183  */
    /* JADX WARN: Code duplicated, block: B:132:0x018a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x019c  */
    /* JADX WARN: Code duplicated, block: B:145:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:146:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:149:0x01b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:153:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:179:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x01bf A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public final boolean a() {
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        char c16;
        char c17;
        char c18;
        char c19;
        char c21 = this.f15462c;
        if (c21 == '\"') {
            g();
            while (!this.f15460a) {
                char c22 = this.f15462c;
                if (c22 == '\\') {
                    g();
                    if (this.f15462c == 'u') {
                        g();
                        g();
                        g();
                        g();
                        g();
                    } else {
                        g();
                    }
                } else {
                    if (c22 == '\"') {
                        g();
                        this.f15463d = Type.Value;
                        return true;
                    }
                    g();
                }
            }
            return false;
        }
        if (c21 != '+' && c21 != '-') {
            if (c21 == '[') {
                g();
                h();
                if (this.f15462c == ']') {
                    g();
                    this.f15463d = Type.Array;
                    return true;
                }
                while (a()) {
                    h();
                    char c23 = this.f15462c;
                    if (c23 != ',') {
                        if (c23 != ']') {
                            return false;
                        }
                        g();
                        this.f15463d = Type.Array;
                        return true;
                    }
                    g();
                    h();
                }
                return false;
            }
            if (c21 == 'f') {
                g();
                if (this.f15462c != 'a') {
                    return false;
                }
                g();
                if (this.f15462c != 'l') {
                    return false;
                }
                g();
                if (this.f15462c != 's') {
                    return false;
                }
                g();
                if (this.f15462c != 'e') {
                    return false;
                }
                g();
                if (!d(this.f15462c) && (c17 = this.f15462c) != ',' && c17 != ']' && c17 != '}' && c17 != 0) {
                    return false;
                }
                this.f15463d = Type.Value;
                return true;
            }
            if (c21 == 'n') {
                g();
                if (this.f15462c != 'u') {
                    return false;
                }
                g();
                if (this.f15462c != 'l') {
                    return false;
                }
                g();
                if (this.f15462c != 'l') {
                    return false;
                }
                g();
                if (!d(this.f15462c) && (c18 = this.f15462c) != ',' && c18 != ']' && c18 != '}' && c18 != 0) {
                    return false;
                }
                this.f15463d = Type.Value;
                return true;
            }
            if (c21 == 't') {
                g();
                if (this.f15462c != 'r') {
                    return false;
                }
                g();
                if (this.f15462c != 'u') {
                    return false;
                }
                g();
                if (this.f15462c != 'e') {
                    return false;
                }
                g();
                if (!d(this.f15462c) && (c19 = this.f15462c) != ',' && c19 != ']' && c19 != '}' && c19 != 0) {
                    return false;
                }
                this.f15463d = Type.Value;
                return true;
            }
            if (c21 == '{') {
                g();
                while (d(this.f15462c)) {
                    g();
                }
                if (this.f15462c == '}') {
                    g();
                    this.f15463d = Type.Object;
                    return true;
                }
                while (this.f15462c == '\"') {
                    b();
                    h();
                    if (this.f15462c != ':') {
                        break;
                    }
                    g();
                    h();
                    if (!a()) {
                        return false;
                    }
                    h();
                    char c24 = this.f15462c;
                    if (c24 != ',') {
                        if (c24 != '}') {
                            break;
                        }
                        g();
                        this.f15463d = Type.Object;
                        return true;
                    }
                    g();
                    h();
                }
                return false;
            }
            switch (c21) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    break;
                default:
                    return false;
            }
        }
        if (c21 == '-' || c21 == '+') {
            g();
            h();
            char c25 = this.f15462c;
            if (c25 >= '0' && c25 <= '9') {
                do {
                    g();
                    c11 = this.f15462c;
                    if (c11 >= '0') {
                    }
                    if (c11 == '.') {
                        g();
                        c16 = this.f15462c;
                        if (c16 >= '0' || c16 > '9') {
                            return false;
                        }
                        while (true) {
                            char c26 = this.f15462c;
                            if (c26 >= '0' && c26 <= '9') {
                                g();
                            }
                        }
                    }
                    c12 = this.f15462c;
                    if (c12 != 'e' || c12 == 'E') {
                        g();
                        c13 = this.f15462c;
                        if (c13 != '-' || c13 == '+') {
                            g();
                        }
                        c14 = this.f15462c;
                        if (c14 >= '0' && c14 <= '9') {
                            g();
                            while (true) {
                                c15 = this.f15462c;
                                if (c15 < '0' && c15 <= '9') {
                                    g();
                                }
                            }
                        }
                    }
                    this.f15463d = Type.Value;
                    return true;
                } while (c11 <= '9');
                if (c11 == '.') {
                    g();
                    c16 = this.f15462c;
                    if (c16 >= '0') {
                    }
                    return false;
                }
                c12 = this.f15462c;
                if (c12 != 'e') {
                }
                g();
                c13 = this.f15462c;
                if (c13 != '-') {
                    g();
                } else {
                    g();
                }
                c14 = this.f15462c;
                if (c14 >= '0') {
                    g();
                    while (true) {
                        c15 = this.f15462c;
                        if (c15 < '0') {
                        }
                        this.f15463d = Type.Value;
                        return true;
                        g();
                    }
                }
            }
        } else {
            do {
                g();
                c11 = this.f15462c;
                if (c11 >= '0') {
                }
                if (c11 == '.') {
                    g();
                    c16 = this.f15462c;
                    if (c16 >= '0') {
                    }
                    return false;
                }
                c12 = this.f15462c;
                if (c12 != 'e') {
                }
                g();
                c13 = this.f15462c;
                if (c13 != '-') {
                    g();
                } else {
                    g();
                }
                c14 = this.f15462c;
                if (c14 >= '0') {
                    g();
                    while (true) {
                        c15 = this.f15462c;
                        if (c15 < '0') {
                        }
                        this.f15463d = Type.Value;
                        return true;
                        g();
                    }
                }
            } while (c11 <= '9');
            if (c11 == '.') {
                g();
                c16 = this.f15462c;
                if (c16 >= '0') {
                }
                return false;
            }
            c12 = this.f15462c;
            if (c12 != 'e') {
            }
            g();
            c13 = this.f15462c;
            if (c13 != '-') {
                g();
            } else {
                g();
            }
            c14 = this.f15462c;
            if (c14 >= '0') {
                g();
                while (true) {
                    c15 = this.f15462c;
                    if (c15 < '0') {
                    }
                    this.f15463d = Type.Value;
                    return true;
                    g();
                }
            }
        }
        return false;
    }

    public abstract void b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract void g();

    public void h() {
        while (d(this.f15462c)) {
            g();
        }
    }

    public boolean j() {
        Boolean bool = this.f15464f;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (a()) {
            h();
            this.f15465g++;
            if (this.f15460a) {
                this.f15464f = Boolean.TRUE;
                return true;
            }
            if (!this.f15466h) {
                this.f15464f = Boolean.FALSE;
                return false;
            }
            h();
            if (this.f15460a) {
                this.f15464f = Boolean.TRUE;
                return true;
            }
        }
        this.f15464f = Boolean.FALSE;
        return false;
    }
}
