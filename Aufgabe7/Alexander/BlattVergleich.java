import java.util.Comparator;

public class BlattVergleich implements Comparator<Blatt> {

	@Override
	public int compare(Blatt b1, Blatt b2) {
		int[][] cards = { b1.getCards(), b2.getCards() };
		int[][] points = countCards(cards);

		int retval = 0;
		int[] highCard = find(points,1);
		
		for(int i =3; i>=1;i--){
			int[] has = find(points,i);
			retval = compare(has); 
			if(retval == 0 && has[0] != -1){
				return compare(highCard);
			}else if (retval != 0){
				return retval;
			}else{
				continue;
			}
		}
		
		
		return retval;
	}
	
	private int compare(int[] compare){
		return Integer.compare(compare[0],compare[1]); 
	}
	
	private int[] find(int[][] points, int count){
		int[] retval = {-1,-1};
		for(int i = 0; i<retval.length;i++){
			for(int x = 0; x<points[i].length;x++){
				if(points[i][x]==count){
					retval[i] = x;
				}
			}
		}
		
		return retval;
	}

	private int[][] countCards(int[][] cards) {
		int[][] retval = new int[cards[0].length][14];
		for (int i = 0; i<cards.length;i ++) {
			for(int card : cards[i]){
				retval[i][card-1] ++;
			}
		}
		return retval;
	}
}