package basic_6;

public class Deck {
	final int CARD_NUM =52; //카드의 갯수
	Card cardArr[] = new Card[CARD_NUM];// Card 객체 배열 포함 
	Deck() {// Deck 카드 초기화 
		int i=0;
		for(int k=Card.KIND_MAX;k>0;k--) { //SPADE = 1, CLOVER =2, DIAMOND=3 , HEART=4
			for(int n=0;n<Card.NUM_MAX;n++) {
				cardArr[i++] = new Card(k, n+1);
			}
		}
	}
	Card pick(int index) {// 지정된 위치에 있는 카드를 꺼내서 반환 
		return cardArr[index];
	}
	Card pick() {//Deck에서 카드 하나를 선택
		int index= (int)(Math.random() *CARD_NUM);
		return pick(index);
	}
	void shuffle() {//카드의 순서를 섞는다
		for(int i=0;i<cardArr.length;i++) {
			int r=(int)(Math.random()*CARD_NUM);
			Card temp = cardArr[i];
			cardArr[i]= cardArr[r];
			cardArr[r] =temp;
		}
	}
}
