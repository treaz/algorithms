package ro.horia.misc;

public class FiboCalc implements Runnable {

	int n;
	int result;
	@Override
	public void run() {
		if (n<=1) {
			result=n;
		} else {
			FiboCalc f =new FiboCalc();
			f.n=n-1;
			new Thread(f).start();
			int x = f.result;
			
			FiboCalc f2 =new FiboCalc();
			f2.n=n-2;
			new Thread(f2).start();
			int y = f2.result;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result=x+y;
		}
		
	}

}
