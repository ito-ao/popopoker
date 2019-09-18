package poker;

public class Card implements Comparable<Card>{

	enum Suit{
		CLUB,
		DIAMOND,
		HEART,
		SPADE,
		JOKER
	};
	private static final String[] toStr = {"クラブ", "ダイヤ", "ハート", "スペード", "ジョーカー"};
	private Suit suit;	// スート
	private int num;	// トランプのナンバー
	private String str;

	public Card (Suit suit,int num) {
		this.suit =suit;
		this.num = num;
		this.str = toStr[suit.ordinal()];
		if(suit != Suit.JOKER){
			this.str += "の" + num;
		}
	}

	@Override
	public int compareTo(Card o) {
		int slf = this.suit.ordinal();
		int obj = o.suit.ordinal();
		return slf == obj ? this.num - o.num : slf - obj;
	}

	@Override
	public String toString(){
		return str;
	}

	public Suit getSuit(){
		return suit;
	}

	public int getNum(){
		return num;
	}

}



