package poker;
import java.util.Collections;
import java.util.LinkedList;

import poker.Card.Suit;



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
		//なおかつ手札を捨てるとなると合計最大二十枚消えることになるためリンクのほうが効率的である(たぶん)。
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
			System.out.printf("(%s, %d)\n", c.getSuit().name(), c.getNum());

		}
	}

	public int getRestCardsNum() {
		return cards.size();

	}
	/**
	 *@param n
	 *@throws DrawException
	 * */

	public Card[]draw(int n)throws DrawException{

		if(getRestCardsNum()<n)throw new DrawException("山札にカードない");

		Card[] res = new Card[n];

		for(int i = 0; i < n; i++){
			res[i] = cards.poll();
		}

		return res;
	}
	/**
	@throws DrawException
	**/
	public Card draw()throws DrawException{
		return draw(1)[0];
	}
	/**
	 * @return
	 */
	public int countJokers() {
		int jSum=0;
		for(Card c:cards) {
			if(c.getSuit()==Suit.JOKER) {
				jSum++;
			}
		}
		return jSum;
	}
}

