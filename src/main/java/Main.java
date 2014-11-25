import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream is = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(outputStream);
        new Task().solve(in, out);
        out.close();
    }
}

class Task {

    public void solve(InputReader in, PrintWriter out) {
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextInt();
        }
        int ans = Math.max(Math.max(a[0] + a[1] + a[2], (a[0] + a[1]) * a[2]), Math.max(a[0] * (a[1] + a[2]), a[0] * a[1] * a[2]));
        out.println(ans);
    }

}

class InputReader {
    public BufferedReader reader;

    public StringTokenizer tokenizer;

    public InputReader(InputStream is) {
        reader = new BufferedReader(new InputStreamReader(is));
        tokenizer = null;
    }

    public void getToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean hasNext() {
        try {
            getToken();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String next() {
        getToken();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

}