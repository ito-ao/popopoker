package Poker;
import java.util.Collections;
import java.util.LinkedList;

import Poker.Card.Suit;


public class Deck {

	public static final int SUM_WITHOUT_JOKER = 52;//ジョーカー以外のトランプの数
	public static final int MAX_TRUMP_NUM =13; //１つのスートのカードの最大枚数
	public static final int SUIT_NUM = 4; //スート数

	private LinkedList<Card> cards;

	public Deck(int jokers) {

		if(jokers<0) {
			throw new IllegalArgumentException("引数[" + jokers + "]が不正");//不正,不適切、引数なメソッドに渡したことを示すためにスローされる
		}

		//なぜリンクでやるか 手札と山札のことを考えるとAraayよりか効率的と考えたため。
		//手札に加わるということは山札からそのカードは消えるので最低十枚は消えることになる
		//なおかつ手札を捨てるとなると合計最大二十枚消えることになるためリンクのほうが効率的であると思いました。
		cards =	new LinkedList<Card>();
		Suit[] suit = Suit.values();
		for(int i =0; i<SUIT_NUM;i++) {
			for(int j =1; j <=MAX_TRUMP_NUM ; j++ ) {
				cards.add(new Card(suit[i],j));
			}
		}

		for(int i =0; i < jokers; i++) {
			cards.add(new Card(Suit.JOKER, 0));
		}

		Collections.shuffle(cards);

	}

	public void printDeck() {
		for (Card c:cards) {

		}
	}
}
