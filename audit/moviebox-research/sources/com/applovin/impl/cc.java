package com.applovin.impl;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f18173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f18174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f18175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f18176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private dc f18177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18178f;

    public int a() {
        return this.f18178f;
    }

    public void a(int i11) {
        this.f18178f = i11;
    }

    public void a(dc dcVar) {
        this.f18177e = dcVar;
        this.f18173a.setText(dcVar.k());
        this.f18173a.setTextColor(dcVar.l());
        if (this.f18174b != null) {
            if (TextUtils.isEmpty(dcVar.f())) {
                this.f18174b.setVisibility(8);
            } else {
                this.f18174b.setTypeface(null, 0);
                this.f18174b.setVisibility(0);
                this.f18174b.setText(dcVar.f());
                this.f18174b.setTextColor(dcVar.g());
                if (dcVar.p()) {
                    this.f18174b.setTypeface(null, 1);
                }
            }
        }
        if (this.f18175c != null) {
            if (dcVar.h() > 0) {
                this.f18175c.setImageResource(dcVar.h());
                this.f18175c.setColorFilter(dcVar.i());
                this.f18175c.setVisibility(0);
            } else {
                this.f18175c.setVisibility(8);
            }
        }
        if (this.f18176d != null) {
            if (dcVar.d() <= 0) {
                this.f18176d.setVisibility(8);
                return;
            }
            this.f18176d.setImageResource(dcVar.d());
            this.f18176d.setColorFilter(dcVar.e());
            this.f18176d.setVisibility(0);
        }
    }

    public dc b() {
        return this.f18177e;
    }
}
