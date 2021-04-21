package com.luck.picture.lib.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/**
 * 根据资源的名字获取其ID值
 *
 * @author janecer
 */
public class MResource {
    public static int[] getIdsByName(Context context, String className, String name) {
        String packageName = context.getPackageName();
        Class r = null;
        int[] ids = null;
        try {
            r = Class.forName(packageName + ".R");

            Class[] classes = r.getClasses();
            Class desireClass = null;

            for (int i = 0; i < classes.length; ++i) {
                if (classes[i].getName().split("\\$")[1].equals(className)) {
                    desireClass = classes[i];
                    break;
                }
            }

            if ((desireClass != null)
                    && (desireClass.getField(name).get(desireClass) != null)
                    && (desireClass.getField(name).get(desireClass).getClass()
                    .isArray()))
                ids = (int[]) desireClass.getField(name).get(desireClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return ids;
    }

    /**
     * 使用Resources 类的 getIdentifier方法
     * @param context
     * @param type
     * @param name
     * @return
     */
    public static int getIdentifier(Context context, String type, String name) {
        int id = 0;
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(type)) {
            return id;
        }
        String packName = context.getPackageName();
        try {
            Resources resource = context.getResources();
            if (resource != null) {
                id = resource.getIdentifier(name, type, packName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public static int getLayoutID(Context context, String name) {
        return MResource.getIdentifier(context, "layout", name);
    }

    public static int getColorID(Context context, String name) {
        return MResource.getIdentifier(context,"color", name);
    }
    public static int getColorInt(Context context, String name) {
        if (context==null){
            return 0;
        }
        int color_id = getColorID(context, name);
        int colorInt = context.getResources().getColor(color_id);
        return colorInt;
    }


}

