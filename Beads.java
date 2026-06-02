import java.util.*;

class Solution {
    static class Bead {
        int r, c;
        int dr, dc;

        Bead(int r, int c, int dr, int dc) {
            this.r = r;
            this.c = c;
            this.dr = dr;
            this.dc = dc;
        }
    }

    public int countRemainingBeads(int R, int C, int sr, int sc, int S) {
        int[][] dirs = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}
        };

        List<Bead> beads = new ArrayList<>();

        for (int[] d : dirs) {
            beads.add(new Bead(sr + d[0], sc + d[1], d[0], d[1]));
        }

        for (int step = 0; step < S; step++) {
            Map<String, Integer> cnt = new HashMap<>();

            for (Bead b : beads) {
                int nr = b.r + b.dr;
                int nc = b.c + b.dc;

                boolean outR = nr < 0 || nr >= R;
                boolean outC = nc < 0 || nc >= C;

                if (outR || outC) {
                    if (outR) b.dr = -b.dr;
                    if (outC) b.dc = -b.dc;

                    nr = b.r + b.dr;
                    nc = b.c + b.dc;
                }

                b.r = nr;
                b.c = nc;

                String key = b.r + "," + b.c;
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            }

            List<Bead> next = new ArrayList<>();

            for (Bead b : beads) {
                String key = b.r + "," + b.c;

                if (cnt.get(key) == 1) {
                    next.add(b);
                }
            }

            beads = next;
        }

        return beads.size();
    }
}