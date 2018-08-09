/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.util;

/**
 *
 * @author luis.carvajal
 */
public final class UtilSingleton {

    private static Util util;

    private UtilSingleton() {
        util = new Util();
    }

    public static Util getUtil() {
        if (null == util) {
            util = new Util();
        }
        return util;
    }

}
