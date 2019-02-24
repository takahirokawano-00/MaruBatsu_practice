import java.util.Scanner;

public class MaruBatsu {
	public static void main(String[] args) {
		int size = 3;
		int[][] box = new int[size][size];

		for(int x=0; x<size; x++) {
			for(int y=0; y<size; y++) {
				box[x][y]=0;
			}
		}
//size*sizeの座標を作り、各マスに0（空欄）を代入

		String[] mark = {"", "O", "X"};
		Scanner sc = new Scanner(System.in);

		for(int turn=0; turn<size*size; turn++) {
			int player = turn%2+1;
			System.out.println("Player"+player+"の番です");

			int putX,putY;
			do {
				System.out.println("X座標の値を入力して下さい");
				putX = sc.nextInt();
				System.out.println("Y座標の値を入力して下さい");
				putY = sc.nextInt();
			}while(putX<0 || putY<0 || putX>=size || putY>=size || box[putX][putY]!=0);
				box[putX][putY] = player;
//"入力できない条件"に当てはまらない場合は、指定のマスにplayer(1か2 ※OかX)を代入
			for(int x=0; x<size; x++) {
				String border = "|";
				for(int y=0; y<size; y++) {
					border+=mark[box[putX][putY]]+"|";
				}
				System.out.println(border);
			}
			int tmp = 0;
			for(int x=0; x<size; x++) {
				if(box[x][putY]==player)tmp++;
			}
			if(tmp==size)win(player);
//縦のtmp数を調べる
			tmp = 0;
			for(int y=0; y<size; y++) {
				if(box[putX][y]==player)tmp++;
			}
			if(tmp==size)win(player);
//横のtmp数を調べる
			tmp = 0;
			for(int x=0; x<size; x++) {
				if(box[x][x]==player)tmp++;
			}
//box[0][0]からbox[2][2]にかけての斜めを調べる
			tmp = 0;
			for(int x=0; x<size; x++) {
				if(box[x][size-1-x]==player)tmp++;
			}
//box[2][0]からbox[0][2]にかけての斜めを調べる
		if(tmp==size)win(player);
		}
		System.out.println("引き分けです");
	}
	public static void win(int player) {
		System.out.println("Player"+player+"の勝ちです");
		System.exit(0);
	}
}
