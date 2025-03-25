package com.ivoyant.week3.multithreading;

public class DeadlockCreation {
    public static void main(String[] args) {
        //in below case thread1 by acquiring lock1 waiting for lock2 which is acquired by thread2
        //thread2 by acquiring lock2 waiting for lock1 which is acquired by thread1
        //circular wait => deadlock
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
                synchronized(lock2){
                    System.out.println("lock2 is acquired by: "+Thread.currentThread());
                    try{Thread.sleep(1);}
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    synchronized(lock1){
                        System.out.println("lock1 is acquired by: "+Thread.currentThread());
                    }

                }

            }
        },"thread2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
    }

