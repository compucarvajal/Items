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
public class DAOException extends Exception{

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
