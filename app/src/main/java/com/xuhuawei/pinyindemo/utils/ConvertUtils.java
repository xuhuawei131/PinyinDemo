package com.xuhuawei.pinyindemo.utils;

import android.content.Context;

public class ConvertUtils {
    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
