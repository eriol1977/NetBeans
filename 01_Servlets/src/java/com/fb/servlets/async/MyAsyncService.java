/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.servlets.async;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;

/**
 *
 * @author Francesco
 */
public class MyAsyncService implements Runnable {

    AsyncContext ac;

    public MyAsyncService(AsyncContext ac) {
        this.ac = ac;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            ac.complete();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyAsyncService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
