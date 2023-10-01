class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char x: tasks) hm.put(x, hm.getOrDefault(x,0)+1);


        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->b[1]-a[1]);

        for(char x: hm.keySet()) {
            pq.add(new int[]{(int)x, hm.get(x)});
        }

        int ans = 0;

        while(pq.size()>0) {

            Stack<int[]> st = new Stack<>();
            int currSize = pq.size();

            for(int i=0;i<Math.min(n+1, currSize);i++) {
                int[] curr = pq.remove();
                curr[1]--;
                if(curr[1]!=0)
                    st.push(curr);
            }
            
            while(!st.empty()) {
                pq.add(st.pop());
            }
            
            if(pq.size()!=0)
                ans += n+1;
            else 
                ans += currSize;

        }


        return ans;



    }
}