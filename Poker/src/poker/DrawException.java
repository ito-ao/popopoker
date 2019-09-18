package poker;

public class DrawException extends Exception{

	private static final long seriakVersionUID = 1L;//同一クラスかを判定する

	public DrawException(String str) {
		super("too large!:"+str);
	}
}
