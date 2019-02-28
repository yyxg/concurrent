package com.xiangxue.ch1.safeend;

/**
 *
 *
 *类说明：如何安全的中断线程
 */
public class EndThread {
	
	private static class UseThread extends Thread{
		
		public UseThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			//interrupt 之前 中断状态是false 子线程 打印 is run
			//当调用子线程的interrupt 方法 将线程的中断标志位置为true
			System.out.println(threadName+" interrput flag is "+isInterrupted());//false
			while(!isInterrupted()) {
				System.out.println(threadName+" is run!");
			}
			System.out.println(threadName+" interrput flag is "+isInterrupted());//true

		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("endThread");
		endThread.start();
		Thread.sleep(20);//主线程休眠20毫秒的时候 子线程在run
		endThread.interrupt();//主线程 不会主动中断子线程 只是跟这个线程打个招呼，将线程的中断标志位置为true，线程是否中断，由线程本身决定。

	}

}
