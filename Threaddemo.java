
public class Threaddemo {

	public static void main(String[] args) {
		PrimeThread thread = new PrimeThread();
		thread.start();// TODO Auto-generated method stub
        
	}

}
class PrimeThread extends Thread{
	public void run() {
		for(int i=2;i<=100;i++) {
			int c=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0)
					c++;
			}
			if(c==2)
				System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
