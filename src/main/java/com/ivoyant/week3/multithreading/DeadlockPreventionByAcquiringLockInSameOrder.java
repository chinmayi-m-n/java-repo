package com.ivoyant.week3.multithreading;

public class DeadlockPreventionByAcquiringLockInSameOrder {
    public static void main(String[] args) {
        //both threads should follow common lock acquisition order for acquiring locks
        //that is lock1 followed by lock2
        //thread1 acquires lock1 and go to sleep state by holding lock1
        //thread2 tries to acquire lock1 as it is already acquired by thread1 , thread2 gets blocked
        //thread1 then acquire lock2 , after completion of its execution it releases lock1 and lock2
        //then thread2 executes
        String lock1="lock1",lock2="lock2";
        Thread t1=new Thread(
                new Runnable(){
                    public void run(){

                        synchronized(lock1){
                            System.out.println("lock1 is acquired by: "+Thread.currentThread());
                            //making thread1 to sleep so that thread2 can acquire lock2
                            try{Thread.sleep(1000);}
                            catch(Exception e){
                                e.printStackTrace();
                            }
                            synchronized(lock2){
                                System.out.println("lock2 is acquired by: "+Thread.currentThread());
                            }
                        }

                    }
                },"thread1");
        Thread t2=new Thread(new Runnable(){
            public void run(){
                synchronized(lock1){
                    System.out.println("lock1 is acquired by: "+Thread.currentThread());
                    try{Thread.sleep(1);}
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    synchronized(lock2){
                        System.out.println("lock2 is acquired by: "+Thread.currentThread());
                    }

                }

            }
        },"thread2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
