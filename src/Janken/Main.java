package Janken;

import java.util.Scanner;

/*
 * テスト
 * 1.
 * 4 7
 * CGPC
 * 4
 * 
 * 2.
 * 5 10
 * GPCPC
 * 3
 */

public class Main {
	static int n, m; // じゃんけんの回数, 出した指の本数の合計
	static int[] a; // n回目で出した手の指の本数を格納する配列
	static String s; // 相手が出す手
	static int maxWinCount = 0, ownWinCount; // 勝った最高回数, 勝った回数

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		n = Integer.valueOf(input[0]);
		m = Integer.valueOf(input[1]);
		a = new int[n]; // 配列をnの長さで定義
		s = scanner.nextLine();
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				for (int k = 0; k < 3; k++) {
//					for (int l = 0; l < input.length; l++) {
//						a[0] = fingerCount(i);
//						a[1] = fingerCount(j);
//						a[2] = fingerCount(k);
//						a[3] = fingerCount(l);
//						if (a[0] + a[1] + a[2] + a[3] == m) {
//							ownWinCount = countWin();
//							maxWinCount = maxWinCount < ownWinCount ? ownWinCount : maxWinCount;
//						}
//					}
//				}
//			}
//		}
		// 上記を再帰関数にて書き換え
		Janken(n, 0, 0);
		System.out.println(maxWinCount);
	}

	// 
	/**
	 * 相手の手と比較して何回勝ったか返す
	 * @return 勝った回数
	 */
	static int countWin() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (ownWinOrLoss(a[i], s.charAt(i)))
				count++;
		}
		return count;
	}

	/**
	 * 勝敗判定
	 * @param ownFingerCount 自分の手の指の本数
	 * @param opponentChar 相手の手の文字
	 * @return 勝ち:true 負け:false
	 */
	static boolean ownWinOrLoss(int ownFingerCount, char opponentChar) {
		switch (ownFingerCount) {
		case 0:
			// 自分がグーのとき相手がチョキなら勝ち
			return opponentChar == 'C' ? true : false;
		case 2:
			// 自分がチョキのとき相手がパーなら勝ち
			return opponentChar == 'P' ? true : false;
		case 5:
			// 自分がパーのとき相手がグーなら勝ち
			return opponentChar == 'G' ? true : false;
		}
		return false;
	}

	/**
	 * じゃんけんの手に対応した指の本数を返す
	 * @param i じゃんけんの手(0:グー, 1:チョキ, 2:パー)
	 * @return 指の本数
	 */
	static int fingerCount(int i) {
		switch (i) {
		case 0:
			return 0;
		case 1:
			return 2;
		case 2:
			return 5;
		}
		return 0;
	}

	/**
	 * 再帰
	 * @param n じゃんけんの回数
	 * @param cnt じゃんけんの回数を数える
	 * @param fingerCount 指の本数
	 */
	static void Janken(int n, int cnt, int fingerCount) {
		if (n == cnt) {
			int sumFingerCount = 0;
			for (int i = 0; i < n; i++)
				sumFingerCount += a[i];

			if (sumFingerCount == m) {
				ownWinCount = countWin();
				// 勝った回数が最高を超えたら更新
				maxWinCount = maxWinCount < ownWinCount ? ownWinCount : maxWinCount;
			}
			return;
		}
		Janken(n, cnt + 1, a[cnt] = fingerCount(0)); // グー
		Janken(n, cnt + 1, a[cnt] = fingerCount(1)); // チョキ
		Janken(n, cnt + 1, a[cnt] = fingerCount(2)); // パー
	}
}
