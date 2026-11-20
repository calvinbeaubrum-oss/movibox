package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$string;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.contrarywind.view.WheelView;
import com.facebook.ads.AdError;
import com.google.logging.type.LogSeverity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static DateFormat f25186y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f25187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WheelView f25188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WheelView f25189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f25190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WheelView f25191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WheelView f25192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WheelView f25193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f25195i;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f25202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f25203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f25204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f25205s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f25206t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f25207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WheelView.DividerType f25208v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g8.a f25210x;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25196j = 1900;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25197k = AdError.BROKEN_MEDIA_ERROR_CODE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25198l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25199m = 12;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f25200n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f25201o = 31;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f25209w = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements we.b {
        public a() {
        }

        @Override // we.b
        public void a(int i11) {
            int iH;
            int i12 = i11 + b.this.f25196j;
            b.this.f25189c.setAdapter(new d8.a(h8.a.d(i12)));
            if (h8.a.g(i12) == 0 || b.this.f25189c.getCurrentItem() <= h8.a.g(i12) - 1) {
                b.this.f25189c.setCurrentItem(b.this.f25189c.getCurrentItem());
            } else {
                b.this.f25189c.setCurrentItem(b.this.f25189c.getCurrentItem() + 1);
            }
            if (h8.a.g(i12) == 0 || b.this.f25189c.getCurrentItem() <= h8.a.g(i12) - 1) {
                b.this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.h(i12, b.this.f25189c.getCurrentItem() + 1))));
                iH = h8.a.h(i12, b.this.f25189c.getCurrentItem() + 1);
            } else if (b.this.f25189c.getCurrentItem() == h8.a.g(i12) + 1) {
                b.this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.f(i12))));
                iH = h8.a.f(i12);
            } else {
                b.this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.h(i12, b.this.f25189c.getCurrentItem()))));
                iH = h8.a.h(i12, b.this.f25189c.getCurrentItem());
            }
            int i13 = iH - 1;
            if (b.this.f25190d.getCurrentItem() > i13) {
                b.this.f25190d.setCurrentItem(i13);
            }
            if (b.this.f25210x != null) {
                b.this.f25210x.a();
            }
        }
    }

    /* JADX INFO: renamed from: com.bigkoo.pickerview.view.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0210b implements we.b {
        public C0210b() {
        }

        @Override // we.b
        public void a(int i11) {
            int iH;
            int currentItem = b.this.f25188b.getCurrentItem() + b.this.f25196j;
            if (h8.a.g(currentItem) == 0 || i11 <= h8.a.g(currentItem) - 1) {
                int i12 = i11 + 1;
                b.this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.h(currentItem, i12))));
                iH = h8.a.h(currentItem, i12);
            } else if (b.this.f25189c.getCurrentItem() == h8.a.g(currentItem) + 1) {
                b.this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.f(currentItem))));
                iH = h8.a.f(currentItem);
            } else {
                b.this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.h(currentItem, i11))));
                iH = h8.a.h(currentItem, i11);
            }
            int i13 = iH - 1;
            if (b.this.f25190d.getCurrentItem() > i13) {
                b.this.f25190d.setCurrentItem(i13);
            }
            if (b.this.f25210x != null) {
                b.this.f25210x.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements we.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f25213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f25214b;

        public c(List list, List list2) {
            this.f25213a = list;
            this.f25214b = list2;
        }

        @Override // we.b
        public void a(int i11) {
            int i12 = i11 + b.this.f25196j;
            b.this.f25202p = i12;
            int currentItem = b.this.f25189c.getCurrentItem();
            if (b.this.f25196j == b.this.f25197k) {
                b.this.f25189c.setAdapter(new d8.b(b.this.f25198l, b.this.f25199m));
                if (currentItem > b.this.f25189c.getAdapter().a() - 1) {
                    currentItem = b.this.f25189c.getAdapter().a() - 1;
                    b.this.f25189c.setCurrentItem(currentItem);
                }
                int i13 = currentItem + b.this.f25198l;
                if (b.this.f25198l == b.this.f25199m) {
                    b bVar = b.this;
                    bVar.F(i12, i13, bVar.f25200n, b.this.f25201o, this.f25213a, this.f25214b);
                } else if (i13 == b.this.f25198l) {
                    b bVar2 = b.this;
                    bVar2.F(i12, i13, bVar2.f25200n, 31, this.f25213a, this.f25214b);
                } else if (i13 == b.this.f25199m) {
                    b bVar3 = b.this;
                    bVar3.F(i12, i13, 1, bVar3.f25201o, this.f25213a, this.f25214b);
                } else {
                    b.this.F(i12, i13, 1, 31, this.f25213a, this.f25214b);
                }
            } else if (i12 == b.this.f25196j) {
                b.this.f25189c.setAdapter(new d8.b(b.this.f25198l, 12));
                if (currentItem > b.this.f25189c.getAdapter().a() - 1) {
                    currentItem = b.this.f25189c.getAdapter().a() - 1;
                    b.this.f25189c.setCurrentItem(currentItem);
                }
                int i14 = currentItem + b.this.f25198l;
                if (i14 == b.this.f25198l) {
                    b bVar4 = b.this;
                    bVar4.F(i12, i14, bVar4.f25200n, 31, this.f25213a, this.f25214b);
                } else {
                    b.this.F(i12, i14, 1, 31, this.f25213a, this.f25214b);
                }
            } else if (i12 == b.this.f25197k) {
                b.this.f25189c.setAdapter(new d8.b(1, b.this.f25199m));
                if (currentItem > b.this.f25189c.getAdapter().a() - 1) {
                    currentItem = b.this.f25189c.getAdapter().a() - 1;
                    b.this.f25189c.setCurrentItem(currentItem);
                }
                int i15 = 1 + currentItem;
                if (i15 == b.this.f25199m) {
                    b bVar5 = b.this;
                    bVar5.F(i12, i15, 1, bVar5.f25201o, this.f25213a, this.f25214b);
                } else {
                    b.this.F(i12, i15, 1, 31, this.f25213a, this.f25214b);
                }
            } else {
                b.this.f25189c.setAdapter(new d8.b(1, 12));
                b bVar6 = b.this;
                bVar6.F(i12, 1 + bVar6.f25189c.getCurrentItem(), 1, 31, this.f25213a, this.f25214b);
            }
            if (b.this.f25210x != null) {
                b.this.f25210x.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements we.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f25216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f25217b;

        public d(List list, List list2) {
            this.f25216a = list;
            this.f25217b = list2;
        }

        @Override // we.b
        public void a(int i11) {
            int i12 = i11 + 1;
            if (b.this.f25196j == b.this.f25197k) {
                int i13 = (i12 + b.this.f25198l) - 1;
                if (b.this.f25198l == b.this.f25199m) {
                    b bVar = b.this;
                    bVar.F(bVar.f25202p, i13, b.this.f25200n, b.this.f25201o, this.f25216a, this.f25217b);
                } else if (b.this.f25198l == i13) {
                    b bVar2 = b.this;
                    bVar2.F(bVar2.f25202p, i13, b.this.f25200n, 31, this.f25216a, this.f25217b);
                } else if (b.this.f25199m == i13) {
                    b bVar3 = b.this;
                    bVar3.F(bVar3.f25202p, i13, 1, b.this.f25201o, this.f25216a, this.f25217b);
                } else {
                    b bVar4 = b.this;
                    bVar4.F(bVar4.f25202p, i13, 1, 31, this.f25216a, this.f25217b);
                }
            } else if (b.this.f25202p == b.this.f25196j) {
                int i14 = (i12 + b.this.f25198l) - 1;
                if (i14 == b.this.f25198l) {
                    b bVar5 = b.this;
                    bVar5.F(bVar5.f25202p, i14, b.this.f25200n, 31, this.f25216a, this.f25217b);
                } else {
                    b bVar6 = b.this;
                    bVar6.F(bVar6.f25202p, i14, 1, 31, this.f25216a, this.f25217b);
                }
            } else if (b.this.f25202p != b.this.f25197k) {
                b bVar7 = b.this;
                bVar7.F(bVar7.f25202p, i12, 1, 31, this.f25216a, this.f25217b);
            } else if (i12 == b.this.f25199m) {
                b bVar8 = b.this;
                bVar8.F(bVar8.f25202p, b.this.f25189c.getCurrentItem() + 1, 1, b.this.f25201o, this.f25216a, this.f25217b);
            } else {
                b bVar9 = b.this;
                bVar9.F(bVar9.f25202p, b.this.f25189c.getCurrentItem() + 1, 1, 31, this.f25216a, this.f25217b);
            }
            if (b.this.f25210x != null) {
                b.this.f25210x.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements we.b {
        public e() {
        }

        @Override // we.b
        public void a(int i11) {
            b.this.f25210x.a();
        }
    }

    public b(View view, boolean[] zArr, int i11, int i12) {
        this.f25187a = view;
        this.f25195i = zArr;
        this.f25194h = i11;
        this.f25203q = i12;
        N(view);
    }

    public void A(float f11) {
        this.f25207u = f11;
        z();
    }

    public final void B(int i11, int i12, int i13, boolean z11, int i14, int i15, int i16) {
        WheelView wheelView = (WheelView) this.f25187a.findViewById(R$id.year);
        this.f25188b = wheelView;
        wheelView.setAdapter(new d8.a(h8.a.e(this.f25196j, this.f25197k)));
        this.f25188b.setLabel("");
        this.f25188b.setCurrentItem(i11 - this.f25196j);
        this.f25188b.setGravity(this.f25194h);
        WheelView wheelView2 = (WheelView) this.f25187a.findViewById(R$id.month);
        this.f25189c = wheelView2;
        wheelView2.setAdapter(new d8.a(h8.a.d(i11)));
        this.f25189c.setLabel("");
        this.f25189c.setConvertMonth(true);
        int iG = h8.a.g(i11);
        if (iG == 0 || (i12 <= iG - 1 && !z11)) {
            this.f25189c.setCurrentItem(i12);
        } else {
            this.f25189c.setCurrentItem(i12 + 1);
        }
        this.f25189c.setGravity(this.f25194h);
        this.f25190d = (WheelView) this.f25187a.findViewById(R$id.day);
        if (h8.a.g(i11) == 0) {
            this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.h(i11, i12))));
        } else {
            this.f25190d.setAdapter(new d8.a(h8.a.b(h8.a.f(i11))));
        }
        this.f25190d.setLabel("");
        this.f25190d.setCurrentItem(i13 - 1);
        this.f25190d.setGravity(this.f25194h);
        WheelView wheelView3 = (WheelView) this.f25187a.findViewById(R$id.hour);
        this.f25191e = wheelView3;
        wheelView3.setAdapter(new d8.b(0, 23));
        this.f25191e.setCurrentItem(i14);
        this.f25191e.setGravity(this.f25194h);
        WheelView wheelView4 = (WheelView) this.f25187a.findViewById(R$id.min);
        this.f25192f = wheelView4;
        wheelView4.setAdapter(new d8.b(0, 59));
        this.f25192f.setCurrentItem(i15);
        this.f25192f.setGravity(this.f25194h);
        WheelView wheelView5 = (WheelView) this.f25187a.findViewById(R$id.second);
        this.f25193g = wheelView5;
        wheelView5.setAdapter(new d8.b(0, 59));
        this.f25193g.setCurrentItem(i15);
        this.f25193g.setGravity(this.f25194h);
        this.f25188b.setOnItemSelectedListener(new a());
        this.f25189c.setOnItemSelectedListener(new C0210b());
        q(this.f25190d);
        q(this.f25191e);
        q(this.f25192f);
        q(this.f25193g);
        boolean[] zArr = this.f25195i;
        if (zArr.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.f25188b.setVisibility(zArr[0] ? 0 : 8);
        this.f25189c.setVisibility(this.f25195i[1] ? 0 : 8);
        this.f25190d.setVisibility(this.f25195i[2] ? 0 : 8);
        this.f25191e.setVisibility(this.f25195i[3] ? 0 : 8);
        this.f25192f.setVisibility(this.f25195i[4] ? 0 : 8);
        this.f25193g.setVisibility(this.f25195i[5] ? 0 : 8);
        r();
    }

    public void C(boolean z11) {
        this.f25209w = z11;
    }

    public void D(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!this.f25209w) {
            G(i11, i12, i13, i14, i15, i16);
        } else {
            int[] iArrD = h8.b.d(i11, i12 + 1, i13);
            B(iArrD[0], iArrD[1] - 1, iArrD[2], iArrD[3] == 1, i14, i15, i16);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i11 = calendar2.get(1);
            int i12 = calendar2.get(2) + 1;
            int i13 = calendar2.get(5);
            int i14 = this.f25196j;
            if (i11 > i14) {
                this.f25197k = i11;
                this.f25199m = i12;
                this.f25201o = i13;
                return;
            } else {
                if (i11 == i14) {
                    int i15 = this.f25198l;
                    if (i12 > i15) {
                        this.f25197k = i11;
                        this.f25199m = i12;
                        this.f25201o = i13;
                        return;
                    } else {
                        if (i12 != i15 || i13 <= this.f25200n) {
                            return;
                        }
                        this.f25197k = i11;
                        this.f25199m = i12;
                        this.f25201o = i13;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.f25196j = calendar.get(1);
            this.f25197k = calendar2.get(1);
            this.f25198l = calendar.get(2) + 1;
            this.f25199m = calendar2.get(2) + 1;
            this.f25200n = calendar.get(5);
            this.f25201o = calendar2.get(5);
            return;
        }
        int i16 = calendar.get(1);
        int i17 = calendar.get(2) + 1;
        int i18 = calendar.get(5);
        int i19 = this.f25197k;
        if (i16 < i19) {
            this.f25198l = i17;
            this.f25200n = i18;
            this.f25196j = i16;
        } else if (i16 == i19) {
            int i21 = this.f25199m;
            if (i17 < i21) {
                this.f25198l = i17;
                this.f25200n = i18;
                this.f25196j = i16;
            } else {
                if (i17 != i21 || i18 >= this.f25201o) {
                    return;
                }
                this.f25198l = i17;
                this.f25200n = i18;
                this.f25196j = i16;
            }
        }
    }

    public final void F(int i11, int i12, int i13, int i14, List<String> list, List<String> list2) {
        int currentItem = this.f25190d.getCurrentItem();
        if (list.contains(String.valueOf(i12))) {
            if (i14 > 31) {
                i14 = 31;
            }
            this.f25190d.setAdapter(new d8.b(i13, i14));
        } else if (list2.contains(String.valueOf(i12))) {
            if (i14 > 30) {
                i14 = 30;
            }
            this.f25190d.setAdapter(new d8.b(i13, i14));
        } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % LogSeverity.WARNING_VALUE != 0) {
            if (i14 > 28) {
                i14 = 28;
            }
            this.f25190d.setAdapter(new d8.b(i13, i14));
        } else {
            if (i14 > 29) {
                i14 = 29;
            }
            this.f25190d.setAdapter(new d8.b(i13, i14));
        }
        if (currentItem > this.f25190d.getAdapter().a() - 1) {
            this.f25190d.setCurrentItem(this.f25190d.getAdapter().a() - 1);
        }
    }

    public final void G(int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17;
        int i18;
        String[] strArr = {"1", "3", "5", "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APPID, PrepareException.ERROR_LOCAL_DATA_FILE_SCAN};
        String[] strArr2 = {"4", PrepareException.ERROR_NO_URL, PrepareException.ERROR_MINI_APP_CLOSE, PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY};
        List listAsList = Arrays.asList(strArr);
        List listAsList2 = Arrays.asList(strArr2);
        this.f25202p = i11;
        WheelView wheelView = (WheelView) this.f25187a.findViewById(R$id.year);
        this.f25188b = wheelView;
        wheelView.setAdapter(new d8.b(this.f25196j, this.f25197k));
        this.f25188b.setCurrentItem(i11 - this.f25196j);
        this.f25188b.setGravity(this.f25194h);
        WheelView wheelView2 = (WheelView) this.f25187a.findViewById(R$id.month);
        this.f25189c = wheelView2;
        wheelView2.setConvertMonth(true);
        int i19 = this.f25196j;
        int i21 = this.f25197k;
        if (i19 == i21) {
            this.f25189c.setAdapter(new d8.b(this.f25198l, this.f25199m));
            this.f25189c.setCurrentItem((i12 + 1) - this.f25198l);
        } else if (i11 == i19) {
            this.f25189c.setAdapter(new d8.b(this.f25198l, 12));
            this.f25189c.setCurrentItem((i12 + 1) - this.f25198l);
        } else if (i11 == i21) {
            this.f25189c.setAdapter(new d8.b(1, this.f25199m));
            this.f25189c.setCurrentItem(i12);
        } else {
            this.f25189c.setAdapter(new d8.b(1, 12));
            this.f25189c.setCurrentItem(i12);
        }
        this.f25189c.setGravity(this.f25194h);
        this.f25190d = (WheelView) this.f25187a.findViewById(R$id.day);
        int i22 = this.f25196j;
        int i23 = this.f25197k;
        if (i22 == i23 && this.f25198l == this.f25199m) {
            int i24 = i12 + 1;
            if (listAsList.contains(String.valueOf(i24))) {
                if (this.f25201o > 31) {
                    this.f25201o = 31;
                }
                this.f25190d.setAdapter(new d8.b(this.f25200n, this.f25201o));
            } else if (listAsList2.contains(String.valueOf(i24))) {
                if (this.f25201o > 30) {
                    this.f25201o = 30;
                }
                this.f25190d.setAdapter(new d8.b(this.f25200n, this.f25201o));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % LogSeverity.WARNING_VALUE != 0) {
                if (this.f25201o > 28) {
                    this.f25201o = 28;
                }
                this.f25190d.setAdapter(new d8.b(this.f25200n, this.f25201o));
            } else {
                if (this.f25201o > 29) {
                    this.f25201o = 29;
                }
                this.f25190d.setAdapter(new d8.b(this.f25200n, this.f25201o));
            }
            this.f25190d.setCurrentItem(i13 - this.f25200n);
        } else if (i11 == i22 && (i18 = i12 + 1) == this.f25198l) {
            if (listAsList.contains(String.valueOf(i18))) {
                this.f25190d.setAdapter(new d8.b(this.f25200n, 31));
            } else if (listAsList2.contains(String.valueOf(i18))) {
                this.f25190d.setAdapter(new d8.b(this.f25200n, 30));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % LogSeverity.WARNING_VALUE != 0) {
                this.f25190d.setAdapter(new d8.b(this.f25200n, 28));
            } else {
                this.f25190d.setAdapter(new d8.b(this.f25200n, 29));
            }
            this.f25190d.setCurrentItem(i13 - this.f25200n);
        } else if (i11 == i23 && (i17 = i12 + 1) == this.f25199m) {
            if (listAsList.contains(String.valueOf(i17))) {
                if (this.f25201o > 31) {
                    this.f25201o = 31;
                }
                this.f25190d.setAdapter(new d8.b(1, this.f25201o));
            } else if (listAsList2.contains(String.valueOf(i17))) {
                if (this.f25201o > 30) {
                    this.f25201o = 30;
                }
                this.f25190d.setAdapter(new d8.b(1, this.f25201o));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % LogSeverity.WARNING_VALUE != 0) {
                if (this.f25201o > 28) {
                    this.f25201o = 28;
                }
                this.f25190d.setAdapter(new d8.b(1, this.f25201o));
            } else {
                if (this.f25201o > 29) {
                    this.f25201o = 29;
                }
                this.f25190d.setAdapter(new d8.b(1, this.f25201o));
            }
            this.f25190d.setCurrentItem(i13 - 1);
        } else {
            int i25 = i12 + 1;
            if (listAsList.contains(String.valueOf(i25))) {
                this.f25190d.setAdapter(new d8.b(1, 31));
            } else if (listAsList2.contains(String.valueOf(i25))) {
                this.f25190d.setAdapter(new d8.b(1, 30));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % LogSeverity.WARNING_VALUE != 0) {
                this.f25190d.setAdapter(new d8.b(1, 28));
            } else {
                this.f25190d.setAdapter(new d8.b(1, 29));
            }
            this.f25190d.setCurrentItem(i13 - 1);
        }
        this.f25190d.setGravity(this.f25194h);
        WheelView wheelView3 = (WheelView) this.f25187a.findViewById(R$id.hour);
        this.f25191e = wheelView3;
        wheelView3.setAdapter(new d8.b(0, 23));
        this.f25191e.setCurrentItem(i14);
        this.f25191e.setGravity(this.f25194h);
        WheelView wheelView4 = (WheelView) this.f25187a.findViewById(R$id.min);
        this.f25192f = wheelView4;
        wheelView4.setAdapter(new d8.b(0, 59));
        this.f25192f.setCurrentItem(i15);
        this.f25192f.setGravity(this.f25194h);
        WheelView wheelView5 = (WheelView) this.f25187a.findViewById(R$id.second);
        this.f25193g = wheelView5;
        wheelView5.setAdapter(new d8.b(0, 59));
        this.f25193g.setCurrentItem(i16);
        this.f25193g.setGravity(this.f25194h);
        this.f25188b.setOnItemSelectedListener(new c(listAsList, listAsList2));
        this.f25189c.setOnItemSelectedListener(new d(listAsList, listAsList2));
        q(this.f25190d);
        q(this.f25191e);
        q(this.f25192f);
        q(this.f25193g);
        boolean[] zArr = this.f25195i;
        if (zArr.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.f25188b.setVisibility(zArr[0] ? 0 : 8);
        this.f25189c.setVisibility(this.f25195i[1] ? 0 : 8);
        this.f25190d.setVisibility(this.f25195i[2] ? 0 : 8);
        this.f25191e.setVisibility(this.f25195i[3] ? 0 : 8);
        this.f25192f.setVisibility(this.f25195i[4] ? 0 : 8);
        this.f25193g.setVisibility(this.f25195i[5] ? 0 : 8);
        r();
    }

    public void H(int i11) {
        this.f25196j = i11;
    }

    public final void I() {
        this.f25190d.setTextColorCenter(this.f25205s);
        this.f25189c.setTextColorCenter(this.f25205s);
        this.f25188b.setTextColorCenter(this.f25205s);
        this.f25191e.setTextColorCenter(this.f25205s);
        this.f25192f.setTextColorCenter(this.f25205s);
        this.f25193g.setTextColorCenter(this.f25205s);
    }

    public void J(int i11) {
        this.f25205s = i11;
        I();
    }

    public final void K() {
        this.f25190d.setTextColorOut(this.f25204r);
        this.f25189c.setTextColorOut(this.f25204r);
        this.f25188b.setTextColorOut(this.f25204r);
        this.f25191e.setTextColorOut(this.f25204r);
        this.f25192f.setTextColorOut(this.f25204r);
        this.f25193g.setTextColorOut(this.f25204r);
    }

    public void L(int i11) {
        this.f25204r = i11;
        K();
    }

    public void M(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f25190d.setTextXOffset(i11);
        this.f25189c.setTextXOffset(i12);
        this.f25188b.setTextXOffset(i13);
        this.f25191e.setTextXOffset(i14);
        this.f25192f.setTextXOffset(i15);
        this.f25193g.setTextXOffset(i16);
    }

    public void N(View view) {
        this.f25187a = view;
    }

    public final String n() {
        int currentItem;
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        int currentItem2 = this.f25188b.getCurrentItem() + this.f25196j;
        if (h8.a.g(currentItem2) == 0 || (this.f25189c.getCurrentItem() + 1) - h8.a.g(currentItem2) <= 0) {
            int currentItem3 = this.f25189c.getCurrentItem();
            currentItem = currentItem3 + 1;
            z11 = false;
        } else if ((this.f25189c.getCurrentItem() + 1) - h8.a.g(currentItem2) == 1) {
            currentItem = this.f25189c.getCurrentItem();
            z11 = true;
        } else {
            currentItem = this.f25189c.getCurrentItem();
            z11 = false;
        }
        int[] iArrB = h8.b.b(currentItem2, currentItem, this.f25190d.getCurrentItem() + 1, z11);
        sb2.append(iArrB[0]);
        sb2.append("-");
        sb2.append(iArrB[1]);
        sb2.append("-");
        sb2.append(iArrB[2]);
        sb2.append(" ");
        sb2.append(this.f25191e.getCurrentItem());
        sb2.append(":");
        sb2.append(this.f25192f.getCurrentItem());
        sb2.append(":");
        sb2.append(this.f25193g.getCurrentItem());
        return sb2.toString();
    }

    public String o() {
        if (this.f25209w) {
            return n();
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f25202p == this.f25196j) {
            int currentItem = this.f25189c.getCurrentItem();
            int i11 = this.f25198l;
            if (currentItem + i11 == i11) {
                sb2.append(this.f25188b.getCurrentItem() + this.f25196j);
                sb2.append("-");
                sb2.append(this.f25189c.getCurrentItem() + this.f25198l);
                sb2.append("-");
                sb2.append(this.f25190d.getCurrentItem() + this.f25200n);
                sb2.append(" ");
                sb2.append(this.f25191e.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f25192f.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f25193g.getCurrentItem());
            } else {
                sb2.append(this.f25188b.getCurrentItem() + this.f25196j);
                sb2.append("-");
                sb2.append(this.f25189c.getCurrentItem() + this.f25198l);
                sb2.append("-");
                sb2.append(this.f25190d.getCurrentItem() + 1);
                sb2.append(" ");
                sb2.append(this.f25191e.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f25192f.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f25193g.getCurrentItem());
            }
        } else {
            sb2.append(this.f25188b.getCurrentItem() + this.f25196j);
            sb2.append("-");
            sb2.append(this.f25189c.getCurrentItem() + 1);
            sb2.append("-");
            sb2.append(this.f25190d.getCurrentItem() + 1);
            sb2.append(" ");
            sb2.append(this.f25191e.getCurrentItem());
            sb2.append(":");
            sb2.append(this.f25192f.getCurrentItem());
            sb2.append(":");
            sb2.append(this.f25193g.getCurrentItem());
        }
        return sb2.toString();
    }

    public void p(boolean z11) {
        this.f25190d.isCenterLabel(z11);
        this.f25189c.isCenterLabel(z11);
        this.f25188b.isCenterLabel(z11);
        this.f25191e.isCenterLabel(z11);
        this.f25192f.isCenterLabel(z11);
        this.f25193g.isCenterLabel(z11);
    }

    public final void q(WheelView wheelView) {
        if (this.f25210x != null) {
            wheelView.setOnItemSelectedListener(new e());
        }
    }

    public final void r() {
        this.f25190d.setTextSize(this.f25203q);
        this.f25189c.setTextSize(this.f25203q);
        this.f25188b.setTextSize(this.f25203q);
        this.f25191e.setTextSize(this.f25203q);
        this.f25192f.setTextSize(this.f25203q);
        this.f25193g.setTextSize(this.f25203q);
    }

    public void s(boolean z11) {
        this.f25188b.setCyclic(z11);
        this.f25189c.setCyclic(z11);
        this.f25190d.setCyclic(z11);
        this.f25191e.setCyclic(z11);
        this.f25192f.setCyclic(z11);
        this.f25193g.setCyclic(z11);
    }

    public final void t() {
        this.f25190d.setDividerColor(this.f25206t);
        this.f25189c.setDividerColor(this.f25206t);
        this.f25188b.setDividerColor(this.f25206t);
        this.f25191e.setDividerColor(this.f25206t);
        this.f25192f.setDividerColor(this.f25206t);
        this.f25193g.setDividerColor(this.f25206t);
    }

    public void u(int i11) {
        this.f25206t = i11;
        t();
    }

    public final void v() {
        this.f25190d.setDividerType(this.f25208v);
        this.f25189c.setDividerType(this.f25208v);
        this.f25188b.setDividerType(this.f25208v);
        this.f25191e.setDividerType(this.f25208v);
        this.f25192f.setDividerType(this.f25208v);
        this.f25193g.setDividerType(this.f25208v);
    }

    public void w(WheelView.DividerType dividerType) {
        this.f25208v = dividerType;
        v();
    }

    public void x(int i11) {
        this.f25197k = i11;
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.f25209w) {
            return;
        }
        if (str != null) {
            this.f25188b.setLabel(str);
        } else {
            this.f25188b.setLabel(this.f25187a.getContext().getString(R$string.pickerview_year));
        }
        if (str2 != null) {
            this.f25189c.setLabel(str2);
        } else {
            this.f25189c.setLabel(this.f25187a.getContext().getString(R$string.pickerview_month));
        }
        if (str3 != null) {
            this.f25190d.setLabel(str3);
        } else {
            this.f25190d.setLabel(this.f25187a.getContext().getString(R$string.pickerview_day));
        }
        if (str4 != null) {
            this.f25191e.setLabel(str4);
        } else {
            this.f25191e.setLabel(this.f25187a.getContext().getString(R$string.pickerview_hours));
        }
        if (str5 != null) {
            this.f25192f.setLabel(str5);
        } else {
            this.f25192f.setLabel(this.f25187a.getContext().getString(R$string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f25193g.setLabel(str6);
        } else {
            this.f25193g.setLabel(this.f25187a.getContext().getString(R$string.pickerview_seconds));
        }
    }

    public final void z() {
        this.f25190d.setLineSpacingMultiplier(this.f25207u);
        this.f25189c.setLineSpacingMultiplier(this.f25207u);
        this.f25188b.setLineSpacingMultiplier(this.f25207u);
        this.f25191e.setLineSpacingMultiplier(this.f25207u);
        this.f25192f.setLineSpacingMultiplier(this.f25207u);
        this.f25193g.setLineSpacingMultiplier(this.f25207u);
    }
}
