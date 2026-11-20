package com.transsion.json;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f52976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f52977b = "(\\p{Digit}+)";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f52978c = "(\\p{XDigit}+)";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f52979d = "[eE][+-]?(\\p{Digit}+)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f52980e = "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

    public n(String str) {
        this.f52976a = str;
    }

    private boolean f() {
        return this.f52976a.startsWith("0x");
    }

    private boolean g() {
        return this.f52976a.length() > 1 && this.f52976a.charAt(0) == '0' && Character.isDigit(this.f52976a.charAt(1));
    }

    public boolean a() {
        return this.f52976a.matches("\\-?\\d+");
    }

    public Double b() {
        return Double.valueOf(Double.parseDouble(this.f52976a));
    }

    public Float c() {
        return Float.valueOf(Float.parseFloat(this.f52976a));
    }

    public Integer d() {
        if (f()) {
            return Integer.valueOf(Integer.parseInt(this.f52976a.substring(2), 16));
        }
        return g() ? Integer.valueOf(Integer.parseInt(this.f52976a.substring(1), 8)) : Integer.valueOf(Integer.parseInt(this.f52976a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b().doubleValue();
    }

    public Long e() {
        if (f()) {
            return Long.valueOf(Long.parseLong(this.f52976a.substring(2), 16));
        }
        return g() ? Long.valueOf(Long.parseLong(this.f52976a.substring(1), 8)) : Long.valueOf(Long.parseLong(this.f52976a));
    }

    @Override // java.lang.Number
    public float floatValue() {
        return c().floatValue();
    }

    @Override // java.lang.Number
    public int intValue() {
        return d().intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return e().longValue();
    }
}
