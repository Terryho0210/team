import java.util.ArrayList;


public class KeywordList {
	
	protected ArrayList<Result> lst;

	public KeywordList(){
		this.lst = new ArrayList<Result>();
    }
	
	public ArrayList<Result> getList(){
		return this.lst;
	}
	
	public void add(Result result){
		lst.add(result);
    }
	
	private void quickSort(int L, int R){
		
		if (L < R) {
			int swapIndex = (L-1);
			for (int x = L; x <= R - 1; x++){
				if (lst.get(x).nodeScore < lst.get(R).nodeScore) {
					swapIndex += 1;
					swap(swapIndex, x);
				}
			}
			swap((swapIndex+1), R);
			quickSort(L, swapIndex);
			quickSort(swapIndex + 2, R);
		}
	}
	
	
	
	public void sort(){
		if(lst.size() == 0)
		{
			System.out.println("Invalid");
		}
		else 
		{
			quickSort(0, lst.size()-1);
		}
	}
	
	private void swap(int a, int b){
		Result tmp = lst.get(a);
		lst.set(a, lst.get(b));
		lst.set(b, tmp);
	}
	
	public void show(){
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < lst.size() ; i++){
			Result result = lst.get(i);
			if(i > 0) sb.append(" ");
			
			sb.append(result.toString());
		}
		
		System.out.println(sb.toString());	
	}
	
}
