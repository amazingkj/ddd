package codingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce04 { //15650 //중복 없이 M개 고르기, 오름차순
	static int N,M;
	static int[] selected;
	
	static StringBuilder sb =new StringBuilder();
	
	
	static void input() {
		FastReader scan =new FastReader();
		N=scan.nextInt();
		M=scan.nextInt();
		selected = new int[M+1];
		
	}
	
	static void rec_func(int k) {
		if(k==M+1) {
			for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
			sb.append('\n');
		}else {
			int start = selected[k-1];
 			if(start == 0) start=1;
			
			for(int cand = start; cand <=N; cand++) {
				//k번째에 cand가 올 수 있으면
				selected[k] =cand;
				rec_func(k+1);
				selected[k]=0;
				
				
			}
		}
		
	}
	
	//입력속도 빠르게하기위해서 사용 
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
	public static void main(String[] args) {
		input();
		
		rec_func(1);
		System.out.println(sb.toString());
	}
	
	

}
