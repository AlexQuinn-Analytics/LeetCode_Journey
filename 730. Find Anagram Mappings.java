   static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>>mapA=new HashMap<>();
        Map<Integer, List<Integer>>mapB=new HashMap<>();
        int n=A.length;
        for (int i=0;i<n;i++){
            if (!mapA.containsKey(A[i])){
                mapA.put(A[i], new ArrayList<>());
            }
            if (!mapB.containsKey(B[i])){
                mapB.put(B[i], new ArrayList<>());
            }
            mapA.get(A[i]).add(i);
            mapB.get(B[i]).add(i);
        }
        int[]res=new int[n];
        for (int i=0;i<n;i++){
            int idxA=mapA.get(A[i]).remove(0);
            int idxB=mapB.get(A[i]).remove(0);
            res[idxA]=idxB;
        }
        return res;
    }