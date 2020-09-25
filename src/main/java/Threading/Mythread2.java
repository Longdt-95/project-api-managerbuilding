/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threading;

/**
 *
 * @author Admin
 */
public class Mythread2 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "=" + i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
