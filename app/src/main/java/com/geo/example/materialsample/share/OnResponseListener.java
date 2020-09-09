package com.geo.example.materialsample.share;

public interface OnResponseListener {
    void onSuccess();

    void onCancel();

    void onFail(String message);
}
