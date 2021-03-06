package sortProcessor;
import timeProcessor.TimeCheck;
//第三代罗瑶光小高峰平均高峰过滤快排思想设计中。小高峰高峰过滤快速排序
//同频函数减少
//同频算子减少
//同频变量减少
@SuppressWarnings("unused")
public class Quick_Luoyaoguang_4D{
	public int[] sort(int[] a) {
		quick2ds(a, 0, a.length-1);
		return a;
	}

	private void quick2ds(int[] a, int lp, int rp) {
		if(lp< rp){
			int c = rp - lp; if(c < 7){ int j;
			for(int i = 1 + lp; i <= lp + c; i++){
				j = i;while(j>=1+lp){
					if(a[j]<a[j-1]){
						int temp=a[j];a[j]=a[j-1];a[j-1]=temp;
					}
					j--;
				}
			}	
			return;
			}
			int pos = partition(a, lp, rp);
			quick2ds(a, lp, pos-1);
			quick2ds(a, pos+1, rp);
		}
	}

	private int partition(int[] a, int lp, int rp) {
		int x= a[lp]>= a[rp]? a[rp]: a[lp];
		int lp1= lp;
		while(lp1< rp){//我总觉得这里可以进行一种积分算法优化，我一直在思考，别让那么快想到。
//			while(a[lp1]<= x&& lp1< rp) {
//				lp1++;
//			}
			while(!(a[lp1]>x|| lp1>= rp)) {
				lp1++;
			} //今天想到了一些优化，
			while(a[rp]>x){
				rp--;
			}
			if(lp1<rp){
				int temp=a[rp];a[rp]=a[lp1];a[lp1]=temp;
			}
		}
		a[lp]=a[rp];a[rp]=x;
		return rp;
	}
	
	public String[][] sort(String[][] a) {
		quick2dsString(a, 0, a.length-1);
		return a;
	}

	private void quick2dsString(String[][] a, int lp, int rp) {
		if(lp < rp){
			int c = rp - lp; if(c < 7){ int j;
			for(int i = 1 + lp; i <= lp + c; i++){
				j = i;while(j>=1+lp){
					if(Double.valueOf(a[j][1])<Double.valueOf(a[j-1][1])){
						String []temp=a[j];
						a[j]=a[j-1];
						a[j-1]=temp;
					}
					j--;
				}
			}	
			return;
			}
			int pos= partitionString(a, lp, rp);
			quick2dsString(a, lp, pos- 1);
			quick2dsString(a, pos+ 1, rp);
		}
	}

	private int partitionString(String[][] a, int lp, int rp) {
		String[] x= a[lp]; 
		int lp1= lp;
		if(Double.valueOf(x[1])>= Double.valueOf(a[rp][1])){
			x= a[rp];
		}
		while(lp1< rp){
			while((Double.valueOf(a[lp1][1])<= Double.valueOf(x[1]))&& (lp1< rp)){
				lp1 ++;
			} 
			while(Double.valueOf(a[rp][1])> Double.valueOf(x[1])){
				rp --;
			}
			if(lp1<rp){
				String[] temp= a[rp].clone();
				a[rp]= a[lp1].clone();
				a[lp1]= temp.clone();
			}
		}
		a[lp]=a[rp].clone();a[rp]=x;
		return rp;
	}
}
