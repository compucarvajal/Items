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
public class BOException extends Exception {

    public BOException(String message) {
        super(message);
    }

    public BOException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
